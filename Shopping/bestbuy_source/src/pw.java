// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class pw
    implements ServiceConnection
{

    boolean a;
    private final BlockingQueue b = new LinkedBlockingQueue();

    public pw()
    {
        a = false;
    }

    public IBinder a()
    {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            throw new IllegalStateException("BlockingServiceConnection.getService() called on main thread");
        }
        if (a)
        {
            throw new IllegalStateException();
        } else
        {
            a = true;
            return (IBinder)b.take();
        }
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        b.add(ibinder);
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
    }
}
