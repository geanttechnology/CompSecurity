// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.categoryservice;

import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.Gson;

// Referenced classes of package com.ebay.nautilus.domain.net.api.categoryservice:
//            CategoryServiceRequest, GetTopLevelCategoriesResponse

public final class GetTopLevelCategoriesRequest extends CategoryServiceRequest
{
    public static final class Payload
    {

        public final String siteId;

        public Payload(String s)
        {
            siteId = s;
        }
    }


    public static final String OPERATION_NAME = "getTopLevelCategories";
    private final String ebaySiteId;

    public GetTopLevelCategoriesRequest(String s, EbaySite ebaysite)
    {
        super("getTopLevelCategories", s, ebaysite);
        ebaySiteId = ebaysite.id;
    }

    public byte[] buildRequest()
    {
        return defaultRequestMapper.toJson(new Payload(ebaySiteId)).getBytes();
    }

    public GetTopLevelCategoriesResponse getResponse()
    {
        return new GetTopLevelCategoriesResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
