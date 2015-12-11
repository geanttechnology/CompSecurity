// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.b;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import c.a.a.a.e;
import c.a.a.a.q;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

final class g
    implements ServiceConnection
{

    private boolean a;
    private final LinkedBlockingQueue b;

    private g()
    {
        a = false;
        b = new LinkedBlockingQueue(1);
    }

    g(byte byte0)
    {
        this();
    }

    public final IBinder a()
    {
        if (a)
        {
            e.d().e("Fabric", "getBinder already called");
        }
        a = true;
        IBinder ibinder;
        try
        {
            ibinder = (IBinder)b.poll(200L, TimeUnit.MILLISECONDS);
        }
        catch (InterruptedException interruptedexception)
        {
            return null;
        }
        return ibinder;
    }

    public final void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        try
        {
            b.put(ibinder);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ComponentName componentname)
        {
            return;
        }
    }

    public final void onServiceDisconnected(ComponentName componentname)
    {
        b.clear();
    }
}
