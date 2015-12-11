// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

public abstract class ehr
    implements Serializable, Collection
{

    static final ehr b = new ehu();
    private transient eic a;

    ehr()
    {
    }

    abstract boolean a();

    public final boolean add(Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    public abstract elm b();

    public eic c()
    {
        eic eic2 = a;
        eic eic1 = eic2;
        if (eic2 == null)
        {
            eic1 = f();
            a = eic1;
        }
        return eic1;
    }

    public final void clear()
    {
        throw new UnsupportedOperationException();
    }

    public boolean contains(Object obj)
    {
        return obj != null && ejj.a(b(), obj);
    }

    public boolean containsAll(Collection collection)
    {
        return ehc.a(this, collection);
    }

    eic f()
    {
        switch (size())
        {
        default:
            return new ekc(this, toArray());

        case 0: // '\0'
            return eic.g();

        case 1: // '\001'
            return eic.a(b().next());
        }
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    public Iterator iterator()
    {
        return b();
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

    public Object[] toArray()
    {
        return eka.a(this);
    }

    public Object[] toArray(Object aobj[])
    {
        return eka.a(this, aobj);
    }

    public String toString()
    {
        return ehc.a(this);
    }

    Object writeReplace()
    {
        return new ehv(toArray());
    }

}
