// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;

import com.ebay.common.model.followinterest.FollowType;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.common.net.api.followinterest:
//            BaseFollowInterestRequest, UpdateFollowLoadTask

private static class url extends BaseFollowInterestRequest
{

    private static final String OPERATION_NAME = "getSingleFollow";
    private static final String SERVICE_NAME = "FollowService";
    private URL url;

    public URL getRequestUrl()
    {
        return url;
    }

    public  getResponse()
    {
        return new ();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    protected boolean isIdempotent()
    {
        return true;
    }

    (String s, String s1, FollowType followtype, String s2)
    {
        super("FollowService", "getSingleFollow", s, s1);
        try
        {
            url = new URL((new StringBuilder()).append(ApiSettings.get(EbaySettings.followBaseUrl)).append("relation/").append(followtype).append("/").append(s2).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
    }
}
