// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.operations;

import android.app.Application;
import android.content.res.Resources;
import android.location.Location;
import com.groupon.models.country.Country;
import com.groupon.service.LocationService;
import com.groupon.service.LoginService;
import com.groupon.service.countryanddivision.CountriesService;
import com.groupon.service.countryanddivision.CurrentCountryDao;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.sdk.Logger;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;
import roboguice.util.Ln;
import roboguice.util.Strings;

public class ClearCountryForSwitchedIntlUsers
{

    Application application;
    CountriesService countriesService;
    CurrentCountryDao currentCountryDao;
    CurrentCountryManager currentCountryManager;
    LocationService locationService;
    Logger logger;
    LoginService loginService;

    public ClearCountryForSwitchedIntlUsers()
    {
    }

    private boolean isSwitchedIntlUser()
    {
_L2:
        return false;
        if (!currentCountryManager.getCurrentCountry().isUSACompatible() || loginService.isLoggedIn()) goto _L2; else goto _L1
_L1:
        List list = countriesService.visitedCountryCodes();
        if (list.size() == 1) goto _L2; else goto _L3
_L3:
        TimeZone timezone;
        String s;
        timezone = TimeZone.getDefault();
        if (timezone == null)
        {
            break; /* Loop/switch isn't completed */
        }
        s = timezone.getID();
        if (Arrays.binarySearch(application.getResources().getStringArray(0x7f0f0016), s) >= 0) goto _L2; else goto _L4
_L4:
        logSwitchedUser(list, timezone);
        return true;
    }

    public void logSwitchedUser(List list, TimeZone timezone)
    {
        float f1 = 0.0F;
        String s = Strings.join("|", list);
        float f;
        if (timezone != null)
        {
            list = timezone.getID();
        } else
        {
            list = "";
        }
        timezone = locationService.getLocation();
        if (timezone != null)
        {
            f = (float)timezone.getLatitude();
        } else
        {
            f = 0.0F;
        }
        if (timezone != null)
        {
            f1 = (float)timezone.getLongitude();
        }
        logger.logGeneralEvent("upgrade_switched_user", "", String.format("%s,%s,%f,%f", new Object[] {
            s, list, Float.valueOf(f), Float.valueOf(f1)
        }), 1, Logger.NULL_NST_FIELD);
    }

    public void run()
    {
        try
        {
            if (isSwitchedIntlUser())
            {
                currentCountryDao.clearCountry();
            }
            return;
        }
        catch (Throwable throwable)
        {
            Ln.e(throwable);
        }
    }
}
