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

public class AddItems
{
    public static final class AddItemsRequest extends EbayCartRequest
    {

        final String cartId;
        final int donationAmountId;
        final String isoCurrencyCode;
        final String nonprofitId;
        final int requestedQuantity;

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
                jsonobject1.put("NonprofitId", Integer.parseInt(nonprofitId));
                JSONObject jsonobject2 = new JSONObject();
                jsonobject2.put("DonationAmountId", donationAmountId);
                jsonobject2.put("DonationCurrency", isoCurrencyCode);
                JSONObject jsonobject3 = new JSONObject();
                JSONObject jsonobject4 = new JSONObject();
                jsonobject4.put("domain", "donation");
                jsonobject4.put("baseIdentifier", jsonobject1.toString());
                jsonobject4.put("extendedIdentifier", jsonobject2.toString());
                jsonobject3.put("lineItemIdentifier", jsonobject4);
                jsonobject3.put("requestedQuantity", requestedQuantity);
                jsonobject.put("lineItemInput", jsonobject3);
                jsonobject1 = new JSONObject();
                jsonobject1.put("addItemsRequest", jsonobject);
                abyte0 = jsonobject1.toString().getBytes();
            }
            catch (JSONException jsonexception)
            {
                throw com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException.create(jsonexception);
            }
            catch (NumberFormatException numberformatexception)
            {
                throw com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException.create(numberformatexception);
            }
            return abyte0;
        }

        public AddItemsResponse getResponse()
        {
            return new AddItemsResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        protected AddItemsRequest(EbayCartApi ebaycartapi, String s, String s1, int i, String s2, int j)
        {
            super(ebaycartapi, "addItems");
            cartId = s;
            nonprofitId = s1;
            donationAmountId = i;
            isoCurrencyCode = s2;
            requestedQuantity = j;
        }
    }

    public static final class AddItemsResponse extends JsonResponse
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
                inputstream = body.getJSONObject("addItemsResponse");
                super.processAck(inputstream);
                result = new Cart(inputstream.getJSONObject("addItemResponse"));
                super.exportErrorsToResponse(result);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                throw com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException.create(inputstream);
            }
        }

        public AddItemsResponse()
        {
            result = null;
        }
    }


    public AddItems()
    {
    }
}
