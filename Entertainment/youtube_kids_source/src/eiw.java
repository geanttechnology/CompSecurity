// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;

public class eiw extends eht
{

    Object a[];
    int b;

    public eiw()
    {
        this(4);
    }

    private eiw(int i)
    {
        f.a(true, "capacity must be >= 0 but was %s", new Object[] {
            Integer.valueOf(4)
        });
        a = new Object[4];
        b = 0;
    }

    private eiw a(int i)
    {
        if (a.length < i)
        {
            a = eka.b(a, a(a.length, i));
        }
        return this;
    }

    public eht a(Object obj)
    {
        return b(obj);
    }

    public eht a(Iterator iterator)
    {
        return b(iterator);
    }

    public transient eiw a(Object aobj[])
    {
        for (int i = 0; i < aobj.length; i++)
        {
            eka.a(aobj[i], i);
        }

        a(b + aobj.length);
        System.arraycopy(((Object) (aobj)), 0, ((Object) (a)), b, aobj.length);
        b = b + aobj.length;
        return this;
    }

    public eiw b(Object obj)
    {
        a(b + 1);
        Object aobj[] = a;
        int i = b;
        b = i + 1;
        aobj[i] = f.b(obj);
        return this;
    }

    public eiw b(Iterator iterator)
    {
        super.a(iterator);
        return this;
    }
}
