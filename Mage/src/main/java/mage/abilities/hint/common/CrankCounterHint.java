package mage.abilities.hint.common;

import mage.abilities.Ability;
import mage.abilities.hint.Hint;
import mage.constants.SubType;
import mage.game.Game;
import mage.game.permanent.Permanent;
import mage.players.Player;

/**
 * @author artemiswkearney
 */
public enum CrankCounterHint implements Hint {
    instance;

    @Override
    public String getText(Game game, Ability ability) {
        Player player = game.getPlayer(ability.getControllerId());
        if (player == null) return "";
        int crankCounter = player.getCrankCounter();
        StringBuilder sb = new StringBuilder();
        if (crankCounter == 0) {
            sb.append(player.getName());
            sb.append(" doesn't have a CRANK! counter yet.");
        }
        else {
            sb.append(player.getName());
            sb.append("'s CRANK! counter is on sprocket ");
            sb.append(crankCounter);
            sb.append(".");
        }
        Permanent permanent = ability.getSourcePermanentIfItStillExists(game);
        if (permanent != null) {
            sb.append(" This ");
            if (permanent.hasSubtype(SubType.CONTRAPTION, game)) {
                sb.append("contraption is on sprocket ");
            }
            else {
                sb.append("permanent is on sprocket ");
            }
            sb.append(permanent.getSprocket());
            sb.append(".");
        }
        return sb.toString();
    }

    @Override
    public CrankCounterHint copy() {
        return this;
    }
}