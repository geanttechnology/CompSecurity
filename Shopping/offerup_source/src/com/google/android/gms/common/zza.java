// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class zza
    implements ServiceConnection
{

    boolean zzZW;
    private final BlockingQueue zzZX = new LinkedBlockingQueue();

    public zza()
    {
        zzZW = false;
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        zzZX.add(ibinder);
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
    }

    public IBinder zzno()
    {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            throw new IllegalStateException("BlockingServiceConnection.getService() called on main thread");
        }
        if (zzZW)
        {
            throw new IllegalStateException();
        } else
        {
            zzZW = true;
            return (IBinder)zzZX.take();
        }
    }
}
