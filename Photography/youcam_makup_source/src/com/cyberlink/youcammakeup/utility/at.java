// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.graphics.Color;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            au

public class at
{

    private Integer a;
    private Integer b;
    private Integer c;
    private int d;
    private int e;
    private String f;
    private final au g;

    public at(int i1)
    {
        g = new au();
        e = 0;
        d = i1;
        g.c = false;
        g.d = 0;
        c(i1);
    }

    public at(int i1, int j1, String s, int k1, int l1, boolean flag, int i2, 
            int ai[])
    {
        this(i1);
        e = j1;
        f = s;
        g.a = k1;
        g.b = l1;
        g.c = flag;
        g.d = i2;
        g.e = ai;
    }

    public at(int i1, int j1, int ai[])
    {
        this(i1);
        e = j1;
        g.e = ai;
    }

    public at(at at1)
    {
        this(0);
        if (at1 != null)
        {
            e = at1.d();
            d = at1.e();
            f = at1.h();
            g.a = at1.f();
            g.b = at1.g();
            g.c = at1.k();
            g.d = at1.j();
            g.e = at1.l();
            c(d);
        }
    }

    private void c(int i1)
    {
        boolean flag = false;
        int l1 = Color.red(i1);
        int k1 = Color.green(i1);
        int j1 = Color.blue(i1);
        if (l1 > -1 && l1 < 256)
        {
            i1 = l1;
        } else
        {
            i1 = 0;
        }
        a = Integer.valueOf(i1);
        if (k1 > -1 && k1 < 256)
        {
            i1 = k1;
        } else
        {
            i1 = 0;
        }
        b = Integer.valueOf(i1);
        i1 = ((flag) ? 1 : 0);
        if (j1 > -1)
        {
            i1 = ((flag) ? 1 : 0);
            if (j1 < 256)
            {
                i1 = j1;
            }
        }
        c = Integer.valueOf(i1);
    }

    public Integer a()
    {
        return a;
    }

    public void a(int i1)
    {
        e = i1;
    }

    public boolean a(boolean flag)
    {
        g.c = flag;
        return flag;
    }

    public Integer b()
    {
        return b;
    }

    public void b(int i1)
    {
        g.d = i1;
    }

    public Integer c()
    {
        return c;
    }

    public Object clone()
    {
        return m();
    }

    public int d()
    {
        return e;
    }

    public int e()
    {
        return d;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof at))
            {
                return false;
            }
            obj = (at)obj;
            if (d != ((at) (obj)).e())
            {
                return false;
            }
        }
        return true;
    }

    public int f()
    {
        return g.a;
    }

    public int g()
    {
        return g.b;
    }

    public String h()
    {
        return f;
    }

    public int hashCode()
    {
        return d;
    }

    public String i()
    {
        return String.format("%08X", new Object[] {
            Integer.valueOf(d & -1)
        });
    }

    public int j()
    {
        return g.d;
    }

    public boolean k()
    {
        return g.c;
    }

    public int[] l()
    {
        return g.e;
    }

    public at m()
    {
        return new at(this);
    }
}
