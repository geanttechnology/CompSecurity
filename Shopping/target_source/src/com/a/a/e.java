// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import android.os.Handler;
import java.util.concurrent.Executor;

// Referenced classes of package com.a.a:
//            p, m, o, t

public class e
    implements p
{
    private class a
        implements Runnable
    {

        final e a;
        private final m b;
        private final o c;
        private final Runnable d;

        public void run()
        {
            if (b.isCanceled())
            {
                b.finish("canceled-at-delivery");
            } else
            {
                if (c.a())
                {
                    b.deliverResponse(c.a);
                } else
                {
                    b.deliverError(c.c);
                }
                if (c.d)
                {
                    b.addMarker("intermediate-response");
                } else
                {
                    b.finish("done");
                }
                if (d != null)
                {
                    d.run();
                    return;
                }
            }
        }

        public a(m m1, o o1, Runnable runnable)
        {
            a = e.this;
            super();
            b = m1;
            c = o1;
            d = runnable;
        }
    }


    private final Executor a;

    public e(Handler handler)
    {
        a = new Executor(handler) {

            final Handler a;
            final e b;

            public void execute(Runnable runnable)
            {
                a.post(runnable);
            }

            
            {
                b = e.this;
                a = handler;
                super();
            }
        };
    }

    public void a(m m1, o o1)
    {
        a(m1, o1, null);
    }

    public void a(m m1, o o1, Runnable runnable)
    {
        m1.markDelivered();
        m1.addMarker("post-response");
        a.execute(new a(m1, o1, runnable));
    }

    public void a(m m1, t t)
    {
        m1.addMarker("post-error");
        t = o.a(t);
        a.execute(new a(m1, t, null));
    }
}
