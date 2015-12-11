// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;
import com.groupon.activity.Gifting;
import com.groupon.cookies.CookieFactory;
import com.groupon.util.SmuggleDealManager;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            BaseSecretSettingsFragment

public class SecretGeneralFragment extends BaseSecretSettingsFragment
{
    private class BCookieSettingsPreferenceChangeListener
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        private final String bCookieOptions[];
        private final ListPreference bCookieSettings;
        final SecretGeneralFragment this$0;

        public boolean onPreferenceChange(final Preference editor, Object obj)
        {
            editor = ((SharedPreferences)prefs.get()).edit();
            if (obj.toString().equals(bCookieOptions[0]) && !((SharedPreferences)prefs.get()).getString("systemGeneratedBCookie", "").equals(((CookieFactory)cookieFactory.get()).getBrowserCookie()))
            {
                ((CookieFactory)cookieFactory.get()).refreshBrowserCookie(getActivity(), ((SharedPreferences)prefs.get()).getString("systemGeneratedBCookie", null));
                bCookieSettings.setSummary(obj.toString());
                return true;
            }
            if (obj.toString().equals(bCookieOptions[1]))
            {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
                final EditText bCookieInput = new EditText(getActivity());
                builder.setView(bCookieInput);
                if (!((SharedPreferences)prefs.get()).getBoolean("isSystemGeneratedBCookie", true))
                {
                    bCookieInput.setText(((CookieFactory)cookieFactory.get()).getBrowserCookie());
                }
                builder.setPositiveButton(0x7f0804fe, ((_cls1) (obj)). new android.content.DialogInterface.OnClickListener() {

                    final BCookieSettingsPreferenceChangeListener this$1;
                    final EditText val$bCookieInput;
                    final android.content.SharedPreferences.Editor val$editor;
                    final Object val$newValue;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        if (((SharedPreferences)prefs.get()).getBoolean("isSystemGeneratedBCookie", true))
                        {
                            editor.putString("systemGeneratedBCookie", ((CookieFactory)cookieFactory.get()).getBrowserCookie());
                            editor.putBoolean("isSystemGeneratedBCookie", false);
                            editor.commit();
                        }
                        ((CookieFactory)cookieFactory.get()).refreshBrowserCookie(getActivity(), bCookieInput.getText().toString());
                        bCookieSettings.setSummary(newValue.toString());
                    }

            
            {
                this$1 = final_bcookiesettingspreferencechangelistener;
                editor = editor1;
                bCookieInput = edittext;
                newValue = Object.this;
                super();
            }
                });
                builder.setNegativeButton(0x7f080084, new android.content.DialogInterface.OnClickListener() {

                    final BCookieSettingsPreferenceChangeListener this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                    }

            
            {
                this$1 = BCookieSettingsPreferenceChangeListener.this;
                super();
            }
                });
                builder.create().show();
                return true;
            } else
            {
                ((CookieFactory)cookieFactory.get()).refreshBrowserCookie(getActivity(), null);
                bCookieSettings.setSummary(obj.toString());
                return true;
            }
        }


        public BCookieSettingsPreferenceChangeListener(String as[], ListPreference listpreference)
        {
            this$0 = SecretGeneralFragment.this;
            super();
            bCookieOptions = as;
            bCookieSettings = listpreference;
        }
    }

    private class ClearSmuggledDealsPreferenceClickListener
        implements android.preference.Preference.OnPreferenceClickListener
    {

        private final Preference clearChannelSmuggledDeals;
        final SecretGeneralFragment this$0;

        public boolean onPreferenceClick(Preference preference)
        {
            ((SmuggleDealManager)smuggleDealManager.get()).clearSmuggledDeals();
            clearChannelSmuggledDeals.notifyDependencyChange(false);
            return true;
        }

        public ClearSmuggledDealsPreferenceClickListener(Preference preference)
        {
            this$0 = SecretGeneralFragment.this;
            super();
            clearChannelSmuggledDeals = preference;
        }
    }

    private class DebuggableWebViewPreferenceClickListener
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        final SecretGeneralFragment this$0;

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            if (android.os.Build.VERSION.SDK_INT >= 19)
            {
                WebView.setWebContentsDebuggingEnabled(((Boolean)obj).booleanValue());
                return true;
            } else
            {
                return false;
            }
        }

        private DebuggableWebViewPreferenceClickListener()
        {
            this$0 = SecretGeneralFragment.this;
            super();
        }

    }

    private class ReportABugEmailPreferenceChangeListener
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        private final EditTextPreference reportABugEmail;
        final SecretGeneralFragment this$0;

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            if (Strings.isEmpty(obj))
            {
                ((SharedPreferences)prefs.get()).edit().remove("reportABugEmail").apply();
                reportABugEmail.setSummary("e.g. ex@mple.com");
            } else
            if (Gifting.isEmailValid(Strings.toString(obj)))
            {
                ((SharedPreferences)prefs.get()).edit().putString("reportABugEmail", Strings.toString(obj)).apply();
                reportABugEmail.setSummary(Strings.toString(obj));
            } else
            {
                Toast.makeText(getActivity(), "Invalid email.", 1).show();
                ((SharedPreferences)prefs.get()).edit().remove("reportABugEmail").apply();
                reportABugEmail.setSummary("e.g. ex@mple.com");
                return false;
            }
            return true;
        }

        public ReportABugEmailPreferenceChangeListener(EditTextPreference edittextpreference)
        {
            this$0 = SecretGeneralFragment.this;
            super();
            reportABugEmail = edittextpreference;
        }
    }

    private class SmuggledDealsPreferenceChangeListener
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        private final EditTextPreference smuggledDeals;
        final SecretGeneralFragment this$0;

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            if (Strings.isEmpty(obj))
            {
                smuggledDeals.setSummary("None");
                ((SharedPreferences)prefs.get()).edit().remove("smuggledDeals").apply();
            } else
            {
                smuggledDeals.setSummary(Strings.toString(obj));
                ((SharedPreferences)prefs.get()).edit().putString("smuggledDeals", Strings.toString(obj)).apply();
            }
            return true;
        }

        public SmuggledDealsPreferenceChangeListener(EditTextPreference edittextpreference)
        {
            this$0 = SecretGeneralFragment.this;
            super();
            smuggledDeals = edittextpreference;
        }
    }


    private static final String B_COOKIE_SETTINGS = "bCookieSettings";
    private static final String CLEAR_SMUGGLED_DEALS = "clearSmuggledDeals";
    private static final String PREFS_IS_SYSTEM_GENERATED_B_COOKIE = "isSystemGeneratedBCookie";
    private static final String PREFS_SYSTEM_GENERATED_B_COOKIE = "systemGeneratedBCookie";
    public static final String TAG = com/groupon/fragment/SecretGeneralFragment.getName();
    private Lazy cookieFactory;
    private Lazy smuggleDealManager;

    public SecretGeneralFragment()
    {
    }

    public void init()
    {
        super.init();
        smuggleDealManager = new Lazy(getActivity()) {

            final SecretGeneralFragment this$0;

            
            {
                this$0 = SecretGeneralFragment.this;
                super(context);
            }
        };
        cookieFactory = new Lazy(getActivity()) {

            final SecretGeneralFragment this$0;

            
            {
                this$0 = SecretGeneralFragment.this;
                super(context);
            }
        };
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = new Intent("android.intent.action.SEND");
        bundle.putExtra("android.intent.extra.SUBJECT", "[ANDROID] Please, add me to the Proximity based notification!");
        bundle.putExtra("android.intent.extra.EMAIL", new String[] {
            "maulik@groupon.com"
        });
        bundle.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append("clientBcookie: ").append(((CookieFactory)cookieFactory.get()).getBrowserCookie()).toString());
        bundle.setType("plain/text");
        Preference preference = new Preference(getActivity());
        preference.setTitle("Send bcookie by e-mail");
        preference.setIntent(bundle);
        getPreferenceScreen().addPreference(preference);
        bundle = new ListPreference(getActivity());
        bundle.setKey("bCookieSettings");
        bundle.setTitle("B Cookie Settings");
        bundle.setSummary(((SharedPreferences)prefs.get()).getString("bCookieSettings", getString(0x7f08052b)));
        String as[] = getResources().getStringArray(0x7f0f0000);
        bundle.setEntries(as);
        bundle.setEntryValues(as);
        bundle.setOnPreferenceChangeListener(new BCookieSettingsPreferenceChangeListener(as, bundle));
        getPreferenceScreen().addPreference(bundle);
        bundle = new EditTextPreference(getActivity()) {

            final SecretGeneralFragment this$0;

            protected void onBindView(View view)
            {
                if (findPreferenceInHierarchy("clearSmuggledDeals") != null)
                {
                    setDependency("clearSmuggledDeals");
                }
                super.onBindView(view);
            }

            public void onDependencyChanged(Preference preference1, boolean flag)
            {
                super.onDependencyChanged(preference1, flag);
                preference1 = ((SharedPreferences)prefs.get()).getString("smuggledDeals", null);
                setText(preference1);
                callChangeListener(preference1);
            }

            
            {
                this$0 = SecretGeneralFragment.this;
                super(context);
            }
        };
        bundle.setKey("smuggledDeals");
        bundle.setTitle("Deals to smuggle in");
        bundle.setSummary(((SharedPreferences)prefs.get()).getString("smuggledDeals", "None"));
        bundle.setOnPreferenceChangeListener(new SmuggledDealsPreferenceChangeListener(bundle));
        getPreferenceScreen().addPreference(bundle);
        bundle = new Preference(getActivity());
        bundle.setKey("clearSmuggledDeals");
        bundle.setTitle("Clear deals smuggled into channels");
        bundle.setOnPreferenceClickListener(new ClearSmuggledDealsPreferenceClickListener(bundle));
        getPreferenceScreen().addPreference(bundle);
        bundle = new CheckBoxPreference(getActivity());
        bundle.setTitle("Show Admin in Menus");
        bundle.setKey("adminMenuEnabled");
        getPreferenceScreen().addPreference(bundle);
        bundle = new CheckBoxPreference(getActivity());
        bundle.setTitle("Show Refresh Menu");
        bundle.setSummary("Add 'Refresh' menu item to DealDetails and other activities that use sync managers.  Menu item flushes cached data and fetches new data from server.");
        bundle.setDefaultValue(Boolean.valueOf(false));
        bundle.setKey("showActivityRefreshMenuItem");
        getPreferenceScreen().addPreference(bundle);
        bundle = new EditTextPreference(getActivity());
        bundle.setKey("reportABugEmail");
        bundle.setTitle("Report A Bug Email");
        bundle.setSummary(((SharedPreferences)prefs.get()).getString("reportABugEmail", "e.g. ex@mple.com"));
        bundle.setOnPreferenceChangeListener(new ReportABugEmailPreferenceChangeListener(bundle));
        getPreferenceScreen().addPreference(bundle);
        bundle = new CheckBoxPreference(getActivity());
        bundle.setTitle("Hide Notifications for Viewed Deals");
        bundle.setSummary("Suppress Notifications for Already Viewed Deals");
        bundle.setDefaultValue(Boolean.valueOf(true));
        bundle.setKey("hidePreviouslySeenDealsFromNotifications");
        getPreferenceScreen().addPreference(bundle);
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            bundle = newCheckBox("enableDebuggableWebViews", "Enable Debuggable WebViews", Boolean.valueOf(false));
            bundle.setOnPreferenceChangeListener(new DebuggableWebViewPreferenceClickListener());
            getPreferenceScreen().addPreference(bundle);
        }
    }



}
