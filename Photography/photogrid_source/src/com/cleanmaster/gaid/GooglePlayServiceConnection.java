// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cleanmaster.gaid;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class GooglePlayServiceConnection
    implements ServiceConnection
{

    boolean CQ;
    private final BlockingQueue CR = new LinkedBlockingQueue();

    public GooglePlayServiceConnection()
    {
        CQ = false;
    }

    public IBinder getConnectedBinder()
    {
        if (CQ)
        {
            throw new IllegalStateException();
        } else
        {
            CQ = true;
            return (IBinder)CR.take();
        }
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        try
        {
            CR.put(ibinder);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ComponentName componentname)
        {
            return;
        }
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
    }
}
