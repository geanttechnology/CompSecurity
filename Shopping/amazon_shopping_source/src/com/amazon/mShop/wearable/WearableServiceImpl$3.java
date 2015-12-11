// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wearable;

import android.util.Log;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.AddListItemsResponse;
import com.amazon.rio.j2me.client.services.mShop.AddListItemsResponseListener;

// Referenced classes of package com.amazon.mShop.wearable:
//            WearableServiceImpl, ResultListener

class val.listener
    implements AddListItemsResponseListener
{

    final WearableServiceImpl this$0;
    final ResultListener val$listener;

    public void cancelled(ServiceCall servicecall)
    {
    }

    public void completed(AddListItemsResponse addlistitemsresponse, ServiceCall servicecall)
    {
        val$listener.onSuccess();
    }

    public void error(Exception exception, ServiceCall servicecall)
    {
        Log.e(WearableServiceImpl.access$000(), "Add to wishlist encountered Exception", exception);
        val$listener.onError(WearableServiceImpl.access$100(WearableServiceImpl.this, "add to wishlist", exception), exception);
    }

    tItemsResponse()
    {
        this$0 = final_wearableserviceimpl;
        val$listener = ResultListener.this;
        super();
    }
}
