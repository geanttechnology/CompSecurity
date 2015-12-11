// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.databerries;

import android.util.Log;
import com.loopj.android.http.AsyncHttpResponseHandler;

// Referenced classes of package com.databerries:
//            DataBerries, DeviceInfo, RestClient

class tpResponseHandler
    implements Runnable
{

    final DataBerries this$0;
    final AsyncHttpResponseHandler val$responseHandler;

    public void run()
    {
        try
        {
            com.google.android.gms.ads.identifier.lient.Info _tmp = DataBerries.access$002(DataBerries.access$200(DataBerries.access$100(DataBerries.this)));
            if (DataBerries.access$000() != null && !DataBerries.access$000().isLimitAdTrackingEnabled())
            {
                String s = DeviceInfo.getKey();
                RestClient.postDevice(DataBerries.access$000().getId(), s, val$responseHandler);
            }
            return;
        }
        catch (Exception exception)
        {
            Log.d("DataBerriesRestClient", "catch Exception in Databerries registerDevice");
            exception.printStackTrace();
            return;
        }
    }

    tpResponseHandler()
    {
        this$0 = final_databerries;
        val$responseHandler = AsyncHttpResponseHandler.this;
        super();
    }
}
