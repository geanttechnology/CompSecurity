// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.net.requestor;

import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.pointinside.internal.utils.IOUtils;
import com.pointinside.internal.utils.LogUtils;
import com.pointinside.json.JSONResponse;
import com.pointinside.products.ProductDesc;
import com.pointinside.products.ProductLookupURLBuilder;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.pointinside.net.requestor:
//            WebserviceRequestor

public class ProductLookupRequestor extends WebserviceRequestor
{

    private static final String TAG = LogUtils.makeLogTag(com/pointinside/net/requestor/ProductLookupRequestor.getSimpleName());

    ProductLookupRequestor(ProductLookupURLBuilder productlookupurlbuilder, JSONResponse jsonresponse)
    {
        super(productlookupurlbuilder, jsonresponse);
    }

    static JSONObject getJSONPostRequest(List list)
        throws JSONException
    {
        JSONArray jsonarray = new JSONArray();
        for (list = list.iterator(); list.hasNext(); jsonarray.put(((ProductDesc)list.next()).getAsJsonObject())) { }
        return (new JSONObject()).put("products", jsonarray);
    }

    public List fetchProductLookupResponse(List list)
        throws IOException, JSONException
    {
        lastNetworkDate = System.currentTimeMillis();
        HttpURLConnection httpurlconnection;
        httpurlconnection = ((ProductLookupURLBuilder)URL).openConnection();
        list = getJSONPostRequest(list);
        if (list instanceof JSONObject)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        list = list.toString();
_L1:
        lastPostBody = list;
        list = parseResponse(IOUtils.executeHttpPostRequest(httpurlconnection, lastPostBody));
        httpurlconnection.disconnect();
        lastNetworkDuration = System.currentTimeMillis() - lastNetworkDate;
        return list;
        list = JSONObjectInstrumentation.toString((JSONObject)list);
          goto _L1
        list;
        lastNetworkDuration = System.currentTimeMillis() - lastNetworkDate;
        throw list;
    }

}
