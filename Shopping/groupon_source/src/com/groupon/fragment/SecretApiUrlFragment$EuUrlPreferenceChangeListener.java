// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.SharedPreferences;
import android.preference.EditTextPreference;
import android.preference.Preference;
import com.groupon.service.LoginService;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            SecretApiUrlFragment

private class baseEUUrl
    implements android.preference.r
{

    private final EditTextPreference baseEUUrl;
    final SecretApiUrlFragment this$0;

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        baseEUUrl.setSummary(Strings.toString(obj));
        ((SharedPreferences)prefs.get()).edit().baseEUUrl("base_url_eu", Strings.toString(obj)).baseEUUrl();
        ((LoginService)loginService.get()).logout();
        return true;
    }

    public (EditTextPreference edittextpreference)
    {
        this$0 = SecretApiUrlFragment.this;
        super();
        baseEUUrl = edittextpreference;
    }
}
