// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;
import android.widget.TabWidget;
import java.util.ArrayList;

public class TabsAdapter extends FragmentPagerAdapter
    implements android.support.v4.view.ViewPager.OnPageChangeListener, android.widget.TabHost.OnTabChangeListener
{
    static class DummyTabFactory
        implements android.widget.TabHost.TabContentFactory
    {

        private final Context context;

        public View createTabContent(String s)
        {
            s = new View(context);
            s.setMinimumWidth(0);
            s.setMinimumHeight(0);
            return s;
        }

        public DummyTabFactory(Context context1)
        {
            context = context1;
        }
    }

    public static interface OnTabCurrentListener
    {

        public abstract void onTabCurrent(boolean flag);
    }

    public static interface TabsAdapterGetter
    {

        public abstract TabsAdapter getTabsAdaptor();
    }


    public static String EXTRA_POSITION = "TabsAdaptor.position";
    private final Activity activity;
    private final android.widget.TabHost.OnTabChangeListener activityOnTabChangeListener;
    private final ArrayList fragments;
    private final HorizontalScrollView horizontalScrollView;
    private final TabHost tabHost;
    private final ViewPager viewPager;

    public TabsAdapter(Activity activity1, android.widget.TabHost.OnTabChangeListener ontabchangelistener, TabHost tabhost, ViewPager viewpager)
    {
        super(activity1.getFragmentManager());
        fragments = new ArrayList();
        activity = activity1;
        activityOnTabChangeListener = ontabchangelistener;
        tabHost = tabhost;
        viewPager = viewpager;
        viewPager.setAdapter(this);
        horizontalScrollView = (HorizontalScrollView)tabhost.findViewById(0x7f10055c);
    }

    public TabsAdapter(Activity activity1, TabHost tabhost, ViewPager viewpager)
    {
        super(activity1.getFragmentManager());
        fragments = new ArrayList();
        activity = activity1;
        if (activity1 instanceof android.widget.TabHost.OnTabChangeListener)
        {
            activity1 = (android.widget.TabHost.OnTabChangeListener)activity1;
        } else
        {
            activity1 = null;
        }
        activityOnTabChangeListener = activity1;
        tabHost = tabhost;
        viewPager = viewpager;
        viewPager.setAdapter(this);
        horizontalScrollView = (HorizontalScrollView)tabhost.findViewById(0x7f10055c);
    }

    private void doChangeCallbacks()
    {
        String s = tabHost.getCurrentTabTag();
        int j = tabHost.getCurrentTab();
        int k = getCount();
        int i = 0;
        while (i < k) 
        {
            Fragment fragment;
            boolean flag;
            if (j == i)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            fragment = getItem(i);
            if (fragment instanceof OnTabCurrentListener)
            {
                ((OnTabCurrentListener)fragment).onTabCurrent(flag);
            }
            i++;
        }
        if (activityOnTabChangeListener != null)
        {
            activityOnTabChangeListener.onTabChanged(s);
        }
    }

    public void addTab(android.widget.TabHost.TabSpec tabspec, Class class1, Bundle bundle)
    {
        this;
        JVM INSTR monitorenter ;
        tabspec.setContent(new DummyTabFactory(activity));
        Bundle bundle1;
        bundle1 = bundle;
        if (bundle != null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        bundle1 = new Bundle();
        bundle1.putInt(EXTRA_POSITION, fragments.size());
        fragments.add(Fragment.instantiate(activity, class1.getName(), bundle1));
        notifyDataSetChanged();
        tabHost.addTab(tabspec);
        this;
        JVM INSTR monitorexit ;
        return;
        tabspec;
        throw tabspec;
    }

    public void addTab(android.widget.TabHost.TabSpec tabspec, Class class1, Bundle bundle, Fragment fragment, int i)
    {
        this;
        JVM INSTR monitorenter ;
        tabspec.setContent(new DummyTabFactory(activity));
        Bundle bundle1;
        bundle1 = bundle;
        if (bundle != null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        bundle1 = new Bundle();
        bundle1.putInt(EXTRA_POSITION, fragments.size());
        class1 = Fragment.instantiate(activity, class1.getName(), bundle1);
        class1.setTargetFragment(fragment, i);
        fragments.add(class1);
        notifyDataSetChanged();
        tabHost.addTab(tabspec);
        this;
        JVM INSTR monitorexit ;
        return;
        tabspec;
        throw tabspec;
    }

    public void clearAllTabs()
    {
        this;
        JVM INSTR monitorenter ;
        tabHost.setCurrentTab(0);
        tabHost.clearAllTabs();
        fragments.clear();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public int getCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = fragments.size();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public int getCurrentTab()
    {
        return tabHost.getCurrentTab();
    }

    public Fragment getItem(int i)
    {
        this;
        JVM INSTR monitorenter ;
        Fragment fragment = null;
        if (i < fragments.size())
        {
            fragment = (Fragment)fragments.get(i);
        }
        this;
        JVM INSTR monitorexit ;
        return fragment;
        Exception exception;
        exception;
        throw exception;
    }

    public int getItemPosition(Object obj)
    {
        if (!fragments.contains(obj))
        {
            return -2;
        } else
        {
            return super.getItemPosition(obj);
        }
    }

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
label0:
        {
            if (horizontalScrollView != null)
            {
                View view = tabHost.getTabWidget().getChildAt(i);
                if (view == null)
                {
                    break label0;
                }
                j = horizontalScrollView.getWidth();
                i = view.getLeft();
                j = (j - view.getWidth()) / 2;
                horizontalScrollView.smoothScrollTo(i - j, 0);
            }
            return;
        }
        horizontalScrollView.smoothScrollBy(j, 0);
    }

    public void onPageSelected(int i)
    {
        tabHost.setCurrentTab(i);
        doChangeCallbacks();
    }

    public void onTabChanged(String s)
    {
        int i = tabHost.getCurrentTab();
        viewPager.setCurrentItem(i);
    }

    public void setCurrentTab(int i)
    {
        tabHost.setCurrentTab(i);
        viewPager.setCurrentItem(i);
    }

    public void setItem(int i, Fragment fragment)
    {
        this;
        JVM INSTR monitorenter ;
        if (i != fragments.size()) goto _L2; else goto _L1
_L1:
        fragments.add(fragment);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (i < fragments.size())
        {
            fragments.set(i, fragment);
        }
        if (true) goto _L4; else goto _L3
_L3:
        fragment;
        throw fragment;
    }

    public void startListening(int i)
    {
        viewPager.setCurrentItem(i);
        tabHost.setCurrentTab(i);
        viewPager.setOnPageChangeListener(this);
        tabHost.setOnTabChangedListener(this);
        doChangeCallbacks();
    }

}
