// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.f;

import com.google.a.a.g;
import com.google.a.c.ad;
import com.google.a.c.ap;
import com.google.a.c.aq;
import com.google.a.c.aw;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.google.a.f:
//            c

private static abstract class <init>
{

    static final  a = new c.b() {

        final Class a(Object obj)
        {
            return com.google.a.f.c.c(((c)obj).a);
        }

        final Iterable b(Object obj)
        {
            obj = (c)obj;
            if (((c) (obj)).a instanceof TypeVariable)
            {
                return com.google.a.f.c.a(((TypeVariable)((c) (obj)).a).getBounds());
            }
            if (((c) (obj)).a instanceof WildcardType)
            {
                return com.google.a.f.c.a(((WildcardType)((c) (obj)).a).getUpperBounds());
            }
            com.google.a.c.ad.a a1 = ad.g();
            java.lang.reflect.Type atype[] = com.google.a.f.c.c(((c) (obj)).a).getGenericInterfaces();
            int j = atype.length;
            for (int i = 0; i < j; i++)
            {
                a1.c(((c) (obj)).a(atype[i]));
            }

            return a1.a();
        }

        final Object c(Object obj)
        {
            obj = (c)obj;
            if (((c) (obj)).a instanceof TypeVariable)
            {
                return com.google.a.f.c.b(((TypeVariable)((c) (obj)).a).getBounds()[0]);
            }
            if (((c) (obj)).a instanceof WildcardType)
            {
                return com.google.a.f.c.b(((WildcardType)((c) (obj)).a).getUpperBounds()[0]);
            }
            java.lang.reflect.Type type = com.google.a.f.c.c(((c) (obj)).a).getGenericSuperclass();
            if (type == null)
            {
                return null;
            } else
            {
                return ((c) (obj)).a(type);
            }
        }

    };
    static final ype b = new c.b() {

        final volatile Class a(Object obj)
        {
            return (Class)obj;
        }

        final Iterable b(Object obj)
        {
            return Arrays.asList(((Class)obj).getInterfaces());
        }

        final Object c(Object obj)
        {
            return ((Class)obj).getSuperclass();
        }

    };

    private int a(Object obj, Map map)
    {
        Object obj1 = (Integer)map.get(this);
        if (obj1 != null)
        {
            return ((Integer) (obj1)).intValue();
        }
        int i;
        if (a(obj).isInterface())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        for (obj1 = b(obj).iterator(); ((Iterator) (obj1)).hasNext();)
        {
            i = Math.max(i, a(((Iterator) (obj1)).next(), map));
        }

        obj1 = c(obj);
        int j = i;
        if (obj1 != null)
        {
            j = Math.max(i, a(obj1, map));
        }
        map.put(obj, Integer.valueOf(j + 1));
        return j + 1;
    }

    final ad a(Iterable iterable)
    {
        java.util.HashMap hashmap = aq.a();
        for (iterable = iterable.iterator(); iterable.hasNext(); a(iterable.next(), ((Map) (hashmap)))) { }
        aw aw1 = new aw(aw.b().a(), hashmap) {

            final Comparator a;
            final Map b;

            public final int compare(Object obj, Object obj1)
            {
                return a.compare(b.get(obj), b.get(obj1));
            }

            
            {
                a = comparator;
                b = map;
                super();
            }
        };
        iterable = hashmap.keySet();
        int j;
        if (iterable instanceof Collection)
        {
            iterable = (Collection)iterable;
        } else
        {
            Iterator iterator = iterable.iterator();
            iterable = new ArrayList();
            ap.a(iterable, iterator);
        }
        iterable = ((Iterable) ((Object[])iterable.toArray()));
        j = iterable.length;
        for (int i = 0; i < j; i++)
        {
            g.a(iterable[i]);
        }

        Arrays.sort(iterable, aw1);
        return ad.b(iterable);
    }

    abstract Class a(Object obj);

    abstract Iterable b(Object obj);

    abstract Object c(Object obj);


    private init>()
    {
    }

    init>(byte byte0)
    {
        this();
    }
}
