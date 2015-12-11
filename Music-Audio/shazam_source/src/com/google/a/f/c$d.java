// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.f;

import com.google.a.c.ad;
import com.google.a.c.aj;
import com.google.a.c.ao;
import com.google.a.c.r;
import com.google.a.c.u;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

// Referenced classes of package com.google.a.f:
//            c

public final class nit> extends u
    implements Serializable
{

    final c a;
    private transient aj b;

    protected final Collection a()
    {
        return c();
    }

    protected final Object b()
    {
        return c();
    }

    protected final Set c()
    {
        aj aj1 = b;
        Object obj = aj1;
        if (aj1 == null)
        {
            obj = r.a(a.a(ad.a(a)));
            c c1 = a;
            obj = aj.a(r.a(ao.a(((r) (obj)).a, c1)).a);
            b = ((aj) (obj));
        }
        return ((Set) (obj));
    }

    public final Set d()
    {
        return aj.a(b.a(com.google.a.f.c.d(a.a)));
    }

    n(c c1)
    {
        a = c1;
        super();
    }
}
