// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.settings;

import android.app.Activity;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;
import com.ebay.common.Preferences;
import com.ebay.common.view.util.EbayCountryManager;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.analytics.model.TrackingFlags;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.domain.data.PostalCodeSpecification;
import com.ebay.nautilus.shell.app.BasePreferenceActivity;

public class CountryPreferencesFragment extends PreferenceFragment
{
    private static final class CountryResourcesAsyncTask extends AsyncTask
    {

        private final Resources resources;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            com.ebay.common.view.util.EbayCountryManager.CountryResources.getAvailableInstances(resources);
            return null;
        }

        public CountryResourcesAsyncTask(Resources resources1)
        {
            resources = resources1;
        }
    }


    private static final String PREFERENCE_COUNTRY = "preference_country";
    private static final String PREFERENCE_DETECT = "preference_auto_detect";
    static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("CountryAutoDetect", 3, "Country Auto-Detect mode");
    UserContextDataManager userContextDataManager;

    public CountryPreferencesFragment()
    {
    }

    public static void trackCountryChange(Activity activity, EbayCountry ebaycountry, boolean flag, String s)
    {
        s = new TrackingData("GbhChanged", TrackingType.EVENT);
        if (ebaycountry.isSite())
        {
            TrackingFlags trackingflags = new TrackingFlags("cflags");
            trackingflags.setBitPosition(15);
            s.setTrackingFlags(trackingflags);
        }
        s.addKeyValuePair("uc", ebaycountry.getCountryCode());
        s.addKeyValuePair("bs", ebaycountry.site.id);
        if (flag)
        {
            ebaycountry = "1";
        } else
        {
            ebaycountry = "0";
        }
        s.addKeyValuePair("ad", ebaycountry);
        s.send(activity);
    }

    public static void trackCountrySettingsChange(Activity activity, EbayCountry ebaycountry, boolean flag)
    {
        TrackingData trackingdata = new TrackingData("SettingsEvents", TrackingType.EVENT);
        trackingdata.addKeyValuePair("mfls", "SelectSite");
        trackingdata.addKeyValuePair("site", ebaycountry.site.id);
        trackingdata.send(activity);
        trackCountryChange(activity, ebaycountry, flag, "Settings");
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = (BasePreferenceActivity)getActivity();
        userContextDataManager = (UserContextDataManager)DataManager.get(bundle.getEbayContext(), UserContextDataManager.KEY);
        userContextDataManager.loadData(null);
        addPreferencesFromResource(0x7f050002);
        SwitchPreference switchpreference = (SwitchPreference)findPreference("preference_auto_detect");
        switchpreference.setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener() {

            final CountryPreferencesFragment this$0;

            public boolean onPreferenceChange(Preference preference, Object obj)
            {
                boolean flag = obj.equals(Boolean.TRUE);
                preference = MyApp.getPrefs();
                preference.setCountryAutoDetected(flag);
                if (flag)
                {
                    if (CountryPreferencesFragment.logger.isLoggable)
                    {
                        CountryPreferencesFragment.logger.log("Turning on country auto-detection");
                    }
                    obj = EbayCountryManager.detectCountry(preference.isSignedIn());
                    PostalCodeSpecification postalcodespecification = preference.getPostalCode();
                    if (postalcodespecification != null && !postalcodespecification.countryCode.equals(((EbayCountry) (obj)).getCountryCode()))
                    {
                        preference.clearPostalCode();
                    }
                    userContextDataManager.setCurrentCountry(((EbayCountry) (obj)));
                    CountryPreferencesFragment.trackCountrySettingsChange(getActivity(), ((EbayCountry) (obj)), true);
                    findPreference("preference_country").setSummary(EbayCountryManager.getCountryWithLanguageName(getResources(), ((EbayCountry) (obj))));
                } else
                if (CountryPreferencesFragment.logger.isLoggable)
                {
                    CountryPreferencesFragment.logger.log("Turning off country auto-detection");
                    return true;
                }
                return true;
            }

            
            {
                this$0 = CountryPreferencesFragment.this;
                super();
            }
        });
        switchpreference.setChecked(MyApp.getPrefs().getCountryAutoDetected());
        (new CountryResourcesAsyncTask(bundle.getResources())).execute(new Void[0]);
    }

    public void onResume()
    {
        super.onResume();
        (new TrackingData("SettingsGbh", TrackingType.PAGE_IMPRESSION)).send(getActivity());
        findPreference("preference_country").setSummary(EbayCountryManager.getCountryWithLanguageName(getResources(), MyApp.getPrefs().getCurrentCountry()));
    }

}
