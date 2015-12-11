// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.m;

import com.g.b.t;
import com.g.c.ab;
import com.g.c.ah;
import com.g.c.i;
import com.g.c.n;
import com.g.c.w;
import com.shazam.h.u;
import com.shazam.i.b.c;
import com.shazam.i.i.f;

// Referenced classes of package com.shazam.i.m:
//            a

public final class b
{

    private static com.g.c.u a;

    public static com.g.c.u a()
    {
        com/shazam/i/m/b;
        JVM INSTR monitorenter ;
        Object obj;
        Object obj1;
        if (a != null)
        {
            break MISSING_BLOCK_LABEL_253;
        }
        obj = new com.g.c.u.a(c.a());
        obj1 = new u(new t(f.b()));
        if (((com.g.c.u.a) (obj)).b != null)
        {
            throw new IllegalStateException("Downloader already set.");
        }
        break MISSING_BLOCK_LABEL_61;
        obj;
        com/shazam/i/m/b;
        JVM INSTR monitorexit ;
        throw obj;
        obj.b = ((com.g.c.j) (obj1));
        obj1 = com.shazam.i.m.a.a();
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        throw new IllegalArgumentException("Memory cache must not be null.");
        if (((com.g.c.u.a) (obj)).d != null)
        {
            throw new IllegalStateException("Memory cache already set.");
        }
        obj.d = ((com.g.c.d) (obj1));
        obj1 = ((com.g.c.u.a) (obj)).a;
        if (((com.g.c.u.a) (obj)).b == null)
        {
            obj.b = ah.a(((android.content.Context) (obj1)));
        }
        if (((com.g.c.u.a) (obj)).d == null)
        {
            obj.d = new n(((android.content.Context) (obj1)));
        }
        if (((com.g.c.u.a) (obj)).c == null)
        {
            obj.c = new w();
        }
        if (((com.g.c.u.a) (obj)).f == null)
        {
            obj.f = com.g.c.u.f.a;
        }
        ab ab1 = new ab(((com.g.c.u.a) (obj)).d);
        a = new com.g.c.u(((android.content.Context) (obj1)), new i(((android.content.Context) (obj1)), ((com.g.c.u.a) (obj)).c, com.g.c.u.a, ((com.g.c.u.a) (obj)).b, ((com.g.c.u.a) (obj)).d, ab1), ((com.g.c.u.a) (obj)).d, ((com.g.c.u.a) (obj)).e, ((com.g.c.u.a) (obj)).f, ((com.g.c.u.a) (obj)).g, ab1, ((com.g.c.u.a) (obj)).h, ((com.g.c.u.a) (obj)).i, ((com.g.c.u.a) (obj)).j);
        obj = a;
        com/shazam/i/m/b;
        JVM INSTR monitorexit ;
        return ((com.g.c.u) (obj));
    }
}
