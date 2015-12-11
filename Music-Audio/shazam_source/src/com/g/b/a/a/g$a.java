// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.a;

import c.d;
import c.m;
import com.g.b.a;
import com.g.b.a.k;
import com.g.b.i;
import com.g.b.q;
import com.g.b.s;
import com.g.b.v;
import com.g.b.w;
import com.g.b.x;
import com.g.b.y;
import com.g.b.z;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

// Referenced classes of package com.g.b.a.a:
//            g, t

final class c
    implements com.g.b.ject
{

    final g a;
    private final int b;
    private final v c;
    private int d;

    public final x a(v v1)
    {
        d = d + 1;
        if (b > 0)
        {
            q q1 = (q)a.a.g.get(b - 1);
            a a1 = com.g.b.a.a.g.a(a).b.a;
            if (!v1.a().getHost().equals(a1.b) || k.a(v1.a()) != a1.c)
            {
                throw new IllegalStateException((new StringBuilder("network interceptor ")).append(q1).append(" must retain the same host and port").toString());
            }
            if (d > 1)
            {
                throw new IllegalStateException((new StringBuilder("network interceptor ")).append(q1).append(" must call proceed() exactly once").toString());
            }
        }
        if (b >= a.a.g.size()) goto _L2; else goto _L1
_L1:
          = new <init>(a, b + 1, v1);
        q q2 = (q)a.a.g.get(b);
        v1 = q2.a();
        if (.d != 1)
        {
            throw new IllegalStateException((new StringBuilder("network interceptor ")).append(q2).append(" must call proceed() exactly once").toString());
        }
_L4:
        return v1;
_L2:
        x x1;
        int j;
        g.b(a).a(v1);
        com.g.b.a.a.g.a(a, v1);
        if (a.c() && v1.d != null)
        {
            d d1 = m.a(g.b(a).a(v1, v1.d.b()));
            v1.d.a(d1);
            d1.close();
        }
        x1 = g.c(a);
        j = x1.c;
        if (j == 204)
        {
            break; /* Loop/switch isn't completed */
        }
        v1 = x1;
        if (j != 205) goto _L4; else goto _L3
_L3:
        v1 = x1;
        if (x1.g.a() > 0L)
        {
            throw new ProtocolException((new StringBuilder("HTTP ")).append(j).append(" had non-zero Content-Length: ").append(x1.g.a()).toString());
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    lException(g g1, int j, v v1)
    {
        a = g1;
        super();
        b = j;
        c = v1;
    }
}
