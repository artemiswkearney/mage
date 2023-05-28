package mage.abilities.hint.common;

import mage.abilities.Ability;
import mage.abilities.hint.Hint;
import mage.game.Game;
import mage.game.permanent.Permanent;

/**
 * @author artemiswkearney
 */
public enum SprocketHint implements Hint {
    instance;

    @Override
    public String getText(Game game, Ability ability) {
        Permanent permanent = ability.getSourcePermanentIfItStillExists(game);
        if (permanent == null) {
            return null;
        }
        return "Sprocket: " + permanent.getSprocket();
    }

    @Override
    public SprocketHint copy() {
        return this;
    }
}