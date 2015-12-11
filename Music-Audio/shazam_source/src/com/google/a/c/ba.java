// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import java.util.Iterator;

// Referenced classes of package com.google.a.c:
//            aj, ap, w, ax, 
//            bk, ad

final class ba extends aj
{

    final transient Object a[];
    private final Object b[];
    private final transient int c;
    private final transient int d;

    ba(Object aobj[], int i, Object aobj1[], int j)
    {
        b = aobj;
        a = aobj1;
        c = j;
        d = i;
    }

    final int a(Object aobj[], int i)
    {
        System.arraycopy(((Object) (b)), 0, ((Object) (aobj)), i, b.length);
        return b.length + i;
    }

    public final bk a()
    {
        return ap.a(b);
    }

    public final boolean contains(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        int i = w.a(obj.hashCode());
        do
        {
            Object obj1 = a[c & i];
            if (obj1 == null)
            {
                return false;
            }
            if (obj1.equals(obj))
            {
                return true;
            }
            i++;
        } while (true);
    }

    final boolean d_()
    {
        return true;
    }

    final boolean e()
    {
        return false;
    }

    final ad f()
    {
        return new ax(this, b);
    }

    public final int hashCode()
    {
        return d;
    }

    public final Iterator iterator()
    {
        return ap.a(b);
    }

    public final int size()
    {
        return b.length;
    }
}
