package mage.abilities.common;

import mage.abilities.TriggeredAbility;
import mage.abilities.TriggeredAbilityImpl;
import mage.abilities.effects.Effect;
import mage.abilities.hint.common.CrankCounterHint;
import mage.constants.Zone;
import mage.game.Game;
import mage.game.events.GameEvent;

public class CrankTriggeredAbility extends TriggeredAbilityImpl {
    protected String text;
    public CrankTriggeredAbility(Effect effect, String text) {
        super(Zone.BATTLEFIELD, effect);
        this.text = text;
        this.addHint(CrankCounterHint.instance);
    }
    public CrankTriggeredAbility(Effect effect) {
        this(effect, null);
    }
    public CrankTriggeredAbility(CrankTriggeredAbility ability) {
        super(ability);
        this.text = ability.text;
    }
    @Override
    public CrankTriggeredAbility copy() {
        return new CrankTriggeredAbility(this);
    }
    @Override
    public boolean checkEventType(GameEvent event, Game game) {
        return event.getType() == GameEvent.EventType.CRANKED_CONTRAPTION;
    }

    @Override
    public boolean checkTrigger(GameEvent event, Game game) {
        if (event.getTargetId().equals(getSourceId())) {
            this.getEffects().setValue("crankedContraption", game.getPermanent(event.getTargetId()));
            return true;
        }
        return false;
    }
    @Override
    public String getRule() {
        if (text == null || text.isEmpty()) {
            return super.getRule();
        }
        return text;
    }

    @Override
    public String getTriggerPhrase() {
        return "Whenever you crank {this}, ";
    }
}
