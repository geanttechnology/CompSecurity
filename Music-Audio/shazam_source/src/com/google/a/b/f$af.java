// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b;

import com.google.a.c.f;
import java.util.AbstractQueue;
import java.util.Iterator;

// Referenced classes of package com.google.a.b:
//            f

static final class it> extends AbstractQueue
{

    final  a = new f.b() {

        f.n a;
        f.n b;
        final f.af c;

        public final void b(long l)
        {
        }

        public final void c(f.n n)
        {
            a = n;
        }

        public final void d(f.n n)
        {
            b = n;
        }

        public final long h()
        {
            return 0x7fffffffffffffffL;
        }

        public final f.n i()
        {
            return a;
        }

        public final f.n j()
        {
            return b;
        }

            
            {
                c = f.af.this;
                super();
                a = this;
                b = this;
            }
    };

    private eue a()
    {
        eue eue1 = a.();
        eue eue = eue1;
        if (eue1 == a)
        {
            eue = null;
        }
        return eue;
    }

    public final void clear()
    {
        a a2;
        for (a a1 = a.(); a1 != a; a1 = a2)
        {
            a2 = a1.();
            f.b(a1);
        }

        a.(a);
        a.(a);
    }

    public final boolean contains(Object obj)
    {
        return ((a)obj).() != ;
    }

    public final boolean isEmpty()
    {
        return a.() == a;
    }

    public final Iterator iterator()
    {
        return new f(a()) {

            final f.af a;

            protected final Object a(Object obj)
            {
                f.n n = ((f.n)obj).i();
                obj = n;
                if (n == a.a)
                {
                    obj = null;
                }
                return obj;
            }

            
            {
                a = f.af.this;
                super(n);
            }
        };
    }

    public final boolean offer(Object obj)
    {
        obj = (a)obj;
        f.b(((a) (obj)).(), (() (obj)).());
        f.b(a.(), (() (obj)));
        f.b((() (obj)), a);
        return true;
    }

    public final Object peek()
    {
        return a();
    }

    public final Object poll()
    {
        a a1 = a.();
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
        remove remove1 = ((remove) (obj)).();
        remove remove2 = (() (obj)).();
        f.b(remove1, remove2);
        f.b((() (obj)));
        return remove2 != ;
    }

    public final int size()
    {
        int i = 0;
        for (  = a.();  != a;  = .())
        {
            i++;
        }

        return i;
    }

    it>()
    {
    }
}
