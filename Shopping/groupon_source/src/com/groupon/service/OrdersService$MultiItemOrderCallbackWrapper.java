// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import com.groupon.models.order.OrderContainer;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.ReturningFunction1;

// Referenced classes of package com.groupon.service:
//            OrdersService, OrdersServiceMultiItemListener

private static class _cls3.val.listener
{

    public final ReturningFunction1 exceptionCallback;
    public final Function0 finallyCallback;
    public final Function1 successCallback;

    public _cls3.val.listener(final OrdersServiceMultiItemListener listener)
    {
        successCallback = new Function1() {

            final OrdersService.MultiItemOrderCallbackWrapper this$0;
            final OrdersServiceMultiItemListener val$listener;

            public void execute(OrderContainer ordercontainer)
                throws RuntimeException
            {
                listener.onSuccess(ordercontainer);
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((OrderContainer)obj);
            }

            
            {
                this$0 = OrdersService.MultiItemOrderCallbackWrapper.this;
                listener = ordersservicemultiitemlistener;
                super();
            }
        };
        exceptionCallback = new ReturningFunction1() {

            final OrdersService.MultiItemOrderCallbackWrapper this$0;
            final OrdersServiceMultiItemListener val$listener;

            public Boolean execute(Exception exception)
                throws RuntimeException
            {
                return Boolean.valueOf(listener.onException(exception));
            }

            public volatile Object execute(Object obj)
                throws Exception
            {
                return execute((Exception)obj);
            }

            
            {
                this$0 = OrdersService.MultiItemOrderCallbackWrapper.this;
                listener = ordersservicemultiitemlistener;
                super();
            }
        };
        finallyCallback = new Function0() {

            final OrdersService.MultiItemOrderCallbackWrapper this$0;
            final OrdersServiceMultiItemListener val$listener;

            public void execute()
                throws RuntimeException
            {
                listener.onComplete();
            }

            
            {
                this$0 = OrdersService.MultiItemOrderCallbackWrapper.this;
                listener = ordersservicemultiitemlistener;
                super();
            }
        };
    }
}
