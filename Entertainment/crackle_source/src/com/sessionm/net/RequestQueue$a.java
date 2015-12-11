// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.net;

import android.util.Log;
import com.sessionm.core.f;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.sessionm.net:
//            RequestQueue

class fP extends TimerTask
{

    final RequestQueue fP;

    public void run()
    {
        if (Log.isLoggable("SessionM.RequestQueue", 3))
        {
            Log.d("SessionM.RequestQueue", "Executing scheduled send task.");
        }
        RequestQueue.d(fP).execute(new Runnable() {

            final RequestQueue.a gd;

            public void run()
            {
                synchronized (f.E())
                {
                    RequestQueue.a(gd.fP, null, null, true);
                }
                return;
                exception;
                f1;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                gd = RequestQueue.a.this;
                super();
            }
        });
    }

    _cls1.gd(RequestQueue requestqueue)
    {
        fP = requestqueue;
        super();
    }
}
