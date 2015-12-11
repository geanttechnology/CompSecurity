// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import android.text.TextUtils;
import com.ebay.common.model.cart.PayPalCheckoutDetails;
import com.ebay.common.net.JsonResponse;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.kernel.EbayIdentity;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Response;
import java.io.InputStream;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.net.api.cart:
//            EbayCartApi

public class PayPalCheckout
{
    public static final class PayPalCheckoutRequest extends EbayRequest
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
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            return null;
        }

        public URL getRequestUrl()
        {
            return url;
        }

        public PayPalCheckoutResponse getResponse()
        {
            return new PayPalCheckoutResponse();
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

        protected PayPalCheckoutRequest(EbayCartApi ebaycartapi, URL url1, String s, String s1, String s2, String s3, String s4, 
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

    public static final class PayPalCheckoutResponse extends JsonResponse
    {

        protected PayPalCheckoutDetails details;

        public PayPalCheckoutDetails getResponseDetails()
        {
            return details;
        }

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            super.parse(inputstream);
            try
            {
                inputstream = body.getJSONObject("PayPalCheckoutResponse");
                super.processAck(inputstream);
                details = new PayPalCheckoutDetails(inputstream, this);
                super.exportErrorsToResponse(details);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                throw com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException.create(inputstream);
            }
        }

        public PayPalCheckoutResponse()
        {
        }
    }


    public static final String MEC2_PP_HEADER_AP_ID = "x-paypal-app-id";
    public static final String MEC2_PP_HEADER_DYSON_DATA = "x-paypal-dyson-data";
    public static final String MEC2_PP_HEADER_FS_ID = "x-paypal-fs-id";
    public static final String MEC2_PP_HEADER_RM_TOKEN = "x-paypal-rm-token";
    public static final String MEC2_PP_HEADER_SESSION_ID = "x-paypal-session-id";
    public static final String MEC2_PP_HEADER_VISITOR_ID = "x-paypal-visitor-id";
    private static final String PP_MOBILE_API_DEVICE_ID = "x-ebay3pp-device-id";
    private static final String PP_MOBILE_APP_VERSION = "x-ebay-mobile-app-version";
    private static final String PP_MOBILE_IAF_TOKEN = "x-ebay-soa-security-iaftoken";

    public PayPalCheckout()
    {
    }
}
