package aufgabe4_generics;
import aufgabe4_generics.diseases.*;
/**
 * Hospital
 */
public class Hospital {

    public static void main(String[] args) {
        //! 1. Aufgabe
        Patient<Mental> madAdam = new Patient<>();

        madAdam.sicken(new Dementia());

        System.out.println(madAdam.getDisease());
        System.out.println(madAdam);

        /**
         * ! 2. Aufgabe
         * Erklären Sie, warum der Compiler die folgende Anweisung nicht übersetzt:
         * madAdam.sicken(new Fracture());
         * ! Weil Fracture das Interface Pysical implementiert! madAdam aber ein Mental Patient ist!
         */

         
    }
}