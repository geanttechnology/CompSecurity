// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.abtest;

import com.groupon.service.core.AbTestService;

public class BadgesAbTestHelper
{

    private AbTestService abTestService;

    public BadgesAbTestHelper()
    {
    }

    public boolean isShowBadgeOnFeaturedGapi()
    {
        return abTestService.isVariantEnabledAndUSCA("showBadgeOnGAPIFeaturedTab1509USCA", "on");
    }

    public boolean isShowBadgeOnFeaturedRapi()
    {
        return abTestService.isVariantEnabledAndUSCA("showBadgeOnRAPIFeaturedTab1509USCA", "on");
    }

    public boolean isShowBadgeOnSearch()
    {
        return abTestService.isVariantEnabledAndUSCA("showBadgeOnSearch1509USCA", "on");
    }
}
