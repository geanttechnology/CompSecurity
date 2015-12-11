// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;

import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.common.net.api.followinterest:
//            BaseFollowInterestRequest, DeleteFollowLoadTask, EmptyResponse

public static class followTypeString extends BaseFollowInterestRequest
{

    private static final String OPERATION_NAME = "deleteFollowByInterest";
    private static final String SERVICE_NAME = "FollowService";
    private final String followTypeString;
    private final String id;

    public String getHttpMethod()
    {
        return "DELETE";
    }

    public URL getRequestUrl()
    {
        URL url;
        try
        {
            url = new URL(ApiSettings.getUrl(EbaySettings.followBaseUrl), (new StringBuilder()).append("relation/").append(followTypeString).append("/").append(id).toString());
        }
        catch (MalformedURLException malformedurlexception)
        {
            throw new RuntimeException(malformedurlexception);
        }
        return url;
    }

    public EmptyResponse getResponse()
    {
        return new EmptyResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    protected boolean isIdempotent()
    {
        return true;
    }

    public void onAddHeaders(IHeaders iheaders)
    {
        super.onAddHeaders(iheaders);
        maybeDisableGzip(iheaders);
    }

    public (String s, String s1, String s2)
    {
        super("FollowService", "deleteFollowByInterest", s2, null);
        id = s1;
        followTypeString = s;
    }
}
