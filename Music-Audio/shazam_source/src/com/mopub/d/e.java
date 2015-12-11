// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.d;

import android.os.Handler;
import java.util.concurrent.Executor;

// Referenced classes of package com.mopub.d:
//            o, l, n, s

public final class e
    implements o
{
    private final class a
        implements Runnable
    {

        final e a;
        private final l b;
        private final n c;
        private final Runnable d;

        public final void run()
        {
            if (!b.h) goto _L2; else goto _L1
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
            l l1;
            s s;
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
            l1 = b;
            s = c.c;
            if (l1.d != null)
            {
                l1.d.a(s);
            }
              goto _L6
        }

        public a(l l1, n n1, Runnable runnable)
        {
            a = e.this;
            super();
            b = l1;
            c = n1;
            d = runnable;
        }
    }


    private final Executor a;

    public e(Handler handler)
    {
        a = new Executor(handler) {

            final Handler a;
            final e b;

            public final void execute(Runnable runnable)
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

    public final void a(l l1, n n1)
    {
        a(l1, n1, null);
    }

    public final void a(l l1, n n1, Runnable runnable)
    {
        l1.i = true;
        l1.a("post-response");
        a.execute(new a(l1, n1, runnable));
    }

    public final void a(l l1, s s)
    {
        l1.a("post-error");
        s = n.a(s);
        a.execute(new a(l1, s, null));
    }
}
