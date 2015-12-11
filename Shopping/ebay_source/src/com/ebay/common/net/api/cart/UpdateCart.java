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

public class UpdateCart
{
    public static final class UpdateCartRequest extends EbayCartRequest
    {

        final List add;
        final String cartId;
        final String cartLineItemId;
        final String itemNoteToSeller;
        final String lineItemToRemove;
        final Integer quantity;
        final List remove;
        final String sellerIdentifier;
        final String shippingServiceId;

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            Object obj;
            JSONObject jsonobject2;
            try
            {
                jsonobject2 = new JSONObject();
                buildClientContext(jsonobject2);
                jsonobject2.put("cartIdentifier", cartId);
                if (quantity != null)
                {
                    JSONObject jsonobject = new JSONObject();
                    jsonobject.put("quantity", quantity);
                    jsonobject.put("cartLineItemIdentifier", cartLineItemId);
                    JSONObject jsonobject3 = new JSONObject();
                    jsonobject3.put("itemQuantity", jsonobject);
                    jsonobject2.put("Quantity", jsonobject3);
                }
                if (shippingServiceId != null)
                {
                    JSONObject jsonobject1 = new JSONObject();
                    jsonobject1.put("shippingServiceIdentifier", shippingServiceId);
                    jsonobject1.put("cartLineItemIdentifier", cartLineItemId);
                    JSONObject jsonobject4 = new JSONObject();
                    jsonobject4.put("itemShippingService", jsonobject1);
                    jsonobject2.put("ShippingService", jsonobject4);
                }
                if (add == null || add.size() <= 0)
                {
                    break MISSING_BLOCK_LABEL_246;
                }
                obj = new JSONArray();
                JSONObject jsonobject7;
                for (Iterator iterator = add.iterator(); iterator.hasNext(); ((JSONArray) (obj)).put(jsonobject7))
                {
                    String s = (String)iterator.next();
                    jsonobject7 = new JSONObject();
                    jsonobject7.put("incentiveCodesToApply", s);
                }

            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException.create(((Throwable) (obj)));
            }
            jsonobject2.put("ApplyIncentive", obj);
            if (remove == null || remove.size() <= 0)
            {
                break MISSING_BLOCK_LABEL_340;
            }
            obj = new JSONArray();
            JSONObject jsonobject8;
            for (Iterator iterator1 = remove.iterator(); iterator1.hasNext(); ((JSONArray) (obj)).put(jsonobject8))
            {
                String s1 = (String)iterator1.next();
                jsonobject8 = new JSONObject();
                jsonobject8.put("incentiveCodesToRemove", s1);
            }

            jsonobject2.put("ApplyIncentive", obj);
            if (lineItemToRemove != null)
            {
                obj = new JSONObject();
                ((JSONObject) (obj)).put("cartLineItemIdentifier", lineItemToRemove);
                jsonobject2.put("ItemToRemove", obj);
            }
            if (TextUtils.isEmpty(sellerIdentifier)) goto _L2; else goto _L1
_L1:
            JSONObject jsonobject5;
            JSONObject jsonobject6;
            jsonobject5 = new JSONObject();
            jsonobject6 = new JSONObject();
            jsonobject6.put("sellerIdentifier", sellerIdentifier);
            if (itemNoteToSeller != null) goto _L4; else goto _L3
_L3:
            obj = "";
_L6:
            jsonobject6.put("note", obj);
            jsonobject5.put("sellerNote", jsonobject6);
            jsonobject2.put("NoteToSeller", jsonobject5);
_L2:
            obj = new JSONObject();
            ((JSONObject) (obj)).put("updateCartRequest", jsonobject2);
            return ((JSONObject) (obj)).toString().getBytes();
_L4:
            obj = itemNoteToSeller;
            if (true) goto _L6; else goto _L5
_L5:
        }

        public UpdateCartResponse getResponse()
        {
            return new UpdateCartResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        protected UpdateCartRequest(EbayCartApi ebaycartapi, String s, String s1, String s2, Integer integer, List list, List list1, 
                String s3, String s4, String s5)
        {
            super(ebaycartapi, "updateCart");
            cartId = s;
            cartLineItemId = s1;
            shippingServiceId = s2;
            quantity = integer;
            add = list;
            remove = list1;
            sellerIdentifier = s3;
            itemNoteToSeller = s4;
            lineItemToRemove = s5;
        }
    }


    public UpdateCart()
    {
    }
}
