// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk;

// Referenced classes of package com.amazon.avod.sdk.internal:
//            BlockingBindingConnection

private static class <init>
    implements ServiceConnection
{

    private final Object mConnectionNotifier;
    private volatile AivPlaybackSdk mServiceHolder;

    AivPlaybackSdk getService()
        throws InterruptedException
    {
        Object obj = mConnectionNotifier;
        obj;
        JVM INSTR monitorenter ;
        while (mServiceHolder == null) 
        {
            mConnectionNotifier.wait();
        }
        break MISSING_BLOCK_LABEL_29;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        AivPlaybackSdk aivplaybacksdk = mServiceHolder;
        obj;
        JVM INSTR monitorexit ;
        return aivplaybacksdk;
    }

    boolean isConnected()
    {
        return mServiceHolder != null;
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        Log.i("AmazonVideo", "SDK connected to AIV");
        synchronized (mConnectionNotifier)
        {
            mServiceHolder = com.amazon.avod.sdk.internal.aidl.iceHolder(ibinder);
            mConnectionNotifier.notify();
        }
        return;
        ibinder;
        componentname;
        JVM INSTR monitorexit ;
        throw ibinder;
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        Log.w("AmazonVideo", "SDK disconnected from AIV");
        synchronized (mConnectionNotifier)
        {
            mServiceHolder = null;
        }
        return;
        exception;
        componentname;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private Q()
    {
        mConnectionNotifier = new Object();
        mServiceHolder = null;
    }

    mServiceHolder(mServiceHolder mserviceholder)
    {
        this();
    }
}
