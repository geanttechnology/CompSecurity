// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collection;
import java.util.Iterator;

final class ekd extends eho
{

    final transient ekf a[];
    final transient int b;
    private final transient ekf c[];
    private final transient ekf d[];
    private final transient int e;
    private transient eho f;

    ekd(Collection collection)
    {
        int i = collection.size();
        int j = ehl.a(i, 1.2D);
        b = j - 1;
        ekf aekf[] = new ekf[j];
        ekf aekf1[] = new ekf[j];
        ekf aekf2[] = new ekf[i];
        Iterator iterator = collection.iterator();
        i = 0;
        j = 0;
        while (iterator.hasNext()) 
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            Object obj = f.b(entry.getKey());
            Object obj1 = f.b(entry.getValue());
            int k = obj.hashCode();
            int l = obj1.hashCode();
            int i1 = ehl.a(k) & b;
            int j1 = ehl.a(l) & b;
            ekf ekf1 = aekf[i1];
            for (collection = ekf1; collection != null; collection = collection.a())
            {
                if (obj.equals(collection.getKey()))
                {
                    throw new IllegalArgumentException((new StringBuilder("Multiple entries with same key: ")).append(entry).append(" and ").append(collection).toString());
                }
            }

            ekf ekf2 = aekf1[j1];
            for (collection = ekf2; collection != null; collection = collection.b())
            {
                if (obj1.equals(collection.getValue()))
                {
                    throw new IllegalArgumentException((new StringBuilder("Multiple entries with same value: ")).append(entry).append(" and ").append(collection).toString());
                }
            }

            if (ekf1 == null && ekf2 == null)
            {
                collection = new ekf(obj, obj1);
            } else
            {
                collection = new ekk(obj, obj1, ekf1, ekf2);
            }
            aekf[i1] = collection;
            aekf1[j1] = collection;
            aekf2[i] = collection;
            j = (k ^ l) + j;
            i++;
        }
        c = aekf;
        a = aekf1;
        d = aekf2;
        e = j;
    }

    static ekf[] a(ekd ekd1)
    {
        return ekd1.d;
    }

    static int b(ekd ekd1)
    {
        return ekd1.e;
    }

    final eiu c()
    {
        return new eke(this);
    }

    final boolean e()
    {
        return false;
    }

    public final Object get(Object obj)
    {
        if (obj != null)
        {
            int i = ehl.a(obj.hashCode());
            int j = b;
            ekf ekf1 = c[i & j];
            while (ekf1 != null) 
            {
                if (obj.equals(ekf1.getKey()))
                {
                    return ekf1.getValue();
                }
                ekf1 = ekf1.a();
            }
        }
        return null;
    }

    public final eho l_()
    {
        eho eho1 = f;
        Object obj = eho1;
        if (eho1 == null)
        {
            obj = new ekg(this);
            f = ((eho) (obj));
        }
        return ((eho) (obj));
    }

    public final int size()
    {
        return d.length;
    }
}
