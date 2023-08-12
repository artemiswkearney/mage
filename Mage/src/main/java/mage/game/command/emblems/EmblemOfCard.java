package mage.game.command.emblems;

import mage.MageObject;
import mage.abilities.AbilityImpl;
import mage.cards.Card;
import mage.cards.decks.DeckCardInfo;
import mage.cards.mock.MockCard;
import mage.cards.repository.CardCriteria;
import mage.cards.repository.CardInfo;
import mage.cards.repository.CardRepository;
import mage.constants.Zone;
import mage.game.command.Emblem;
import mage.util.CardUtil;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public final class EmblemOfCard extends Emblem {
    private boolean usesVariousArt;
    private static final Logger logger = Logger.getLogger(EmblemOfCard.class);
    public static Card lookupCard(
            String cardName,
            String cardNumber,
            String setCode,
            String infoTypeForError
    ) {
        int cardNumberInt = CardUtil.parseCardNumberAsInt(cardNumber);
        List<CardInfo> found = CardRepository.instance.findCards(new CardCriteria()
                .name(cardName)
                .minCardNumber(cardNumberInt)
                .maxCardNumber(cardNumberInt)
                .setCodes(setCode);
        return found.stream()
                .filter(ci -> ci.getCardNumber().equals(cardNumber))
                .findFirst()
                .orElseGet(() -> found.stream()
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("No real card for " + infoTypeForError + " " + cardName)))
                .getCard();
    }
    public static Card cardFromDeckInfo(DeckCardInfo info) {
        return lookupCard(
                info.getCardName(),
                info.getCardNum(),
                info.getSetCode(),
                "DeckCardInfo"
        )
    }
    public EmblemOfCard(Card card, Zone zone) {
        super(card.getName());
        if (card instanceof MockCard) {
            card = lookupCard(
                    card.getName(),
                    card.getCardNumber()
                    card.getExpansionSetCode(),
                    "MockCard"
            );
        }
        this.getAbilities().addAll(card.getAbilities().stream().filter(
                ability -> zone.match(ability.getZone())
        ).map(ability -> {
            if (ability instanceof AbilityImpl && ability.getZone() == zone) {
                return ((AbilityImpl)ability).copyWithZone(Zone.COMMAND);
            }
            return ability;
        }).collect(Collectors.toList()));
        this.getAbilities().setSourceId(this.getId());
        this.setExpansionSetCode(card.getExpansionSetCode());
        this.setCardNumber(card.getCardNumber());
        this.setImageNumber(card.getImageNumber());
        this.usesVariousArt = card.getUsesVariousArt();
    }
    public EmblemOfCard(Card card) {
        this(card, Zone.BATTLEFIELD);
    }

    private EmblemOfCard(EmblemOfCard eoc) {
        super(eoc);
        this.usesVariousArt = eoc.usesVariousArt;
    }
    @Override
    public Emblem copy() {
        return new EmblemOfCard(this);
    }

    @Override
    public void setSourceObject(MageObject sourceObject) {
        try {
            super.setSourceObject(sourceObject);
        }
        catch (IllegalArgumentException e) {
            // happens because this isn't a real emblem, but the source object gets set before throwing so it's fine
        }
    }
    public boolean getUsesVariousArt() {
        return usesVariousArt;
    }
}

