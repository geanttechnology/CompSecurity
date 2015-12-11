// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;

public class ov
{

    pw a;
    ahe b;
    boolean c;
    Object d;
    ox e;
    final long f;
    private final Context g;

    public ov(Context context)
    {
        this(context, 30000L);
    }

    public ov(Context context, long l)
    {
        d = new Object();
        ady.a(context);
        g = context;
        c = false;
        f = l;
    }

    static ahe a(Context context, pw pw1)
    {
        try
        {
            context = ahf.a(pw1.a());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IOException("Interrupted exception");
        }
        return context;
    }

    static pw a(Context context)
    {
        pw pw1;
        Intent intent;
        try
        {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new ps(9);
        }
        try
        {
            pu.b(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IOException(context);
        }
        pw1 = new pw();
        intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, pw1, 1))
        {
            return pw1;
        } else
        {
            throw new IOException("Connection failure");
        }
    }

    private void d()
    {
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        if (e == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        e.a();
        Exception exception;
        try
        {
            e.join();
        }
        catch (InterruptedException interruptedexception) { }
        if (f > 0L)
        {
            e = new ox(this, f);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a()
    {
        a(true);
    }

    protected void a(boolean flag)
    {
        ady.c("Calling this from your main thread can lead to deadlock");
        this;
        JVM INSTR monitorenter ;
        if (c)
        {
            c();
        }
        a = a(g);
        b = a(g, a);
        c = true;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        d();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public ow b()
    {
        ady.c("Calling this from your main thread can lead to deadlock");
        this;
        JVM INSTR monitorenter ;
        if (c)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        if (e == null || !e.b())
        {
            throw new IOException("AdvertisingIdClient is not connected.");
        }
        break MISSING_BLOCK_LABEL_58;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        JVM INSTR monitorexit ;
        a(false);
        if (!c)
        {
            throw new IOException("AdvertisingIdClient cannot reconnect.");
        }
        break MISSING_BLOCK_LABEL_94;
        Object obj1;
        obj1;
        throw new IOException("AdvertisingIdClient cannot reconnect.", ((Throwable) (obj1)));
        ady.a(a);
        ady.a(b);
        obj1 = new ow(b.a(), b.a(true));
        this;
        JVM INSTR monitorexit ;
        d();
        return ((ow) (obj1));
        obj1;
        Log.i("AdvertisingIdClient", "GMS remote exception ", ((Throwable) (obj1)));
        throw new IOException("Remote exception");
    }

    public void c()
    {
        ady.c("Calling this from your main thread can lead to deadlock");
        this;
        JVM INSTR monitorenter ;
        if (g != null && a != null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        if (c)
        {
            g.unbindService(a);
        }
_L1:
        c = false;
        b = null;
        a = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", ((Throwable) (obj)));
          goto _L1
    }

    protected void finalize()
    {
        c();
        super.finalize();
    }
}
