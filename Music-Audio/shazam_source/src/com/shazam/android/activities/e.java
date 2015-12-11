// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import com.shazam.android.advert.c;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.factory.UserSessionEventFactory;
import com.shazam.android.aq.n;
import com.shazam.android.util.a.b;
import com.shazam.k.s;
import com.shazam.n.l;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.shazam.android.activities:
//            f

public final class e
    implements f
{

    final EventAnalytics a;
    final s b;
    final c c;
    final b d;
    String e;
    private final l f;
    private final ExecutorService g;
    private final n h;

    public e(EventAnalytics eventanalytics, l l1, s s, ExecutorService executorservice, n n1, c c1, b b1)
    {
        a = eventanalytics;
        f = l1;
        b = s;
        g = executorservice;
        h = n1;
        c = c1;
        d = b1;
    }

    public final void a()
    {
        f.a(0L);
        h.b();
        e = h.a();
    }

    public final void a(long l1)
    {
        f.b(l1);
        l1 = f.a();
        g.execute(new Runnable(l1) {

            final long a;
            final e b;

            public final void run()
            {
                int i = b.b.d();
                b.a.logEvent(UserSessionEventFactory.userSessionEvent(b.e, a, b.c.b(), i, b.d.a()));
            }

            
            {
                b = e.this;
                a = l1;
                super();
            }
        });
    }
}
