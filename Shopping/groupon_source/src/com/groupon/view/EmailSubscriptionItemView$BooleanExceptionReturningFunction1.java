// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import com.groupon.util.Function1;
import com.groupon.util.ReturningFunction1;

// Referenced classes of package com.groupon.view:
//            EmailSubscriptionItemView

private static class internalCallback
    implements ReturningFunction1
{

    private final Function1 internalCallback;

    public Boolean execute(Exception exception)
    {
        internalCallback.execute(null);
        return Boolean.valueOf(true);
    }

    public volatile Object execute(Object obj)
        throws Exception
    {
        return execute((Exception)obj);
    }

    public (Function1 function1)
    {
        internalCallback = function1;
    }
}
