// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.store;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.store:
//            Response

public class Si
    implements gu, Serializable
{

    private Response response;
    private String type;
    private String version;

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

    public String getVersion()
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

    public void setVersion(String s)
    {
        version = s;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ClassPojo [response = ").append(response).append(", type = ").append(type).append(", version = ").append(version).append("]").toString();
    }
}
