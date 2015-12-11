// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.preference.Preference;
import com.groupon.GrouponApplication;
import com.groupon.util.TimePickerPreference;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            SettingsFragment

class this._cls0
    implements android.preference.enceChangeListener
{

    final SettingsFragment this$0;

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        SettingsFragment.access$400(SettingsFragment.this).setSummary(Strings.toString(obj));
        GrouponApplication.refreshLocalNotificationSetup(getActivity());
        return true;
    }

    ceChangeListener()
    {
        this$0 = SettingsFragment.this;
        super();
    }
}
