// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.marketrate;

import com.groupon.util.Function1;
import com.groupon.util.ReturningFunction1;

// Referenced classes of package com.groupon.service.marketrate:
//            HotelsService

protected static class onException
    implements ReturningFunction1
{

    protected final Function1 onException;

    public Boolean execute(Exception exception)
    {
        if (onException != null)
        {
            onException.execute(exception);
        }
        return Boolean.valueOf(false);
    }

    public volatile Object execute(Object obj)
        throws Exception
    {
        return execute((Exception)obj);
    }

    public (Function1 function1)
    {
        onException = function1;
    }
}
