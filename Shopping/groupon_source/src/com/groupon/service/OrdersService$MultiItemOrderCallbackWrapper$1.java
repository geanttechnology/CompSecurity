// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import com.groupon.models.order.OrderContainer;
import com.groupon.util.Function1;

// Referenced classes of package com.groupon.service:
//            OrdersService, OrdersServiceMultiItemListener

class val.listener
    implements Function1
{

    final execute this$0;
    final OrdersServiceMultiItemListener val$listener;

    public void execute(OrderContainer ordercontainer)
        throws RuntimeException
    {
        val$listener.onSuccess(ordercontainer);
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((OrderContainer)obj);
    }

    ()
    {
        this$0 = final_;
        val$listener = OrdersServiceMultiItemListener.this;
        super();
    }
}
