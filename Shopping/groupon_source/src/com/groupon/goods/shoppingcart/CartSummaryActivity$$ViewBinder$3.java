// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;

// Referenced classes of package com.groupon.goods.shoppingcart:
//            CartSummaryActivity

class val.target extends DebouncingOnClickListener
{

    final pingClick this$0;
    final CartSummaryActivity val$target;

    public void doClick(View view)
    {
        val$target.onContinueShoppingClick();
    }

    ()
    {
        this$0 = final_;
        val$target = CartSummaryActivity.this;
        super();
    }
}
