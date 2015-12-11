// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk;

class BlockingBindingConnection
{
    private static class SdkServiceConnection
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
                mServiceHolder = com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk.Stub.asInterface(ibinder);
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

        private SdkServiceConnection()
        {
            mConnectionNotifier = new Object();
            mServiceHolder = null;
        }

    }


    private final Context mContext;
    private final SdkServiceConnection mServiceConnection;
    private final Intent mServiceIntent;

    BlockingBindingConnection(Context context, Intent intent)
    {
        this(context, intent, new SdkServiceConnection());
    }

    private BlockingBindingConnection(Context context, Intent intent, SdkServiceConnection sdkserviceconnection)
    {
        mContext = context;
        mServiceIntent = intent;
        mServiceConnection = sdkserviceconnection;
    }

    void bind()
    {
        mContext.startService(mServiceIntent);
        if (!mContext.bindService(mServiceIntent, mServiceConnection, 5))
        {
            throw new IllegalStateException("Could not bind to the service");
        } else
        {
            return;
        }
    }

    boolean canBind()
    {
        boolean flag = false;
        if (mContext.getPackageManager().resolveService(mServiceIntent, 0) != null)
        {
            flag = true;
        }
        return flag;
    }

    AivPlaybackSdk getService()
        throws InterruptedException
    {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            throw new IllegalStateException("Calling this from the main thread will cause a deadlock");
        } else
        {
            return mServiceConnection.getService();
        }
    }

    boolean isConnected()
    {
        return mServiceConnection.isConnected();
    }

    void unbind()
    {
        mContext.unbindService(mServiceConnection);
        mContext.stopService(mServiceIntent);
    }
}
