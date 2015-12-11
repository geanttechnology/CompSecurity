// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart;

import com.groupon.models.order.OrderContainer;
import com.groupon.service.OrdersServiceMultiItemListener;

// Referenced classes of package com.groupon.goods.shoppingcart:
//            NewPurchaseCart

private class <init>
    implements OrdersServiceMultiItemListener
{

    final NewPurchaseCart this$0;

    public void onComplete()
    {
    }

    public boolean onException(Exception exception)
    {
        return NewPurchaseCart.access$1300(NewPurchaseCart.this, exception);
    }

    public void onSuccess(OrderContainer ordercontainer)
    {
        NewPurchaseCart.access$1200(NewPurchaseCart.this, ordercontainer);
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
