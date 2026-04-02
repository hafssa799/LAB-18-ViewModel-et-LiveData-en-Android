package projet.fst.ma.viewmodellivedatademoenrichi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ScoreViewModel extends ViewModel {

    // On utilise MutableLiveData pour pouvoir modifier la valeur en interne
    private final MutableLiveData<Integer> count = new MutableLiveData<>();

    public ScoreViewModel() {
        // Initialisation obligatoire pour éviter le NullPointerException au premier clic
        count.setValue(0);
    }

    // On expose en LiveData (lecture seule pour l'Activity)
    public LiveData<Integer> getCount() {
        return count;
    }

    public void incrementer() {
        if (count.getValue() != null) {
            count.setValue(count.getValue() + 1);
        }
    }

    public void decrementer() {
        if (count.getValue() != null) {
            count.setValue(count.getValue() - 1);
        }
    }

    public void reset() {
        count.setValue(0);
    }
}