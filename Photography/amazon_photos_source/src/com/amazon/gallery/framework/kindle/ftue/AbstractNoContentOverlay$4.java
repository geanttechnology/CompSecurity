// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ftue;

import android.os.AsyncTask;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;

// Referenced classes of package com.amazon.gallery.framework.kindle.ftue:
//            AbstractNoContentOverlay

class y
    implements Runnable
{

    final AbstractNoContentOverlay this$0;
    final NetworkConnectivity val$networkConnectivity;

    public void run()
    {
label0:
        {
            synchronized (AbstractNoContentOverlay.this)
            {
                if (AbstractNoContentOverlay.access$200(AbstractNoContentOverlay.this) == null)
                {
                    break label0;
                }
            }
            return;
        }
        if (endpoint == null && val$networkConnectivity.getConnectionStatus() != com.amazon.gallery.framework.network.connectivity.ionStatus.NONE)
        {
            AbstractNoContentOverlay.access$202(AbstractNoContentOverlay.this, new adingEndpointAsyncRunner(AbstractNoContentOverlay.this, null));
            AbstractNoContentOverlay.access$200(AbstractNoContentOverlay.this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
        abstractnocontentoverlay;
        JVM INSTR monitorexit ;
        return;
        exception;
        abstractnocontentoverlay;
        JVM INSTR monitorexit ;
        throw exception;
    }

    y()
    {
        this$0 = final_abstractnocontentoverlay;
        val$networkConnectivity = NetworkConnectivity.this;
        super();
    }
}
