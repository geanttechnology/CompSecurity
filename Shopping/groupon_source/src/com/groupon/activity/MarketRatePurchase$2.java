// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.view.ObservableScrollView;

// Referenced classes of package com.groupon.activity:
//            MarketRatePurchase

class this._cls0
    implements com.groupon.view.OnLayoutUpdatedListener
{

    final MarketRatePurchase this$0;

    public void onLayoutUpdated(boolean flag, int i, int j, int k, int l)
    {
        scroller.smoothScrollTo(0, titleGradientContainer.getTop());
    }

    youtUpdatedListener()
    {
        this$0 = MarketRatePurchase.this;
        super();
    }
}
