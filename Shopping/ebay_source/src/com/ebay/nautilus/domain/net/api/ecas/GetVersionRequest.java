// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ecas;

import com.ebay.nautilus.kernel.net.Response;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.nautilus.domain.net.api.ecas:
//            EcasApiRequest, ShoppingCartResponse, EcasApiContext

public class GetVersionRequest extends EcasApiRequest
{

    public GetVersionRequest(EcasApiContext ecasapicontext)
    {
        super("getVersion", ecasapicontext);
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        byte abyte0[];
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put((new StringBuilder()).append(getOperationName()).append("Request").toString(), new JSONObject());
            abyte0 = jsonobject.toString().getBytes();
        }
        catch (JSONException jsonexception)
        {
            throw com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException.create(jsonexception);
        }
        return abyte0;
    }

    public ShoppingCartResponse getResponse()
    {
        return new ShoppingCartResponse(com/ebay/nautilus/domain/net/api/ecas/ShoppingCartResponse$GetVersion);
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
