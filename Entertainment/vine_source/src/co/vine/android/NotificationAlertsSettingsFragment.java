// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class NotificationAlertsSettingsFragment extends PreferenceFragment
{

    public NotificationAlertsSettingsFragment()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        addPreferencesFromResource(0x7f050003);
    }
}
