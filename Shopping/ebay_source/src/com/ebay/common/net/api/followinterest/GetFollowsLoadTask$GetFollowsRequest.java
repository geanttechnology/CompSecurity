// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;

import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.dcs.DcsNautilusBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.common.net.api.followinterest:
//            BaseFollowInterestRequest, GetFollowsLoadTask

public static class  extends BaseFollowInterestRequest
{

    public static final String OPERATION_NAME = "getUserFollowSummary";
    public static final String SERVICE_NAME = "FollowService";

    public URL getRequestUrl()
    {
        Object obj;
        try
        {
            obj = new StringBuilder(ApiSettings.get(EbaySettings.followBaseUrl));
            ((StringBuilder) (obj)).append("following/user/@self");
            if (DeviceConfiguration.getAsync().get(DcsNautilusBoolean.searchFollowRequestUsernameField))
            {
                ((StringBuilder) (obj)).append("?fields=username");
            }
            obj = new URL(((StringBuilder) (obj)).toString());
        }
        catch (MalformedURLException malformedurlexception)
        {
            throw new RuntimeException(malformedurlexception);
        }
        return ((URL) (obj));
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

    public (String s, String s1)
    {
        super("FollowService", "getUserFollowSummary", s, s1);
    }
}
