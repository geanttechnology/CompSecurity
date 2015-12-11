// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import com.groupon.service.LoginService;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            BaseSecretSettingsFragment

public class SecretApiUrlFragment extends BaseSecretSettingsFragment
{
    private class AsUrlPreferenceChangeListener
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        private final EditTextPreference baseASUrl;
        final SecretApiUrlFragment this$0;

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            baseASUrl.setSummary(Strings.toString(obj));
            ((SharedPreferences)prefs.get()).edit().putString("base_url_as", Strings.toString(obj)).apply();
            ((LoginService)loginService.get()).logout();
            return true;
        }

        public AsUrlPreferenceChangeListener(EditTextPreference edittextpreference)
        {
            this$0 = SecretApiUrlFragment.this;
            super();
            baseASUrl = edittextpreference;
        }
    }

    private class ClUrlPreferenceChangeListener
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        private final EditTextPreference baseCLUrl;
        final SecretApiUrlFragment this$0;

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            baseCLUrl.setSummary(Strings.toString(obj));
            ((LoginService)loginService.get()).logout();
            return true;
        }

        public ClUrlPreferenceChangeListener(EditTextPreference edittextpreference)
        {
            this$0 = SecretApiUrlFragment.this;
            super();
            baseCLUrl = edittextpreference;
        }
    }

    private class ConfigurableUrlPreferenceChangeListener
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        private final ListPreference baseUrl;
        final SecretApiUrlFragment this$0;
        private final String urlKey;

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            baseUrl.setSummary(Strings.toString(obj));
            ((SharedPreferences)prefs.get()).edit().putString(urlKey, Strings.toString(obj)).apply();
            return true;
        }

        public ConfigurableUrlPreferenceChangeListener(ListPreference listpreference, String s)
        {
            this$0 = SecretApiUrlFragment.this;
            super();
            baseUrl = listpreference;
            urlKey = s;
        }
    }

    private class EuUrlPreferenceChangeListener
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        private final EditTextPreference baseEUUrl;
        final SecretApiUrlFragment this$0;

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            baseEUUrl.setSummary(Strings.toString(obj));
            ((SharedPreferences)prefs.get()).edit().putString("base_url_eu", Strings.toString(obj)).apply();
            ((LoginService)loginService.get()).logout();
            return true;
        }

        public EuUrlPreferenceChangeListener(EditTextPreference edittextpreference)
        {
            this$0 = SecretApiUrlFragment.this;
            super();
            baseEUUrl = edittextpreference;
        }
    }

    private class GdtUrlPreferenceChangeListener
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        private final EditTextPreference gdtBaseUrl;
        final SecretApiUrlFragment this$0;

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            gdtBaseUrl.setSummary(Strings.toString(obj));
            ((LoginService)loginService.get()).logout();
            return true;
        }

        public GdtUrlPreferenceChangeListener(EditTextPreference edittextpreference)
        {
            this$0 = SecretApiUrlFragment.this;
            super();
            gdtBaseUrl = edittextpreference;
        }
    }

    private class InUrlPreferenceChangeListener
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        private final EditTextPreference baseINUrl;
        final SecretApiUrlFragment this$0;

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            baseINUrl.setSummary(Strings.toString(obj));
            ((LoginService)loginService.get()).logout();
            return true;
        }

        public InUrlPreferenceChangeListener(EditTextPreference edittextpreference)
        {
            this$0 = SecretApiUrlFragment.this;
            super();
            baseINUrl = edittextpreference;
        }
    }

    private class JpUrlPreferenceChangeListener
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        private final EditTextPreference baseJPUrl;
        final SecretApiUrlFragment this$0;

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            baseJPUrl.setSummary(Strings.toString(obj));
            ((LoginService)loginService.get()).logout();
            return true;
        }

        public JpUrlPreferenceChangeListener(EditTextPreference edittextpreference)
        {
            this$0 = SecretApiUrlFragment.this;
            super();
            baseJPUrl = edittextpreference;
        }
    }

    private static class PogUrlPreferenceChangeListener
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        private final EditTextPreference webBasePoGUrl;

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            webBasePoGUrl.setSummary(Strings.toString(obj));
            return true;
        }

        public PogUrlPreferenceChangeListener(EditTextPreference edittextpreference)
        {
            webBasePoGUrl = edittextpreference;
        }
    }

    private class RapiUrlPreferenceChangeListener
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        private final EditTextPreference baseRapiUrl;
        final SecretApiUrlFragment this$0;

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            baseRapiUrl.setSummary(Strings.toString(obj));
            ((SharedPreferences)prefs.get()).edit().putString("baseRapiUrl", Strings.toString(obj)).apply();
            ((LoginService)loginService.get()).logout();
            return true;
        }

        public RapiUrlPreferenceChangeListener(EditTextPreference edittextpreference)
        {
            this$0 = SecretApiUrlFragment.this;
            super();
            baseRapiUrl = edittextpreference;
        }
    }

    private class RuPaymentUrlPreferenceChangeListener
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        private final EditTextPreference baseRUPaymentUrl;
        final SecretApiUrlFragment this$0;

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            baseRUPaymentUrl.setSummary(Strings.toString(obj));
            ((LoginService)loginService.get()).logout();
            return true;
        }

        public RuPaymentUrlPreferenceChangeListener(EditTextPreference edittextpreference)
        {
            this$0 = SecretApiUrlFragment.this;
            super();
            baseRUPaymentUrl = edittextpreference;
        }
    }

    private class RuUrlPreferenceChangeListener
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        private final EditTextPreference baseRUUrl;
        final SecretApiUrlFragment this$0;

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            baseRUUrl.setSummary(Strings.toString(obj));
            ((LoginService)loginService.get()).logout();
            return true;
        }

        public RuUrlPreferenceChangeListener(EditTextPreference edittextpreference)
        {
            this$0 = SecretApiUrlFragment.this;
            super();
            baseRUUrl = edittextpreference;
        }
    }

    private class UsUrlPreferenceChangeListener
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        private final EditTextPreference baseUSUrl;
        final SecretApiUrlFragment this$0;

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            baseUSUrl.setSummary(Strings.toString(obj));
            ((SharedPreferences)prefs.get()).edit().putString("baseUrl", Strings.toString(obj)).apply();
            ((LoginService)loginService.get()).logout();
            return true;
        }

        public UsUrlPreferenceChangeListener(EditTextPreference edittextpreference)
        {
            this$0 = SecretApiUrlFragment.this;
            super();
            baseUSUrl = edittextpreference;
        }
    }


    public static final String TAG = com/groupon/fragment/SecretApiUrlFragment.getName();
    public static final String WEBVIEW_BASE_URL = "webview_base_url";
    public static final String WEBVIEW_BASE_URL_SUMMARY = "eg: https://groupon.com";
    public static final String WEBVIEW_BASE_URL_TITLE = "WebView Base URL";

    public SecretApiUrlFragment()
    {
    }

    private ListPreference createConfigurableUrlPreference(String s, String s1, String as[], String s2)
    {
        ListPreference listpreference = new ListPreference(getActivity());
        listpreference.setKey(s);
        listpreference.setTitle(s2);
        listpreference.setSummary(((SharedPreferences)prefs.get()).getString(s, s1));
        listpreference.setEntries(as);
        listpreference.setEntryValues(as);
        listpreference.setOnPreferenceChangeListener(new ConfigurableUrlPreferenceChangeListener(listpreference, s));
        return listpreference;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = new PreferenceCategory(getActivity());
        bundle.setTitle("Features");
        getPreferenceScreen().addPreference(bundle);
        Object obj = new CheckBoxPreference(getActivity());
        ((CheckBoxPreference) (obj)).setTitle("Google Wallet");
        ((CheckBoxPreference) (obj)).setSummary("Use Sandbox environment");
        ((CheckBoxPreference) (obj)).setDefaultValue(Boolean.valueOf(false));
        ((CheckBoxPreference) (obj)).setKey("googleWalletSandboxEnabled");
        bundle.addPreference(((Preference) (obj)));
        obj = new CheckBoxPreference(getActivity());
        ((CheckBoxPreference) (obj)).setTitle("PoG webview");
        ((CheckBoxPreference) (obj)).setSummary("Use Test Webview");
        ((CheckBoxPreference) (obj)).setDefaultValue(Boolean.valueOf(false));
        ((CheckBoxPreference) (obj)).setKey("enable_pog_test_webview");
        bundle.addPreference(((Preference) (obj)));
        obj = new EditTextPreference(getActivity());
        ((EditTextPreference) (obj)).setKey("baseRapiUrl");
        ((EditTextPreference) (obj)).setDefaultValue(getString(0x7f0804c6));
        ((EditTextPreference) (obj)).setTitle("Groupon RAPI API URL");
        ((EditTextPreference) (obj)).setSummary(((SharedPreferences)prefs.get()).getString("baseRapiUrl", getString(0x7f0804c6)));
        ((EditTextPreference) (obj)).setOnPreferenceChangeListener(new RapiUrlPreferenceChangeListener(((EditTextPreference) (obj))));
        bundle.addPreference(((Preference) (obj)));
        bundle.addPreference(createConfigurableUrlPreference("base_url_market_rate", getString(0x7f0804c5), getResources().getStringArray(0x7f0f000c), "Groupon Market Rate API URL"));
        bundle.addPreference(createConfigurableUrlPreference("base_url_delivery_estimates", getString(0x7f0804c0), getResources().getStringArray(0x7f0f0008), "Groupon Delivery Estimation API URL"));
        bundle.addPreference(createConfigurableUrlPreference("base_url_booking_engine", getString(0x7f0804be), getResources().getStringArray(0x7f0f0001), "Groupon Booking Engine API URL"));
        obj = new EditTextPreference(getActivity());
        ((EditTextPreference) (obj)).setKey("base_url_gdt");
        ((EditTextPreference) (obj)).setDefaultValue(getString(0x7f0804c2));
        ((EditTextPreference) (obj)).setTitle("GDT API URL");
        ((EditTextPreference) (obj)).setSummary(((SharedPreferences)prefs.get()).getString("base_url_gdt", getString(0x7f0804c2)));
        ((EditTextPreference) (obj)).setOnPreferenceChangeListener(new GdtUrlPreferenceChangeListener(((EditTextPreference) (obj))));
        bundle.addPreference(((Preference) (obj)));
        bundle.addPreference(createConfigurableUrlPreference("web_base_url_gdt", getString(0x7f080533), getResources().getStringArray(0x7f0f000a), "GDT/GTG Web URLs"));
        bundle.addPreference(generateEditTextPreference("webview_base_url", "WebView Base URL", "eg: https://groupon.com", "https://www.groupon.com"));
        bundle = new PreferenceCategory(getActivity());
        bundle.setTitle("Countries");
        getPreferenceScreen().addPreference(bundle);
        obj = new EditTextPreference(getActivity());
        ((EditTextPreference) (obj)).setKey("baseUrl");
        ((EditTextPreference) (obj)).setDefaultValue(getString(0x7f0804bc));
        ((EditTextPreference) (obj)).setTitle("Groupon US API URL");
        ((EditTextPreference) (obj)).setSummary(((SharedPreferences)prefs.get()).getString("baseUrl", getString(0x7f0804bc)));
        ((EditTextPreference) (obj)).setOnPreferenceChangeListener(new UsUrlPreferenceChangeListener(((EditTextPreference) (obj))));
        bundle.addPreference(((Preference) (obj)));
        obj = new EditTextPreference(getActivity());
        ((EditTextPreference) (obj)).setKey("base_url_eu");
        ((EditTextPreference) (obj)).setDefaultValue(getString(0x7f0804c1));
        ((EditTextPreference) (obj)).setTitle("Groupon EU API URL");
        ((EditTextPreference) (obj)).setSummary(((SharedPreferences)prefs.get()).getString("base_url_eu", getString(0x7f0804c1)));
        ((EditTextPreference) (obj)).setOnPreferenceChangeListener(new EuUrlPreferenceChangeListener(((EditTextPreference) (obj))));
        bundle.addPreference(((Preference) (obj)));
        obj = new EditTextPreference(getActivity());
        ((EditTextPreference) (obj)).setKey("base_url_as");
        ((EditTextPreference) (obj)).setDefaultValue(getString(0x7f0804bd));
        ((EditTextPreference) (obj)).setTitle("Groupon Asia API URL");
        ((EditTextPreference) (obj)).setSummary(((SharedPreferences)prefs.get()).getString("base_url_as", getString(0x7f0804bd)));
        ((EditTextPreference) (obj)).setOnPreferenceChangeListener(new AsUrlPreferenceChangeListener(((EditTextPreference) (obj))));
        bundle.addPreference(((Preference) (obj)));
        obj = new EditTextPreference(getActivity());
        ((EditTextPreference) (obj)).setKey("base_url_cl");
        ((EditTextPreference) (obj)).setDefaultValue(getString(0x7f0804bf));
        ((EditTextPreference) (obj)).setTitle("Groupon Chile API URL");
        ((EditTextPreference) (obj)).setSummary(((SharedPreferences)prefs.get()).getString("base_url_cl", getString(0x7f0804bf)));
        ((EditTextPreference) (obj)).setOnPreferenceChangeListener(new ClUrlPreferenceChangeListener(((EditTextPreference) (obj))));
        bundle.addPreference(((Preference) (obj)));
        obj = new EditTextPreference(getActivity());
        ((EditTextPreference) (obj)).setKey("base_url_in");
        ((EditTextPreference) (obj)).setDefaultValue(getString(0x7f0804c3));
        ((EditTextPreference) (obj)).setTitle("Groupon India API URL");
        ((EditTextPreference) (obj)).setSummary(((SharedPreferences)prefs.get()).getString("base_url_in", getString(0x7f0804c3)));
        ((EditTextPreference) (obj)).setOnPreferenceChangeListener(new InUrlPreferenceChangeListener(((EditTextPreference) (obj))));
        bundle.addPreference(((Preference) (obj)));
        obj = new EditTextPreference(getActivity());
        ((EditTextPreference) (obj)).setKey("base_url_jp");
        ((EditTextPreference) (obj)).setDefaultValue(getString(0x7f0804c4));
        ((EditTextPreference) (obj)).setTitle("Groupon Japan API URL");
        ((EditTextPreference) (obj)).setSummary(((SharedPreferences)prefs.get()).getString("base_url_jp", getString(0x7f0804c4)));
        ((EditTextPreference) (obj)).setOnPreferenceChangeListener(new JpUrlPreferenceChangeListener(((EditTextPreference) (obj))));
        bundle.addPreference(((Preference) (obj)));
        obj = new EditTextPreference(getActivity());
        ((EditTextPreference) (obj)).setKey("base_url_ru");
        ((EditTextPreference) (obj)).setDefaultValue(getString(0x7f0804c7));
        ((EditTextPreference) (obj)).setTitle("Groupon Russia API URL");
        ((EditTextPreference) (obj)).setSummary(((SharedPreferences)prefs.get()).getString("base_url_ru", getString(0x7f0804c7)));
        ((EditTextPreference) (obj)).setOnPreferenceChangeListener(new RuUrlPreferenceChangeListener(((EditTextPreference) (obj))));
        bundle.addPreference(((Preference) (obj)));
        obj = new EditTextPreference(getActivity());
        ((EditTextPreference) (obj)).setKey("base_payment_url_ru");
        ((EditTextPreference) (obj)).setDefaultValue(getString(0x7f080500));
        ((EditTextPreference) (obj)).setTitle("Groupon Russia Payment URL");
        ((EditTextPreference) (obj)).setSummary(((SharedPreferences)prefs.get()).getString("base_payment_url_ru", getString(0x7f080500)));
        ((EditTextPreference) (obj)).setOnPreferenceChangeListener(new RuPaymentUrlPreferenceChangeListener(((EditTextPreference) (obj))));
        bundle.addPreference(((Preference) (obj)));
    }

}
