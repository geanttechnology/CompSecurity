// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter;

import com.cyberlink.youcammakeup.jniproxy.ah;
import com.cyberlink.youcammakeup.jniproxy.bi;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter:
//            b

public class a
{

    private b a;
    private b b;
    private b c;
    private b d;
    private b e;
    private boolean f;

    public a()
    {
        f = true;
    }

    public a(a a1)
    {
        Object obj = null;
        super();
        b b1;
        if (a1.a != null)
        {
            b1 = a1.a.a();
        } else
        {
            b1 = null;
        }
        a = b1;
        if (a1.b != null)
        {
            b1 = a1.b.a();
        } else
        {
            b1 = null;
        }
        b = b1;
        if (a1.c != null)
        {
            b1 = a1.c.a();
        } else
        {
            b1 = null;
        }
        c = b1;
        if (a1.d != null)
        {
            b1 = a1.d.a();
        } else
        {
            b1 = null;
        }
        d = b1;
        b1 = obj;
        if (a1.e != null)
        {
            b1 = a1.e.a();
        }
        e = b1;
        f = a1.f;
    }

    public b a()
    {
        if (a != null)
        {
            return a.a();
        } else
        {
            return null;
        }
    }

    public void a(boolean flag)
    {
        f = flag;
    }

    public void a(boolean flag, boolean flag1, boolean flag2, boolean flag3, String s, ah ah, ah ah1, 
            int i, bi bi)
    {
        if (a == null)
        {
            a = new b();
        }
        a.a = flag;
        a.b = flag2;
        a.c = flag3;
        a.d = s;
        a.e = i;
        a.f = ah;
        a.g = ah1;
        a.j = bi;
    }

    public void a(boolean flag, boolean flag1, boolean flag2, boolean flag3, String s, ah ah, ah ah1, 
            bi bi)
    {
        if (b == null)
        {
            b = new b();
        }
        b.a = flag;
        b.b = flag2;
        b.c = flag3;
        b.d = s;
        b.f = ah;
        b.g = ah1;
        b.j = bi;
    }

    public void a(boolean flag, boolean flag1, boolean flag2, boolean flag3, String s, ah ah, ah ah1, 
            bi bi, boolean flag4)
    {
        if (e == null)
        {
            e = new b();
        }
        e.a = flag;
        e.b = flag2;
        e.c = flag3;
        e.d = s;
        e.h = ah;
        e.i = ah1;
        e.j = bi;
        e.k = flag4;
    }

    public b b()
    {
        if (b != null)
        {
            return b.a();
        } else
        {
            return null;
        }
    }

    public void b(boolean flag, boolean flag1, boolean flag2, boolean flag3, String s, ah ah, ah ah1, 
            bi bi)
    {
        if (c == null)
        {
            c = new b();
        }
        c.a = flag;
        c.b = flag2;
        c.c = flag3;
        c.d = s;
        c.f = ah;
        c.g = ah1;
        c.j = bi;
    }

    public b c()
    {
        if (c != null)
        {
            return c.a();
        } else
        {
            return null;
        }
    }

    public void c(boolean flag, boolean flag1, boolean flag2, boolean flag3, String s, ah ah, ah ah1, 
            bi bi)
    {
        if (d == null)
        {
            d = new b();
        }
        d.a = flag;
        d.b = flag2;
        d.c = flag3;
        d.d = s;
        d.h = ah;
        d.i = ah1;
        d.j = bi;
        d.k = false;
    }

    public b d()
    {
        if (d != null)
        {
            return d.a();
        } else
        {
            return null;
        }
    }

    public b e()
    {
        if (e != null)
        {
            return e.a();
        } else
        {
            return null;
        }
    }

    public boolean f()
    {
        return f;
    }
}
