// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ListIterator;

class ekc extends ehm
{

    private final ehr a;
    private final eic c;

    ekc(ehr ehr, eic eic1)
    {
        a = ehr;
        c = eic1;
    }

    ekc(ehr ehr, Object aobj[])
    {
        this(ehr, eic.b(aobj));
    }

    public final eln a(int i)
    {
        return c.a(i);
    }

    ehr e()
    {
        return a;
    }

    public boolean equals(Object obj)
    {
        return c.equals(obj);
    }

    public Object get(int i)
    {
        return c.get(i);
    }

    public int hashCode()
    {
        return c.hashCode();
    }

    public int indexOf(Object obj)
    {
        return c.indexOf(obj);
    }

    public int lastIndexOf(Object obj)
    {
        return c.lastIndexOf(obj);
    }

    public ListIterator listIterator(int i)
    {
        return a(i);
    }

    public Object[] toArray()
    {
        return c.toArray();
    }

    public Object[] toArray(Object aobj[])
    {
        return c.toArray(aobj);
    }
}
