// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.home;

import com.amazon.mShop.control.cart.CartController;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.persistence.DataStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mShop.control.home:
//            HomeController, HomeSubscriber

class this._cls0
    implements Runnable
{

    final HomeController this$0;

    public void run()
    {
        HomeController.access$502(HomeController.this, System.currentTimeMillis());
        HomeController.access$602(HomeController.this, null);
        com.amazon.mShop.platform.getInstance().getDataStore().remove("applicationExitReason");
        if (HomeController.access$400(HomeController.this))
        {
            CartController.getInstance().onCartReceivedFromHomeCall(null);
            HomeController.access$402(HomeController.this, false);
        }
        if (!HomeController.access$000(HomeController.this) && User.getUser() != null)
        {
            HomeController.access$702(HomeController.this, true);
            User.userSignedOut();
        }
        for (Iterator iterator = (new ArrayList(HomeController.access$200(HomeController.this))).iterator(); iterator.hasNext(); ((HomeSubscriber)iterator.next()).onPageComplete()) { }
        if (HomeController.access$800(HomeController.this))
        {
            HomeController.access$900(HomeController.this);
        }
    }

    e()
    {
        this$0 = HomeController.this;
        super();
    }
}
