// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bo.app;

import java.util.Iterator;

// Referenced classes of package bo.app:
//            gr, gy, fu, hj, 
//            hw, gg

final class ho extends gr
{

    final transient Object a[];
    private final Object b[];
    private final transient int c;
    private final transient int d;

    ho(Object aobj[], int i, Object aobj1[], int j)
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

    public final hw a()
    {
        return gy.a(b);
    }

    final boolean b_()
    {
        return true;
    }

    public final boolean contains(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        int i = fu.a(obj.hashCode());
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

    final boolean e()
    {
        return false;
    }

    final gg f()
    {
        return new hj(this, b);
    }

    public final int hashCode()
    {
        return d;
    }

    public final Iterator iterator()
    {
        return gy.a(b);
    }

    public final int size()
    {
        return b.length;
    }
}
