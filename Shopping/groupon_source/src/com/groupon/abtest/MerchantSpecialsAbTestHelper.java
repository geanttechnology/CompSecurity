// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.abtest;

import com.groupon.models.Place;
import com.groupon.models.division.Division;
import com.groupon.service.core.AbTestService;
import com.groupon.util.DivisionUtil;
import com.groupon.util.GeoPoint;
import com.groupon.util.SecurityUtil;

public class MerchantSpecialsAbTestHelper
{

    private AbTestService abTestService;
    private DivisionUtil divisionUtil;

    public MerchantSpecialsAbTestHelper()
    {
    }

    public boolean isMerchantSpecialsEnabled(Place place)
    {
        place = divisionUtil.getDivisionFrom(new GeoPoint((int)(place.lat * 1000000D), (int)(place.lng * 1000000D))).id;
        return abTestService.isVariantEnabledAndUSCA("merchantSpecialsEnabledDivisions1510", "All") || abTestService.isVariantListEnabled("merchantSpecialsEnabledDivisions1510", SecurityUtil.getMD5ForString(place));
    }
}
