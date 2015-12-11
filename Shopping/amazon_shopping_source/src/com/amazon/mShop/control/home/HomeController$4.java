// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.home;

import com.amazon.mShop.control.cart.CartController;
import com.amazon.rio.j2me.client.services.mShop.CartItems;

// Referenced classes of package com.amazon.mShop.control.home:
//            HomeController

class tems
    implements Runnable
{

    final HomeController this$0;
    final CartItems val$value;

    public void run()
    {
        HomeController.access$402(HomeController.this, false);
        CartController.getInstance().onCartReceivedFromHomeCall(val$value);
    }

    tems()
    {
        this$0 = final_homecontroller;
        val$value = CartItems.this;
        super();
    }
}
