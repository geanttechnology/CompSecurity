// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sellsmartbox;

import com.ebay.nautilus.kernel.net.IResponseDataHandler;
import com.ebay.nautilus.kernel.net.IResponseHeaderHandler;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.StreamUtil;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.mobile.sellsmartbox:
//            SellerTagSpellCheck

private static final class <init> extends Response
    implements IResponseDataHandler
{

    public int responseCode;
    public String suggestion;

    public IResponseDataHandler getDataHandler()
    {
        if (hasSuccessResponseCode())
        {
            return this;
        } else
        {
            return null;
        }
    }

    public IResponseHeaderHandler getHeaderHandler()
    {
        return null;
    }

    public boolean hasSuccessResponseCode()
    {
        return responseCode == 200;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.responseCode
    {
        try
        {
            inputstream = StreamUtil.jsonObjectFromStream(inputstream);
            if (!inputstream.has("SugVal"))
            {
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new com.ebay.nautilus.kernel.net.nit>(inputstream);
        }
        suggestion = (String)inputstream.get("SugVal");
        return;
    }

    public void setRequestTime(long l)
    {
    }

    public void setResponseCode(int i, String s)
    {
        responseCode = i;
    }

    private I()
    {
        responseCode = -1;
    }

    responseCode(responseCode responsecode)
    {
        this();
    }
}
