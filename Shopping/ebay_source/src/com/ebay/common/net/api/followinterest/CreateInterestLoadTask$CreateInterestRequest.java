// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;

import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.Gson;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.common.net.api.followinterest:
//            BaseFollowInterestRequest, CreateInterestLoadTask

public static class ent extends BaseFollowInterestRequest
{

    public static final String OPERATION_NAME = "createInterest";
    public static final String SERVICE_NAME = "InterestService";
    final ent interestContainer;

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.stRequest
    {
        return DataMapperFactory.getDefaultMapper().toJson(interestContainer).getBytes();
    }

    public URL getRequestUrl()
    {
        URL url;
        try
        {
            url = new URL(ApiSettings.getUrl(EbaySettings.interestBaseUrl), "metadata");
        }
        catch (MalformedURLException malformedurlexception)
        {
            throw new RuntimeException(malformedurlexception);
        }
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

    public (SearchParameters searchparameters, String s)
    {
        super("InterestService", "createInterest", s, searchparameters.country.getSiteGlobalId());
        interestContainer = new ent(searchparameters);
    }
}
