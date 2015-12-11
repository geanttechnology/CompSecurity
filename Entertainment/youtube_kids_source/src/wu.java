// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import android.preference.Preference;
import com.google.android.apps.youtube.kids.activities.DeveloperActivity;

public final class wu
    implements android.preference.Preference.OnPreferenceChangeListener
{

    private DeveloperActivity a;

    public wu(DeveloperActivity developeractivity)
    {
        a = developeractivity;
        super();
    }

    public final boolean onPreferenceChange(Preference preference, Object obj)
    {
        DeveloperActivity.b(a).edit().putBoolean("pref_enable_parental_gate", ((Boolean)obj).booleanValue()).commit();
        return true;
    }
}
