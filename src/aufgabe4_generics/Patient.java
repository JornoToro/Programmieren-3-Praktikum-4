package aufgabe4_generics;
import aufgabe4_generics.diseases.*;

/**
 * Patient
 */
public class Patient<T extends Disease> {
    //! 1. Aufgabe
    private T patient;

    public T sicken(T disease) {
        this.patient = disease;
        return patient;
    }

    public T getDisease() {
        return (T) patient;
    }

    public Patient<T> visit(Doctor<? super T> doctor){


        return null;
    }
}