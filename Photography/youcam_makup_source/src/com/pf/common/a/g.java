// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.a;

import android.graphics.Bitmap;
import java.util.Set;

// Referenced classes of package com.pf.common.a:
//            d, c, f

class g
    implements d
{

    final d a;
    final c b;

    g(c c1, d d1)
    {
        b = c1;
        super();
        a = d1;
        c1.c();
        c.b(c1).add(new f(this, c.a(c1)));
    }

    public Bitmap a()
    {
        b.c();
        return a.a();
    }

    public void b()
    {
        b.c();
        a.b();
    }

    public String toString()
    {
        return a.toString();
    }
}
