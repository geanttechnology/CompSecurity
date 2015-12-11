// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class avz
    implements ServiceConnection
{

    private boolean a;
    private final BlockingQueue b = new LinkedBlockingQueue();

    public avz()
    {
        a = false;
    }

    public final IBinder a()
    {
        if (a)
        {
            throw new IllegalStateException();
        } else
        {
            a = true;
            return (IBinder)b.take();
        }
    }

    public final void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        b.add(ibinder);
    }

    public final void onServiceDisconnected(ComponentName componentname)
    {
    }
}
