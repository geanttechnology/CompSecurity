// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.fragments.manager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.astuetz.PagerSlidingTabStrip;
import my.googlemusic.play.adapters.manager.library.LibraryPagerAdapter;

public class LibraryFragment extends Fragment
    implements android.support.v4.view.ViewPager.OnPageChangeListener
{

    private ViewHolder mHolder;
    private LibraryPagerAdapter pagerAdapter;

    public LibraryFragment()
    {
    }

    private void initView(View view)
    {
    /* block-local class not found */
    class ViewHolder {}

        mHolder = new ViewHolder(null);
        mHolder.pager = (ViewPager)view.findViewById(0x7f0d023a);
        mHolder.tab = (PagerSlidingTabStrip)view.findViewById(0x7f0d0239);
        pagerAdapter = new LibraryPagerAdapter(getActivity().getSupportFragmentManager());
        mHolder.pager.setAdapter(pagerAdapter);
        mHolder.tab.setViewPager(mHolder.pager);
    }

    public static LibraryFragment newInstance()
    {
        return new LibraryFragment();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030067, viewgroup, false);
        initView(layoutinflater);
        return layoutinflater;
    }

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        mHolder.pager.setCurrentItem(i);
    }
}
