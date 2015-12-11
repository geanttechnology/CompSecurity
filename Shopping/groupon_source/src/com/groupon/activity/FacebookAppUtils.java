// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.SharedPreferences;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import roboguice.util.Strings;

public class FacebookAppUtils
{

    private CurrentCountryManager currentCountryManager;
    private SharedPreferences prefs;

    public FacebookAppUtils()
    {
    }

    public String getFacebookAppId()
    {
        if (currentCountryManager.getCurrentCountry() == null)
        {
            return "";
        }
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            return Strings.toString("7829106395");
        } else
        {
            return Strings.toString(currentCountryManager.getCurrentCountry().facebookAppId);
        }
    }

    public boolean isFacebookLoginAvailable()
    {
        return Strings.notEmpty(getFacebookAppId()) && prefs.getBoolean("facebookLoginEnabled", true);
    }
}
