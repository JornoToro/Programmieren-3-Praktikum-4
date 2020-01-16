package aufgabe4_generics;
import aufgabe4_generics.diseases.*;
/**
 * Hospital
 */
public class Hospital {

    public static void main(String[] args) {
        //! 2. Aufgabe
        Patient<Mental> madAdam = new Patient<>();

        madAdam.sicken(new Dementia());

        System.out.println("2. :" + madAdam.getDisease());
        System.out.println("2. :" + madAdam);

        /**
         * ! 2.c 
         * Erklären Sie, warum der Compiler die folgende Anweisung nicht übersetzt:
         * madAdam.sicken(new Fracture());
         * ! Weil Fracture das Interface Pysical implementiert! madAdam aber ein Mental Patient ist!
         * ! --> TYP Patient<Mental> ist nicht anwendbar auf Fracture(Pysical)
         */
        
        /**
         * ! 2.d 
         * Patient<Disease> somePatient
         * Erklären Sie, warum Sie madAdam trotzdem nicht zuweisen können
         * ! Weil, Compiler: Type mismatch: cannot convert from Patient<Mental> to Patient<Disease>
         */
        // Abänderung auf Mental✔︎
        Patient<Mental> somePatient = new Patient<>();
        somePatient = madAdam;

        /**
         * ! 2.f
         * Fragen Sie somePatient nach seiner Krankheit und geben Sie das Ergebnis aus. 
         * Erklären Sie, warum es nicht Disease lautet, wie der Variablentyp nahelegen würde.
         * ! Weil, bereits ein konkretes Typargument verwendet wurde, (Dementia) wurde gesetzt
         */
        System.out.println("2.f :" + somePatient.getDisease());
         
    }
}