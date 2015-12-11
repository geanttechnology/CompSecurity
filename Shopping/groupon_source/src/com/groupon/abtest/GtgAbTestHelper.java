// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.abtest;

import com.groupon.models.division.Division;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.util.DealCardListUtils;
import com.groupon.util.GtgZoneUtil;
import com.groupon.util.SecurityUtil;

// Referenced classes of package com.groupon.abtest:
//            RapiAbTestHelper

public class GtgAbTestHelper
{

    private AbTestService abTestService;
    private CurrentDivisionManager currentDivisionManager;
    private DealCardListUtils dealCardListUtils;
    private GtgZoneUtil gtgZoneUtil;
    private RapiAbTestHelper rapiAbTestHelper;

    public GtgAbTestHelper()
    {
    }

    private boolean isGtgEnabledForCurrentDivision()
    {
        return abTestService.isVariantEnabledAndUSCA("GTGEnabledDivisions1510USCA", "All") || abTestService.isVariantListEnabled("GTGEnabledDivisions1510USCA", SecurityUtil.getMD5ForString(currentDivisionManager.getCurrentDivision().id));
    }

    public boolean isGtgJumpoffCardOnFeatured()
    {
        if (rapiAbTestHelper.isFeaturedUsingRAPI1511USCAEnabled() || dealCardListUtils.getNumberOfColumns() == 1)
        {
            if (abTestService.isVariantEnabledAndUS("GTGJumpoff1511US", "zone"))
            {
                return gtgZoneUtil.isCurrentLocationInValidZone();
            }
            if (abTestService.isVariantEnabledAndUS("GTGJumpoff1511US", "All") || abTestService.isVariantListEnabled("GTGJumpoff1511US", SecurityUtil.getMD5ForString(currentDivisionManager.getCurrentDivision().id)))
            {
                return true;
            }
        }
        return false;
    }

    public boolean isGtgNewFlagDivision()
    {
        return abTestService.isVariantEnabledAndUSCA("GTGNewFlagDivisions1510USCA", "All") || abTestService.isVariantListEnabled("GTGNewFlagDivisions1510USCA", SecurityUtil.getMD5ForString(currentDivisionManager.getCurrentDivision().id));
    }

    public boolean isGtgOnNearby()
    {
        if (abTestService.isVariantEnabledAndUS("GTGOnNearby1511US", "zone"))
        {
            return gtgZoneUtil.isCurrentLocationInValidZone();
        }
        if (abTestService.isVariantEnabledAndUS("GTGOnNearby1511US", "division"))
        {
            return isGtgEnabledForCurrentDivision();
        } else
        {
            return false;
        }
    }

    public boolean isGtgOnSearch()
    {
        if (abTestService.isVariantEnabledAndUS("GTGOnSearch1511US", "zone"))
        {
            return gtgZoneUtil.isCurrentLocationInValidZone();
        }
        if (abTestService.isVariantEnabledAndUS("GTGOnSearch1511US", "division"))
        {
            return isGtgEnabledForCurrentDivision();
        } else
        {
            return false;
        }
    }

    public boolean isGtgPromoCardOnFeatured()
    {
        return abTestService.isVariantEnabledAndUSCA("GTGOnFeatured1506USCA", "on") && isGtgEnabledForCurrentDivision();
    }
}
