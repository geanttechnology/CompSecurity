// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import com.google.a.a.k;
import com.google.a.a.n;
import com.google.a.c.aj;
import com.google.a.e.a;
import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.google.a.b:
//            b, n, k, j, 
//            c, e, l

class com.google.a.b.f extends AbstractMap
    implements ConcurrentMap
{
    abstract class a extends AbstractSet
    {

        final ConcurrentMap a;
        final com.google.a.b.f b;

        public void clear()
        {
            a.clear();
        }

        public boolean isEmpty()
        {
            return a.isEmpty();
        }

        public int size()
        {
            return a.size();
        }

        a(ConcurrentMap concurrentmap)
        {
            b = com.google.a.b.f.this;
            super();
            a = concurrentmap;
        }
    }

    static final class aa extends ab
    {

        volatile long a;
        n b;
        n c;
        volatile long d;
        n e;
        n f;

        public final void a(long l1)
        {
            a = l1;
        }

        public final void a(n n1)
        {
            b = n1;
        }

        public final void b(long l1)
        {
            d = l1;
        }

        public final void b(n n1)
        {
            c = n1;
        }

        public final void c(n n1)
        {
            e = n1;
        }

        public final void d(n n1)
        {
            f = n1;
        }

        public final long e()
        {
            return a;
        }

        public final n f()
        {
            return b;
        }

        public final n g()
        {
            return c;
        }

        public final long h()
        {
            return d;
        }

        public final n i()
        {
            return e;
        }

        public final n j()
        {
            return f;
        }

        aa(ReferenceQueue referencequeue, Object obj, int i1, n n1)
        {
            super(referencequeue, obj, i1, n1);
            a = 0x7fffffffffffffffL;
            b = com.google.a.b.f.k();
            c = com.google.a.b.f.k();
            d = 0x7fffffffffffffffL;
            e = com.google.a.b.f.k();
            f = com.google.a.b.f.k();
        }
    }

    static class ab extends WeakReference
        implements n
    {

        final int g;
        final n h;
        volatile x i;

        public final x a()
        {
            return i;
        }

        public void a(long l1)
        {
            throw new UnsupportedOperationException();
        }

        public void a(n n1)
        {
            throw new UnsupportedOperationException();
        }

        public final void a(x x1)
        {
            i = x1;
        }

        public final n b()
        {
            return h;
        }

        public void b(long l1)
        {
            throw new UnsupportedOperationException();
        }

        public void b(n n1)
        {
            throw new UnsupportedOperationException();
        }

        public final int c()
        {
            return g;
        }

        public void c(n n1)
        {
            throw new UnsupportedOperationException();
        }

        public final Object d()
        {
            return get();
        }

        public void d(n n1)
        {
            throw new UnsupportedOperationException();
        }

        public long e()
        {
            throw new UnsupportedOperationException();
        }

        public n f()
        {
            throw new UnsupportedOperationException();
        }

        public n g()
        {
            throw new UnsupportedOperationException();
        }

        public long h()
        {
            throw new UnsupportedOperationException();
        }

        public n i()
        {
            throw new UnsupportedOperationException();
        }

        public n j()
        {
            throw new UnsupportedOperationException();
        }

        ab(ReferenceQueue referencequeue, Object obj, int i1, n n1)
        {
            super(obj, referencequeue);
            i = com.google.a.b.f.j();
            g = i1;
            h = n1;
        }
    }

    static final class ac extends WeakReference
        implements x
    {

        final n a;

        public final int a()
        {
            return 1;
        }

        public final x a(ReferenceQueue referencequeue, Object obj, n n1)
        {
            return new ac(referencequeue, obj, n1);
        }

        public final void a(Object obj)
        {
        }

        public final n b()
        {
            return a;
        }

        public final boolean c()
        {
            return false;
        }

        public final boolean d()
        {
            return true;
        }

        public final Object e()
        {
            return get();
        }

        ac(ReferenceQueue referencequeue, Object obj, n n1)
        {
            super(obj, referencequeue);
            a = n1;
        }
    }

    static final class ad extends ab
    {

        volatile long a;
        n b;
        n c;

        public final void b(long l1)
        {
            a = l1;
        }

        public final void c(n n1)
        {
            b = n1;
        }

        public final void d(n n1)
        {
            c = n1;
        }

        public final long h()
        {
            return a;
        }

        public final n i()
        {
            return b;
        }

        public final n j()
        {
            return c;
        }

        ad(ReferenceQueue referencequeue, Object obj, int i1, n n1)
        {
            super(referencequeue, obj, i1, n1);
            a = 0x7fffffffffffffffL;
            b = com.google.a.b.f.k();
            c = com.google.a.b.f.k();
        }
    }

    static final class ae extends u
    {

        final int b = 0;

        public final int a()
        {
            return b;
        }

        ae(Object obj)
        {
            super(obj);
        }
    }

    static final class af extends AbstractQueue
    {

        final n a = new _cls1(this);

        private n a()
        {
            n n2 = a.i();
            n n1 = n2;
            if (n2 == a)
            {
                n1 = null;
            }
            return n1;
        }

        public final void clear()
        {
            n n2;
            for (n n1 = a.i(); n1 != a; n1 = n2)
            {
                n2 = n1.i();
                com.google.a.b.f.b(n1);
            }

            a.c(a);
            a.d(a);
        }

        public final boolean contains(Object obj)
        {
            return ((n)obj).i() != com.google.a.b.m.a;
        }

        public final boolean isEmpty()
        {
            return a.i() == a;
        }

        public final Iterator iterator()
        {
            return new com.google.a.c.f(this, a()) {

                final af a;

                protected final Object a(Object obj)
                {
                    n n1 = ((n)obj).i();
                    obj = n1;
                    if (n1 == a.a)
                    {
                        obj = null;
                    }
                    return obj;
                }

            
            {
                a = af1;
                super(n1);
            }
            };
        }

        public final boolean offer(Object obj)
        {
            obj = (n)obj;
            com.google.a.b.f.b(((n) (obj)).j(), ((n) (obj)).i());
            com.google.a.b.f.b(a.j(), ((n) (obj)));
            com.google.a.b.f.b(((n) (obj)), a);
            return true;
        }

        public final Object peek()
        {
            return a();
        }

        public final Object poll()
        {
            n n1 = a.i();
            if (n1 == a)
            {
                return null;
            } else
            {
                remove(n1);
                return n1;
            }
        }

        public final boolean remove(Object obj)
        {
            obj = (n)obj;
            n n1 = ((n) (obj)).j();
            n n2 = ((n) (obj)).i();
            com.google.a.b.f.b(n1, n2);
            com.google.a.b.f.b(((n) (obj)));
            return n2 != com.google.a.b.m.a;
        }

        public final int size()
        {
            int i1 = 0;
            for (n n1 = a.i(); n1 != a; n1 = n1.i())
            {
                i1++;
            }

            return i1;
        }

        af()
        {
        }
    }

    final class ag
        implements java.util.Map.Entry
    {

        final Object a;
        Object b;
        final com.google.a.b.f c;

        public final boolean equals(Object obj)
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (obj instanceof java.util.Map.Entry)
            {
                obj = (java.util.Map.Entry)obj;
                flag = flag1;
                if (a.equals(((java.util.Map.Entry) (obj)).getKey()))
                {
                    flag = flag1;
                    if (b.equals(((java.util.Map.Entry) (obj)).getValue()))
                    {
                        flag = true;
                    }
                }
            }
            return flag;
        }

        public final Object getKey()
        {
            return a;
        }

        public final Object getValue()
        {
            return b;
        }

        public final int hashCode()
        {
            return a.hashCode() ^ b.hashCode();
        }

        public final Object setValue(Object obj)
        {
            throw new UnsupportedOperationException();
        }

        public final String toString()
        {
            String s1 = String.valueOf(String.valueOf(getKey()));
            String s2 = String.valueOf(String.valueOf(getValue()));
            return (new StringBuilder(s1.length() + 1 + s2.length())).append(s1).append("=").append(s2).toString();
        }

        ag(Object obj, Object obj1)
        {
            c = com.google.a.b.f.this;
            super();
            a = obj;
            b = obj1;
        }
    }

    static abstract class b
        implements n
    {

        public x a()
        {
            throw new UnsupportedOperationException();
        }

        public void a(long l1)
        {
            throw new UnsupportedOperationException();
        }

        public void a(n n1)
        {
            throw new UnsupportedOperationException();
        }

        public void a(x x1)
        {
            throw new UnsupportedOperationException();
        }

        public n b()
        {
            throw new UnsupportedOperationException();
        }

        public void b(long l1)
        {
            throw new UnsupportedOperationException();
        }

        public void b(n n1)
        {
            throw new UnsupportedOperationException();
        }

        public int c()
        {
            throw new UnsupportedOperationException();
        }

        public void c(n n1)
        {
            throw new UnsupportedOperationException();
        }

        public Object d()
        {
            throw new UnsupportedOperationException();
        }

        public void d(n n1)
        {
            throw new UnsupportedOperationException();
        }

        public long e()
        {
            throw new UnsupportedOperationException();
        }

        public n f()
        {
            throw new UnsupportedOperationException();
        }

        public n g()
        {
            throw new UnsupportedOperationException();
        }

        public long h()
        {
            throw new UnsupportedOperationException();
        }

        public n i()
        {
            throw new UnsupportedOperationException();
        }

        public n j()
        {
            throw new UnsupportedOperationException();
        }

        b()
        {
        }
    }

    static final class c extends AbstractQueue
    {

        final n a = new _cls1(this);

        private n a()
        {
            n n2 = a.f();
            n n1 = n2;
            if (n2 == a)
            {
                n1 = null;
            }
            return n1;
        }

        public final void clear()
        {
            n n2;
            for (n n1 = a.f(); n1 != a; n1 = n2)
            {
                n2 = n1.f();
                com.google.a.b.f.a(n1);
            }

            a.a(a);
            a.b(a);
        }

        public final boolean contains(Object obj)
        {
            return ((n)obj).f() != com.google.a.b.m.a;
        }

        public final boolean isEmpty()
        {
            return a.f() == a;
        }

        public final Iterator iterator()
        {
            return new com.google.a.c.f(this, a()) {

                final c a;

                protected final Object a(Object obj)
                {
                    n n1 = ((n)obj).f();
                    obj = n1;
                    if (n1 == a.a)
                    {
                        obj = null;
                    }
                    return obj;
                }

            
            {
                a = c1;
                super(n1);
            }
            };
        }

        public final boolean offer(Object obj)
        {
            obj = (n)obj;
            com.google.a.b.f.a(((n) (obj)).g(), ((n) (obj)).f());
            com.google.a.b.f.a(a.g(), ((n) (obj)));
            com.google.a.b.f.a(((n) (obj)), a);
            return true;
        }

        public final Object peek()
        {
            return a();
        }

        public final Object poll()
        {
            n n1 = a.f();
            if (n1 == a)
            {
                return null;
            } else
            {
                remove(n1);
                return n1;
            }
        }

        public final boolean remove(Object obj)
        {
            obj = (n)obj;
            n n1 = ((n) (obj)).g();
            n n2 = ((n) (obj)).f();
            com.google.a.b.f.a(n1, n2);
            com.google.a.b.f.a(((n) (obj)));
            return n2 != com.google.a.b.m.a;
        }

        public final int size()
        {
            int i1 = 0;
            for (n n1 = a.f(); n1 != a; n1 = n1.f())
            {
                i1++;
            }

            return i1;
        }

        c()
        {
        }
    }

    static abstract class d extends Enum
    {

        public static final d a;
        public static final d b;
        public static final d c;
        public static final d d;
        public static final d e;
        public static final d f;
        public static final d g;
        public static final d h;
        static final d i[];
        private static final d j[];

        static d a(q q1, boolean flag, boolean flag1)
        {
            byte byte1 = 0;
            byte byte0;
            boolean flag2;
            if (q1 == q.c)
            {
                byte0 = 4;
            } else
            {
                byte0 = 0;
            }
            if (flag)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (flag1)
            {
                byte1 = 2;
            }
            return i[byte1 | (flag2 | byte0)];
        }

        static void a(n n1, n n2)
        {
            n2.a(n1.e());
            com.google.a.b.f.a(n1.g(), n2);
            com.google.a.b.f.a(n2, n1.f());
            com.google.a.b.f.a(n1);
        }

        static void b(n n1, n n2)
        {
            n2.b(n1.h());
            com.google.a.b.f.b(n1.j(), n2);
            com.google.a.b.f.b(n2, n1.i());
            com.google.a.b.f.b(n1);
        }

        public static d valueOf(String s1)
        {
            return (d)Enum.valueOf(com/google/a/b/f$d, s1);
        }

        public static d[] values()
        {
            return (d[])j.clone();
        }

        n a(o o1, n n1, n n2)
        {
            return a(o1, n1.d(), n1.c(), n2);
        }

        abstract n a(o o1, Object obj, int i1, n n1);

        static 
        {
            a = new d("STRONG") {

                final n a(o o1, Object obj, int i1, n n1)
                {
                    return new t(obj, i1, n1);
                }

            };
            b = new d("STRONG_ACCESS") {

                final n a(o o1, n n1, n n2)
                {
                    o1 = super.a(o1, n1, n2);
                    a(n1, ((n) (o1)));
                    return o1;
                }

                final n a(o o1, Object obj, int i1, n n1)
                {
                    return new r(obj, i1, n1);
                }

            };
            c = new d("STRONG_WRITE") {

                final n a(o o1, n n1, n n2)
                {
                    o1 = super.a(o1, n1, n2);
                    b(n1, o1);
                    return o1;
                }

                final n a(o o1, Object obj, int i1, n n1)
                {
                    return new v(obj, i1, n1);
                }

            };
            d = new d("STRONG_ACCESS_WRITE") {

                final n a(o o1, n n1, n n2)
                {
                    o1 = super.a(o1, n1, n2);
                    a(n1, ((n) (o1)));
                    b(n1, o1);
                    return o1;
                }

                final n a(o o1, Object obj, int i1, n n1)
                {
                    return new s(obj, i1, n1);
                }

            };
            e = new d("WEAK") {

                final n a(o o1, Object obj, int i1, n n1)
                {
                    return new ab(o1.h, obj, i1, n1);
                }

            };
            f = new d("WEAK_ACCESS") {

                final n a(o o1, n n1, n n2)
                {
                    o1 = super.a(o1, n1, n2);
                    a(n1, ((n) (o1)));
                    return o1;
                }

                final n a(o o1, Object obj, int i1, n n1)
                {
                    return new z(o1.h, obj, i1, n1);
                }

            };
            g = new d("WEAK_WRITE") {

                final n a(o o1, n n1, n n2)
                {
                    o1 = super.a(o1, n1, n2);
                    b(n1, o1);
                    return o1;
                }

                final n a(o o1, Object obj, int i1, n n1)
                {
                    return new ad(o1.h, obj, i1, n1);
                }

            };
            h = new d("WEAK_ACCESS_WRITE") {

                final n a(o o1, n n1, n n2)
                {
                    o1 = super.a(o1, n1, n2);
                    a(n1, ((n) (o1)));
                    b(n1, o1);
                    return o1;
                }

                final n a(o o1, Object obj, int i1, n n1)
                {
                    return new aa(o1.h, obj, i1, n1);
                }

            };
            j = (new d[] {
                a, b, c, d, e, f, g, h
            });
            i = (new d[] {
                a, b, c, d, e, f, g, h
            });
        }

        private d(String s1, int i1)
        {
            super(s1, i1);
        }

        d(String s1, int i1, byte byte0)
        {
            this(s1, i1);
        }
    }

    final class e extends g
    {

        final com.google.a.b.f a;

        public final Object next()
        {
            return a();
        }

        e()
        {
            a = com.google.a.b.f.this;
            super();
        }
    }

    final class f extends a
    {

        final com.google.a.b.f c;

        public final boolean contains(Object obj)
        {
            if (obj instanceof java.util.Map.Entry)
            {
                obj = (java.util.Map.Entry)obj;
                Object obj1 = ((java.util.Map.Entry) (obj)).getKey();
                if (obj1 != null)
                {
                    obj1 = c.get(obj1);
                    if (obj1 != null && c.g.a(((java.util.Map.Entry) (obj)).getValue(), obj1))
                    {
                        return true;
                    }
                }
            }
            return false;
        }

        public final Iterator iterator()
        {
            return c. new e();
        }

        public final boolean remove(Object obj)
        {
            if (obj instanceof java.util.Map.Entry)
            {
                obj = (java.util.Map.Entry)obj;
                Object obj1 = ((java.util.Map.Entry) (obj)).getKey();
                if (obj1 != null && c.remove(obj1, ((java.util.Map.Entry) (obj)).getValue()))
                {
                    return true;
                }
            }
            return false;
        }

        f(ConcurrentMap concurrentmap)
        {
            c = com.google.a.b.f.this;
            super(concurrentmap);
        }
    }

    abstract class g
        implements Iterator
    {

        int b;
        int c;
        o d;
        AtomicReferenceArray e;
        n f;
        ag g;
        ag h;
        final com.google.a.b.f i;

        private boolean a(n n1)
        {
            Object obj1 = null;
            Object obj3;
            com.google.a.b.f f1;
            long l1;
            l1 = i.q.a();
            obj3 = n1.d();
            f1 = i;
            if (n1.d() != null) goto _L2; else goto _L1
_L1:
            Object obj = obj1;
_L4:
            if (obj == null)
            {
                break; /* Loop/switch isn't completed */
            }
            g = i. new ag(obj3, obj);
            d.a();
            return true;
_L2:
            Object obj2 = n1.a().get();
            obj = obj1;
            if (obj2 == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            boolean flag = f1.a(n1, l1);
            obj = obj1;
            if (!flag)
            {
                obj = obj2;
            }
            if (true) goto _L4; else goto _L3
_L3:
            d.a();
            return false;
            n1;
            d.a();
            throw n1;
        }

        private void b()
        {
            g = null;
            break MISSING_BLOCK_LABEL_5;
            if (!c() && !d())
            {
                while (b >= 0) 
                {
                    o ao[] = i.d;
                    int i1 = b;
                    b = i1 - 1;
                    d = ao[i1];
                    if (d.b != 0)
                    {
                        e = d.f;
                        c = e.length() - 1;
                        if (d())
                        {
                            return;
                        }
                    }
                }
            }
            return;
        }

        private boolean c()
        {
            if (f != null)
            {
                for (f = f.b(); f != null; f = f.b())
                {
                    if (a(f))
                    {
                        return true;
                    }
                }

            }
            return false;
        }

        private boolean d()
        {
            while (c >= 0) 
            {
                Object obj = e;
                int i1 = c;
                c = i1 - 1;
                obj = (n)((AtomicReferenceArray) (obj)).get(i1);
                f = ((n) (obj));
                if (obj != null && (a(f) || c()))
                {
                    return true;
                }
            }
            return false;
        }

        final ag a()
        {
            if (g == null)
            {
                throw new NoSuchElementException();
            } else
            {
                h = g;
                b();
                return h;
            }
        }

        public boolean hasNext()
        {
            return g != null;
        }

        public void remove()
        {
            boolean flag;
            if (h != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            com.google.a.a.g.b(flag);
            i.remove(h.getKey());
            h = null;
        }

        g()
        {
            i = com.google.a.b.f.this;
            super();
            b = com.google.a.b.f.this.d.length - 1;
            c = -1;
            b();
        }
    }

    final class h extends g
    {

        final com.google.a.b.f a;

        public final Object next()
        {
            return a().getKey();
        }

        h()
        {
            a = com.google.a.b.f.this;
            super();
        }
    }

    final class i extends a
    {

        final com.google.a.b.f c;

        public final boolean contains(Object obj)
        {
            return a.containsKey(obj);
        }

        public final Iterator iterator()
        {
            return c. new h();
        }

        public final boolean remove(Object obj)
        {
            return a.remove(obj) != null;
        }

        i(ConcurrentMap concurrentmap)
        {
            c = com.google.a.b.f.this;
            super(concurrentmap);
        }
    }

    static final class j
        implements x
    {

        volatile x a;
        final com.google.a.g.a.p b;
        final com.google.a.a.j c;

        public final int a()
        {
            return a.a();
        }

        public final x a(ReferenceQueue referencequeue, Object obj, n n1)
        {
            return this;
        }

        public final com.google.a.g.a.j a(Object obj, com.google.a.b.c c1)
        {
            Object obj1 = c;
            boolean flag;
            if (!((com.google.a.a.j) (obj1)).b)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            com.google.a.a.g.b(flag, "This stopwatch is already running.");
            obj1.b = true;
            obj1.c = ((com.google.a.a.j) (obj1)).a.a();
            obj1 = a.get();
            if (obj1 != null)
            {
                break MISSING_BLOCK_LABEL_76;
            }
            obj = c1.a(obj);
            if (b(obj))
            {
                return b;
            } else
            {
                return com.google.a.g.a.i.a(obj);
            }
            com.google.a.a.g.a(obj);
            com.google.a.a.g.a(obj1);
            obj = com.google.a.g.a.i.a(com.google.a.g.a.i.a(c1.a(obj)), new com.google.a.a.c(this) {

                final j a;

                public final Object a(Object obj)
                {
                    a.b(obj);
                    return obj;
                }

            
            {
                a = j1;
                super();
            }
            });
            return ((com.google.a.g.a.j) (obj));
            obj;
            if (obj instanceof InterruptedException)
            {
                Thread.currentThread().interrupt();
            }
            if (a(((Throwable) (obj))))
            {
                return b;
            } else
            {
                return com.google.a.g.a.i.a(((Throwable) (obj)));
            }
        }

        public final void a(Object obj)
        {
            if (obj != null)
            {
                b(obj);
                return;
            } else
            {
                a = com.google.a.b.f.j();
                return;
            }
        }

        public final boolean a(Throwable throwable)
        {
            return b.a(throwable);
        }

        public final n b()
        {
            return null;
        }

        public final boolean b(Object obj)
        {
            return b.a(obj);
        }

        public final boolean c()
        {
            return true;
        }

        public final boolean d()
        {
            return a.d();
        }

        public final Object e()
        {
            return com.google.a.g.a.r.a(b);
        }

        public final long f()
        {
            com.google.a.a.j j1 = c;
            return TimeUnit.NANOSECONDS.convert(j1.a(), TimeUnit.NANOSECONDS);
        }

        public final Object get()
        {
            return a.get();
        }

        public j()
        {
            this(com.google.a.b.f.j());
        }

        public j(x x1)
        {
            b = com.google.a.g.a.p.a();
            c = new com.google.a.a.j();
            a = x1;
        }
    }

    static final class k extends l
        implements com.google.a.b.e
    {

        public final Object a(Object obj)
        {
            return b(obj);
        }

        public final Object b(Object obj)
        {
            try
            {
                com.google.a.b.f f1 = a;
                com.google.a.b.c c1 = f1.t;
                int i1 = f1.a(com.google.a.a.g.a(obj));
                obj = f1.a(i1).a(obj, i1, c1);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new com.google.a.g.a.q(((ExecutionException) (obj)).getCause());
            }
            return obj;
        }

        k(com.google.a.b.b b1, com.google.a.b.c c1)
        {
            super(new com.google.a.b.f(b1, (com.google.a.b.c)com.google.a.a.g.a(c1)), (byte)0);
        }
    }

    static class l
        implements Serializable
    {

        final com.google.a.b.f a;

        private l(com.google.a.b.f f1)
        {
            a = f1;
        }

        l(com.google.a.b.f f1, byte byte0)
        {
            this(f1);
        }
    }

    private static final class m extends Enum
        implements n
    {

        public static final m a;
        private static final m b[];

        public static m valueOf(String s1)
        {
            return (m)Enum.valueOf(com/google/a/b/f$m, s1);
        }

        public static m[] values()
        {
            return (m[])b.clone();
        }

        public final x a()
        {
            return null;
        }

        public final void a(long l1)
        {
        }

        public final void a(n n1)
        {
        }

        public final void a(x x1)
        {
        }

        public final n b()
        {
            return null;
        }

        public final void b(long l1)
        {
        }

        public final void b(n n1)
        {
        }

        public final int c()
        {
            return 0;
        }

        public final void c(n n1)
        {
        }

        public final Object d()
        {
            return null;
        }

        public final void d(n n1)
        {
        }

        public final long e()
        {
            return 0L;
        }

        public final n f()
        {
            return this;
        }

        public final n g()
        {
            return this;
        }

        public final long h()
        {
            return 0L;
        }

        public final n i()
        {
            return this;
        }

        public final n j()
        {
            return this;
        }

        static 
        {
            a = new m("INSTANCE");
            b = (new m[] {
                a
            });
        }

        private m(String s1)
        {
            super(s1, 0);
        }
    }

    static interface n
    {

        public abstract x a();

        public abstract void a(long l1);

        public abstract void a(n n1);

        public abstract void a(x x1);

        public abstract n b();

        public abstract void b(long l1);

        public abstract void b(n n1);

        public abstract int c();

        public abstract void c(n n1);

        public abstract Object d();

        public abstract void d(n n1);

        public abstract long e();

        public abstract n f();

        public abstract n g();

        public abstract long h();

        public abstract n i();

        public abstract n j();
    }

    static final class o extends ReentrantLock
    {

        final com.google.a.b.f a;
        volatile int b;
        long c;
        int d;
        int e;
        volatile AtomicReferenceArray f;
        final long g;
        final ReferenceQueue h;
        final ReferenceQueue i;
        final Queue j;
        final AtomicInteger k = new AtomicInteger();
        final Queue l;
        final Queue m;
        final a.b n;

        private n a(n n1, n n2)
        {
            if (n1.d() != null)
            {
                x x1 = n1.a();
                Object obj = x1.get();
                if (obj != null || !x1.d())
                {
                    n1 = a.r.a(this, n1, n2);
                    n1.a(x1.a(i, obj, n1));
                    return n1;
                }
            }
            return null;
        }

        private n a(n n1, n n2, Object obj, x x1, com.google.a.b.j j1)
        {
            a(obj, x1, j1);
            l.remove(n2);
            m.remove(n2);
            if (x1.c())
            {
                x1.a(null);
                return n1;
            } else
            {
                return b(n1, n2);
            }
        }

        private n a(Object obj, int i1, long l1)
        {
            obj = e(obj, i1);
            if (obj == null)
            {
                return null;
            }
            if (a.a(((n) (obj)), l1))
            {
                a(l1);
                return null;
            } else
            {
                return ((n) (obj));
            }
        }

        private n a(Object obj, int i1, n n1)
        {
            return a.r.a(this, com.google.a.a.g.a(obj), i1, n1);
        }

        private Object a(n n1, Object obj, int i1, Object obj1, long l1, com.google.a.b.c c1)
        {
            Object obj2 = obj1;
            if (a.e())
            {
                obj2 = obj1;
                if (l1 - n1.h() > a.n)
                {
                    obj2 = obj1;
                    if (!n1.a().c())
                    {
                        n1 = ((n) (c(obj, i1, c1)));
                        obj2 = obj1;
                        if (n1 != null)
                        {
                            obj2 = n1;
                        }
                    }
                }
            }
            return obj2;
        }

        private Object a(n n1, Object obj, x x1)
        {
            if (!x1.c())
            {
                throw new AssertionError();
            }
            boolean flag;
            if (!Thread.holdsLock(n1))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            com.google.a.a.g.b(flag, "Recursive load of: %s", new Object[] {
                obj
            });
            x1 = ((x) (x1.e()));
            if (x1 != null)
            {
                break MISSING_BLOCK_LABEL_118;
            }
            n1 = String.valueOf(String.valueOf(obj));
            throw new c.a((new StringBuilder(n1.length() + 35)).append("CacheLoader returned null for key ").append(n1).append(".").toString());
            n1;
            n.b();
            throw n1;
            b(n1, a.q.a());
            n.b();
            return x1;
        }

        private static AtomicReferenceArray a(int i1)
        {
            return new AtomicReferenceArray(i1);
        }

        private void a(long l1)
        {
            if (!tryLock())
            {
                break MISSING_BLOCK_LABEL_16;
            }
            b(l1);
            unlock();
            return;
            Exception exception;
            exception;
            unlock();
            throw exception;
        }

        private void a(n n1)
        {
            a(n1, com.google.a.b.j.c);
            l.remove(n1);
            m.remove(n1);
        }

        private void a(n n1, Object obj, long l1)
        {
            x x1 = n1.a();
            com.google.a.b.n n2 = a.k;
            com.google.a.a.g.b(true, "Weights must be non-negative");
            n1.a(a.i.a(this, n1, obj));
            e();
            c = c + 1L;
            if (a.d())
            {
                n1.a(l1);
            }
            if (a.g())
            {
                n1.b(l1);
            }
            m.add(n1);
            l.add(n1);
            x1.a(obj);
        }

        private void a(Object obj, x x1, com.google.a.b.j j1)
        {
            c = c - (long)x1.a();
            if (j1.a())
            {
                n.c();
            }
            if (a.o != com.google.a.b.f.v)
            {
                obj = new com.google.a.b.l(obj, x1.get(), j1);
                a.o.offer(obj);
            }
        }

        private boolean a(n n1, int i1)
        {
            lock();
            n n3;
            AtomicReferenceArray atomicreferencearray;
            int j1 = b;
            atomicreferencearray = f;
            i1 &= atomicreferencearray.length() - 1;
            n3 = (n)atomicreferencearray.get(i1);
            n n2 = n3;
_L2:
            if (n2 == null)
            {
                break; /* Loop/switch isn't completed */
            }
            if (n2 != n1)
            {
                break MISSING_BLOCK_LABEL_113;
            }
            d = d + 1;
            n1 = a(n3, n2, n2.d(), n2.a(), com.google.a.b.j.c);
            int k1 = b;
            atomicreferencearray.set(i1, n1);
            b = k1 - 1;
            unlock();
            b();
            return true;
            n2 = n2.b();
            if (true) goto _L2; else goto _L1
_L1:
            unlock();
            b();
            return false;
            n1;
            unlock();
            b();
            throw n1;
        }

        private boolean a(n n1, int i1, com.google.a.b.j j1)
        {
            int k1 = b;
            AtomicReferenceArray atomicreferencearray = f;
            i1 &= atomicreferencearray.length() - 1;
            n n3 = (n)atomicreferencearray.get(i1);
            for (n n2 = n3; n2 != null; n2 = n2.b())
            {
                if (n2 == n1)
                {
                    d = d + 1;
                    n1 = a(n3, n2, n2.d(), n2.a(), j1);
                    int l1 = b;
                    atomicreferencearray.set(i1, n1);
                    b = l1 - 1;
                    return true;
                }
            }

            return false;
        }

        private boolean a(Object obj, int i1, j j1)
        {
            lock();
            n n2;
            AtomicReferenceArray atomicreferencearray;
            int k1;
            atomicreferencearray = f;
            k1 = i1 & atomicreferencearray.length() - 1;
            n2 = (n)atomicreferencearray.get(k1);
            n n1 = n2;
_L6:
            if (n1 == null)
            {
                break; /* Loop/switch isn't completed */
            }
            Object obj1 = n1.d();
            if (n1.c() != i1 || obj1 == null)
            {
                break MISSING_BLOCK_LABEL_161;
            }
            if (!a.f.a(obj, obj1))
            {
                break MISSING_BLOCK_LABEL_161;
            }
            if (n1.a() != j1)
            {
                break MISSING_BLOCK_LABEL_151;
            }
            if (!j1.d()) goto _L2; else goto _L1
_L1:
            n1.a(j1.a);
_L4:
            unlock();
            b();
            return true;
_L2:
            atomicreferencearray.set(k1, b(n2, n1));
            if (true) goto _L4; else goto _L3
_L3:
            obj;
            unlock();
            b();
            throw obj;
            unlock();
            b();
            return false;
            n1 = n1.b();
            if (true) goto _L6; else goto _L5
_L5:
            unlock();
            b();
            return false;
        }

        private boolean a(Object obj, int i1, j j1, Object obj1)
        {
            lock();
            int l1;
            long l2;
            l2 = a.q.a();
            c(l2);
            l1 = b + 1;
            int k1 = l1;
            Object obj3;
            Object obj4;
            if (l1 > e)
            {
                g();
                k1 = b + 1;
            }
            obj4 = f;
            l1 = i1 & ((AtomicReferenceArray) (obj4)).length() - 1;
            obj3 = (n)((AtomicReferenceArray) (obj4)).get(l1);
            Object obj2 = obj3;
_L13:
            if (obj2 == null) goto _L2; else goto _L1
_L1:
            Object obj5 = ((n) (obj2)).d();
            if (((n) (obj2)).c() != i1 || obj5 == null) goto _L4; else goto _L3
_L3:
            if (!a.f.a(obj, obj5)) goto _L4; else goto _L5
_L5:
            obj3 = ((n) (obj2)).a();
            obj4 = ((x) (obj3)).get();
            if (j1 == obj3) goto _L7; else goto _L6
_L6:
            if (obj4 != null) goto _L9; else goto _L8
_L8:
            if (obj3 == com.google.a.b.f.u) goto _L9; else goto _L7
_L7:
            d = d + 1;
            if (!j1.d())
            {
                break MISSING_BLOCK_LABEL_354;
            }
            if (obj4 != null) goto _L11; else goto _L10
_L10:
            obj3 = com.google.a.b.j.c;
_L12:
            a(obj, ((x) (j1)), ((com.google.a.b.j) (obj3)));
            i1 = k1 - 1;
_L14:
            a(((n) (obj2)), obj1, l2);
            b = i1;
            f();
            unlock();
            b();
            return true;
_L11:
            obj3 = com.google.a.b.j.b;
              goto _L12
_L9:
            a(obj, ((x) (new ae(obj1))), com.google.a.b.j.b);
            unlock();
            b();
            return false;
_L4:
            obj2 = ((n) (obj2)).b();
              goto _L13
_L2:
            d = d + 1;
            obj = a(obj, i1, ((n) (obj3)));
            a(((n) (obj)), obj1, l2);
            ((AtomicReferenceArray) (obj4)).set(l1, obj);
            b = k1;
            f();
            unlock();
            b();
            return true;
            obj;
            unlock();
            b();
            throw obj;
            i1 = k1;
              goto _L14
        }

        private boolean a(Object obj, int i1, x x1)
        {
            boolean flag;
            flag = false;
            lock();
            n n2;
            AtomicReferenceArray atomicreferencearray;
            int j1;
            j1 = b;
            atomicreferencearray = f;
            j1 = i1 & atomicreferencearray.length() - 1;
            n2 = (n)atomicreferencearray.get(j1);
            n n1 = n2;
_L12:
            if (n1 == null) goto _L2; else goto _L1
_L1:
            Object obj1 = n1.d();
            if (n1.c() != i1 || obj1 == null) goto _L4; else goto _L3
_L3:
            if (!a.f.a(obj, obj1)) goto _L4; else goto _L5
_L5:
            if (n1.a() != x1) goto _L7; else goto _L6
_L6:
            d = d + 1;
            obj = a(n2, n1, obj1, x1, com.google.a.b.j.c);
            i1 = b;
            atomicreferencearray.set(j1, obj);
            b = i1 - 1;
            unlock();
            if (!isHeldByCurrentThread())
            {
                b();
            }
            flag = true;
_L9:
            return flag;
_L7:
            unlock();
            if (isHeldByCurrentThread()) goto _L9; else goto _L8
_L8:
            b();
            return false;
_L4:
            n1 = n1.b();
            continue; /* Loop/switch isn't completed */
_L2:
            unlock();
            if (isHeldByCurrentThread()) goto _L9; else goto _L10
_L10:
            b();
            return false;
            obj;
            unlock();
            if (!isHeldByCurrentThread())
            {
                b();
            }
            throw obj;
            if (true) goto _L12; else goto _L11
_L11:
        }

        private n b(n n1, n n2)
        {
            int i1 = b;
            n n4 = n2.b();
            n n3 = n1;
            n1 = n4;
            while (n3 != n2) 
            {
                n n5 = a(n3, n1);
                if (n5 != null)
                {
                    n1 = n5;
                } else
                {
                    a(n3);
                    i1--;
                }
                n3 = n3.b();
            }
            b = i1;
            return n1;
        }

        private Object b(Object obj, int i1, com.google.a.b.c c1)
        {
            lock();
            n n2;
            AtomicReferenceArray atomicreferencearray;
            int j1;
            int k1;
            long l1;
            l1 = a.q.a();
            c(l1);
            j1 = b;
            atomicreferencearray = f;
            k1 = i1 & atomicreferencearray.length() - 1;
            n2 = (n)atomicreferencearray.get(k1);
            n n1 = n2;
_L14:
            if (n1 == null)
            {
                break MISSING_BLOCK_LABEL_410;
            }
            Object obj1 = n1.d();
            if (n1.c() != i1 || obj1 == null) goto _L2; else goto _L1
_L1:
            if (!a.f.a(obj, obj1)) goto _L2; else goto _L3
_L3:
            x x1 = n1.a();
            if (!x1.c()) goto _L5; else goto _L4
_L4:
            j1 = 0;
_L12:
            if (j1 == 0) goto _L7; else goto _L6
_L6:
            obj1 = new j();
            if (n1 != null) goto _L9; else goto _L8
_L8:
            n1 = a(obj, i1, n2);
            n1.a(((x) (obj1)));
            atomicreferencearray.set(k1, n1);
_L15:
            unlock();
            b();
            if (j1 == 0) goto _L11; else goto _L10
_L10:
            n1;
            JVM INSTR monitorenter ;
            obj = a(obj, i1, ((j) (obj1)), ((j) (obj1)).a(obj, c1));
            n1;
            JVM INSTR monitorexit ;
            n.b();
            return obj;
_L5:
            Object obj2 = x1.get();
            if (obj2 != null)
            {
                break MISSING_BLOCK_LABEL_285;
            }
            a(obj1, x1, com.google.a.b.j.c);
_L13:
            l.remove(n1);
            m.remove(n1);
            b = j1 - 1;
            j1 = 1;
              goto _L12
            if (!a.a(n1, l1))
            {
                break MISSING_BLOCK_LABEL_324;
            }
            a(obj1, x1, com.google.a.b.j.d);
              goto _L13
            obj;
            unlock();
            b();
            throw obj;
            c(n1, l1);
            n.a();
            unlock();
            b();
            return obj2;
_L2:
            n1 = n1.b();
              goto _L14
_L9:
            n1.a(((x) (obj1)));
              goto _L15
            obj;
            n1;
            JVM INSTR monitorexit ;
            throw obj;
            obj;
            n.b();
            throw obj;
_L11:
            return a(n1, obj, x1);
_L7:
            obj1 = null;
              goto _L15
            x1 = null;
            j1 = 1;
              goto _L12
        }

        private void b(long l1)
        {
            e();
            do
            {
                n n1 = (n)l.peek();
                if (n1 != null && a.a(n1, l1))
                {
                    if (!a(n1, n1.c(), com.google.a.b.j.d))
                    {
                        throw new AssertionError();
                    }
                } else
                {
                    do
                    {
                        n n2 = (n)m.peek();
                        if (n2 != null && a.a(n2, l1))
                        {
                            if (!a(n2, n2.c(), com.google.a.b.j.d))
                            {
                                throw new AssertionError();
                            }
                        } else
                        {
                            return;
                        }
                    } while (true);
                }
            } while (true);
        }

        private void b(n n1, long l1)
        {
            if (a.d())
            {
                n1.a(l1);
            }
            j.add(n1);
        }

        private Object c(Object obj, int i1, com.google.a.b.c c1)
        {
            j j1 = d(obj, i1);
            if (j1 == null)
            {
                return null;
            }
            c1 = j1.a(obj, c1);
            c1.a(new Runnable(this, obj, i1, j1, c1) {

                final Object a;
                final int b;
                final j c;
                final com.google.a.g.a.j d;
                final o e;

                public final void run()
                {
                    try
                    {
                        e.a(a, b, c, d);
                        return;
                    }
                    catch (Throwable throwable)
                    {
                        com.google.a.b.f.a.log(Level.WARNING, "Exception thrown during refresh", throwable);
                        c.a(throwable);
                        return;
                    }
                }

            
            {
                e = o1;
                a = obj;
                b = i1;
                c = j1;
                d = j2;
                super();
            }
            }, com.google.a.g.a.o.a.a);
            if (!c1.isDone())
            {
                break MISSING_BLOCK_LABEL_62;
            }
            obj = com.google.a.g.a.r.a(c1);
            return obj;
            obj;
            return null;
        }

        private void c()
        {
            if (!tryLock())
            {
                break MISSING_BLOCK_LABEL_15;
            }
            d();
            unlock();
            return;
            Exception exception;
            exception;
            unlock();
            throw exception;
        }

        private void c(long l1)
        {
            if (!tryLock())
            {
                break MISSING_BLOCK_LABEL_28;
            }
            d();
            b(l1);
            k.set(0);
            unlock();
            return;
            Exception exception;
            exception;
            unlock();
            throw exception;
        }

        private void c(n n1, long l1)
        {
            if (a.d())
            {
                n1.a(l1);
            }
            m.add(n1);
        }

        private j d(Object obj, int i1)
        {
            lock();
            n n1;
            AtomicReferenceArray atomicreferencearray;
            int j1;
            long l1;
            l1 = a.q.a();
            c(l1);
            atomicreferencearray = f;
            j1 = i1 & atomicreferencearray.length() - 1;
            n1 = (n)atomicreferencearray.get(j1);
            Object obj1 = n1;
_L1:
            if (obj1 == null)
            {
                break MISSING_BLOCK_LABEL_197;
            }
            Object obj2 = ((n) (obj1)).d();
            if (((n) (obj1)).c() != i1 || obj2 == null)
            {
                break MISSING_BLOCK_LABEL_187;
            }
            long l2;
            long l3;
            if (!a.f.a(obj, obj2))
            {
                break MISSING_BLOCK_LABEL_187;
            }
            obj = ((n) (obj1)).a();
            if (((x) (obj)).c())
            {
                break MISSING_BLOCK_LABEL_141;
            }
            l2 = ((n) (obj1)).h();
            l3 = a.n;
            if (l1 - l2 >= l3)
            {
                break MISSING_BLOCK_LABEL_151;
            }
            unlock();
            b();
            return null;
            d = d + 1;
            obj = new j(((x) (obj)));
            ((n) (obj1)).a(((x) (obj)));
            unlock();
            b();
            return ((j) (obj));
            obj1 = ((n) (obj1)).b();
              goto _L1
            d = d + 1;
            obj1 = new j();
            obj = a(obj, i1, n1);
            ((n) (obj)).a(((x) (obj1)));
            atomicreferencearray.set(j1, obj);
            unlock();
            b();
            return ((j) (obj1));
            obj;
            unlock();
            b();
            throw obj;
        }

        private void d()
        {
            int k1 = 0;
            if (a.h())
            {
                int i1 = 0;
                do
                {
                    Object obj = h.poll();
                    if (obj == null)
                    {
                        break;
                    }
                    obj = (n)obj;
                    com.google.a.b.f f1 = a;
                    int l1 = ((n) (obj)).c();
                    f1.a(l1).a(((n) (obj)), l1);
                    i1++;
                } while (i1 != 16);
            }
            if (a.i())
            {
                int j1 = k1;
                do
                {
                    Object obj1 = i.poll();
                    if (obj1 == null)
                    {
                        break;
                    }
                    obj1 = (x)obj1;
                    com.google.a.b.f f2 = a;
                    n n1 = ((x) (obj1)).b();
                    k1 = n1.c();
                    f2.a(k1).a(n1.d(), k1, ((x) (obj1)));
                    k1 = j1 + 1;
                    j1 = k1;
                } while (k1 != 16);
            }
        }

        private n e(Object obj, int i1)
        {
            Object obj1;
            obj1 = f;
            obj1 = (n)((AtomicReferenceArray) (obj1)).get(((AtomicReferenceArray) (obj1)).length() - 1 & i1);
_L2:
            Object obj2;
            if (obj1 == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            if (((n) (obj1)).c() == i1)
            {
                obj2 = ((n) (obj1)).d();
                if (obj2 != null)
                {
                    break; /* Loop/switch isn't completed */
                }
                c();
            }
_L4:
            obj1 = ((n) (obj1)).b();
            if (true) goto _L2; else goto _L1
_L1:
            if (!a.f.a(obj, obj2)) goto _L4; else goto _L3
_L3:
            return ((n) (obj1));
            return null;
        }

        private void e()
        {
            do
            {
                n n1 = (n)j.poll();
                if (n1 == null)
                {
                    break;
                }
                if (m.contains(n1))
                {
                    m.add(n1);
                }
            } while (true);
        }

        private void f()
        {
            if (a.a())
            {
                e();
                while (c > g) 
                {
label0:
                    {
                        Iterator iterator = m.iterator();
                        n n1;
                        do
                        {
                            if (!iterator.hasNext())
                            {
                                break label0;
                            }
                            n1 = (n)iterator.next();
                        } while (n1.a().a() <= 0);
                        if (!a(n1, n1.c(), com.google.a.b.j.e))
                        {
                            throw new AssertionError();
                        }
                    }
                }
            }
            return;
            throw new AssertionError();
        }

        private void g()
        {
            AtomicReferenceArray atomicreferencearray;
            AtomicReferenceArray atomicreferencearray1;
            int i1;
            int k1;
            int i2;
            int j2;
            atomicreferencearray = f;
            i2 = atomicreferencearray.length();
            if (i2 >= 0x40000000)
            {
                return;
            }
            i1 = b;
            atomicreferencearray1 = a(i2 << 1);
            e = (atomicreferencearray1.length() * 3) / 4;
            j2 = atomicreferencearray1.length() - 1;
            k1 = 0;
_L2:
            n n1;
            n n2;
            int j1;
            if (k1 >= i2)
            {
                break MISSING_BLOCK_LABEL_257;
            }
            n2 = (n)atomicreferencearray.get(k1);
            if (n2 != null)
            {
                n1 = n2.b();
                j1 = n2.c() & j2;
                if (n1 != null)
                {
                    break; /* Loop/switch isn't completed */
                }
                atomicreferencearray1.set(j1, n2);
            }
_L4:
            k1++;
            if (true) goto _L2; else goto _L1
_L1:
            n n4;
            n4 = n2;
            for (; n1 != null; n1 = n1.b())
            {
                int l1 = n1.c() & j2;
                if (l1 != j1)
                {
                    n4 = n1;
                    j1 = l1;
                }
            }

            atomicreferencearray1.set(j1, n4);
            n1 = n2;
            j1 = i1;
_L5:
            i1 = j1;
            if (n1 == n4) goto _L4; else goto _L3
_L3:
            i1 = n1.c() & j2;
            n n3 = a(n1, (n)atomicreferencearray1.get(i1));
            if (n3 != null)
            {
                atomicreferencearray1.set(i1, n3);
                i1 = j1;
            } else
            {
                a(n1);
                i1 = j1 - 1;
            }
            n1 = n1.b();
            j1 = i1;
              goto _L5
              goto _L4
            f = atomicreferencearray1;
            b = i1;
            return;
        }

        final Object a(n n1, long l1)
        {
            if (n1.d() == null)
            {
                c();
                return null;
            }
            Object obj = n1.a().get();
            if (obj == null)
            {
                c();
                return null;
            }
            if (a.a(n1, l1))
            {
                a(l1);
                return null;
            } else
            {
                return obj;
            }
        }

        final Object a(Object obj, int i1)
        {
            long l1;
            if (b == 0)
            {
                break MISSING_BLOCK_LABEL_94;
            }
            l1 = a.q.a();
            obj = a(obj, i1, l1);
            if (obj == null)
            {
                a();
                return null;
            }
            Object obj1 = ((n) (obj)).a().get();
            if (obj1 == null)
            {
                break MISSING_BLOCK_LABEL_90;
            }
            b(((n) (obj)), l1);
            obj = a(((n) (obj)), ((n) (obj)).d(), i1, obj1, l1, a.t);
            a();
            return obj;
            c();
            a();
            return null;
            obj;
            a();
            throw obj;
        }

        final Object a(Object obj, int i1, com.google.a.b.c c1)
        {
            com.google.a.a.g.a(obj);
            com.google.a.a.g.a(c1);
            n n1;
            if (b == 0)
            {
                break MISSING_BLOCK_LABEL_129;
            }
            n1 = e(obj, i1);
            if (n1 == null)
            {
                break MISSING_BLOCK_LABEL_129;
            }
            Object obj1;
            long l1;
            l1 = a.q.a();
            obj1 = a(n1, l1);
            if (obj1 == null)
            {
                break MISSING_BLOCK_LABEL_94;
            }
            b(n1, l1);
            n.a();
            obj = a(n1, obj, i1, obj1, l1, c1);
            a();
            return obj;
            x x1 = n1.a();
            if (!x1.c())
            {
                break MISSING_BLOCK_LABEL_129;
            }
            obj = a(n1, obj, x1);
            a();
            return obj;
            obj = b(obj, i1, c1);
            a();
            return obj;
            obj;
            c1 = ((ExecutionException) (obj)).getCause();
            if (c1 instanceof Error)
            {
                throw new com.google.a.g.a.d((Error)c1);
            }
            break MISSING_BLOCK_LABEL_175;
            obj;
            a();
            throw obj;
            if (c1 instanceof RuntimeException)
            {
                throw new com.google.a.g.a.q(c1);
            } else
            {
                throw obj;
            }
        }

        final Object a(Object obj, int i1, j j1, com.google.a.g.a.j j2)
        {
            com.google.a.g.a.j j3 = null;
            j2 = ((com.google.a.g.a.j) (com.google.a.g.a.r.a(j2)));
            if (j2 != null)
            {
                break MISSING_BLOCK_LABEL_104;
            }
            j3 = j2;
            String s1 = String.valueOf(String.valueOf(obj));
            j3 = j2;
            throw new c.a((new StringBuilder(s1.length() + 35)).append("CacheLoader returned null for key ").append(s1).append(".").toString());
            j2;
            if (j3 == null)
            {
                n.b(j1.f());
                a(obj, i1, j1);
            }
            throw j2;
            j3 = j2;
            n.a(j1.f());
            j3 = j2;
            a(obj, i1, j1, j2);
            if (j2 == null)
            {
                n.b(j1.f());
                a(obj, i1, j1);
            }
            return j2;
        }

        final Object a(Object obj, int i1, Object obj1)
        {
            lock();
            n n2;
            AtomicReferenceArray atomicreferencearray;
            int j1;
            long l1;
            l1 = a.q.a();
            c(l1);
            atomicreferencearray = f;
            j1 = i1 & atomicreferencearray.length() - 1;
            n2 = (n)atomicreferencearray.get(j1);
            n n1 = n2;
_L2:
            if (n1 == null)
            {
                break; /* Loop/switch isn't completed */
            }
            Object obj2 = n1.d();
            if (n1.c() != i1 || obj2 == null)
            {
                break MISSING_BLOCK_LABEL_239;
            }
            x x1;
            Object obj3;
            if (!a.f.a(obj, obj2))
            {
                break MISSING_BLOCK_LABEL_239;
            }
            x1 = n1.a();
            obj3 = x1.get();
            if (obj3 != null)
            {
                break MISSING_BLOCK_LABEL_195;
            }
            if (x1.d())
            {
                i1 = b;
                d = d + 1;
                obj = a(n2, n1, obj2, x1, com.google.a.b.j.c);
                i1 = b;
                atomicreferencearray.set(j1, obj);
                b = i1 - 1;
            }
            unlock();
            b();
            return null;
            d = d + 1;
            a(obj, x1, com.google.a.b.j.b);
            a(n1, obj1, l1);
            f();
            unlock();
            b();
            return obj3;
            n1 = n1.b();
            if (true) goto _L2; else goto _L1
_L1:
            unlock();
            b();
            return null;
            obj;
            unlock();
            b();
            throw obj;
        }

        final Object a(Object obj, int i1, Object obj1, boolean flag)
        {
            lock();
            Object obj3;
            Object obj4;
            int k1;
            long l1;
            l1 = a.q.a();
            c(l1);
            if (b + 1 > e)
            {
                g();
                int j1 = b;
            }
            obj4 = f;
            k1 = i1 & ((AtomicReferenceArray) (obj4)).length() - 1;
            obj3 = (n)((AtomicReferenceArray) (obj4)).get(k1);
            Object obj2 = obj3;
_L2:
            if (obj2 == null)
            {
                break MISSING_BLOCK_LABEL_309;
            }
            Object obj5 = ((n) (obj2)).d();
            if (((n) (obj2)).c() != i1 || obj5 == null)
            {
                break MISSING_BLOCK_LABEL_297;
            }
            if (!a.f.a(obj, obj5))
            {
                break MISSING_BLOCK_LABEL_297;
            }
            obj3 = ((n) (obj2)).a();
            obj4 = ((x) (obj3)).get();
            if (obj4 != null)
            {
                break MISSING_BLOCK_LABEL_229;
            }
            d = d + 1;
            if (!((x) (obj3)).d())
            {
                break MISSING_BLOCK_LABEL_210;
            }
            a(obj, ((x) (obj3)), com.google.a.b.j.c);
            a(((n) (obj2)), obj1, l1);
            i1 = b;
_L1:
            b = i1;
            f();
            unlock();
            b();
            return null;
            a(((n) (obj2)), obj1, l1);
            i1 = b + 1;
              goto _L1
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_253;
            }
            c(((n) (obj2)), l1);
            unlock();
            b();
            return obj4;
            d = d + 1;
            a(obj, ((x) (obj3)), com.google.a.b.j.b);
            a(((n) (obj2)), obj1, l1);
            f();
            unlock();
            b();
            return obj4;
            obj2 = ((n) (obj2)).b();
              goto _L2
            d = d + 1;
            obj = a(obj, i1, ((n) (obj3)));
            a(((n) (obj)), obj1, l1);
            ((AtomicReferenceArray) (obj4)).set(k1, obj);
            b = b + 1;
            f();
            unlock();
            b();
            return null;
            obj;
            unlock();
            b();
            throw obj;
        }

        final void a()
        {
            if ((k.incrementAndGet() & 0x3f) == 0)
            {
                c(a.q.a());
                b();
            }
        }

        final void a(n n1, com.google.a.b.j j1)
        {
            Object obj = n1.d();
            n1.c();
            a(obj, n1.a(), j1);
        }

        final boolean a(Object obj, int i1, Object obj1, Object obj2)
        {
            lock();
            n n2;
            AtomicReferenceArray atomicreferencearray;
            int j1;
            long l1;
            l1 = a.q.a();
            c(l1);
            atomicreferencearray = f;
            j1 = i1 & atomicreferencearray.length() - 1;
            n2 = (n)atomicreferencearray.get(j1);
            n n1 = n2;
_L2:
            if (n1 == null)
            {
                break; /* Loop/switch isn't completed */
            }
            Object obj3 = n1.d();
            if (n1.c() != i1 || obj3 == null)
            {
                break MISSING_BLOCK_LABEL_273;
            }
            x x1;
            Object obj4;
            if (!a.f.a(obj, obj3))
            {
                break MISSING_BLOCK_LABEL_273;
            }
            x1 = n1.a();
            obj4 = x1.get();
            if (obj4 != null)
            {
                break MISSING_BLOCK_LABEL_195;
            }
            if (x1.d())
            {
                i1 = b;
                d = d + 1;
                obj = a(n2, n1, obj3, x1, com.google.a.b.j.c);
                i1 = b;
                atomicreferencearray.set(j1, obj);
                b = i1 - 1;
            }
            unlock();
            b();
            return false;
            if (!a.g.a(obj1, obj4))
            {
                break MISSING_BLOCK_LABEL_255;
            }
            d = d + 1;
            a(obj, x1, com.google.a.b.j.b);
            a(n1, obj2, l1);
            f();
            unlock();
            b();
            return true;
            c(n1, l1);
            unlock();
            b();
            return false;
            n1 = n1.b();
            if (true) goto _L2; else goto _L1
_L1:
            unlock();
            b();
            return false;
            obj;
            unlock();
            b();
            throw obj;
        }

        final void b()
        {
            if (!isHeldByCurrentThread())
            {
                for (com.google.a.b.f f1 = a; (com.google.a.b.l)f1.o.poll() != null;) { }
            }
        }

        final boolean b(Object obj, int i1)
        {
            boolean flag = false;
            if (b == 0)
            {
                break MISSING_BLOCK_LABEL_60;
            }
            obj = a(obj, i1, a.q.a());
            if (obj == null)
            {
                a();
                return false;
            }
            obj = ((n) (obj)).a().get();
            if (obj != null)
            {
                flag = true;
            }
            a();
            return flag;
            a();
            return false;
            obj;
            a();
            throw obj;
        }

        final boolean b(Object obj, int i1, Object obj1)
        {
            lock();
            n n2;
            AtomicReferenceArray atomicreferencearray;
            int j1;
            c(a.q.a());
            j1 = b;
            atomicreferencearray = f;
            j1 = i1 & atomicreferencearray.length() - 1;
            n2 = (n)atomicreferencearray.get(j1);
            n n1 = n2;
_L5:
            if (n1 == null)
            {
                break; /* Loop/switch isn't completed */
            }
            Object obj2 = n1.d();
            if (n1.c() != i1 || obj2 == null)
            {
                break MISSING_BLOCK_LABEL_243;
            }
            x x1;
            if (!a.f.a(obj, obj2))
            {
                break MISSING_BLOCK_LABEL_243;
            }
            x1 = n1.a();
            obj = x1.get();
            if (!a.g.a(obj1, obj)) goto _L2; else goto _L1
_L1:
            obj = com.google.a.b.j.a;
_L3:
            d = d + 1;
            obj1 = a(n2, n1, obj2, x1, ((com.google.a.b.j) (obj)));
            i1 = b;
            atomicreferencearray.set(j1, obj1);
            b = i1 - 1;
            obj1 = com.google.a.b.j.a;
            boolean flag;
            if (obj == obj1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            unlock();
            b();
            return flag;
_L2:
            if (obj != null)
            {
                break MISSING_BLOCK_LABEL_227;
            }
            if (!x1.d())
            {
                break MISSING_BLOCK_LABEL_227;
            }
            obj = com.google.a.b.j.c;
              goto _L3
            unlock();
            b();
            return false;
            n1 = n1.b();
            if (true) goto _L5; else goto _L4
_L4:
            unlock();
            b();
            return false;
            obj;
            unlock();
            b();
            throw obj;
        }

        final Object c(Object obj, int i1)
        {
            lock();
            n n2;
            AtomicReferenceArray atomicreferencearray;
            int j1;
            c(a.q.a());
            j1 = b;
            atomicreferencearray = f;
            j1 = i1 & atomicreferencearray.length() - 1;
            n2 = (n)atomicreferencearray.get(j1);
            n n1 = n2;
_L3:
            if (n1 == null)
            {
                break; /* Loop/switch isn't completed */
            }
            Object obj1 = n1.d();
            if (n1.c() != i1 || obj1 == null)
            {
                break MISSING_BLOCK_LABEL_206;
            }
            Object obj2;
            x x1;
            if (!a.f.a(obj, obj1))
            {
                break MISSING_BLOCK_LABEL_206;
            }
            x1 = n1.a();
            obj2 = x1.get();
            if (obj2 == null)
            {
                break MISSING_BLOCK_LABEL_179;
            }
            obj = com.google.a.b.j.a;
_L1:
            d = d + 1;
            obj = a(n2, n1, obj1, x1, ((com.google.a.b.j) (obj)));
            i1 = b;
            atomicreferencearray.set(j1, obj);
            b = i1 - 1;
            unlock();
            b();
            return obj2;
label0:
            {
                if (!x1.d())
                {
                    break label0;
                }
                obj = com.google.a.b.j.c;
            }
              goto _L1
            unlock();
            b();
            return null;
            n1 = n1.b();
            if (true) goto _L3; else goto _L2
_L2:
            unlock();
            b();
            return null;
            obj;
            unlock();
            b();
            throw obj;
        }

        o(com.google.a.b.f f1, int i1, long l1, a.b b1)
        {
            Object obj = null;
            super();
            a = f1;
            g = l1;
            n = (a.b)com.google.a.a.g.a(b1);
            b1 = a(i1);
            e = (b1.length() * 3) / 4;
            if (!a.b() && (long)e == g)
            {
                e = e + 1;
            }
            f = b1;
            if (f1.h())
            {
                b1 = new ReferenceQueue();
            } else
            {
                b1 = null;
            }
            h = b1;
            b1 = obj;
            if (f1.i())
            {
                b1 = new ReferenceQueue();
            }
            i = b1;
            if (f1.f())
            {
                b1 = new ConcurrentLinkedQueue();
            } else
            {
                b1 = com.google.a.b.f.l();
            }
            j = b1;
            if (f1.c())
            {
                b1 = new af();
            } else
            {
                b1 = com.google.a.b.f.l();
            }
            l = b1;
            if (f1.f())
            {
                f1 = new c();
            } else
            {
                f1 = com.google.a.b.f.l();
            }
            m = f1;
        }
    }

    static final class p extends SoftReference
        implements x
    {

        final n a;

        public final int a()
        {
            return 1;
        }

        public final x a(ReferenceQueue referencequeue, Object obj, n n1)
        {
            return new p(referencequeue, obj, n1);
        }

        public final void a(Object obj)
        {
        }

        public final n b()
        {
            return a;
        }

        public final boolean c()
        {
            return false;
        }

        public final boolean d()
        {
            return true;
        }

        public final Object e()
        {
            return get();
        }

        p(ReferenceQueue referencequeue, Object obj, n n1)
        {
            super(obj, referencequeue);
            a = n1;
        }
    }

    static abstract class q extends Enum
    {

        public static final q a;
        public static final q b;
        public static final q c;
        private static final q d[];

        public static q valueOf(String s1)
        {
            return (q)Enum.valueOf(com/google/a/b/f$q, s1);
        }

        public static q[] values()
        {
            return (q[])d.clone();
        }

        abstract com.google.a.a.b a();

        abstract x a(o o1, n n1, Object obj);

        static 
        {
            a = new q("STRONG") {

                final com.google.a.a.b a()
                {
                    return com.google.a.a.b.a.a;
                }

                final x a(o o1, n n1, Object obj)
                {
                    return new u(obj);
                }

            };
            b = new q("SOFT") {

                final com.google.a.a.b a()
                {
                    return com.google.a.a.b.b.a;
                }

                final x a(o o1, n n1, Object obj)
                {
                    return new p(o1.i, obj, n1);
                }

            };
            c = new q("WEAK") {

                final com.google.a.a.b a()
                {
                    return com.google.a.a.b.b.a;
                }

                final x a(o o1, n n1, Object obj)
                {
                    return new ac(o1.i, obj, n1);
                }

            };
            d = (new q[] {
                a, b, c
            });
        }

        private q(String s1, int i1)
        {
            super(s1, i1);
        }

        q(String s1, int i1, byte byte0)
        {
            this(s1, i1);
        }
    }

    static final class r extends t
    {

        volatile long a;
        n b;
        n c;

        public final void a(long l1)
        {
            a = l1;
        }

        public final void a(n n1)
        {
            b = n1;
        }

        public final void b(n n1)
        {
            c = n1;
        }

        public final long e()
        {
            return a;
        }

        public final n f()
        {
            return b;
        }

        public final n g()
        {
            return c;
        }

        r(Object obj, int i1, n n1)
        {
            super(obj, i1, n1);
            a = 0x7fffffffffffffffL;
            b = com.google.a.b.f.k();
            c = com.google.a.b.f.k();
        }
    }

    static final class s extends t
    {

        volatile long a;
        n b;
        n c;
        volatile long d;
        n e;
        n f;

        public final void a(long l1)
        {
            a = l1;
        }

        public final void a(n n1)
        {
            b = n1;
        }

        public final void b(long l1)
        {
            d = l1;
        }

        public final void b(n n1)
        {
            c = n1;
        }

        public final void c(n n1)
        {
            e = n1;
        }

        public final void d(n n1)
        {
            f = n1;
        }

        public final long e()
        {
            return a;
        }

        public final n f()
        {
            return b;
        }

        public final n g()
        {
            return c;
        }

        public final long h()
        {
            return d;
        }

        public final n i()
        {
            return e;
        }

        public final n j()
        {
            return f;
        }

        s(Object obj, int i1, n n1)
        {
            super(obj, i1, n1);
            a = 0x7fffffffffffffffL;
            b = com.google.a.b.f.k();
            c = com.google.a.b.f.k();
            d = 0x7fffffffffffffffL;
            e = com.google.a.b.f.k();
            f = com.google.a.b.f.k();
        }
    }

    static class t extends b
    {

        final Object g;
        final int h;
        final n i;
        volatile x j;

        public final x a()
        {
            return j;
        }

        public final void a(x x1)
        {
            j = x1;
        }

        public final n b()
        {
            return i;
        }

        public final int c()
        {
            return h;
        }

        public final Object d()
        {
            return g;
        }

        t(Object obj, int i1, n n1)
        {
            j = com.google.a.b.f.j();
            g = obj;
            h = i1;
            i = n1;
        }
    }

    static class u
        implements x
    {

        final Object a;

        public int a()
        {
            return 1;
        }

        public final x a(ReferenceQueue referencequeue, Object obj, n n1)
        {
            return this;
        }

        public final void a(Object obj)
        {
        }

        public final n b()
        {
            return null;
        }

        public final boolean c()
        {
            return false;
        }

        public final boolean d()
        {
            return true;
        }

        public final Object e()
        {
            return get();
        }

        public Object get()
        {
            return a;
        }

        u(Object obj)
        {
            a = obj;
        }
    }

    static final class v extends t
    {

        volatile long a;
        n b;
        n c;

        public final void b(long l1)
        {
            a = l1;
        }

        public final void c(n n1)
        {
            b = n1;
        }

        public final void d(n n1)
        {
            c = n1;
        }

        public final long h()
        {
            return a;
        }

        public final n i()
        {
            return b;
        }

        public final n j()
        {
            return c;
        }

        v(Object obj, int i1, n n1)
        {
            super(obj, i1, n1);
            a = 0x7fffffffffffffffL;
            b = com.google.a.b.f.k();
            c = com.google.a.b.f.k();
        }
    }

    final class w extends g
    {

        final com.google.a.b.f a;

        public final Object next()
        {
            return a().getValue();
        }

        w()
        {
            a = com.google.a.b.f.this;
            super();
        }
    }

    static interface x
    {

        public abstract int a();

        public abstract x a(ReferenceQueue referencequeue, Object obj, n n1);

        public abstract void a(Object obj);

        public abstract n b();

        public abstract boolean c();

        public abstract boolean d();

        public abstract Object e();

        public abstract Object get();
    }

    final class y extends AbstractCollection
    {

        final com.google.a.b.f a;
        private final ConcurrentMap b;

        public final void clear()
        {
            b.clear();
        }

        public final boolean contains(Object obj)
        {
            return b.containsValue(obj);
        }

        public final boolean isEmpty()
        {
            return b.isEmpty();
        }

        public final Iterator iterator()
        {
            return a. new w();
        }

        public final int size()
        {
            return b.size();
        }

        y(ConcurrentMap concurrentmap)
        {
            a = com.google.a.b.f.this;
            super();
            b = concurrentmap;
        }
    }

    static final class z extends ab
    {

        volatile long a;
        n b;
        n c;

        public final void a(long l1)
        {
            a = l1;
        }

        public final void a(n n1)
        {
            b = n1;
        }

        public final void b(n n1)
        {
            c = n1;
        }

        public final long e()
        {
            return a;
        }

        public final n f()
        {
            return b;
        }

        public final n g()
        {
            return c;
        }

        z(ReferenceQueue referencequeue, Object obj, int i1, n n1)
        {
            super(referencequeue, obj, i1, n1);
            a = 0x7fffffffffffffffL;
            b = com.google.a.b.f.k();
            c = com.google.a.b.f.k();
        }
    }


    static final Logger a = Logger.getLogger(com/google/a/b/f.getName());
    static final x u = new x() {

        public final int a()
        {
            return 0;
        }

        public final x a(ReferenceQueue referencequeue, Object obj, n n1)
        {
            return this;
        }

        public final void a(Object obj)
        {
        }

        public final n b()
        {
            return null;
        }

        public final boolean c()
        {
            return false;
        }

        public final boolean d()
        {
            return false;
        }

        public final Object e()
        {
            return null;
        }

        public final Object get()
        {
            return null;
        }

    };
    static final Queue v = new AbstractQueue() {

        public final Iterator iterator()
        {
            return aj.g().a();
        }

        public final boolean offer(Object obj)
        {
            return true;
        }

        public final Object peek()
        {
            return null;
        }

        public final Object poll()
        {
            return null;
        }

        public final int size()
        {
            return 0;
        }

    };
    final int b;
    final int c;
    final o d[];
    final int e;
    final com.google.a.a.b f;
    final com.google.a.a.b g;
    final q h;
    final q i;
    final long j;
    final com.google.a.b.n k;
    final long l;
    final long m;
    final long n;
    final Queue o;
    final com.google.a.b.k p;
    final com.google.a.a.n q;
    final d r;
    final a.b s;
    final com.google.a.b.c t;
    Set w;
    Collection x;
    Set y;

    com.google.a.b.f(com.google.a.b.b b1, com.google.a.b.c c1)
    {
        boolean flag2 = true;
        long l4 = 0L;
        boolean flag1 = false;
        boolean flag = false;
        super();
        Object obj;
        int i1;
        int k1;
        int l1;
        long l2;
        boolean flag3;
        boolean flag4;
        if (b1.g == -1)
        {
            i1 = 4;
        } else
        {
            i1 = b1.g;
        }
        e = Math.min(i1, 0x10000);
        h = b1.c();
        i = b1.d();
        f = (com.google.a.a.b)com.google.a.a.e.a(b1.p, b1.c().a());
        g = (com.google.a.a.b)com.google.a.a.e.a(b1.q, b1.d().a());
        if (b1.m == 0L || b1.n == 0L)
        {
            l2 = 0L;
        } else
        if (b1.j == null)
        {
            l2 = b1.h;
        } else
        {
            l2 = b1.i;
        }
        j = l2;
        k = (com.google.a.b.n)com.google.a.a.e.a(b1.j, com.google.a.b.b.b.a);
        if (b1.n == -1L)
        {
            l2 = 0L;
        } else
        {
            l2 = b1.n;
        }
        l = l2;
        if (b1.m == -1L)
        {
            l2 = 0L;
        } else
        {
            l2 = b1.m;
        }
        m = l2;
        if (b1.o == -1L)
        {
            l2 = l4;
        } else
        {
            l2 = b1.o;
        }
        n = l2;
        p = (com.google.a.b.k)com.google.a.a.e.a(b1.r, com.google.a.b.b.a.a);
        if (p == com.google.a.b.b.a.a)
        {
            obj = v;
        } else
        {
            obj = new ConcurrentLinkedQueue();
        }
        o = ((Queue) (obj));
        if (g() || d())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (b1.s != null)
        {
            obj = b1.s;
        } else
        if (i1 != 0)
        {
            obj = com.google.a.a.n.b();
        } else
        {
            obj = com.google.a.b.b.d;
        }
        q = ((com.google.a.a.n) (obj));
        obj = h;
        if (f() || d())
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if (c() || g())
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
        r = com.google.a.b.d.a(((q) (obj)), flag3, flag4);
        s = (a.b)b1.t.a();
        t = c1;
        if (b1.f == -1)
        {
            i1 = 16;
        } else
        {
            i1 = b1.f;
        }
        i1 = Math.min(i1, 0x40000000);
        k1 = i1;
        if (a())
        {
            k1 = i1;
            if (!b())
            {
                k1 = Math.min(i1, (int)j);
            }
        }
        i1 = 1;
        l1 = 0;
        for (; i1 < e && (!a() || (long)(i1 * 20) <= j); i1 <<= 1)
        {
            l1++;
        }

        c = 32 - l1;
        b = i1 - 1;
        d = new o[i1];
        l1 = k1 / i1;
        if (l1 * i1 < k1)
        {
            l1++;
            k1 = ((flag2) ? 1 : 0);
        } else
        {
            k1 = ((flag2) ? 1 : 0);
        }
        for (; k1 < l1; k1 <<= 1) { }
        l1 = ((flag1) ? 1 : 0);
        if (a())
        {
            long l3 = j / (long)i1;
            long l5 = j;
            long l6 = i1;
            l3++;
            for (int j1 = ((flag) ? 1 : 0); j1 < d.length; j1++)
            {
                if ((long)j1 == l5 % l6)
                {
                    l3--;
                }
                d[j1] = a(k1, l3, (a.b)b1.t.a());
            }

        } else
        {
            for (; l1 < d.length; l1++)
            {
                d[l1] = a(k1, -1L, (a.b)b1.t.a());
            }

        }
    }

    private o a(int i1, long l1, a.b b1)
    {
        return new o(this, i1, l1, b1);
    }

    static void a(n n1)
    {
        m m1 = com.google.a.b.m.a;
        n1.a(m1);
        n1.b(m1);
    }

    static void a(n n1, n n2)
    {
        n1.a(n2);
        n2.b(n1);
    }

    static void b(n n1)
    {
        m m1 = com.google.a.b.m.a;
        n1.c(m1);
        n1.d(m1);
    }

    static void b(n n1, n n2)
    {
        n1.c(n2);
        n2.d(n1);
    }

    static x j()
    {
        return u;
    }

    static n k()
    {
        return com.google.a.b.m.a;
    }

    static Queue l()
    {
        return v;
    }

    final int a(Object obj)
    {
        int i1 = f.a(obj);
        i1 += i1 << 15 ^ 0xffffcd7d;
        i1 ^= i1 >>> 10;
        i1 += i1 << 3;
        i1 ^= i1 >>> 6;
        i1 += (i1 << 2) + (i1 << 14);
        return i1 ^ i1 >>> 16;
    }

    final o a(int i1)
    {
        return d[i1 >>> c & b];
    }

    final boolean a()
    {
        return j >= 0L;
    }

    final boolean a(n n1, long l1)
    {
        com.google.a.a.g.a(n1);
        while (d() && l1 - n1.e() >= l || c() && l1 - n1.h() >= m) 
        {
            return true;
        }
        return false;
    }

    final boolean b()
    {
        return k != com.google.a.b.b.b.a;
    }

    final boolean c()
    {
        return m > 0L;
    }

    public void clear()
    {
        o ao[];
        int i1;
        int k1;
        ao = d;
        k1 = ao.length;
        i1 = 0;
_L8:
        if (i1 >= k1) goto _L2; else goto _L1
_L1:
        o o1 = ao[i1];
        if (o1.b == 0) goto _L4; else goto _L3
_L3:
        o1.lock();
        AtomicReferenceArray atomicreferencearray = o1.f;
        int j1 = 0;
_L9:
        n n1;
        if (j1 >= atomicreferencearray.length())
        {
            break MISSING_BLOCK_LABEL_247;
        }
        n1 = (n)atomicreferencearray.get(j1);
_L6:
        if (n1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (n1.a().d())
        {
            o1.a(n1, com.google.a.b.j.a);
        }
        n1 = n1.b();
        if (true) goto _L6; else goto _L5
_L7:
        Exception exception;
        for (; j1 >= atomicreferencearray.length(); j1 = 0)
        {
            break MISSING_BLOCK_LABEL_128;
        }

        atomicreferencearray.set(j1, null);
        j1++;
          goto _L7
        if (o1.a.h())
        {
            while (o1.h.poll() != null) ;
        }
        if (o1.a.i())
        {
            while (o1.i.poll() != null) ;
        }
        o1.l.clear();
        o1.m.clear();
        o1.k.set(0);
        o1.d = o1.d + 1;
        o1.b = 0;
        o1.unlock();
        o1.b();
_L4:
        i1++;
          goto _L8
        exception;
        o1.unlock();
        o1.b();
        throw exception;
_L2:
        return;
_L5:
        j1++;
          goto _L9
    }

    public boolean containsKey(Object obj)
    {
        if (obj == null)
        {
            return false;
        } else
        {
            int i1 = a(obj);
            return a(i1).b(obj, i1);
        }
    }

    public boolean containsValue(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        long l4 = q.a();
        o ao[] = d;
        int i1 = 0;
        long l3 = -1L;
        do
        {
            if (i1 >= 3)
            {
                break;
            }
            int i2 = ao.length;
            long l2 = 0L;
            for (int j1 = 0; j1 < i2; j1++)
            {
                o o1 = ao[j1];
                int k1 = o1.b;
                AtomicReferenceArray atomicreferencearray = o1.f;
                for (int l1 = 0; l1 < atomicreferencearray.length(); l1++)
                {
                    for (n n1 = (n)atomicreferencearray.get(l1); n1 != null; n1 = n1.b())
                    {
                        Object obj1 = o1.a(n1, l4);
                        if (obj1 != null && g.a(obj, obj1))
                        {
                            return true;
                        }
                    }

                }

                l2 += o1.d;
            }

            if (l2 == l3)
            {
                break;
            }
            i1++;
            l3 = l2;
        } while (true);
        return false;
    }

    final boolean d()
    {
        return l > 0L;
    }

    final boolean e()
    {
        return n > 0L;
    }

    public Set entrySet()
    {
        Set set = y;
        if (set != null)
        {
            return set;
        } else
        {
            f f1 = new f(this);
            y = f1;
            return f1;
        }
    }

    final boolean f()
    {
        return d() || a();
    }

    final boolean g()
    {
        return c() || e();
    }

    public Object get(Object obj)
    {
        if (obj == null)
        {
            return null;
        } else
        {
            int i1 = a(obj);
            return a(i1).a(obj, i1);
        }
    }

    final boolean h()
    {
        return h != com.google.a.b.q.a;
    }

    final boolean i()
    {
        return i != com.google.a.b.q.a;
    }

    public boolean isEmpty()
    {
        o ao[];
        int i1;
        long l1;
        ao = d;
        i1 = 0;
        l1 = 0L;
_L9:
        if (i1 >= ao.length) goto _L2; else goto _L1
_L1:
        if (ao[i1].b == 0) goto _L4; else goto _L3
_L3:
        return false;
_L4:
        l1 += ao[i1].d;
        i1++;
        continue; /* Loop/switch isn't completed */
_L2:
        if (l1 == 0L)
        {
            break; /* Loop/switch isn't completed */
        }
        i1 = 0;
_L6:
        if (i1 >= ao.length)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (ao[i1].b != 0) goto _L3; else goto _L5
_L5:
        l1 -= ao[i1].d;
        i1++;
          goto _L6
        if (l1 != 0L) goto _L3; else goto _L7
_L7:
        return true;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public Set keySet()
    {
        Set set = w;
        if (set != null)
        {
            return set;
        } else
        {
            i i1 = new i(this);
            w = i1;
            return i1;
        }
    }

    public Object put(Object obj, Object obj1)
    {
        com.google.a.a.g.a(obj);
        com.google.a.a.g.a(obj1);
        int i1 = a(obj);
        return a(i1).a(obj, i1, obj1, false);
    }

    public void putAll(Map map)
    {
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); put(entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

    }

    public Object putIfAbsent(Object obj, Object obj1)
    {
        com.google.a.a.g.a(obj);
        com.google.a.a.g.a(obj1);
        int i1 = a(obj);
        return a(i1).a(obj, i1, obj1, true);
    }

    public Object remove(Object obj)
    {
        if (obj == null)
        {
            return null;
        } else
        {
            int i1 = a(obj);
            return a(i1).c(obj, i1);
        }
    }

    public boolean remove(Object obj, Object obj1)
    {
        if (obj == null || obj1 == null)
        {
            return false;
        } else
        {
            int i1 = a(obj);
            return a(i1).b(obj, i1, obj1);
        }
    }

    public Object replace(Object obj, Object obj1)
    {
        com.google.a.a.g.a(obj);
        com.google.a.a.g.a(obj1);
        int i1 = a(obj);
        return a(i1).a(obj, i1, obj1);
    }

    public boolean replace(Object obj, Object obj1, Object obj2)
    {
        com.google.a.a.g.a(obj);
        com.google.a.a.g.a(obj2);
        if (obj1 == null)
        {
            return false;
        } else
        {
            int i1 = a(obj);
            return a(i1).a(obj, i1, obj1, obj2);
        }
    }

    public int size()
    {
        o ao[] = d;
        long l1 = 0L;
        for (int i1 = 0; i1 < ao.length; i1++)
        {
            l1 += ao[i1].b;
        }

        return com.google.a.e.a.a(l1);
    }

    public Collection values()
    {
        Collection collection = x;
        if (collection != null)
        {
            return collection;
        } else
        {
            y y1 = new y(this);
            x = y1;
            return y1;
        }
    }


    // Unreferenced inner class com/google/a/b/f$af$1

/* anonymous class */
    final class af._cls1 extends b
    {

        n a;
        n b;
        final af c;

        public final void b(long l1)
        {
        }

        public final void c(n n1)
        {
            a = n1;
        }

        public final void d(n n1)
        {
            b = n1;
        }

        public final long h()
        {
            return 0x7fffffffffffffffL;
        }

        public final n i()
        {
            return a;
        }

        public final n j()
        {
            return b;
        }

            
            {
                c = af1;
                super();
                a = this;
                b = this;
            }
    }


    // Unreferenced inner class com/google/a/b/f$c$1

/* anonymous class */
    final class c._cls1 extends b
    {

        n a;
        n b;
        final c c;

        public final void a(long l1)
        {
        }

        public final void a(n n1)
        {
            a = n1;
        }

        public final void b(n n1)
        {
            b = n1;
        }

        public final long e()
        {
            return 0x7fffffffffffffffL;
        }

        public final n f()
        {
            return a;
        }

        public final n g()
        {
            return b;
        }

            
            {
                c = c1;
                super();
                a = this;
                b = this;
            }
    }

}
