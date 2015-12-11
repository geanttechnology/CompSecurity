// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b;

import com.google.a.a.f;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.google.a.b:
//            n, h, s, l

public abstract class g extends AbstractCollection
    implements Serializable
{

    private transient h a;

    g()
    {
    }

    int a(Object aobj[], int i)
    {
        for (Iterator iterator1 = iterator(); iterator1.hasNext();)
        {
            aobj[i] = iterator1.next();
            i++;
        }

        return i;
    }

    public final boolean add(Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    abstract boolean b();

    public abstract s c();

    public final void clear()
    {
        throw new UnsupportedOperationException();
    }

    public boolean contains(Object obj)
    {
        return obj != null && super.contains(obj);
    }

    public h d()
    {
        h h2 = a;
        h h1 = h2;
        if (h2 == null)
        {
            h1 = e();
            a = h1;
        }
        return h1;
    }

    h e()
    {
        switch (size())
        {
        default:
            return new n(this, toArray());

        case 0: // '\0'
            return com.google.a.b.h.f();

        case 1: // '\001'
            return h.a(c().next());
        }
    }

    public Iterator iterator()
    {
        return c();
    }

    public final boolean remove(Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public final boolean removeAll(Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    public final boolean retainAll(Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    public final Object[] toArray()
    {
        int i = size();
        if (i == 0)
        {
            return l.a;
        } else
        {
            Object aobj[] = new Object[i];
            a(aobj, 0);
            return aobj;
        }
    }

    public final Object[] toArray(Object aobj[])
    {
        int i;
        f.a(((Object) (aobj)));
        i = size();
        if (aobj.length >= i) goto _L2; else goto _L1
_L1:
        Object aobj1[] = l.a(aobj, i);
_L4:
        a(aobj1, 0);
        return aobj1;
_L2:
        aobj1 = aobj;
        if (aobj.length > i)
        {
            aobj[i] = null;
            aobj1 = aobj;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    // Unreferenced inner class com/google/a/b/g$a
    /* block-local class not found */
    class a {}


    // Unreferenced inner class com/google/a/b/g$b
    /* block-local class not found */
    class b {}

}
