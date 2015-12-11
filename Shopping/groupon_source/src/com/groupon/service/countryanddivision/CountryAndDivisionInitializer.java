// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.countryanddivision;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import com.groupon.models.country.Country;
import com.groupon.models.division.City;
import com.groupon.service.LocalizationInitializerService;
import com.groupon.service.LocationService;
import com.groupon.service.core.AbTestService;
import com.groupon.service.core.CurrentDivisionUpdaterService;
import com.groupon.service.core.StatusService;
import com.groupon.service.countryanddivision.listener.CountryAndDivisionInitializerEventSource;
import com.groupon.service.countryanddivision.listener.CountryAndDivisionInitializerListener;
import com.groupon.util.DivisionUtil;
import com.groupon.util.GeoPoint;
import java.io.IOException;
import roboguice.inject.Lazy;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.service.countryanddivision:
//            CurrentCountryManager, CurrentCountryService, DivisionsService, CurrentDivisionManager, 
//            CurrentDivisionDao

public class CountryAndDivisionInitializer
{

    private Lazy abTestService;
    private Lazy currentCountryManager;
    private Lazy currentCountryService;
    private Lazy currentDivisionManager;
    private Lazy divisionUtil;
    private Lazy divisionsService;
    CountryAndDivisionInitializerEventSource eventSource;
    private Lazy localizationInitializerService;
    private Lazy locationService;
    private Lazy sharedPreferences;
    private Lazy statusService;

    public CountryAndDivisionInitializer()
    {
    }

    public void addCountryAndDivisionInitializerListener(CountryAndDivisionInitializerListener countryanddivisioninitializerlistener)
    {
        eventSource.addCountryAndDivisionInitializerListener(countryanddivisioninitializerlistener);
    }

    public void findCountryAndDivision()
    {
        this;
        JVM INSTR monitorenter ;
        if (hasDivisionBeenSet())
        {
            break MISSING_BLOCK_LABEL_116;
        }
        if (((CurrentCountryManager)currentCountryManager.get()).getCurrentCountry() != null) goto _L2; else goto _L1
_L1:
        Country country = ((LocalizationInitializerService)localizationInitializerService.get()).getCountry();
        if (country != LocalizationInitializerService.NO_COUNTRY_DETECTED) goto _L4; else goto _L3
_L3:
        eventSource.fireOnManualCountrySelectionNeeded();
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        country = ((CurrentCountryService)currentCountryService.get()).getCountryFromServer(country);
        ((CurrentCountryManager)currentCountryManager.get()).setCurrentCountryAndRemoveDivision(country);
        findDivision();
          goto _L5
        Object obj;
        obj;
        eventSource.fireOnException(((Exception) (obj)));
          goto _L5
        obj;
        throw obj;
_L2:
        findDivision();
          goto _L5
        eventSource.fireOnCountryAndDivisionSet();
          goto _L5
    }

    void findDivision()
    {
        Object obj;
        com.groupon.models.division.Division division;
        Object obj1;
        boolean flag;
        if (!((StatusService)statusService.get()).isUpToDate())
        {
            try
            {
                ((StatusService)statusService.get()).refresh();
            }
            catch (Exception exception)
            {
                eventSource.fireOnException(exception);
                return;
            }
        }
        if (!((DivisionsService)divisionsService.get()).isUpToDate())
        {
            try
            {
                ((DivisionsService)divisionsService.get()).refresh();
            }
            catch (Exception exception1)
            {
                eventSource.fireOnException(exception1);
                return;
            }
        }
        if (!((SharedPreferences)sharedPreferences.get()).getBoolean("attributionFirstLaunchRecorded", false))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_320;
        }
        obj1 = ((LocationService)locationService.get()).getLocation();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_312;
        }
        obj = new GeoPoint(((Location) (obj1)));
        division = ((DivisionUtil)divisionUtil.get()).getDivisionFrom(((GeoPoint) (obj)));
        if (division == null)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        obj = division;
        if (!((AbTestService)abTestService.get()).isVariantEnabled("maskDivisions1508", "on"))
        {
            break MISSING_BLOCK_LABEL_231;
        }
        obj = division;
        if (!((CurrentCountryManager)currentCountryManager.get()).getCurrentCountry().isLocationsAutocompleteEnabledCountry())
        {
            break MISSING_BLOCK_LABEL_231;
        }
        obj1 = ((DivisionUtil)divisionUtil.get()).getCityNameFromGeoPoint(new GeoPoint((int)(((Location) (obj1)).getLatitude() * 1000000D), (int)(((Location) (obj1)).getLongitude() * 1000000D)));
        obj = division;
        if (obj1 != null)
        {
            try
            {
                obj = new City(division, ((String) (obj1)));
            }
            catch (IOException ioexception)
            {
                Ln.e(ioexception);
                ioexception = division;
            }
        }
        ((CurrentDivisionManager)currentDivisionManager.get()).setCurrentDivisionAndClearCaches(((com.groupon.models.division.Division) (obj)), new Class[] {
            com/groupon/service/core/StatusService, com/groupon/service/core/CurrentDivisionUpdaterService
        });
        eventSource.fireOnCountryAndDivisionSet();
        return;
        eventSource.fireOnManualDivisionSelectionNeeded();
        return;
        eventSource.fireOnManualDivisionSelectionNeeded();
        return;
        eventSource.fireOnManualDivisionSelectionNeeded();
        return;
    }

    public boolean hasDivisionBeenSet()
    {
        return ((CurrentDivisionManager)currentDivisionManager.get()).getCurrentDivision() != CurrentDivisionDao.DEFAULT_DIVISION;
    }

    public void init(Application application)
    {
        divisionUtil = new Lazy(application) {

            final CountryAndDivisionInitializer this$0;

            
            {
                this$0 = CountryAndDivisionInitializer.this;
                super(context);
            }
        };
        divisionsService = new Lazy(application) {

            final CountryAndDivisionInitializer this$0;

            
            {
                this$0 = CountryAndDivisionInitializer.this;
                super(context);
            }
        };
        currentCountryManager = new Lazy(application) {

            final CountryAndDivisionInitializer this$0;

            
            {
                this$0 = CountryAndDivisionInitializer.this;
                super(context);
            }
        };
        currentCountryService = new Lazy(application) {

            final CountryAndDivisionInitializer this$0;

            
            {
                this$0 = CountryAndDivisionInitializer.this;
                super(context);
            }
        };
        currentDivisionManager = new Lazy(application) {

            final CountryAndDivisionInitializer this$0;

            
            {
                this$0 = CountryAndDivisionInitializer.this;
                super(context);
            }
        };
        localizationInitializerService = new Lazy(application) {

            final CountryAndDivisionInitializer this$0;

            
            {
                this$0 = CountryAndDivisionInitializer.this;
                super(context);
            }
        };
        locationService = new Lazy(application) {

            final CountryAndDivisionInitializer this$0;

            
            {
                this$0 = CountryAndDivisionInitializer.this;
                super(context);
            }
        };
        sharedPreferences = new Lazy(application) {

            final CountryAndDivisionInitializer this$0;

            
            {
                this$0 = CountryAndDivisionInitializer.this;
                super(context);
            }
        };
        statusService = new Lazy(application) {

            final CountryAndDivisionInitializer this$0;

            
            {
                this$0 = CountryAndDivisionInitializer.this;
                super(context);
            }
        };
        abTestService = new Lazy(application) {

            final CountryAndDivisionInitializer this$0;

            
            {
                this$0 = CountryAndDivisionInitializer.this;
                super(context);
            }
        };
    }

    public void removeCountryAndDivisionInitializerListener(CountryAndDivisionInitializerListener countryanddivisioninitializerlistener)
    {
        eventSource.removeCountryAndDivisionInitializerListener(countryanddivisioninitializerlistener);
    }

    public void setCurrentDivision(String s)
        throws Exception
    {
        ((CurrentDivisionManager)currentDivisionManager.get()).setCurrentDivisionInfoAndClearCaches(s);
    }
}
