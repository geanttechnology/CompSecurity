// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.FlurryUtils;
import co.vine.android.util.Util;

// Referenced classes of package co.vine.android:
//            BaseControllerActionBarActivity, Settings, NotificationAlertsSettingsFragment

public class NotificationAlertsSettingsActivity extends BaseControllerActionBarActivity
{

    private boolean mNotificationWasEnabled;

    public NotificationAlertsSettingsActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle, 0x7f030046, true);
        setupActionBar(Boolean.valueOf(true), Boolean.valueOf(true), 0x7f0e01f3, Boolean.valueOf(true));
        mNotificationWasEnabled = Settings.isNotificationEnabled(this);
        if (bundle == null)
        {
            bundle = new NotificationAlertsSettingsFragment();
            getFragmentManager().beginTransaction().add(0x7f0a0102, bundle).commit();
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (mNotificationWasEnabled && !Settings.isNotificationEnabled(this))
        {
            FlurryUtils.trackNotificationDisabled();
        }
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i)
    {
        try
        {
            super.startActivityFromFragment(fragment, intent, i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Fragment fragment)
        {
            CrashUtil.logException(fragment);
        }
        Util.showCenteredToast(this, 0x7f0e0256);
    }
}
