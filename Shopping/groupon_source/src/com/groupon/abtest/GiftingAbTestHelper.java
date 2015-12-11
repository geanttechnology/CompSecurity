// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.abtest;

import com.groupon.service.core.AbTestService;

public class GiftingAbTestHelper
{

    private AbTestService abTestService;

    public GiftingAbTestHelper()
    {
    }

    public boolean isThemeSelectionOptional()
    {
        return abTestService.isVariantEnabledAndUSCA("addGiftingButtonAndNewFlow1510USCA", "dealPageGiftButtonThemeOptional");
    }

    public boolean isThemeSelectionRequired()
    {
        return abTestService.isVariantEnabledAndUSCA("addGiftingButtonAndNewFlow1510USCA", "dealPageGiftButtonThemeRequired");
    }

    public boolean shouldAddGiftingButtonOnDealDetail()
    {
        return abTestService.isVariantEnabledAndUSCA("addGiftingButtonAndNewFlow1510USCA", "dealPageGiftButton") || shouldShowGiftNewFlow1510USCA();
    }

    public boolean shouldShowGiftNewFlow1510USCA()
    {
        return isThemeSelectionOptional() || isThemeSelectionRequired();
    }
}
