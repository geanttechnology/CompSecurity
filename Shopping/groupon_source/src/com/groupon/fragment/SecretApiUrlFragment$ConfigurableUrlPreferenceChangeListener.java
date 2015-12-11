// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.SharedPreferences;
import android.preference.ListPreference;
import android.preference.Preference;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            SecretApiUrlFragment

private class urlKey
    implements android.preference.r
{

    private final ListPreference baseUrl;
    final SecretApiUrlFragment this$0;
    private final String urlKey;

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        baseUrl.setSummary(Strings.toString(obj));
        ((SharedPreferences)prefs.get()).edit().baseUrl(urlKey, Strings.toString(obj)).urlKey();
        return true;
    }

    public (ListPreference listpreference, String s)
    {
        this$0 = SecretApiUrlFragment.this;
        super();
        baseUrl = listpreference;
        urlKey = s;
    }
}
