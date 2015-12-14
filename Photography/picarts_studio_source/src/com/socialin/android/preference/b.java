// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.preference;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import com.socialin.android.apiv3.util.AnalyticUtils;
import myobfuscated.f.m;

public final class b extends PreferenceFragment
    implements com.socialin.android.constants.b
{

    private SharedPreferences c;
    private boolean d;

    public b()
    {
    }

    static SharedPreferences a(b b1)
    {
        return b1.c;
    }

    static boolean b(b b1)
    {
        return b1.d;
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        addPreferencesFromResource(0x7f060001);
        d = getActivity().getIntent().getBooleanExtra("dialog_hide", false);
        AnalyticUtils.getInstance(getActivity()).trackLocalAction("fbActionsPref:onCreate");
        c = getActivity().getSharedPreferences((new StringBuilder("sinPref_")).append(getString(m.e(getActivity(), "app_name_short"))).toString(), 0);
        bundle = (CheckBoxPreference)findPreference("enable_fb_action_all");
        CheckBoxPreference checkboxpreference = (CheckBoxPreference)findPreference("enable_fb_action_add");
        CheckBoxPreference checkboxpreference1 = (CheckBoxPreference)findPreference("enable_fb_action_like");
        CheckBoxPreference checkboxpreference2 = (CheckBoxPreference)findPreference("enable_fb_action_comment");
        CheckBoxPreference checkboxpreference3 = (CheckBoxPreference)findPreference("enable_fb_action_follow");
        CheckBoxPreference checkboxpreference4 = (CheckBoxPreference)findPreference("enable_fb_explicit");
        CheckBoxPreference checkboxpreference5 = (CheckBoxPreference)findPreference("enable_fb_action_vote");
        checkboxpreference.setChecked(c.getBoolean("enable_fb_action_add", true));
        checkboxpreference1.setChecked(c.getBoolean("enable_fb_action_like", true));
        checkboxpreference2.setChecked(c.getBoolean("enable_fb_action_comment", true));
        checkboxpreference3.setChecked(c.getBoolean("enable_fb_action_follow", true));
        checkboxpreference5.setChecked(c.getBoolean("enable_fb_action_vote", true));
        checkboxpreference4.setChecked(c.getBoolean("enable_fb_explicit", false));
        boolean flag;
        if (checkboxpreference.isChecked() && checkboxpreference1.isChecked() && checkboxpreference2.isChecked() && checkboxpreference3.isChecked() && checkboxpreference5.isChecked())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bundle.setChecked(flag);
        checkboxpreference4.setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener(checkboxpreference4) {

            private CheckBoxPreference a;
            private b b;

            public final boolean onPreferenceClick(Preference preference)
            {
                boolean flag1 = a.isChecked();
                b.a(b).edit().putBoolean("enable_fb_explicit", flag1).apply();
                return flag1;
            }

            
            {
                b = b.this;
                a = checkboxpreference;
                super();
            }
        });
        bundle.setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener(bundle, checkboxpreference, checkboxpreference1, checkboxpreference2, checkboxpreference3, checkboxpreference5) {

            private CheckBoxPreference a;
            private CheckBoxPreference b;
            private CheckBoxPreference c;
            private CheckBoxPreference d;
            private CheckBoxPreference e;
            private CheckBoxPreference f;
            private b g;

            public final boolean onPreferenceClick(Preference preference)
            {
                boolean flag2 = true;
                boolean flag3 = a.isChecked();
                b.setChecked(flag3);
                c.setChecked(flag3);
                d.setChecked(flag3);
                e.setChecked(flag3);
                f.setChecked(flag3);
                preference = b.a(g).edit();
                preference.putBoolean("enable_fb_action_add", flag3);
                preference.putBoolean("enable_fb_action_like", flag3);
                preference.putBoolean("enable_fb_action_comment", flag3);
                preference.putBoolean("enable_fb_action_follow", flag3);
                preference.putBoolean("enable_fb_action_vote", flag3);
                if (b.b(g))
                {
                    boolean flag1;
                    if (!flag3)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    preference.putBoolean("like_accept", flag1);
                    if (!flag3)
                    {
                        flag1 = flag2;
                    } else
                    {
                        flag1 = false;
                    }
                    preference.putBoolean("vote_accept", flag1);
                }
                preference.apply();
                return flag3;
            }

            
            {
                g = b.this;
                a = checkboxpreference;
                b = checkboxpreference1;
                c = checkboxpreference2;
                d = checkboxpreference3;
                e = checkboxpreference4;
                f = checkboxpreference5;
                super();
            }
        });
        checkboxpreference.setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener(checkboxpreference, bundle, checkboxpreference1, checkboxpreference2, checkboxpreference3, checkboxpreference5) {

            private CheckBoxPreference a;
            private CheckBoxPreference b;
            private CheckBoxPreference c;
            private CheckBoxPreference d;
            private CheckBoxPreference e;
            private CheckBoxPreference f;
            private b g;

            public final boolean onPreferenceClick(Preference preference)
            {
                boolean flag1 = a.isChecked();
                b.a(g).edit().putBoolean("enable_fb_action_add", flag1).apply();
                if (!flag1)
                {
                    b.setChecked(false);
                } else
                if (c.isChecked() && d.isChecked() && e.isChecked() && f.isChecked())
                {
                    b.setChecked(true);
                    return flag1;
                }
                return flag1;
            }

            
            {
                g = b.this;
                a = checkboxpreference;
                b = checkboxpreference1;
                c = checkboxpreference2;
                d = checkboxpreference3;
                e = checkboxpreference4;
                f = checkboxpreference5;
                super();
            }
        });
        checkboxpreference1.setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener(checkboxpreference1, bundle, checkboxpreference, checkboxpreference2, checkboxpreference3, checkboxpreference5) {

            private CheckBoxPreference a;
            private CheckBoxPreference b;
            private CheckBoxPreference c;
            private CheckBoxPreference d;
            private CheckBoxPreference e;
            private CheckBoxPreference f;
            private b g;

            public final boolean onPreferenceClick(Preference preference)
            {
                boolean flag2 = a.isChecked();
                preference = b.a(g).edit();
                preference.putBoolean("enable_fb_action_like", flag2);
                if (b.b(g))
                {
                    boolean flag1;
                    if (!flag2)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    preference.putBoolean("like_accept", flag1);
                }
                preference.apply();
                if (!flag2)
                {
                    b.setChecked(false);
                } else
                if (c.isChecked() && d.isChecked() && e.isChecked() && f.isChecked())
                {
                    b.setChecked(true);
                    return flag2;
                }
                return flag2;
            }

            
            {
                g = b.this;
                a = checkboxpreference;
                b = checkboxpreference1;
                c = checkboxpreference2;
                d = checkboxpreference3;
                e = checkboxpreference4;
                f = checkboxpreference5;
                super();
            }
        });
        checkboxpreference2.setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener(checkboxpreference2, bundle, checkboxpreference, checkboxpreference1, checkboxpreference3, checkboxpreference5) {

            private CheckBoxPreference a;
            private CheckBoxPreference b;
            private CheckBoxPreference c;
            private CheckBoxPreference d;
            private CheckBoxPreference e;
            private CheckBoxPreference f;
            private b g;

            public final boolean onPreferenceClick(Preference preference)
            {
                boolean flag1 = a.isChecked();
                b.a(g).edit().putBoolean("enable_fb_action_comment", flag1).apply();
                if (!flag1)
                {
                    b.setChecked(false);
                } else
                if (c.isChecked() && d.isChecked() && e.isChecked() && f.isChecked())
                {
                    b.setChecked(true);
                    return flag1;
                }
                return flag1;
            }

            
            {
                g = b.this;
                a = checkboxpreference;
                b = checkboxpreference1;
                c = checkboxpreference2;
                d = checkboxpreference3;
                e = checkboxpreference4;
                f = checkboxpreference5;
                super();
            }
        });
        checkboxpreference3.setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener(checkboxpreference3, bundle, checkboxpreference, checkboxpreference1, checkboxpreference2, checkboxpreference5) {

            private CheckBoxPreference a;
            private CheckBoxPreference b;
            private CheckBoxPreference c;
            private CheckBoxPreference d;
            private CheckBoxPreference e;
            private CheckBoxPreference f;
            private b g;

            public final boolean onPreferenceClick(Preference preference)
            {
                boolean flag1 = a.isChecked();
                b.a(g).edit().putBoolean("enable_fb_action_follow", flag1).apply();
                if (!flag1)
                {
                    b.setChecked(false);
                } else
                if (c.isChecked() && d.isChecked() && e.isChecked() && f.isChecked())
                {
                    b.setChecked(true);
                    return flag1;
                }
                return flag1;
            }

            
            {
                g = b.this;
                a = checkboxpreference;
                b = checkboxpreference1;
                c = checkboxpreference2;
                d = checkboxpreference3;
                e = checkboxpreference4;
                f = checkboxpreference5;
                super();
            }
        });
        checkboxpreference5.setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener(checkboxpreference5, bundle, checkboxpreference, checkboxpreference1, checkboxpreference2, checkboxpreference3) {

            private CheckBoxPreference a;
            private CheckBoxPreference b;
            private CheckBoxPreference c;
            private CheckBoxPreference d;
            private CheckBoxPreference e;
            private CheckBoxPreference f;
            private b g;

            public final boolean onPreferenceClick(Preference preference)
            {
                boolean flag2 = a.isChecked();
                preference = b.a(g).edit();
                preference.putBoolean("enable_fb_action_vote", flag2);
                if (b.b(g))
                {
                    boolean flag1;
                    if (!flag2)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    preference.putBoolean("vote_accept", flag1);
                }
                preference.apply();
                if (!flag2)
                {
                    b.setChecked(false);
                } else
                if (c.isChecked() && d.isChecked() && e.isChecked() && f.isChecked())
                {
                    b.setChecked(true);
                    return flag2;
                }
                return flag2;
            }

            
            {
                g = b.this;
                a = checkboxpreference;
                b = checkboxpreference1;
                c = checkboxpreference2;
                d = checkboxpreference3;
                e = checkboxpreference4;
                f = checkboxpreference5;
                super();
            }
        });
    }
}
