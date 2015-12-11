// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.http.Http;
import com.groupon.models.OrderDetails;
import com.groupon.models.cancel.CancelOrderContainer;
import java.util.concurrent.Executor;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.activity:
//            CancelOrder

private class details extends Http
{

    private OrderDetails details;
    final CancelOrder this$0;

    public void onException(Exception exception)
    {
        Ln.e("Cancel Order request failed", new Object[] {
            exception.getMessage()
        });
        CancelOrder.access$600(CancelOrder.this);
        CancelOrder.access$1100(CancelOrder.this, "cancel_order_retry_cancel_order_dialog");
    }

    protected void onPreExecute()
        throws Exception
    {
        super.onPreExecute();
        CancelOrder.access$800(CancelOrder.this);
    }

    public void onSuccess(CancelOrderContainer cancelordercontainer)
    {
        CancelOrder.access$600(CancelOrder.this);
        executor.execute(new com.groupon.service.Runnable(CancelOrder.access$1300(CancelOrder.this), CancelOrder.access$1400(CancelOrder.this), CancelOrder.access$1500(CancelOrder.this)));
        CancelOrder.access$1600(CancelOrder.this, details.getTitle(), details.getPrice());
    }

    public volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((CancelOrderContainer)obj);
    }

    public unnable(OrderDetails orderdetails, Object aobj[])
    {
        this$0 = CancelOrder.this;
        super(CancelOrder.this, com/groupon/models/cancel/CancelOrderContainer, String.format("https:/users/%s/orders/%s", new Object[] {
            CancelOrder.access$1200(CancelOrder.this), orderdetails.getId()
        }), aobj);
        details = orderdetails;
    }
}
