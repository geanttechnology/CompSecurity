// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.error;


// Referenced classes of package com.amazon.insights.error:
//            BaseInsightsError

public class UnexpectedError extends BaseInsightsError
{

    private final Exception exception;

    public UnexpectedError(String s, Exception exception1)
    {
        super(s);
        exception = exception1;
    }

    public volatile String getMessage()
    {
        return super.getMessage();
    }
}
