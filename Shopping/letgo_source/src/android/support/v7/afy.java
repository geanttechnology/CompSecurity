// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public final class afy extends AbstractMap
    implements Serializable
{
    class a extends AbstractSet
    {

        final afy a;

        public void clear()
        {
            a.clear();
        }

        public boolean contains(Object obj)
        {
            return (obj instanceof java.util.Map.Entry) && a.a((java.util.Map.Entry)obj) != null;
        }

        public Iterator iterator()
        {
            return new c(this) {

                final a a;

                public java.util.Map.Entry a()
                {
                    return b();
                }

                public Object next()
                {
                    return a();
                }

            
            {
                a = a1;
                a1.a. super();
            }
            };
        }

        public boolean remove(Object obj)
        {
            if (obj instanceof java.util.Map.Entry)
            {
                if ((obj = a.a((java.util.Map.Entry)obj)) != null)
                {
                    a.a(((d) (obj)), true);
                    return true;
                }
            }
            return false;
        }

        public int size()
        {
            return a.c;
        }

        a()
        {
            a = afy.this;
            super();
        }
    }

    final class b extends AbstractSet
    {

        final afy a;

        public void clear()
        {
            a.clear();
        }

        public boolean contains(Object obj)
        {
            return a.containsKey(obj);
        }

        public Iterator iterator()
        {
            return new c(this) {

                final b a;

                public Object next()
                {
                    return b().f;
                }

            
            {
                a = b1;
                b1.a. super();
            }
            };
        }

        public boolean remove(Object obj)
        {
            return a.b(obj) != null;
        }

        public int size()
        {
            return a.c;
        }

        b()
        {
            a = afy.this;
            super();
        }
    }

    private abstract class c
        implements Iterator
    {

        d b;
        d c;
        int d;
        final afy e;

        final d b()
        {
            d d1 = b;
            if (d1 == e.e)
            {
                throw new NoSuchElementException();
            }
            if (e.d != d)
            {
                throw new ConcurrentModificationException();
            } else
            {
                b = d1.d;
                c = d1;
                return d1;
            }
        }

        public final boolean hasNext()
        {
            return b != e.e;
        }

        public final void remove()
        {
            if (c == null)
            {
                throw new IllegalStateException();
            } else
            {
                e.a(c, true);
                c = null;
                d = e.d;
                return;
            }
        }

        private c()
        {
            e = afy.this;
            super();
            b = e.e.d;
            c = null;
            d = e.d;
        }

    }

    static final class d
        implements java.util.Map.Entry
    {

        d a;
        d b;
        d c;
        d d;
        d e;
        final Object f;
        Object g;
        int h;

        public d a()
        {
            d d1 = b;
            d d2 = this;
            d d3;
            for (; d1 != null; d1 = d3)
            {
                d3 = d1.b;
                d2 = d1;
            }

            return d2;
        }

        public d b()
        {
            d d1 = c;
            d d2 = this;
            d d3;
            for (; d1 != null; d1 = d3)
            {
                d3 = d1.c;
                d2 = d1;
            }

            return d2;
        }

        public boolean equals(Object obj)
        {
            boolean flag;
            boolean flag1;
            flag1 = false;
            flag = flag1;
            if (!(obj instanceof java.util.Map.Entry)) goto _L2; else goto _L1
_L1:
            obj = (java.util.Map.Entry)obj;
            if (f != null) goto _L4; else goto _L3
_L3:
            flag = flag1;
            if (((java.util.Map.Entry) (obj)).getKey() != null) goto _L2; else goto _L5
_L5:
            if (g != null) goto _L7; else goto _L6
_L6:
            flag = flag1;
            if (((java.util.Map.Entry) (obj)).getValue() != null) goto _L2; else goto _L8
_L8:
            flag = true;
_L2:
            return flag;
_L4:
            flag = flag1;
            if (!f.equals(((java.util.Map.Entry) (obj)).getKey())) goto _L2; else goto _L5
_L7:
            flag = flag1;
            if (!g.equals(((java.util.Map.Entry) (obj)).getValue())) goto _L2; else goto _L8
        }

        public Object getKey()
        {
            return f;
        }

        public Object getValue()
        {
            return g;
        }

        public int hashCode()
        {
            int k = 0;
            int j;
            if (f == null)
            {
                j = 0;
            } else
            {
                j = f.hashCode();
            }
            if (g != null)
            {
                k = g.hashCode();
            }
            return j ^ k;
        }

        public Object setValue(Object obj)
        {
            Object obj1 = g;
            g = obj;
            return obj1;
        }

        public String toString()
        {
            return (new StringBuilder()).append(f).append("=").append(g).toString();
        }

        d()
        {
            f = null;
            e = this;
            d = this;
        }

        d(d d1, Object obj, d d2, d d3)
        {
            a = d1;
            f = obj;
            h = 1;
            d = d2;
            e = d3;
            d3.d = this;
            d2.e = this;
        }
    }


    static final boolean f;
    private static final Comparator g = new Comparator() {

        public int a(Comparable comparable, Comparable comparable1)
        {
            return comparable.compareTo(comparable1);
        }

        public int compare(Object obj, Object obj1)
        {
            return a((Comparable)obj, (Comparable)obj1);
        }

    };
    Comparator a;
    d b;
    int c;
    int d;
    final d e;
    private a h;
    private b i;

    public afy()
    {
        this(g);
    }

    public afy(Comparator comparator)
    {
        c = 0;
        d = 0;
        e = new d();
        if (comparator == null)
        {
            comparator = g;
        }
        a = comparator;
    }

    private void a(d d1)
    {
        boolean flag = false;
        d d2 = d1.b;
        d d3 = d1.c;
        d d4 = d3.b;
        d d5 = d3.c;
        d1.c = d4;
        if (d4 != null)
        {
            d4.a = d1;
        }
        a(d1, d3);
        d3.b = d1;
        d1.a = d3;
        int j;
        int k;
        if (d2 != null)
        {
            j = d2.h;
        } else
        {
            j = 0;
        }
        if (d4 != null)
        {
            k = d4.h;
        } else
        {
            k = 0;
        }
        d1.h = Math.max(j, k) + 1;
        k = d1.h;
        j = ((flag) ? 1 : 0);
        if (d5 != null)
        {
            j = d5.h;
        }
        d3.h = Math.max(k, j) + 1;
    }

    private void a(d d1, d d2)
    {
        d d3 = d1.a;
        d1.a = null;
        if (d2 != null)
        {
            d2.a = d3;
        }
        if (d3 != null)
        {
            if (d3.b == d1)
            {
                d3.b = d2;
                return;
            }
            if (!f && d3.c != d1)
            {
                throw new AssertionError();
            } else
            {
                d3.c = d2;
                return;
            }
        } else
        {
            b = d2;
            return;
        }
    }

    private boolean a(Object obj, Object obj1)
    {
        return obj == obj1 || obj != null && obj.equals(obj1);
    }

    private void b(d d1)
    {
        boolean flag = false;
        d d2 = d1.b;
        d d3 = d1.c;
        d d4 = d2.b;
        d d5 = d2.c;
        d1.b = d5;
        if (d5 != null)
        {
            d5.a = d1;
        }
        a(d1, d2);
        d2.c = d1;
        d1.a = d2;
        int j;
        int k;
        if (d3 != null)
        {
            j = d3.h;
        } else
        {
            j = 0;
        }
        if (d5 != null)
        {
            k = d5.h;
        } else
        {
            k = 0;
        }
        d1.h = Math.max(j, k) + 1;
        k = d1.h;
        j = ((flag) ? 1 : 0);
        if (d4 != null)
        {
            j = d4.h;
        }
        d2.h = Math.max(k, j) + 1;
    }

    private void b(d d1, boolean flag)
    {
_L11:
        if (d1 == null) goto _L2; else goto _L1
_L1:
        d d2;
        d d3;
        int j;
        int k;
        int l;
        d2 = d1.b;
        d3 = d1.c;
        d d5;
        if (d2 != null)
        {
            j = d2.h;
        } else
        {
            j = 0;
        }
        if (d3 != null)
        {
            k = d3.h;
        } else
        {
            k = 0;
        }
        l = j - k;
        if (l != -2) goto _L4; else goto _L3
_L3:
        d2 = d3.b;
        d5 = d3.c;
        if (d5 != null)
        {
            j = d5.h;
        } else
        {
            j = 0;
        }
        if (d2 != null)
        {
            k = d2.h;
        } else
        {
            k = 0;
        }
        j = k - j;
        if (j == -1 || j == 0 && !flag)
        {
            a(d1);
        } else
        {
            if (!f && j != 1)
            {
                throw new AssertionError();
            }
            b(d3);
            a(d1);
        }
        if (!flag) goto _L5; else goto _L2
_L2:
        return;
_L4:
        if (l != 2) goto _L7; else goto _L6
_L6:
        d d4 = d2.b;
        d d6 = d2.c;
        if (d6 != null)
        {
            j = d6.h;
        } else
        {
            j = 0;
        }
        if (d4 != null)
        {
            k = d4.h;
        } else
        {
            k = 0;
        }
        j = k - j;
        if (j == 1 || j == 0 && !flag)
        {
            b(d1);
        } else
        {
            if (!f && j != -1)
            {
                throw new AssertionError();
            }
            a(d2);
            b(d1);
        }
        if (flag) goto _L2; else goto _L5
_L5:
        d1 = d1.a;
        continue; /* Loop/switch isn't completed */
_L7:
        if (l != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        d1.h = j + 1;
        if (flag)
        {
            return;
        }
        if (true) goto _L5; else goto _L8
_L8:
        if (!f && l != -1 && l != 1)
        {
            throw new AssertionError();
        }
        d1.h = Math.max(j, k) + 1;
        if (flag) goto _L5; else goto _L9
_L9:
        return;
        if (true) goto _L11; else goto _L10
_L10:
    }

    d a(Object obj)
    {
        d d1 = null;
        if (obj != null)
        {
            try
            {
                d1 = a(obj, false);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return null;
            }
        }
        return d1;
    }

    d a(Object obj, boolean flag)
    {
        d d1;
        Object obj1;
        Comparator comparator;
        obj1 = null;
        comparator = a;
        d1 = b;
        if (d1 == null) goto _L2; else goto _L1
_L1:
        d d2;
        Comparable comparable;
        int j;
        if (comparator == g)
        {
            comparable = (Comparable)obj;
        } else
        {
            comparable = null;
        }
_L11:
        if (comparable != null)
        {
            j = comparable.compareTo(d1.f);
        } else
        {
            j = comparator.compare(obj, d1.f);
        }
        if (j != 0) goto _L4; else goto _L3
_L3:
        d2 = d1;
_L8:
        return d2;
_L4:
        if (j < 0)
        {
            d2 = d1.b;
        } else
        {
            d2 = d1.c;
        }
        if (d2 != null) goto _L6; else goto _L5
_L5:
        d2 = obj1;
        if (!flag) goto _L8; else goto _L7
_L7:
        d2 = e;
        if (d1 != null) goto _L10; else goto _L9
_L6:
        d1 = d2;
          goto _L11
_L9:
        if (comparator == g && !(obj instanceof Comparable))
        {
            throw new ClassCastException((new StringBuilder()).append(obj.getClass().getName()).append(" is not Comparable").toString());
        }
        obj = new d(d1, obj, d2, d2.e);
        b = ((d) (obj));
_L12:
        c = c + 1;
        d = d + 1;
        return ((d) (obj));
_L10:
        obj = new d(d1, obj, d2, d2.e);
        if (j < 0)
        {
            d1.b = ((d) (obj));
        } else
        {
            d1.c = ((d) (obj));
        }
        b(d1, true);
        if (true) goto _L12; else goto _L2
_L2:
        j = 0;
          goto _L5
    }

    d a(java.util.Map.Entry entry)
    {
        d d1 = a(entry.getKey());
        boolean flag;
        if (d1 != null && a(d1.g, entry.getValue()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return d1;
        } else
        {
            return null;
        }
    }

    void a(d d1, boolean flag)
    {
        int k = 0;
        if (flag)
        {
            d1.e.d = d1.d;
            d1.d.e = d1.e;
        }
        d d2 = d1.b;
        d d3 = d1.c;
        d d4 = d1.a;
        if (d2 != null && d3 != null)
        {
            int j;
            if (d2.h > d3.h)
            {
                d2 = d2.b();
            } else
            {
                d2 = d3.a();
            }
            a(d2, false);
            d3 = d1.b;
            if (d3 != null)
            {
                j = d3.h;
                d2.b = d3;
                d3.a = d2;
                d1.b = null;
            } else
            {
                j = 0;
            }
            d3 = d1.c;
            if (d3 != null)
            {
                k = d3.h;
                d2.c = d3;
                d3.a = d2;
                d1.c = null;
            }
            d2.h = Math.max(j, k) + 1;
            a(d1, d2);
            return;
        }
        if (d2 != null)
        {
            a(d1, d2);
            d1.b = null;
        } else
        if (d3 != null)
        {
            a(d1, d3);
            d1.c = null;
        } else
        {
            a(d1, ((d) (null)));
        }
        b(d4, false);
        c = c - 1;
        d = d + 1;
    }

    d b(Object obj)
    {
        obj = a(obj);
        if (obj != null)
        {
            a(((d) (obj)), true);
        }
        return ((d) (obj));
    }

    public void clear()
    {
        b = null;
        c = 0;
        d = d + 1;
        d d1 = e;
        d1.e = d1;
        d1.d = d1;
    }

    public boolean containsKey(Object obj)
    {
        return a(obj) != null;
    }

    public Set entrySet()
    {
        a a1 = h;
        if (a1 != null)
        {
            return a1;
        } else
        {
            a a2 = new a();
            h = a2;
            return a2;
        }
    }

    public Object get(Object obj)
    {
        obj = a(obj);
        if (obj != null)
        {
            return ((d) (obj)).g;
        } else
        {
            return null;
        }
    }

    public Set keySet()
    {
        b b1 = i;
        if (b1 != null)
        {
            return b1;
        } else
        {
            b b2 = new b();
            i = b2;
            return b2;
        }
    }

    public Object put(Object obj, Object obj1)
    {
        if (obj == null)
        {
            throw new NullPointerException("key == null");
        } else
        {
            obj = a(obj, true);
            Object obj2 = ((d) (obj)).g;
            obj.g = obj1;
            return obj2;
        }
    }

    public Object remove(Object obj)
    {
        obj = b(obj);
        if (obj != null)
        {
            return ((d) (obj)).g;
        } else
        {
            return null;
        }
    }

    public int size()
    {
        return c;
    }

    static 
    {
        boolean flag;
        if (!android/support/v7/afy.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f = flag;
    }
}
