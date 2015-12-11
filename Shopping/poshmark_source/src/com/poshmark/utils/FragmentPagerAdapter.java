// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.poshmark.ui.fragments.PMFragment;

public abstract class FragmentPagerAdapter extends PagerAdapter
{

    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentPagerAdapter";
    private FragmentTransaction mCurTransaction;
    private PMFragment mCurrentPrimaryItem;
    private final FragmentManager mFragmentManager;

    public FragmentPagerAdapter(FragmentManager fragmentmanager)
    {
        mCurTransaction = null;
        mCurrentPrimaryItem = null;
        mFragmentManager = fragmentmanager;
    }

    private static String makeFragmentName(int i, int j)
    {
        return (new StringBuilder()).append("android:switcher:").append(i).append(":").append(j).toString();
    }

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        if (mCurTransaction == null)
        {
            mCurTransaction = mFragmentManager.beginTransaction();
        }
        mCurTransaction.detach((Fragment)obj);
    }

    public void finishUpdate(ViewGroup viewgroup)
    {
        if (mCurTransaction != null)
        {
            mCurTransaction.commitAllowingStateLoss();
            mFragmentManager.executePendingTransactions();
            mCurTransaction = null;
        }
    }

    public Fragment getCurrentVisibleFragment()
    {
        return mCurrentPrimaryItem;
    }

    public abstract Fragment getItem(int i);

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        if (mCurTransaction == null)
        {
            mCurTransaction = mFragmentManager.beginTransaction();
        }
        Object obj = makeFragmentName(viewgroup.getId(), i);
        obj = (PMFragment)mFragmentManager.findFragmentByTag(((String) (obj)));
        if (obj != null)
        {
            mCurTransaction.attach(((Fragment) (obj)));
            return obj;
        } else
        {
            PMFragment pmfragment = (PMFragment)getItem(i);
            mCurTransaction.add(viewgroup.getId(), pmfragment, makeFragmentName(viewgroup.getId(), i));
            return pmfragment;
        }
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return ((Fragment)obj).getView() == view;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classloader)
    {
    }

    public Parcelable saveState()
    {
        return null;
    }

    public void setPrimaryItem(ViewGroup viewgroup, int i, Object obj)
    {
        viewgroup = (PMFragment)obj;
        if (viewgroup != mCurrentPrimaryItem)
        {
            if (mCurrentPrimaryItem != null)
            {
                mCurrentPrimaryItem.setUserVisibleHint(false);
            }
            if (viewgroup != null && !viewgroup.getUserVisibleHint())
            {
                viewgroup.setUserVisibleHint(true);
            }
            mCurrentPrimaryItem = viewgroup;
        }
    }

    public void startUpdate(ViewGroup viewgroup)
    {
    }
}
