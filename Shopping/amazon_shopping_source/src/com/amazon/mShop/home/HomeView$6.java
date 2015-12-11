// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.home;

import android.view.View;
import android.widget.ImageView;
import com.amazon.mShop.error.AmazonErrorInfo;

// Referenced classes of package com.amazon.mShop.home:
//            HomeView, GatewayActivity, PromoSlotView, HomeShovelerView

class val.view
    implements Runnable
{

    final HomeView this$0;
    final View val$view;

    public void run()
    {
        if (HomeView.access$1500(HomeView.this).getCurrentView() == val$view && HomeView.access$1500(HomeView.this).getCurrentErrorInfo() != null && HomeView.access$1500(HomeView.this).getCurrentErrorInfo().getErrorId() == 4)
        {
            HomeView.access$1500(HomeView.this).dismissErrorBox();
        }
        if (!HomeView.access$1200(HomeView.this))
        {
            return;
        } else
        {
            HomeView.access$1202(HomeView.this, false);
            HomeView.access$300(HomeView.this).clear();
            HomeView.access$600(HomeView.this).clear();
            HomeView.access$1600(HomeView.this).setVisibility(8);
            HomeView.access$1700(HomeView.this).setVisibility(0);
            HomeView.access$1800(HomeView.this).setVisibility(0);
            HomeView.access$1900(HomeView.this).setVisibility(0);
            HomeView.access$2000(HomeView.this).setVisibility(0);
            HomeView.access$2100(HomeView.this);
            HomeView.access$1900(HomeView.this).clear();
            HomeView.access$2000(HomeView.this).clear();
            return;
        }
    }

    rView()
    {
        this$0 = final_homeview;
        val$view = View.this;
        super();
    }
}
