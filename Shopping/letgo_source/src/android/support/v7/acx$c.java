// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            acx

private static class 
{

    private final Set a = new HashSet();
    private final Map b = new HashMap();
    private final Map c = new HashMap();
    private final Map d = new HashMap();
    private final Map e = new HashMap();
    private f f;

    public Set a()
    {
        return a;
    }

    public void a(a a1)
    {
        f = a1;
    }

    public void a(f f1)
    {
        a.add(f1);
    }

    public void a(a a1, a a2)
    {
        List list = (List)b.get(a1);
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
            b.put(a1, obj);
        }
        ((List) (obj)).add(a2);
    }

    public void a(b b1, String s)
    {
        List list = (List)d.get(b1);
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
            d.put(b1, obj);
        }
        ((List) (obj)).add(s);
    }

    public Map b()
    {
        return b;
    }

    public void b(b b1, b b2)
    {
        List list = (List)c.get(b1);
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
            c.put(b1, obj);
        }
        ((List) (obj)).add(b2);
    }

    public void b(c c1, String s)
    {
        List list = (List)e.get(c1);
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
            e.put(c1, obj);
        }
        ((List) (obj)).add(s);
    }

    public Map c()
    {
        return d;
    }

    public Map d()
    {
        return e;
    }

    public Map e()
    {
        return c;
    }

    public c f()
    {
        return f;
    }

    public ()
    {
    }
}
