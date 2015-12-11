// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.countryanddivision;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import com.google.inject.Injector;
import com.groupon.models.country.Country;
import com.groupon.service.ConfigurationChangedProvider;
import com.groupon.service.GCMNotificationService;
import com.groupon.service.LoginService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.CountryUtil;
import java.io.Serializable;
import roboguice.RoboGuice;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.service.countryanddivision:
//            CurrentCountryDao, CurrentDivisionManager, DivisionsService

public class CurrentCountryManager
    implements ConfigurationChangedProvider
{

    private Application application;
    private CountryUtil countryUtil;
    private Country currentCountry;
    private CurrentCountryDao currentCountryDao;
    private SharedPreferences sharedPreferences;

    public CurrentCountryManager()
    {
    }

    public void clearCountry()
    {
        currentCountry = null;
        currentCountryDao.clearCountry();
    }

    public Serializable getConfigurationState()
    {
        if (currentCountry == null)
        {
            return null;
        } else
        {
            return currentCountry.shortName;
        }
    }

    public Country getCurrentCountry()
    {
        return currentCountry;
    }

    public boolean hasCurrentCountry()
    {
        return currentCountry != null;
    }

    public void init()
    {
        String s = sharedPreferences.getString("currentCountryShortname", null);
        if (s != null && countryUtil.isCountrySupported(s))
        {
            currentCountry = currentCountryDao.loadCountry();
            return;
        } else
        {
            currentCountryDao.clearCountry();
            return;
        }
    }

    public void setCurrentCountry(Country country)
    {
        currentCountry = country;
        currentCountryDao.saveCountry(country);
    }

    public void setCurrentCountryAndRemoveDivision(Country country)
    {
        if (!country.equals(currentCountry))
        {
            roboguice.inject.ContextScopedRoboInjector contextscopedroboinjector = RoboGuice.getInjector(application);
            ((LoginService)contextscopedroboinjector.getInstance(com/groupon/service/LoginService)).logout();
            ((CurrentDivisionManager)contextscopedroboinjector.getInstance(com/groupon/service/countryanddivision/CurrentDivisionManager)).clearCurrentDivision();
            ((DivisionsService)contextscopedroboinjector.getInstance(com/groupon/service/countryanddivision/DivisionsService)).clearAllDivisions();
            if (currentCountry != null)
            {
                Intent intent = new Intent(application, com/groupon/service/GCMNotificationService);
                intent.setAction("com.groupon.UNSUBSCRIBE_PUSH");
                intent.putExtra("countryToBeUnsubscribed", currentCountry);
                Ln.d("Unsubscribing GCM ID from country %s", new Object[] {
                    currentCountry.isoName
                });
                application.startService(intent);
            }
            setCurrentCountry(country);
            Ln.d("Country is set: %s", new Object[] {
                country
            });
            ((Logger)contextscopedroboinjector.getInstance(com/groupon/tracking/mobile/sdk/Logger)).forceLogRotate();
        }
    }
}
