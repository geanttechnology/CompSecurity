// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.tapjoy.internal:
//            dw, eb, dt

public abstract class do
    implements Iterable
{
    public static interface a
        extends Iterator
    {

        public abstract byte a();
    }

    public static final class b extends OutputStream
    {

        private static final byte a[] = new byte[0];
        private final int b = 128;
        private final ArrayList c = new ArrayList();
        private int d;
        private byte e[];
        private int f;

        private void a(int l)
        {
            c.add(new dw(e));
            d = d + e.length;
            e = new byte[Math.max(b, Math.max(l, d >>> 1))];
            f = 0;
        }

        private int b()
        {
            this;
            JVM INSTR monitorenter ;
            int l;
            int i1;
            l = d;
            i1 = f;
            this;
            JVM INSTR monitorexit ;
            return l + i1;
            Exception exception;
            exception;
            throw exception;
        }

        public final do a()
        {
            this;
            JVM INSTR monitorenter ;
            if (f >= e.length)
            {
                break MISSING_BLOCK_LABEL_94;
            }
            if (f > 0)
            {
                byte abyte0[] = e;
                int l = f;
                byte abyte1[] = new byte[l];
                System.arraycopy(abyte0, 0, abyte1, 0, Math.min(abyte0.length, l));
                c.add(new dw(abyte1));
            }
_L1:
            do do1;
            d = d + f;
            f = 0;
            do1 = do.a(c);
            this;
            JVM INSTR monitorexit ;
            return do1;
            c.add(new dw(e));
            e = a;
              goto _L1
            Exception exception;
            exception;
            throw exception;
        }

        public final String toString()
        {
            return String.format("<ByteString.Output@%s size=%d>", new Object[] {
                Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(b())
            });
        }

        public final void write(int l)
        {
            this;
            JVM INSTR monitorenter ;
            byte abyte0[];
            int i1;
            if (f == e.length)
            {
                a(1);
            }
            abyte0 = e;
            i1 = f;
            f = i1 + 1;
            abyte0[i1] = (byte)l;
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public final void write(byte abyte0[], int l, int i1)
        {
            this;
            JVM INSTR monitorenter ;
            if (i1 > e.length - f) goto _L2; else goto _L1
_L1:
            System.arraycopy(abyte0, l, e, f, i1);
            f = f + i1;
_L4:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            int j1;
            j1 = e.length - f;
            System.arraycopy(abyte0, l, e, f, j1);
            i1 -= j1;
            a(i1);
            System.arraycopy(abyte0, l + j1, e, 0, i1);
            f = i1;
            if (true) goto _L4; else goto _L3
_L3:
            abyte0;
            throw abyte0;
        }


        b()
        {
            e = new byte[128];
        }
    }


    public static final do a = new dw(new byte[0]);
    static final boolean b;

    do()
    {
    }

    public static do a(Iterable iterable)
    {
        if (!(iterable instanceof Collection))
        {
            ArrayList arraylist = new ArrayList();
            for (iterable = iterable.iterator(); iterable.hasNext(); arraylist.add((do)iterable.next())) { }
            iterable = arraylist;
        } else
        {
            iterable = (Collection)iterable;
        }
        if (iterable.isEmpty())
        {
            return a;
        } else
        {
            return a(iterable.iterator(), iterable.size());
        }
    }

    public static do a(String s)
    {
        try
        {
            s = new dw(s.getBytes("UTF-8"));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException("UTF-8 not supported?", s);
        }
        return s;
    }

    private static do a(Iterator iterator1, int l)
    {
        if (!b && l <= 0)
        {
            throw new AssertionError();
        }
        if (l == 1)
        {
            return (do)iterator1.next();
        } else
        {
            int i1 = l >>> 1;
            return a(iterator1, i1).a(a(iterator1, l - i1));
        }
    }

    public static do a(byte abyte0[], int l, int i1)
    {
        byte abyte1[] = new byte[i1];
        System.arraycopy(abyte0, l, abyte1, 0, i1);
        return new dw(abyte1);
    }

    public static b h()
    {
        return new b();
    }

    public abstract int a();

    protected abstract int a(int l, int i1, int j1);

    public final do a(do do1)
    {
        int l = a();
        int i1 = do1.a();
        if ((long)l + (long)i1 >= 0x7fffffffL)
        {
            throw new IllegalArgumentException((new StringBuilder(53)).append("ByteString would be too long: ").append(l).append("+").append(i1).toString());
        } else
        {
            return eb.a(this, do1);
        }
    }

    final void a(OutputStream outputstream, int l, int i1)
    {
        if (l < 0)
        {
            throw new IndexOutOfBoundsException((new StringBuilder(30)).append("Source offset < 0: ").append(l).toString());
        }
        if (i1 < 0)
        {
            throw new IndexOutOfBoundsException((new StringBuilder(23)).append("Length < 0: ").append(i1).toString());
        }
        if (l + i1 > a())
        {
            throw new IndexOutOfBoundsException((new StringBuilder(39)).append("Source end offset exceeded: ").append(l + i1).toString());
        }
        if (i1 > 0)
        {
            b(outputstream, l, i1);
        }
    }

    protected abstract void a(byte abyte0[], int l, int i1, int j1);

    protected abstract int b(int l, int i1, int j1);

    public abstract String b(String s);

    abstract void b(OutputStream outputstream, int l, int i1);

    public final void b(byte abyte0[], int l, int i1, int j1)
    {
        if (l < 0)
        {
            throw new IndexOutOfBoundsException((new StringBuilder(30)).append("Source offset < 0: ").append(l).toString());
        }
        if (i1 < 0)
        {
            throw new IndexOutOfBoundsException((new StringBuilder(30)).append("Target offset < 0: ").append(i1).toString());
        }
        if (j1 < 0)
        {
            throw new IndexOutOfBoundsException((new StringBuilder(23)).append("Length < 0: ").append(j1).toString());
        }
        if (l + j1 > a())
        {
            throw new IndexOutOfBoundsException((new StringBuilder(34)).append("Source end offset < 0: ").append(l + j1).toString());
        }
        if (i1 + j1 > abyte0.length)
        {
            throw new IndexOutOfBoundsException((new StringBuilder(34)).append("Target end offset < 0: ").append(i1 + j1).toString());
        }
        if (j1 > 0)
        {
            a(abyte0, l, i1, j1);
        }
    }

    public abstract a c();

    public final boolean d()
    {
        return a() == 0;
    }

    public final byte[] e()
    {
        int l = a();
        if (l == 0)
        {
            return dt.a;
        } else
        {
            byte abyte0[] = new byte[l];
            a(abyte0, 0, 0, l);
            return abyte0;
        }
    }

    public final String f()
    {
        String s;
        try
        {
            s = b("UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new RuntimeException("UTF-8 not supported?", unsupportedencodingexception);
        }
        return s;
    }

    public abstract boolean g();

    public abstract int hashCode();

    protected abstract int i();

    public Iterator iterator()
    {
        return c();
    }

    protected abstract boolean j();

    protected abstract int k();

    public String toString()
    {
        return String.format("<ByteString@%s size=%d>", new Object[] {
            Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(a())
        });
    }

    static 
    {
        boolean flag;
        if (!com/tapjoy/internal/do.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b = flag;
    }
}
