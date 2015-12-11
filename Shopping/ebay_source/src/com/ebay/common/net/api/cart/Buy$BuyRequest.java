// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import com.ebay.nautilus.kernel.net.Response;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.net.api.cart:
//            EbayCartRequest, Buy, EbayCartApi

public static final class cartId extends EbayCartRequest
{

    final String cartId;

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.RequestDataException
    {
        byte abyte0[];
        try
        {
            JSONObject jsonobject = new JSONObject();
            buildClientContext(jsonobject);
            jsonobject.put("cartIdentifier", cartId);
            JSONObject jsonobject1 = new JSONObject();
            jsonobject1.put("buyRequest", jsonobject);
            abyte0 = jsonobject1.toString().getBytes();
        }
        catch (JSONException jsonexception)
        {
            throw com.ebay.nautilus.kernel.net.RequestDataException.create(jsonexception);
        }
        return abyte0;
    }

    public  getResponse()
    {
        return new ();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    protected (EbayCartApi ebaycartapi, String s)
    {
        super(ebaycartapi, "buy");
        cartId = s;
    }
}
