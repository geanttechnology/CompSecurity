// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.error;


// Referenced classes of package com.amazon.insights.error:
//            InsightsError

class BaseInsightsError
    implements InsightsError
{

    private final String message;

    public BaseInsightsError(String s)
    {
        message = s;
    }

    public String getMessage()
    {
        return message;
    }
}
