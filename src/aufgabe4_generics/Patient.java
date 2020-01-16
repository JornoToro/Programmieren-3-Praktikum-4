package aufgabe4_generics;
import aufgabe4_generics.diseases.*;

/**
 * Patient
 */
public class Patient<T extends Disease> {
    // Erster Ansatz
 /*    
    private T disease;

    public T sicken(T disease) {
        this.disease = disease;
        return (T) this;
    }

    public T getDisease() {
        return this.disease;
    }
*/
    //! 1. Aufgabe
    private T patient;

    public T sicken(T disease) {
        this.patient = disease;
        return patient;
    }

    public T getDisease() {
        return (T) patient;
    }

    public Patient<T> visit(Doctor<Disease> doctor){


        return null;
    }
}