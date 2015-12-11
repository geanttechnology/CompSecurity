// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart;

import com.groupon.models.dealbreakdown.DealMultiItemBreakdownContainer;
import com.groupon.service.DealBreakdownServiceMultiDealListener;

// Referenced classes of package com.groupon.goods.shoppingcart:
//            NewPurchaseCart

private class <init>
    implements DealBreakdownServiceMultiDealListener
{

    final NewPurchaseCart this$0;

    public void onComplete()
    {
    }

    public boolean onException(Exception exception)
    {
        return NewPurchaseCart.access$1100(NewPurchaseCart.this, exception).booleanValue();
    }

    public void onSuccess(DealMultiItemBreakdownContainer dealmultiitembreakdowncontainer)
    {
        NewPurchaseCart.access$1000(NewPurchaseCart.this, dealmultiitembreakdowncontainer);
    }

    private ()
    {
        this$0 = NewPurchaseCart.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
