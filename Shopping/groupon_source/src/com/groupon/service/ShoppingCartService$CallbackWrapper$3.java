// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import com.groupon.util.Function0;

// Referenced classes of package com.groupon.service:
//            ShoppingCartService, ShoppingCartServiceListener

class val.listener
    implements Function0
{

    final val.listener this$1;
    final ShoppingCartServiceListener val$listener;
    final ShoppingCartService val$this$0;

    public void execute()
        throws RuntimeException
    {
        val$listener.onCancel();
    }

    ()
    {
        this$1 = final_;
        val$this$0 = shoppingcartservice;
        val$listener = ShoppingCartServiceListener.this;
        super();
    }
}
