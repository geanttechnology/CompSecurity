// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

// Referenced classes of package co.vine.android:
//            BaseControllerActionBarActivity, NotificationSettingsFragment

public class NotificationSettingsActivity extends BaseControllerActionBarActivity
{

    public NotificationSettingsActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle, 0x7f030046, true);
        setupActionBar(Boolean.valueOf(true), Boolean.valueOf(true), 0x7f0e01f2, Boolean.valueOf(true));
        if (bundle == null)
        {
            bundle = new NotificationSettingsFragment();
            getSupportFragmentManager().beginTransaction().add(0x7f0a0102, bundle).commit();
        }
    }
}
