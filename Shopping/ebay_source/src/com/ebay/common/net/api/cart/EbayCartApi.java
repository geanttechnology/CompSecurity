// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.ApiSettings;
import java.net.URL;
import java.util.Locale;
import org.json.JSONObject;

public class EbayCartApi
{

    static final String SOA_CART_SERVICE_NAME = "CartService";
    public static final String SOA_INCENTIVE_SERVICE_NAME = "CommonMobileAppService";
    private static final String payPalUserAgentFormat = "Mozilla/5.0 (eBayAndroid %s; Android %s; %s) AppleWebKit/533.1 (KHTML, like Gecko)";
    public final String applicationVersion;
    public final String iafToken;
    public final String payPalAppId;
    public String riskCorrelationId;
    public JSONObject riskPayload;
    public final EbaySite site;

    public EbayCartApi(String s, EbaySite ebaysite, String s1, String s2)
    {
        payPalAppId = s;
        site = ebaysite;
        iafToken = s1;
        applicationVersion = s2;
        if (s == null)
        {
            throw new NullPointerException("payPalAppId");
        } else
        {
            return;
        }
    }

    static URL getIncentiveServiceUrl()
    {
        return ApiSettings.getUrl(EbaySettings.commonMobileAppSvcUrl);
    }

    URL getSoaCartServiceUrl()
    {
        return ApiSettings.getUrl(EbaySettings.cartServicesUrl);
    }

    public final String payPalUserAgent()
    {
        return String.format("Mozilla/5.0 (eBayAndroid %s; Android %s; %s) AppleWebKit/533.1 (KHTML, like Gecko)", new Object[] {
            applicationVersion, android.os.Build.VERSION.RELEASE, Locale.US.toString()
        });
    }
}
