// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.home;

import com.amazon.mShop.model.auth.User;
import com.amazon.rio.j2me.client.services.mShop.LoginData;

// Referenced classes of package com.amazon.mShop.control.home:
//            HomeController

class Data
    implements Runnable
{

    final HomeController this$0;
    final LoginData val$value;

    public void run()
    {
        HomeController.access$002(HomeController.this, true);
        User.userUpdated(val$value);
    }

    Data()
    {
        this$0 = final_homecontroller;
        val$value = LoginData.this;
        super();
    }
}
