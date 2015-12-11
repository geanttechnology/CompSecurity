// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import com.ebay.common.model.cart.PaymentSession;
import com.ebay.common.net.JsonResponse;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.Gson;
import java.io.InputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.net.api.cart:
//            EbayCartRequest, EbayCartApi

public class InitPayment
{
    public static final class InitPaymentRequest extends EbayCartRequest
    {

        final Address address;
        final String cartId;
        final boolean guestXO;
        final String paymentMethod;

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            JSONObject jsonobject;
            jsonobject = new JSONObject();
            jsonobject.put("@name", "landingPage");
            Object obj;
            if (guestXO)
            {
                obj = "Billing";
            } else
            {
                obj = "Login";
            }
            try
            {
                jsonobject.put("__value__", obj);
                JSONObject jsonobject1 = new JSONObject();
                jsonobject1.put("@name", "trackingURL");
                jsonobject1.put("__value__", "https://payments.ebay.com/ws/eBayISAPI.dll?CheckoutProcessor&amp;track_paypal;=true");
                JSONObject jsonobject2 = new JSONObject();
                jsonobject2.put("@name", "giropayCancelURL");
                jsonobject2.put("__value__", "https://payments.ebay.com/ws/eBayISAPI.dll?CheckoutProcessor&amp;giropay_redirect;=true&amp;rp;=-155743400");
                JSONObject jsonobject3 = new JSONObject();
                jsonobject3.put("@name", "giropaySuccessURL");
                jsonobject3.put("__value__", "https://payments.ebay.com/ws/eBayISAPI.dll?CheckoutProcessor&amp;giropay_redirect;=true&amp;rp;=1241295873");
                JSONObject jsonobject4 = new JSONObject();
                jsonobject4.put("@name", "bankTransactionPendingURL");
                jsonobject4.put("__value__", "https://payments.ebay.com/ws/eBayISAPI.dll?ViewPaymentStatus&amp;itemId;=120625214862&amp;transId;=609878728002");
                JSONObject jsonobject5 = new JSONObject();
                jsonobject5.put("@name", "logoImageURL");
                jsonobject5.put("__value__", "https://securepics.ebaystatic.com/aw/pics/logos/logoEbay_x45.gif");
                JSONObject jsonobject6 = new JSONObject();
                jsonobject6.put("@name", "brandName");
                jsonobject6.put("__value__", "eBay");
                JSONObject jsonobject7 = new JSONObject();
                jsonobject7.put("@name", "payflowColor");
                jsonobject7.put("__value__", "fae16b");
                obj = new JSONArray();
                ((JSONArray) (obj)).put(jsonobject);
                ((JSONArray) (obj)).put(jsonobject1);
                ((JSONArray) (obj)).put(jsonobject2);
                ((JSONArray) (obj)).put(jsonobject3);
                ((JSONArray) (obj)).put(jsonobject4);
                ((JSONArray) (obj)).put(jsonobject5);
                ((JSONArray) (obj)).put(jsonobject6);
                ((JSONArray) (obj)).put(jsonobject7);
                jsonobject = new JSONObject();
                buildClientContext(jsonobject);
                jsonobject.put("cartIdentifier", cartId);
                if (address != null)
                {
                    jsonobject.put("billingAddress", new JSONObject(DataMapperFactory.getDefaultMapper().toJson(address.addressFields)));
                }
                jsonobject.put("paymentMethod", paymentMethod);
                jsonobject.put("returnURL", "http://wap.ebay.com/returnurl");
                jsonobject.put("errorURL", "http://wap.ebay.com/cancelurl");
                jsonobject.put("paymentMethodParameters", (new JSONObject()).put("parameter", obj));
                obj = new JSONObject();
                ((JSONObject) (obj)).put("initPaymentRequest", jsonobject);
                return ((JSONObject) (obj)).toString().getBytes();
            }
            catch (Exception exception)
            {
                throw com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException.create(exception);
            }
        }

        public InitPaymentResponse getResponse()
        {
            return new InitPaymentResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        protected InitPaymentRequest(EbayCartApi ebaycartapi, String s, Address address1, boolean flag, String s1)
        {
            super(ebaycartapi, "initPayment");
            cartId = s;
            address = address1;
            guestXO = flag;
            paymentMethod = s1;
        }
    }

    public static final class InitPaymentResponse extends JsonResponse
    {

        protected PaymentSession result;

        public PaymentSession getResponsePaymentSession()
        {
            return result;
        }

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            super.parse(inputstream);
            try
            {
                inputstream = body.getJSONObject("initPaymentResponse");
                super.processAck(inputstream);
                result = new PaymentSession(inputstream);
                super.exportErrorsToResponse(result);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                throw com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException.create(inputstream);
            }
        }

        public InitPaymentResponse()
        {
            result = null;
        }
    }


    public InitPayment()
    {
    }
}
