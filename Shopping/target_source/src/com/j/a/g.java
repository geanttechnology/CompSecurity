// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a;

import com.j.a.a.a.l;
import com.j.a.a.d;
import com.j.a.d.e;
import com.j.a.e.az;
import com.j.a.g.a.c;
import com.j.a.g.b;
import com.j.a.g.m;
import com.j.a.g.w;
import java.util.ArrayList;

// Referenced classes of package com.j.a:
//            i

class g extends c
{

    final i a;

    g(i i)
    {
        a = i;
        super();
    }

    public void a()
    {
        e.e().b(true);
        if (!m.a(b.a))
        {
            e.e().n().a("appBackground");
        }
        e.e().n().a(null);
        e.e().n().a().a(null);
        w.a("App assumed to be backgrounded");
        if (e.e().g())
        {
            az.a().c();
        }
        if (l.b() != null && l.b().a().size() > 0)
        {
            l.b().i();
        }
        super.a();
    }
}
