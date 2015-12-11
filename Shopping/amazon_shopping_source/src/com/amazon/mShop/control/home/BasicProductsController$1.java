// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.home;

import com.amazon.rio.j2me.client.services.ServiceCall;

// Referenced classes of package com.amazon.mShop.control.home:
//            BasicProductsController, BasicProductsSubscriber

class val.exp
    implements Runnable
{

    final BasicProductsController this$0;
    final Exception val$exp;
    final ServiceCall val$sc;

    public void run()
    {
        if (BasicProductsController.access$000(BasicProductsController.this, val$sc))
        {
            BasicProductsController.access$100(BasicProductsController.this);
            BasicProductsController.access$200(BasicProductsController.this).onError(val$exp, val$sc);
        }
    }

    ()
    {
        this$0 = final_basicproductscontroller;
        val$sc = servicecall;
        val$exp = Exception.this;
        super();
    }
}
