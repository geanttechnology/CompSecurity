// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.net.URL;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.net.api.cart:
//            EbayCartApi

public class PayPalCheckoutNetLoader extends EbaySimpleNetLoader
{

    private final EbayCartApi api;
    private final String appVersion;
    private final String authToken;
    private final String fundingSourceId;
    private final String paymentToken;
    private final JSONObject riskPayload;
    private final String sessionId;
    private final URL url;
    private final String visitorId;

    public PayPalCheckoutNetLoader(EbayContext ebaycontext, EbayCartApi ebaycartapi, URL url1, String s, String s1, String s2, String s3, 
            String s4, String s5, JSONObject jsonobject)
    {
        super(ebaycontext);
        api = ebaycartapi;
        url = url1;
        appVersion = s;
        paymentToken = s1;
        authToken = s2;
        visitorId = s3;
        sessionId = s4;
        fundingSourceId = s5;
        riskPayload = jsonobject;
    }

    protected EbayRequest createRequest()
    {
        return new PayPalCheckout.PayPalCheckoutRequest(api, url, appVersion, paymentToken, authToken, visitorId, sessionId, fundingSourceId, riskPayload);
    }

    public boolean isServiceError()
    {
        return false;
    }
}
