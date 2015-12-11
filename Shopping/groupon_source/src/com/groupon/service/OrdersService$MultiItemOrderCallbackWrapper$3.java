// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import com.groupon.util.Function0;

// Referenced classes of package com.groupon.service:
//            OrdersService, OrdersServiceMultiItemListener

class val.listener
    implements Function0
{

    final val.listener this$0;
    final OrdersServiceMultiItemListener val$listener;

    public void execute()
        throws RuntimeException
    {
        val$listener.onComplete();
    }

    ()
    {
        this$0 = final_;
        val$listener = OrdersServiceMultiItemListener.this;
        super();
    }
}
