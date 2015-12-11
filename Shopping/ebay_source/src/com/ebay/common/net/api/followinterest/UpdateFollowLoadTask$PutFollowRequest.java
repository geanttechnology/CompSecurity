// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;

import com.ebay.common.model.followinterest.FollowDescriptor;
import com.ebay.common.model.followinterest.FollowType;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.Gson;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.common.net.api.followinterest:
//            BaseFollowInterestRequest, UpdateFollowLoadTask, EmptyResponse

public static class requestURL extends BaseFollowInterestRequest
{

    private static final String OPERATION_NAME = "putSingleFollow";
    private static final String SERVICE_NAME = "FollowService";
    final FollowDescriptor followDescriptor;
    private URL requestURL;

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.owRequest
    {
        return DataMapperFactory.getDefaultMapper().toJson(followDescriptor).getBytes();
    }

    public String getHttpMethod()
    {
        return "PUT";
    }

    public URL getRequestUrl()
    {
        return requestURL;
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

    public (String s, String s1, String s2, FollowType followtype, FollowDescriptor followdescriptor)
    {
        super("FollowService", "putSingleFollow", s, s1);
        followDescriptor = followdescriptor;
        followDescriptor.type = null;
        followDescriptor.interestId = null;
        followDescriptor.followDate = null;
        followDescriptor.id = null;
        try
        {
            requestURL = new URL((new StringBuilder()).append(ApiSettings.get(EbaySettings.followBaseUrl)).append("relation/").append(followtype).append("/").append(s2).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
    }
}
