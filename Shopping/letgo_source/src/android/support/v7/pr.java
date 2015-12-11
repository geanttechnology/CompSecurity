// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Handler;
import java.util.concurrent.Executor;

// Referenced classes of package android.support.v7:
//            vy, ve, vw, xs

public class pr
    implements vy
{
    private class a
        implements Runnable
    {

        final pr a;
        private final ve b;
        private final vw c;
        private final Runnable d;

        public void run()
        {
            if (b.g())
            {
                b.c("canceled-at-delivery");
            } else
            {
                if (c.a())
                {
                    b.a(c.a);
                } else
                {
                    b.b(c.c);
                }
                if (c.d)
                {
                    b.b("intermediate-response");
                } else
                {
                    b.c("done");
                }
                if (d != null)
                {
                    d.run();
                    return;
                }
            }
        }

        public a(ve ve1, vw vw1, Runnable runnable)
        {
            a = pr.this;
            super();
            b = ve1;
            c = vw1;
            d = runnable;
        }
    }


    private final Executor a;

    public pr(Handler handler)
    {
        a = new Executor(handler) {

            final Handler a;
            final pr b;

            public void execute(Runnable runnable)
            {
                a.post(runnable);
            }

            
            {
                b = pr.this;
                a = handler;
                super();
            }
        };
    }

    public void a(ve ve1, vw vw1)
    {
        a(ve1, vw1, null);
    }

    public void a(ve ve1, vw vw1, Runnable runnable)
    {
        ve1.t();
        ve1.b("post-response");
        a.execute(new a(ve1, vw1, runnable));
    }

    public void a(ve ve1, xs xs)
    {
        ve1.b("post-error");
        xs = vw.a(xs);
        a.execute(new a(ve1, xs, null));
    }
}
