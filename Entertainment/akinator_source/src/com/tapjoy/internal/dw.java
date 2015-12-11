// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package com.tapjoy.internal:
//            do, ed, eb

class dw extends do
{
    final class a
        implements do.a
    {

        final dw a;
        private int b;
        private final int c;

        public final byte a()
        {
            byte byte0;
            byte abyte0[];
            int l;
            try
            {
                abyte0 = a.c;
                l = b;
                b = l + 1;
            }
            catch (ArrayIndexOutOfBoundsException arrayindexoutofboundsexception)
            {
                throw new NoSuchElementException(arrayindexoutofboundsexception.getMessage());
            }
            byte0 = abyte0[l];
            return byte0;
        }

        public final boolean hasNext()
        {
            return b < c;
        }

        public final Object next()
        {
            return Byte.valueOf(a());
        }

        public final void remove()
        {
            throw new UnsupportedOperationException();
        }

        private a()
        {
            a = dw.this;
            super();
            b = 0;
            c = dw.this.a();
        }

        a(byte byte0)
        {
            this();
        }
    }


    protected final byte c[];
    private int d;

    dw(byte abyte0[])
    {
        d = 0;
        c = abyte0;
    }

    public int a()
    {
        return c.length;
    }

    protected final int a(int l, int i1, int j1)
    {
        byte abyte0[];
        int i2;
        i1 = b() + i1;
        abyte0 = c;
        i2 = i1 + j1;
        if (l == 0) goto _L2; else goto _L1
_L1:
        byte byte1;
        if (i1 >= i2)
        {
            return l;
        }
        byte1 = (byte)l;
        if (byte1 >= -32) goto _L4; else goto _L3
_L3:
        if (byte1 < -62) goto _L6; else goto _L5
_L5:
        l = i1 + 1;
        if (abyte0[i1] <= -65) goto _L7; else goto _L6
_L6:
        return -1;
_L4:
        if (byte1 >= -16) goto _L9; else goto _L8
_L8:
        byte byte0 = (byte)(~(l >> 8));
        l = byte0;
        j1 = i1;
        if (byte0 == 0)
        {
            j1 = i1 + 1;
            l = abyte0[i1];
            if (j1 >= i2)
            {
                return ed.a(byte1, l);
            }
        }
        if (l > -65 || byte1 == -32 && l < -96 || byte1 == -19 && l >= -96) goto _L11; else goto _L10
_L10:
        l = j1 + 1;
        if (abyte0[j1] <= -65) goto _L7; else goto _L11
_L11:
        return -1;
_L9:
        int k1;
        j1 = (byte)(~(l >> 8));
        k1 = 0;
        if (j1 != 0) goto _L13; else goto _L12
_L12:
        int l1 = i1 + 1;
        j1 = abyte0[i1];
        if (l1 >= i2)
        {
            return ed.a(byte1, j1);
        }
        l = k1;
        i1 = l1;
          goto _L14
_L13:
        l = (byte)(l >> 16);
_L18:
        if (l == 0)
        {
            k1 = i1 + 1;
            l1 = abyte0[i1];
            l = l1;
            i1 = k1;
            if (k1 >= i2)
            {
                return ed.a(byte1, j1, l1);
            }
        }
        if (j1 > -65 || (byte1 << 28) + (j1 + 112) >> 30 != 0 || l > -65) goto _L16; else goto _L15
_L15:
        l = i1 + 1;
        if (abyte0[i1] <= -65) goto _L7; else goto _L16
_L16:
        return -1;
_L2:
        l = i1;
_L7:
        return ed.a(abyte0, l, i2);
_L14:
        if (true) goto _L18; else goto _L17
_L17:
    }

    protected void a(byte abyte0[], int l, int i1, int j1)
    {
        System.arraycopy(c, l, abyte0, i1, j1);
    }

    final boolean a(dw dw1, int l, int i1)
    {
        if (i1 > dw1.a())
        {
            l = a();
            throw new IllegalArgumentException((new StringBuilder(40)).append("Length too large: ").append(i1).append(l).toString());
        }
        if (l + i1 > dw1.a())
        {
            int j1 = dw1.a();
            throw new IllegalArgumentException((new StringBuilder(59)).append("Ran off end of other: ").append(l).append(", ").append(i1).append(", ").append(j1).toString());
        }
        byte abyte0[] = c;
        byte abyte1[] = dw1.c;
        int l1 = b();
        int k1 = b();
        for (l = dw1.b() + l; k1 < l1 + i1; l++)
        {
            if (abyte0[k1] != abyte1[l])
            {
                return false;
            }
            k1++;
        }

        return true;
    }

    protected int b()
    {
        return 0;
    }

    protected final int b(int l, int i1, int j1)
    {
        byte abyte0[] = c;
        int k1 = b() + i1;
        for (i1 = k1; i1 < k1 + j1; i1++)
        {
            l = l * 31 + abyte0[i1];
        }

        return l;
    }

    public final String b(String s)
    {
        return new String(c, b(), a(), s);
    }

    final void b(OutputStream outputstream, int l, int i1)
    {
        outputstream.write(c, b() + l, i1);
    }

    public do.a c()
    {
        return new a((byte)0);
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof do))
        {
            return false;
        }
        if (a() != ((do)obj).a())
        {
            return false;
        }
        if (a() == 0)
        {
            return true;
        }
        if (obj instanceof dw)
        {
            return a((dw)obj, 0, a());
        }
        if (obj instanceof eb)
        {
            return obj.equals(this);
        } else
        {
            obj = String.valueOf(String.valueOf(obj.getClass()));
            throw new IllegalArgumentException((new StringBuilder(((String) (obj)).length() + 49)).append("Has a new type of ByteString been created? Found ").append(((String) (obj))).toString());
        }
    }

    public final boolean g()
    {
        int l = b();
        return ed.a(c, l, a() + l) == 0;
    }

    public int hashCode()
    {
        int i1 = d;
        int l = i1;
        if (i1 == 0)
        {
            l = a();
            int j1 = b(l, 0, l);
            l = j1;
            if (j1 == 0)
            {
                l = 1;
            }
            d = l;
        }
        return l;
    }

    protected final int i()
    {
        return 0;
    }

    public Iterator iterator()
    {
        return c();
    }

    protected final boolean j()
    {
        return true;
    }

    protected final int k()
    {
        return d;
    }
}
