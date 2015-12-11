// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.categoryservice;

import java.io.InputStream;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.api.categoryservice:
//            CategoryServiceResponse

public final class GetCurrentCategoryTreeVersionBySiteResponse extends CategoryServiceResponse
{
    public static final class Payload
    {

        public List categoryTreeVersionDetail;

        public Payload()
        {
        }
    }

    public static final class Payload.CategoryTreeVersionDetail
    {

        public String categoryTreeVersion;
        public String siteId;

        public Payload.CategoryTreeVersionDetail()
        {
        }
    }


    public Payload data;

    public GetCurrentCategoryTreeVersionBySiteResponse()
    {
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        data = (Payload)readJsonStream(inputstream, com/ebay/nautilus/domain/net/api/categoryservice/GetCurrentCategoryTreeVersionBySiteResponse$Payload);
    }
}
