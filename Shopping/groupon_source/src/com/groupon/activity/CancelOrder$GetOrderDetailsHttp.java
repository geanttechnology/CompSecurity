// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.http.Http;
import com.groupon.models.GenericAmount;
import com.groupon.models.order.detail.DealOption;
import com.groupon.models.order.detail.Order;
import com.groupon.models.order.detail.OrderContainer;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.activity:
//            CancelOrder

private class this._cls0 extends Http
{

    final CancelOrder this$0;

    public void onException(Exception exception)
    {
        Ln.e("GET order details for Cancel Order failed", new Object[] {
            exception.getMessage()
        });
        CancelOrder.access$600(CancelOrder.this);
        CancelOrder.access$1100(CancelOrder.this, "cancel_order_retry_load_details_dialog");
    }

    protected void onPreExecute()
        throws Exception
    {
        super.onPreExecute();
        CancelOrder.access$800(CancelOrder.this);
    }

    public void onSuccess(OrderContainer ordercontainer)
    {
        ordercontainer = ordercontainer.order;
        GenericAmount genericamount = ((Order) (ordercontainer)).dealOption.price;
        CancelOrder.access$1702(CancelOrder.this, ((Order) (ordercontainer)).quantity);
        CancelOrder.access$1802(CancelOrder.this, genericamount.getFormattedAmount());
        ordercontainer = CancelOrder.this;
        boolean flag;
        if (CancelOrder.access$1700(CancelOrder.this) <= CancelOrder.access$900(CancelOrder.this))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        CancelOrder.access$1902(ordercontainer, flag);
        if (CancelOrder.access$1700(CancelOrder.this) > 1 && CancelOrder.access$1900(CancelOrder.this))
        {
            CancelOrder.access$600(CancelOrder.this);
            CancelOrder.access$2000(CancelOrder.this);
            return;
        } else
        {
            cancelOrder();
            return;
        }
    }

    public volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((OrderContainer)obj);
    }

    public ()
    {
        this$0 = CancelOrder.this;
        super(CancelOrder.this, com/groupon/models/order/detail/OrderContainer, String.format("https:/users/%s/orders/%s", new Object[] {
            CancelOrder.access$1200(CancelOrder.this), orderId
        }));
    }
}
