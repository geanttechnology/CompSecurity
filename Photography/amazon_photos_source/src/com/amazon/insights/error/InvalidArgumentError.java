// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.error;


// Referenced classes of package com.amazon.insights.error:
//            BaseInsightsError

public class InvalidArgumentError extends BaseInsightsError
{

    private final String parameterName;

    public InvalidArgumentError(String s, String s1, String s2)
    {
        super(String.format("Invalid parameter: '%s' provided to method '%s. %s'", new Object[] {
            s, s1, s2
        }));
        parameterName = s;
    }

    public volatile String getMessage()
    {
        return super.getMessage();
    }
}
