// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import com.groupon.util.ReturningFunction1;

// Referenced classes of package com.groupon.service:
//            OrdersService, OrdersServiceMultiItemListener

class val.listener
    implements ReturningFunction1
{

    final execute this$0;
    final OrdersServiceMultiItemListener val$listener;

    public Boolean execute(Exception exception)
        throws RuntimeException
    {
        return Boolean.valueOf(val$listener.onException(exception));
    }

    public volatile Object execute(Object obj)
        throws Exception
    {
        return execute((Exception)obj);
    }

    ()
    {
        this$0 = final_;
        val$listener = OrdersServiceMultiItemListener.this;
        super();
    }
}
