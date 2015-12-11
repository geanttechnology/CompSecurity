// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.wishlist;

import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.GetListListsResponseListener;
import java.util.List;

// Referenced classes of package com.amazon.mShop.control.wishlist:
//            WishListController, WishListSubscriber

class val.value
    implements Runnable
{

    final val.value this$1;
    final ServiceCall val$sc;
    final List val$value;

    public void run()
    {
        if (WishListController.access$000(_fld0, val$sc))
        {
            WishListController.access$100(_fld0);
            WishListController.access$200(_fld0).onListLists(val$value);
        }
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$sc = servicecall;
        val$value = List.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/control/wishlist/WishListController$1

/* anonymous class */
    class WishListController._cls1
        implements GetListListsResponseListener
    {

        final WishListController this$0;

        public void cancelled(ServiceCall servicecall)
        {
            WishListController.this.cancelled(servicecall);
        }

        public void completed(List list, final ServiceCall sc)
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(list. new WishListController._cls1._cls1());
        }

        public void error(Exception exception, ServiceCall servicecall)
        {
            WishListController.this.error(exception, servicecall);
        }

            
            {
                this$0 = WishListController.this;
                super();
            }
    }

}
