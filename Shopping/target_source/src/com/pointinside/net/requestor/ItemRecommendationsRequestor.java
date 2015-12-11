// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.net.requestor;

import com.pointinside.internal.utils.IOUtils;
import com.pointinside.json.JSONResponse;
import com.pointinside.products.ItemRecommendationsURLBuilder;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.pointinside.net.requestor:
//            WebserviceRequestor

public class ItemRecommendationsRequestor extends WebserviceRequestor
{

    protected ItemRecommendationsRequestor(ItemRecommendationsURLBuilder itemrecommendationsurlbuilder, JSONResponse jsonresponse)
    {
        super(itemrecommendationsurlbuilder, jsonresponse);
    }

    public List fetchItemRecommendation()
        throws IOException
    {
        HttpURLConnection httpurlconnection;
        httpurlconnection = null;
        new ArrayList();
        HttpURLConnection httpurlconnection1 = ((ItemRecommendationsURLBuilder)URL).openConnection();
        httpurlconnection = httpurlconnection1;
        List list = parseResponse(IOUtils.executeHttpRequest(httpurlconnection1, "GET"));
        if (httpurlconnection1 != null)
        {
            httpurlconnection1.disconnect();
        }
        lastNetworkDuration = System.currentTimeMillis() - lastNetworkDate;
        return list;
        Exception exception;
        exception;
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
        }
        lastNetworkDuration = System.currentTimeMillis() - lastNetworkDate;
        throw exception;
    }
}
