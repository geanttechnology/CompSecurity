// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v4.preference.PreferenceFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import com.bitstrips.imoji.InjectorApplication;
import com.bitstrips.imoji.analytics.Action;
import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.analytics.Category;
import com.bitstrips.imoji.auth.FacebookService;
import com.bitstrips.imoji.manager.FloaterServiceManager;
import com.bitstrips.imoji.util.PreferenceUtils;

public class SettingsActivity extends AppCompatActivity
{
    public static class SettingsFragment extends PreferenceFragment
    {

        public void onCreate(Bundle bundle)
        {
            super.onCreate(bundle);
            getPreferenceManager().setSharedPreferencesName(getString(0x7f0600bd));
            addPreferencesFromResource(0x7f050002);
            if (android.os.Build.VERSION.SDK_INT > 21)
            {
                bundle = findPreference(getString(0x7f060083));
                if (bundle != null)
                {
                    getPreferenceScreen().removePreference(bundle);
                }
            }
        }

        public SettingsFragment()
        {
        }
    }


    public static final int LOG_OUT_REQUEST_CODE = 1;
    private static final String TAG = "SettingsActivity";
    AnalyticsService analytics;
    FacebookService facebookService;
    FloaterServiceManager floaterServiceManager;
    private android.content.SharedPreferences.OnSharedPreferenceChangeListener listener;
    PreferenceUtils preferenceUtils;
    private SharedPreferences prefs;
    private Toolbar toolbar;

    public SettingsActivity()
    {
    }

    private void registerFloaterSettingChangeListener()
    {
        listener = new android.content.SharedPreferences.OnSharedPreferenceChangeListener() {

            final SettingsActivity this$0;

            public void onSharedPreferenceChanged(SharedPreferences sharedpreferences, String s)
            {
label0:
                {
                    if (getString(0x7f060083).equals(s))
                    {
                        if (!sharedpreferences.getBoolean(s, true))
                        {
                            break label0;
                        }
                        if (preferenceUtils.getString(0x7f06002a, null) != null)
                        {
                            floaterServiceManager.startFloaterService();
                        }
                    }
                    return;
                }
                floaterServiceManager.stopFloaterService();
                analytics.sendEvent(Category.FLOATER, Action.DISABLE, null);
            }

            
            {
                this$0 = SettingsActivity.this;
                super();
            }
        };
        prefs.registerOnSharedPreferenceChangeListener(listener);
    }

    private void unregisterFloaterSettingChangeListener()
    {
        prefs.unregisterOnSharedPreferenceChangeListener(listener);
        listener = null;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        ((InjectorApplication)getApplication()).inject(this);
        setContentView(0x7f030063);
        toolbar = (Toolbar)findViewById(0x7f0b0074);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(getString(0x7f0600d8));
        if (bundle == null)
        {
            getSupportFragmentManager().beginTransaction().replace(0x7f0b00fc, new SettingsFragment()).commit();
        }
        prefs = getApplication().getSharedPreferences(getString(0x7f0600bd), 0);
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        intent = intent.getDataString();
        if (intent != null && intent.equals(getString(0x7f0600a6)))
        {
            setResult(-1);
            finish();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            setResult(0);
            break;
        }
        NavUtils.navigateUpFromSameTask(this);
        return true;
    }

    protected void onPause()
    {
        super.onPause();
        facebookService.logDeactivate(this);
    }

    public void onResume()
    {
        super.onResume();
        facebookService.logActivate(this);
    }

    protected void onStart()
    {
        super.onStart();
        analytics.reportStart(this);
        registerFloaterSettingChangeListener();
    }

    protected void onStop()
    {
        unregisterFloaterSettingChangeListener();
        analytics.reportStop(this);
        super.onStop();
    }
}
