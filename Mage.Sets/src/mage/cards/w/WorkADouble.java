package mage.cards.w;

import java.util.UUID;

import mage.abilities.effects.keyword.AssembleContraptionsEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;

/**
 *
 * @author Arti
 */
public final class WorkADouble extends CardImpl {

    public WorkADouble(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.SORCERY}, "{2}{R}{R}");

        // Assemble two Contraptions.
        this.getSpellAbility().addEffect(new AssembleContraptionsEffect(false, 2));
    }

    private WorkADouble(final WorkADouble card) {
        super(card);
    }

    @Override
    public WorkADouble copy() {
        return new WorkADouble(this);
    }
}
