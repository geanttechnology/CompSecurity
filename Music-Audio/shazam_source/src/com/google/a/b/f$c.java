// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b;

import com.google.a.c.f;
import java.util.AbstractQueue;
import java.util.Iterator;

// Referenced classes of package com.google.a.b:
//            f

static final class nit> extends AbstractQueue
{

    final f a = new f.b() {

        f.n a;
        f.n b;
        final f.c c;

        public final void a(long l)
        {
        }

        public final void a(f.n n)
        {
            a = n;
        }

        public final void b(f.n n)
        {
            b = n;
        }

        public final long e()
        {
            return 0x7fffffffffffffffL;
        }

        public final f.n f()
        {
            return a;
        }

        public final f.n g()
        {
            return b;
        }

            
            {
                c = f.c.this;
                super();
                a = this;
                b = this;
            }
    };

    private ueue a()
    {
        ueue ueue1 = a.f();
        ueue ueue = ueue1;
        if (ueue1 == a)
        {
            ueue = null;
        }
        return ueue;
    }

    public final void clear()
    {
        a a2;
        for (a a1 = a.f(); a1 != a; a1 = a2)
        {
            a2 = a1.f();
            f.a(a1);
        }

        a.a(a);
        a.b(a);
    }

    public final boolean contains(Object obj)
    {
        return ((a)obj).f() != a;
    }

    public final boolean isEmpty()
    {
        return a.f() == a;
    }

    public final Iterator iterator()
    {
        return new f(a()) {

            final f.c a;

            protected final Object a(Object obj)
            {
                f.n n = ((f.n)obj).f();
                obj = n;
                if (n == a.a)
                {
                    obj = null;
                }
                return obj;
            }

            
            {
                a = f.c.this;
                super(n);
            }
        };
    }

    public final boolean offer(Object obj)
    {
        obj = (a)obj;
        f.a(((a) (obj)).g(), ((g) (obj)).f());
        f.a(a.g(), ((g) (obj)));
        f.a(((g) (obj)), a);
        return true;
    }

    public final Object peek()
    {
        return a();
    }

    public final Object poll()
    {
        a a1 = a.f();
        if (a1 == a)
        {
            return null;
        } else
        {
            remove(a1);
            return a1;
        }
    }

    public final boolean remove(Object obj)
    {
        obj = (remove)obj;
        remove remove1 = ((remove) (obj)).g();
        remove remove2 = ((g) (obj)).f();
        f.a(remove1, remove2);
        f.a(((f) (obj)));
        return remove2 != a;
    }

    public final int size()
    {
        int i = 0;
        for (a a1 = a.f(); a1 != a; a1 = a1.f())
        {
            i++;
        }

        return i;
    }

    nit>()
    {
    }
}
