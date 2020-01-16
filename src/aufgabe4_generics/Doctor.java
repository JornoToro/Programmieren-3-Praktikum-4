package aufgabe4_generics;
import aufgabe4_generics.diseases.*;

/*
** Ein Doktor.
* @param T Krankheit, die dieser Doktor behandeln kann. 
*/
public class Doctor <T extends Disease>{

    void visitAll(Patient<? extends T>... patients){
        
    }
}