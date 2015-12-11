// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.preference;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.widget.Toast;
import com.ebay.mobile.ErrorDialogFragment;
import com.ebay.mobile.dcs.DcsTest;
import com.ebay.mobile.util.PreferenceUtil;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.sql.Date;
import java.text.DateFormat;

public final class DcsGeneralPreferenceFragment extends PreferenceFragment
    implements android.preference.Preference.OnPreferenceClickListener
{
    private final class ForceSyncTask extends AsyncTask
    {

        final DcsGeneralPreferenceFragment this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Boolean[])aobj);
        }

        protected transient Void doInBackground(Boolean aboolean[])
        {
            dc.refresh(aboolean[0].booleanValue(), Boolean.valueOf(true));
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            forceSyncTask = null;
            void1 = getActivity();
            if (void1 == null || void1.isFinishing())
            {
                return;
            } else
            {
                findPreference("force_sync").setSummary(getLastSyncedSummary());
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            findPreference("force_sync").setSummary("Syncing...");
        }

        private ForceSyncTask()
        {
            this$0 = DcsGeneralPreferenceFragment.this;
            super();
        }

    }


    private static final String KEY_DUMP = "dump_properties";
    static final String KEY_FORCE_SYNC = "force_sync";
    private static final String KEY_RESET = "reset_overrides";
    private static final String KEY_VALIDATE = "validate_rules";
    final DeviceConfiguration dc = DeviceConfiguration.getAsync();
    ForceSyncTask forceSyncTask;

    public DcsGeneralPreferenceFragment()
    {
    }

    static String getResetSummary(DeviceConfiguration deviceconfiguration)
    {
        int i = deviceconfiguration.getDevOverrideCount();
        if (i == 1)
        {
            return "1 override";
        } else
        {
            return (new StringBuilder()).append(String.valueOf(i)).append(" overrides").toString();
        }
    }

    final String getLastSyncedSummary()
    {
        long l = dc.getLastSynced();
        StringBuilder stringbuilder = (new StringBuilder()).append("Last synced: ");
        String s;
        if (l == 0L)
        {
            s = "never";
        } else
        {
            s = DateFormat.getDateTimeInstance().format(new Date(l));
        }
        return stringbuilder.append(s).toString();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Object obj = getActivity();
        PreferenceScreen preferencescreen = getPreferenceManager().createPreferenceScreen(((android.content.Context) (obj)));
        Object obj1 = PreferenceUtil.setup(new Preference(((android.content.Context) (obj))), "validate_rules", "Validate rules", null, false);
        ((Preference) (obj1)).setOnPreferenceClickListener(this);
        preferencescreen.addPreference(((Preference) (obj1)));
        obj1 = getLastSyncedSummary();
        obj1 = PreferenceUtil.setup(new Preference(((android.content.Context) (obj))), "force_sync", "Force sync", ((CharSequence) (obj1)), false);
        ((Preference) (obj1)).setOnPreferenceClickListener(this);
        preferencescreen.addPreference(((Preference) (obj1)));
        obj1 = getResetSummary(dc);
        obj1 = PreferenceUtil.setup(new Preference(((android.content.Context) (obj))), "reset_overrides", "Reset overrides", ((CharSequence) (obj1)), false);
        ((Preference) (obj1)).setOnPreferenceClickListener(this);
        preferencescreen.addPreference(((Preference) (obj1)));
        obj = PreferenceUtil.setup(new Preference(((android.content.Context) (obj))), "dump_properties", "Dump properties", "Will dump to logcat under DeviceConfig", false);
        ((Preference) (obj)).setOnPreferenceClickListener(this);
        preferencescreen.addPreference(((Preference) (obj)));
        setPreferenceScreen(preferencescreen);
        if (bundle != null && bundle.getBoolean("force_sync"))
        {
            forceSyncTask = new ForceSyncTask();
            forceSyncTask.execute(new Boolean[] {
                Boolean.valueOf(false)
            });
        }
    }

    public boolean onPreferenceClick(Preference preference)
    {
        Object obj = preference.getKey();
        if ("validate_rules".equals(obj))
        {
            obj = new Bundle();
            Object obj1;
            try
            {
                ((Bundle) (obj)).putString("title", "Default rules");
                DcsTest.validateDefaults();
                ((Bundle) (obj)).putString("title", "Loaded rules");
                DcsTest.validateLoadedRules(dc);
                ((Bundle) (obj)).putString("title", preference.getTitle().toString());
                ((Bundle) (obj)).putString("message", "Checks out");
            }
            // Misplaced declaration of an exception variable
            catch (Preference preference)
            {
                ((Bundle) (obj)).putBoolean("isError", true);
                ((Bundle) (obj)).putString("message", preference.getMessage());
            }
            obj1 = getFragmentManager();
            preference = ((FragmentManager) (obj1)).beginTransaction();
            obj1 = ((FragmentManager) (obj1)).findFragmentByTag("messageDialog");
            if (obj1 != null)
            {
                preference.remove(((android.app.Fragment) (obj1)));
            }
            preference.addToBackStack(null);
            obj1 = new ErrorDialogFragment();
            ((ErrorDialogFragment) (obj1)).setArguments(((Bundle) (obj)));
            ((ErrorDialogFragment) (obj1)).setTargetFragment(this, 0);
            ((ErrorDialogFragment) (obj1)).show(preference, "messageDialog");
            return true;
        }
        if ("force_sync".equals(obj))
        {
            if (forceSyncTask == null)
            {
                forceSyncTask = new ForceSyncTask();
                forceSyncTask.execute(new Boolean[] {
                    Boolean.valueOf(true)
                });
                return true;
            }
        } else
        {
            if ("reset_overrides".equals(obj))
            {
                dc.resetAllDevOverrides();
                preference.setSummary(getResetSummary(dc));
                Toast.makeText(getActivity(), "Overrides reset", 0).show();
                return true;
            }
            if ("dump_properties".equals(obj))
            {
                DcsTest.dumpAll();
                return true;
            }
        }
        return false;
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (forceSyncTask != null)
        {
            bundle.putBoolean("force_sync", true);
        }
    }
}
