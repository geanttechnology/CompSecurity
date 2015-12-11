// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.os.Handler;
import com.groupon.util.Function1;

// Referenced classes of package com.groupon.service:
//            LocationService

class this._cls1
    implements Runnable
{

    final ocation this$1;

    public void run()
    {
        listener.execute(getLocation());
    }

    l.listener()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/groupon/service/LocationService$1

/* anonymous class */
    class LocationService._cls1 extends Thread
    {

        final LocationService this$0;
        final Function1 val$listener;
        final int val$maxWaitMs;

        public void run()
        {
            LocationService.access$000(LocationService.this, maxWaitMs);
            if (listener != null)
            {
                LocationService.access$100(LocationService.this).post(new LocationService._cls1._cls1());
            }
        }

            
            {
                this$0 = final_locationservice;
                maxWaitMs = i;
                listener = Function1.this;
                super();
            }
    }

}
