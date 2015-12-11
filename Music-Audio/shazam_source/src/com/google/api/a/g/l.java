// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.g;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.api.a.g:
//            a, f, h, k, 
//            i

public class l extends AbstractMap
    implements Cloneable
{
    final class a
        implements Iterator
    {

        final l a;
        private boolean b;
        private final Iterator c;
        private final Iterator d;

        public final boolean hasNext()
        {
            return c.hasNext() || d.hasNext();
        }

        public final Object next()
        {
            if (!b)
            {
                if (c.hasNext())
                {
                    return (java.util.Map.Entry)c.next();
                }
                b = true;
            }
            return (java.util.Map.Entry)d.next();
        }

        public final void remove()
        {
            if (b)
            {
                d.remove();
            }
            c.remove();
        }

        a(i.c c1)
        {
            a = l.this;
            super();
            c = c1.a();
            d = unknownFields.entrySet().iterator();
        }
    }

    final class b extends AbstractSet
    {

        final l a;
        private final i.c b;

        public final void clear()
        {
            a.unknownFields.clear();
            b.clear();
        }

        public final Iterator iterator()
        {
            return a. new a(b);
        }

        public final int size()
        {
            return a.unknownFields.size() + b.size();
        }

        b()
        {
            a = l.this;
            super();
            b = (new i(l.this, classInfo.b)).a();
        }
    }

    public static final class c extends Enum
    {

        public static final c a;
        private static final c b[];

        public static c valueOf(String s)
        {
            return (c)Enum.valueOf(com/google/api/a/g/l$c, s);
        }

        public static c[] values()
        {
            return (c[])b.clone();
        }

        static 
        {
            a = new c("IGNORE_CASE");
            b = (new c[] {
                a
            });
        }

        private c(String s)
        {
            super(s, 0);
        }
    }


    final f classInfo;
    Map unknownFields;

    public l()
    {
        this(EnumSet.noneOf(com/google/api/a/g/l$c));
    }

    public l(EnumSet enumset)
    {
        unknownFields = com.google.api.a.g.a.a();
        classInfo = f.a(getClass(), enumset.contains(c.a));
    }

    public l clone()
    {
        l l1;
        try
        {
            l1 = (l)super.clone();
            h.a(this, l1);
            l1.unknownFields = (Map)h.c(unknownFields);
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            throw new IllegalStateException(clonenotsupportedexception);
        }
        return l1;
    }

    public volatile Object clone()
    {
        return clone();
    }

    public Set entrySet()
    {
        return new b();
    }

    public final Object get(Object obj)
    {
        if (!(obj instanceof String))
        {
            return null;
        }
        String s = (String)obj;
        obj = classInfo.a(s);
        if (obj != null)
        {
            return ((k) (obj)).a(this);
        }
        obj = s;
        if (classInfo.b)
        {
            obj = s.toLowerCase();
        }
        return unknownFields.get(obj);
    }

    public final f getClassInfo()
    {
        return classInfo;
    }

    public final Map getUnknownKeys()
    {
        return unknownFields;
    }

    public volatile Object put(Object obj, Object obj1)
    {
        return put((String)obj, obj1);
    }

    public final Object put(String s, Object obj)
    {
        Object obj1 = classInfo.a(s);
        if (obj1 != null)
        {
            s = ((String) (((k) (obj1)).a(this)));
            ((k) (obj1)).a(this, obj);
            return s;
        }
        obj1 = s;
        if (classInfo.b)
        {
            obj1 = s.toLowerCase();
        }
        return unknownFields.put(obj1, obj);
    }

    public final void putAll(Map map)
    {
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); set((String)entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

    }

    public final Object remove(Object obj)
    {
        if (!(obj instanceof String))
        {
            return null;
        }
        String s = (String)obj;
        if (classInfo.a(s) != null)
        {
            throw new UnsupportedOperationException();
        }
        obj = s;
        if (classInfo.b)
        {
            obj = s.toLowerCase();
        }
        return unknownFields.remove(obj);
    }

    public l set(String s, Object obj)
    {
        Object obj1 = classInfo.a(s);
        if (obj1 != null)
        {
            ((k) (obj1)).a(this, obj);
            return this;
        }
        obj1 = s;
        if (classInfo.b)
        {
            obj1 = s.toLowerCase();
        }
        unknownFields.put(obj1, obj);
        return this;
    }

    public final void setUnknownKeys(Map map)
    {
        unknownFields = map;
    }
}
