// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.os.Handler;
import com.groupon.util.Function1;

// Referenced classes of package com.groupon.service:
//            LocationService

class val.listener extends Thread
{

    final LocationService this$0;
    final Function1 val$listener;
    final int val$maxWaitMs;

    public void run()
    {
        LocationService.access$000(LocationService.this, val$maxWaitMs);
        if (val$listener != null)
        {
            LocationService.access$100(LocationService.this).post(new Runnable() {

                final LocationService._cls1 this$1;

                public void run()
                {
                    listener.execute(getLocation());
                }

            
            {
                this$1 = LocationService._cls1.this;
                super();
            }
            });
        }
    }

    _cls1.this._cls1()
    {
        this$0 = final_locationservice;
        val$maxWaitMs = i;
        val$listener = Function1.this;
        super();
    }
}
