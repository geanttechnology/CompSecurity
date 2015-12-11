// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

// Referenced classes of package com.wishabi.flipp.app:
//            er, es

public final class eq extends PreferenceFragment
{

    android.preference.Preference.OnPreferenceClickListener a;
    android.preference.Preference.OnPreferenceChangeListener b;
    private Toast c;

    public eq()
    {
        a = new er(this);
        b = new es(this);
    }

    static void a(eq eq1, String s)
    {
label0:
        {
label1:
            {
                Object obj = eq1.getActivity();
                if (obj == null)
                {
                    break label1;
                }
                if (eq1.c == null)
                {
                    eq1.c = new Toast(eq1.getActivity());
                    eq1.c.setGravity(80, 0, (int)TypedValue.applyDimension(1, 55F, ((Activity) (obj)).getResources().getDisplayMetrics()));
                    obj = ((Activity) (obj)).getLayoutInflater().inflate(0x7f030031, null);
                    if (obj == null)
                    {
                        break label1;
                    }
                    eq1.c.setView(((View) (obj)));
                }
                if (s != null)
                {
                    break label0;
                }
                eq1.c.cancel();
            }
            return;
        }
        ((TextView)eq1.c.getView().findViewById(0x7f0b00c2)).setText(s);
        eq1.c.setDuration(0);
        eq1.c.show();
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getPreferenceManager().setSharedPreferencesName("com.wishabi.flipp.preferences");
        addPreferencesFromResource(0x7f060000);
        boolean flag = getPreferenceManager().getSharedPreferences().getBoolean("keep_search_history", true);
        findPreference("keep_search_history").setOnPreferenceChangeListener(b);
        bundle = findPreference("clear_search_history");
        bundle.setOnPreferenceClickListener(a);
        bundle.setEnabled(flag);
    }
}
