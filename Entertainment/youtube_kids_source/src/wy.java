// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.widget.Toast;
import com.google.android.apps.youtube.kids.activities.DeveloperActivity;

public final class wy
    implements android.preference.Preference.OnPreferenceChangeListener
{

    private ListPreference a;
    private DeveloperActivity b;

    public wy(DeveloperActivity developeractivity, ListPreference listpreference)
    {
        b = developeractivity;
        a = listpreference;
        super();
    }

    public final boolean onPreferenceChange(Preference preference, Object obj)
    {
        obj = obj.toString();
        cof cof1 = cof.valueOf(a.getValue());
        if (coj.valueOf(((String) (obj))) == coj.a && cof1 != cof.b)
        {
            b.getPreferenceScreen().onItemClick(null, null, a.getOrder(), 0L);
            Toast.makeText(b.getApplicationContext(), "Select staging to use V1RELEASE api.", 1).show();
        }
        DeveloperActivity.b(b).edit().putString(preference.getKey(), ((String) (obj))).commit();
        preference.setSummary(b.getString(0x7f0b01ca, new Object[] {
            obj
        }));
        return true;
    }
}
