// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.interception;

import java.util.ArrayList;
import java.util.Collections;

// Referenced classes of package com.amazon.mobile.mash.interception:
//            UrlIntercepterConfigEntry

public final class UrlIntercepterConfigManager
{

    private static UrlIntercepterConfigManager sConfigManager;
    private ArrayList mUrlHandlerList;

    private UrlIntercepterConfigManager()
    {
        initUrlHandlerList();
    }

    public static UrlIntercepterConfigManager getInstance()
    {
        com/amazon/mobile/mash/interception/UrlIntercepterConfigManager;
        JVM INSTR monitorenter ;
        UrlIntercepterConfigManager urlintercepterconfigmanager;
        if (sConfigManager == null)
        {
            sConfigManager = new UrlIntercepterConfigManager();
        }
        urlintercepterconfigmanager = sConfigManager;
        com/amazon/mobile/mash/interception/UrlIntercepterConfigManager;
        JVM INSTR monitorexit ;
        return urlintercepterconfigmanager;
        Exception exception;
        exception;
        throw exception;
    }

    public static void init()
    {
        getInstance();
    }

    private void initUrlHandlerList()
    {
        mUrlHandlerList = new ArrayList();
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.browse, "*/gp/b"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.browse, "*/gp/b/*"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.browse, "*/b"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.browse, "*/b/*"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.browse, "*/gp/browse.html"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.browse, "*/gp/browse"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.browse, "*/gp/browse/*"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.browse, "*/mn/s/browse"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.browse, "*/mn/search/browse"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.browse, "*/s/browse"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.browse, "*/*/b"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.browse, "*/*/b/*"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.browse, "*/*/s/browse"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.cart, "*/gp/cart/view.html"));
        mUrlHandlerList.add((new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.detail, "*/gp/aw/d/*")).addUrlPathIndexToParseParameter("asin", 3));
        mUrlHandlerList.add((new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.detail, "*/dp/*")).addUrlPathIndexToParseParameter("asin", 1));
        mUrlHandlerList.add((new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.detail, "*/gp/mobile/dp/*")).addUrlPathIndexToParseParameter("asin", 3));
        mUrlHandlerList.add((new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.detail, "*/gp/mobile/udp/*")).addUrlPathIndexToParseParameter("asin", 3));
        mUrlHandlerList.add((new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.detail, "*/gp/product/*")).addUrlPathIndexToParseParameter("asin", 2));
        mUrlHandlerList.add((new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.detail, "*/exec/obidos/ASIN/*")).addUrlPathIndexToParseParameter("asin", 3));
        mUrlHandlerList.add((new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.detail, "*/*/dp/*")).addUrlPathIndexToParseParameter("asin", 2));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.home, "*/gp/homepage.html"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.home, "*/gp/mobile/ipad-home"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.home, "*/gp/mobile/tablet-browse"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.home, "*/gp/aw"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.home, "*"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.home, "*/exec/obidos/subst/home/home.html"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.home, "*/home"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.home, "*/postSignIn"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.home, "*/zipCheck"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.home, "*/start"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.home, "*/start/*"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.search, "*/s"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.search, "*/s/*"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.search, "*/*/s"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.search, "*/*/s/*"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.search, "*/gp/s"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.search, "*/gp/search"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.search, "*/gp/aw/search/s"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.search, "*/gp/aw/s"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.search, "*/gp/aw/s/*"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.search, "*/mn/s"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.search, "*/mn/search"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.checkout, "*/gp/checkoutportal/enter-checkout.html"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.order_status, "*/orderStatus"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.order_status, "*/orderStatus/*"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.prime_sign_up, "*/primeSignUp"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.checkout, "*/checkout/*"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.your_account, "*/yourAccount"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.your_account, "*/yourOrders"));
        mUrlHandlerList.add(new UrlIntercepterConfigEntry(MASHUrlIntercepter.UrlDestination.appstore, "*/gp/mshop/apps"));
        Collections.sort(mUrlHandlerList);
    }

    public ArrayList getUrlConfigList()
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist = mUrlHandlerList;
        this;
        JVM INSTR monitorexit ;
        return arraylist;
        Exception exception;
        exception;
        throw exception;
    }
}
