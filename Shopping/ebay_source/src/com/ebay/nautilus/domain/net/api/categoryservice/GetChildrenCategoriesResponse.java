// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.categoryservice;

import com.ebay.nautilus.domain.net.ResponseWrapper;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import java.io.InputStream;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.api.categoryservice:
//            CategoryServiceResponse

public final class GetChildrenCategoriesResponse extends CategoryServiceResponse
{
    public static final class CallWrapper
        implements ResponseWrapper
    {

        protected Payload payload;

        public Payload getResponse()
        {
            return payload;
        }

        public volatile BaseApiResponse getResponse()
        {
            return getResponse();
        }

        public CallWrapper()
        {
        }
    }

    public static final class Payload extends CategoryServiceResponse.CategoryServicePayload
    {

        public List categoryNodes;
        public int numberOfChildrenCategories;
        public CategoryServiceResponse.PaginationDetails paginationDetails;

        public Payload()
        {
        }
    }


    public Payload data;

    public GetChildrenCategoriesResponse()
    {
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        inputstream = (CallWrapper)readJsonStream(inputstream, com/ebay/nautilus/domain/net/api/categoryservice/GetChildrenCategoriesResponse$CallWrapper);
        if (inputstream != null)
        {
            data = inputstream.getResponse();
        }
    }
}
