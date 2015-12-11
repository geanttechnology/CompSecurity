// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.e;

import com.j.a.d.e;
import com.j.a.g.w;

// Referenced classes of package com.j.a.e:
//            az, ar

class t
    implements com.d.a.b.a.a
{

    final ar a;
    final az b;

    t(az az1, ar ar1)
    {
        b = az1;
        a = ar1;
        super();
    }

    public transient void a(Object aobj[])
    {
        w.a("SocketIO Disconnected!");
        b.a = false;
        b.b = false;
        az.a(b, null);
        if (a != null)
        {
            a.a(Boolean.valueOf(false));
        }
        if (!az.a(b).booleanValue() && e.e().g())
        {
            az.b(b);
        }
    }
}
