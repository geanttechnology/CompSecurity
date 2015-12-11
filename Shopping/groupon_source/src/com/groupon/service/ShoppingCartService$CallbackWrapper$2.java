// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import com.groupon.util.ReturningFunction1;

// Referenced classes of package com.groupon.service:
//            ShoppingCartService, ShoppingCartServiceListener

class val.listener
    implements ReturningFunction1
{

    final execute this$1;
    final ShoppingCartServiceListener val$listener;
    final ShoppingCartService val$this$0;

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
        this$1 = final_;
        val$this$0 = shoppingcartservice;
        val$listener = ShoppingCartServiceListener.this;
        super();
    }
}
