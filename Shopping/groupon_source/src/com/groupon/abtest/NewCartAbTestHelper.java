// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.abtest;

import com.groupon.service.core.AbTestService;

public class NewCartAbTestHelper
{

    public static final String CART_ICON_CLICK = "cart";
    public static final String CART_ICON_IMPRESSION = "cart";
    public static final String VIEW_CART_CLICK = "view_cart_click";
    protected AbTestService abTestService;

    public NewCartAbTestHelper()
    {
    }

    public boolean isCartCheckoutContinueShoppingEnabled()
    {
        return abTestService.isVariantEnabledAndUS("cartCheckoutContinueShopping1511US", "on");
    }

    public boolean isShoppingCartEnabled()
    {
        return abTestService.isVariantEnabledAndUS("cart1511US", "skipSummary") || abTestService.isVariantEnabledAndUS("cart1511US", "summary");
    }

    public boolean shouldSkipSummary()
    {
        return abTestService.isVariantEnabledAndUS("cart1511US", "skipSummary");
    }
}
