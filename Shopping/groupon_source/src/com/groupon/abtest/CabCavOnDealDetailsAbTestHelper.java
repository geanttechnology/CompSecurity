// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.abtest;

import com.groupon.db.models.Deal;
import com.groupon.models.country.Country;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import roboguice.util.Strings;

public class CabCavOnDealDetailsAbTestHelper
{

    private static final int DEFAULT_DEAL_DETAIL_ACTIVITIES_ON_STACK = 3;
    private static final int MAX_DEAL_DETAIL_ACTIVITIES_ON_STACK = 5;
    private static final int MIN_DEAL_DETAIL_ACTIVITIES_ON_STACK = 1;
    private AbTestService abTestService;
    private CurrentCountryManager currentCountryManager;

    public CabCavOnDealDetailsAbTestHelper()
    {
    }

    public boolean shouldDisplayCABWidget()
    {
        String s = abTestService.getVariant("cabCavOnDealDetails1504USCA");
        return s.equals("v2") || s.equals("v3");
    }

    public boolean shouldDisplayCAVWidget()
    {
        String s = abTestService.getVariant("cabCavOnDealDetails1504USCA");
        return s.equals("v1") || s.equals("v3");
    }

    public boolean shouldDisplayWidgets(Deal deal, boolean flag, int i)
    {
        boolean flag2 = true;
        if (!flag && currentCountryManager.getCurrentCountry().isUSACompatible() && deal.shippingAddressRequired)
        {
            deal = abTestService.getVariant("cabCavOnDealDetails1504USCA");
            boolean flag1;
            if (!Strings.isEmpty(deal) && !Strings.equalsIgnoreCase(deal, "Original"))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                if (i < Math.min(Math.max(1, 3), 5))
                {
                    flag = flag2;
                } else
                {
                    flag = false;
                }
                return flag;
            }
        }
        return false;
    }
}
