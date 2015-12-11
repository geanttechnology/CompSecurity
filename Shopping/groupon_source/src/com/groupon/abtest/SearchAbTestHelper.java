// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.abtest;

import com.groupon.models.country.Country;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;

public class SearchAbTestHelper
{

    private AbTestService abTestService;
    private CurrentCountryManager currentCountryManager;

    public SearchAbTestHelper()
    {
    }

    public boolean isRapiSearch1511Enabled()
    {
        return android.os.Build.VERSION.SDK_INT >= 17 && abTestService.isVariantEnabledAndUSCA("rapiSearch1511USCA", "on");
    }

    public boolean isSearchEnabled()
    {
        return currentCountryManager.getCurrentCountry().isSearchEnabledCountry() && abTestService.isINTLVariantEnabled("intlSearch1403%s", "on") || currentCountryManager.getCurrentCountry().isUnitedKingdom();
    }

    public boolean isUniversalSearchChannelSelectorEnabled()
    {
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            return abTestService.isVariantEnabled("globalSearchChannelSelector1506USCA", "on");
        } else
        {
            return abTestService.isVariantEnabled("globalSearchChannelSelector1506INTL", "on");
        }
    }

    public boolean isUniversalSearchRedesignEnabled()
    {
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            return abTestService.isVariantEnabled("globalSearchRedesign1505USCA", "on");
        } else
        {
            return abTestService.isVariantEnabled("globalSearchRedesign1505INTL", "on");
        }
    }
}
