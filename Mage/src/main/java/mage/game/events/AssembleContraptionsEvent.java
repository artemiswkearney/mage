package mage.game.events;

import mage.abilities.Ability;

import java.util.UUID;

public class AssembleContraptionsEvent extends GameEvent {
    public AssembleContraptionsEvent(Ability source, UUID controllerId, int amount, boolean assembledBySource) {
        super(
                EventType.ASSEMBLE_CONTRAPTIONS,
                (assembledBySource ? source.getSourceId() : controllerId),
                source,
                controllerId,
                amount,
                false
        );
    }
    public void doubleContraptions() {
        this.setAmount(this.getAmount() * 2);
    }
}
