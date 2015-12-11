// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.cart;

import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.CartItems;

// Referenced classes of package com.amazon.mShop.control.cart:
//            CartController

class tems
    implements Runnable
{

    final CartController this$0;
    final ServiceCall val$sc;
    final CartItems val$value;

    public void run()
    {
        if (CartController.access$100(CartController.this, val$sc))
        {
            CartController.access$200(CartController.this);
            CartController.access$300(CartController.this, val$value);
        }
    }

    tems()
    {
        this$0 = final_cartcontroller;
        val$sc = servicecall;
        val$value = CartItems.this;
        super();
    }
}
