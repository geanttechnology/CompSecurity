// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.Set;

// Referenced classes of package shared_presage.com.google.gson.internal:
//            n, o, p

public final class LinkedTreeMap extends AbstractMap
    implements Serializable
{
    final class a extends AbstractSet
    {

        final LinkedTreeMap a;

        public final void clear()
        {
            a.clear();
        }

        public final boolean contains(Object obj)
        {
            return (obj instanceof java.util.Map.Entry) && a.findByEntry((java.util.Map.Entry)obj) != null;
        }

        public final Iterator iterator()
        {
            return new o(this);
        }

        public final boolean remove(Object obj)
        {
            if (obj instanceof java.util.Map.Entry)
            {
                if ((obj = a.findByEntry((java.util.Map.Entry)obj)) != null)
                {
                    a.removeInternal(((d) (obj)), true);
                    return true;
                }
            }
            return false;
        }

        public final int size()
        {
            return a.size;
        }

        a()
        {
            a = LinkedTreeMap.this;
            super();
        }
    }

    final class b extends AbstractSet
    {

        final LinkedTreeMap a;

        public final void clear()
        {
            a.clear();
        }

        public final boolean contains(Object obj)
        {
            return a.containsKey(obj);
        }

        public final Iterator iterator()
        {
            return new p(this);
        }

        public final boolean remove(Object obj)
        {
            return a.removeInternalByKey(obj) != null;
        }

        public final int size()
        {
            return a.size;
        }

        b()
        {
            a = LinkedTreeMap.this;
            super();
        }
    }

    private abstract class c
        implements Iterator
    {

        d b;
        d c;
        int d;
        final LinkedTreeMap e;

        final d a()
        {
            d d1 = b;
            if (d1 == e.header)
            {
                throw new NoSuchElementException();
            }
            if (e.modCount != d)
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
            return b != e.header;
        }

        public final void remove()
        {
            if (c == null)
            {
                throw new IllegalStateException();
            } else
            {
                e.removeInternal(c, true);
                c = null;
                d = e.modCount;
                return;
            }
        }

        private c()
        {
            e = LinkedTreeMap.this;
            super();
            b = e.header.d;
            c = null;
            d = e.modCount;
        }

        c(byte byte0)
        {
            this();
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

        public final d a()
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

        public final d b()
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

        public final boolean equals(Object obj)
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

        public final Object getKey()
        {
            return f;
        }

        public final Object getValue()
        {
            return g;
        }

        public final int hashCode()
        {
            int j = 0;
            int i;
            if (f == null)
            {
                i = 0;
            } else
            {
                i = f.hashCode();
            }
            if (g != null)
            {
                j = g.hashCode();
            }
            return i ^ j;
        }

        public final Object setValue(Object obj)
        {
            Object obj1 = g;
            g = obj;
            return obj1;
        }

        public final String toString()
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


    static final boolean $assertionsDisabled;
    private static final Comparator NATURAL_ORDER = new n();
    Comparator comparator;
    private a entrySet;
    final d header;
    private b keySet;
    int modCount;
    d root;
    int size;

    public LinkedTreeMap()
    {
        this(NATURAL_ORDER);
    }

    public LinkedTreeMap(Comparator comparator1)
    {
        size = 0;
        modCount = 0;
        header = new d();
        if (comparator1 == null)
        {
            comparator1 = NATURAL_ORDER;
        }
        comparator = comparator1;
    }

    private boolean equal(Object obj, Object obj1)
    {
        return obj == obj1 || obj != null && obj.equals(obj1);
    }

    private void rebalance(d d1, boolean flag)
    {
_L6:
        if (d1 == null) goto _L2; else goto _L1
_L1:
        d d2;
        d d3;
        int i;
        int j;
        int k;
        d2 = d1.b;
        d3 = d1.c;
        d d5;
        if (d2 != null)
        {
            i = d2.h;
        } else
        {
            i = 0;
        }
        if (d3 != null)
        {
            j = d3.h;
        } else
        {
            j = 0;
        }
        k = i - j;
        if (k != -2) goto _L4; else goto _L3
_L3:
        d2 = d3.b;
        d5 = d3.c;
        if (d5 != null)
        {
            i = d5.h;
        } else
        {
            i = 0;
        }
        if (d2 != null)
        {
            j = d2.h;
        } else
        {
            j = 0;
        }
        i = j - i;
        if (i == -1 || i == 0 && !flag)
        {
            rotateLeft(d1);
        } else
        {
            if (!$assertionsDisabled && i != 1)
            {
                throw new AssertionError();
            }
            rotateRight(d3);
            rotateLeft(d1);
        }
        if (flag) goto _L2; else goto _L5
_L5:
        d1 = d1.a;
          goto _L6
_L4:
        if (k != 2) goto _L8; else goto _L7
_L7:
        d d4 = d2.b;
        d d6 = d2.c;
        if (d6 != null)
        {
            i = d6.h;
        } else
        {
            i = 0;
        }
        if (d4 != null)
        {
            j = d4.h;
        } else
        {
            j = 0;
        }
        i = j - i;
        if (i == 1 || i == 0 && !flag)
        {
            rotateRight(d1);
        } else
        {
            if (!$assertionsDisabled && i != -1)
            {
                throw new AssertionError();
            }
            rotateLeft(d2);
            rotateRight(d1);
        }
        if (!flag) goto _L5; else goto _L2
_L2:
        return;
_L8:
        if (k == 0)
        {
            d1.h = i + 1;
            if (flag)
            {
                return;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (!$assertionsDisabled && k != -1 && k != 1)
        {
            throw new AssertionError();
        }
        d1.h = Math.max(i, j) + 1;
        if (!flag) goto _L2; else goto _L5
    }

    private void replaceInParent(d d1, d d2)
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
            if (!$assertionsDisabled && d3.c != d1)
            {
                throw new AssertionError();
            } else
            {
                d3.c = d2;
                return;
            }
        } else
        {
            root = d2;
            return;
        }
    }

    private void rotateLeft(d d1)
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
        replaceInParent(d1, d3);
        d3.b = d1;
        d1.a = d3;
        int i;
        int j;
        if (d2 != null)
        {
            i = d2.h;
        } else
        {
            i = 0;
        }
        if (d4 != null)
        {
            j = d4.h;
        } else
        {
            j = 0;
        }
        d1.h = Math.max(i, j) + 1;
        j = d1.h;
        i = ((flag) ? 1 : 0);
        if (d5 != null)
        {
            i = d5.h;
        }
        d3.h = Math.max(j, i) + 1;
    }

    private void rotateRight(d d1)
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
        replaceInParent(d1, d2);
        d2.c = d1;
        d1.a = d2;
        int i;
        int j;
        if (d3 != null)
        {
            i = d3.h;
        } else
        {
            i = 0;
        }
        if (d5 != null)
        {
            j = d5.h;
        } else
        {
            j = 0;
        }
        d1.h = Math.max(i, j) + 1;
        j = d1.h;
        i = ((flag) ? 1 : 0);
        if (d4 != null)
        {
            i = d4.h;
        }
        d2.h = Math.max(j, i) + 1;
    }

    private Object writeReplace()
    {
        return new LinkedHashMap(this);
    }

    public final void clear()
    {
        root = null;
        size = 0;
        modCount = modCount + 1;
        d d1 = header;
        d1.e = d1;
        d1.d = d1;
    }

    public final boolean containsKey(Object obj)
    {
        return findByObject(obj) != null;
    }

    public final Set entrySet()
    {
        a a1 = entrySet;
        if (a1 != null)
        {
            return a1;
        } else
        {
            a a2 = new a();
            entrySet = a2;
            return a2;
        }
    }

    final d find(Object obj, boolean flag)
    {
        d d1;
        d d2;
        Object obj1;
        Comparator comparator1;
        int i;
        obj1 = null;
        comparator1 = comparator;
        d1 = root;
        if (d1 == null)
        {
            break MISSING_BLOCK_LABEL_269;
        }
        Comparable comparable;
        if (comparator1 == NATURAL_ORDER)
        {
            comparable = (Comparable)obj;
        } else
        {
            comparable = null;
        }
_L3:
        if (comparable != null)
        {
            i = comparable.compareTo(d1.f);
        } else
        {
            i = comparator1.compare(obj, d1.f);
        }
        if (i != 0) goto _L2; else goto _L1
_L1:
        d2 = d1;
_L5:
        return d2;
_L2:
label0:
        {
            if (i < 0)
            {
                d2 = d1.b;
            } else
            {
                d2 = d1.c;
            }
            if (d2 == null)
            {
                break label0;
            }
            d1 = d2;
        }
          goto _L3
        if (!flag) goto _L5; else goto _L4
_L4:
        d d3 = header;
        if (d1 == null)
        {
            if (comparator1 == NATURAL_ORDER && !(obj instanceof Comparable))
            {
                throw new ClassCastException((new StringBuilder()).append(obj.getClass().getName()).append(" is not Comparable").toString());
            }
            obj = new d(d1, obj, d3, d3.e);
            root = ((d) (obj));
        } else
        {
            obj = new d(d1, obj, d3, d3.e);
            if (i < 0)
            {
                d1.b = ((d) (obj));
            } else
            {
                d1.c = ((d) (obj));
            }
            rebalance(d1, true);
        }
        size = size + 1;
        modCount = modCount + 1;
        return ((d) (obj));
        i = 0;
        d2 = obj1;
        continue; /* Loop/switch isn't completed */
    }

    final d findByEntry(java.util.Map.Entry entry)
    {
        d d1 = findByObject(entry.getKey());
        boolean flag;
        if (d1 != null && equal(d1.g, entry.getValue()))
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

    final d findByObject(Object obj)
    {
        d d1 = null;
        if (obj != null)
        {
            try
            {
                d1 = find(obj, false);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return null;
            }
        }
        return d1;
    }

    public final Object get(Object obj)
    {
        obj = findByObject(obj);
        if (obj != null)
        {
            return ((d) (obj)).g;
        } else
        {
            return null;
        }
    }

    public final Set keySet()
    {
        b b1 = keySet;
        if (b1 != null)
        {
            return b1;
        } else
        {
            b b2 = new b();
            keySet = b2;
            return b2;
        }
    }

    public final Object put(Object obj, Object obj1)
    {
        if (obj == null)
        {
            throw new NullPointerException("key == null");
        } else
        {
            obj = find(obj, true);
            Object obj2 = ((d) (obj)).g;
            obj.g = obj1;
            return obj2;
        }
    }

    public final Object remove(Object obj)
    {
        obj = removeInternalByKey(obj);
        if (obj != null)
        {
            return ((d) (obj)).g;
        } else
        {
            return null;
        }
    }

    final void removeInternal(d d1, boolean flag)
    {
        int j = 0;
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
            int i;
            if (d2.h > d3.h)
            {
                d2 = d2.b();
            } else
            {
                d2 = d3.a();
            }
            removeInternal(d2, false);
            d3 = d1.b;
            if (d3 != null)
            {
                i = d3.h;
                d2.b = d3;
                d3.a = d2;
                d1.b = null;
            } else
            {
                i = 0;
            }
            d3 = d1.c;
            if (d3 != null)
            {
                j = d3.h;
                d2.c = d3;
                d3.a = d2;
                d1.c = null;
            }
            d2.h = Math.max(i, j) + 1;
            replaceInParent(d1, d2);
            return;
        }
        if (d2 != null)
        {
            replaceInParent(d1, d2);
            d1.b = null;
        } else
        if (d3 != null)
        {
            replaceInParent(d1, d3);
            d1.c = null;
        } else
        {
            replaceInParent(d1, null);
        }
        rebalance(d4, false);
        size = size - 1;
        modCount = modCount + 1;
    }

    final d removeInternalByKey(Object obj)
    {
        obj = findByObject(obj);
        if (obj != null)
        {
            removeInternal(((d) (obj)), true);
        }
        return ((d) (obj));
    }

    public final int size()
    {
        return size;
    }

    static 
    {
        boolean flag;
        if (!shared_presage/com/google/gson/internal/LinkedTreeMap.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }
}
