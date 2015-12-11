// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import com.groupon.fragment.SettingsFragment;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity

public class Settings extends GrouponActivity
{

    private PreferenceFragment preferenceFragment;

    public Settings()
    {
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setToolbarTitle(getString(0x7f08036f));
    }

    public void onCreate(Bundle bundle)
    {
        FragmentManager fragmentmanager;
        String s;
        super.onCreate(bundle);
        setContentView(0x7f0301eb);
        fragmentmanager = getFragmentManager();
        s = com/groupon/activity/Settings.getName();
        if (bundle == null) goto _L2; else goto _L1
_L1:
        preferenceFragment = (PreferenceFragment)fragmentmanager.getFragment(bundle, s);
_L4:
        if (!preferenceFragment.isInLayout())
        {
            fragmentmanager.beginTransaction().replace(0x7f100132, preferenceFragment, s).commitAllowingStateLoss();
        }
        return;
_L2:
        if (preferenceFragment == null)
        {
            preferenceFragment = new SettingsFragment();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        String s = com/groupon/activity/Settings.getName();
        getFragmentManager().putFragment(bundle, s, preferenceFragment);
    }
}
