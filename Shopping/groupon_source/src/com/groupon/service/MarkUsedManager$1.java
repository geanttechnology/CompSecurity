// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.groupon.http.Http;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.service:
//            MarkUsedManager

class val.finallyCallback extends Http
{

    final MarkUsedManager this$0;
    final Function1 val$errorCallback;
    final Function0 val$finallyCallback;
    final Function1 val$successCallback;

    protected void onException(Exception exception)
    {
        Ln.d("BARCODE: fail: %s!", new Object[] {
            exception.getMessage()
        });
        if (val$errorCallback != null)
        {
            val$errorCallback.execute(exception);
        }
    }

    protected void onFinally()
    {
        if (val$finallyCallback != null)
        {
            val$finallyCallback.execute();
        }
    }

    protected void onSuccess(com.groupon.models.er er)
    {
        Ln.d("BARCODE: success!", new Object[0]);
        if (val$successCallback != null)
        {
            val$successCallback.execute(er.groupon);
        }
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((com.groupon.models.er)obj);
    }

    transient r(Object aobj[], Function1 function1, Function1 function1_1, 
            Function0 function0)
    {
        this$0 = final_markusedmanager;
        val$successCallback = function1;
        val$errorCallback = function1_1;
        val$finallyCallback = function0;
        super(final_context, final_class1, String.this, aobj);
    }
}
