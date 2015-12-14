// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.preference;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import com.socialin.android.apiv3.util.AnalyticUtils;
import myobfuscated.f.m;

public final class c extends PreferenceFragment
{

    private SharedPreferences a;

    public c()
    {
    }

    static SharedPreferences a(c c1)
    {
        return c1.a;
    }

    public final void onCreate(Bundle bundle)
    {
        boolean flag1 = false;
        super.onCreate(bundle);
        addPreferencesFromResource(0x7f060004);
        AnalyticUtils.getInstance(getActivity()).trackLocalAction("gpActionsPref:onCreate");
        a = getActivity().getSharedPreferences((new StringBuilder("sinPref_")).append(getString(m.e(getActivity(), "app_name_short"))).toString(), 0);
        bundle = (CheckBoxPreference)findPreference("enable_gp_action_all");
        CheckBoxPreference checkboxpreference = (CheckBoxPreference)findPreference("enable_gp_action_add");
        CheckBoxPreference checkboxpreference1 = (CheckBoxPreference)findPreference("enable_gp_action_like");
        CheckBoxPreference checkboxpreference2 = (CheckBoxPreference)findPreference("enable_gp_action_comment");
        checkboxpreference.setChecked(a.getBoolean("enable_gp_action_add", false));
        checkboxpreference1.setChecked(a.getBoolean("enable_gp_action_like", false));
        checkboxpreference2.setChecked(a.getBoolean("enable_gp_action_comment", false));
        boolean flag = flag1;
        if (checkboxpreference.isChecked())
        {
            flag = flag1;
            if (checkboxpreference1.isChecked())
            {
                flag = flag1;
                if (checkboxpreference2.isChecked())
                {
                    flag = true;
                }
            }
        }
        bundle.setChecked(flag);
        bundle.setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener(bundle, checkboxpreference, checkboxpreference1, checkboxpreference2) {

            private CheckBoxPreference a;
            private CheckBoxPreference b;
            private CheckBoxPreference c;
            private CheckBoxPreference d;
            private c e;

            public final boolean onPreferenceClick(Preference preference)
            {
                boolean flag2 = a.isChecked();
                b.setChecked(flag2);
                c.setChecked(flag2);
                d.setChecked(flag2);
                c.a(e).edit().putBoolean("enable_gp_action_add", flag2).apply();
                c.a(e).edit().putBoolean("enable_gp_action_like", flag2).apply();
                c.a(e).edit().putBoolean("enable_gp_action_comment", flag2).apply();
                return flag2;
            }

            
            {
                e = c.this;
                a = checkboxpreference;
                b = checkboxpreference1;
                c = checkboxpreference2;
                d = checkboxpreference3;
                super();
            }
        });
        checkboxpreference.setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener(checkboxpreference, bundle, checkboxpreference1, checkboxpreference2) {

            private CheckBoxPreference a;
            private CheckBoxPreference b;
            private CheckBoxPreference c;
            private CheckBoxPreference d;
            private c e;

            public final boolean onPreferenceClick(Preference preference)
            {
                boolean flag2 = a.isChecked();
                c.a(e).edit().putBoolean("enable_gp_action_add", flag2).apply();
                if (!flag2)
                {
                    b.setChecked(false);
                } else
                if (c.isChecked() && d.isChecked())
                {
                    b.setChecked(true);
                    return flag2;
                }
                return flag2;
            }

            
            {
                e = c.this;
                a = checkboxpreference;
                b = checkboxpreference1;
                c = checkboxpreference2;
                d = checkboxpreference3;
                super();
            }
        });
        checkboxpreference1.setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener(checkboxpreference1, bundle, checkboxpreference, checkboxpreference2) {

            private CheckBoxPreference a;
            private CheckBoxPreference b;
            private CheckBoxPreference c;
            private CheckBoxPreference d;
            private c e;

            public final boolean onPreferenceClick(Preference preference)
            {
                boolean flag2 = a.isChecked();
                c.a(e).edit().putBoolean("enable_gp_action_like", flag2).apply();
                if (!flag2)
                {
                    b.setChecked(false);
                } else
                if (c.isChecked() && d.isChecked())
                {
                    b.setChecked(true);
                    return flag2;
                }
                return flag2;
            }

            
            {
                e = c.this;
                a = checkboxpreference;
                b = checkboxpreference1;
                c = checkboxpreference2;
                d = checkboxpreference3;
                super();
            }
        });
        checkboxpreference2.setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener(checkboxpreference2, bundle, checkboxpreference, checkboxpreference1) {

            private CheckBoxPreference a;
            private CheckBoxPreference b;
            private CheckBoxPreference c;
            private CheckBoxPreference d;
            private c e;

            public final boolean onPreferenceClick(Preference preference)
            {
                boolean flag2 = a.isChecked();
                c.a(e).edit().putBoolean("enable_gp_action_comment", flag2).apply();
                if (!flag2)
                {
                    b.setChecked(false);
                } else
                if (c.isChecked() && d.isChecked())
                {
                    b.setChecked(true);
                    return flag2;
                }
                return flag2;
            }

            
            {
                e = c.this;
                a = checkboxpreference;
                b = checkboxpreference1;
                c = checkboxpreference2;
                d = checkboxpreference3;
                super();
            }
        });
    }
}
