// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.widget.Toast;
import com.google.android.apps.youtube.kids.activities.DeveloperActivity;

public final class xa
    implements android.preference.Preference.OnPreferenceChangeListener
{

    private ListPreference a;
    private EditTextPreference b;
    private DeveloperActivity c;

    public xa(DeveloperActivity developeractivity, ListPreference listpreference, EditTextPreference edittextpreference)
    {
        c = developeractivity;
        a = listpreference;
        b = edittextpreference;
        super();
    }

    public final boolean onPreferenceChange(Preference preference, Object obj)
    {
        obj = obj.toString();
        if (coj.valueOf(a.getValue()) == coj.a && cof.valueOf(((String) (obj))) != cof.b)
        {
            c.getPreferenceScreen().onItemClick(null, null, a.getOrder(), 0L);
            Toast.makeText(c.getApplicationContext(), "Change the api first to use non-staging backend.", 1).show();
            return false;
        }
        DeveloperActivity.b(c).edit().putString(preference.getKey(), ((String) (obj))).commit();
        preference.setSummary(c.getString(0x7f0b01c7, new Object[] {
            obj
        }));
        boolean flag;
        if (cof.valueOf(((String) (obj))) == cof.d)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.setEnabled(flag);
        if (flag)
        {
            c.getPreferenceScreen().onItemClick(null, null, b.getOrder(), 0L);
        } else
        {
            DeveloperActivity.c(c);
        }
        return true;
    }
}
