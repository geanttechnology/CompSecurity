// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.net.requestor;

import com.pointinside.analytics.BaseAnalyticsData;
import com.pointinside.internal.utils.IOUtils;
import com.pointinside.json.JSONResponse;
import com.pointinside.products.ProductSearchURLBuilder;
import com.pointinside.products.SearchAnalyticsData;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

// Referenced classes of package com.pointinside.net.requestor:
//            WebserviceRequestor

public class ProductSearchRequestor extends WebserviceRequestor
{

    ProductSearchRequestor(ProductSearchURLBuilder productsearchurlbuilder, JSONResponse jsonresponse)
    {
        super(productsearchurlbuilder, jsonresponse);
    }

    public List fetchProductSearchResponse()
        throws IOException
    {
        lastNetworkDate = System.currentTimeMillis();
        List list;
        HttpURLConnection httpurlconnection = ((ProductSearchURLBuilder)URL).openConnection();
        list = parseResponse(IOUtils.executeHttpRequest(httpurlconnection, "GET"));
        httpurlconnection.disconnect();
        lastNetworkDuration = System.currentTimeMillis() - lastNetworkDate;
        return list;
        Exception exception;
        exception;
        lastNetworkDuration = System.currentTimeMillis() - lastNetworkDate;
        throw exception;
    }

    String getPOSTBody(SearchAnalyticsData searchanalyticsdata)
    {
        return (new com.pointinside.internal.utils.IOUtils.AnalyticsPOSTData(new BaseAnalyticsData[] {
            searchanalyticsdata
        })).getJSONString();
    }

    public void sendAnalyticsInfo(SearchAnalyticsData searchanalyticsdata)
        throws IOException
    {
        ((ProductSearchURLBuilder)URL).setQualifiers("analytics");
        lastPostBody = getPOSTBody(searchanalyticsdata);
        searchanalyticsdata = ((ProductSearchURLBuilder)URL).openConnection();
        IOUtils.executeHttpPostRequest(searchanalyticsdata, lastPostBody);
        searchanalyticsdata.disconnect();
    }
}
