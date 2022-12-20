package it.ikbo1120.fitness_club_v1_1.presentation.view;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import it.ikbo1120.fitness_club_v1_1.R;
import it.ikbo1120.fitness_club_v1_1.presentation.viewmodel.AddEventViewModel;

public class AddEventFragment extends Fragment {

    private AddEventViewModel mViewModel;

    public static AddEventFragment newInstance() {
        return new AddEventFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_event, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AddEventViewModel.class);
        // TODO: Use the ViewModel
    }

}