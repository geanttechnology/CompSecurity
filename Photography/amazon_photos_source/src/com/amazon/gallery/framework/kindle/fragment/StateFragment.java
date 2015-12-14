// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration;
import java.util.LinkedList;
import java.util.List;

public class StateFragment extends Fragment
{

    public static final String TAG = com/amazon/gallery/framework/kindle/fragment/StateFragment.getName();
    private MediaContentConfiguration mContentConfiguration;
    private List mSelectedItems;

    public StateFragment()
    {
    }

    public static StateFragment getAndRegisterInstance(FragmentActivity fragmentactivity)
    {
        FragmentManager fragmentmanager = fragmentactivity.getSupportFragmentManager();
        Fragment fragment = fragmentmanager.findFragmentByTag(TAG);
        fragmentactivity = fragment;
        if (fragment == null)
        {
            fragmentactivity = new StateFragment();
            fragmentmanager.beginTransaction().add(fragmentactivity, TAG).commitAllowingStateLoss();
        }
        return (StateFragment)fragmentactivity;
    }

    public static boolean stateFragmentExists(FragmentActivity fragmentactivity)
    {
        return fragmentactivity.getSupportFragmentManager().findFragmentByTag(TAG) != null;
    }

    public void clearSelectedItems()
    {
        mSelectedItems.clear();
    }

    public MediaContentConfiguration getContentConfiguration()
    {
        return mContentConfiguration;
    }

    public List getSelectedItems()
    {
        return mSelectedItems;
    }

    public boolean hasSelectedItems()
    {
        return !mSelectedItems.isEmpty();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setRetainInstance(true);
        mSelectedItems = new LinkedList();
    }

    public void setContentConfiguration(MediaContentConfiguration mediacontentconfiguration)
    {
        mContentConfiguration = mediacontentconfiguration;
    }

    public void setSelectedItems(List list)
    {
        mSelectedItems = list;
    }

}
