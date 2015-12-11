// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import com.ebay.nautilus.kernel.net.Response;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.net.api.cart:
//            EbayCartRequest, UpdateLogisticsPlanParams, UpdateCartResponse, EbayCartApi

public class UpdateLogisticsPlan
{
    public static final class UpdateLogisticsPlanRequest extends EbayCartRequest
    {

        private final String cartId;
        private final List paramList;

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            Object obj;
            JSONObject jsonobject;
            try
            {
                obj = new JSONObject();
                buildClientContext(((JSONObject) (obj)));
                ((JSONObject) (obj)).put("cartIdentifier", cartId);
                jsonobject = new JSONObject();
                JSONObject jsonobject1;
                for (Iterator iterator = paramList.iterator(); iterator.hasNext(); jsonobject.put("logisticsPlan", jsonobject1))
                {
                    UpdateLogisticsPlanParams updatelogisticsplanparams = (UpdateLogisticsPlanParams)iterator.next();
                    jsonobject1 = new JSONObject();
                    jsonobject1.put("logisticsPlanType", updatelogisticsplanparams.logisticsPlanType);
                    jsonobject1.put("logisticsOptionIdentifier", updatelogisticsplanparams.logisticsOptionId);
                }

            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException.create(((Throwable) (obj)));
            }
            byte abyte0[];
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

        protected UpdateLogisticsPlanRequest(EbayCartApi ebaycartapi, String s, List list)
        {
            super(ebaycartapi, "updateCart");
            cartId = s;
            paramList = list;
        }
    }


    public UpdateLogisticsPlan()
    {
    }
}
