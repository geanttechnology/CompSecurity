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

class this._cls0
    implements GetListListsResponseListener
{

    final WishListController this$0;

    public void cancelled(ServiceCall servicecall)
    {
        WishListController.this.cancelled(servicecall);
    }

    public void completed(final List value, final ServiceCall sc)
    {
        com.amazon.mShop.platform.nstance().invokeLater(new Runnable() {

            final WishListController._cls1 this$1;
            final ServiceCall val$sc;
            final List val$value;

            public void run()
            {
                if (WishListController.access$000(this$0, sc))
                {
                    WishListController.access$100(this$0);
                    WishListController.access$200(this$0).onListLists(value);
                }
            }

            
            {
                this$1 = WishListController._cls1.this;
                sc = servicecall;
                value = list;
                super();
            }
        });
    }

    public void error(Exception exception, ServiceCall servicecall)
    {
        WishListController.this.error(exception, servicecall);
    }

    _cls1.val.value()
    {
        this$0 = WishListController.this;
        super();
    }
}
