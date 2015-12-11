// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.widget.LinearLayout;

// Referenced classes of package com.target.ui.view.checkout:
//            GiftCardContainerView, GiftCardAppliedView

class val.appliedView
    implements Runnable
{

    final GiftCardContainerView this$0;
    final GiftCardAppliedView val$appliedView;

    public void run()
    {
        if (GiftCardContainerView.a(GiftCardContainerView.this) != null)
        {
            GiftCardContainerView.a(GiftCardContainerView.this).giftCardContentView.addView(val$appliedView, 1);
        }
    }

    ews()
    {
        this$0 = final_giftcardcontainerview;
        val$appliedView = GiftCardAppliedView.this;
        super();
    }
}
