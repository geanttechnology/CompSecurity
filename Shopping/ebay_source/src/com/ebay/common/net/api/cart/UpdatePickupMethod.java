// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import com.ebay.nautilus.kernel.net.Response;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.net.api.cart:
//            EbayCartRequest, UpdateCartResponse, EbayCartApi

public class UpdatePickupMethod
{
    public static final class UpdatePickupMethodRequest extends EbayCartRequest
    {

        private final String cartId;
        private final String cartLineItemId;
        private final List logisticsPlanOptionIds;
        private final com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type logisticsPlanType;
        private final String pickupStoreId;

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            Object obj;
            JSONObject jsonobject;
            JSONArray jsonarray;
            Iterator iterator;
            obj = new JSONObject();
            buildClientContext(((JSONObject) (obj)));
            ((JSONObject) (obj)).put("cartIdentifier", cartId);
            ((JSONObject) (obj)).put("cartLineItemIdentifier", cartLineItemId);
            jsonobject = new JSONObject();
            jsonarray = new JSONArray();
            iterator = logisticsPlanOptionIds.iterator();
_L2:
            JSONObject jsonobject1;
            Object obj1;
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_247;
            }
            obj1 = (String)iterator.next();
            jsonobject1 = new JSONObject();
            jsonobject1.put("logisticsPlanType", logisticsPlanType.longName);
            jsonobject1.put("logisticsOptionIdentifier", obj1);
            obj1 = new JSONArray();
            if (!logisticsPlanType.equals(com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.PUDO))
            {
                break; /* Loop/switch isn't completed */
            }
            JSONObject jsonobject2 = new JSONObject();
            jsonobject2.put("@name", "LocationId");
            jsonobject2.put("__value__", pickupStoreId);
            ((JSONArray) (obj1)).put(jsonobject2);
_L3:
            jsonobject1.put("attribute", obj1);
            jsonarray.put(jsonobject1);
            if (true) goto _L2; else goto _L1
_L1:
            try
            {
                JSONObject jsonobject3 = new JSONObject();
                jsonobject3.put("@name", "StoreId");
                jsonobject3.put("__value__", pickupStoreId);
                ((JSONArray) (obj1)).put(jsonobject3);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException.create(((Throwable) (obj)));
            }
              goto _L3
            if (true) goto _L2; else goto _L4
_L4:
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

        protected UpdatePickupMethodRequest(EbayCartApi ebaycartapi, String s, String s1, List list, String s2, com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type type)
        {
            super(ebaycartapi, "updateCart");
            cartId = s;
            cartLineItemId = s1;
            logisticsPlanOptionIds = list;
            pickupStoreId = s2;
            logisticsPlanType = type;
        }
    }


    public UpdatePickupMethod()
    {
    }
}
