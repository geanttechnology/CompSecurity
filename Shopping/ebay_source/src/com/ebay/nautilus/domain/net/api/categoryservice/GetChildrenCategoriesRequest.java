// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.categoryservice;

import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.Gson;

// Referenced classes of package com.ebay.nautilus.domain.net.api.categoryservice:
//            CategoryServiceRequest, GetChildrenCategoriesResponse

public final class GetChildrenCategoriesRequest extends CategoryServiceRequest
{
    public static final class Payload
    {

        public final String categoryId;
        public final Integer level;
        public final String pageNumber;
        public final String siteId;

        public Payload(String s, long l, Integer integer, Integer integer1)
        {
            siteId = s;
            categoryId = Long.toString(l);
            level = integer;
            if (integer1 != null)
            {
                s = integer1.toString();
            } else
            {
                s = null;
            }
            pageNumber = s;
        }
    }


    private static final int MAXIMUM_LEVEL = 6;
    private static final int MINIMUM_LEVEL = 0;
    public static final String OPERATION_NAME = "getChildrenCategories";
    private final long categoryId;
    private final String ebaySiteId;
    private final Integer level;
    private final Integer pageNumber;

    public GetChildrenCategoriesRequest(long l, Integer integer, Integer integer1, String s, EbaySite ebaysite)
    {
        super("getChildrenCategories", s, ebaysite);
        categoryId = l;
        if (integer == null)
        {
            integer = null;
        } else
        {
            integer = Integer.valueOf(Math.max(Math.min(integer.intValue(), 6), 0));
        }
        level = integer;
        pageNumber = integer1;
        ebaySiteId = ebaysite.id;
    }

    public byte[] buildRequest()
    {
        return defaultRequestMapper.toJson(new Payload(ebaySiteId, categoryId, level, pageNumber)).getBytes();
    }

    public GetChildrenCategoriesResponse getResponse()
    {
        return new GetChildrenCategoriesResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
