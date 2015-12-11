// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;
import java.util.Set;

final class ekz extends eiu
{

    private transient Object a;
    private transient int c;

    ekz(Object obj)
    {
        a = f.b(obj);
    }

    ekz(Object obj, int i)
    {
        a = obj;
        c = i;
    }

    final boolean a()
    {
        return false;
    }

    public final elm b()
    {
        return ejj.a(a);
    }

    public final boolean contains(Object obj)
    {
        return a.equals(obj);
    }

    final boolean d()
    {
        return c != 0;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof Set)
            {
                if (((Set) (obj = (Set)obj)).size() != 1 || !a.equals(((Set) (obj)).iterator().next()))
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        int j = c;
        int i = j;
        if (j == 0)
        {
            i = a.hashCode();
            c = i;
        }
        return i;
    }

    public final boolean isEmpty()
    {
        return false;
    }

    public final Iterator iterator()
    {
        return ejj.a(a);
    }

    public final int size()
    {
        return 1;
    }

    public final Object[] toArray()
    {
        return (new Object[] {
            a
        });
    }

    public final Object[] toArray(Object aobj[])
    {
        if (aobj.length != 0) goto _L2; else goto _L1
_L1:
        Object aobj1[] = eka.a(aobj, 1);
_L4:
        aobj1[0] = a;
        return aobj1;
_L2:
        aobj1 = aobj;
        if (aobj.length > 1)
        {
            aobj[1] = null;
            aobj1 = aobj;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final String toString()
    {
        String s = a.toString();
        return (new StringBuilder(s.length() + 2)).append('[').append(s).append(']').toString();
    }
}
