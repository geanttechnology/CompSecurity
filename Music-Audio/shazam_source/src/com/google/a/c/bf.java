// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;


// Referenced classes of package com.google.a.c:
//            y, j, aj, aq

final class bf extends y
{

    final transient Object a;
    final transient Object b;
    transient y c;

    bf(Object obj, Object obj1)
    {
        j.a(obj, obj1);
        a = obj;
        b = obj1;
    }

    private bf(Object obj, Object obj1, y y1)
    {
        a = obj;
        b = obj1;
        c = y1;
    }

    final aj a()
    {
        return aj.a(a);
    }

    final aj c()
    {
        return aj.a(aq.a(a, b));
    }

    public final boolean containsKey(Object obj)
    {
        return a.equals(obj);
    }

    public final boolean containsValue(Object obj)
    {
        return b.equals(obj);
    }

    final boolean e()
    {
        return false;
    }

    public final y e_()
    {
        y y1 = c;
        Object obj = y1;
        if (y1 == null)
        {
            obj = new bf(b, a, this);
            c = ((y) (obj));
        }
        return ((y) (obj));
    }

    public final Object get(Object obj)
    {
        if (a.equals(obj))
        {
            return b;
        } else
        {
            return null;
        }
    }

    public final int size()
    {
        return 1;
    }
}
