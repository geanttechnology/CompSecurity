// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;

import com.google.b.f;
import com.google.b.g;
import com.pointinside.analytics.BaseAnalyticsData;
import com.pointinside.internal.DateDeserializer;
import com.pointinside.internal.utils.IOUtils;
import com.pointinside.json.JSONResponse;
import com.pointinside.maps.model.LocationDefs;
import com.pointinside.net.requestor.WebserviceRequestor;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Date;

// Referenced classes of package com.pointinside.products:
//            NearbySearchURLBuilder, ProductsNearBy, SearchAnalyticsData

public class NearbySearchRequestor extends WebserviceRequestor
{

    private static final String TAG_JSON = "JSON";

    NearbySearchRequestor(NearbySearchURLBuilder nearbysearchurlbuilder, JSONResponse jsonresponse)
    {
        super(nearbysearchurlbuilder, jsonresponse);
    }

    String getPOSTBody(SearchAnalyticsData searchanalyticsdata)
    {
        return (new com.pointinside.internal.utils.IOUtils.AnalyticsPOSTData(new BaseAnalyticsData[] {
            searchanalyticsdata
        })).getJSONString();
    }

    public ProductsNearBy getProductsNearby(LocationDefs locationdefs)
        throws IOException
    {
        Object obj;
        obj = (new f()).b(locationdefs);
        lastNetworkDate = System.currentTimeMillis();
        locationdefs = ((NearbySearchURLBuilder)URL).openConnection();
        obj = fetchResponsePayload(IOUtils.executeHttpPostRequest(locationdefs, ((String) (obj))));
        g g1 = new g();
        g1.a(java/util/Date, new DateDeserializer());
        obj = (ProductsNearBy)g1.d().a(((String) (obj)), com/pointinside/products/ProductsNearBy);
        locationdefs.disconnect();
        lastNetworkDuration = System.currentTimeMillis() - lastNetworkDate;
        return ((ProductsNearBy) (obj));
        locationdefs;
        lastNetworkDuration = System.currentTimeMillis() - lastNetworkDate;
        throw locationdefs;
    }

    public void sendAnalyticsInfo(SearchAnalyticsData searchanalyticsdata)
        throws IOException
    {
        ((NearbySearchURLBuilder)URL).setQualifiers("analytics");
        lastPostBody = getPOSTBody(searchanalyticsdata);
        searchanalyticsdata = ((NearbySearchURLBuilder)URL).openConnection();
        IOUtils.executeHttpPostRequest(searchanalyticsdata, lastPostBody);
        searchanalyticsdata.disconnect();
    }
}
