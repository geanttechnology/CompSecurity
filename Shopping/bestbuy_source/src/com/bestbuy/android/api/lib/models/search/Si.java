// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.search;

import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.search:
//            Response

public class Si
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private Response response;
    private String type;
    private double version;

    public Si()
    {
    }

    public Response getResponse()
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

    public void setResponse(Response response1)
    {
        response = response1;
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
