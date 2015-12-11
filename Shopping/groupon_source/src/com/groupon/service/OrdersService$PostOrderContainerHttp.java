// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.groupon.http.Http;
import com.groupon.models.order.OrderContainer;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.ReturningFunction1;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.RequestBody;

// Referenced classes of package com.groupon.service:
//            OrdersService

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
    }

    protected void onFinally()
    {
        super.onFinally();
        if (finallyCallback != null)
        {
            finallyCallback.execute();
        }
    }

    protected void onSuccess(OrderContainer ordercontainer)
        throws Exception
    {
        super.onSuccess(ordercontainer);
        if (successCallback != null)
        {
            successCallback.execute(ordercontainer);
        }
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((OrderContainer)obj);
    }

    public (Context context, String s, Headers headers, RequestBody requestbody, Function1 function1, ReturningFunction1 returningfunction1, Function0 function0)
    {
        super(context, com/groupon/models/order/OrderContainer, s, headers, requestbody);
        successCallback = function1;
        exceptionCallback = returningfunction1;
        finallyCallback = function0;
    }
}
