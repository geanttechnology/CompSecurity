// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.http.Http;
import com.groupon.models.cancel.CancelResponse;
import com.groupon.models.cancel.Deal;
import com.groupon.models.cancel.Option;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.activity:
//            CancelOrder

private class this._cls0 extends Http
{

    final CancelOrder this$0;

    public void onException(Exception exception)
    {
        Ln.e("GET deal details for Cancel Order failed", new Object[] {
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

    public void onSuccess(CancelResponse cancelresponse)
    {
        cancelresponse = cancelresponse.deal.options.iterator();
        do
        {
            if (!cancelresponse.hasNext())
            {
                break;
            }
            Option option = (Option)cancelresponse.next();
            if (!option.id.equals(optionId))
            {
                continue;
            }
            CancelOrder.access$902(CancelOrder.this, option.minimumPurchaseQuantity);
            CancelOrder.access$1002(CancelOrder.this, option.title);
            (new ttp(CancelOrder.this)).method("GET").execute();
            break;
        } while (true);
    }

    public volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((CancelResponse)obj);
    }

    public ttp(String s, Object aobj[])
    {
        this$0 = CancelOrder.this;
        super(CancelOrder.this, com/groupon/models/cancel/CancelResponse, String.format("https:/deals/%s", new Object[] {
            s
        }), aobj);
    }
}
