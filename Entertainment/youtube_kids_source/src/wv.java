// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.preference.Preference;
import android.widget.Toast;
import com.google.android.apps.youtube.kids.activities.DeveloperActivity;

public final class wv
    implements android.preference.Preference.OnPreferenceChangeListener
{

    private DeveloperActivity a;

    public wv(DeveloperActivity developeractivity)
    {
        a = developeractivity;
        super();
    }

    public final boolean onPreferenceChange(Preference preference, Object obj)
    {
        obj = obj.toString();
        boolean flag = bye.a(((String) (obj)));
        if (flag)
        {
            bye.a(DeveloperActivity.b(a), ((String) (obj)));
            preference.setSummary(DeveloperActivity.a(bye.b(DeveloperActivity.b(a))));
            (new xb(a)).execute(new Void[0]);
            return flag;
        } else
        {
            Toast.makeText(a, "Invalid Format: experiment ids not saved. Expected: 111111,111112,...", 1).show();
            return flag;
        }
    }
}
