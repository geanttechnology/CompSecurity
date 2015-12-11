// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpoffers;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdpoffers:
//            OffersResponse

public class SIOffers
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private OffersResponse response;
    private String type;
    private double version;

    public SIOffers()
    {
    }

    public OffersResponse getResponse()
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

    public void setResponse(OffersResponse offersresponse)
    {
        response = offersresponse;
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
