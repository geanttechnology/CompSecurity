// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.home;

import com.amazon.mShop.control.home.HomeController;
import com.amazon.mShop.net.PageMetricsObserver;

// Referenced classes of package com.amazon.mShop.home:
//            HomeView, GatewayActivity

class this._cls0
    implements Runnable
{

    final HomeView this$0;

    public void run()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (!HomeView.access$1000(HomeView.this))
        {
            flag = flag1;
            if (HomeView.access$1100(HomeView.this).isFinished())
            {
                HomeView.access$1102(HomeView.this, new PageMetricsObserver("HomeRefreshCriticalFeature"));
                HomeView.access$1100(HomeView.this).startForObject(HomeView.access$100(HomeView.this).getClass().getSimpleName());
                flag = true;
            }
        }
        HomeView.access$1202(HomeView.this, true);
        HomeView.access$100(HomeView.this).setReturnCartItems(true);
        HomeView.access$100(HomeView.this).setReturnHomeItems(true);
        boolean flag2 = HomeView.access$100(HomeView.this).phoneHome(HomeView.access$1300(HomeView.this), HomeView.access$1300(HomeView.this));
        if (!flag2 && flag && !HomeView.access$1100(HomeView.this).isFinished())
        {
            HomeView.access$1100(HomeView.this).onCancelled();
        }
        HomeView.access$1400(HomeView.this, flag2);
        if (HomeView.access$1500(HomeView.this).isHomeActivityJustCreated())
        {
            onHomeCallStarted();
        }
        HomeView.access$1302(HomeView.this, false);
        HomeView.access$1500(HomeView.this).setHomeActivityJustCreated(false);
        postHomePageImpression();
    }

    vity()
    {
        this$0 = HomeView.this;
        super();
    }
}
