// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.os.Handler;
import java.util.concurrent.Executor;

// Referenced classes of package com.google.android.gms.d:
//            iu, hx, is, kq

public final class cy
    implements iu
{
    private final class a
        implements Runnable
    {

        final cy a;
        private final hx b;
        private final is c;
        private final Runnable d;

        public final void run()
        {
            if (!b.j) goto _L2; else goto _L1
_L1:
            b.b("canceled-at-delivery");
_L5:
            return;
_L2:
            boolean flag;
            if (c.c == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag) goto _L4; else goto _L3
_L3:
            b.a(c.a);
_L6:
            hx hx1;
            kq kq;
            if (c.d)
            {
                b.a("intermediate-response");
            } else
            {
                b.b("done");
            }
            if (d != null)
            {
                d.run();
                return;
            }
            if (true) goto _L5; else goto _L4
_L4:
            hx1 = b;
            kq = c.c;
            if (hx1.f != null)
            {
                hx1.f.a(kq);
            }
              goto _L6
        }

        public a(hx hx1, is is1, Runnable runnable)
        {
            a = cy.this;
            super();
            b = hx1;
            c = is1;
            d = runnable;
        }
    }


    private final Executor a;

    public cy(Handler handler)
    {
        a = new Executor(handler) {

            final Handler a;
            final cy b;

            public final void execute(Runnable runnable)
            {
                a.post(runnable);
            }

            
            {
                b = cy.this;
                a = handler;
                super();
            }
        };
    }

    public final void a(hx hx1, is is1)
    {
        a(hx1, is1, null);
    }

    public final void a(hx hx1, is is1, Runnable runnable)
    {
        hx1.k = true;
        hx1.a("post-response");
        a.execute(new a(hx1, is1, runnable));
    }

    public final void a(hx hx1, kq kq)
    {
        hx1.a("post-error");
        kq = new is(kq);
        a.execute(new a(hx1, kq, null));
    }
}
