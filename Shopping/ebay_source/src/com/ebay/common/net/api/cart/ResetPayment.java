// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import com.ebay.common.model.cart.Cart;
import com.ebay.common.net.JsonResponse;
import com.ebay.nautilus.kernel.net.Response;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.net.api.cart:
//            EbayCartRequest, EbayCartApi

public class ResetPayment
{
    public static final class ResetPaymentRequest extends EbayCartRequest
    {

        final String cartId;

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            byte abyte0[];
            try
            {
                JSONObject jsonobject = new JSONObject();
                jsonobject.put("cartIdentifier", cartId);
                JSONObject jsonobject1 = new JSONObject();
                jsonobject1.put("resetPaymentRequest", jsonobject);
                abyte0 = jsonobject1.toString().getBytes();
            }
            catch (JSONException jsonexception)
            {
                throw com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException.create(jsonexception);
            }
            return abyte0;
        }

        public ResetPaymentResponse getResponse()
        {
            return new ResetPaymentResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        protected ResetPaymentRequest(EbayCartApi ebaycartapi, String s)
        {
            super(ebaycartapi, "getCart");
            cartId = s;
        }
    }

    public static final class ResetPaymentResponse extends JsonResponse
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
                inputstream = body.getJSONObject("resetPaymentResponse");
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

        public ResetPaymentResponse()
        {
            result = null;
        }
    }


    public ResetPayment()
    {
    }
}
