// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.util;

import java.util.ArrayList;

// Referenced classes of package com.wishabi.flipp.util:
//            n, m

public class o
{

    public final ArrayList a;
    public final int b;
    public int c;
    public int d;
    public final String e;
    private final ArrayList f;
    private final ArrayList g;

    public o(int i)
    {
        a = new ArrayList();
        f = new ArrayList();
        g = new ArrayList();
        c = -1;
        b = i;
        e = null;
    }

    public o(int i, String s)
    {
        a = new ArrayList();
        f = new ArrayList();
        g = new ArrayList();
        c = -1;
        b = i;
        e = s;
    }

    public static o a(int i, int j)
    {
        return new n(i, j, (byte)0);
    }

    public static o a(int i, int j, String s)
    {
        return new n(i, j, s, (byte)0);
    }

    private void c()
    {
        if (c != -1)
        {
            throw new IllegalAccessError("Can't modify a section after it has already been added to a SectionedCollection");
        } else
        {
            return;
        }
    }

    public int a()
    {
        return a.size() + f.size() + g.size();
    }

    public m a(int i)
    {
        return (m)f.get(i);
    }

    public void a(m m1)
    {
        c();
        m1.b = b;
        a.add(m1);
    }

    public int b()
    {
        return f.size();
    }

    public m b(int i)
    {
        if (i < a.size())
        {
            return (m)a.get(i);
        }
        if (i < f.size() + a.size())
        {
            return (m)f.get(i - a.size());
        }
        if (i < g.size() + f.size() + a.size())
        {
            return (m)g.get(i - f.size() - a.size());
        } else
        {
            throw new IndexOutOfBoundsException();
        }
    }

    public void b(m m1)
    {
        c();
        m1.b = b;
        f.add(m1);
    }
}
