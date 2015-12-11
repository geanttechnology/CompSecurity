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
import java.util.Arrays;

// Referenced classes of package com.ebay.common.net.api.followinterest:
//            BaseFollowInterestRequest, CreateFollowLoadTask, EmptyResponse

public static class followDescriptor extends BaseFollowInterestRequest
{

    public static final String OPERATION_NAME = "createFollow";
    public static final String SERVICE_NAME = "FollowService";
    final FollowDescriptor followDescriptor = new FollowDescriptor();

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.owRequest
    {
        return DataMapperFactory.getDefaultMapper().toJson(followDescriptor).getBytes();
    }

    public URL getRequestUrl()
    {
        URL url;
        try
        {
            url = new URL(ApiSettings.getUrl(EbaySettings.followBaseUrl), "relation");
        }
        catch (MalformedURLException malformedurlexception)
        {
            throw new RuntimeException(malformedurlexception);
        }
        return url;
    }

    public EmptyResponse getResponse()
    {
        EmptyResponse emptyresponse = new EmptyResponse();
        emptyresponse.setSuccessCodes(Arrays.asList(new Integer[] {
            Integer.valueOf(200), Integer.valueOf(201)
        }));
        return emptyresponse;
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

    public (String s, FollowType followtype, String s1, String s2, String s3)
    {
        super("FollowService", "createFollow", s2, s3);
        followDescriptor.customTitle = s1;
        followDescriptor.id = s;
        followDescriptor.type = followtype;
        if (followtype != FollowType.INTEREST)
        {
            followDescriptor.visibility = com.ebay.common.model.followinterest.t.followDescriptor;
        }
    }
}
