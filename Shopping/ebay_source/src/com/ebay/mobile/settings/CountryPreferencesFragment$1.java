// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.settings;

import android.preference.Preference;
import com.ebay.common.Preferences;
import com.ebay.common.view.util.EbayCountryManager;
import com.ebay.mobile.MyApp;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.domain.data.PostalCodeSpecification;

// Referenced classes of package com.ebay.mobile.settings:
//            CountryPreferencesFragment

class this._cls0
    implements android.preference.Listener
{

    final CountryPreferencesFragment this$0;

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        boolean flag = obj.equals(Boolean.TRUE);
        preference = MyApp.getPrefs();
        preference.setCountryAutoDetected(flag);
        if (flag)
        {
            if (CountryPreferencesFragment.logger._fld0)
            {
                CountryPreferencesFragment.logger._mth0("Turning on country auto-detection");
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
        if (CountryPreferencesFragment.logger.urces)
        {
            CountryPreferencesFragment.logger.urces("Turning off country auto-detection");
            return true;
        }
        return true;
    }

    ager()
    {
        this$0 = CountryPreferencesFragment.this;
        super();
    }
}
