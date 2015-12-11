// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.f.b.a.a.a.a;


// Referenced classes of package com.google.api.a.f.b.a.a.a.a:
//            b, c

public final class a extends b
{

    static final byte a[] = {
        13, 10
    };
    private static final byte i[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 43, 47
    };
    private static final byte j[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 45, 95
    };
    private static final byte k[] = {
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 
        54, 55, 56, 57, 58, 59, 60, 61, -1, -1, 
        -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
        49, 50, 51
    };
    private final byte l[];
    private final byte m[];
    private final byte n[];
    private final int o;
    private final int p;
    private int q;

    public a()
    {
        this((byte)0);
    }

    private a(byte byte0)
    {
        this(a);
    }

    private a(byte abyte0[])
    {
        this(abyte0, (byte)0);
    }

    private a(byte abyte0[], byte byte0)
    {
        if (abyte0 == null)
        {
            byte0 = 0;
        } else
        {
            byte0 = abyte0.length;
        }
        super(byte0);
        m = k;
        if (abyte0 != null)
        {
            if (c(abyte0))
            {
                abyte0 = c.a(abyte0, "UTF-8");
                throw new IllegalArgumentException((new StringBuilder("lineSeparator must not contain base64 characters: [")).append(abyte0).append("]").toString());
            }
            p = 4;
            n = null;
        } else
        {
            p = 4;
            n = null;
        }
        o = p - 1;
        l = i;
    }

    public static String a(byte abyte0[])
    {
        Object obj = abyte0;
        if (abyte0 != null)
        {
            if (abyte0.length == 0)
            {
                obj = abyte0;
            } else
            {
                obj = new a(a, (byte)0);
                long l1 = ((a) (obj)).d(abyte0);
                if (l1 > 0x7fffffffL)
                {
                    throw new IllegalArgumentException((new StringBuilder("Input array too big, the output array would be bigger (")).append(l1).append(") than the specified maximum size of 2147483647").toString());
                }
                obj = ((a) (obj)).b(abyte0);
            }
        }
        return c.a(((byte []) (obj)), "UTF-8");
    }

    final void a(byte abyte0[], int i1, int j1)
    {
        if (!f) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (j1 >= 0) goto _L4; else goto _L3
_L3:
        f = true;
        if (h == 0 && c == 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        a(p);
        i1 = e;
        h;
        JVM INSTR tableswitch 1 2: default 72
    //                   1 139
    //                   2 264;
           goto _L5 _L6 _L7
_L5:
        j1 = g;
        g = (e - i1) + j1;
        if (c > 0 && g > 0)
        {
            System.arraycopy(n, 0, d, e, n.length);
            e = e + n.length;
            return;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        abyte0 = d;
        j1 = e;
        e = j1 + 1;
        abyte0[j1] = l[q >> 2 & 0x3f];
        abyte0 = d;
        j1 = e;
        e = j1 + 1;
        abyte0[j1] = l[q << 4 & 0x3f];
        if (l == i)
        {
            abyte0 = d;
            j1 = e;
            e = j1 + 1;
            abyte0[j1] = 61;
            abyte0 = d;
            j1 = e;
            e = j1 + 1;
            abyte0[j1] = 61;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        abyte0 = d;
        j1 = e;
        e = j1 + 1;
        abyte0[j1] = l[q >> 10 & 0x3f];
        abyte0 = d;
        j1 = e;
        e = j1 + 1;
        abyte0[j1] = l[q >> 4 & 0x3f];
        abyte0 = d;
        j1 = e;
        e = j1 + 1;
        abyte0[j1] = l[q << 2 & 0x3f];
        if (l == i)
        {
            abyte0 = d;
            j1 = e;
            e = j1 + 1;
            abyte0[j1] = 61;
        }
        if (true) goto _L5; else goto _L4
_L4:
        int k1 = 0;
        while (k1 < j1) 
        {
            a(p);
            h = (h + 1) % 3;
            byte byte0 = abyte0[i1];
            int l1 = byte0;
            if (byte0 < 0)
            {
                l1 = byte0 + 256;
            }
            q = l1 + (q << 8);
            if (h == 0)
            {
                byte abyte1[] = d;
                int i2 = e;
                e = i2 + 1;
                abyte1[i2] = l[q >> 18 & 0x3f];
                abyte1 = d;
                i2 = e;
                e = i2 + 1;
                abyte1[i2] = l[q >> 12 & 0x3f];
                abyte1 = d;
                i2 = e;
                e = i2 + 1;
                abyte1[i2] = l[q >> 6 & 0x3f];
                abyte1 = d;
                i2 = e;
                e = i2 + 1;
                abyte1[i2] = l[q & 0x3f];
                g = g + 4;
                if (c > 0 && c <= g)
                {
                    System.arraycopy(n, 0, d, e, n.length);
                    e = e + n.length;
                    g = 0;
                }
            }
            k1++;
            i1++;
        }
        if (true) goto _L1; else goto _L8
_L8:
    }

    protected final boolean a(byte byte0)
    {
        return byte0 >= 0 && byte0 < m.length && m[byte0] != -1;
    }

}
