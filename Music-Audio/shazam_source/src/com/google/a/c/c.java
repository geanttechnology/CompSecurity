// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import com.google.a.a.g;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

// Referenced classes of package com.google.a.c:
//            e, aq, ap, k, 
//            be

abstract class com.google.a.c.c extends com.google.a.c.e
    implements Serializable
{
    private class a extends aq.c
    {

        final transient Map a;
        final com.google.a.c.c b;

        protected final Set a()
        {
            return new a(this);
        }

        public void clear()
        {
            if (a == com.google.a.c.c.a(b))
            {
                b.c();
                return;
            } else
            {
                ap.e(new b(this));
                return;
            }
        }

        public boolean containsKey(Object obj)
        {
            return aq.b(a, obj);
        }

        public boolean equals(Object obj)
        {
            return this == obj || a.equals(obj);
        }

        public Object get(Object obj)
        {
            Collection collection = (Collection)aq.a(a, obj);
            if (collection == null)
            {
                return null;
            } else
            {
                return b.a(obj, collection);
            }
        }

        public int hashCode()
        {
            return a.hashCode();
        }

        public Set keySet()
        {
            return b.h();
        }

        public Object remove(Object obj)
        {
            obj = (Collection)a.remove(obj);
            if (obj == null)
            {
                return null;
            } else
            {
                Collection collection = b.a();
                collection.addAll(((Collection) (obj)));
                com.google.a.c.c.b(b, ((Collection) (obj)).size());
                ((Collection) (obj)).clear();
                return collection;
            }
        }

        public int size()
        {
            return a.size();
        }

        public String toString()
        {
            return a.toString();
        }

        a(Map map)
        {
            b = com.google.a.c.c.this;
            super();
            a = map;
        }
    }

    final class a.a extends aq.b
    {

        final a a;

        final Map a()
        {
            return a;
        }

        public final boolean contains(Object obj)
        {
            return k.a(a.a.entrySet(), obj);
        }

        public final Iterator iterator()
        {
            return new a.b(a);
        }

        public final boolean remove(Object obj)
        {
            if (!contains(obj))
            {
                return false;
            } else
            {
                obj = (java.util.Map.Entry)obj;
                com.google.a.c.c.a(a.b, ((java.util.Map.Entry) (obj)).getKey());
                return true;
            }
        }

        a.a(a a1)
        {
            a = a1;
            super();
        }
    }

    final class a.b
        implements Iterator
    {

        final Iterator a;
        Collection b;
        final a c;

        public final boolean hasNext()
        {
            return a.hasNext();
        }

        public final Object next()
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)a.next();
            b = (Collection)entry.getValue();
            a a1 = c;
            Object obj = entry.getKey();
            return aq.a(obj, a1.b.a(obj, (Collection)entry.getValue()));
        }

        public final void remove()
        {
            a.remove();
            com.google.a.c.c.b(c.b, b.size());
            b.clear();
        }

        a.b(a a1)
        {
            c = a1;
            super();
            a = c.a.entrySet().iterator();
        }
    }

    private abstract class b
        implements Iterator
    {

        final Iterator b;
        Object c;
        Collection d;
        Iterator e;
        final com.google.a.c.c f;

        abstract Object a(Object obj, Object obj1);

        public boolean hasNext()
        {
            return b.hasNext() || e.hasNext();
        }

        public Object next()
        {
            if (!e.hasNext())
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)b.next();
                c = entry.getKey();
                d = (Collection)entry.getValue();
                e = d.iterator();
            }
            return a(c, e.next());
        }

        public void remove()
        {
            e.remove();
            if (d.isEmpty())
            {
                b.remove();
            }
            com.google.a.c.c.b(f);
        }

        b()
        {
            f = com.google.a.c.c.this;
            super();
            b = com.google.a.c.c.a(com.google.a.c.c.this).entrySet().iterator();
            c = null;
            d = null;
            e = ap.b();
        }
    }

    private class c extends aq.d
    {

        final com.google.a.c.c a;

        public void clear()
        {
            ap.e(iterator());
        }

        public boolean containsAll(Collection collection)
        {
            return super.c.keySet().containsAll(collection);
        }

        public boolean equals(Object obj)
        {
            return this == obj || super.c.keySet().equals(obj);
        }

        public int hashCode()
        {
            return super.c.keySet().hashCode();
        }

        public Iterator iterator()
        {
            return new Iterator(this, super.c.entrySet().iterator()) {

                java.util.Map.Entry a;
                final Iterator b;
                final c c;

                public final boolean hasNext()
                {
                    return b.hasNext();
                }

                public final Object next()
                {
                    a = (java.util.Map.Entry)b.next();
                    return a.getKey();
                }

                public final void remove()
                {
                    Collection collection;
                    boolean flag;
                    if (a != null)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    com.google.a.a.g.b(flag, "no calls to next() since the last call to remove()");
                    collection = (Collection)a.getValue();
                    b.remove();
                    com.google.a.c.c.b(c.a, collection.size());
                    collection.clear();
                }

            
            {
                c = c1;
                b = iterator;
                super();
            }
            };
        }

        public boolean remove(Object obj)
        {
            obj = (Collection)super.c.remove(obj);
            int k;
            if (obj != null)
            {
                k = ((Collection) (obj)).size();
                ((Collection) (obj)).clear();
                com.google.a.c.c.b(a, k);
            } else
            {
                k = 0;
            }
            return k > 0;
        }

        c(Map map)
        {
            a = com.google.a.c.c.this;
            super(map);
        }
    }

    private final class d extends h
        implements RandomAccess
    {

        final com.google.a.c.c a;

        d(Object obj, List list, g g1)
        {
            a = com.google.a.c.c.this;
            super(obj, list, g1);
        }
    }

    private final class e extends a
        implements SortedMap
    {

        SortedSet c;
        final com.google.a.c.c d;

        private SortedSet c()
        {
            return d. new f((SortedMap)a);
        }

        final Set b()
        {
            return c();
        }

        public final Comparator comparator()
        {
            return ((SortedMap)a).comparator();
        }

        public final Object firstKey()
        {
            return ((SortedMap)a).firstKey();
        }

        public final SortedMap headMap(Object obj)
        {
            return d. new e(((SortedMap)a).headMap(obj));
        }

        public final Set keySet()
        {
            SortedSet sortedset1 = c;
            SortedSet sortedset = sortedset1;
            if (sortedset1 == null)
            {
                sortedset = c();
                c = sortedset;
            }
            return sortedset;
        }

        public final Object lastKey()
        {
            return ((SortedMap)a).lastKey();
        }

        public final SortedMap subMap(Object obj, Object obj1)
        {
            return d. new e(((SortedMap)a).subMap(obj, obj1));
        }

        public final SortedMap tailMap(Object obj)
        {
            return d. new e(((SortedMap)a).tailMap(obj));
        }

        e(SortedMap sortedmap)
        {
            d = com.google.a.c.c.this;
            super(sortedmap);
        }
    }

    private final class f extends c
        implements SortedSet
    {

        final com.google.a.c.c b;

        public final Comparator comparator()
        {
            return ((SortedMap)super.c).comparator();
        }

        public final Object first()
        {
            return ((SortedMap)super.c).firstKey();
        }

        public final SortedSet headSet(Object obj)
        {
            return b. new f(((SortedMap)super.c).headMap(obj));
        }

        public final Object last()
        {
            return ((SortedMap)super.c).lastKey();
        }

        public final SortedSet subSet(Object obj, Object obj1)
        {
            return b. new f(((SortedMap)super.c).subMap(obj, obj1));
        }

        public final SortedSet tailSet(Object obj)
        {
            return b. new f(((SortedMap)super.c).tailMap(obj));
        }

        f(SortedMap sortedmap)
        {
            b = com.google.a.c.c.this;
            super(sortedmap);
        }
    }

    private class g extends AbstractCollection
    {

        final Object b;
        Collection c;
        final g d;
        final Collection e;
        final com.google.a.c.c f;

        final void a()
        {
            if (d != null)
            {
                d.a();
                if (d.c != e)
                {
                    throw new ConcurrentModificationException();
                }
            } else
            if (c.isEmpty())
            {
                Collection collection = (Collection)com.google.a.c.c.a(f).get(b);
                if (collection != null)
                {
                    c = collection;
                }
            }
        }

        public boolean add(Object obj)
        {
            a();
            boolean flag = c.isEmpty();
            boolean flag1 = c.add(obj);
            if (flag1)
            {
                com.google.a.c.c.c(f);
                if (flag)
                {
                    c();
                }
            }
            return flag1;
        }

        public boolean addAll(Collection collection)
        {
            boolean flag;
            if (collection.isEmpty())
            {
                flag = false;
            } else
            {
                int k = size();
                boolean flag1 = c.addAll(collection);
                flag = flag1;
                if (flag1)
                {
                    int l = c.size();
                    com.google.a.c.c.a(f, l - k);
                    flag = flag1;
                    if (k == 0)
                    {
                        c();
                        return flag1;
                    }
                }
            }
            return flag;
        }

        final void b()
        {
            g g1;
            for (g1 = this; g1.d != null; g1 = g1.d) { }
            if (g1.c.isEmpty())
            {
                com.google.a.c.c.a(g1.f).remove(g1.b);
            }
        }

        final void c()
        {
            g g1;
            for (g1 = this; g1.d != null; g1 = g1.d) { }
            com.google.a.c.c.a(g1.f).put(g1.b, g1.c);
        }

        public void clear()
        {
            int k = size();
            if (k == 0)
            {
                return;
            } else
            {
                c.clear();
                com.google.a.c.c.b(f, k);
                b();
                return;
            }
        }

        public boolean contains(Object obj)
        {
            a();
            return c.contains(obj);
        }

        public boolean containsAll(Collection collection)
        {
            a();
            return c.containsAll(collection);
        }

        public boolean equals(Object obj)
        {
            if (obj == this)
            {
                return true;
            } else
            {
                a();
                return c.equals(obj);
            }
        }

        public int hashCode()
        {
            a();
            return c.hashCode();
        }

        public Iterator iterator()
        {
            a();
            return new a(this);
        }

        public boolean remove(Object obj)
        {
            a();
            boolean flag = c.remove(obj);
            if (flag)
            {
                com.google.a.c.c.b(f);
                b();
            }
            return flag;
        }

        public boolean removeAll(Collection collection)
        {
            boolean flag;
            if (collection.isEmpty())
            {
                flag = false;
            } else
            {
                int k = size();
                boolean flag1 = c.removeAll(collection);
                flag = flag1;
                if (flag1)
                {
                    int l = c.size();
                    com.google.a.c.c.a(f, l - k);
                    b();
                    return flag1;
                }
            }
            return flag;
        }

        public boolean retainAll(Collection collection)
        {
            com.google.a.a.g.a(collection);
            int k = size();
            boolean flag = c.retainAll(collection);
            if (flag)
            {
                int l = c.size();
                com.google.a.c.c.a(f, l - k);
                b();
            }
            return flag;
        }

        public int size()
        {
            a();
            return c.size();
        }

        public String toString()
        {
            a();
            return c.toString();
        }

        g(Object obj, Collection collection, g g1)
        {
            f = com.google.a.c.c.this;
            super();
            b = obj;
            c = collection;
            d = g1;
            if (g1 == null)
            {
                c1 = null;
            } else
            {
                c1 = g1.c;
            }
            e = com.google.a.c.c.this;
        }
    }

    class g.a
        implements Iterator
    {

        final Iterator a;
        final Collection b;
        final g c;

        final void a()
        {
            c.a();
            if (c.c != b)
            {
                throw new ConcurrentModificationException();
            } else
            {
                return;
            }
        }

        public boolean hasNext()
        {
            a();
            return a.hasNext();
        }

        public Object next()
        {
            a();
            return a.next();
        }

        public void remove()
        {
            a.remove();
            com.google.a.c.c.b(c.f);
            c.b();
        }

        g.a(g g1)
        {
            c = g1;
            super();
            b = c.c;
            a = com.google.a.c.c.a(g1.c);
        }

        g.a(g g1, Iterator iterator)
        {
            c = g1;
            super();
            b = c.c;
            a = iterator;
        }
    }

    private class h extends g
        implements List
    {

        final com.google.a.c.c g;

        public void add(int k, Object obj)
        {
            a();
            boolean flag = super.c.isEmpty();
            ((List)super.c).add(k, obj);
            com.google.a.c.c.c(g);
            if (flag)
            {
                c();
            }
        }

        public boolean addAll(int k, Collection collection)
        {
            boolean flag;
            if (collection.isEmpty())
            {
                flag = false;
            } else
            {
                int l = size();
                boolean flag1 = ((List)super.c).addAll(k, collection);
                flag = flag1;
                if (flag1)
                {
                    k = super.c.size();
                    com.google.a.c.c.a(g, k - l);
                    flag = flag1;
                    if (l == 0)
                    {
                        c();
                        return flag1;
                    }
                }
            }
            return flag;
        }

        public Object get(int k)
        {
            a();
            return ((List)super.c).get(k);
        }

        public int indexOf(Object obj)
        {
            a();
            return ((List)super.c).indexOf(obj);
        }

        public int lastIndexOf(Object obj)
        {
            a();
            return ((List)super.c).lastIndexOf(obj);
        }

        public ListIterator listIterator()
        {
            a();
            return new a(this);
        }

        public ListIterator listIterator(int k)
        {
            a();
            return new a(this, k);
        }

        public Object remove(int k)
        {
            a();
            Object obj = ((List)super.c).remove(k);
            com.google.a.c.c.b(g);
            b();
            return obj;
        }

        public Object set(int k, Object obj)
        {
            a();
            return ((List)super.c).set(k, obj);
        }

        public List subList(int k, int l)
        {
            a();
            com.google.a.c.c c1 = g;
            Object obj1 = super.b;
            List list = ((List)super.c).subList(k, l);
            Object obj;
            if (super.d == null)
            {
                obj = this;
            } else
            {
                obj = super.d;
            }
            return com.google.a.c.c.a(c1, obj1, list, ((g) (obj)));
        }

        h(Object obj, List list, g g1)
        {
            g = com.google.a.c.c.this;
            super(obj, list, g1);
        }
    }

    private final class h.a extends g.a
        implements ListIterator
    {

        final h d;

        private ListIterator b()
        {
            ((g.a)this).a();
            return (ListIterator)super.a;
        }

        public final void add(Object obj)
        {
            boolean flag = d.isEmpty();
            b().add(obj);
            com.google.a.c.c.c(d.g);
            if (flag)
            {
                d.c();
            }
        }

        public final boolean hasPrevious()
        {
            return b().hasPrevious();
        }

        public final int nextIndex()
        {
            return b().nextIndex();
        }

        public final Object previous()
        {
            return b().previous();
        }

        public final int previousIndex()
        {
            return b().previousIndex();
        }

        public final void set(Object obj)
        {
            b().set(obj);
        }

        h.a(h h1)
        {
            d = h1;
            super(h1);
        }

        public h.a(h h1, int k)
        {
            d = h1;
            super(h1, ((List)((g) (h1)).c).listIterator(k));
        }
    }

    private final class i extends g
        implements Set
    {

        final com.google.a.c.c a;

        public final boolean removeAll(Collection collection)
        {
            boolean flag;
            if (collection.isEmpty())
            {
                flag = false;
            } else
            {
                int k = size();
                boolean flag1 = be.a((Set)c, collection);
                flag = flag1;
                if (flag1)
                {
                    int l = c.size();
                    com.google.a.c.c.a(a, l - k);
                    b();
                    return flag1;
                }
            }
            return flag;
        }

        i(Object obj, Set set)
        {
            a = com.google.a.c.c.this;
            super(obj, set, null);
        }
    }

    private final class j extends g
        implements SortedSet
    {

        final com.google.a.c.c a;

        public final Comparator comparator()
        {
            return ((SortedSet)super.c).comparator();
        }

        public final Object first()
        {
            a();
            return ((SortedSet)super.c).first();
        }

        public final SortedSet headSet(Object obj)
        {
            a();
            com.google.a.c.c c1 = a;
            Object obj1 = super.b;
            SortedSet sortedset = ((SortedSet)super.c).headSet(obj);
            if (super.d == null)
            {
                obj = this;
            } else
            {
                obj = super.d;
            }
            return c1. new j(obj1, sortedset, ((g) (obj)));
        }

        public final Object last()
        {
            a();
            return ((SortedSet)super.c).last();
        }

        public final SortedSet subSet(Object obj, Object obj1)
        {
            a();
            com.google.a.c.c c1 = a;
            Object obj2 = super.b;
            obj1 = ((SortedSet)super.c).subSet(obj, obj1);
            if (super.d == null)
            {
                obj = this;
            } else
            {
                obj = super.d;
            }
            return c1. new j(obj2, ((SortedSet) (obj1)), ((g) (obj)));
        }

        public final SortedSet tailSet(Object obj)
        {
            a();
            com.google.a.c.c c1 = a;
            Object obj1 = super.b;
            SortedSet sortedset = ((SortedSet)super.c).tailSet(obj);
            if (super.d == null)
            {
                obj = this;
            } else
            {
                obj = super.d;
            }
            return c1. new j(obj1, sortedset, ((g) (obj)));
        }

        j(Object obj, SortedSet sortedset, g g1)
        {
            a = com.google.a.c.c.this;
            super(obj, sortedset, g1);
        }
    }


    private transient Map a;
    private transient int b;

    protected com.google.a.c.c(Map map)
    {
        com.google.a.a.g.a(map.isEmpty());
        a = map;
    }

    static int a(com.google.a.c.c c1, int k)
    {
        k = c1.b + k;
        c1.b = k;
        return k;
    }

    static int a(com.google.a.c.c c1, Object obj)
    {
        obj = (Collection)aq.c(c1.a, obj);
        int k = 0;
        if (obj != null)
        {
            k = ((Collection) (obj)).size();
            ((Collection) (obj)).clear();
            c1.b = c1.b - k;
        }
        return k;
    }

    static Iterator a(Collection collection)
    {
        if (collection instanceof List)
        {
            return ((List)collection).listIterator();
        } else
        {
            return collection.iterator();
        }
    }

    static List a(com.google.a.c.c c1, Object obj, List list, g g1)
    {
        return c1.a(obj, list, g1);
    }

    private List a(Object obj, List list, g g1)
    {
        if (list instanceof RandomAccess)
        {
            return new d(obj, list, g1);
        } else
        {
            return new h(obj, list, g1);
        }
    }

    static Map a(com.google.a.c.c c1)
    {
        return c1.a;
    }

    static int b(com.google.a.c.c c1)
    {
        int k = c1.b;
        c1.b = k - 1;
        return k;
    }

    static int b(com.google.a.c.c c1, int k)
    {
        k = c1.b - k;
        c1.b = k;
        return k;
    }

    static int c(com.google.a.c.c c1)
    {
        int k = c1.b;
        c1.b = k + 1;
        return k;
    }

    abstract Collection a();

    public Collection a(Object obj)
    {
        Collection collection1 = (Collection)a.get(obj);
        Collection collection = collection1;
        if (collection1 == null)
        {
            collection = a();
        }
        return a(obj, collection);
    }

    final Collection a(Object obj, Collection collection)
    {
        if (collection instanceof SortedSet)
        {
            return new j(obj, (SortedSet)collection, null);
        }
        if (collection instanceof Set)
        {
            return new i(obj, (Set)collection);
        }
        if (collection instanceof List)
        {
            return a(obj, (List)collection, null);
        } else
        {
            return new g(obj, collection, null);
        }
    }

    public boolean a(Object obj, Object obj1)
    {
        Collection collection = (Collection)a.get(obj);
        if (collection == null)
        {
            collection = a();
            if (collection.add(obj1))
            {
                b = b + 1;
                a.put(obj, collection);
                return true;
            } else
            {
                throw new AssertionError("New Collection violated the Collection spec");
            }
        }
        if (collection.add(obj1))
        {
            b = b + 1;
            return true;
        } else
        {
            return false;
        }
    }

    public int b()
    {
        return b;
    }

    public void c()
    {
        for (Iterator iterator = a.values().iterator(); iterator.hasNext(); ((Collection)iterator.next()).clear()) { }
        a.clear();
        b = 0;
    }

    final Set d()
    {
        if (a instanceof SortedMap)
        {
            return new f((SortedMap)a);
        } else
        {
            return new c(a);
        }
    }

    public Collection e()
    {
        return super.e();
    }

    final Iterator f()
    {
        return new b() {

            final com.google.a.c.c a;

            final volatile Object a(Object obj, Object obj1)
            {
                return aq.a(obj, obj1);
            }

            
            {
                a = com.google.a.c.c.this;
                super();
            }
        };
    }

    final Map g()
    {
        if (a instanceof SortedMap)
        {
            return new e((SortedMap)a);
        } else
        {
            return new a(a);
        }
    }
}
