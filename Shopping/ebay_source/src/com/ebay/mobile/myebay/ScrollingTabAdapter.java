// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.myebay:
//            EbayFragmentPagerAdapter, ScrollingTabView

public class ScrollingTabAdapter extends EbayFragmentPagerAdapter
{

    public static String EXTRA_POSITION = "TabsAdaptor.position";
    private final Activity activity;
    private final ArrayList fragmentArgs = new ArrayList();
    private final Class fragmentClass;
    private final ScrollingTabView scrollingTabView;
    private final List titles = new ArrayList();

    public ScrollingTabAdapter(Activity activity1, ViewPager viewpager, ScrollingTabView scrollingtabview, Class class1)
    {
        super(activity1.getFragmentManager());
        activity = activity1;
        scrollingTabView = scrollingtabview;
        scrollingTabView.setViewPager(viewpager);
        fragmentClass = class1;
        viewpager.setAdapter(this);
    }

    private void updateFragmentArgPositions(int i)
    {
        for (; i < fragmentArgs.size(); i++)
        {
            ((Bundle)fragmentArgs.get(i)).putInt(EXTRA_POSITION, i);
        }

    }

    public void addOnPageChangeListener(android.support.v4.view.ViewPager.OnPageChangeListener onpagechangelistener)
    {
        scrollingTabView.addOnPageChangeListener(onpagechangelistener);
    }

    public void addTab(View view, Bundle bundle)
    {
        this;
        JVM INSTR monitorenter ;
        Bundle bundle1;
        bundle1 = bundle;
        if (bundle != null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        bundle1 = new Bundle();
        int i = fragmentArgs.size();
        bundle1.putInt(EXTRA_POSITION, i);
        fragmentArgs.add(bundle1);
        scrollingTabView.addTab(view, i);
        this;
        JVM INSTR monitorexit ;
        return;
        view;
        throw view;
    }

    public void addTabAtIndex(View view, Bundle bundle, int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (i < 0) goto _L2; else goto _L1
_L1:
        if (i < fragmentArgs.size()) goto _L3; else goto _L2
_L2:
        (new IndexOutOfBoundsException((new StringBuilder()).append("Index:").append(i).append(", size:").append(fragmentArgs.size()).toString())).printStackTrace();
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        Bundle bundle1;
        bundle1 = bundle;
        if (bundle != null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        bundle1 = new Bundle();
        bundle1.putInt(EXTRA_POSITION, i);
        fragmentArgs.add(i, bundle1);
        updateFragmentArgPositions(i);
        scrollingTabView.addTab(view, i);
        if (true) goto _L5; else goto _L4
_L4:
        view;
        throw view;
    }

    public void clearAllTabs()
    {
        fragmentArgs.clear();
        scrollingTabView.clearAllTabs();
    }

    public int getCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = fragmentArgs.size();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public int getCurrentTab()
    {
        return scrollingTabView.getCurrentPosition();
    }

    public Fragment getItem(int i)
    {
        this;
        JVM INSTR monitorenter ;
        Fragment fragment;
        Object obj = null;
        fragment = obj;
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        fragment = obj;
        if (i < fragmentArgs.size())
        {
            fragment = Fragment.instantiate(activity, fragmentClass.getName(), (Bundle)fragmentArgs.get(i));
        }
        this;
        JVM INSTR monitorexit ;
        return fragment;
        Exception exception;
        exception;
        throw exception;
    }

    public CharSequence getPageTitle(int i)
    {
        return (CharSequence)titles.get(i);
    }

    public View getTabAtIndex(int i)
    {
        return scrollingTabView.getTabAtIndex(i);
    }

    public void removeTabAtIndex(int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (i < 0) goto _L2; else goto _L1
_L1:
        if (i < fragmentArgs.size()) goto _L3; else goto _L2
_L2:
        (new IndexOutOfBoundsException((new StringBuilder()).append("Index:").append(i).append(", size:").append(fragmentArgs.size()).toString())).printStackTrace();
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        fragmentArgs.remove(i);
        updateFragmentArgPositions(i);
        scrollingTabView.removeTabAtIndex(i);
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    public void setOnCurrentTabReselected(ScrollingTabView.OnCurrentTabReselected oncurrenttabreselected)
    {
        scrollingTabView.setOnCurrentTabReselected(oncurrenttabreselected);
    }

    public void setPosition(int i)
    {
        scrollingTabView.setPosition(i);
    }

}
