// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.error;


// Referenced classes of package com.amazon.insights.error:
//            BaseInsightsError

public class NullArgumentError extends BaseInsightsError
{

    private final String parameterName;

    public NullArgumentError(String s, String s1)
    {
        super(String.format("Null value for parameter: '%s' provided to method '%s'", new Object[] {
            s, s1
        }));
        parameterName = s;
    }

    public volatile String getMessage()
    {
        return super.getMessage();
    }
}
