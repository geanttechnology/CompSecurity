// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.groupon.http.Http;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.ReturningFunction1;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.service:
//            ApiServiceBase

class val.finallyCallback extends Http
{

    final ApiServiceBase this$0;
    final Function0 val$cancelRetryCallback;
    final ReturningFunction1 val$exceptionCallback;
    final Function0 val$finallyCallback;
    final Function1 val$successCallback;
    final String val$url;

    protected void onException(Exception exception)
    {
        Ln.d("API SERVICE BASE: exception for %s: %s", new Object[] {
            val$url, exception.getMessage()
        });
        boolean flag = true;
        if (val$exceptionCallback != null)
        {
            flag = ((Boolean)val$exceptionCallback.execute(exception)).booleanValue();
        }
        if (flag)
        {
            super.onException(exception);
        }
    }

    protected void onFinally()
    {
        super.onFinally();
        if (val$finallyCallback != null)
        {
            val$finallyCallback.execute();
        }
    }

    protected void onSuccess(Object obj)
        throws Exception
    {
        super.onSuccess(obj);
        Ln.d("API SERVICE BASE: success for %s", new Object[] {
            val$url
        });
        if (val$successCallback != null)
        {
            val$successCallback.execute(obj);
        }
    }

    public void onUserCancelRetry()
    {
        super.onUserCancelRetry();
        if (val$cancelRetryCallback != null)
        {
            val$cancelRetryCallback.execute();
        }
    }

    transient (Function1 function1, 
            ReturningFunction1 returningfunction1, Function0 function0, Function0 function0_1)
    {
        this$0 = final_apiservicebase;
        val$url = String.this;
        val$successCallback = function1;
        val$exceptionCallback = returningfunction1;
        val$cancelRetryCallback = function0;
        val$finallyCallback = function0_1;
        super(final_context, final_class1, final_s, final_aobj);
    }
}
