package projet.fst.ma.viewmodellivedatademoenrichi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CounterViewModel extends ViewModel {
    // Vérifiez que le nom correspond à celui utilisé dans MainActivity
    private final MutableLiveData<Integer> countLiveData = new MutableLiveData<>();

    public CounterViewModel() {
        countLiveData.setValue(0);
    }

    public LiveData<Integer> getCount() {
        return countLiveData;
    }

    public void increment() {
        Integer current = countLiveData.getValue();
        if (current != null) countLiveData.setValue(current + 1);
    }

    public void decrement() {
        Integer current = countLiveData.getValue();
        if (current != null) countLiveData.setValue(current - 1);
    }

    public void reset() {
        countLiveData.setValue(0);
    }
}