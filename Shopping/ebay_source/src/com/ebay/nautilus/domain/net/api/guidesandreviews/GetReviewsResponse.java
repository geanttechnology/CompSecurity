// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.guidesandreviews;

import com.ebay.nautilus.domain.net.EbayCosResponse;
import com.ebay.nautilus.kernel.util.NetworkUtil;
import java.io.InputStream;

// Referenced classes of package com.ebay.nautilus.domain.net.api.guidesandreviews:
//            Reviews

public class GetReviewsResponse extends EbayCosResponse
{

    public Reviews reviews;

    public GetReviewsResponse()
    {
        super(true);
    }

    public boolean hasSuccessResponseCode()
    {
        return super.hasSuccessResponseCode() || NetworkUtil.isHttpClass4xx(responseCode);
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        reviews = (Reviews)readJsonStream(inputstream, com/ebay/nautilus/domain/net/api/guidesandreviews/Reviews);
    }
}
