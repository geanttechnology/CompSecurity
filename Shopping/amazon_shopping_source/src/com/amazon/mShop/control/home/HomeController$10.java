// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.home;

import com.amazon.rio.j2me.client.services.mShop.HomeShoveler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mShop.control.home:
//            HomeController, HomeSubscriber

class oveler
    implements Runnable
{

    final HomeController this$0;
    final HomeShoveler val$value;

    public void run()
    {
        HomeController.access$1102(HomeController.this, val$value);
        for (Iterator iterator = (new ArrayList(HomeController.access$200(HomeController.this))).iterator(); iterator.hasNext(); ((HomeSubscriber)iterator.next()).onHomeShoveler1Received(val$value)) { }
    }

    oveler()
    {
        this$0 = final_homecontroller;
        val$value = HomeShoveler.this;
        super();
    }
}
