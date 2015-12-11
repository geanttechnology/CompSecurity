// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.groupon.http.Http;
import com.groupon.util.CheckedFunction1;
import com.groupon.util.Function0;
import com.groupon.util.Function1;

// Referenced classes of package com.groupon.service:
//            ShippingService

class val.finallyListener extends Http
{

    final ShippingService this$0;
    final Function1 val$exceptionListener;
    final Function0 val$finallyListener;
    final CheckedFunction1 val$listener;

    protected void onException(Exception exception)
    {
        super.onException(exception);
        clearStore();
        if (val$exceptionListener != null)
        {
            val$exceptionListener.execute(exception);
        }
    }

    protected void onFinally()
    {
        super.onFinally();
        if (val$finallyListener != null)
        {
            val$finallyListener.execute();
        }
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((Void)obj);
    }

    protected void onSuccess(Void void1)
        throws Exception
    {
        super.onSuccess(void1);
        if (val$listener != null)
        {
            val$listener.execute(void1);
        }
    }

    transient (Object aobj[], CheckedFunction1 checkedfunction1, Function1 function1, 
            Function0 function0)
    {
        this$0 = final_shippingservice;
        val$listener = checkedfunction1;
        val$exceptionListener = function1;
        val$finallyListener = function0;
        super(final_context, final_class1, String.this, aobj);
    }
}
