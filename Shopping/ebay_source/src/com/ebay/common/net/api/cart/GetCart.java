// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import android.text.TextUtils;
import com.ebay.common.model.cart.Cart;
import com.ebay.common.net.JsonResponse;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Response;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.net.api.cart:
//            EbayCartRequest, EbayCartApi

public class GetCart
{
    public static final class GetCartRequest extends EbayCartRequest
    {

        private final String X_EBAY_SOA_LOCALE_CURRENCY = "x-ebay-soa-locale-currency";
        final String cartId;
        private final String outputCurrencyCode;

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            byte abyte0[];
            try
            {
                JSONObject jsonobject = new JSONObject();
                buildClientContext(jsonobject);
                jsonobject.put("cartIdentifier", cartId);
                JSONObject jsonobject1 = new JSONObject();
                jsonobject1.put("getCartRequest", jsonobject);
                abyte0 = jsonobject1.toString().getBytes();
            }
            catch (JSONException jsonexception)
            {
                throw com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException.create(jsonexception);
            }
            return abyte0;
        }

        public GetCartResponse getResponse()
        {
            return new GetCartResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        public void onAddHeaders(IHeaders iheaders)
        {
            super.onAddHeaders(iheaders);
            if (!TextUtils.isEmpty(outputCurrencyCode))
            {
                iheaders.setHeader("x-ebay-soa-locale-currency", outputCurrencyCode);
            }
        }

        protected GetCartRequest(EbayCartApi ebaycartapi, String s, String s1)
        {
            super(ebaycartapi, "getCart");
            cartId = s;
            outputCurrencyCode = s1;
        }
    }

    public static final class GetCartResponse extends JsonResponse
    {

        protected Cart result;

        public Cart getResponseCart()
        {
            return result;
        }

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            super.parse(inputstream);
            try
            {
                inputstream = body.getJSONObject("getCartResponse");
                super.processAck(inputstream);
                result = new Cart(inputstream.getJSONObject("cartResponse"));
                super.exportErrorsToResponse(result);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                throw com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException.create(inputstream);
            }
        }

        public GetCartResponse()
        {
            result = null;
        }
    }


    public GetCart()
    {
    }
}
