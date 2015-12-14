// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmsp.client.sdk.oem;

import android.os.Looper;
import bm;
import bn;
import bq;
import d;
import java.util.Hashtable;

// Referenced classes of package com.nuance.nmsp.client.sdk.oem:
//            a

public class f
    implements bn
{
    public static final class a
    {

        public Thread a;
        public bn.b b;
        public Object c;

        public a(Object obj, bn.b b1)
        {
            c = obj;
            b = b1;
        }
    }

    public final class b
        implements Runnable
    {

        private bq a;
        private f b;

        public final void run()
        {
            b b1 = (b)f.a(b).remove(a);
            if (f.d().b())
            {
                f.d().b((new StringBuilder("TIMER run() _pendingTimerTasks.size():")).append(f.a(b).size()).append(", this:").append(this).append(", r:").append(b1).toString());
            }
            if (b1 != null)
            {
                b1.a.run();
            }
        }

        public b(bq bq1)
        {
            b = f.this;
            super();
            a = bq1;
            f.a(f.this).put(bq1, this);
        }
    }


    private static final bm a = d.a(com/nuance/nmsp/client/sdk/oem/f);
    private final com.nuance.nmsp.client.sdk.oem.a b = new com.nuance.nmsp.client.sdk.oem.a();
    private final Thread c = new Thread(new Runnable() {

        private f a;

        public final void run()
        {
            Looper.prepare();
            f.b(a).a();
            Looper.loop();
        }

            
            {
                a = f.this;
                super();
            }
    });
    private final Hashtable d = new Hashtable();

    public f()
    {
        c.start();
    }

    static Hashtable a(f f1)
    {
        return f1.d;
    }

    static com.nuance.nmsp.client.sdk.oem.a b(f f1)
    {
        return f1.b;
    }

    static bm d()
    {
        return a;
    }

    public final void a(bq bq, long l)
    {
        bq = new b(bq);
        if (a.b())
        {
            a.b((new StringBuilder("TIMER _handler.postDelayed(")).append(bq).append(")").toString());
        }
        b.postDelayed(bq, l);
    }

    public final void a(Object obj, bn.b b1, Object obj1)
    {
        obj = new a(obj, b1);
        obj.a = (Thread)obj1;
        b.post(new Runnable(((a) (obj))) {

            private a a;

            public final void run()
            {
                if (f.d().a())
                {
                    f.d().a("Executing Message");
                }
                a.b.a(a.c, a.a);
                if (f.d().a())
                {
                    f.d().a("Done Executing Message");
                }
            }

            
            {
                a = a1;
                super();
            }
        });
    }

    public final boolean a(bq bq)
    {
        bq = (b)d.remove(bq);
        if (a.b())
        {
            a.b((new StringBuilder("TIMER cancelTask() _pendingTimerTasks.size():")).append(d.size()).toString());
        }
        if (bq != null)
        {
            if (a.b())
            {
                a.b((new StringBuilder("TIMER _handler.removeCallbacks(")).append(bq).append(")").toString());
            }
            b.removeCallbacks(bq);
        }
        return bq != null;
    }

    public final Object[] a()
    {
        return (new Object[] {
            Thread.currentThread()
        });
    }

    public final Object b()
    {
        return Thread.currentThread();
    }

    public final void c()
    {
        b.post(new Runnable() {

            public final void run()
            {
                Looper.myLooper().quit();
            }

        });
    }

}
