// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ecas;

import android.text.TextUtils;
import com.ebay.nautilus.kernel.net.Response;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.nautilus.domain.net.api.ecas:
//            EcasApiRequest, ShoppingCartResponse, EcasApiContext

public final class AddItemToShoppingCartRequest extends EcasApiRequest
{

    final Long itemId;
    final int quantity;
    final String storeLocationId;
    final String variationId;

    public AddItemToShoppingCartRequest(EcasApiContext ecasapicontext, Long long1, String s, String s1, int i)
    {
        super("addItemToShoppingCart", ecasapicontext);
        itemId = long1;
        variationId = s;
        quantity = i;
        storeLocationId = s1;
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        if (!requestVersion.equals("3.00"))
        {
            break MISSING_BLOCK_LABEL_38;
        }
        Object obj;
        if (useBopis)
        {
            obj = "true";
        } else
        {
            obj = "false";
        }
        jsonobject.put("bopisSupported", obj);
        obj = new JSONObject();
        ((JSONObject) (obj)).put("itemId", Long.toString(itemId.longValue()));
        if (!TextUtils.isEmpty(variationId))
        {
            ((JSONObject) (obj)).put("variationId", variationId);
        }
        ((JSONObject) (obj)).put("quantity", Integer.toString(quantity));
        if (useBopis && storeLocationId != null)
        {
            JSONObject jsonobject1 = new JSONObject();
            jsonobject1.put("pickupMethodToken", "InStorePickup");
            JSONObject jsonobject2 = new JSONObject();
            jsonobject2.put("@name", "StoreId");
            jsonobject2.put("__value__", storeLocationId);
            jsonobject1.put("pickupMethodAttribute", jsonobject2);
            ((JSONObject) (obj)).put("pickupMethod", jsonobject1);
        }
        jsonobject.put("addItemInput", obj);
        jsonobject.put("shopCartProcessingOptions", "true");
        jsonobject.put("includeAuctions", "false");
        jsonobject.put("includeSaveForLaterItems", "true");
        jsonobject.put("returnOnlyAddedItems", "false");
        obj = new JSONObject();
        ((JSONObject) (obj)).put((new StringBuilder()).append(getOperationName()).append("Request").toString(), jsonobject);
        return ((JSONObject) (obj)).toString().getBytes();
        JSONException jsonexception;
        jsonexception;
        throw com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException.create(jsonexception);
    }

    public ShoppingCartResponse getResponse()
    {
        return new ShoppingCartResponse(com/ebay/nautilus/domain/net/api/ecas/ShoppingCartResponse$AddItemToShoppingCart);
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
