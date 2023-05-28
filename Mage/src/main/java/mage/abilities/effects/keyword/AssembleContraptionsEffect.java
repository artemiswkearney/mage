package mage.abilities.effects.keyword;

import mage.abilities.Ability;
import mage.abilities.Mode;
import mage.abilities.dynamicvalue.DynamicValue;
import mage.abilities.dynamicvalue.common.StaticValue;
import mage.abilities.effects.Effect;
import mage.abilities.effects.OneShotEffect;
import mage.constants.Outcome;
import mage.game.Game;
import mage.game.events.AssembleContraptionsEvent;
import mage.util.CardUtil;

/**
 * attempting to infer likely rules from "Open an Attraction", except sometimes a source does the assembling
 *
 * 701.48. Open an Attraction
 * 701.48a. A player may open an Attraction only during a game in which that player is playing with an Attraction deck
 * (see rule 717, "Attraction Cards").
 * 701.48b. To open an Attraction, move the top card of your Attraction deck off the Attraction deck, turn it face up,
 * and put it onto the battlefield under your control.
 * 701.48c. An ability which triggers whenever a player opens an Attraction triggers when that player puts an Attraction
 * card onto the battlefield while performing the instruction in the above rule. If an effect prevents that Attraction
 * from entering the battlefield or replaces entering the battlefield with another event, that ability doesn't trigger.
 */
public class AssembleContraptionsEffect extends OneShotEffect {
    private final boolean sourceIsAssembler;
    private final DynamicValue amount;
    private final String selfName;

    public AssembleContraptionsEffect(boolean sourceIsAssembler, String selfName, int amount) {
        this(sourceIsAssembler, selfName, StaticValue.get(amount))
    }
    public AssembleContraptionsEffect(boolean sourceIsAssembler, String selfName, DynamicValue amount) {
        super(Outcome.PutCardInPlay);
        this.sourceIsAssembler = sourceIsAssembler;
        this.selfName = selfName;
        this.amount = amount;
    }
    public AssembleContraptionsEffect(boolean sourceIsAssembler, DynamicValue amount) {
        this(sourceIsAssembler, "{this}", amount);
    }
    public AssembleContraptionsEffect(boolean sourceIsAssembler, int amount) {
        this(sourceIsAssembler, "{this}", amount);
    }
    public AssembleContraptionsEffect(boolean sourceIsAssembler, String selfName) {
        this(sourceIsAssembler, selfName, 1);
    }
    public AssembleContraptionsEffect(boolean sourceIsAssembler) {
        this(sourceIsAssembler, 1);
    }
    public AssembleContraptionsEffect(AssembleContraptionsEffect effect) {
        super(effect);
        this.amount = effect.amount;
        this.sourceIsAssembler = effect.sourceIsAssembler;
        this.selfName = effect.selfName;
    }
    @Override
    public boolean apply(Game game, Ability source) {
        game.getPlayer(source.getSourceId()).assembleContraptions(
                amount.calculate(game, source, this),
                source,
                sourceIsAssembler,
                game
        );
    }

    @Override
    public Effect copy() {
        return new AssembleContraptionsEffect(this);
    }

    @Override
    public String getText(Mode mode) {
        if (staticText != null && !staticText.isEmpty()) {
            return staticText;
        }
        StringBuilder sb = new StringBuilder();
        if (sourceIsAssembler) {
            sb.append(selfName).append(" assembles ");
        }
        else {
            sb.append("assemble ");
        }
        String value = amount.toString();
        sb.append(CardUtil.numberToText(value, "a"));
        sb.append(value.equals("1") ? " Contraption" : " Contraptions");
        String message = amount.getMessage();
        if (!message.isEmpty()) {
            sb.append(value.equals("X") ? ", where X is " : " for each ");
            sb.append(message);
        }
        return sb.toString();
    }
}
