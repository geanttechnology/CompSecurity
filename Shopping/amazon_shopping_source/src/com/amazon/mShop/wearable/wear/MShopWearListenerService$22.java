// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wearable.wear;

import android.os.AsyncTask;
import com.google.android.gms.wearable.MessageEvent;

// Referenced classes of package com.amazon.mShop.wearable.wear:
//            MShopWearListenerService

class val.messageEvent extends AsyncTask
{

    final MShopWearListenerService this$0;
    final sageHandler val$handler;
    final MessageEvent val$messageEvent;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        val$handler.onHandleMessage(MShopWearListenerService.this, val$messageEvent);
        return null;
    }

    sageHandler()
    {
        this$0 = final_mshopwearlistenerservice;
        val$handler = sagehandler;
        val$messageEvent = MessageEvent.this;
        super();
    }
}
