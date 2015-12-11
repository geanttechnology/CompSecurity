// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.core;

import com.smule.android.c.aa;
import java.util.Map;

// Referenced classes of package com.smule.android.network.core:
//            m, l, n

public class k
{

    private static final String k = com/smule/android/network/core/k.getName();
    public m a;
    public String b;
    public l c;
    public Map d;
    public Map e;
    public boolean f;
    public int g;
    public int h;
    public boolean i;
    public Map j;
    private int l;
    private boolean m;

    public k()
    {
        a = m.a;
        c = l.a;
        d = null;
        e = null;
        f = false;
        g = 2;
        h = 0;
        i = false;
        l = 10000;
        m = false;
        j = null;
    }

    public k(m m1, String s, l l1, n n1, Map map, Map map1, boolean flag)
    {
        a = m.a;
        c = l.a;
        d = null;
        e = null;
        f = false;
        g = 2;
        h = 0;
        i = false;
        l = 10000;
        m = false;
        j = null;
        a = m1;
        b = s;
        c = l1;
        d = map;
        e = map1;
        f = flag;
        g = a(n1);
    }

    public k(m m1, String s, l l1, n n1, Map map, boolean flag)
    {
        a = m.a;
        c = l.a;
        d = null;
        e = null;
        f = false;
        g = 2;
        h = 0;
        i = false;
        l = 10000;
        m = false;
        j = null;
        a = m1;
        b = s;
        c = l1;
        d = map;
        f = flag;
        g = a(n1);
    }

    private int a(n n1)
    {
        if (n1 == n.a)
        {
            return 0;
        }
        if (n1 == n.b)
        {
            return 1;
        }
        if (n1 == n.c)
        {
            return 2;
        } else
        {
            aa.b(k, "invalid api version!");
            return -1;
        }
    }

    public int a()
    {
        return l;
    }

    public void a(int i1)
    {
        l = i1;
    }

    public boolean b()
    {
        return m;
    }

}
