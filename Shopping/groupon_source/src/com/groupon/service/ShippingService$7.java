// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.groupon.http.Http;
import com.groupon.models.shippingFields.converter.ShippingFieldsConverter;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.ReturningFunction1;

// Referenced classes of package com.groupon.service:
//            ShippingService

class val.finallyCallback extends Http
{

    final ShippingService this$0;
    final ReturningFunction1 val$exceptionCallback;
    final Function0 val$finallyCallback;
    final Function1 val$successCallback;

    protected void onException(Exception exception)
        throws RuntimeException
    {
        super.onException(exception);
        if (val$exceptionCallback != null)
        {
            val$exceptionCallback.execute(exception);
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

    protected void onSuccess(com.groupon.models.shippingFields.json. )
        throws Exception
    {
        super.onSuccess();
         = ShippingService.access$000(ShippingService.this).fromJson();
        val$successCallback.execute();
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((com.groupon.models.shippingFields.json.)obj);
    }

    transient .ShippingField.List(Object aobj[], Function1 function1, ReturningFunction1 returningfunction1, 
            Function0 function0)
    {
        this$0 = final_shippingservice;
        val$successCallback = function1;
        val$exceptionCallback = returningfunction1;
        val$finallyCallback = function0;
        super(final_context, final_class1, String.this, aobj);
    }
}
