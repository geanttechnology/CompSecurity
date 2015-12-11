// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library.f;

import com.liverail.library.a.b;
import com.liverail.library.a.c;
import com.liverail.library.a.d;
import com.liverail.library.b.a;

// Referenced classes of package com.liverail.library.f:
//            a

class g
    implements Runnable
{

    final com.liverail.library.f.a a;

    g(com.liverail.library.f.a a1)
    {
        a = a1;
        super();
    }

    public void run()
    {
        if (!com.liverail.library.f.a.m(a) && com.liverail.library.f.a.e(a) != null && com.liverail.library.f.a.d(a) != null)
        {
            com.liverail.library.b.a.d("Video stream has timed out");
            com.liverail.library.f.a.a(a, new b(c.c, (new StringBuilder("timeout=")).append(com.liverail.library.f.a.k(a).h).append("ms ").append(com.liverail.library.f.a.d(a).toString()).append(" url=").append(com.liverail.library.f.a.e(a)).toString()));
        }
    }
}
