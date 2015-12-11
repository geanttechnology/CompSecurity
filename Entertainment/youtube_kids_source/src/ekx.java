// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class ekx extends eho
{

    private transient Object a;
    private transient Object b;
    private transient eho c;

    ekx(Object obj, Object obj1)
    {
        a = obj;
        b = obj1;
    }

    private ekx(Object obj, Object obj1, eho eho1)
    {
        a = obj;
        b = obj1;
        c = eho1;
    }

    ekx(java.util.Map.Entry entry)
    {
        this(entry.getKey(), entry.getValue());
    }

    final eiu a()
    {
        return eiu.b(a);
    }

    final eiu c()
    {
        return eiu.b(ejr.a(a, b));
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

    public final eho l_()
    {
        eho eho1 = c;
        Object obj = eho1;
        if (eho1 == null)
        {
            obj = new ekx(b, a, this);
            c = ((eho) (obj));
        }
        return ((eho) (obj));
    }

    public final int size()
    {
        return 1;
    }
}
