// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.widget.Toast;
import com.groupon.http.GrouponOkHttpClient;
import com.groupon.service.LoginService;
import com.groupon.util.Function0;
import com.groupon.util.Function3;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import roboguice.inject.Lazy;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            BaseSecretSettingsFragment

public class SecretProxyFragment extends BaseSecretSettingsFragment
{
    private class ProxyIpExceptionListener
        implements Function3
    {

        private final boolean shouldResetProxyIpPref;
        private final boolean shouldResetProxyPortPref;
        final SecretProxyFragment this$0;

        public void execute(Exception exception, String s, String s1)
        {
            if (shouldResetProxyIpPref)
            {
                proxyIpPref.setSummary("");
                ((SharedPreferences)prefs.get()).edit().putString("proxyIp", "").apply();
            }
            if (shouldResetProxyPortPref)
            {
                proxyPortPref.setSummary("9090");
                ((SharedPreferences)prefs.get()).edit().putString("proxyPort", "9090").apply();
            }
            if (exception instanceof UnknownHostException)
            {
                Ln.e(exception);
                Toast.makeText(getActivity(), (new StringBuilder()).append("Cannot resolve the host ").append(s).append(":").append(s1).toString(), 0).show();
                return;
            }
            if (exception instanceof GeneralSecurityException)
            {
                Ln.e(exception);
                Toast.makeText(getActivity(), "Check logs for general security exception", 0).show();
                return;
            }
            if (exception instanceof NumberFormatException)
            {
                Ln.e(exception);
                Toast.makeText(getActivity(), "Port must be an integer value", 0).show();
                return;
            }
            if (exception instanceof IllegalArgumentException)
            {
                Ln.e(exception);
                Toast.makeText(getActivity(), "Port must be between 0 and 65535 (inclusive)", 0).show();
                return;
            } else
            {
                throw new RuntimeException(exception);
            }
        }

        public volatile void execute(Object obj, Object obj1, Object obj2)
            throws Exception
        {
            execute((Exception)obj, (String)obj1, (String)obj2);
        }

        ProxyIpExceptionListener(boolean flag, boolean flag1)
        {
            this$0 = SecretProxyFragment.this;
            super();
            shouldResetProxyIpPref = flag;
            shouldResetProxyPortPref = flag1;
        }
    }

    private class ProxyIpPreferenceChangeListener
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        final SecretProxyFragment this$0;

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            preference = Strings.toString(obj);
            obj = ((SharedPreferences)prefs.get()).getString("proxyPort", "3128");
            ((GrouponOkHttpClient)grouponOkHttpClient.get()).configureProxyAsync(preference, ((String) (obj)), new UpdateProxyIpSuccessListener(preference), new ProxyIpExceptionListener(true, false));
            return true;
        }

        private ProxyIpPreferenceChangeListener()
        {
            this$0 = SecretProxyFragment.this;
            super();
        }

    }

    private class ProxyMobileBuildPreferenceClickListener
        implements android.preference.Preference.OnPreferenceClickListener
    {

        final SecretProxyFragment this$0;

        public boolean onPreferenceClick(Preference preference)
        {
            ((GrouponOkHttpClient)grouponOkHttpClient.get()).configureProxyAsync("10.63.9.31", "9090", new UpdateOdoProxySuccessListener(), new ProxyIpExceptionListener(true, true));
            return true;
        }

        private ProxyMobileBuildPreferenceClickListener()
        {
            this$0 = SecretProxyFragment.this;
            super();
        }

    }

    private class ProxyPortPreferenceChangeListener
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        final SecretProxyFragment this$0;

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            preference = ((SharedPreferences)prefs.get()).getString("proxyIp", "");
            obj = Strings.toString(obj);
            ((GrouponOkHttpClient)grouponOkHttpClient.get()).configureProxyAsync(preference, ((String) (obj)), new UpdateProxyPortSuccessListener(((String) (obj))), new ProxyIpExceptionListener(false, true));
            return true;
        }

        private ProxyPortPreferenceChangeListener()
        {
            this$0 = SecretProxyFragment.this;
            super();
        }

    }

    private static class ProxyUuidPreferenceChangeListener
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        private final EditTextPreference odoName;

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            odoName.setSummary(Strings.toString(obj));
            return true;
        }

        public ProxyUuidPreferenceChangeListener(EditTextPreference edittextpreference)
        {
            odoName = edittextpreference;
        }
    }

    private class UpdateOdoProxySuccessListener
        implements Function0
    {

        final SecretProxyFragment this$0;

        public void execute()
        {
            ((SharedPreferences)prefs.get()).edit().putString("proxyIp", "10.63.9.31").putString("proxyPort", "9090").commit();
            proxyIpPref.setSummary("10.63.9.31");
            proxyPortPref.setSummary("9090");
            proxyIpPref.getOnPreferenceChangeListener().onPreferenceChange(null, "10.63.9.31");
            proxyPortPref.getOnPreferenceChangeListener().onPreferenceChange(null, "9090");
        }

        private UpdateOdoProxySuccessListener()
        {
            this$0 = SecretProxyFragment.this;
            super();
        }

    }

    private class UpdateProxyIpSuccessListener
        implements Function0
    {

        private String newProxyIp;
        final SecretProxyFragment this$0;

        public void execute()
        {
            proxyIpPref.setSummary(newProxyIp);
            ((SharedPreferences)prefs.get()).edit().putString("proxyIp", newProxyIp).apply();
            ((LoginService)loginService.get()).logout();
        }

        public UpdateProxyIpSuccessListener(String s)
        {
            this$0 = SecretProxyFragment.this;
            super();
            newProxyIp = s;
        }
    }

    private class UpdateProxyPortSuccessListener
        implements Function0
    {

        private String newProxyPort;
        final SecretProxyFragment this$0;

        public void execute()
        {
            proxyPortPref.setSummary(newProxyPort);
            ((LoginService)loginService.get()).logout();
        }

        public UpdateProxyPortSuccessListener(String s)
        {
            this$0 = SecretProxyFragment.this;
            super();
            newProxyPort = s;
        }
    }


    private static final String ODO_PROXY_IP = "10.63.9.31";
    private static final String ODO_PROXY_PORT = "9090";
    public static final String TAG = com/groupon/fragment/SecretProxyFragment.getName();
    private EditTextPreference proxyIpPref;
    private EditTextPreference proxyPortPref;

    public SecretProxyFragment()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        proxyIpPref = new EditTextPreference(getActivity());
        proxyIpPref.setKey("proxyIp");
        proxyIpPref.setDefaultValue("");
        proxyIpPref.setTitle("Proxy IP Address");
        proxyIpPref.setSummary(((SharedPreferences)prefs.get()).getString("proxyIp", ""));
        proxyIpPref.setOnPreferenceChangeListener(new ProxyIpPreferenceChangeListener());
        getPreferenceScreen().addPreference(proxyIpPref);
        proxyPortPref = new EditTextPreference(getActivity());
        proxyPortPref.setKey("proxyPort");
        proxyPortPref.setDefaultValue("9090");
        proxyPortPref.setTitle("Proxy Port");
        proxyPortPref.setSummary(((SharedPreferences)prefs.get()).getString("proxyPort", "9090"));
        proxyPortPref.setOnPreferenceChangeListener(new ProxyPortPreferenceChangeListener());
        getPreferenceScreen().addPreference(proxyPortPref);
        bundle = new EditTextPreference(getActivity());
        bundle.setKey("proxyClientUUID");
        bundle.setDefaultValue("");
        bundle.setTitle("Proxy Client UUID");
        bundle.setSummary(((SharedPreferences)prefs.get()).getString("proxyClientUUID", ""));
        bundle.setOnPreferenceChangeListener(new ProxyUuidPreferenceChangeListener(bundle));
        getPreferenceScreen().addPreference(bundle);
        bundle = new Preference(getActivity());
        bundle.setTitle("Set proxy to mobilebuild on 9090");
        bundle.setOnPreferenceClickListener(new ProxyMobileBuildPreferenceClickListener());
        getPreferenceScreen().addPreference(bundle);
    }



}
