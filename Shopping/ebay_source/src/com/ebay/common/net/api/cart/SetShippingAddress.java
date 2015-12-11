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

public final class SetShippingAddress
{
    public static final class SetShippingAddressRequest extends EbayCartRequest
    {

        final Address address;
        final String cartId;

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            try
            {
                JSONObject jsonobject = new JSONObject();
                buildClientContext(jsonobject);
                jsonobject.put("cartIdentifier", cartId);
                JSONObject jsonobject2;
                if (address != null)
                {
                    if (!TextUtils.isEmpty(address.getAddressId()))
                    {
                        JSONObject jsonobject1 = new JSONObject();
                        jsonobject1.put("externalIdentifier", (new StringBuilder()).append("eBay:").append(address.getAddressId()).toString());
                        jsonobject.put("address", jsonobject1);
                    } else
                    {
                        jsonobject.put("address", DataMapperFactory.getDefaultMapper().toJson(address.addressFields));
                    }
                }
                jsonobject2 = new JSONObject();
                jsonobject2.put("setShippingAddressRequest", jsonobject);
                return jsonobject2.toString().getBytes();
            }
            catch (Exception exception)
            {
                throw com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException.create(exception);
            }
        }

        public SetShippingAddressResponse getResponse()
        {
            return new SetShippingAddressResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        protected SetShippingAddressRequest(EbayCartApi ebaycartapi, Address address1, String s)
        {
            super(ebaycartapi, "setShippingAddress");
            address = address1;
            cartId = s;
        }
    }

    public static final class SetShippingAddressResponse extends JsonResponse
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
                inputstream = body.getJSONObject("setShippingAddressResponse");
                super.processAck(inputstream);
                result = new Cart(inputstream.getJSONObject("shippingResponse"));
                super.exportErrorsToResponse(result);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                throw com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException.create(inputstream);
            }
        }

        public SetShippingAddressResponse()
        {
            result = null;
        }
    }


    public SetShippingAddress()
    {
    }
}
