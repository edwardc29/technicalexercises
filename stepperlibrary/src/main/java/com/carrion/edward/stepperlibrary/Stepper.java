package com.carrion.edward.stepperlibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;

import java.util.List;

/**
 * @author Edward Carrion
 * @author https://github.com/edwardc29
 */
public class Stepper extends CoordinatorLayout {
    private TextView title;
    private StepperViewPager pager;
    private StepperPagerAdapter adapter;

    public Stepper(@NonNull Context context) {
        this(context, null);
    }

    public Stepper(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Stepper(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View view = inflate(context, R.layout.layout_stepper, this);

        title = view.findViewById(R.id.title);
        pager = view.findViewById(R.id.pager);
        TextView back = view.findViewById(R.id.tv_back);
        TextView next = view.findViewById(R.id.tv_next);

        back.setOnClickListener(this::onBackClick);
        next.setOnClickListener(this::onNextClick);
    }

    public void onBackClick(View view) {
        pager.setCurrentItem(pager.getCurrentItem() - 1);
        updateTitle(pager.getCurrentItem(), adapter.getCount());
    }

    public void onNextClick(View view) {
        pager.setCurrentItem(pager.getCurrentItem() + 1);
        updateTitle(pager.getCurrentItem(), adapter.getCount());
    }

    public void setPages(List<Fragment> pages) {
        if (getContext() instanceof AppCompatActivity) {
            if (adapter == null) {
                adapter = new StepperPagerAdapter(((AppCompatActivity) getContext()).getSupportFragmentManager(), pages);
            }

            updateTitle(0, adapter.getCount());
            pager.setAdapter(adapter);
        }
    }

    private void updateTitle(int currentStep, int totalPages) {
        title.setText(String.format(getContext().getString(R.string.stepper_header), currentStep + 1, totalPages));
    }
}
