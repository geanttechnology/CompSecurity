// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;


// Referenced classes of package com.target.ui.view.checkout:
//            PromoCodeContainerView, PromoCodeAppliedView

class val.appliedView
    implements Runnable
{

    final PromoCodeContainerView this$0;
    final PromoCodeAppliedView val$appliedView;

    public void run()
    {
        if (PromoCodeContainerView.a(PromoCodeContainerView.this) != null)
        {
            addView(val$appliedView, 1);
        }
    }

    ()
    {
        this$0 = final_promocodecontainerview;
        val$appliedView = PromoCodeAppliedView.this;
        super();
    }
}
