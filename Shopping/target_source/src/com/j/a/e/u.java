// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.e;

import com.j.a.g.w;

// Referenced classes of package com.j.a.e:
//            az, ar

class u
    implements com.d.a.b.a.a
{

    final ar a;
    final az b;

    u(az az1, ar ar1)
    {
        b = az1;
        a = ar1;
        super();
    }

    public transient void a(Object aobj[])
    {
        w.a("SocketIO Connected!");
        b.a = true;
        az.c(b);
        az.a(b, Boolean.valueOf(false));
        if (a != null)
        {
            a.a(Boolean.valueOf(true));
        }
    }
}
