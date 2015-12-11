// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.groupon.http.Http;
import com.groupon.models.shipping.AddressEu;
import com.groupon.util.Function0;
import com.groupon.util.Function1;

// Referenced classes of package com.groupon.service:
//            ShippingService

class val.onFinally extends Http
{

    final ShippingService this$0;
    final Function1 val$onException;
    final Function0 val$onFinally;
    final Function1 val$onSuccess;

    protected void onException(Exception exception)
    {
        if (val$onException != null)
        {
            clearStore();
            val$onException.execute(exception);
            return;
        } else
        {
            super.onException(exception);
            return;
        }
    }

    protected void onFinally()
    {
        if (val$onFinally == null)
        {
            super.onFinally();
            return;
        } else
        {
            val$onFinally.execute();
            return;
        }
    }

    protected void onSuccess(AddressEu addresseu)
        throws Exception
    {
        if (val$onSuccess != null)
        {
            val$onSuccess.execute(addresseu);
        }
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((AddressEu)obj);
    }

    transient (Object aobj[], Function1 function1, Function1 function1_1, 
            Function0 function0)
    {
        this$0 = final_shippingservice;
        val$onSuccess = function1;
        val$onException = function1_1;
        val$onFinally = function0;
        super(final_context, final_class1, String.this, aobj);
    }
}
