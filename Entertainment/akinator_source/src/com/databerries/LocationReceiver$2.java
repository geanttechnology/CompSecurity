// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.databerries;

import android.content.Context;
import android.util.Log;
import com.loopj.android.http.ResponseHandlerInterface;

// Referenced classes of package com.databerries:
//            LocationReceiver

class lerInterface
    implements Runnable
{

    final LocationReceiver this$0;
    final Context val$context;
    final ResponseHandlerInterface val$responseHandler;

    public void run()
    {
        try
        {
            LocationReceiver.access$000(LocationReceiver.this, val$context, val$responseHandler);
            return;
        }
        catch (Exception exception)
        {
            Log.d("DataBerries", "catch exception in LocationReceiver's onReceive");
            exception.printStackTrace();
            return;
        }
    }

    lerInterface()
    {
        this$0 = final_locationreceiver;
        val$context = context1;
        val$responseHandler = ResponseHandlerInterface.this;
        super();
    }
}
