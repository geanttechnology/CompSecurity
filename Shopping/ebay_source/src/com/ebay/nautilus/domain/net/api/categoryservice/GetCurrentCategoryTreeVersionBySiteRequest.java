// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.categoryservice;

import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.Gson;

// Referenced classes of package com.ebay.nautilus.domain.net.api.categoryservice:
//            CategoryServiceRequest, GetCurrentCategoryTreeVersionBySiteResponse

public final class GetCurrentCategoryTreeVersionBySiteRequest extends CategoryServiceRequest
{
    public static final class Payload
    {

        public String siteId;

        public Payload(String s)
        {
            siteId = s;
        }
    }


    public static final String OPERATION_NAME = "getCurrentCategoryTreeVersionBySite";
    private final String ebaySiteId;

    protected GetCurrentCategoryTreeVersionBySiteRequest(String s, EbaySite ebaysite)
    {
        super("getCurrentCategoryTreeVersionBySite", s, ebaysite);
        ebaySiteId = ebaysite.id;
    }

    public byte[] buildRequest()
    {
        return defaultRequestMapper.toJson(new Payload(ebaySiteId)).getBytes();
    }

    public GetCurrentCategoryTreeVersionBySiteResponse getResponse()
    {
        return new GetCurrentCategoryTreeVersionBySiteResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
