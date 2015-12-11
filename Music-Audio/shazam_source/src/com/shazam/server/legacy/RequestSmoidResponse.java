// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.legacy;


// Referenced classes of package com.shazam.server.legacy:
//            ErrorBean, RequestSmoid

public class RequestSmoidResponse
{

    private ErrorBean errorBean;
    private RequestSmoid requestSmoid;
    private Long timestamp;

    private RequestSmoidResponse()
    {
    }

    private RequestSmoidResponse(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        timestamp = Builder.access._mth000(builder);
        errorBean = Builder.access._mth100(builder);
        requestSmoid = Builder.access._mth200(builder);
    }

    RequestSmoidResponse(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public ErrorBean getErrorBean()
    {
        return errorBean;
    }

    public RequestSmoid getRequestSmoid()
    {
        return requestSmoid;
    }

    public Long getTimestamp()
    {
        return timestamp;
    }
}
