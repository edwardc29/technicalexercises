package com.carrion.edward.app1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.carrion.edward.app1.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Edward Carrion
 * @author https://github.com/edwardc29
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        List<Fragment> pages = new ArrayList<>();
        pages.add(StepFragment.newInstance("First"));
        pages.add(StepFragment.newInstance("Second"));
        pages.add(StepFragment.newInstance("Third"));

        binding.content.stepper.setPages(pages);
    }
}
