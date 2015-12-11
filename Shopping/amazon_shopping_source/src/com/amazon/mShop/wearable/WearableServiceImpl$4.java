// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wearable;

import android.util.Log;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.BuyAsinResponseListener;
import com.amazon.rio.j2me.client.services.mShop.PurchaseOrderResponse;
import com.amazon.rio.j2me.client.services.mShop.PurchaseStatus;
import java.util.List;

// Referenced classes of package com.amazon.mShop.wearable:
//            WearableServiceImpl, ResultListener

class val.listener
    implements BuyAsinResponseListener
{

    final WearableServiceImpl this$0;
    final ResultListener val$listener;

    public void cancelled(ServiceCall servicecall)
    {
        val$listener.onError("Cancelled while trying to buy", new Throwable("Call cancelled"));
    }

    public void completed(PurchaseOrderResponse purchaseorderresponse, ServiceCall servicecall)
    {
        if (purchaseorderresponse.getConfirmedOrderId() != null && purchaseorderresponse.getConfirmedOrderId().size() > 0)
        {
            val$listener.onSuccess();
            return;
        }
        if (purchaseorderresponse.getPurchaseStatus() != null)
        {
            val$listener.onError(purchaseorderresponse.getPurchaseStatus().getNextStep(), new Throwable("BuyNow order not completed"));
            return;
        } else
        {
            val$listener.onError("Unknown error", new Throwable("BuyNow order not completed"));
            return;
        }
    }

    public void error(Exception exception, ServiceCall servicecall)
    {
        Log.e(WearableServiceImpl.access$000(), "Error while trying to buy ", exception);
        val$listener.onError(WearableServiceImpl.access$100(WearableServiceImpl.this, "buyNow", exception), exception);
    }

    seOrderResponse()
    {
        this$0 = final_wearableserviceimpl;
        val$listener = ResultListener.this;
        super();
    }
}
