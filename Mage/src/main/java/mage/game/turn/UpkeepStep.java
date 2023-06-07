

package mage.game.turn;

import mage.constants.PhaseStep;
import mage.game.Game;
import mage.game.events.GameEvent.EventType;
import mage.players.Player;

import java.util.UUID;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class UpkeepStep extends Step {

    public UpkeepStep() {
        super(PhaseStep.UPKEEP, true);
        this.stepEvent = EventType.UPKEEP_STEP;
        this.preStepEvent = EventType.UPKEEP_STEP_PRE;
        this.postStepEvent = EventType.UPKEEP_STEP_POST;
    }

    public UpkeepStep(final UpkeepStep step) {
        super(step);
    }

    @Override
    public UpkeepStep copy() {
        return new UpkeepStep(this);
    }

    @Override
    public void beginStep(Game game, UUID activePlayerId) {
        Player activePlayer = game.getPlayer(activePlayerId);
        activePlayer.advanceCrankCounter(game);
        game.applyEffects();
        super.beginStep(game, activePlayerId);
    }
}
