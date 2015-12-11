// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopcase;

import android.net.Uri;
import android.util.Log;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.CosVersionType;
import com.ebay.nautilus.domain.net.EbayCosRequest;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.Gson;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopcase:
//            ShopcaseCheckoutSessionResponse

public final class CreateCheckoutSessionRequest extends EbayCosRequest
{
    private static final class CheckoutFlow extends Enum
    {

        private static final CheckoutFlow $VALUES[];
        public static final CheckoutFlow EBAY_PROGRESSEIV_XO_FLOW_IDENTIFIER;
        public static final CheckoutFlow EBAY_PROGRESSEIV_XO_MOBLIE_FLOW_IDENTIFIER;
        public static final CheckoutFlow EBAY_SBC_APP_SUPPORT_XO_FLOW_IDENTIFIER;
        public static final CheckoutFlow EBAY_SVC_BASED_CHECKOUT_FLOW_IDENTIFIER;

        public static CheckoutFlow valueOf(String s)
        {
            return (CheckoutFlow)Enum.valueOf(com/ebay/nautilus/domain/net/api/shopcase/CreateCheckoutSessionRequest$CheckoutFlow, s);
        }

        public static CheckoutFlow[] values()
        {
            return (CheckoutFlow[])$VALUES.clone();
        }

        static 
        {
            EBAY_SVC_BASED_CHECKOUT_FLOW_IDENTIFIER = new CheckoutFlow("EBAY_SVC_BASED_CHECKOUT_FLOW_IDENTIFIER", 0);
            EBAY_SBC_APP_SUPPORT_XO_FLOW_IDENTIFIER = new CheckoutFlow("EBAY_SBC_APP_SUPPORT_XO_FLOW_IDENTIFIER", 1);
            EBAY_PROGRESSEIV_XO_FLOW_IDENTIFIER = new CheckoutFlow("EBAY_PROGRESSEIV_XO_FLOW_IDENTIFIER", 2);
            EBAY_PROGRESSEIV_XO_MOBLIE_FLOW_IDENTIFIER = new CheckoutFlow("EBAY_PROGRESSEIV_XO_MOBLIE_FLOW_IDENTIFIER", 3);
            $VALUES = (new CheckoutFlow[] {
                EBAY_SVC_BASED_CHECKOUT_FLOW_IDENTIFIER, EBAY_SBC_APP_SUPPORT_XO_FLOW_IDENTIFIER, EBAY_PROGRESSEIV_XO_FLOW_IDENTIFIER, EBAY_PROGRESSEIV_XO_MOBLIE_FLOW_IDENTIFIER
            });
        }

        private CheckoutFlow(String s, int i)
        {
            super(s, i);
        }
    }

    private static final class CheckoutLevel extends Enum
    {

        private static final CheckoutLevel $VALUES[];
        public static final CheckoutLevel FULL_CART;
        public static final CheckoutLevel ITEMS;
        public static final CheckoutLevel SELLER_GROUP;

        public static CheckoutLevel valueOf(String s)
        {
            return (CheckoutLevel)Enum.valueOf(com/ebay/nautilus/domain/net/api/shopcase/CreateCheckoutSessionRequest$CheckoutLevel, s);
        }

        public static CheckoutLevel[] values()
        {
            return (CheckoutLevel[])$VALUES.clone();
        }

        static 
        {
            FULL_CART = new CheckoutLevel("FULL_CART", 0);
            SELLER_GROUP = new CheckoutLevel("SELLER_GROUP", 1);
            ITEMS = new CheckoutLevel("ITEMS", 2);
            $VALUES = (new CheckoutLevel[] {
                FULL_CART, SELLER_GROUP, ITEMS
            });
        }

        private CheckoutLevel(String s, int i)
        {
            super(s, i);
        }
    }

    public static class RequestBody
    {

        public boolean bopisSupported;
        public CheckoutFlow checkoutFlow;
        public CheckoutLevel checkoutLevel;
        public Map clientAttributes;
        public boolean gbhUser;
        public boolean guestCheckout;
        public Collection itemReferenceIds;
        public Long sellerId;

        public RequestBody()
        {
        }
    }


    private static final String LOG_TAG = "CreateXoSessionRequest";
    private static final String OPERATION_NAME = "CreateCheckoutSession";
    private static final String RESOURCE_PATH = "shopcart/checkout/createsession";
    private static final String SERVICE_NAME = "Shopcase";
    private final boolean bopisSupported = true;
    private final CheckoutFlow checkoutFlow;
    private final CheckoutLevel checkoutLevel;
    private final Map clientAttributes;
    private final boolean gbhUser = false;
    private final boolean guestCheckout = false;
    private final Collection itemReferenceIds;
    private final Long sellerId = null;

    public CreateCheckoutSessionRequest(String s, EbaySite ebaysite, Collection collection, boolean flag, Map map)
    {
        super("Shopcase", "CreateCheckoutSession", CosVersionType.V2);
        iafToken = s;
        itemReferenceIds = collection;
        checkoutLevel = CheckoutLevel.ITEMS;
        if (flag)
        {
            s = CheckoutFlow.EBAY_PROGRESSEIV_XO_MOBLIE_FLOW_IDENTIFIER;
        } else
        {
            s = CheckoutFlow.EBAY_SVC_BASED_CHECKOUT_FLOW_IDENTIFIER;
        }
        checkoutFlow = s;
        clientAttributes = map;
        marketPlaceId = ebaysite.idString;
        serviceVersion = "2.0.1";
        requestBodyContentType = "application/json";
        responseBodyContentType = "application/json";
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        RequestBody requestbody = new RequestBody();
        requestbody.itemReferenceIds = itemReferenceIds;
        requestbody.checkoutLevel = checkoutLevel;
        requestbody.sellerId = sellerId;
        requestbody.checkoutFlow = checkoutFlow;
        requestbody.guestCheckout = guestCheckout;
        requestbody.gbhUser = gbhUser;
        requestbody.bopisSupported = bopisSupported;
        requestbody.clientAttributes = clientAttributes;
        return defaultRequestMapper.toJson(requestbody).getBytes();
    }

    public String getHttpMethod()
    {
        return "POST";
    }

    public URL getRequestUrl()
    {
        Object obj;
        try
        {
            obj = Uri.parse(ApiSettings.getUrl(ApiSettings.shopcaseApiUrl).toString()).buildUpon();
            ((android.net.Uri.Builder) (obj)).appendEncodedPath("shopcart/checkout/createsession");
            obj = new URL(((android.net.Uri.Builder) (obj)).build().toString());
        }
        catch (MalformedURLException malformedurlexception)
        {
            Log.e("CreateXoSessionRequest", "Unable to parse URL", malformedurlexception);
            return null;
        }
        return ((URL) (obj));
    }

    public ShopcaseCheckoutSessionResponse getResponse()
    {
        return new ShopcaseCheckoutSessionResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public boolean isIdempotent()
    {
        return false;
    }
}
