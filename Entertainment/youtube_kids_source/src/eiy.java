// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Comparator;

final class eiy extends ekc
    implements ela
{

    eiy(eje eje1, eic eic)
    {
        super(eje1, eic);
    }

    final eic b(int i, int j)
    {
        return (new ekv(super.b(i, j), comparator())).c();
    }

    public final Comparator comparator()
    {
        return ((eje)super.e()).comparator();
    }

    public final boolean contains(Object obj)
    {
        return indexOf(obj) >= 0;
    }

    final ehr e()
    {
        return (eje)super.e();
    }

    public final int indexOf(Object obj)
    {
        int i = ((eje)super.e()).a(obj);
        if (i >= 0 && get(i).equals(obj))
        {
            return i;
        } else
        {
            return -1;
        }
    }

    public final int lastIndexOf(Object obj)
    {
        return indexOf(obj);
    }
}
