// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.wishlist;

import com.amazon.rio.j2me.client.services.ServiceCall;

// Referenced classes of package com.amazon.mShop.control.wishlist:
//            WishListController, WishListSubscriber

class val.sc
    implements Runnable
{

    final WishListController this$0;
    final ServiceCall val$sc;

    public void run()
    {
        if (WishListController.access$700(WishListController.this, val$sc))
        {
            WishListController.access$800(WishListController.this);
            WishListController.access$200(WishListController.this).onWishListItemAdded();
        }
    }

    ()
    {
        this$0 = final_wishlistcontroller;
        val$sc = ServiceCall.this;
        super();
    }
}
