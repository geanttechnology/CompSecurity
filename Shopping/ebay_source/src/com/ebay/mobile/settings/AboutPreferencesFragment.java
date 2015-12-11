// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.settings;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.ShowFileWebViewActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.experimentation.Experiments;
import com.ebay.nautilus.domain.net.api.experimentation.Experiment;
import com.ebay.nautilus.domain.net.api.experimentation.Treatment;
import com.ebay.nautilus.shell.app.BasePreferenceActivity;

public class AboutPreferencesFragment extends PreferenceFragment
{

    private static final String PREFERENCE_LEGAL = "about_legal";
    private Treatment activeExperimentState;

    public AboutPreferencesFragment()
    {
        activeExperimentState = null;
    }

    public void onCreate(final Bundle activity)
    {
        super.onCreate(activity);
        addPreferencesFromResource(0x7f050000);
        activity = (BasePreferenceActivity)getActivity();
        final Preferences prefs = MyApp.getPrefs();
        findPreference("about_legal").setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener() {

            final AboutPreferencesFragment this$0;
            final BasePreferenceActivity val$activity;
            final Preferences val$prefs;

            public boolean onPreferenceClick(Preference preference)
            {
                ShowFileWebViewActivity.startActivity(activity, prefs.getLicenseUrl(), Integer.valueOf(0x7f070116), "LegalInfo", Boolean.valueOf(false));
                return true;
            }

            
            {
                this$0 = AboutPreferencesFragment.this;
                activity = basepreferenceactivity;
                prefs = preferences;
                super();
            }
        });
        activeExperimentState = Experiments.TestExperiment.getCurrentTreatment(activity.getEbayContext());
    }

    public void onResume()
    {
        super.onResume();
        (new TrackingData("SettingsAbout", TrackingType.PAGE_IMPRESSION)).addExperimentServedTags(activeExperimentState).send(getActivity());
    }
}
