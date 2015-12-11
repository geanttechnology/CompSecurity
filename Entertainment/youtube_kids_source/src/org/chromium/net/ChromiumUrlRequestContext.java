// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;

// Referenced classes of package org.chromium.net:
//            Version

public class ChromiumUrlRequestContext
{

    long a;

    protected ChromiumUrlRequestContext(Context context, String s, String s1)
    {
        byte byte0 = 3;
        super();
        if (Log.isLoggable("ChromiumNetwork", 2))
        {
            byte0 = -2;
        } else
        if (Log.isLoggable("ChromiumNetwork", 3))
        {
            byte0 = -1;
        }
        a = nativeCreateRequestContextAdapter(context, s, byte0, s1);
        if (a == 0L)
        {
            throw new NullPointerException("Context Adapter creation failed");
        } else
        {
            context = new _cls1(context);
            (new Handler(Looper.getMainLooper())).post(context);
            return;
        }
    }

    static long a(ChromiumUrlRequestContext chromiumurlrequestcontext)
    {
        return chromiumurlrequestcontext.a;
    }

    public static String a()
    {
        return Version.a();
    }

    static void a(ChromiumUrlRequestContext chromiumurlrequestcontext, long l)
    {
        chromiumurlrequestcontext.nativeInitRequestContextOnMainThread(l);
    }

    private void initNetworkThread()
    {
        Thread.currentThread().setName("ChromiumNet");
        Process.setThreadPriority(10);
    }

    private native long nativeCreateRequestContextAdapter(Context context, String s, int i, String s1);

    private native String nativeGetStatisticsJSON(String s);

    private native void nativeInitRequestContextOnMainThread(long l);

    private native void nativeInitializeStatistics();

    private native void nativeReleaseRequestContextAdapter(long l);

    private native void nativeStartNetLogToFile(long l, String s);

    private native void nativeStopNetLog(long l);

    protected void finalize()
    {
        nativeReleaseRequestContextAdapter(a);
        super.finalize();
    }

    private class _cls1
        implements Runnable
    {

        private Context a;
        private ChromiumUrlRequestContext b;

        public void run()
        {
            NetworkChangeNotifier.init(a);
            NetworkChangeNotifier.a();
            ChromiumUrlRequestContext.a(b, ChromiumUrlRequestContext.a(b));
        }

        _cls1(Context context)
        {
            b = ChromiumUrlRequestContext.this;
            a = context;
            super();
        }
    }

}
