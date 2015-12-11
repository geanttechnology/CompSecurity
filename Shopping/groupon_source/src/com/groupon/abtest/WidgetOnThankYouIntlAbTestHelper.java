// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.abtest;

import com.groupon.models.country.Country;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;

public class WidgetOnThankYouIntlAbTestHelper
{

    private AbTestService abTestService;
    private CurrentCountryManager currentCountryManager;

    public WidgetOnThankYouIntlAbTestHelper()
    {
    }

    public boolean isMegamindOnThankYouScreenEnabledINTL()
    {
        boolean flag = abTestService.isINTLVariantEnabled("megamindOnThankYouScreen1511INTL", "recentlyViewedOnly");
        boolean flag1 = abTestService.isINTLVariantEnabled("megamindOnThankYouScreen1511INTL", "rvdCabCavSingleDeal");
        boolean flag2 = abTestService.isINTLVariantEnabled("megamindOnThankYouScreen1511INTL", "rvdCabCavThreeDeals");
        return currentCountryManager.getCurrentCountry().isMegamindEnabledCountry() && (flag || flag1 || flag2);
    }
}
