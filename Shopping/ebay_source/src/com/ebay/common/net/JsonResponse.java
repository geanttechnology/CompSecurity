// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net;

import com.ebay.common.model.cart.JsonModel;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.util.StreamUtil;
import java.io.InputStream;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class JsonResponse extends EbayResponse
{

    protected JSONObject body;

    public JsonResponse()
    {
    }

    protected void exportErrorsToResponse(JsonModel jsonmodel)
    {
        if (ackCode != 1)
        {
            setResultStatus(ResultStatus.create(jsonmodel.getEbayResponseErrors()));
        }
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        try
        {
            body = StreamUtil.jsonObjectFromStream(inputstream);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException.create(inputstream);
        }
    }

    protected void processAck(JSONObject jsonobject)
        throws JSONException
    {
        if (jsonobject.getString("ack").toLowerCase(Locale.US).equalsIgnoreCase("success"))
        {
            ackCode = 1;
            return;
        } else
        {
            ackCode = -1;
            return;
        }
    }
}
