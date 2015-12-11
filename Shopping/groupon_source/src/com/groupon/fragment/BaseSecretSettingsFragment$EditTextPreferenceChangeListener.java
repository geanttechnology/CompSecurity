// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.SharedPreferences;
import android.preference.EditTextPreference;
import android.preference.Preference;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            BaseSecretSettingsFragment

private class preferenceKey
    implements android.preference.r
{

    private final EditTextPreference pref;
    private final String preferenceKey;
    private final String summaryWhenEmpty;
    final BaseSecretSettingsFragment this$0;

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        if (Strings.isEmpty(obj))
        {
            pref.setSummary(summaryWhenEmpty);
            ((SharedPreferences)prefs.get()).edit().summaryWhenEmpty(preferenceKey).preferenceKey();
        } else
        {
            pref.setSummary(Strings.toString(obj));
            ((SharedPreferences)prefs.get()).edit().pref(preferenceKey, Strings.toString(obj)).preferenceKey();
        }
        return true;
    }

    public (EditTextPreference edittextpreference, String s, String s1)
    {
        this$0 = BaseSecretSettingsFragment.this;
        super();
        pref = edittextpreference;
        summaryWhenEmpty = s;
        preferenceKey = s1;
    }
}
