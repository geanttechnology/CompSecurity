// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.legacy;


// Referenced classes of package com.shazam.server.legacy:
//            ErrorBean

public class ErrorResponse
{

    private ErrorBean errorBean;

    private ErrorResponse()
    {
    }

    public ErrorResponse(ErrorBean errorbean)
    {
        errorBean = errorbean;
    }

    public ErrorBean getErrorBean()
    {
        return errorBean;
    }
}
