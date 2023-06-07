package mage.cards.w;

import java.util.UUID;

import mage.abilities.common.CrankTriggeredAbility;
import mage.abilities.effects.keyword.AssembleContraptionsEffect;
import mage.constants.SubType;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;

/**
 *
 * @author Arti
 */
public final class WidgetContraption extends CardImpl {

    public WidgetContraption(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.ARTIFACT}, "");

        this.subtype.add(SubType.CONTRAPTION);
        this.extraDeckCard = true;

        // Whenever you crank Widget Contraption, it assembles a Contraption.
        this.addAbility(new CrankTriggeredAbility(
                new AssembleContraptionsEffect(true, "it")
        ));
    }

    private WidgetContraption(final WidgetContraption card) {
        super(card);
    }

    @Override
    public WidgetContraption copy() {
        return new WidgetContraption(this);
    }
}
