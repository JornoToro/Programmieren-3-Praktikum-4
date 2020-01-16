package aufgabe4_generics;
import aufgabe4_generics.diseases.*;

/**
 * Patient
 */
public class Patient<T extends Disease> {
    private T disease;

    public void sicken(T disease) {
        this.disease = disease;
        //return (T) this;
    }

    public T getDisease() {
        return this.disease;
    }


}