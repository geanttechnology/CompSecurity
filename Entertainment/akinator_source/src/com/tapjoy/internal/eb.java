// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

// Referenced classes of package com.tapjoy.internal:
//            do, dw

final class eb extends do
{
    static final class a
    {

        final Stack a;

        private static int a(int l)
        {
            int i1 = Arrays.binarySearch(eb.b(), l);
            l = i1;
            if (i1 < 0)
            {
                l = -(i1 + 1) - 1;
            }
            return l;
        }

        final void a(do do1)
        {
            do
            {
                if (do1.j())
                {
                    int l = a(do1.a());
                    int j1 = eb.b()[l + 1];
                    if (a.isEmpty() || ((do)a.peek()).a() >= j1)
                    {
                        a.push(do1);
                        return;
                    }
                    l = eb.b()[l];
                    Object obj;
                    for (obj = (do)a.pop(); !a.isEmpty() && ((do)a.peek()).a() < l; obj = new eb((do)a.pop(), ((do) (obj)), (byte)0)) { }
                    do1 = new eb(((do) (obj)), do1, (byte)0);
                    do
                    {
                        if (a.isEmpty())
                        {
                            break;
                        }
                        int i1 = a(do1.a());
                        i1 = eb.b()[i1 + 1];
                        if (((do)a.peek()).a() >= i1)
                        {
                            break;
                        }
                        do1 = new eb((do)a.pop(), do1, (byte)0);
                    } while (true);
                    a.push(do1);
                    return;
                }
                if (do1 instanceof eb)
                {
                    do1 = (eb)do1;
                    a(eb.a(do1));
                    do1 = eb.b(do1);
                } else
                {
                    do1 = String.valueOf(String.valueOf(do1.getClass()));
                    throw new IllegalArgumentException((new StringBuilder(do1.length() + 49)).append("Has a new type of ByteString been created? Found ").append(do1).toString());
                }
            } while (true);
        }

        private a()
        {
            a = new Stack();
        }

        a(byte byte0)
        {
            this();
        }
    }

    static final class b
        implements Iterator
    {

        private final Stack a;
        private dw b;

        private dw a(do do1)
        {
            for (; do1 instanceof eb; do1 = eb.a(do1))
            {
                do1 = (eb)do1;
                a.push(do1);
            }

            return (dw)do1;
        }

        private dw b()
        {
            dw dw1;
            do
            {
                if (a.isEmpty())
                {
                    return null;
                }
                dw1 = a(eb.b((eb)a.pop()));
            } while (dw1.d());
            return dw1;
        }

        public final dw a()
        {
            if (b == null)
            {
                throw new NoSuchElementException();
            } else
            {
                dw dw1 = b;
                b = b();
                return dw1;
            }
        }

        public final boolean hasNext()
        {
            return b != null;
        }

        public final Object next()
        {
            return a();
        }

        public final void remove()
        {
            throw new UnsupportedOperationException();
        }

        private b(do do1)
        {
            a = new Stack();
            b = a(do1);
        }

        b(do do1, byte byte0)
        {
            this(do1);
        }
    }

    final class c
        implements do.a
    {

        int a;
        final eb b;
        private final b c;
        private do.a d;

        public final byte a()
        {
            if (!d.hasNext())
            {
                d = c.a().c();
            }
            a = a - 1;
            return d.a();
        }

        public final boolean hasNext()
        {
            return a > 0;
        }

        public final Object next()
        {
            return Byte.valueOf(a());
        }

        public final void remove()
        {
            throw new UnsupportedOperationException();
        }

        private c()
        {
            b = eb.this;
            super();
            c = new b(eb.this, (byte)0);
            d = c.a().c();
            a = eb.this.a();
        }

        c(byte byte0)
        {
            this();
        }
    }


    private static final int c[];
    private final int d;
    private final do e;
    private final do f;
    private final int g;
    private final int h;
    private int i;

    private eb(do do1, do do2)
    {
        i = 0;
        e = do1;
        f = do2;
        g = do1.a();
        d = g + do2.a();
        h = Math.max(do1.i(), do2.i()) + 1;
    }

    eb(do do1, do do2, byte byte0)
    {
        this(do1, do2);
    }

    static do a(do do1, do do2)
    {
        Object obj;
        if (do1 instanceof eb)
        {
            obj = (eb)do1;
        } else
        {
            obj = null;
        }
        if (do2.a() == 0)
        {
            return do1;
        }
        if (do1.a() == 0)
        {
            return do2;
        }
        int l = do1.a() + do2.a();
        if (l < 128)
        {
            return b(do1, do2);
        }
        if (obj != null && ((eb) (obj)).f.a() + do2.a() < 128)
        {
            do1 = b(((eb) (obj)).f, do2);
            return new eb(((eb) (obj)).e, do1);
        }
        if (obj != null && ((eb) (obj)).e.i() > ((eb) (obj)).f.i() && ((eb) (obj)).h > do2.i())
        {
            do1 = new eb(((eb) (obj)).f, do2);
            return new eb(((eb) (obj)).e, do1);
        }
        int i1 = Math.max(do1.i(), do2.i());
        if (l >= c[i1 + 1])
        {
            return new eb(do1, do2);
        }
        obj = new a((byte)0);
        ((a) (obj)).a(do1);
        ((a) (obj)).a(do2);
        for (do1 = (do)((a) (obj)).a.pop(); !((a) (obj)).a.isEmpty(); do1 = new eb((do)((a) (obj)).a.pop(), do1, (byte)0)) { }
        return do1;
    }

    static do a(eb eb1)
    {
        return eb1.e;
    }

    static do b(eb eb1)
    {
        return eb1.f;
    }

    private static dw b(do do1, do do2)
    {
        int l = do1.a();
        int i1 = do2.a();
        byte abyte0[] = new byte[l + i1];
        do1.b(abyte0, 0, 0, l);
        do2.b(abyte0, 0, l, i1);
        return new dw(abyte0);
    }

    static int[] b()
    {
        return c;
    }

    public final int a()
    {
        return d;
    }

    protected final int a(int l, int i1, int j1)
    {
        if (i1 + j1 <= g)
        {
            return e.a(l, i1, j1);
        }
        if (i1 >= g)
        {
            return f.a(l, i1 - g, j1);
        } else
        {
            int k1 = g - i1;
            l = e.a(l, i1, k1);
            return f.a(l, 0, j1 - k1);
        }
    }

    protected final void a(byte abyte0[], int l, int i1, int j1)
    {
        if (l + j1 <= g)
        {
            e.a(abyte0, l, i1, j1);
            return;
        }
        if (l >= g)
        {
            f.a(abyte0, l - g, i1, j1);
            return;
        } else
        {
            int k1 = g - l;
            e.a(abyte0, l, i1, k1);
            f.a(abyte0, 0, i1 + k1, j1 - k1);
            return;
        }
    }

    protected final int b(int l, int i1, int j1)
    {
        if (i1 + j1 <= g)
        {
            return e.b(l, i1, j1);
        }
        if (i1 >= g)
        {
            return f.b(l, i1 - g, j1);
        } else
        {
            int k1 = g - i1;
            l = e.b(l, i1, k1);
            return f.b(l, 0, j1 - k1);
        }
    }

    public final String b(String s)
    {
        return new String(e(), s);
    }

    final void b(OutputStream outputstream, int l, int i1)
    {
        if (l + i1 <= g)
        {
            e.b(outputstream, l, i1);
            return;
        }
        if (l >= g)
        {
            f.b(outputstream, l - g, i1);
            return;
        } else
        {
            int j1 = g - l;
            e.b(outputstream, l, j1);
            f.b(outputstream, 0, i1 - j1);
            return;
        }
    }

    public final do.a c()
    {
        return new c((byte)0);
    }

    public final boolean equals(Object obj)
    {
        boolean flag2 = false;
        if (obj != this) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        int l;
        flag = flag2;
        if (!(obj instanceof do))
        {
            continue;
        }
        obj = (do)obj;
        flag = flag2;
        if (d != ((do) (obj)).a())
        {
            continue;
        }
        if (d == 0)
        {
            return true;
        }
        if (i == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        l = ((do) (obj)).k();
        if (l == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag2;
        if (i != l) goto _L4; else goto _L3
_L3:
        b b1 = new b(this, (byte)0);
        dw dw1 = (dw)b1.next();
        b b2 = new b(((do) (obj)), (byte)0);
        obj = (dw)b2.next();
        int i1 = 0;
        int j1 = 0;
        int k1 = 0;
        do
        {
            int j2 = dw1.a() - j1;
            int l1 = ((dw) (obj)).a() - i1;
            int i2 = Math.min(j2, l1);
            boolean flag1;
            if (j1 == 0)
            {
                flag1 = dw1.a(((dw) (obj)), i1, i2);
            } else
            {
                flag1 = ((dw) (obj)).a(dw1, j1, i2);
            }
            flag = flag2;
            if (!flag1)
            {
                continue;
            }
            k1 += i2;
            if (k1 >= d)
            {
                if (k1 == d)
                {
                    return true;
                } else
                {
                    throw new IllegalStateException();
                }
            }
            if (i2 == j2)
            {
                dw1 = (dw)b1.next();
                j1 = 0;
            } else
            {
                j1 += i2;
            }
            if (i2 == l1)
            {
                obj = (dw)b2.next();
                i1 = 0;
            } else
            {
                i1 += i2;
            }
        } while (true);
        if (true) goto _L4; else goto _L5
_L5:
    }

    public final boolean g()
    {
        boolean flag = false;
        int l = e.a(0, 0, g);
        if (f.a(l, 0, f.a()) == 0)
        {
            flag = true;
        }
        return flag;
    }

    public final int hashCode()
    {
        int i1 = i;
        int l = i1;
        if (i1 == 0)
        {
            int j1 = b(d, 0, d);
            l = j1;
            if (j1 == 0)
            {
                l = 1;
            }
            i = l;
        }
        return l;
    }

    protected final int i()
    {
        return h;
    }

    public final Iterator iterator()
    {
        return c();
    }

    protected final boolean j()
    {
        return d >= c[h];
    }

    protected final int k()
    {
        return i;
    }

    static 
    {
        int l = 1;
        ArrayList arraylist = new ArrayList();
        int j1 = 1;
        do
        {
            int k1 = j1;
            if (l <= 0)
            {
                break;
            }
            arraylist.add(Integer.valueOf(l));
            j1 = l;
            l = k1 + l;
        } while (true);
        arraylist.add(Integer.valueOf(0x7fffffff));
        c = new int[arraylist.size()];
        for (int i1 = 0; i1 < c.length; i1++)
        {
            c[i1] = ((Integer)arraylist.get(i1)).intValue();
        }

    }
}
