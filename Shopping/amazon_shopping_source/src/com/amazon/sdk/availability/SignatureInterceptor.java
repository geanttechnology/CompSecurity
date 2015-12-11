// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.sdk.availability:
//            AwsUtil, Logger

public class SignatureInterceptor
    implements com.amazon.mas.http.Web.Interceptor
{

    public SignatureInterceptor()
    {
    }

    public void after(com.amazon.mas.http.Web.Response response)
    {
    }

    public void before(com.amazon.mas.http.Web.Request request)
    {
        String s;
        if (request == null || request.getPostBody() == null)
        {
            break MISSING_BLOCK_LABEL_235;
        }
        s = request.getPostBody();
        JSONObject jsonobject = new JSONObject(s);
        String s1 = jsonobject.optString("sdkVersion", null);
        String s2 = jsonobject.optString("marketplaceId", null);
        String s3 = jsonobject.optString("customerId", null);
        String s4 = jsonobject.optString("region", null);
        String s5 = jsonobject.optString("deviceType", null);
        String s6 = jsonobject.optString("deviceMake", null);
        String s7 = jsonobject.optString("deviceModel", null);
        String s8 = jsonobject.optString("deviceOs", null);
        String s9 = jsonobject.optString("deviceCarrier", null);
        long l = jsonobject.optLong("timestamp", 0L);
        request.addHeader("X-sdk-RequestSignature", AwsUtil.hmacSha1("l1UzmagX6XhERqhgSwdSNDP4gDjEvZh5OWaEiOD5", (new StringBuilder()).append(s1).append("&").append(s2).append("&").append(s3).append("&").append(s4).append("&").append(s5).append("&").append(s6).append("&").append(s7).append("&").append(s8).append("&").append(s9).append("&").append(Long.valueOf(l)).toString()));
        return;
        request;
        Logger.v((new StringBuilder()).append("failed to parse JSON request body: ").append(s).toString());
        Logger.e("failed to parse JSON request body", request);
        return;
    }
}
