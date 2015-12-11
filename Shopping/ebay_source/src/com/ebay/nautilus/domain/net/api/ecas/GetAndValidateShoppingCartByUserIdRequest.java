// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ecas;

import com.ebay.nautilus.kernel.net.Response;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.nautilus.domain.net.api.ecas:
//            EcasApiRequest, ShoppingCartResponse, EcasApiContext

public class GetAndValidateShoppingCartByUserIdRequest extends EcasApiRequest
{

    public GetAndValidateShoppingCartByUserIdRequest(EcasApiContext ecasapicontext)
    {
        super("getAndValidateShoppingCartByUserId", ecasapicontext);
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
        return new ShoppingCartResponse(com/ebay/nautilus/domain/net/api/ecas/ShoppingCartResponse$GetAndValidateShoppingCartByUserId);
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
