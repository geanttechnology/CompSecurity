// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.preference.Preference;
import com.groupon.google_api.GeofenceSetter;
import com.groupon.tracking.mobile.sdk.Logger;

// Referenced classes of package com.groupon.fragment:
//            SettingsFragment

class this._cls0
    implements android.preference.enceChangeListener
{

    final SettingsFragment this$0;

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        boolean flag = ((Boolean)obj).booleanValue();
        obj = SettingsFragment.access$000(SettingsFragment.this);
        if (flag)
        {
            preference = "user_enabled";
        } else
        {
            preference = "user_disabled";
        }
        ((Logger) (obj)).logGeneralEvent("proximity_notification", "user_pref", preference, 0, Logger.NULL_NST_FIELD);
        if (!flag)
        {
            SettingsFragment.access$500(SettingsFragment.this).clearGeofences();
        }
        return true;
    }

    ceChangeListener()
    {
        this$0 = SettingsFragment.this;
        super();
    }
}
