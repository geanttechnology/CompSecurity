// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp.editorialreview;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdp.editorialreview:
//            PDPEditorialReviewResponse

public class PDPEditorialReviewSI
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private PDPEditorialReviewResponse response;
    private String type;
    private String version;

    public PDPEditorialReviewSI()
    {
    }

    public PDPEditorialReviewResponse getResponse()
    {
        return response;
    }

    public String getType()
    {
        return type;
    }

    public String getVersion()
    {
        return version;
    }

    public void setResponse(PDPEditorialReviewResponse pdpeditorialreviewresponse)
    {
        response = pdpeditorialreviewresponse;
    }

    public void setType(String s)
    {
        type = s;
    }

    public void setVersion(String s)
    {
        version = s;
    }
}
