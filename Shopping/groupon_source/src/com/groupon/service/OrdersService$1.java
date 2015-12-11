// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import com.groupon.models.MultiItemOrderResponse;
import com.groupon.util.Function1;

// Referenced classes of package com.groupon.service:
//            OrdersService

class val.successCallback
    implements Function1
{

    final OrdersService this$0;
    final Function1 val$successCallback;

    public void execute(MultiItemOrderResponse multiitemorderresponse)
    {
        val$successCallback.execute(multiitemorderresponse.order);
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((MultiItemOrderResponse)obj);
    }

    ponse()
    {
        this$0 = final_ordersservice;
        val$successCallback = Function1.this;
        super();
    }
}
