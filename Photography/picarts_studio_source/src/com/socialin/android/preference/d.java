// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.preference;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.view.View;
import android.widget.RadioButton;
import com.picsart.studio.PicsartContext;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.AppProps;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.model.parsers.StringParser;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.dialog.e;
import com.socialin.android.dialog.f;
import com.socialin.android.dialog.g;
import com.socialin.android.picsart.profile.util.GalleryUtils;
import com.socialin.android.picsart.profile.util.aa;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.a;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.cache.CacheManager;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import myobfuscated.cv.c;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.preference:
//            FBActionPreferencesActivity, GPActionPreferencesActivity, SharePreferencesActivity, ContentPreferencesActivity

public final class d extends PreferenceFragment
{

    private android.preference.Preference.OnPreferenceClickListener a;
    private android.preference.Preference.OnPreferenceClickListener b;
    private android.preference.Preference.OnPreferenceClickListener c;
    private android.preference.Preference.OnPreferenceClickListener d;
    private boolean e;

    public d()
    {
        a = new android.preference.Preference.OnPreferenceClickListener() {

            private d a;

            public final boolean onPreferenceClick(Preference preference)
            {
                GalleryUtils.a(a.getActivity(), com.socialin.android.picsart.profile.util.GalleryUtils.PreferencesAbout.Terms);
                return false;
            }

            
            {
                a = d.this;
                super();
            }
        };
        b = new android.preference.Preference.OnPreferenceClickListener() {

            private d a;

            public final boolean onPreferenceClick(Preference preference)
            {
                GalleryUtils.a(a.getActivity(), com.socialin.android.picsart.profile.util.GalleryUtils.PreferencesAbout.License);
                return false;
            }

            
            {
                a = d.this;
                super();
            }
        };
        c = new android.preference.Preference.OnPreferenceClickListener() {

            private d a;

            public final boolean onPreferenceClick(Preference preference)
            {
                GalleryUtils.a(a.getActivity(), com.socialin.android.picsart.profile.util.GalleryUtils.PreferencesAbout.PrivacyPolicy);
                return false;
            }

            
            {
                a = d.this;
                super();
            }
        };
        d = new android.preference.Preference.OnPreferenceClickListener() {

            private d a;

            public final boolean onPreferenceClick(Preference preference)
            {
                GalleryUtils.a(a.getActivity(), com.socialin.android.picsart.profile.util.GalleryUtils.PreferencesAbout.DMCA);
                return false;
            }

            
            {
                a = d.this;
                super();
            }
        };
        e = false;
    }

    static long a(String s)
    {
        return a(s, true);
    }

    private static long a(String s, boolean flag)
    {
        long l = System.currentTimeMillis();
        s = new Request(s, StringParser.instance());
        s.c("Host", "api.picsart.com");
        try
        {
            s.d();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        return System.currentTimeMillis() - l;
    }

    public final void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (j != -1) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 116 117: default 36
    //                   116 37
    //                   117 53;
           goto _L2 _L3 _L4
_L2:
        return;
_L3:
        getActivity().setResult(-1);
        getActivity().finish();
        return;
_L4:
        e = true;
        return;
    }

    public final void onCreate(Bundle bundle)
    {
        boolean flag1;
        flag1 = true;
        super.onCreate(bundle);
        addPreferencesFromResource(0x7f060007);
        AnalyticUtils.getInstance(getActivity()).trackLocalAction("pref:onCreate");
        CheckBoxPreference checkboxpreference;
        Object obj1;
        boolean flag;
        boolean flag2;
        if ((getActivity().getApplicationInfo().flags & 2) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag2 = "true".equals(getString(0x7f08091d));
        if (flag || flag2)
        {
            Object obj = (PreferenceScreen)findPreference("pref_screen_main");
            bundle = new PreferenceCategory(getActivity());
            bundle.setTitle("Development");
            ((PreferenceScreen) (obj)).addPreference(bundle);
            obj = new Preference(getActivity());
            bundle.addPreference(((Preference) (obj)));
            ((Preference) (obj)).setTitle("API: api.picsart.com");
            ((Preference) (obj)).setSummary(getString(0x7f08043d));
            (new Thread(((Preference) (obj))) {

                final Preference a;
                private d b;

                public final void run()
                {
                    InetAddress ainetaddress[] = InetAddress.getAllByName("api.picsart.com");
                    String s = "IPs: ";
                    int j = ainetaddress.length;
                    int i = 0;
_L2:
                    InetAddress inetaddress;
                    if (i >= j)
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    inetaddress = ainetaddress[i];
                    s = (new StringBuilder()).append(s).append(inetaddress.getHostAddress()).append(", ").toString();
                    i++;
                    if (true) goto _L2; else goto _L1
_L1:
                    try
                    {
                        if (b.getActivity() != null)
                        {
                            b.getActivity().runOnUiThread(new Runnable(this, s) {

                                private String a;
                                private _cls15 b;

                                public final void run()
                                {
                                    b.a.setSummary(a);
                                }

            
            {
                b = _pcls15;
                a = s;
                super();
            }
                            });
                        }
                        return;
                    }
                    catch (UnknownHostException unknownhostexception)
                    {
                        unknownhostexception.printStackTrace();
                    }
                    return;
                }

            
            {
                b = d.this;
                a = preference;
                super();
            }
            }).start();
            obj = new Preference(getActivity());
            ((Preference) (obj)).setTitle("CDN: cdn.picsart.com");
            ((Preference) (obj)).setSummary(getString(0x7f08043d));
            bundle.addPreference(((Preference) (obj)));
            (new Thread(((Preference) (obj))) {

                final Preference a;
                private d b;

                public final void run()
                {
                    InetAddress ainetaddress[] = InetAddress.getAllByName("cdn.picsart.com");
                    String s = "IPs: ";
                    int j = ainetaddress.length;
                    int i = 0;
_L2:
                    InetAddress inetaddress;
                    if (i >= j)
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    inetaddress = ainetaddress[i];
                    s = (new StringBuilder()).append(s).append(inetaddress.getHostAddress()).append(", ").toString();
                    i++;
                    if (true) goto _L2; else goto _L1
_L1:
                    try
                    {
                        if (b.getActivity() != null)
                        {
                            b.getActivity().runOnUiThread(new Runnable(this, s) {

                                private String a;
                                private _cls16 b;

                                public final void run()
                                {
                                    b.a.setSummary(a);
                                }

            
            {
                b = _pcls16;
                a = s;
                super();
            }
                            });
                        }
                        return;
                    }
                    catch (UnknownHostException unknownhostexception)
                    {
                        unknownhostexception.printStackTrace();
                    }
                    return;
                }

            
            {
                b = d.this;
                a = preference;
                super();
            }
            }).start();
            obj = new Preference(getActivity());
            ((Preference) (obj)).setTitle("BaseApi URL");
            ((Preference) (obj)).setSummary(getString(0x7f08043d));
            bundle.addPreference(((Preference) (obj)));
            (new Thread(((Preference) (obj))) {

                final Preference a;
                private d b;

                public final void run()
                {
                    SocialinV3 socialinv3 = SocialinV3.getInstance();
                    if (socialinv3.getAppProps().getData().api != null && socialinv3.getAppProps().getData().api.baseUrl != null)
                    {
                        long l = com.socialin.android.preference.d.a(socialinv3.getAppProps().getData().api.baseUrl);
                        if (b.getActivity() != null)
                        {
                            b.getActivity().runOnUiThread(new Runnable(this, socialinv3, l) {

                                private SocialinV3 a;
                                private long b;
                                private _cls17 c;

                                public final void run()
                                {
                                    c.a.setSummary((new StringBuilder()).append(a.getAppProps().getData().api.baseUrl).append(" latency: ").append(b).toString());
                                }

            
            {
                c = _pcls17;
                a = socialinv3;
                b = l;
                super();
            }
                            });
                            return;
                        }
                    }
                }

            
            {
                b = d.this;
                a = preference;
                super();
            }
            }).start();
            obj = new Preference(getActivity());
            ((Preference) (obj)).setTitle("BackupApi URL");
            ((Preference) (obj)).setSummary(getString(0x7f08043d));
            bundle.addPreference(((Preference) (obj)));
            (new Thread(((Preference) (obj))) {

                final Preference a;
                private d b;

                public final void run()
                {
                    SocialinV3 socialinv3 = SocialinV3.getInstance();
                    if (socialinv3.getAppProps().getData().api != null && socialinv3.getAppProps().getData().api.retryUrl != null)
                    {
                        long l = com.socialin.android.preference.d.a(socialinv3.getAppProps().getData().api.retryUrl);
                        if (b.getActivity() != null)
                        {
                            b.getActivity().runOnUiThread(new Runnable(this, socialinv3, l) {

                                private SocialinV3 a;
                                private long b;
                                private _cls18 c;

                                public final void run()
                                {
                                    c.a.setSummary((new StringBuilder()).append(a.getAppProps().getData().api.retryUrl).append(" latency: ").append(b).toString());
                                }

            
            {
                c = _pcls18;
                a = socialinv3;
                b = l;
                super();
            }
                            });
                            return;
                        }
                    }
                }

            
            {
                b = d.this;
                a = preference;
                super();
            }
            }).start();
            obj = new CheckBoxPreference(getActivity());
            SharedPreferences sharedpreferences = getActivity().getSharedPreferences("analyticsEventLoggingDebugMode", 4);
            android.content.SharedPreferences.Editor editor = sharedpreferences.edit();
            ((CheckBoxPreference) (obj)).setTitle("Enable analytics logging");
            ((CheckBoxPreference) (obj)).setSummary(SocialinV3.getInstance().getDeviceId());
            ((CheckBoxPreference) (obj)).setChecked(sharedpreferences.getBoolean("analyticsEventLoggingEnabled", true));
            editor.putBoolean("analyticsEventLoggingEnabled", flag2);
            editor.apply();
            ((CheckBoxPreference) (obj)).setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener(((CheckBoxPreference) (obj)), editor) {

                private CheckBoxPreference a;
                private android.content.SharedPreferences.Editor b;

                public final boolean onPreferenceClick(Preference preference)
                {
                    if (a.isChecked())
                    {
                        b.putBoolean("analyticsEventLoggingEnabled", true);
                    } else
                    {
                        b.putBoolean("analyticsEventLoggingEnabled", false);
                    }
                    b.apply();
                    return false;
                }

            
            {
                a = checkboxpreference;
                b = editor;
                super();
            }
            });
            bundle.addPreference(((Preference) (obj)));
        }
        findPreference("pref_facebook_connections").setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener() {

            private d a;

            public final boolean onPreferenceClick(Preference preference)
            {
                AnalyticUtils.getInstance(a.getActivity()).trackLocalAction("pref:social_connections");
                myobfuscated.cv.c.c(a.getActivity());
                return false;
            }

            
            {
                a = d.this;
                super();
            }
        });
        findPreference("pref_facebook_actions").setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener() {

            private d a;

            public final boolean onPreferenceClick(Preference preference)
            {
                AnalyticUtils.getInstance(a.getActivity()).trackLocalAction("pref:facebook_actions");
                preference = new Intent();
                preference.setClass(a.getActivity(), com/socialin/android/preference/FBActionPreferencesActivity);
                a.startActivity(preference);
                return false;
            }

            
            {
                a = d.this;
                super();
            }
        });
        if (!getString(0x7f0808c8).equals(getString(0x7f0808ce)))
        {
            findPreference("pref_googleplus_actions").setEnabled(false);
        } else
        {
            findPreference("pref_googleplus_actions").setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener() {

                private d a;

                public final boolean onPreferenceClick(Preference preference)
                {
                    AnalyticUtils.getInstance(a.getActivity()).trackLocalAction("pref:googleplus_actions");
                    preference = new Intent();
                    preference.setClass(a.getActivity(), com/socialin/android/preference/GPActionPreferencesActivity);
                    a.startActivity(preference);
                    return false;
                }

            
            {
                a = d.this;
                super();
            }
            });
        }
        findPreference("pref_notification_settings").setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener() {

            private d a;

            public final boolean onPreferenceClick(Preference preference)
            {
                AnalyticUtils.getInstance(a.getActivity()).trackLocalAction("pref:notifications");
                preference = new Intent();
                preference.setClass(a.getActivity(), com/socialin/android/preference/SharePreferencesActivity);
                a.startActivityForResult(preference, 116);
                return false;
            }

            
            {
                a = d.this;
                super();
            }
        });
        bundle = findPreference("pref_content_settings");
        if (!SocialinV3.getInstance().getSettings().isMatureContentEnabled() || getString(0x7f0808c8).equals(getString(0x7f0808d3)))
        {
            ((PreferenceCategory)findPreference("pref_category_content")).removePreference(bundle);
        } else
        {
            bundle.setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener() {

                private d a;

                public final boolean onPreferenceClick(Preference preference)
                {
                    AnalyticUtils.getInstance(a.getActivity()).trackLocalAction("pref:content-settings");
                    preference = new Intent();
                    preference.setClass(a.getActivity(), com/socialin/android/preference/ContentPreferencesActivity);
                    a.startActivityForResult(preference, 117);
                    return false;
                }

            
            {
                a = d.this;
                super();
            }
            });
        }
        findPreference("pref_web_cache").setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener() {

            final d a;

            public final boolean onPreferenceClick(Preference preference)
            {
                AnalyticUtils.getInstance(a.getActivity()).trackLocalAction("pref:pref_web_cache");
                preference = new f(a.getActivity());
                preference.a = a.getString(0x7f080521);
                preference.b = a.getString(0x7f080051);
                preference.a(new android.view.View.OnClickListener(this) {

                    final _cls7 a;

                    public final void onClick(View view)
                    {
                        (new Thread(this, g.a(a.a.getActivity(), a.a.getString(0x7f080450), a.a.getString(0x7f08041a))) {

                            private g a;
                            private _cls1 b;

                            public final void run()
                            {
                                com.socialin.android.util.m.a();
                                FileUtils.a(new File(com.socialin.android.photo.g.a(b.a.a.getActivity())));
                                CacheManager.a().c();
                                m.b(b.a.a.getActivity(), a);
                            }

            
            {
                b = _pcls1;
                a = g1;
                super();
            }
                        }).start();
                    }

            
            {
                a = _pcls7;
                super();
            }
                }).a().show();
                return false;
            }

            
            {
                a = d.this;
                super();
            }
        });
        findPreference("pref_search_history").setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener() {

            final d a;

            public final boolean onPreferenceClick(Preference preference)
            {
                AnalyticUtils.getInstance(a.getActivity()).trackLocalAction("pref:pref_search_history");
                preference = new f(a.getActivity());
                preference.a = a.getString(0x7f08051c);
                preference.b = a.getString(0x7f080051);
                preference.a(new android.view.View.OnClickListener(this) {

                    final _cls8 a;

                    public final void onClick(View view)
                    {
                        (new Thread(this, g.a(a.a.getActivity(), a.a.getString(0x7f080450), a.a.getString(0x7f08041a))) {

                            private g a;
                            private _cls1 b;

                            public final void run()
                            {
                                aa.c(b.a.a.getActivity());
                                m.b(b.a.a.getActivity(), a);
                            }

            
            {
                b = _pcls1;
                a = g;
                super();
            }
                        }).start();
                    }

            
            {
                a = _pcls8;
                super();
            }
                }).a().show();
                return false;
            }

            
            {
                a = d.this;
                super();
            }
        });
        if (!getActivity().getSharedPreferences("socialin", 0).getBoolean("wifi_only_upload", false))
        {
            ((CheckBoxPreference)findPreference("pref_wifi_settings")).setChecked(false);
        } else
        {
            ((CheckBoxPreference)findPreference("pref_wifi_settings")).setChecked(true);
        }
        findPreference("pref_wifi_settings").setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener() {

            private d a;

            public final boolean onPreferenceClick(Preference preference)
            {
                boolean flag3 = ((CheckBoxPreference)a.findPreference("pref_wifi_settings")).isChecked();
                a.getActivity().getSharedPreferences("socialin", 0).edit().putBoolean("wifi_only_upload", flag3).apply();
                return false;
            }

            
            {
                a = d.this;
                super();
            }
        });
        findPreference("pref_terms").setOnPreferenceClickListener(a);
        findPreference("pref_license").setOnPreferenceClickListener(b);
        findPreference("pref_privacy").setOnPreferenceClickListener(c);
        findPreference("pref_dmca").setOnPreferenceClickListener(d);
        if (m.e()) goto _L2; else goto _L1
_L1:
        obj1 = new a(getActivity().getApplicationContext());
        bundle = new Preference(getActivity());
        bundle.setTitle(0x7f080519);
        PicsartContext.a(getActivity()) / 0x100000;
        JVM INSTR tableswitch 3 8: default 764
    //                   3 950
    //                   4 964
    //                   5 978
    //                   6 992
    //                   7 1006
    //                   8 1020;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L3:
        break; /* Loop/switch isn't completed */
_L9:
        break MISSING_BLOCK_LABEL_1020;
_L10:
        bundle.setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener(bundle) {

            final Preference a;
            final d b;

            public final boolean onPreferenceClick(Preference preference)
            {
                preference = new f(b.getActivity());
                preference.e = 0x7f0300a1;
                preference.a = b.getResources().getString(0x7f0800c3);
                preference.g = false;
                String s = b.getResources().getString(0x7f080311);
                if (s != null)
                {
                    preference.c = s;
                }
                preference.f = true;
                preference = preference.a(new android.view.View.OnClickListener(this) {

                    private _cls10 a;

                    public final void onClick(View view)
                    {
                        if (((RadioButton)view.getRootView().findViewById(0x7f100377)).isChecked())
                        {
                            PicsartContext.a(a.b.getActivity(), 0x400000);
                            a.a.setSummary(a.b.getString(0x7f08038c));
                        } else
                        {
                            if (((RadioButton)view.getRootView().findViewById(0x7f100378)).isChecked())
                            {
                                PicsartContext.a(a.b.getActivity(), 0x400000);
                                a.a.setSummary(a.b.getString(0x7f08038d));
                                return;
                            }
                            if (((RadioButton)view.getRootView().findViewById(0x7f100379)).isChecked())
                            {
                                PicsartContext.a(a.b.getActivity(), 0x500000);
                                a.a.setSummary(a.b.getString(0x7f08038e));
                                return;
                            }
                            if (((RadioButton)view.getRootView().findViewById(0x7f10037a)).isChecked())
                            {
                                PicsartContext.a(a.b.getActivity(), 0x600000);
                                a.a.setSummary(a.b.getString(0x7f08038f));
                                return;
                            }
                            if (((RadioButton)view.getRootView().findViewById(0x7f10037b)).isChecked())
                            {
                                PicsartContext.a(a.b.getActivity(), 0x700000);
                                a.a.setSummary(a.b.getString(0x7f080390));
                                return;
                            }
                            if (((RadioButton)view.getRootView().findViewById(0x7f10037c)).isChecked())
                            {
                                PicsartContext.a(a.b.getActivity(), 0x800000);
                                a.a.setSummary(a.b.getString(0x7f080391));
                                return;
                            }
                        }
                    }

            
            {
                a = _pcls10;
                super();
            }
                }).a();
                PicsartContext.a(b.getActivity()) / 0x100000;
                JVM INSTR tableswitch 3 8: default 136
            //                           3 241
            //                           4 257
            //                           5 273
            //                           6 289
            //                           7 305
            //                           8 321;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
                if (PicsartContext.a.getMaxImageSizeMegapixel() < 5)
                {
                    ((RadioButton)preference.findViewById(0x7f100379)).setVisibility(8);
                }
                if (PicsartContext.a.getMaxImageSizeMegapixel() < 6)
                {
                    ((RadioButton)preference.findViewById(0x7f10037a)).setVisibility(8);
                }
                if (PicsartContext.a.getMaxImageSizeMegapixel() < 7)
                {
                    ((RadioButton)preference.findViewById(0x7f10037b)).setVisibility(8);
                }
                if (PicsartContext.a.getMaxImageSizeMegapixel() < 8)
                {
                    ((RadioButton)preference.findViewById(0x7f10037c)).setVisibility(8);
                }
                preference.show();
                return true;
_L2:
                ((RadioButton)preference.findViewById(0x7f100377)).setChecked(true);
                continue; /* Loop/switch isn't completed */
_L3:
                ((RadioButton)preference.findViewById(0x7f100378)).setChecked(true);
                continue; /* Loop/switch isn't completed */
_L4:
                ((RadioButton)preference.findViewById(0x7f100379)).setChecked(true);
                continue; /* Loop/switch isn't completed */
_L5:
                ((RadioButton)preference.findViewById(0x7f10037a)).setChecked(true);
                continue; /* Loop/switch isn't completed */
_L6:
                ((RadioButton)preference.findViewById(0x7f10037b)).setChecked(true);
                continue; /* Loop/switch isn't completed */
_L7:
                ((RadioButton)preference.findViewById(0x7f10037c)).setChecked(true);
                if (true) goto _L1; else goto _L8
_L8:
            }

            
            {
                b = d.this;
                a = preference;
                super();
            }
        });
        checkboxpreference = new CheckBoxPreference(getActivity());
        checkboxpreference.setTitle(0x7f08051e);
        if (((a) (obj1)).b("prefs.rec.size.donotshow"))
        {
            flag1 = false;
        }
        checkboxpreference.setChecked(flag1);
        checkboxpreference.setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener(((a) (obj1))) {

            private a a;

            public final boolean onPreferenceChange(Preference preference, Object obj2)
            {
                boolean flag4 = false;
                boolean flag5 = ((Boolean)obj2).booleanValue();
                obj2 = a;
                boolean flag3;
                if (!flag5)
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
                ((a) (obj2)).a("prefs.rec.size.donotshow", flag3);
                preference = AnalyticUtils.getInstance(preference.getContext());
                flag3 = flag4;
                if (!flag5)
                {
                    flag3 = true;
                }
                preference.track(new com.socialin.android.apiv3.events.EventsFactory.HighResDialogNotShowAgainEvent(flag3));
                return true;
            }

            
            {
                a = a1;
                super();
            }
        });
        obj1 = (PreferenceCategory)findPreference("pref_caretory_gen");
        ((PreferenceCategory) (obj1)).addPreference(bundle);
        ((PreferenceCategory) (obj1)).addPreference(checkboxpreference);
_L2:
        if (getString(0x7f0808c8).equalsIgnoreCase(getString(0x7f0808cc)))
        {
            ((PreferenceScreen)findPreference("pref_screen_main")).removePreference((PreferenceCategory)findPreference("social_connections"));
        } else
        if (getString(0x7f0808c8).equalsIgnoreCase(getString(0x7f0808ca)))
        {
            ((PreferenceScreen)findPreference("pref_screen_main")).removePreference(findPreference("pref_googleplus_actions"));
            return;
        }
        return;
_L4:
        bundle.setSummary(getString(0x7f08038c));
          goto _L10
_L5:
        bundle.setSummary(getString(0x7f08038d));
          goto _L10
_L6:
        bundle.setSummary(getString(0x7f08038e));
          goto _L10
_L7:
        bundle.setSummary(getString(0x7f08038f));
          goto _L10
_L8:
        bundle.setSummary(getString(0x7f080390));
          goto _L10
        bundle.setSummary(getString(0x7f080391));
          goto _L10
    }

    public final void onPause()
    {
        super.onPause();
        if (e)
        {
            getActivity().setResult(-1);
            getActivity().finish();
        }
    }
}
