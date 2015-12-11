// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.home;

import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.BasicProductsResponse;

// Referenced classes of package com.amazon.mShop.control.home:
//            BasicProductsController, BasicProductsSubscriber

class esponse
    implements Runnable
{

    final BasicProductsController this$0;
    final BasicProductsResponse val$response;
    final ServiceCall val$sc;

    public void run()
    {
        if (BasicProductsController.access$300(BasicProductsController.this, val$sc))
        {
            BasicProductsController.access$400(BasicProductsController.this);
            BasicProductsController.access$200(BasicProductsController.this).onBasicProductsReceived(val$response);
        }
    }

    esponse()
    {
        this$0 = final_basicproductscontroller;
        val$sc = servicecall;
        val$response = BasicProductsResponse.this;
        super();
    }
}
