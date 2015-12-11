// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.groupon.http.Http;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.models.dealbreakdown.DealMultiItemBreakdownContainer;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.ReturningFunction1;

// Referenced classes of package com.groupon.service:
//            DealBreakdownService

private static class finallyCallback extends Http
{

    private final ReturningFunction1 exceptionCallback;
    private final Function0 finallyCallback;
    private final Function1 successCallback;

    protected void onException(Exception exception)
    {
        if (exceptionCallback != null)
        {
            exceptionCallback.execute(exception);
        }
        super.onException(exception);
    }

    protected void onFinally()
    {
        super.onFinally();
        if (finallyCallback != null)
        {
            finallyCallback.execute();
        }
    }

    protected void onSuccess(DealMultiItemBreakdownContainer dealmultiitembreakdowncontainer)
        throws Exception
    {
        super.onSuccess(dealmultiitembreakdowncontainer);
        if (successCallback != null)
        {
            successCallback.execute(dealmultiitembreakdowncontainer);
        }
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((DealMultiItemBreakdownContainer)obj);
    }

    public (Context context, SyncHttp synchttp, Function1 function1, ReturningFunction1 returningfunction1, Function0 function0)
    {
        super(context, synchttp);
        successCallback = function1;
        exceptionCallback = returningfunction1;
        finallyCallback = function0;
    }
}
