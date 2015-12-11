// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;

public final class eie extends eht
{

    private Object a[];
    private int b;

    public eie()
    {
        this(4);
    }

    private eie(int i)
    {
        a = new Object[4];
        b = 0;
    }

    public final eht a(Object obj)
    {
        return b(obj);
    }

    public final eht a(Iterator iterator)
    {
        super.a(iterator);
        return this;
    }

    public final eic a()
    {
        switch (b)
        {
        default:
            if (b == a.length)
            {
                return new ekl(a);
            } else
            {
                return new ekl(eka.b(a, b));
            }

        case 0: // '\0'
            return eic.g();

        case 1: // '\001'
            return eic.a(a[0]);
        }
    }

    public final eie b(Object obj)
    {
        f.b(obj);
        int i = b + 1;
        if (a.length < i)
        {
            a = eka.b(a, a(a.length, i));
        }
        Object aobj[] = a;
        i = b;
        b = i + 1;
        aobj[i] = obj;
        return this;
    }

    public final eie b(Iterator iterator)
    {
        super.a(iterator);
        return this;
    }
}
