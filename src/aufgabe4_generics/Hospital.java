package aufgabe4_generics;
import aufgabe4_generics.diseases.*;
/**
 * Hospital
 */
@SuppressWarnings("unchecked")
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
         
        /**
         * ! 3.
         */

        Doctor<Physical> drWho = new Doctor<>();
        Doctor<Mental> drFreud = new Doctor<>();
        Doctor<Disease> mediBot = new Doctor<>();
        
        //! 3.d
        //madAdam.visit(drWho);
        //madAdam.visit(drFreud);
        madAdam.visit(mediBot); //--> würde funktionieren wenn man Doctor<Disease> macht

        //! 3.f
        Patient<Lovesickness> susi = new Patient<>();
        drFreud.visitAll(madAdam, susi);

        //! 3.g --> mediBot kann alle heilen
        mediBot.visitAll(madAdam, susi, somePatient);

        /**
         * ! 3.h
         * Warum liefert die folgende Anweisung einen Compilerfehler?
         */
        /* drFreud.visitAll(madAdam, susi,
                     new Patient<Dementia>(),
                     new Patient<Rash>()); 
        */
        //! Weil, drFreund kann nur Mentale und davon geerbte Krankheiten heilen, da Rash aber
        //! eine Pysical Krankheit ist, kann er sie nicht heilen.

    }
}