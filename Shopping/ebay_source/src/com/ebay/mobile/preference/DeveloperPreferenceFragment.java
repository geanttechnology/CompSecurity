// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.preference;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Process;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.preference.SwitchPreference;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;
import com.ebay.common.Preferences;
import com.ebay.common.util.EbaySettings;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.DcsPreferenceActivity;
import com.ebay.mobile.activities.NotificationReportActivity;
import com.ebay.mobile.activities.eBay;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.util.PreferenceUtil;
import com.ebay.nautilus.domain.dcs.DcsState;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.kernel.EbayIdentity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class DeveloperPreferenceFragment extends PreferenceFragment
    implements android.preference.Preference.OnPreferenceChangeListener, android.preference.Preference.OnPreferenceClickListener
{
    private final class GetDeviceIdTask extends AsyncTask
    {

        private final Preference pref;
        final DeveloperPreferenceFragment this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Context[])aobj);
        }

        protected transient String doInBackground(Context acontext[])
        {
            return EbayIdentity.getDeviceIdString(acontext[0]);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            Activity activity = getActivity();
            if (activity != null && !activity.isFinishing())
            {
                pref.setSummary(s);
            }
        }

        public GetDeviceIdTask(Preference preference)
        {
            this$0 = DeveloperPreferenceFragment.this;
            super();
            pref = preference;
        }
    }


    private static final String PREF_DCS_ROLLOUT_THRESHOLD = "dcs_rollout_threshold";
    private static final String PREF_DEV_OPTIONS = "developer_options_enabled";
    private static final String PREF_DUMP_KNOWN_ENDPOINTS = "dump_known_endpoints";
    private static final String PREF_INVERT_THEME = "invert_theme";
    private static final String PREF_RESET_DEVICE_ID = "reset_device_id";
    private static final String PREF_SEARCH_URL_SHARING = "search_url_sharing";
    private static final String PREF_USE_QA_SERVERS = "use_staging_mode";
    private Preferences pref;

    public DeveloperPreferenceFragment()
    {
    }

    private int getDcsRolloutThreshold()
    {
        return DeviceConfiguration.getNoSync().getState().rolloutThreshold;
    }

    private void killMyProcesses(Context context)
    {
        Object obj = ((ActivityManager)context.getSystemService("activity")).getRunningAppProcesses();
        if (obj == null)
        {
            return;
        }
        int i = Process.myPid();
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)((Iterator) (obj)).next();
            if (runningappprocessinfo.processName.startsWith("com.ebay.mobile:") && runningappprocessinfo.pid != i)
            {
                killPid(runningappprocessinfo.pid);
            }
        } while (true);
        eBay.Restart(context);
        killPid(i);
    }

    private static void killPid(int i)
    {
        if (i != -1)
        {
            Process.killProcess(i);
        }
    }

    private boolean setDcsRolloutThreshold(int i)
    {
        return DeviceConfiguration.getNoSync().setRolloutThreshold(i);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        pref = MyApp.getPrefs();
        Object obj = getActivity();
        bundle = getPreferenceManager().createPreferenceScreen(((Context) (obj)));
        setPreferenceScreen(bundle);
        boolean flag = pref.getGlobalPref("developerOptions", false);
        Object obj1 = (SwitchPreference)PreferenceUtil.setup(new SwitchPreference(((Context) (obj))), "developer_options_enabled", "Developer options", "Enables link from settings", false);
        ((SwitchPreference) (obj1)).setOnPreferenceChangeListener(this);
        ((SwitchPreference) (obj1)).setChecked(flag);
        bundle.addPreference(((Preference) (obj1)));
        flag = (new File(((Context) (obj)).getFilesDir(), "DebugSettings")).isFile();
        obj1 = (SwitchPreference)PreferenceUtil.setup(new SwitchPreference(((Context) (obj))), "use_staging_mode", "QA servers", "Will restart the app", false);
        ((SwitchPreference) (obj1)).setChecked(flag);
        ((SwitchPreference) (obj1)).setOnPreferenceChangeListener(this);
        bundle.addPreference(((Preference) (obj1)));
        ((SwitchPreference) (obj1)).setDependency("developer_options_enabled");
        flag = pref.getGlobalPref("developerOptionSearchUrl", false);
        obj1 = (SwitchPreference)PreferenceUtil.setup(new SwitchPreference(((Context) (obj))), "search_url_sharing", "Search URL", "Select menu->URL in SRP", false);
        ((SwitchPreference) (obj1)).setChecked(flag);
        ((SwitchPreference) (obj1)).setOnPreferenceChangeListener(this);
        bundle.addPreference(((Preference) (obj1)));
        ((SwitchPreference) (obj1)).setDependency("developer_options_enabled");
        flag = pref.getGlobalPref("developerOptionInvertTheme", false);
        obj1 = (SwitchPreference)PreferenceUtil.setup(new SwitchPreference(((Context) (obj))), "invert_theme", "Invert theme", "Disabled in release builds", false);
        ((SwitchPreference) (obj1)).setChecked(flag);
        ((SwitchPreference) (obj1)).setOnPreferenceChangeListener(this);
        ((SwitchPreference) (obj1)).setEnabled(false);
        bundle.addPreference(((Preference) (obj1)));
        ((SwitchPreference) (obj1)).setDependency("developer_options_enabled");
        obj1 = PreferenceUtil.setup(new Preference(((Context) (obj))), null, "Report AWOL Notification", "Click to send report", false);
        ((Preference) (obj1)).setIntent(new Intent(((Context) (obj)), com/ebay/mobile/activities/NotificationReportActivity));
        bundle.addPreference(((Preference) (obj1)));
        ((Preference) (obj1)).setDependency("developer_options_enabled");
        obj1 = PreferenceUtil.setup(new Preference(((Context) (obj))), "dump_known_endpoints", "Dump known endpoints", "Will dump to logcat under ApiSettings", false);
        ((Preference) (obj1)).setOnPreferenceClickListener(this);
        bundle.addPreference(((Preference) (obj1)));
        ((Preference) (obj1)).setDependency("developer_options_enabled");
        Object obj2 = String.valueOf(getDcsRolloutThreshold());
        obj1 = (EditTextPreference)PreferenceUtil.setup(new EditTextPreference(((Context) (obj))), "dcs_rollout_threshold", (new StringBuilder()).append("DCS rollout threshold: ").append(((String) (obj2))).append("%").toString(), "Click to change and restart the app", false);
        ((EditTextPreference) (obj1)).setDialogTitle("DCS rollout threshold");
        ((EditTextPreference) (obj1)).setText(((String) (obj2)));
        ((EditTextPreference) (obj1)).setOnPreferenceChangeListener(this);
        obj2 = ((EditTextPreference) (obj1)).getEditText();
        ((EditText) (obj2)).setInputType(2);
        ((EditText) (obj2)).setSelectAllOnFocus(true);
        ((EditText) (obj2)).setMaxLines(1);
        ((EditText) (obj2)).setSingleLine(true);
        bundle.addPreference(((Preference) (obj1)));
        ((EditTextPreference) (obj1)).setDependency("developer_options_enabled");
        obj1 = PreferenceUtil.setup(new Preference(((Context) (obj))), "reset_device_id", "Reset device ID", "Will restart the app", false);
        ((Preference) (obj1)).setOnPreferenceClickListener(this);
        bundle.addPreference(((Preference) (obj1)));
        ((Preference) (obj1)).setDependency("developer_options_enabled");
        (new GetDeviceIdTask(((Preference) (obj1)))).execute(new Context[] {
            ((Context) (obj)).getApplicationContext()
        });
        obj1 = PreferenceUtil.setup(new Preference(((Context) (obj))), null, "Device configuration", null, false);
        ((Preference) (obj1)).setIntent(new Intent(getActivity(), com/ebay/mobile/activities/DcsPreferenceActivity));
        bundle.addPreference(((Preference) (obj1)));
        ((Preference) (obj1)).setDependency("developer_options_enabled");
        obj = PreferenceUtil.setup(new Preference(((Context) (obj))), null, "Local Maps State", (new DcsHelper(((Context) (obj)))).getDeviceMapsState(), false);
        bundle.addPreference(((Preference) (obj)));
        ((Preference) (obj)).setDependency("developer_options_enabled");
    }

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        String s;
        boolean flag1;
        flag1 = false;
        s = preference.getKey();
        preference = getActivity();
        if (!"use_staging_mode".equals(s)) goto _L2; else goto _L1
_L1:
        boolean flag;
        boolean flag4;
        flag4 = ((Boolean)obj).booleanValue();
        flag = false;
        obj = new File(preference.getFilesDir(), "DebugSettings");
        if (!flag4) goto _L4; else goto _L3
_L3:
        if (((File) (obj)).isFile())
        {
            break MISSING_BLOCK_LABEL_81;
        }
        obj = new FileOutputStream(((File) (obj)));
        ((FileOutputStream) (obj)).write(1);
        ((FileOutputStream) (obj)).close();
        flag = true;
_L6:
        if (flag)
        {
            killMyProcesses(preference);
        }
_L9:
        flag1 = true;
_L8:
        return flag1;
        preference;
        try
        {
            ((FileOutputStream) (obj)).close();
            throw preference;
        }
        // Misplaced declaration of an exception variable
        catch (Preference preference)
        {
            preference.printStackTrace();
        }
        return false;
_L4:
        if (!((File) (obj)).isFile()) goto _L6; else goto _L5
_L5:
        if (!((File) (obj)).delete()) goto _L8; else goto _L7
_L7:
        flag = true;
          goto _L6
_L2:
        if ("developer_options_enabled".equals(s))
        {
            boolean flag2 = ((Boolean)obj).booleanValue();
            if (flag2)
            {
                pref.setGlobalPref(true, "developerOptions");
            } else
            {
                pref.removeGlobalPref("developerOptions");
            }
            DeviceConfiguration.getNoSync().developerOptionsEnabled(flag2);
        } else
        {
label0:
            {
                if (!"search_url_sharing".equals(s))
                {
                    break label0;
                }
                if (((Boolean)obj).booleanValue())
                {
                    pref.setGlobalPref(true, "developerOptionSearchUrl");
                } else
                {
                    pref.removeGlobalPref("developerOptionSearchUrl");
                }
            }
        }
          goto _L9
        if (!"invert_theme".equals(s)) goto _L11; else goto _L10
_L10:
        boolean flag3 = ((Boolean)obj).booleanValue();
        if (flag3)
        {
            pref.setGlobalPref(true, "developerOptionInvertTheme");
        } else
        {
            pref.removeGlobalPref("developerOptionInvertTheme");
        }
        com.ebay.mobile.MyApp.InvertThemeShim.debugInvertTheme(preference, flag3);
          goto _L9
_L11:
        if (!"dcs_rollout_threshold".equals(s)) goto _L9; else goto _L12
_L12:
        int i = Integer.parseInt(obj.toString());
        if (i >= 1 && i <= 100) goto _L14; else goto _L13
_L13:
        try
        {
            throw new NumberFormatException();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Toast.makeText(preference, "Value must be withing [1 - 100].", 1).show();
        }
          goto _L9
_L14:
        if (!setDcsRolloutThreshold(i)) goto _L9; else goto _L15
_L15:
        killMyProcesses(preference);
          goto _L9
    }

    public boolean onPreferenceClick(Preference preference)
    {
        Object obj = preference.getKey();
        preference = getActivity();
        boolean flag1 = false;
        boolean flag;
        if ("dump_known_endpoints".equals(obj))
        {
            obj = new TreeMap();
            DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
            Object aobj[] = ApiSettings.values();
            int k = aobj.length;
            for (int i = 0; i < k; i++)
            {
                ApiSettings apisettings = aobj[i];
                ((TreeMap) (obj)).put(apisettings.name(), String.valueOf(deviceconfiguration.getDefault(apisettings)));
            }

            aobj = EbaySettings.values();
            k = aobj.length;
            for (int j = 0; j < k; j++)
            {
                EbaySettings ebaysettings = aobj[j];
                ((TreeMap) (obj)).put(ebaysettings.name(), String.valueOf(deviceconfiguration.getDefault(ebaysettings)));
            }

            for (obj = ((TreeMap) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); Log.d("ApiSettings", ((java.util.Map.Entry)((Iterator) (obj)).next()).toString())) { }
            Toast.makeText(preference, "Endpoints logged.", 1).show();
            flag = true;
        } else
        {
            flag = flag1;
            if ("reset_device_id".equals(obj))
            {
                flag = flag1;
                if ((new File(preference.getFilesDir(), "installId")).delete())
                {
                    killMyProcesses(preference);
                    return false;
                }
            }
        }
        return flag;
    }
}
