// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.SharedPreferences;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;

public class OnBoardingService
{

    private CurrentCountryManager currentCountryManager;
    private SharedPreferences prefs;

    public OnBoardingService()
    {
    }

    public void setShowForcedOnBoarding(boolean flag)
    {
        prefs.edit().putBoolean("forceShowOnBoarding", flag).apply();
    }

    public void setShowOnBoarding(boolean flag)
    {
        if (!currentCountryManager.getCurrentCountry().shouldShowOnBoarding())
        {
            return;
        } else
        {
            prefs.edit().putBoolean((new StringBuilder()).append("showOnBoarding").append(currentCountryManager.getCurrentCountry().isoName).toString(), flag).apply();
            return;
        }
    }

    public boolean shouldShowForcedOnBoarding()
    {
        return prefs.getBoolean("forceShowOnBoarding", false);
    }

    public boolean shouldShowOnBoarding()
    {
        boolean flag = true;
        if (!currentCountryManager.getCurrentCountry().shouldShowOnBoarding())
        {
            flag = false;
        } else
        if (!shouldShowForcedOnBoarding())
        {
            return prefs.getBoolean((new StringBuilder()).append("showOnBoarding").append(currentCountryManager.getCurrentCountry().isoName).toString(), true);
        }
        return flag;
    }
}
