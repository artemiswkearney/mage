package mage.game.command;

import mage.MageInt;
import mage.MageObject;
import mage.ObjectColor;
import mage.abilities.Abilities;
import mage.abilities.Ability;
import mage.abilities.costs.mana.ManaCost;
import mage.abilities.costs.mana.ManaCosts;
import mage.cards.FrameStyle;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.SuperType;
import mage.game.Game;
import mage.game.events.ZoneChangeEvent;
import mage.util.SubTypes;

import java.util.List;
import java.util.UUID;

public class ContraptionDeck extends ExtraDeck {
    public ContraptionDeck(UUID ownerID) {
        super(ownerID, "Contraption Deck");
    }
    public ContraptionDeck(ContraptionDeck contraptionDeck) {
        super(contraptionDeck);
    }
    @Override
    public ContraptionDeck copy() {
        return new ContraptionDeck(this);
    }
    //TODO image?
}
