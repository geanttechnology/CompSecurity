// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library.c;

import com.a.a.a.f;
import com.liverail.library.b.a;
import java.util.Date;

// Referenced classes of package com.liverail.library.c:
//            g

class h extends f
{

    final g a;

    h(g g1)
    {
        a = g1;
        super();
    }

    public void a()
    {
        com.liverail.library.c.g.a(a, (new Date()).getTime() - com.liverail.library.c.g.a(a));
        com.liverail.library.b.a.b((new StringBuilder("(")).append(a.a).append(") ~ HTTP start delay=").append(g.b(a)).append("ms ").append(g.c(a)).toString());
    }

    public void a(int i, String s)
    {
        com.liverail.library.b.a.c((new StringBuilder("(")).append(a.a).append(") ~ HTTP complete ").append((new Date()).getTime() - com.liverail.library.c.g.a(a)).append("ms ").append(g.c(a)).toString());
        com.liverail.library.c.g.a(a, i, s);
    }

    public void a(Throwable throwable, String s)
    {
        StringBuilder stringbuilder = (new StringBuilder("(")).append(a.a).append(") ~ HTTP failed ").append((new Date()).getTime() - com.liverail.library.c.g.a(a)).append("ms ").append(a.b.e).append(" error=").append(throwable).append(" content=");
        String s1;
        if (s != null)
        {
            s1 = s;
        } else
        {
            s1 = "null";
        }
        com.liverail.library.b.a.e(stringbuilder.append(s1).toString());
        com.liverail.library.c.g.a(a, throwable, s);
    }
}
