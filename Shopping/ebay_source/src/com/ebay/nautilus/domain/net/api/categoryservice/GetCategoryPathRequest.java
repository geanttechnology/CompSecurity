// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.categoryservice;

import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.Gson;

// Referenced classes of package com.ebay.nautilus.domain.net.api.categoryservice:
//            CategoryServiceRequest, GetCategoryPathResponse

public final class GetCategoryPathRequest extends CategoryServiceRequest
{
    public static final class Payload
    {

        public final SiteCategoryInputDetail siteCategoryInputDetail;

        public Payload(String s, long l)
        {
            siteCategoryInputDetail = new SiteCategoryInputDetail(s, l);
        }
    }

    public static final class Payload.SiteCategoryInputDetail
    {

        public final String categoryId;
        public final String siteId;

        public Payload.SiteCategoryInputDetail(String s, long l)
        {
            siteId = s;
            categoryId = Long.toString(l);
        }
    }


    public static final String OPERATION_NAME = "getCategoryPath";
    private final long categoryId;
    private final String ebaySiteId;

    public GetCategoryPathRequest(long l, String s, EbaySite ebaysite)
    {
        super("getCategoryPath", s, ebaysite);
        categoryId = l;
        ebaySiteId = ebaysite.id;
    }

    public byte[] buildRequest()
    {
        return defaultRequestMapper.toJson(new Payload(ebaySiteId, categoryId)).getBytes();
    }

    public GetCategoryPathResponse getResponse()
    {
        return new GetCategoryPathResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
