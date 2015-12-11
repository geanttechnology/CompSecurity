// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.interception;

import android.content.Context;
import android.net.Uri;
import com.amazon.mobile.mash.interception.MASHUrlIntercepter;
import com.amazon.mobile.mash.interception.UrlIntercepterConfigEntry;
import com.amazon.mobile.mash.interception.UrlInterceptionHandler;

// Referenced classes of package com.amazon.mShop.mash.interception:
//            HomeInterceptionHandler, SearchInterceptionHandler, BrowseInterceptionHandler, CartInterceptionHandler, 
//            DetailInterceptionHandler, CheckoutInterceptionHandler, AppStoreInterceptionHandler

public class MShopUrlIntercepter extends MASHUrlIntercepter
{

    public MShopUrlIntercepter()
    {
    }

    public UrlInterceptionHandler buildHandler(String s, Context context)
    {
        s = Uri.parse(s);
        UrlIntercepterConfigEntry urlintercepterconfigentry = getConfigEntryForUri(s);
        if (urlintercepterconfigentry == null)
        {
            return null;
        }
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$mobile$mash$interception$MASHUrlIntercepter$UrlDestination[];

            static 
            {
                $SwitchMap$com$amazon$mobile$mash$interception$MASHUrlIntercepter$UrlDestination = new int[com.amazon.mobile.mash.interception.MASHUrlIntercepter.UrlDestination.values().length];
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$interception$MASHUrlIntercepter$UrlDestination[com.amazon.mobile.mash.interception.MASHUrlIntercepter.UrlDestination.home.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$interception$MASHUrlIntercepter$UrlDestination[com.amazon.mobile.mash.interception.MASHUrlIntercepter.UrlDestination.search.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$interception$MASHUrlIntercepter$UrlDestination[com.amazon.mobile.mash.interception.MASHUrlIntercepter.UrlDestination.browse.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$interception$MASHUrlIntercepter$UrlDestination[com.amazon.mobile.mash.interception.MASHUrlIntercepter.UrlDestination.cart.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$interception$MASHUrlIntercepter$UrlDestination[com.amazon.mobile.mash.interception.MASHUrlIntercepter.UrlDestination.detail.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$interception$MASHUrlIntercepter$UrlDestination[com.amazon.mobile.mash.interception.MASHUrlIntercepter.UrlDestination.checkout.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$interception$MASHUrlIntercepter$UrlDestination[com.amazon.mobile.mash.interception.MASHUrlIntercepter.UrlDestination.appstore.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.amazon.mobile.mash.interception.MASHUrlIntercepter.UrlDestination[urlintercepterconfigentry.getDestination().ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return new HomeInterceptionHandler(context, s, urlintercepterconfigentry);

        case 2: // '\002'
            return new SearchInterceptionHandler(context, s, urlintercepterconfigentry);

        case 3: // '\003'
            return new BrowseInterceptionHandler(context, s, urlintercepterconfigentry);

        case 4: // '\004'
            return new CartInterceptionHandler(context, s, urlintercepterconfigentry);

        case 5: // '\005'
            return new DetailInterceptionHandler(context, s, urlintercepterconfigentry);

        case 6: // '\006'
            return new CheckoutInterceptionHandler(context, s, urlintercepterconfigentry);

        case 7: // '\007'
            return new AppStoreInterceptionHandler(context, s, urlintercepterconfigentry);
        }
    }
}
