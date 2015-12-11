// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpreviews;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdpreviews:
//            ReviewsResponse

public class SIReviews
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private ReviewsResponse response;
    private String type;
    private double version;

    public SIReviews()
    {
    }

    public ReviewsResponse getResponse()
    {
        return response;
    }

    public String getType()
    {
        return type;
    }

    public double getVersion()
    {
        return version;
    }

    public void setResponse(ReviewsResponse reviewsresponse)
    {
        response = reviewsresponse;
    }

    public void setType(String s)
    {
        type = s;
    }

    public void setVersion(double d)
    {
        version = d;
    }
}
