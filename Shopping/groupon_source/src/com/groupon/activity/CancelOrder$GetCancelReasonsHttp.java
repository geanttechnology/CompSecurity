// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.http.Http;
import com.groupon.models.cancel.ResignationResponse;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.activity:
//            CancelOrder

private class this._cls0 extends Http
{

    final CancelOrder this$0;

    public void onException(Exception exception)
    {
        Ln.e("GET request for Cancel Order Reasons failed", new Object[] {
            exception.getMessage()
        });
        CancelOrder.access$600(CancelOrder.this);
        CancelOrder.access$700(CancelOrder.this);
    }

    public void onSuccess(ResignationResponse resignationresponse)
    {
        CancelOrder.access$502(CancelOrder.this, resignationresponse);
        populateReasonsList(resignationresponse);
    }

    public volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((ResignationResponse)obj);
    }

    public ()
    {
        this$0 = CancelOrder.this;
        super(CancelOrder.this, com/groupon/models/cancel/ResignationResponse, "https:/resignation_reasons");
    }
}
