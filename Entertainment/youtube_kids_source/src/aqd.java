// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Stack;

final class aqd
    implements aqg
{

    private static final int a[] = {
        128, 64, 32, 16, 8, 4, 2, 1
    };
    private final byte b[] = new byte[8];
    private final Stack c = new Stack();
    private aqf d;
    private int e;
    private long f;
    private long g;
    private int h;
    private int i;
    private long j;
    private int k;
    private int l;
    private int m;
    private int n;
    private byte o[];

    aqd()
    {
    }

    private int a(int i1, int j1)
    {
        if (i1 == -1)
        {
            return 2;
        }
        n = n + i1;
        f = f + (long)i1;
        return n >= j1 ? 0 : 1;
    }

    private long a(int i1, boolean flag)
    {
        int j1 = 0;
        if (flag)
        {
            byte abyte0[] = b;
            abyte0[0] = (byte)(abyte0[0] & ~a[m - 1]);
        }
        long l1 = 0L;
        for (; j1 < i1; j1++)
        {
            l1 = l1 << 8 | (long)(b[j1] & 0xff);
        }

        return l1;
    }

    private int b(asn asn1, int i1)
    {
        if (n >= i1)
        {
            return 0;
        } else
        {
            return a(asn1.a(i1 - n), i1);
        }
    }

    private int b(asn asn1, byte abyte0[], int i1)
    {
        if (n == 0 && i1 > abyte0.length)
        {
            throw new IllegalArgumentException("Byte array not large enough");
        }
        if (n >= i1)
        {
            return 0;
        } else
        {
            int j1 = n;
            return a(asn1.a(abyte0, n, i1 - j1), i1);
        }
    }

    private int c(asn asn1)
    {
        if (l != 2) goto _L2; else goto _L1
_L1:
        return 0;
_L2:
        if (l == 0)
        {
            n = 0;
            int i1 = b(asn1, b, 1);
            if (i1 != 0)
            {
                return i1;
            }
            l = 1;
            byte byte0 = b[0];
            m = -1;
            i1 = 0;
label0:
            do
            {
label1:
                {
                    int ai[] = a;
                    if (i1 < 8)
                    {
                        if ((a[i1] & (byte0 & 0xff)) == 0)
                        {
                            break label1;
                        }
                        m = i1 + 1;
                    }
                    if (m == -1)
                    {
                        long l1 = f;
                        throw new IllegalStateException((new StringBuilder(69)).append("No valid varint length mask found at bytesRead = ").append(l1).toString());
                    }
                    break label0;
                }
                i1++;
            } while (true);
        }
        int j1 = b(asn1, b, m);
        if (j1 != 0)
        {
            return j1;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private void c()
    {
        e = 0;
        i = 0;
        k = 0;
        g = f;
    }

    public final int a(asn asn1)
    {
        boolean flag;
        if (d != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(flag);
_L14:
        if (c.isEmpty() || f < ((aqe)c.peek()).b) goto _L2; else goto _L1
_L1:
        d.b(((aqe)c.pop()).a);
_L12:
        return 0;
_L2:
        if (e != 0)
        {
            break MISSING_BLOCK_LABEL_246;
        }
        if (i != 2) goto _L4; else goto _L3
_L3:
        int i1 = 0;
_L6:
        if (i1 != 0)
        {
            return i1;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (i == 0)
        {
            l = 0;
            i = 1;
        }
        int i3 = c(asn1);
        i1 = i3;
        if (i3 == 0)
        {
            h = (int)a(m, false);
            i = 2;
            i1 = 0;
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (k != 2) goto _L8; else goto _L7
_L7:
        i1 = 0;
_L10:
        if (i1 != 0)
        {
            return i1;
        }
        break; /* Loop/switch isn't completed */
_L8:
        if (k == 0)
        {
            l = 0;
            k = 1;
        }
        int j3 = c(asn1);
        i1 = j3;
        if (j3 == 0)
        {
            j = a(m, true);
            k = 2;
            i1 = 0;
        }
        if (true) goto _L10; else goto _L9
_L9:
        e = 1;
        n = 0;
        int j1 = d.a(h);
        switch (j1)
        {
        default:
            throw new IllegalStateException((new StringBuilder(32)).append("Invalid element type ").append(j1).toString());

        case 1: // '\001'
            int k1 = (int)(f - g);
            c.add(new aqe(h, f + j));
            d.a(h, g, k1, j);
            c();
            return 0;

        case 2: // '\002'
            if (j > 8L)
            {
                long l3 = j;
                throw new IllegalStateException((new StringBuilder(41)).append("Invalid integer size ").append(l3).toString());
            }
            int l1 = b(asn1, b, (int)j);
            if (l1 != 0)
            {
                return l1;
            } else
            {
                long l4 = a((int)j, false);
                d.a(h, l4);
                c();
                return 0;
            }

        case 5: // '\005'
            if (j != 4L && j != 8L)
            {
                long l5 = j;
                throw new IllegalStateException((new StringBuilder(39)).append("Invalid float size ").append(l5).toString());
            }
            int i2 = b(asn1, b, (int)j);
            if (i2 != 0)
            {
                return i2;
            }
            long l6 = a((int)j, false);
            double d1;
            if (j == 4L)
            {
                d1 = Float.intBitsToFloat((int)l6);
            } else
            {
                d1 = Double.longBitsToDouble(l6);
            }
            d.a(h, d1);
            c();
            return 0;

        case 3: // '\003'
            if (j > 0x7fffffffL)
            {
                long l7 = j;
                throw new IllegalStateException((new StringBuilder(63)).append("String element size ").append(l7).append(" is larger than MAX_INT").toString());
            }
            if (o == null)
            {
                o = new byte[(int)j];
            }
            int j2 = b(asn1, o, (int)j);
            if (j2 != 0)
            {
                return j2;
            } else
            {
                asn1 = new String(o, Charset.forName("UTF-8"));
                o = null;
                d.a(h, asn1);
                c();
                return 0;
            }

        case 4: // '\004'
            if (j > 0x7fffffffL)
            {
                long l8 = j;
                throw new IllegalStateException((new StringBuilder(63)).append("Binary element size ").append(l8).append(" is larger than MAX_INT").toString());
            }
            if (asn1.a() < j)
            {
                return 1;
            }
            int k2 = (int)(f - g);
            if (d.a(h, g, k2, (int)j, asn1))
            {
                long l9 = g + (long)k2 + j;
                if (l9 != f)
                {
                    long l11 = f;
                    throw new IllegalStateException((new StringBuilder(91)).append("Incorrect total bytes read. Expected ").append(l9).append(" but actually ").append(l11).toString());
                } else
                {
                    c();
                    return 0;
                }
            }
            break;

        case 0: // '\0'
            if (j > 0x7fffffffL)
            {
                long l10 = j;
                throw new IllegalStateException((new StringBuilder(64)).append("Unknown element size ").append(l10).append(" is larger than MAX_INT").toString());
            }
            int l2 = b(asn1, (int)j);
            if (l2 != 0)
            {
                return l2;
            }
            c();
            continue; /* Loop/switch isn't completed */
        }
        if (true) goto _L12; else goto _L11
_L11:
        if (true) goto _L14; else goto _L13
_L13:
    }

    public final long a()
    {
        return f;
    }

    public final void a(aqf aqf1)
    {
        d = aqf1;
    }

    public final void a(asn asn1, int i1)
    {
        n = 0;
        if (b(asn1, i1) != 0)
        {
            throw new IllegalStateException("Couldn't skip bytes");
        } else
        {
            return;
        }
    }

    public final void a(asn asn1, ByteBuffer bytebuffer, int i1)
    {
        boolean flag = false;
        n = 0;
        if (n == 0 && i1 > bytebuffer.capacity())
        {
            throw new IllegalArgumentException("Byte buffer not large enough");
        }
        if (n >= i1)
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = a(asn1.a(bytebuffer, i1 - n), i1);
        }
        if (i1 != 0)
        {
            throw new IllegalStateException("Couldn't read bytes into buffer");
        } else
        {
            return;
        }
    }

    public final void a(asn asn1, byte abyte0[], int i1)
    {
        n = 0;
        if (b(asn1, abyte0, i1) != 0)
        {
            throw new IllegalStateException("Couldn't read bytes into array");
        } else
        {
            return;
        }
    }

    public final long b(asn asn1)
    {
        l = 0;
        if (c(asn1) != 0)
        {
            throw new IllegalStateException("Couldn't read varint");
        } else
        {
            return a(m, true);
        }
    }

    public final void b()
    {
        c();
        c.clear();
        f = 0L;
    }

}
