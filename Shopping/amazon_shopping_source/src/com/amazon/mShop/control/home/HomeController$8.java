// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.home;

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
        HomeController.access$602(HomeController.this, null);
        for (Iterator iterator = (new ArrayList(HomeController.access$200(HomeController.this))).iterator(); iterator.hasNext(); ((HomeSubscriber)iterator.next()).onCancelled()) { }
        if (HomeController.access$800(HomeController.this))
        {
            HomeController.access$900(HomeController.this);
        }
    }

    ()
    {
        this$0 = HomeController.this;
        super();
    }
}
