package telran.util;

import java.util.function.Predicate;

public class CharacterRule {
    public boolean flag;
    public Predicate<Character> predicate;
    public String errorMessage;

    public CharacterRule(boolean flag, Predicate<Character> predicate, String errorMessage) {
        this.flag = flag;
        this.predicate = predicate;
        this.errorMessage = errorMessage;
    }

    public CharacterRule(Predicate<Character> predicate, String errorMessage) {
        this.predicate = predicate;
        this.errorMessage = errorMessage;
    }
    

    public Predicate<Character> getPredicate() {

        return this.predicate;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public Boolean getFlag() {
        return this.flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
