// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import android.text.TextUtils;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.kernel.EbayIdentity;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Response;
import java.net.URL;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.net.api.cart:
//            PayPalCheckout, EbayCartApi

public static final class riskPayload extends EbayRequest
{

    final String appVersion;
    final String authToken;
    final String fundingSourceId;
    final EbayCartApi handle;
    final String paymentToken;
    final JSONObject riskPayload;
    final String sessionId;
    final URL url;
    final String visitorId;

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.riskPayload
    {
        return null;
    }

    public URL getRequestUrl()
    {
        return url;
    }

    public  getResponse()
    {
        return new ();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public String getUserAgent()
    {
        return handle.payPalUserAgent();
    }

    public void onAddHeaders(IHeaders iheaders)
    {
        iheaders.setHeader("x-ebay-soa-security-iaftoken", paymentToken);
        iheaders.setHeader("x-ebay3pp-device-id", EbayIdentity.get3ppFingerprint(getContext()));
        iheaders.setHeader("x-ebay-mobile-app-version", appVersion);
        iheaders.setHeader("x-paypal-app-id", handle.payPalAppId);
        if (!TextUtils.isEmpty(visitorId))
        {
            iheaders.setHeader("x-paypal-visitor-id", visitorId);
        }
        if (!TextUtils.isEmpty(sessionId))
        {
            iheaders.setHeader("x-paypal-session-id", sessionId);
        }
        if (!TextUtils.isEmpty(authToken))
        {
            iheaders.setHeader("x-paypal-rm-token", authToken);
        }
        if (!TextUtils.isEmpty(fundingSourceId))
        {
            iheaders.setHeader("x-paypal-fs-id", fundingSourceId);
        }
        if (riskPayload != null)
        {
            iheaders.setHeader("x-paypal-dyson-data", riskPayload.toString());
        }
        super.onAddHeaders(iheaders);
    }

    protected (EbayCartApi ebaycartapi, URL url1, String s, String s1, String s2, String s3, String s4, 
            String s5, JSONObject jsonobject)
    {
        handle = ebaycartapi;
        url = url1;
        appVersion = s;
        paymentToken = s1;
        authToken = s2;
        visitorId = s3;
        sessionId = s4;
        fundingSourceId = s5;
        riskPayload = jsonobject;
    }
}
