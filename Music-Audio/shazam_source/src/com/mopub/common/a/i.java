// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.a;

import android.os.Handler;
import android.os.Looper;
import com.mopub.c.m;
import com.mopub.c.n;
import com.mopub.c.o;
import com.mopub.common.c.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

// Referenced classes of package com.mopub.common.a:
//            e, f, g, a

public final class i
    implements e
{
    final class a
        implements Runnable
    {

        final i a;

        public final void run()
        {
            a.a();
            a.b();
        }

        a()
        {
            a = i.this;
            super();
        }
    }


    final g a;
    private final f b;
    private final Queue c;
    private final o d;
    private final Handler e;
    private final a f;

    i(Looper looper)
    {
        this(new f(), ((Queue) (new LinkedList())), new g(), new o(looper), new Handler(looper));
    }

    private i(f f1, Queue queue, g g1, o o1, Handler handler)
    {
        b = f1;
        c = queue;
        a = g1;
        d = o1;
        e = handler;
        f = new a();
    }

    final void a()
    {
        if (!d.b())
        {
            ArrayList arraylist;
            for (arraylist = new ArrayList(); c.peek() != null && arraylist.size() < 100; arraylist.add(c.poll())) { }
            if (!arraylist.isEmpty())
            {
                d.a(new com.mopub.c.n.b(arraylist) {

                    final List a;
                    final i b;

                    public final n a(com.mopub.c.n.a a1)
                    {
                        return new n("https://analytics.mopub.com/i/jot/exchange_client_event", a, b.a, a1);
                    }

            
            {
                b = i.this;
                a = list;
                super();
            }
                }, new m());
                return;
            }
        }
    }

    public final void a(com.mopub.common.a.a a1)
    {
        f f1 = b;
        com.mopub.common.m.a(a1);
        boolean flag;
        if (f1.a.nextDouble() < a1.D)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            return;
        }
        if (c.size() >= 500)
        {
            com.mopub.common.c.a.b((new StringBuilder("EventQueue is at max capacity. Event \"")).append(a1.b).append("\" is being dropped.").toString());
            return;
        }
        c.add(a1);
        if (c.size() >= 100)
        {
            a();
        }
        b();
    }

    final void b()
    {
        if (e.hasMessages(0) || c.isEmpty())
        {
            return;
        } else
        {
            e.postDelayed(f, 0x1d4c0L);
            return;
        }
    }
}
