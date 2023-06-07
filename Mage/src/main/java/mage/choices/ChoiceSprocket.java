package mage.choices;

public class ChoiceSprocket extends ChoiceImpl {
    public ChoiceSprocket() {
        super(true);
        this.choices.add("1");
        this.choices.add("2");
        this.choices.add("3");
        this.message = "Choose a sprocket";
    }
    public ChoiceSprocket(String chooseFor) {
        this();
        this.message = "Choose a sprocket for " + chooseFor + ".";
    }
    public ChoiceSprocket(String chooseFor, int nextSprocket) {
        this();
        this.message = "Choose a sprocket for " + chooseFor + ". (You will crank sprocket " + nextSprocket + " next.)";
    }
    public ChoiceSprocket(ChoiceSprocket choice) {
        super(choice);
    }
    @Override
    public ChoiceSprocket copy() {
        return new ChoiceSprocket(this);
    }
}
