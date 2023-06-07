package mage.filter.predicate.mageobject;

import mage.MageObject;
import mage.filter.predicate.Predicate;
import mage.game.Game;
import mage.game.permanent.Permanent;

public class SprocketPredicate implements Predicate<MageObject> {
    private static final SprocketPredicate INSTANCE_1 = new SprocketPredicate(1);
    private static final SprocketPredicate INSTANCE_2 = new SprocketPredicate(2);
    private static final SprocketPredicate INSTANCE_3 = new SprocketPredicate(3);
    public static SprocketPredicate forSprocket(int sprocket) {
        switch (sprocket) {
            case 1: return INSTANCE_1;
            case 2: return INSTANCE_2;
            case 3: return INSTANCE_3;
            default: return new SprocketPredicate(sprocket);
        }
    }
    protected int sprocket;
    public SprocketPredicate(int sprocket) {
        this.sprocket = sprocket;
    }
    @Override
    public boolean apply(MageObject input, Game game) {
        Permanent object = game.getPermanent(input.getId());
        if (object == null) return false;
        return object.getSprocket() == this.sprocket;
    }

    @Override
    public String toString() {
        return "on sprocket " + this.sprocket;
    }
}
