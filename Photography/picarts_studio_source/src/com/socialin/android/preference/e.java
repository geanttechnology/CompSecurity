// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.preference;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceFragment;
import com.appboy.enums.NotificationSubscriptionType;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.UpdateUserController;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.request.NotificationSettingsParams;
import com.socialin.android.apiv3.request.UpdateUserParams;
import com.socialin.android.dialog.g;
import com.socialin.android.util.b;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.preference:
//            PreferencesActivity

public final class e extends PreferenceFragment
{

    private g a;
    private SharedPreferences b;
    private UpdateUserController c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private UpdateUserParams o;

    public e()
    {
        c = new UpdateUserController();
        d = 1;
        e = 1;
        f = 1;
        g = 1;
        h = 1;
        i = 1;
        j = 1;
        k = 1;
        l = 1;
        m = 1;
        n = 1;
        o = new UpdateUserParams();
    }

    static g a(e e1)
    {
        return e1.a;
    }

    static SharedPreferences b(e e1)
    {
        return e1.b;
    }

    static UpdateUserParams c(e e1)
    {
        return e1.o;
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        o.notificationParams = new NotificationSettingsParams();
        addPreferencesFromResource(0x7f060009);
        b = getActivity().getSharedPreferences((new StringBuilder("sinPref_")).append(getString(myobfuscated.f.m.e(getActivity(), "app_name_short"))).toString(), 0);
        bundle = (CheckBoxPreference)findPreference("notifications_enable_all");
        CheckBoxPreference checkboxpreference = (CheckBoxPreference)findPreference("notifications_enable_likes");
        CheckBoxPreference checkboxpreference1 = (CheckBoxPreference)findPreference("notifications_enable_reposts_me");
        CheckBoxPreference checkboxpreference2 = (CheckBoxPreference)findPreference("notifications_enable_reposts_other");
        CheckBoxPreference checkboxpreference3 = (CheckBoxPreference)findPreference("notifications_enable_comments");
        CheckBoxPreference checkboxpreference4 = (CheckBoxPreference)findPreference("notifications_enable_mention");
        CheckBoxPreference checkboxpreference5 = (CheckBoxPreference)findPreference("notifications_enable_publishs");
        CheckBoxPreference checkboxpreference6 = (CheckBoxPreference)findPreference("notifications_enable_follow");
        CheckBoxPreference checkboxpreference7 = (CheckBoxPreference)findPreference("notifications_enable_follow_me");
        CheckBoxPreference checkboxpreference8 = (CheckBoxPreference)findPreference("notifications_enable_suggest");
        CheckBoxPreference checkboxpreference9 = (CheckBoxPreference)findPreference("notifications_enable_push");
        if (getString(0x7f0808c8).equals(getString(0x7f0808cc)))
        {
            ((PreferenceCategory)findPreference("pref_screen_main")).removePreference(checkboxpreference8);
        }
        checkboxpreference.setChecked(b.getBoolean("notifications_enable_likes_me", true));
        checkboxpreference1.setChecked(b.getBoolean("notifications_enable_reposts_me", true));
        checkboxpreference2.setChecked(b.getBoolean("notifications_enable_reposts_other", true));
        checkboxpreference3.setChecked(b.getBoolean("notifications_enable_comments", true));
        checkboxpreference4.setChecked(b.getBoolean("notifications_enable_mention", true));
        checkboxpreference5.setChecked(b.getBoolean("notifications_enable_publishs", true));
        checkboxpreference6.setChecked(b.getBoolean("notifications_enable_follow", true));
        checkboxpreference7.setChecked(b.getBoolean("notifications_enable_follow_me", true));
        checkboxpreference8.setChecked(b.getBoolean("enable_facebook_notifications", true));
        checkboxpreference9.setChecked(b.getBoolean("enable_push_notifications", true));
        d = 1;
        int i1;
        if (checkboxpreference.isChecked())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        e = i1;
        if (checkboxpreference1.isChecked())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        f = i1;
        if (checkboxpreference2.isChecked())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        g = i1;
        if (checkboxpreference5.isChecked())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        h = i1;
        if (checkboxpreference3.isChecked())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        i = i1;
        if (checkboxpreference4.isChecked())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        j = i1;
        if (checkboxpreference6.isChecked())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        k = i1;
        if (checkboxpreference7.isChecked())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        l = i1;
        if (checkboxpreference8.isChecked())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        m = i1;
        if (checkboxpreference9.isChecked())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        n = i1;
        o.notificationParams.like = d;
        o.notificationParams.likeMe = e;
        o.notificationParams.repostMe = f;
        o.notificationParams.repostOther = g;
        o.notificationParams.publish = h;
        o.notificationParams.comment = i;
        o.notificationParams.mention = j;
        o.notificationParams.follow = k;
        o.notificationParams.followMe = l;
        o.notificationParams.suggestFb = m;
        o.notificationParams.suggestTwitter = m;
        o.notificationParams.pushMe = n;
        if (checkboxpreference.isChecked() && checkboxpreference1.isChecked() && checkboxpreference2.isChecked() && checkboxpreference3.isChecked() && checkboxpreference4.isChecked() && checkboxpreference5.isChecked() && checkboxpreference8.isChecked() && checkboxpreference6.isChecked() && checkboxpreference7.isChecked())
        {
            bundle.setChecked(true);
        } else
        {
            bundle.setChecked(false);
        }
        bundle.setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener(bundle, checkboxpreference, checkboxpreference1, checkboxpreference2, checkboxpreference3, checkboxpreference4, checkboxpreference5, checkboxpreference8, checkboxpreference6, checkboxpreference7) {

            private CheckBoxPreference a;
            private CheckBoxPreference b;
            private CheckBoxPreference c;
            private CheckBoxPreference d;
            private CheckBoxPreference e;
            private CheckBoxPreference f;
            private CheckBoxPreference g;
            private CheckBoxPreference h;
            private CheckBoxPreference i;
            private CheckBoxPreference j;
            private e k;

            public final boolean onPreferenceClick(Preference preference)
            {
                boolean flag = a.isChecked();
                b.setChecked(flag);
                c.setChecked(flag);
                d.setChecked(flag);
                e.setChecked(flag);
                f.setChecked(flag);
                g.setChecked(flag);
                h.setChecked(flag);
                i.setChecked(flag);
                j.setChecked(flag);
                com.socialin.android.preference.e.b(k).edit().putBoolean("notifications_enable_likes", flag).apply();
                com.socialin.android.preference.e.b(k).edit().putBoolean("notifications_enable_likes_me", flag).apply();
                com.socialin.android.preference.e.b(k).edit().putBoolean("notifications_enable_reposts_me", flag).apply();
                com.socialin.android.preference.e.b(k).edit().putBoolean("notifications_enable_reposts_other", flag).apply();
                com.socialin.android.preference.e.b(k).edit().putBoolean("notifications_enable_comments", flag).apply();
                com.socialin.android.preference.e.b(k).edit().putBoolean("notifications_enable_mention", flag).apply();
                com.socialin.android.preference.e.b(k).edit().putBoolean("notifications_enable_publishs", flag).apply();
                com.socialin.android.preference.e.b(k).edit().putBoolean("enable_facebook_notifications", flag).apply();
                com.socialin.android.preference.e.b(k).edit().putBoolean("enable_twitter_notifications", flag).apply();
                com.socialin.android.preference.e.b(k).edit().putBoolean("notifications_enable_follow", flag).apply();
                com.socialin.android.preference.e.b(k).edit().putBoolean("notifications_enable_follow_me", flag).apply();
                preference = e.c(k).notificationParams;
                int j1;
                if (flag)
                {
                    j1 = 1;
                } else
                {
                    j1 = 0;
                }
                preference.setAll(j1);
                return flag;
            }

            
            {
                k = e.this;
                a = checkboxpreference;
                b = checkboxpreference1;
                c = checkboxpreference2;
                d = checkboxpreference3;
                e = checkboxpreference4;
                f = checkboxpreference5;
                g = checkboxpreference6;
                h = checkboxpreference7;
                i = checkboxpreference8;
                j = checkboxpreference9;
                super();
            }
        });
        checkboxpreference.setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener(checkboxpreference, checkboxpreference1, checkboxpreference2, checkboxpreference3, checkboxpreference4, checkboxpreference5, checkboxpreference8, checkboxpreference6, checkboxpreference7, bundle) {

            private CheckBoxPreference a;
            private CheckBoxPreference b;
            private CheckBoxPreference c;
            private CheckBoxPreference d;
            private CheckBoxPreference e;
            private CheckBoxPreference f;
            private CheckBoxPreference g;
            private CheckBoxPreference h;
            private CheckBoxPreference i;
            private CheckBoxPreference j;
            private e k;

            public final boolean onPreferenceClick(Preference preference)
            {
                int j1 = 1;
                if (a.isChecked())
                {
                    com.socialin.android.preference.e.b(k).edit().putBoolean("notifications_enable_likes_me", true).apply();
                    if (b.isChecked() && c.isChecked() && d.isChecked() && e.isChecked() && f.isChecked() && g.isChecked() && h.isChecked() && i.isChecked())
                    {
                        j.setChecked(true);
                    }
                } else
                {
                    com.socialin.android.preference.e.b(k).edit().putBoolean("notifications_enable_likes_me", false).apply();
                    j.setChecked(false);
                }
                preference = e.c(k).notificationParams;
                if (!a.isChecked())
                {
                    j1 = 0;
                }
                preference.likeMe = j1;
                return false;
            }

            
            {
                k = e.this;
                a = checkboxpreference;
                b = checkboxpreference1;
                c = checkboxpreference2;
                d = checkboxpreference3;
                e = checkboxpreference4;
                f = checkboxpreference5;
                g = checkboxpreference6;
                h = checkboxpreference7;
                i = checkboxpreference8;
                j = checkboxpreference9;
                super();
            }
        });
        checkboxpreference1.setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener(checkboxpreference1, checkboxpreference, checkboxpreference3, checkboxpreference2, checkboxpreference4, checkboxpreference5, checkboxpreference8, checkboxpreference6, checkboxpreference7, bundle) {

            private CheckBoxPreference a;
            private CheckBoxPreference b;
            private CheckBoxPreference c;
            private CheckBoxPreference d;
            private CheckBoxPreference e;
            private CheckBoxPreference f;
            private CheckBoxPreference g;
            private CheckBoxPreference h;
            private CheckBoxPreference i;
            private CheckBoxPreference j;
            private e k;

            public final boolean onPreferenceClick(Preference preference)
            {
                int j1 = 1;
                if (a.isChecked())
                {
                    com.socialin.android.preference.e.b(k).edit().putBoolean("notifications_enable_reposts_me", true).apply();
                    if (b.isChecked() && c.isChecked() && d.isChecked() && e.isChecked() && f.isChecked() && g.isChecked() && h.isChecked() && i.isChecked())
                    {
                        j.setChecked(true);
                    }
                } else
                {
                    com.socialin.android.preference.e.b(k).edit().putBoolean("notifications_enable_reposts_me", false).apply();
                    j.setChecked(false);
                }
                preference = e.c(k).notificationParams;
                if (!a.isChecked())
                {
                    j1 = 0;
                }
                preference.repostMe = j1;
                return false;
            }

            
            {
                k = e.this;
                a = checkboxpreference;
                b = checkboxpreference1;
                c = checkboxpreference2;
                d = checkboxpreference3;
                e = checkboxpreference4;
                f = checkboxpreference5;
                g = checkboxpreference6;
                h = checkboxpreference7;
                i = checkboxpreference8;
                j = checkboxpreference9;
                super();
            }
        });
        checkboxpreference2.setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener(checkboxpreference2, checkboxpreference, checkboxpreference1, checkboxpreference3, checkboxpreference4, checkboxpreference5, checkboxpreference8, checkboxpreference6, checkboxpreference7, bundle) {

            private CheckBoxPreference a;
            private CheckBoxPreference b;
            private CheckBoxPreference c;
            private CheckBoxPreference d;
            private CheckBoxPreference e;
            private CheckBoxPreference f;
            private CheckBoxPreference g;
            private CheckBoxPreference h;
            private CheckBoxPreference i;
            private CheckBoxPreference j;
            private e k;

            public final boolean onPreferenceClick(Preference preference)
            {
                int j1 = 1;
                if (a.isChecked())
                {
                    com.socialin.android.preference.e.b(k).edit().putBoolean("notifications_enable_reposts_other", true).apply();
                    if (b.isChecked() && c.isChecked() && d.isChecked() && e.isChecked() && f.isChecked() && g.isChecked() && h.isChecked() && i.isChecked())
                    {
                        j.setChecked(true);
                    }
                } else
                {
                    com.socialin.android.preference.e.b(k).edit().putBoolean("notifications_enable_reposts_other", false).apply();
                    j.setChecked(false);
                }
                preference = e.c(k).notificationParams;
                if (!a.isChecked())
                {
                    j1 = 0;
                }
                preference.repostOther = j1;
                return false;
            }

            
            {
                k = e.this;
                a = checkboxpreference;
                b = checkboxpreference1;
                c = checkboxpreference2;
                d = checkboxpreference3;
                e = checkboxpreference4;
                f = checkboxpreference5;
                g = checkboxpreference6;
                h = checkboxpreference7;
                i = checkboxpreference8;
                j = checkboxpreference9;
                super();
            }
        });
        checkboxpreference3.setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener(checkboxpreference3, checkboxpreference, checkboxpreference1, checkboxpreference2, checkboxpreference4, checkboxpreference5, checkboxpreference8, checkboxpreference6, checkboxpreference7, bundle) {

            private CheckBoxPreference a;
            private CheckBoxPreference b;
            private CheckBoxPreference c;
            private CheckBoxPreference d;
            private CheckBoxPreference e;
            private CheckBoxPreference f;
            private CheckBoxPreference g;
            private CheckBoxPreference h;
            private CheckBoxPreference i;
            private CheckBoxPreference j;
            private e k;

            public final boolean onPreferenceClick(Preference preference)
            {
                int j1 = 1;
                if (a.isChecked())
                {
                    com.socialin.android.preference.e.b(k).edit().putBoolean("notifications_enable_comments", true).apply();
                    if (b.isChecked() && c.isChecked() && d.isChecked() && e.isChecked() && f.isChecked() && g.isChecked() && h.isChecked() && i.isChecked())
                    {
                        j.setChecked(true);
                    }
                } else
                {
                    com.socialin.android.preference.e.b(k).edit().putBoolean("notifications_enable_comments", false).apply();
                    j.setChecked(false);
                }
                preference = e.c(k).notificationParams;
                if (!a.isChecked())
                {
                    j1 = 0;
                }
                preference.comment = j1;
                return false;
            }

            
            {
                k = e.this;
                a = checkboxpreference;
                b = checkboxpreference1;
                c = checkboxpreference2;
                d = checkboxpreference3;
                e = checkboxpreference4;
                f = checkboxpreference5;
                g = checkboxpreference6;
                h = checkboxpreference7;
                i = checkboxpreference8;
                j = checkboxpreference9;
                super();
            }
        });
        checkboxpreference4.setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener(checkboxpreference4, checkboxpreference, checkboxpreference1, checkboxpreference2, checkboxpreference3, checkboxpreference5, checkboxpreference8, checkboxpreference6, checkboxpreference7, bundle) {

            private CheckBoxPreference a;
            private CheckBoxPreference b;
            private CheckBoxPreference c;
            private CheckBoxPreference d;
            private CheckBoxPreference e;
            private CheckBoxPreference f;
            private CheckBoxPreference g;
            private CheckBoxPreference h;
            private CheckBoxPreference i;
            private CheckBoxPreference j;
            private e k;

            public final boolean onPreferenceClick(Preference preference)
            {
                int j1 = 1;
                if (a.isChecked())
                {
                    com.socialin.android.preference.e.b(k).edit().putBoolean("notifications_enable_mention", true).apply();
                    if (b.isChecked() && c.isChecked() && d.isChecked() && e.isChecked() && f.isChecked() && g.isChecked() && h.isChecked() && i.isChecked())
                    {
                        j.setChecked(true);
                    }
                } else
                {
                    com.socialin.android.preference.e.b(k).edit().putBoolean("notifications_enable_mention", false).apply();
                    j.setChecked(false);
                }
                preference = e.c(k).notificationParams;
                if (!a.isChecked())
                {
                    j1 = 0;
                }
                preference.mention = j1;
                return false;
            }

            
            {
                k = e.this;
                a = checkboxpreference;
                b = checkboxpreference1;
                c = checkboxpreference2;
                d = checkboxpreference3;
                e = checkboxpreference4;
                f = checkboxpreference5;
                g = checkboxpreference6;
                h = checkboxpreference7;
                i = checkboxpreference8;
                j = checkboxpreference9;
                super();
            }
        });
        checkboxpreference5.setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener(checkboxpreference5, checkboxpreference, checkboxpreference1, checkboxpreference2, checkboxpreference3, checkboxpreference4, checkboxpreference8, checkboxpreference6, checkboxpreference7, bundle) {

            private CheckBoxPreference a;
            private CheckBoxPreference b;
            private CheckBoxPreference c;
            private CheckBoxPreference d;
            private CheckBoxPreference e;
            private CheckBoxPreference f;
            private CheckBoxPreference g;
            private CheckBoxPreference h;
            private CheckBoxPreference i;
            private CheckBoxPreference j;
            private e k;

            public final boolean onPreferenceClick(Preference preference)
            {
                int j1 = 1;
                if (a.isChecked())
                {
                    com.socialin.android.preference.e.b(k).edit().putBoolean("notifications_enable_publishs", true).apply();
                    if (b.isChecked() && c.isChecked() && d.isChecked() && e.isChecked() && f.isChecked() && g.isChecked() && h.isChecked() && i.isChecked())
                    {
                        j.setChecked(true);
                    }
                } else
                {
                    com.socialin.android.preference.e.b(k).edit().putBoolean("notifications_enable_publishs", false).apply();
                    j.setChecked(false);
                }
                preference = e.c(k).notificationParams;
                if (!a.isChecked())
                {
                    j1 = 0;
                }
                preference.publish = j1;
                return false;
            }

            
            {
                k = e.this;
                a = checkboxpreference;
                b = checkboxpreference1;
                c = checkboxpreference2;
                d = checkboxpreference3;
                e = checkboxpreference4;
                f = checkboxpreference5;
                g = checkboxpreference6;
                h = checkboxpreference7;
                i = checkboxpreference8;
                j = checkboxpreference9;
                super();
            }
        });
        checkboxpreference8.setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener(checkboxpreference8, checkboxpreference, checkboxpreference1, checkboxpreference2, checkboxpreference3, checkboxpreference4, checkboxpreference5, checkboxpreference6, checkboxpreference7, bundle) {

            private CheckBoxPreference a;
            private CheckBoxPreference b;
            private CheckBoxPreference c;
            private CheckBoxPreference d;
            private CheckBoxPreference e;
            private CheckBoxPreference f;
            private CheckBoxPreference g;
            private CheckBoxPreference h;
            private CheckBoxPreference i;
            private CheckBoxPreference j;
            private e k;

            public final boolean onPreferenceClick(Preference preference)
            {
                boolean flag = true;
                int j1;
                if (a.isChecked())
                {
                    com.socialin.android.preference.e.b(k).edit().putBoolean("enable_facebook_notifications", true).apply();
                    com.socialin.android.preference.e.b(k).edit().putBoolean("enable_twitter_notifications", true).apply();
                    if (b.isChecked() && c.isChecked() && d.isChecked() && e.isChecked() && f.isChecked() && g.isChecked() && h.isChecked() && i.isChecked())
                    {
                        j.setChecked(true);
                    }
                } else
                {
                    com.socialin.android.preference.e.b(k).edit().putBoolean("enable_facebook_notifications", false).apply();
                    com.socialin.android.preference.e.b(k).edit().putBoolean("enable_twitter_notifications", false).apply();
                    j.setChecked(false);
                }
                preference = e.c(k).notificationParams;
                if (a.isChecked())
                {
                    j1 = 1;
                } else
                {
                    j1 = 0;
                }
                preference.suggestFb = j1;
                preference = e.c(k).notificationParams;
                if (a.isChecked())
                {
                    j1 = ((flag) ? 1 : 0);
                } else
                {
                    j1 = 0;
                }
                preference.suggestTwitter = j1;
                return false;
            }

            
            {
                k = e.this;
                a = checkboxpreference;
                b = checkboxpreference1;
                c = checkboxpreference2;
                d = checkboxpreference3;
                e = checkboxpreference4;
                f = checkboxpreference5;
                g = checkboxpreference6;
                h = checkboxpreference7;
                i = checkboxpreference8;
                j = checkboxpreference9;
                super();
            }
        });
        checkboxpreference6.setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener(checkboxpreference6, checkboxpreference, checkboxpreference1, checkboxpreference2, checkboxpreference3, checkboxpreference4, checkboxpreference5, checkboxpreference8, checkboxpreference7, bundle) {

            private CheckBoxPreference a;
            private CheckBoxPreference b;
            private CheckBoxPreference c;
            private CheckBoxPreference d;
            private CheckBoxPreference e;
            private CheckBoxPreference f;
            private CheckBoxPreference g;
            private CheckBoxPreference h;
            private CheckBoxPreference i;
            private CheckBoxPreference j;
            private e k;

            public final boolean onPreferenceClick(Preference preference)
            {
                int j1 = 1;
                if (a.isChecked())
                {
                    com.socialin.android.preference.e.b(k).edit().putBoolean("notifications_enable_follow", true).apply();
                    if (b.isChecked() && c.isChecked() && d.isChecked() && e.isChecked() && f.isChecked() && g.isChecked() && h.isChecked() && i.isChecked())
                    {
                        j.setChecked(true);
                    }
                } else
                {
                    com.socialin.android.preference.e.b(k).edit().putBoolean("notifications_enable_follow", false).apply();
                    j.setChecked(false);
                }
                preference = e.c(k).notificationParams;
                if (!a.isChecked())
                {
                    j1 = 0;
                }
                preference.follow = j1;
                return false;
            }

            
            {
                k = e.this;
                a = checkboxpreference;
                b = checkboxpreference1;
                c = checkboxpreference2;
                d = checkboxpreference3;
                e = checkboxpreference4;
                f = checkboxpreference5;
                g = checkboxpreference6;
                h = checkboxpreference7;
                i = checkboxpreference8;
                j = checkboxpreference9;
                super();
            }
        });
        checkboxpreference7.setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener(checkboxpreference7, checkboxpreference, checkboxpreference1, checkboxpreference2, checkboxpreference3, checkboxpreference4, checkboxpreference5, checkboxpreference8, checkboxpreference6, bundle) {

            private CheckBoxPreference a;
            private CheckBoxPreference b;
            private CheckBoxPreference c;
            private CheckBoxPreference d;
            private CheckBoxPreference e;
            private CheckBoxPreference f;
            private CheckBoxPreference g;
            private CheckBoxPreference h;
            private CheckBoxPreference i;
            private CheckBoxPreference j;
            private e k;

            public final boolean onPreferenceClick(Preference preference)
            {
                int j1 = 1;
                if (a.isChecked())
                {
                    com.socialin.android.preference.e.b(k).edit().putBoolean("notifications_enable_follow_me", true).apply();
                    if (b.isChecked() && c.isChecked() && d.isChecked() && e.isChecked() && f.isChecked() && g.isChecked() && h.isChecked() && i.isChecked())
                    {
                        j.setChecked(true);
                    }
                } else
                {
                    com.socialin.android.preference.e.b(k).edit().putBoolean("notifications_enable_follow_me", false).apply();
                    j.setChecked(false);
                }
                preference = e.c(k).notificationParams;
                if (!a.isChecked())
                {
                    j1 = 0;
                }
                preference.followMe = j1;
                return false;
            }

            
            {
                k = e.this;
                a = checkboxpreference;
                b = checkboxpreference1;
                c = checkboxpreference2;
                d = checkboxpreference3;
                e = checkboxpreference4;
                f = checkboxpreference5;
                g = checkboxpreference6;
                h = checkboxpreference7;
                i = checkboxpreference8;
                j = checkboxpreference9;
                super();
            }
        });
        checkboxpreference9.setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener(checkboxpreference9) {

            private CheckBoxPreference a;
            private e b;

            public final boolean onPreferenceClick(Preference preference)
            {
                int j1 = 1;
                boolean flag = SocialinV3.getInstance().getSettings().isAppboyEnabled();
                if (a.isChecked())
                {
                    com.socialin.android.preference.e.b(b).edit().putBoolean("enable_push_notifications", true).apply();
                    if (flag)
                    {
                        com.socialin.android.util.b.a(b.getActivity()).a(NotificationSubscriptionType.OPTED_IN);
                    }
                } else
                {
                    com.socialin.android.preference.e.b(b).edit().putBoolean("enable_push_notifications", false).apply();
                    if (flag)
                    {
                        com.socialin.android.util.b.a(b.getActivity()).a(NotificationSubscriptionType.UNSUBSCRIBED);
                    }
                }
                preference = e.c(b).notificationParams;
                if (!a.isChecked())
                {
                    j1 = 0;
                }
                preference.pushMe = j1;
                return false;
            }

            
            {
                b = e.this;
                a = checkboxpreference;
                super();
            }
        });
    }

    public final void onPause()
    {
        super.onPause();
        if (d != o.notificationParams.like || e != o.notificationParams.likeMe || f == o.notificationParams.repostMe || g == o.notificationParams.repostOther || i != o.notificationParams.comment || j != o.notificationParams.mention || h != o.notificationParams.publish || k != o.notificationParams.follow || l != o.notificationParams.followMe || m != o.notificationParams.suggestFb || m != o.notificationParams.suggestTwitter || n != o.notificationParams.pushMe)
        {
            if (a == null)
            {
                a = new g(getActivity());
                a.setMessage(getString(0x7f080573));
                a.setCancelable(true);
                a.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                    private e a;

                    public final void onCancel(DialogInterface dialoginterface)
                    {
                        a.getActivity().finish();
                    }

            
            {
                a = e.this;
                super();
            }
                });
            }
            myobfuscated.f.m.a(getActivity(), a);
            c.setRequestParams(o);
            c.setRequestCompleteListener(new d() {

                private e a;

                public final volatile void onCancelRequest(Object obj, Request request)
                {
                }

                public final void onFailure(Exception exception, Request request)
                {
                    myobfuscated.f.m.b(a.getActivity(), e.a(a));
                    if (a.getActivity() != null)
                    {
                        a.getActivity().setResult(-1);
                        a.getActivity().finish();
                    }
                }

                public final transient void onProgressUpdate(Integer ainteger[])
                {
                }

                public final void onSuccess(Object obj, Request request)
                {
                    myobfuscated.f.m.b(a.getActivity(), e.a(a));
                    if (a.getActivity() != null)
                    {
                        a.getActivity().setResult(-1);
                        a.getActivity().finish();
                    }
                }

            
            {
                a = e.this;
                super();
            }
            });
            c.doRequest();
            getActivity().runOnUiThread(new Runnable() {

                private e a;

                public final void run()
                {
                    Intent intent = new Intent();
                    intent.setClass(a.getActivity(), com/socialin/android/preference/PreferencesActivity);
                    a.startActivity(intent);
                }

            
            {
                a = e.this;
                super();
            }
            });
        }
    }
}
