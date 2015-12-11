// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.kernel.net.IResponseDataHandler;
import com.ebay.nautilus.kernel.util.StreamUtil;
import java.io.InputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.content.dm:
//            RlProductInfoDataManager

private static final class <init> extends EbayResponse
    implements IResponseDataHandler
{

    protected JSONObject body;
    protected body result;

    public <init> getRlProductInfo()
    {
        return result;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.sult
    {
        body = StreamUtil.jsonObjectFromStream(inputstream);
        result = new result();
        if (body.has("ean"))
        {
            result.result = body.getString("ean");
        }
        if (!body.has("keywords"))
        {
            break MISSING_BLOCK_LABEL_121;
        }
        inputstream = body.getJSONArray("keywords");
        if (inputstream.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        result.result = new String[inputstream.length()];
        int i = 0;
        do
        {
            try
            {
                if (i >= inputstream.length())
                {
                    break;
                }
                result.result[i] = inputstream.getString(i);
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                throw com.ebay.nautilus.kernel.net.sult(inputstream);
            }
            i++;
        } while (true);
        if (body.has("voyager_query"))
        {
            result.y = body.getString("voyager_query");
        }
        return;
    }

    private ()
    {
        result = null;
    }

    result(result result1)
    {
        this();
    }
}
