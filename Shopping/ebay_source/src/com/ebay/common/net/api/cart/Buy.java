// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import com.ebay.common.model.cart.Cart;
import com.ebay.common.model.cart.PaymentInstruction;
import com.ebay.common.net.JsonResponse;
import com.ebay.nautilus.kernel.net.Response;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.net.api.cart:
//            EbayCartRequest, EbayCartApi

public class Buy
{
    public static final class BuyRequest extends EbayCartRequest
    {

        final String cartId;

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
                jsonobject1.put("buyRequest", jsonobject);
                abyte0 = jsonobject1.toString().getBytes();
            }
            catch (JSONException jsonexception)
            {
                throw com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException.create(jsonexception);
            }
            return abyte0;
        }

        public BuyResponse getResponse()
        {
            return new BuyResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        protected BuyRequest(EbayCartApi ebaycartapi, String s)
        {
            super(ebaycartapi, "buy");
            cartId = s;
        }
    }

    public static final class BuyResponse extends JsonResponse
    {

        protected Cart cart;
        protected PaymentInstruction paymentAttributes;

        public PaymentInstruction getPaymentInstruction()
        {
            return paymentAttributes;
        }

        public Cart getResponseCart()
        {
            return cart;
        }

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            super.parse(inputstream);
            inputstream = body.getJSONObject("buyResponse");
            super.processAck(inputstream);
            cart = new Cart(inputstream.getJSONObject("cartResponse"));
            if (!inputstream.has("paymentAttributes"))
            {
                break MISSING_BLOCK_LABEL_72;
            }
            paymentAttributes = new PaymentInstruction(inputstream.getJSONObject("paymentAttributes"));
_L1:
            super.exportErrorsToResponse(cart);
            return;
            try
            {
                paymentAttributes = null;
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                throw com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException.create(inputstream);
            }
              goto _L1
        }

        public BuyResponse()
        {
            cart = null;
            paymentAttributes = null;
        }
    }


    public Buy()
    {
    }
}
