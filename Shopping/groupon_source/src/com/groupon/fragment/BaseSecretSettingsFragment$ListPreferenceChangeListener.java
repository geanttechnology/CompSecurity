// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.SharedPreferences;
import android.preference.ListPreference;
import android.preference.Preference;
import java.util.HashMap;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            BaseSecretSettingsFragment

private class valuesToNames
    implements android.preference.r
{

    private final ListPreference pref;
    private final String preferenceKey;
    final BaseSecretSettingsFragment this$0;
    private final HashMap valuesToNames;

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        ((SharedPreferences)prefs.get()).edit().ener(preferenceKey, Strings.toString(obj)).preferenceKey();
        pref.setSummary((CharSequence)valuesToNames.get(obj));
        return true;
    }

    public (String s, ListPreference listpreference, HashMap hashmap)
    {
        this$0 = BaseSecretSettingsFragment.this;
        super();
        preferenceKey = s;
        pref = listpreference;
        valuesToNames = hashmap;
    }
}
