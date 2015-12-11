// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.abtest;

import com.groupon.service.core.AbTestService;

public class SnapAbTestHelper
{

    private AbTestService abTestService;

    public SnapAbTestHelper()
    {
    }

    public boolean isSnapEntryPointNearbyEnabled()
    {
        return abTestService.isVariantListEnabledAndUSCA("snapEntryPoint1510USCA", "nearby");
    }

    public boolean isSnapEntryPointSearchEnabled()
    {
        return abTestService.isVariantListEnabledAndUSCA("snapEntryPoint1510USCA", "search");
    }

    public boolean isSnapNearbyCarouselCategoryEnabled()
    {
        return abTestService.isVariantListEnabledAndUSCA("snapEntryPoint1510USCA", "nearbyCarousel");
    }
}
