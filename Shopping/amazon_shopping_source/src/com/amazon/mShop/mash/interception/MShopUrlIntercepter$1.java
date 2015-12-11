// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.interception;


// Referenced classes of package com.amazon.mShop.mash.interception:
//            MShopUrlIntercepter

static class lDestination
{

    static final int $SwitchMap$com$amazon$mobile$mash$interception$MASHUrlIntercepter$UrlDestination[];

    static 
    {
        $SwitchMap$com$amazon$mobile$mash$interception$MASHUrlIntercepter$UrlDestination = new int[com.amazon.mobile.mash.interception.Destination.values().length];
        try
        {
            $SwitchMap$com$amazon$mobile$mash$interception$MASHUrlIntercepter$UrlDestination[com.amazon.mobile.mash.interception.Destination.home.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$amazon$mobile$mash$interception$MASHUrlIntercepter$UrlDestination[com.amazon.mobile.mash.interception.Destination.search.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$amazon$mobile$mash$interception$MASHUrlIntercepter$UrlDestination[com.amazon.mobile.mash.interception.Destination.browse.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$amazon$mobile$mash$interception$MASHUrlIntercepter$UrlDestination[com.amazon.mobile.mash.interception.Destination.cart.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$mobile$mash$interception$MASHUrlIntercepter$UrlDestination[com.amazon.mobile.mash.interception.Destination.detail.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$mobile$mash$interception$MASHUrlIntercepter$UrlDestination[com.amazon.mobile.mash.interception.Destination.checkout.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$mobile$mash$interception$MASHUrlIntercepter$UrlDestination[com.amazon.mobile.mash.interception.Destination.appstore.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
