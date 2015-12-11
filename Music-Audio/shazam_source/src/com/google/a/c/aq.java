// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import com.google.a.a.f;
import com.google.a.a.g;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.a.c:
//            k, j, ap, aa, 
//            bk, be

public final class aq
{
    private static abstract class a extends Enum
        implements com.google.a.a.c
    {

        public static final a a;
        public static final a b;
        private static final a c[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/google/a/c/aq$a, s);
        }

        public static a[] values()
        {
            return (a[])c.clone();
        }

        static 
        {
            a = new a("KEY") {

                public final Object a(Object obj)
                {
                    return ((java.util.Map.Entry)obj).getKey();
                }

            };
            b = new a("VALUE") {

                public final Object a(Object obj)
                {
                    return ((java.util.Map.Entry)obj).getValue();
                }

            };
            c = (new a[] {
                a, b
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }

        a(String s, int i, byte byte0)
        {
            this(s, i);
        }
    }

    static abstract class b extends be.a
    {

        abstract Map a();

        public void clear()
        {
            a().clear();
        }

        public boolean contains(Object obj)
        {
            boolean flag;
label0:
            {
                boolean flag1 = false;
                flag = flag1;
                if (!(obj instanceof java.util.Map.Entry))
                {
                    break label0;
                }
                obj = (java.util.Map.Entry)obj;
                Object obj1 = ((java.util.Map.Entry) (obj)).getKey();
                Object obj2 = aq.a(a(), obj1);
                flag = flag1;
                if (!f.a(obj2, ((java.util.Map.Entry) (obj)).getValue()))
                {
                    break label0;
                }
                if (obj2 == null)
                {
                    flag = flag1;
                    if (!a().containsKey(obj1))
                    {
                        break label0;
                    }
                }
                flag = true;
            }
            return flag;
        }

        public boolean isEmpty()
        {
            return a().isEmpty();
        }

        public boolean remove(Object obj)
        {
            if (contains(obj))
            {
                obj = (java.util.Map.Entry)obj;
                return a().keySet().remove(((java.util.Map.Entry) (obj)).getKey());
            } else
            {
                return false;
            }
        }

        public boolean removeAll(Collection collection)
        {
            boolean flag;
            try
            {
                flag = super.removeAll((Collection)g.a(collection));
            }
            catch (UnsupportedOperationException unsupportedoperationexception)
            {
                return be.a(this, collection.iterator());
            }
            return flag;
        }

        public boolean retainAll(Collection collection)
        {
            boolean flag;
            try
            {
                flag = super.retainAll((Collection)g.a(collection));
            }
            catch (UnsupportedOperationException unsupportedoperationexception)
            {
                HashSet hashset = be.a(collection.size());
                collection = collection.iterator();
                do
                {
                    if (!collection.hasNext())
                    {
                        break;
                    }
                    Object obj = collection.next();
                    if (contains(obj))
                    {
                        hashset.add(((java.util.Map.Entry)obj).getKey());
                    }
                } while (true);
                return a().keySet().retainAll(hashset);
            }
            return flag;
        }

        public int size()
        {
            return a().size();
        }

        b()
        {
        }
    }

    static abstract class c extends AbstractMap
    {

        private transient Set a;
        private transient Set b;
        private transient Collection c;

        abstract Set a();

        Set b()
        {
            return new d(this);
        }

        public Set entrySet()
        {
            Set set1 = a;
            Set set = set1;
            if (set1 == null)
            {
                set = a();
                a = set;
            }
            return set;
        }

        public Set keySet()
        {
            Set set1 = b;
            Set set = set1;
            if (set1 == null)
            {
                set = b();
                b = set;
            }
            return set;
        }

        public Collection values()
        {
            Collection collection = c;
            Object obj = collection;
            if (collection == null)
            {
                obj = new e(this);
                c = ((Collection) (obj));
            }
            return ((Collection) (obj));
        }

        c()
        {
        }
    }

    static class d extends be.a
    {

        final Map c;

        public void clear()
        {
            c.clear();
        }

        public boolean contains(Object obj)
        {
            return c.containsKey(obj);
        }

        public boolean isEmpty()
        {
            return c.isEmpty();
        }

        public Iterator iterator()
        {
            return aq.a(c.entrySet().iterator());
        }

        public boolean remove(Object obj)
        {
            if (contains(obj))
            {
                c.remove(obj);
                return true;
            } else
            {
                return false;
            }
        }

        public int size()
        {
            return c.size();
        }

        d(Map map)
        {
            c = (Map)g.a(map);
        }
    }

    static final class e extends AbstractCollection
    {

        final Map a;

        public final void clear()
        {
            a.clear();
        }

        public final boolean contains(Object obj)
        {
            return a.containsValue(obj);
        }

        public final boolean isEmpty()
        {
            return a.isEmpty();
        }

        public final Iterator iterator()
        {
            return aq.b(a.entrySet().iterator());
        }

        public final boolean remove(Object obj)
        {
            boolean flag;
            try
            {
                flag = super.remove(obj);
            }
            catch (UnsupportedOperationException unsupportedoperationexception)
            {
                for (Iterator iterator1 = a.entrySet().iterator(); iterator1.hasNext();)
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator1.next();
                    if (f.a(obj, entry.getValue()))
                    {
                        a.remove(entry.getKey());
                        return true;
                    }
                }

                return false;
            }
            return flag;
        }

        public final boolean removeAll(Collection collection)
        {
            boolean flag;
            try
            {
                flag = super.removeAll((Collection)g.a(collection));
            }
            catch (UnsupportedOperationException unsupportedoperationexception)
            {
                HashSet hashset = new HashSet();
                Iterator iterator1 = a.entrySet().iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator1.next();
                    if (collection.contains(entry.getValue()))
                    {
                        hashset.add(entry.getKey());
                    }
                } while (true);
                return a.keySet().removeAll(hashset);
            }
            return flag;
        }

        public final boolean retainAll(Collection collection)
        {
            boolean flag;
            try
            {
                flag = super.retainAll((Collection)g.a(collection));
            }
            catch (UnsupportedOperationException unsupportedoperationexception)
            {
                HashSet hashset = new HashSet();
                Iterator iterator1 = a.entrySet().iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator1.next();
                    if (collection.contains(entry.getValue()))
                    {
                        hashset.add(entry.getKey());
                    }
                } while (true);
                return a.keySet().retainAll(hashset);
            }
            return flag;
        }

        public final int size()
        {
            return a.size();
        }

        e(Map map)
        {
            a = (Map)g.a(map);
        }
    }


    static final com.google.a.a.d.a a;

    static int a(int i)
    {
        if (i < 3)
        {
            j.a(i, "expectedSize");
            return i + 1;
        }
        if (i < 0x40000000)
        {
            return i / 3 + i;
        } else
        {
            return 0x7fffffff;
        }
    }

    static bk a(bk bk)
    {
        return new bk(bk) {

            final bk a;

            public final boolean hasNext()
            {
                return a.hasNext();
            }

            public final Object next()
            {
                return ((java.util.Map.Entry)a.next()).getValue();
            }

            
            {
                a = bk1;
                super();
            }
        };
    }

    static Object a(java.util.Map.Entry entry)
    {
        if (entry == null)
        {
            return null;
        } else
        {
            return entry.getKey();
        }
    }

    static Object a(Map map, Object obj)
    {
        g.a(map);
        try
        {
            map = ((Map) (map.get(obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return null;
        }
        return map;
    }

    static String a(Map map)
    {
        StringBuilder stringbuilder = k.a(map.size()).append('{');
        a.a(stringbuilder, map.entrySet().iterator());
        return stringbuilder.append('}').toString();
    }

    public static HashMap a()
    {
        return new HashMap();
    }

    static Iterator a(Iterator iterator)
    {
        return ap.a(iterator, a.a);
    }

    public static java.util.Map.Entry a(Object obj, Object obj1)
    {
        return new aa(obj, obj1);
    }

    static Iterator b(Iterator iterator)
    {
        return ap.a(iterator, a.b);
    }

    static boolean b(Map map, Object obj)
    {
        g.a(map);
        boolean flag;
        try
        {
            flag = map.containsKey(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return false;
        }
        return flag;
    }

    static Object c(Map map, Object obj)
    {
        g.a(map);
        try
        {
            map = ((Map) (map.remove(obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return null;
        }
        return map;
    }

    static boolean d(Map map, Object obj)
    {
        if (map == obj)
        {
            return true;
        }
        if (obj instanceof Map)
        {
            obj = (Map)obj;
            return map.entrySet().equals(((Map) (obj)).entrySet());
        } else
        {
            return false;
        }
    }

    static 
    {
        a = new com.google.a.a.d.a(k.a, "=", (byte)0);
    }
}
