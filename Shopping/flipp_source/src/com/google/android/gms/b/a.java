// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Messenger;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.b:
//            b

public final class a
{

    static a a;
    public Context b;
    public final BlockingQueue c = new LinkedBlockingQueue();
    public Messenger d;
    private PendingIntent e;
    private Handler f;

    public a()
    {
        f = new b(this, Looper.getMainLooper());
        d = new Messenger(f);
    }

    public static a a(Context context)
    {
        com/google/android/gms/b/a;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            a a1 = new a();
            a = a1;
            a1.b = context;
        }
        context = a;
        com/google/android/gms/b/a;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private transient void b(String as[])
    {
        if (as == null || as.length == 0)
        {
            throw new IllegalArgumentException("No senderIds");
        }
        Object obj = new StringBuilder(as[0]);
        for (int i = 1; i < as.length; i++)
        {
            ((StringBuilder) (obj)).append(',').append(as[i]);
        }

        as = ((StringBuilder) (obj)).toString();
        obj = new Intent("com.google.android.c2dm.intent.REGISTER");
        ((Intent) (obj)).setPackage("com.google.android.gms");
        ((Intent) (obj)).putExtra("google.messenger", d);
        a(((Intent) (obj)));
        ((Intent) (obj)).putExtra("sender", as);
        b.startService(((Intent) (obj)));
    }

    public final transient String a(String as[])
    {
        if (Looper.getMainLooper() == Looper.myLooper())
        {
            throw new IOException("MAIN_THREAD");
        }
        c.clear();
        b(as);
        try
        {
            as = (Intent)c.poll(5000L, TimeUnit.MILLISECONDS);
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            throw new IOException(as.getMessage());
        }
        if (as != null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        throw new IOException("SERVICE_NOT_AVAILABLE");
        String s = as.getStringExtra("registration_id");
        if (s != null)
        {
            return s;
        }
        as.getStringExtra("error");
        as = as.getStringExtra("error");
        if (as == null)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        throw new IOException(as);
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    public final void a(Intent intent)
    {
        this;
        JVM INSTR monitorenter ;
        if (e == null)
        {
            e = PendingIntent.getBroadcast(b, 0, new Intent(), 0);
        }
        intent.putExtra("app", e);
        this;
        JVM INSTR monitorexit ;
        return;
        intent;
        throw intent;
    }
}
