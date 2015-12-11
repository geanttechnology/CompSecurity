// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.now;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class BlockingServiceConnection
    implements ServiceConnection
{

    private final BlockingQueue mBlockingQueue = new LinkedBlockingQueue();
    boolean mUsed;

    BlockingServiceConnection()
    {
        mUsed = false;
    }

    public IBinder getService()
    {
        if (mUsed)
        {
            throw new IllegalStateException();
        } else
        {
            mUsed = true;
            return (IBinder)mBlockingQueue.take();
        }
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        mBlockingQueue.add(ibinder);
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
    }
}
