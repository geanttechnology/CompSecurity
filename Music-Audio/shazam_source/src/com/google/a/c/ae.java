// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import java.io.Serializable;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.a.c:
//            ak, j, ab, y, 
//            ao, az, ah, z, 
//            aq, ai, aj, av

public abstract class ae
    implements Serializable, Map
{
    public static final class a
    {

        public af.a a[];
        public int b;

        public final a a(Object obj, Object obj1)
        {
            a(b + 1);
            obj = ae.c(obj, obj1);
            obj1 = a;
            int k = b;
            b = k + 1;
            obj1[k] = obj;
            return this;
        }

        public final void a(int k)
        {
            if (k > a.length)
            {
                a = (af.a[])av.b(a, z.b.a(a.length, k));
            }
        }

        public a()
        {
            this((byte)0);
        }

        private a(byte byte0)
        {
            a = new af.a[4];
            b = 0;
        }
    }


    private static final java.util.Map.Entry a[] = new java.util.Map.Entry[0];
    private transient aj b;
    private transient aj c;
    private transient z d;

    ae()
    {
    }

    public static ae a(Map map)
    {
        if ((map instanceof ae) && !(map instanceof ak))
        {
            ae ae1 = (ae)map;
            if (!ae1.e())
            {
                return ae1;
            }
        } else
        if (map instanceof EnumMap)
        {
            map = new EnumMap((EnumMap)map);
            java.util.Map.Entry entry;
            for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); j.a(entry.getKey(), entry.getValue()))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

            switch (map.size())
            {
            default:
                return new ab(map);

            case 0: // '\0'
                return y.g();

            case 1: // '\001'
                map = (java.util.Map.Entry)ao.a(map.entrySet());
                break;
            }
            return y.a(map.getKey(), map.getValue());
        }
        map = (java.util.Map.Entry[])map.entrySet().toArray(a);
        switch (map.length)
        {
        default:
            return new az(map);

        case 0: // '\0'
            return y.g();

        case 1: // '\001'
            map = map[0];
            break;
        }
        return y.a(map.getKey(), map.getValue());
    }

    public static ae b(Object obj, Object obj1)
    {
        return y.a(obj, obj1);
    }

    static af.a c(Object obj, Object obj1)
    {
        j.a(obj, obj1);
        return new af.a(obj, obj1);
    }

    public static ae h()
    {
        return y.g();
    }

    public static a i()
    {
        return new a();
    }

    aj a()
    {
        return new ah(this);
    }

    public aj b()
    {
        aj aj2 = b;
        aj aj1 = aj2;
        if (aj2 == null)
        {
            aj1 = c();
            b = aj1;
        }
        return aj1;
    }

    abstract aj c();

    public final void clear()
    {
        throw new UnsupportedOperationException();
    }

    public boolean containsKey(Object obj)
    {
        return get(obj) != null;
    }

    public boolean containsValue(Object obj)
    {
        return f().contains(obj);
    }

    public aj d()
    {
        aj aj2 = c;
        aj aj1 = aj2;
        if (aj2 == null)
        {
            aj1 = a();
            c = aj1;
        }
        return aj1;
    }

    abstract boolean e();

    public Set entrySet()
    {
        return b();
    }

    public boolean equals(Object obj)
    {
        return aq.d(this, obj);
    }

    public z f()
    {
        z z1 = d;
        Object obj = z1;
        if (z1 == null)
        {
            obj = new ai(this);
            d = ((z) (obj));
        }
        return ((z) (obj));
    }

    public abstract Object get(Object obj);

    public int hashCode()
    {
        return b().hashCode();
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    public Set keySet()
    {
        return d();
    }

    public final Object put(Object obj, Object obj1)
    {
        throw new UnsupportedOperationException();
    }

    public final void putAll(Map map)
    {
        throw new UnsupportedOperationException();
    }

    public final Object remove(Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public String toString()
    {
        return aq.a(this);
    }

    public Collection values()
    {
        return f();
    }

}
