// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.resolver;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.digimarc.dms.resolver:
//            ResolverThreadHandler, ResolverServiceHandler

class ResolverWorkerThread extends Thread
{

    private Context mContext;
    private ResolverServiceHandler mNotifyHandler;
    private final String mPassword;
    private final String mServer;
    private final CountDownLatch mSync = new CountDownLatch(1);
    private ResolverThreadHandler mThreadHandler;
    private final boolean mUseLabs;
    private final String mUserName;

    public ResolverWorkerThread(Context context, String s, String s1, ResolverServiceHandler resolverservicehandler, boolean flag, String s2)
    {
        mUserName = s;
        mPassword = s1;
        mNotifyHandler = resolverservicehandler;
        mContext = context;
        mUseLabs = flag;
        mServer = s2;
    }

    public Handler getHandler()
    {
        try
        {
            mSync.await();
        }
        catch (InterruptedException interruptedexception) { }
        return mThreadHandler;
    }

    public void run()
    {
        Looper.prepare();
        mThreadHandler = new ResolverThreadHandler(mContext, mUserName, mPassword, mNotifyHandler, mUseLabs, mServer);
        mSync.countDown();
        Looper.loop();
    }
}
