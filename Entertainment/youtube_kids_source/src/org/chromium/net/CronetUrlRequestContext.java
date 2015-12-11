// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net;

import android.content.Context;
import android.os.Process;
import java.util.concurrent.Executor;

// Referenced classes of package org.chromium.net:
//            UrlRequestContext, CronetUrlRequest, UrlRequestListener, UrlRequest

public class CronetUrlRequestContext extends UrlRequestContext
{

    private void initNetworkThread()
    {
        Thread.currentThread();
        Thread.currentThread().setName("ChromiumNet");
        Process.setThreadPriority(10);
    }

    private native long nativeCreateRequestContextAdapter(Context context, String s);

    private native void nativeDestroyRequestContextAdapter(long l);

    private native int nativeSetMinLogLevel(int i);

    private native void nativeStartNetLogToFile(long l, String s);

    private native void nativeStopNetLog(long l);

    public final UrlRequest a(String s, UrlRequestListener urlrequestlistener, Executor executor)
    {
        if (0L == 0L)
        {
            throw new IllegalStateException("Cannot create requests on shutdown context.");
        } else
        {
            return new CronetUrlRequest(this, s, 3, urlrequestlistener, executor);
        }
    }
}
