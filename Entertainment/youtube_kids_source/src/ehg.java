// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

final class ehg extends eiu
{

    static final ehg a = new ehg();
    private static final long serialVersionUID = 0L;

    private ehg()
    {
    }

    final boolean a()
    {
        return false;
    }

    public final elm b()
    {
        return ejj.a();
    }

    public final eic c()
    {
        return eic.g();
    }

    public final boolean contains(Object obj)
    {
        return false;
    }

    public final boolean containsAll(Collection collection)
    {
        return collection.isEmpty();
    }

    final boolean d()
    {
        return true;
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof Set)
        {
            return ((Set)obj).isEmpty();
        } else
        {
            return false;
        }
    }

    public final int hashCode()
    {
        return 0;
    }

    public final boolean isEmpty()
    {
        return true;
    }

    public final Iterator iterator()
    {
        return ejj.a();
    }

    final Object readResolve()
    {
        return a;
    }

    public final int size()
    {
        return 0;
    }

    public final Object[] toArray()
    {
        return eka.a;
    }

    public final Object[] toArray(Object aobj[])
    {
        return eic.g().toArray(aobj);
    }

    public final String toString()
    {
        return "[]";
    }

}
