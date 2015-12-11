// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;

// Referenced classes of package com.groupon.activity:
//            MarketRatePurchase

class this._cls0
    implements android.view.obalLayoutListener
{

    final MarketRatePurchase this$0;

    public void onGlobalLayout()
    {
        int i = bottomBar.getHeight();
        scrollableContent.setPadding(0, 0, 0, i);
    }

    utListener()
    {
        this$0 = MarketRatePurchase.this;
        super();
    }
}
