// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import android.text.TextUtils;
import com.ebay.common.model.cart.Cart;
import com.ebay.common.net.JsonResponse;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.Gson;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.net.api.cart:
//            EbayCartRequest, EbayCartApi

public class CreateCart
{
    public static final class CreateCartRequest extends EbayCartRequest
    {

        final Address address;
        final String itemId;
        final int quantity;
        final String transactionId;
        final boolean useProgressiveCheckout;
        final String variationId;

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            try
            {
                JSONObject jsonobject = new JSONObject();
                buildClientContext(jsonobject);
                if (useProgressiveCheckout)
                {
                    JSONObject jsonobject1 = new JSONObject();
                    jsonobject1.put("option", "EnablePaymentInstruments");
                    jsonobject.put("processingOption", jsonobject1);
                }
                JSONObject jsonobject2 = new JSONObject();
                jsonobject2.put("domain", "ebay");
                jsonobject2.put("baseIdentifier", (new StringBuilder()).append("ItemId=").append(itemId).toString());
                if (transactionId != null)
                {
                    jsonobject2.put("extendedIdentifier", (new StringBuilder()).append("TransactionId=").append(transactionId).toString());
                }
                if (variationId != null)
                {
                    jsonobject2.put("extendedIdentifier", (new StringBuilder()).append("VariationId=").append(variationId).toString());
                }
                JSONObject jsonobject3 = new JSONObject();
                jsonobject3.put("lineItemIdentifier", jsonobject2);
                jsonobject3.put("requestedQuantity", quantity);
                jsonobject.put("lineItemInput", jsonobject3);
                if (address != null)
                {
                    if (!TextUtils.isEmpty(address.getAddressId()))
                    {
                        jsonobject2 = new JSONObject();
                        jsonobject2.put("externalIdentifier", (new StringBuilder()).append("eBay:").append(address.getAddressId()).toString());
                        jsonobject.put("shippingAddress", jsonobject2);
                    } else
                    {
                        jsonobject.put("shippingAddress", DataMapperFactory.getDefaultMapper().toJson(address.addressFields));
                    }
                }
                jsonobject2 = new JSONObject();
                jsonobject2.put("createCartRequest", jsonobject);
                return jsonobject2.toString().getBytes();
            }
            catch (Exception exception)
            {
                throw com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException.create(exception);
            }
        }

        public CreateCartResponse getResponse()
        {
            return new CreateCartResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        protected CreateCartRequest(EbayCartApi ebaycartapi, Address address1, Integer integer, String s, String s1, String s2, boolean flag)
        {
            super(ebaycartapi, "createCart");
            address = address1;
            int i;
            if (integer == null)
            {
                i = 1;
            } else
            {
                i = integer.intValue();
            }
            quantity = i;
            itemId = s;
            transactionId = s1;
            variationId = s2;
            useProgressiveCheckout = flag;
        }
    }

    public static final class CreateCartResponse extends JsonResponse
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
                inputstream = body.getJSONObject("createCartResponse");
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

        public CreateCartResponse()
        {
            result = null;
        }
    }


    public CreateCart()
    {
    }
}
