// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view;

import android.view.View;
import com.groupon.callbacks.OnBuyButtonClickListener;
import com.groupon.service.core.AbTestService;

// Referenced classes of package com.groupon.mvc.view:
//            DealDetailsBottomBarView

class this._cls0
    implements android.view.rView._cls1
{

    final DealDetailsBottomBarView this$0;

    public void onClick(View view)
    {
        if (DealDetailsBottomBarView.access$000(DealDetailsBottomBarView.this) != null)
        {
            DealDetailsBottomBarView.access$100(DealDetailsBottomBarView.this).isVariantEnabled("AAforDealDetailsContinueClick1510", "On");
            DealDetailsBottomBarView.access$000(DealDetailsBottomBarView.this).onBuyButtonClick(view);
        }
    }

    ()
    {
        this$0 = DealDetailsBottomBarView.this;
        super();
    }
}
