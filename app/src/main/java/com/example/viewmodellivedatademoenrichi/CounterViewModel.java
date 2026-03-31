package com.example.viewmodellivedatademoenrichi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class CounterViewModel extends ViewModel {

    private final SavedStateHandle savedStateHandle;
    private static final String COUNT_KEY = "count";

    public CounterViewModel(SavedStateHandle handle) {
        this.savedStateHandle = handle;
    }

    public LiveData<Integer> getCount() {
        return savedStateHandle.getLiveData(COUNT_KEY, 0);
    }

    public void increment() {
        Integer current = getCount().getValue();
        if (current != null) {
            savedStateHandle.set(COUNT_KEY, current + 1);
        }
    }

    public void decrement() {
        Integer current = getCount().getValue();
        if (current != null) {
            savedStateHandle.set(COUNT_KEY, current - 1);
        }
    }

    public void reset() {
        savedStateHandle.set(COUNT_KEY, 0);
    }

    public void incrementFromBackground() {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                Integer current = getCount().getValue();
                if (current != null) {
                    savedStateHandle.getLiveData(COUNT_KEY).postValue(current + 1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}