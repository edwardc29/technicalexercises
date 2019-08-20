package com.carrion.edward.stepperlibrary;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * @author Edward Carrion
 * @author https://github.com/edwardc29
 */
public class StepperPagerAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> pages;

    StepperPagerAdapter(FragmentManager fragmentManager, List<Fragment> pages) {
        super(fragmentManager);

        this.pages = pages;
    }

    @Override
    public Fragment getItem(int index) {
        return pages.get(index);
    }

    @Override
    public int getCount() {
        return pages.size();
    }
}
