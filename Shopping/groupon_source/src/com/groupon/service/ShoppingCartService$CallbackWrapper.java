// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import com.groupon.models.shoppingCart.ShoppingCartResponse;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.ReturningFunction1;

// Referenced classes of package com.groupon.service:
//            ShoppingCartService, ShoppingCartServiceListener

private class te
{

    public final Function0 cancelCallback;
    public final ReturningFunction1 exceptionCallback;
    public final Function0 finallyCallback;
    public final Function1 successCallback;
    final ShoppingCartService this$0;

    public _cls4.val.listener(final ShoppingCartServiceListener listener)
    {
        this.this$0 = ShoppingCartService.this;
        super();
        successCallback = new Function1() {

            final ShoppingCartService.CallbackWrapper this$1;
            final ShoppingCartServiceListener val$listener;
            final ShoppingCartService val$this$0;

            public void execute(ShoppingCartResponse shoppingcartresponse)
                throws RuntimeException
            {
                onCartUpdated(shoppingcartresponse.cart);
                listener.onSuccess(shoppingcartresponse);
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((ShoppingCartResponse)obj);
            }

            
            {
                this$1 = ShoppingCartService.CallbackWrapper.this;
                this$0 = shoppingcartservice;
                listener = shoppingcartservicelistener;
                super();
            }
        };
        exceptionCallback = new ReturningFunction1() {

            final ShoppingCartService.CallbackWrapper this$1;
            final ShoppingCartServiceListener val$listener;
            final ShoppingCartService val$this$0;

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
                this$1 = ShoppingCartService.CallbackWrapper.this;
                this$0 = shoppingcartservice;
                listener = shoppingcartservicelistener;
                super();
            }
        };
        cancelCallback = new Function0() {

            final ShoppingCartService.CallbackWrapper this$1;
            final ShoppingCartServiceListener val$listener;
            final ShoppingCartService val$this$0;

            public void execute()
                throws RuntimeException
            {
                listener.onCancel();
            }

            
            {
                this$1 = ShoppingCartService.CallbackWrapper.this;
                this$0 = shoppingcartservice;
                listener = shoppingcartservicelistener;
                super();
            }
        };
        finallyCallback = new Function0() {

            final ShoppingCartService.CallbackWrapper this$1;
            final ShoppingCartServiceListener val$listener;
            final ShoppingCartService val$this$0;

            public void execute()
                throws RuntimeException
            {
                listener.onComplete();
            }

            
            {
                this$1 = ShoppingCartService.CallbackWrapper.this;
                this$0 = shoppingcartservice;
                listener = shoppingcartservicelistener;
                super();
            }
        };
    }
}
