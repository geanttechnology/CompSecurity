// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import com.mopub.common.b;
import com.mopub.common.c.a;
import com.mopub.common.m;
import com.mopub.mobileads.a.e;
import java.util.Map;
import java.util.TreeMap;

// Referenced classes of package com.mopub.mobileads:
//            t, s, m

public final class n
    implements m.a
{
    static interface a
    {

        public abstract void a();

        public abstract void a(s s1);

        public abstract void b();

        public abstract void c();

        public abstract void d();
    }


    boolean a;
    a b;
    com.mopub.mobileads.m c;
    final Handler d = new Handler();
    final Runnable e = new Runnable() {

        final n a;

        public final void run()
        {
            com.mopub.common.c.a.b("Third-party network timed out.");
            a.a(s.i);
            a.e();
        }

            
            {
                a = n.this;
                super();
            }
    };
    private final t f;
    private Context g;
    private Map h;
    private Map i;

    public n(t t1, String s1, Map map, long l, b b1)
    {
        m.a(map);
        f = t1;
        g = f.d;
        com.mopub.common.c.a.b((new StringBuilder("Attempting to invoke custom event: ")).append(s1).toString());
        try
        {
            c = com.mopub.mobileads.a.e.a(s1);
        }
        // Misplaced declaration of an exception variable
        catch (t t1)
        {
            com.mopub.common.c.a.b((new StringBuilder("Couldn't locate or instantiate custom event: ")).append(s1).append(".").toString());
            f.a(s.g);
            return;
        }
        i = new TreeMap(map);
        h = f.a.getLocalExtras();
        if (f.a.getLocation() != null)
        {
            h.put("location", f.a.getLocation());
        }
        h.put("broadcastIdentifier", Long.valueOf(l));
        h.put("mopub-intent-ad-report", b1);
    }

    private void g()
    {
        d.removeCallbacks(e);
    }

    public final void a()
    {
        if (!a)
        {
            g();
            if (b != null)
            {
                b.a();
                return;
            }
        }
    }

    public final void a(s s1)
    {
        while (a || b == null) 
        {
            return;
        }
        s s2 = s1;
        if (s1 == null)
        {
            s2 = s.q;
        }
        g();
        b.a(s2);
    }

    public final void b()
    {
        while (a || b == null) 
        {
            return;
        }
        b.b();
    }

    public final void c()
    {
        while (a || b == null) 
        {
            return;
        }
        b.c();
    }

    public final void d()
    {
        while (a || b == null) 
        {
            return;
        }
        b.d();
    }

    final void e()
    {
        c = null;
        g = null;
        i = null;
        h = null;
        b = null;
        a = true;
    }

    final int f()
    {
        if (f == null || f.a.getAdTimeoutDelay() == null || f.a.getAdTimeoutDelay().intValue() < 0)
        {
            return 30000;
        } else
        {
            return f.a.getAdTimeoutDelay().intValue() * 1000;
        }
    }
}
