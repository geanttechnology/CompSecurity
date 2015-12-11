// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import com.groupon.activity.LogViewer;
import com.groupon.http.GrouponOkHttpClient;
import com.groupon.tracking.mobile.internal.LogClient;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.Function0;
import roboguice.inject.Lazy;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            BaseSecretSettingsFragment

public class SecretLoggingFragment extends BaseSecretSettingsFragment
{
    private class DebugLoggingPreferenceChangeListener
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        final SecretLoggingFragment this$0;

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            ((GrouponOkHttpClient)grouponOkHttpClient.get()).configureProxyAsync(((SharedPreferences)prefs.get()).getString("proxyIp", ""), ((SharedPreferences)prefs.get()).getString("proxyPort", "3128"), new UpdateDebugLoggingSuccessListener(((Boolean)obj).booleanValue()), null);
            return true;
        }

        private DebugLoggingPreferenceChangeListener()
        {
            this$0 = SecretLoggingFragment.this;
            super();
        }

    }

    private class ForceNstUploadPreferenceClickListener
        implements android.preference.Preference.OnPreferenceClickListener
    {

        final SecretLoggingFragment this$0;

        public boolean onPreferenceClick(Preference preference)
        {
            ((Logger)logger.get()).forceLogRotate();
            return true;
        }

        private ForceNstUploadPreferenceClickListener()
        {
            this$0 = SecretLoggingFragment.this;
            super();
        }

    }

    private class IncludeApiLogsPreferenceChangeListener
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        final SecretLoggingFragment this$0;

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            ((SharedPreferences)prefs.get()).edit().putBoolean(preference.getKey(), ((Boolean)obj).booleanValue()).apply();
            return true;
        }

        private IncludeApiLogsPreferenceChangeListener()
        {
            this$0 = SecretLoggingFragment.this;
            super();
        }

    }

    private class NstUploadsPreferenceChangeListener
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        final SecretLoggingFragment this$0;

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            ((LogClient)logClient.get()).setTestMode(((Boolean)obj).booleanValue());
            return true;
        }

        private NstUploadsPreferenceChangeListener()
        {
            this$0 = SecretLoggingFragment.this;
            super();
        }

    }

    private class NstUrlPreferenceChangeListener
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        private final ListPreference nstUrl;
        final SecretLoggingFragment this$0;

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            ((LogClient)logClient.get()).setNstUrl(String.format(Strings.toString(obj), new Object[] {
                clientId
            }));
            nstUrl.setSummary(((LogClient)logClient.get()).getNstUrl());
            return true;
        }

        public NstUrlPreferenceChangeListener(ListPreference listpreference)
        {
            this$0 = SecretLoggingFragment.this;
            super();
            nstUrl = listpreference;
        }
    }

    private class ShowTrackingInfoPreferenceChangeListener
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        final SecretLoggingFragment this$0;

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            ((SharedPreferences)prefs.get()).edit().putBoolean("showTrackingInfo", ((Boolean)obj).booleanValue()).apply();
            return true;
        }

        private ShowTrackingInfoPreferenceChangeListener()
        {
            this$0 = SecretLoggingFragment.this;
            super();
        }

    }

    private class UpdateDebugLoggingSuccessListener
        implements Function0
    {

        boolean debugLoggingEnabled;
        final SecretLoggingFragment this$0;

        public void execute()
        {
            byte byte0;
            if (debugLoggingEnabled)
            {
                byte0 = 2;
            } else
            {
                byte0 = 4;
            }
            Ln.setLoggingLevel(byte0);
        }

        public UpdateDebugLoggingSuccessListener(boolean flag)
        {
            this$0 = SecretLoggingFragment.this;
            super();
            debugLoggingEnabled = flag;
        }
    }


    public static final String TAG = com/groupon/fragment/SecretLoggingFragment.getName();
    protected String clientId;
    private Lazy logClient;
    private Lazy logger;

    public SecretLoggingFragment()
    {
    }

    public void init()
    {
        super.init();
        logger = new Lazy(getActivity()) {

            final SecretLoggingFragment this$0;

            
            {
                this$0 = SecretLoggingFragment.this;
                super(context);
            }
        };
        logClient = new Lazy(getActivity()) {

            final SecretLoggingFragment this$0;

            
            {
                this$0 = SecretLoggingFragment.this;
                super(context);
            }
        };
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = new Preference(getActivity());
        bundle.setKey("viewLogs");
        bundle.setTitle("View Logs");
        bundle.setIntent(new Intent(getActivity(), com/groupon/activity/LogViewer));
        getPreferenceScreen().addPreference(bundle);
        bundle = new CheckBoxPreference(getActivity());
        bundle.setKey("debugLogging");
        bundle.setTitle("Debug Logging");
        bundle.setDefaultValue(Boolean.valueOf(Ln.isDebugEnabled()));
        bundle.setOnPreferenceChangeListener(new DebugLoggingPreferenceChangeListener());
        getPreferenceScreen().addPreference(bundle);
        bundle = new CheckBoxPreference(getActivity());
        bundle.setKey("includeApiLogs");
        bundle.setTitle("Include API Logging");
        bundle.setDefaultValue(Boolean.valueOf(false));
        bundle.setOnPreferenceChangeListener(new IncludeApiLogsPreferenceChangeListener());
        getPreferenceScreen().addPreference(bundle);
        bundle = new CheckBoxPreference(getActivity());
        bundle.setTitle("Upload to NST constantly");
        bundle.setSummary("Every 10 seconds");
        bundle.setDefaultValue(Boolean.valueOf(((LogClient)logClient.get()).isTestMode()));
        bundle.setOnPreferenceChangeListener(new NstUploadsPreferenceChangeListener());
        getPreferenceScreen().addPreference(bundle);
        bundle = new ListPreference(getActivity());
        String as[] = getResources().getStringArray(0x7f0f000e);
        bundle.setKey("nst_url");
        bundle.setTitle("NST URL");
        bundle.setSummary(((LogClient)logClient.get()).getNstUrl());
        bundle.setEntries(as);
        bundle.setEntryValues(as);
        bundle.setOnPreferenceChangeListener(new NstUrlPreferenceChangeListener(bundle));
        getPreferenceScreen().addPreference(bundle);
        bundle = new CheckBoxPreference(getActivity());
        bundle.setTitle("Show tracking info");
        bundle.setSummary("Force stop app to pick up preference. (Settings => Applications => Groupon)");
        bundle.setDefaultValue(Boolean.valueOf(((SharedPreferences)prefs.get()).getBoolean("showTrackingInfo", false)));
        bundle.setOnPreferenceChangeListener(new ShowTrackingInfoPreferenceChangeListener());
        getPreferenceScreen().addPreference(bundle);
        bundle = new CheckBoxPreference(getActivity());
        bundle.setTitle("Enable basic quality checks");
        bundle.setSummary("Dumps hprof on OOM and sets VM/thread policies to find common problems");
        bundle.setDefaultValue(Boolean.valueOf(Ln.isDebugEnabled()));
        bundle.setKey("checkForLeakedActivities");
        getPreferenceScreen().addPreference(bundle);
        bundle = new Preference(getActivity());
        bundle.setTitle("Force NST upload to Groupon");
        bundle.setOnPreferenceClickListener(new ForceNstUploadPreferenceClickListener());
        getPreferenceScreen().addPreference(bundle);
        bundle = new EditTextPreference(getActivity());
        bundle.setTitle("Device Token");
        bundle.setDefaultValue(((SharedPreferences)prefs.get()).getString("gcmRegId", ""));
        getPreferenceScreen().addPreference(bundle);
    }



}
