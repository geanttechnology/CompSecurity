// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.dyson;

import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.kernel.util.StreamUtil;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class DysonLogRiskMetadataResponse extends EbayResponse
{

    public JSONObject response;

    public DysonLogRiskMetadataResponse()
    {
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        try
        {
            response = StreamUtil.jsonObjectFromStream(inputstream);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException(inputstream);
        }
    }
}
