// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import android.content.Context;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

// Referenced classes of package com.google.android.gms.e:
//            dc

final class bp
    implements cz.b
{
    static interface a
    {
    }

    static interface b
    {

        public abstract ScheduledExecutorService a();
    }


    private final String a;
    private final Context b;
    private final ScheduledExecutorService c;
    private final a d;
    private ScheduledFuture e;
    private boolean f;
    private dc g;
    private String h;

    public bp(Context context, String s, dc dc)
    {
        this(context, s, dc, (byte)0);
    }

    private bp(Context context, String s, dc dc, byte byte0)
    {
        g = dc;
        b = context;
        a = s;
        c = (new b() {

            final bp a;

            public final ScheduledExecutorService a()
            {
                return Executors.newSingleThreadScheduledExecutor();
            }

            
            {
                a = bp.this;
                super();
            }
        }).a();
        d = new a() {

            final bp a;

            
            {
                a = bp.this;
                super();
            }
        };
    }

    private void a()
    {
        this;
        JVM INSTR monitorenter ;
        if (f)
        {
            throw new IllegalStateException("called method after closed");
        }
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    public final void a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        a();
        h = s;
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public final void b()
    {
        this;
        JVM INSTR monitorenter ;
        a();
        if (e != null)
        {
            e.cancel(false);
        }
        c.shutdown();
        f = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
