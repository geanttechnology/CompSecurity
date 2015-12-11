// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class ekr extends eiv
{

    private transient Object a[];
    private final transient int c;
    private final transient int d;

    ekr(Object aobj[], int i, Object aobj1[], int j)
    {
        super(aobj);
        a = aobj1;
        c = j;
        d = i;
    }

    public final boolean contains(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        int i = ehl.a(obj.hashCode());
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

    final boolean d()
    {
        return true;
    }

    public final int hashCode()
    {
        return d;
    }
}
