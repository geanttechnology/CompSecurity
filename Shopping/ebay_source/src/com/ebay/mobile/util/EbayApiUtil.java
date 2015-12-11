// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.util;

import android.content.Context;
import com.ebay.common.ObfuscatedData;
import com.ebay.common.Preferences;
import com.ebay.common.net.api.aps.ApplicationProcessServiceApi;
import com.ebay.common.net.api.autocomplete.AutoCompleteApi;
import com.ebay.common.net.api.cart.EbayCartApi;
import com.ebay.common.net.api.catalog.CatalogMatchProductService;
import com.ebay.common.net.api.finditem.FindItemService;
import com.ebay.common.net.api.findproduct.FindProductService;
import com.ebay.common.net.api.fuss.EbayFussApi;
import com.ebay.common.net.api.mftd.EbayMftdApi;
import com.ebay.common.net.api.product.EbayProductApi;
import com.ebay.mobile.MyApp;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.domain.net.api.shopping.EbayShoppingApi;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.util.ArrayList;

public final class EbayApiUtil
{

    private EbayApiUtil()
    {
    }

    public static com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException buildOutOfMemoryError(OutOfMemoryError outofmemoryerror)
    {
        Object obj1 = MyApp.getApp().getString(0x7f070155);
        Object obj = new EbayResponseError();
        obj.category = 2;
        obj.severity = 1;
        obj.shortMessage = ((String) (obj1));
        obj.longMessage = ((String) (obj1));
        obj1 = new ArrayList(1);
        ((ArrayList) (obj1)).add(obj);
        obj = new com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException(((ArrayList) (obj1)));
        ((com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException) (obj)).initCause(outofmemoryerror);
        return ((com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException) (obj));
    }

    public static final ApplicationProcessServiceApi getApsApi(EbayContext ebaycontext)
    {
        return new ApplicationProcessServiceApi(ebaycontext, getCurrentSite());
    }

    public static final AutoCompleteApi getAutoCompleteApi(EbayContext ebaycontext, EbayCountry ebaycountry)
    {
        return new AutoCompleteApi(ebaycontext, ebaycountry);
    }

    public static final EbayCartApi getCartApi(Context context, Authentication authentication)
    {
        if (authentication == null)
        {
            throw new NullPointerException("authentication");
        }
        DeviceConfiguration.getAsync();
        Object obj = getCurrentCountry();
        if ("RU".equals(((EbayCountry) (obj)).getCountryCode()))
        {
            obj = EbaySite.RU;
        } else
        {
            obj = ((EbayCountry) (obj)).getSite();
        }
        return new EbayCartApi(ObfuscatedData.decryptedPayPalAppId, ((EbaySite) (obj)), authentication.iafToken, NautilusKernel.getAppVersionName(context));
    }

    public static final EbayCountry getCurrentCountry()
    {
        return MyApp.getPrefs().getCurrentCountry();
    }

    public static final EbaySite getCurrentSite()
    {
        return MyApp.getPrefs().getCurrentSite();
    }

    public static final FindItemService getFindItemService(Context context, EbaySite ebaysite)
    {
        return new FindItemService(ebaysite);
    }

    public static final FindProductService getFindProductService(Context context, EbaySite ebaysite)
    {
        return new FindProductService(ebaysite);
    }

    public static final EbayFussApi getFindingUserSettingsApi(EbayContext ebaycontext)
    {
        return new EbayFussApi(ebaycontext, getCurrentCountry());
    }

    public static final CatalogMatchProductService getMatchProductService(Context context, EbaySite ebaysite)
    {
        return new CatalogMatchProductService(ebaysite);
    }

    public static final EbayMftdApi getMftdApi(EbayContext ebaycontext)
    {
        return new EbayMftdApi(ebaycontext, getCurrentSite());
    }

    public static final EbayProductApi getProductApi(Context context, EbaySite ebaysite)
    {
        return new EbayProductApi(ebaysite);
    }

    public static final EbayShoppingApi getShoppingApi(Context context)
    {
        return new EbayShoppingApi(getCurrentSite());
    }

    public static final EbayTradingApi getTradingApi(Context context, Authentication authentication)
    {
        if (authentication == null)
        {
            throw new NullPointerException("authentication");
        } else
        {
            return new EbayTradingApi(getCurrentSite(), authentication.iafToken);
        }
    }

    public static final EbayTradingApi getTradingApi(EbaySite ebaysite, Context context, Authentication authentication)
    {
        if (authentication == null)
        {
            throw new NullPointerException("authentication");
        } else
        {
            return new EbayTradingApi(ebaysite, authentication.iafToken);
        }
    }
}
