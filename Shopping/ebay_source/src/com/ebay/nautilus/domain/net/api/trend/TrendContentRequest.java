// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trend;

import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.CosVersionType;
import com.ebay.nautilus.domain.net.EbayCosRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.net.URL;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trend:
//            TrendContentResponse

public class TrendContentRequest extends EbayCosRequest
{

    public static final String OPERATION_NAME = "topic";

    public TrendContentRequest()
    {
        super("trending", "topic", CosVersionType.V2);
        requestBodyContentType = "application/json";
        responseBodyContentType = "application/json";
    }

    public String getHttpMethod()
    {
        return "GET";
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(ApiSettings.trendingUrl);
    }

    public TrendContentResponse getResponse()
    {
        return new TrendContentResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    protected boolean isIdempotent()
    {
        return true;
    }
}
