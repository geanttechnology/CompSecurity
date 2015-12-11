// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpbuyingoptions;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdpbuyingoptions:
//            BuyingOptionsResponse

public class SIBuyingOptions
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private BuyingOptionsResponse response;
    private String type;
    private double version;

    public SIBuyingOptions()
    {
    }

    public BuyingOptionsResponse getResponse()
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

    public void setResponse(BuyingOptionsResponse buyingoptionsresponse)
    {
        response = buyingoptionsresponse;
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
