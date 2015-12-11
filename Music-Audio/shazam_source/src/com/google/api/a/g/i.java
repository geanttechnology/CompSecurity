// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.g;

import com.google.api.a.f.a.a.a.a.c;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

// Referenced classes of package com.google.api.a.g:
//            f, w, k

final class i extends AbstractMap
{
    final class a
        implements java.util.Map.Entry
    {

        final i a;
        private Object b;
        private final k c;

        private String a()
        {
            String s1 = c.c;
            String s = s1;
            if (a.b.b)
            {
                s = s1.toLowerCase();
            }
            return s;
        }

        public final boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (!(obj instanceof java.util.Map.Entry))
                {
                    return false;
                }
                obj = (java.util.Map.Entry)obj;
                if (!a().equals(((java.util.Map.Entry) (obj)).getKey()) || !getValue().equals(((java.util.Map.Entry) (obj)).getValue()))
                {
                    return false;
                }
            }
            return true;
        }

        public final Object getKey()
        {
            return a();
        }

        public final Object getValue()
        {
            return b;
        }

        public final int hashCode()
        {
            return a().hashCode() ^ getValue().hashCode();
        }

        public final Object setValue(Object obj)
        {
            Object obj1 = b;
            b = com.google.api.a.f.a.a.a.a.c.a(obj);
            c.a(a.a, obj);
            return obj1;
        }

        a(k k1, Object obj)
        {
            a = i.this;
            super();
            c = k1;
            b = com.google.api.a.f.a.a.a.a.c.a(obj);
        }
    }

    final class b
        implements Iterator
    {

        final i a;
        private int b;
        private k c;
        private Object d;
        private boolean e;
        private boolean f;
        private k g;

        public final boolean hasNext()
        {
            if (!f)
            {
                f = true;
                d = null;
                do
                {
                    if (d != null)
                    {
                        break;
                    }
                    int j = b + 1;
                    b = j;
                    if (j >= a.b.d.size())
                    {
                        break;
                    }
                    c = a.b.a((String)a.b.d.get(b));
                    d = c.a(a.a);
                } while (true);
            }
            return d != null;
        }

        public final Object next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            } else
            {
                g = c;
                Object obj = d;
                f = false;
                e = false;
                c = null;
                d = null;
                return a. new a(g, obj);
            }
        }

        public final void remove()
        {
            boolean flag;
            if (g != null && !e)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            w.b(flag);
            e = true;
            g.a(a.a, null);
        }

        b()
        {
            a = i.this;
            super();
            b = -1;
        }
    }

    final class c extends AbstractSet
    {

        final i a;

        public final b a()
        {
            return a. new b();
        }

        public final void clear()
        {
            String s;
            for (Iterator iterator1 = a.b.d.iterator(); iterator1.hasNext(); a.b.a(s).a(a.a, null))
            {
                s = (String)iterator1.next();
            }

        }

        public final boolean isEmpty()
        {
            for (Iterator iterator1 = a.b.d.iterator(); iterator1.hasNext();)
            {
                String s = (String)iterator1.next();
                if (a.b.a(s).a(a.a) != null)
                {
                    return false;
                }
            }

            return true;
        }

        public final Iterator iterator()
        {
            return a();
        }

        public final int size()
        {
            Iterator iterator1 = a.b.d.iterator();
            int j = 0;
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                String s = (String)iterator1.next();
                if (a.b.a(s).a(a.a) != null)
                {
                    j++;
                }
            } while (true);
            return j;
        }

        c()
        {
            a = i.this;
            super();
        }
    }


    final Object a;
    final f b;

    i(Object obj, boolean flag)
    {
        a = obj;
        b = f.a(obj.getClass(), flag);
        if (!b.a.isEnum())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        w.a(flag);
    }

    public final c a()
    {
        return new c();
    }

    public final boolean containsKey(Object obj)
    {
        return get(obj) != null;
    }

    public final Set entrySet()
    {
        return a();
    }

    public final Object get(Object obj)
    {
        if (obj instanceof String)
        {
            if ((obj = b.a((String)obj)) != null)
            {
                return ((k) (obj)).a(a);
            }
        }
        return null;
    }

    public final Object put(Object obj, Object obj1)
    {
        obj = (String)obj;
        k k1 = b.a(((String) (obj)));
        obj = String.valueOf(obj);
        if (((String) (obj)).length() != 0)
        {
            obj = "no field of key ".concat(((String) (obj)));
        } else
        {
            obj = new String("no field of key ");
        }
        w.a(k1, obj);
        obj = k1.a(a);
        k1.a(a, com.google.api.a.f.a.a.a.a.c.a(obj1));
        return obj;
    }
}
