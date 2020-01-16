package aufgabe4_generics;
import aufgabe4_generics.diseases.*;
/**
 * Hospital
 */
public class Hospital {

    public static void main(String[] args) {
        Patient<Mental> madAdam = new Patient<>();

        madAdam.sicken(new Dementia());

        System.out.println(madAdam.getDisease());
    }
}