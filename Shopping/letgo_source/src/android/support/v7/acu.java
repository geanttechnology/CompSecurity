// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

// Referenced classes of package android.support.v7:
//            aeh

class acu
    implements aee.b
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
    private aeh g;
    private String h;

    public acu(Context context, String s, aeh aeh)
    {
        this(context, s, aeh, null, null);
    }

    acu(Context context, String s, aeh aeh, b b1, a a1)
    {
        g = aeh;
        b = context;
        a = s;
        context = b1;
        if (b1 == null)
        {
            context = new b() {

                final acu a;

                public ScheduledExecutorService a()
                {
                    return Executors.newSingleThreadScheduledExecutor();
                }

            
            {
                a = acu.this;
                super();
            }
            };
        }
        c = context.a();
        if (a1 == null)
        {
            d = new a() {

                final acu a;

            
            {
                a = acu.this;
                super();
            }
            };
            return;
        } else
        {
            d = a1;
            return;
        }
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

    public void a(String s)
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

    public void b()
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
