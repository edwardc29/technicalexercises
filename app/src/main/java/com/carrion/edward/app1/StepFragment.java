package com.carrion.edward.app1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.carrion.edward.app1.databinding.FragmentStepBinding;

/**
 * @author Edward Carrion
 * @author https://github.com/edwardc29
 */
public class StepFragment extends Fragment {

    private static final String VALUE_KEY = "value_key";

    static StepFragment newInstance(String step) {
        StepFragment stepFragment = new StepFragment();
        Bundle args = new Bundle();
        args.putString(VALUE_KEY, step);
        stepFragment.setArguments(args);
        return stepFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentStepBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_step, container, false);

        Bundle args = getArguments();

        if (args != null && args.containsKey(VALUE_KEY)) {
            binding.tvStep.setText(args.getString(VALUE_KEY));
        }

        return binding.getRoot();
    }
}
