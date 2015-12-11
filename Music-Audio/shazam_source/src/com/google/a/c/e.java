// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.a.c:
//            ar, bd, be

abstract class e
    implements ar
{
    private class a extends as.a
    {

        final e a;

        final ar a()
        {
            return a;
        }

        public Iterator iterator()
        {
            return a.f();
        }

        private a()
        {
            a = e.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

    private final class b extends a
        implements Set
    {

        final e b;

        public final boolean equals(Object obj)
        {
            return be.a(this, obj);
        }

        public final int hashCode()
        {
            return be.a(this);
        }

        private b()
        {
            b = e.this;
            super((byte)0);
        }

        b(byte byte0)
        {
            this();
        }
    }


    private transient Collection a;
    private transient Set b;
    private transient Map c;

    e()
    {
    }

    public boolean a(ar ar1)
    {
        ar1 = ar1.e().iterator();
        java.util.Map.Entry entry;
        boolean flag;
        for (flag = false; ar1.hasNext(); flag = a(entry.getKey(), entry.getValue()) | flag)
        {
            entry = (java.util.Map.Entry)ar1.next();
        }

        return flag;
    }

    public boolean a(Object obj, Object obj1)
    {
        return a(obj).add(obj1);
    }

    public boolean b(Object obj, Object obj1)
    {
        obj = (Collection)i().get(obj);
        return obj != null && ((Collection) (obj)).contains(obj1);
    }

    public boolean c(Object obj, Object obj1)
    {
        obj = (Collection)i().get(obj);
        return obj != null && ((Collection) (obj)).remove(obj1);
    }

    Set d()
    {
        return new aq.d(i());
    }

    public Collection e()
    {
        Collection collection = a;
        Object obj = collection;
        if (collection == null)
        {
            if (this instanceof bd)
            {
                obj = new b((byte)0);
            } else
            {
                obj = new a((byte)0);
            }
            a = ((Collection) (obj));
        }
        return ((Collection) (obj));
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj instanceof ar)
        {
            obj = (ar)obj;
            return i().equals(((ar) (obj)).i());
        } else
        {
            return false;
        }
    }

    abstract Iterator f();

    abstract Map g();

    public Set h()
    {
        Set set1 = b;
        Set set = set1;
        if (set1 == null)
        {
            set = d();
            b = set;
        }
        return set;
    }

    public int hashCode()
    {
        return i().hashCode();
    }

    public Map i()
    {
        Map map1 = c;
        Map map = map1;
        if (map1 == null)
        {
            map = g();
            c = map;
        }
        return map;
    }

    public String toString()
    {
        return i().toString();
    }
}
