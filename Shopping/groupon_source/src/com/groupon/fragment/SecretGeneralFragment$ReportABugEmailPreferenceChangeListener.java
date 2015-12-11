// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.SharedPreferences;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.widget.Toast;
import com.groupon.activity.Gifting;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            SecretGeneralFragment

private class reportABugEmail
    implements android.preference.r
{

    private final EditTextPreference reportABugEmail;
    final SecretGeneralFragment this$0;

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        if (Strings.isEmpty(obj))
        {
            ((SharedPreferences)prefs.get()).edit().ener("reportABugEmail").ener();
            reportABugEmail.setSummary("e.g. ex@mple.com");
        } else
        if (Gifting.isEmailValid(Strings.toString(obj)))
        {
            ((SharedPreferences)prefs.get()).edit().reportABugEmail("reportABugEmail", Strings.toString(obj)).reportABugEmail();
            reportABugEmail.setSummary(Strings.toString(obj));
        } else
        {
            Toast.makeText(getActivity(), "Invalid email.", 1).show();
            ((SharedPreferences)prefs.get()).edit().reportABugEmail("reportABugEmail").reportABugEmail();
            reportABugEmail.setSummary("e.g. ex@mple.com");
            return false;
        }
        return true;
    }

    public (EditTextPreference edittextpreference)
    {
        this$0 = SecretGeneralFragment.this;
        super();
        reportABugEmail = edittextpreference;
    }
}
