// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

final class bto
    implements ServiceConnection
{

    private boolean a;
    private final LinkedBlockingQueue b;

    private bto()
    {
        a = false;
        b = new LinkedBlockingQueue(1);
    }

    bto(btn btn)
    {
        this();
    }

    public IBinder a()
    {
        if (a)
        {
            bso.h().e("Fabric", "getBinder already called");
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

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
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

    public void onServiceDisconnected(ComponentName componentname)
    {
        b.clear();
    }
}
