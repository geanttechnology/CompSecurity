// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import android.text.TextUtils;
import com.ebay.nautilus.kernel.net.Response;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.net.api.cart:
//            EbayCartRequest, UpdateCartResponse, EbayCartApi

public class UpdateDeliveryReservation
{
    public static final class UpdateDeliveryReservationRequest extends EbayCartRequest
    {

        private final String cartId;
        private final String deliveryInstructions;
        private final List logisticsPlanOptionIds;
        private final String reservationToken;

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            Object obj;
            JSONObject jsonobject;
            JSONArray jsonarray;
            try
            {
                obj = new JSONObject();
                buildClientContext(((JSONObject) (obj)));
                ((JSONObject) (obj)).put("cartIdentifier", cartId);
                jsonobject = new JSONObject();
                jsonarray = new JSONArray();
                JSONObject jsonobject1;
                for (Iterator iterator = logisticsPlanOptionIds.iterator(); iterator.hasNext(); jsonarray.put(jsonobject1))
                {
                    Object obj1 = (String)iterator.next();
                    jsonobject1 = new JSONObject();
                    jsonobject1.put("logisticsPlanType", com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.EBAY_NOW.longName);
                    jsonobject1.put("logisticsOptionIdentifier", obj1);
                    obj1 = new JSONArray();
                    if (!TextUtils.isEmpty(reservationToken))
                    {
                        JSONObject jsonobject2 = new JSONObject();
                        jsonobject2.put("@name", "ReservationToken");
                        jsonobject2.put("__value__", reservationToken);
                        ((JSONArray) (obj1)).put(jsonobject2);
                    }
                    if (!TextUtils.isEmpty(deliveryInstructions))
                    {
                        JSONObject jsonobject3 = new JSONObject();
                        jsonobject3.put("@name", "DeliveryInstructions");
                        jsonobject3.put("__value__", deliveryInstructions);
                        ((JSONArray) (obj1)).put(jsonobject3);
                    }
                    jsonobject1.put("attribute", obj1);
                }

            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException.create(((Throwable) (obj)));
            }
            byte abyte0[];
            jsonobject.put("logisticsPlan", jsonarray);
            ((JSONObject) (obj)).put("LogisticsService", jsonobject);
            jsonobject = new JSONObject();
            jsonobject.put("updateCartRequest", obj);
            abyte0 = jsonobject.toString().getBytes();
            return abyte0;
        }

        public UpdateCartResponse getResponse()
        {
            return new UpdateCartResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        protected UpdateDeliveryReservationRequest(EbayCartApi ebaycartapi, String s, List list, String s1, String s2)
        {
            super(ebaycartapi, "updateCart");
            cartId = s;
            logisticsPlanOptionIds = list;
            reservationToken = s1;
            deliveryInstructions = s2;
        }
    }


    public UpdateDeliveryReservation()
    {
    }
}
