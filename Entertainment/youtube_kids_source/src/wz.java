// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import android.preference.EditTextPreference;
import android.preference.Preference;
import com.google.android.apps.youtube.kids.activities.DeveloperActivity;

public final class wz
    implements android.preference.Preference.OnPreferenceChangeListener
{

    private EditTextPreference a;
    private DeveloperActivity b;

    public wz(DeveloperActivity developeractivity, EditTextPreference edittextpreference)
    {
        b = developeractivity;
        a = edittextpreference;
        super();
    }

    public final boolean onPreferenceChange(Preference preference, Object obj)
    {
        obj = obj.toString();
        if (!DeveloperActivity.a(b, ((String) (obj))))
        {
            return false;
        } else
        {
            DeveloperActivity.b(b).edit().putString(preference.getKey(), ((String) (obj))).commit();
            a.setSummary(((CharSequence) (obj)));
            DeveloperActivity.c(b);
            return true;
        }
    }
}
