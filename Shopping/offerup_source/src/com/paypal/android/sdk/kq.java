// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.EOFException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Referenced classes of package com.paypal.android.sdk:
//            kr, ks, lm, lf, 
//            lg, lj, kt, lk

public final class kq
    implements kr, ks, Cloneable
{

    private static final byte c[] = {
        48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 
        97, 98, 99, 100, 101, 102
    };
    lf a;
    long b;

    public kq()
    {
    }

    private String a(long l1, Charset charset)
    {
        lm.a(b, 0L, l1);
        if (charset == null)
        {
            throw new IllegalArgumentException("charset == null");
        }
        if (l1 > 0x7fffffffL)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount > Integer.MAX_VALUE: ")).append(l1).toString());
        }
        if (l1 == 0L)
        {
            charset = "";
        } else
        {
            lf lf1 = a;
            if ((long)lf1.b + l1 > (long)lf1.c)
            {
                return new String(e(l1), charset);
            }
            String s = new String(lf1.a, lf1.b, (int)l1, charset);
            lf1.b = (int)((long)lf1.b + l1);
            b = b - l1;
            charset = s;
            if (lf1.b == lf1.c)
            {
                a = lf1.a();
                lg.a(lf1);
                return s;
            }
        }
        return charset;
    }

    private void c(byte abyte0[])
    {
        int i1 = 0;
_L7:
        if (i1 >= abyte0.length) goto _L2; else goto _L1
_L1:
        lf lf1;
        int j1;
        j1 = abyte0.length - i1;
        lm.a(abyte0.length, i1, j1);
        lf1 = a;
        if (lf1 != null) goto _L4; else goto _L3
_L3:
        j1 = -1;
_L6:
        if (j1 == -1)
        {
            throw new EOFException();
        }
        continue; /* Loop/switch isn't completed */
_L4:
        int k1 = Math.min(j1, lf1.c - lf1.b);
        System.arraycopy(lf1.a, lf1.b, abyte0, i1, k1);
        lf1.b = lf1.b + k1;
        b = b - (long)k1;
        j1 = k1;
        if (lf1.b == lf1.c)
        {
            a = lf1.a();
            lg.a(lf1);
            j1 = k1;
        }
        if (true) goto _L6; else goto _L5
_L5:
        i1 = j1 + i1;
          goto _L7
_L2:
    }

    private String i(long l1)
    {
        return a(l1, lm.a);
    }

    private kq p()
    {
        kq kq1 = new kq();
        if (b == 0L)
        {
            return kq1;
        }
        kq1.a = new lf(a);
        lf lf1 = kq1.a;
        lf lf3 = kq1.a;
        lf lf4 = kq1.a;
        lf3.g = lf4;
        lf1.f = lf4;
        for (lf lf2 = a.f; lf2 != a; lf2 = lf2.f)
        {
            kq1.a.g.a(new lf(lf2));
        }

        kq1.b = b;
        return kq1;
    }

    public final long a(byte byte0)
    {
        return a(byte0, 0L);
    }

    public final long a(byte byte0, long l1)
    {
        if (l1 < 0L)
        {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        lf lf1 = a;
        if (lf1 == null)
        {
            return -1L;
        }
        long l2 = 0L;
        do
        {
            int j1 = lf1.c - lf1.b;
            lf lf2;
            if (l1 >= (long)j1)
            {
                l1 -= j1;
            } else
            {
                byte abyte0[] = lf1.a;
                int i1 = (int)((long)lf1.b + l1);
                for (int k1 = lf1.c; i1 < k1; i1++)
                {
                    if (abyte0[i1] == byte0)
                    {
                        return (l2 + (long)i1) - (long)lf1.b;
                    }
                }

                l1 = 0L;
            }
            l2 += j1;
            lf2 = lf1.f;
            lf1 = lf2;
        } while (lf2 != a);
        return -1L;
    }

    public final long a(kq kq1, long l1)
    {
        if (kq1 == null)
        {
            throw new IllegalArgumentException("sink == null");
        }
        if (l1 < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l1).toString());
        }
        if (b == 0L)
        {
            return -1L;
        }
        long l2 = l1;
        if (l1 > b)
        {
            l2 = b;
        }
        kq1.a_(this, l2);
        return l2;
    }

    public final long a(lj lj1)
    {
        if (lj1 == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        long l1 = 0L;
        do
        {
            long l2 = lj1.a(this, 2048L);
            if (l2 != -1L)
            {
                l1 += l2;
            } else
            {
                return l1;
            }
        } while (true);
    }

    public final kq a(int i1)
    {
        if (i1 < 128)
        {
            b(i1);
            return this;
        }
        if (i1 < 2048)
        {
            b(i1 >> 6 | 0xc0);
            b(i1 & 0x3f | 0x80);
            return this;
        }
        if (i1 < 0x10000)
        {
            if (i1 >= 55296 && i1 <= 57343)
            {
                throw new IllegalArgumentException((new StringBuilder("Unexpected code point: ")).append(Integer.toHexString(i1)).toString());
            } else
            {
                b(i1 >> 12 | 0xe0);
                b(i1 >> 6 & 0x3f | 0x80);
                b(i1 & 0x3f | 0x80);
                return this;
            }
        }
        if (i1 <= 0x10ffff)
        {
            b(i1 >> 18 | 0xf0);
            b(i1 >> 12 & 0x3f | 0x80);
            b(i1 >> 6 & 0x3f | 0x80);
            b(i1 & 0x3f | 0x80);
            return this;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Unexpected code point: ")).append(Integer.toHexString(i1)).toString());
        }
    }

    public final kq a(kq kq1, long l1, long l2)
    {
        if (kq1 == null)
        {
            throw new IllegalArgumentException("out == null");
        }
        lm.a(b, l1, l2);
        if (l2 != 0L)
        {
            kq1.b = kq1.b + l2;
            lf lf1 = a;
            lf lf3;
            long l3;
            long l4;
            do
            {
                lf3 = lf1;
                l3 = l1;
                l4 = l2;
                if (l1 < (long)(lf1.c - lf1.b))
                {
                    break;
                }
                l1 -= lf1.c - lf1.b;
                lf1 = lf1.f;
            } while (true);
            while (l4 > 0L) 
            {
                lf lf2 = new lf(lf3);
                lf2.b = (int)((long)lf2.b + l3);
                lf2.c = Math.min(lf2.b + (int)l4, lf2.c);
                if (kq1.a == null)
                {
                    lf2.g = lf2;
                    lf2.f = lf2;
                    kq1.a = lf2;
                } else
                {
                    kq1.a.g.a(lf2);
                }
                l4 -= lf2.c - lf2.b;
                lf3 = lf3.f;
                l3 = 0L;
            }
        }
        return this;
    }

    public final kq a(kt kt1)
    {
        if (kt1 == null)
        {
            throw new IllegalArgumentException("byteString == null");
        } else
        {
            a(kt1.b, 0, kt1.b.length);
            return this;
        }
    }

    public final kq a(String s)
    {
        return a(s, 0, s.length());
    }

    public final kq a(String s, int i1, int j1)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("string == null");
        }
        if (i1 < 0)
        {
            throw new IllegalAccessError((new StringBuilder("beginIndex < 0: ")).append(i1).toString());
        }
        if (j1 < i1)
        {
            throw new IllegalArgumentException((new StringBuilder("endIndex < beginIndex: ")).append(j1).append(" < ").append(i1).toString());
        }
        if (j1 > s.length())
        {
            throw new IllegalArgumentException((new StringBuilder("endIndex > string.length: ")).append(j1).append(" > ").append(s.length()).toString());
        }
          goto _L1
_L3:
        lf lf1;
        int j2;
        int k1 = (i1 + j2) - lf1.c;
        lf1.c = lf1.c + k1;
        b = b + (long)k1;
_L1:
        byte abyte0[];
        char c2;
        int k2;
        if (i1 >= j1)
        {
            break MISSING_BLOCK_LABEL_526;
        }
        c2 = s.charAt(i1);
        if (c2 >= '\200')
        {
            break MISSING_BLOCK_LABEL_272;
        }
        lf1 = e(1);
        abyte0 = lf1.a;
        j2 = lf1.c - i1;
        k2 = Math.min(j1, 2048 - j2);
        int l1 = i1 + 1;
        abyte0[j2 + i1] = (byte)c2;
        i1 = l1;
_L5:
        if (i1 >= k2) goto _L3; else goto _L2
_L2:
        char c1 = s.charAt(i1);
        if (c1 >= '\200') goto _L3; else goto _L4
_L4:
        abyte0[i1 + j2] = (byte)c1;
        i1++;
          goto _L5
        if (c2 < '\u0800')
        {
            b(c2 >> 6 | 0xc0);
            b(c2 & 0x3f | 0x80);
            i1++;
        } else
        if (c2 < '\uD800' || c2 > '\uDFFF')
        {
            b(c2 >> 12 | 0xe0);
            b(c2 >> 6 & 0x3f | 0x80);
            b(c2 & 0x3f | 0x80);
            i1++;
        } else
        {
            int i2;
            if (i1 + 1 < j1)
            {
                i2 = s.charAt(i1 + 1);
            } else
            {
                i2 = 0;
            }
            if (c2 > '\uDBFF' || i2 < '\uDC00' || i2 > '\uDFFF')
            {
                b(63);
                i1++;
            } else
            {
                i2 = (i2 & 0xffff23ff | (c2 & 0xffff27ff) << 10) + 0x10000;
                b(i2 >> 18 | 0xf0);
                b(i2 >> 12 & 0x3f | 0x80);
                b(i2 >> 6 & 0x3f | 0x80);
                b(i2 & 0x3f | 0x80);
                i1 += 2;
            }
        }
          goto _L1
        return this;
    }

    public final kq a(byte abyte0[])
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("source == null");
        } else
        {
            return a(abyte0, 0, abyte0.length);
        }
    }

    public final kq a(byte abyte0[], int i1, int j1)
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        lm.a(abyte0.length, i1, j1);
        for (int k1 = i1 + j1; i1 < k1;)
        {
            lf lf1 = e(1);
            int l1 = Math.min(k1 - i1, 2048 - lf1.c);
            System.arraycopy(abyte0, i1, lf1.a, lf1.c, l1);
            i1 += l1;
            lf1.c = l1 + lf1.c;
        }

        b = b + (long)j1;
        return this;
    }

    public final lk a()
    {
        return lk.a;
    }

    public final void a(long l1)
    {
        if (b < l1)
        {
            throw new EOFException();
        } else
        {
            return;
        }
    }

    public final void a_(kq kq1, long l1)
    {
        if (kq1 == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        if (kq1 == this)
        {
            throw new IllegalArgumentException("source == this");
        }
        lm.a(kq1.b, 0L, l1);
_L2:
        lf lf3;
        long l3;
label0:
        {
label1:
            {
                if (l1 > 0L)
                {
                    if (l1 >= (long)(kq1.a.c - kq1.a.b))
                    {
                        break label0;
                    }
                    lf lf1;
                    int i1;
                    long l2;
                    if (a != null)
                    {
                        lf1 = a.g;
                    } else
                    {
                        lf1 = null;
                    }
                    if (lf1 == null || !lf1.e)
                    {
                        break label1;
                    }
                    l2 = lf1.c;
                    if (lf1.d)
                    {
                        i1 = 0;
                    } else
                    {
                        i1 = lf1.b;
                    }
                    if ((l2 + l1) - (long)i1 > 2048L)
                    {
                        break label1;
                    }
                    kq1.a.a(lf1, (int)l1);
                    kq1.b = kq1.b - l1;
                    b = b + l1;
                }
                return;
            }
            lf lf2 = kq1.a;
            int j1 = (int)l1;
            if (j1 <= 0 || j1 > lf2.c - lf2.b)
            {
                throw new IllegalArgumentException();
            }
            lf lf4 = new lf(lf2);
            lf4.c = lf4.b + j1;
            lf2.b = j1 + lf2.b;
            lf2.g.a(lf4);
            kq1.a = lf4;
        }
        lf3 = kq1.a;
        l3 = lf3.c - lf3.b;
        kq1.a = lf3.a();
        if (a != null)
        {
            break; /* Loop/switch isn't completed */
        }
        a = lf3;
        lf3 = a;
        lf lf5 = a;
        lf lf6 = a;
        lf5.g = lf6;
        lf3.f = lf6;
_L3:
        kq1.b = kq1.b - l3;
        b = b + l3;
        l1 -= l3;
        if (true) goto _L2; else goto _L1
_L1:
        lf3 = a.g.a(lf3);
        if (lf3.g == lf3)
        {
            throw new IllegalStateException();
        }
        if (lf3.g.e)
        {
            int i2 = lf3.c - lf3.b;
            int j2 = lf3.g.c;
            int k1;
            if (lf3.g.d)
            {
                k1 = 0;
            } else
            {
                k1 = lf3.g.b;
            }
            if (i2 <= k1 + (2048 - j2))
            {
                lf3.a(lf3.g, i2);
                lf3.a();
                lg.a(lf3);
            }
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    public final byte b(long l1)
    {
        lm.a(b, l1, 1L);
        lf lf1 = a;
        do
        {
            int i1 = lf1.c - lf1.b;
            if (l1 < (long)i1)
            {
                return lf1.a[lf1.b + (int)l1];
            }
            l1 -= i1;
            lf1 = lf1.f;
        } while (true);
    }

    public final kq b()
    {
        return this;
    }

    public final kq b(int i1)
    {
        lf lf1 = e(1);
        byte abyte0[] = lf1.a;
        int j1 = lf1.c;
        lf1.c = j1 + 1;
        abyte0[j1] = (byte)i1;
        b = b + 1L;
        return this;
    }

    public final kr b(kt kt1)
    {
        return a(kt1);
    }

    public final kr b(String s)
    {
        return a(s);
    }

    public final kr b(byte abyte0[])
    {
        return a(abyte0);
    }

    public final kr b(byte abyte0[], int i1, int j1)
    {
        return a(abyte0, i1, j1);
    }

    public final kq c(int i1)
    {
        lf lf1 = e(2);
        byte abyte0[] = lf1.a;
        int j1 = lf1.c;
        int k1 = j1 + 1;
        abyte0[j1] = (byte)(i1 >>> 8);
        abyte0[k1] = (byte)i1;
        lf1.c = k1 + 1;
        b = b + 2L;
        return this;
    }

    public final kt c(long l1)
    {
        return new kt(e(l1));
    }

    public final boolean c()
    {
        return b == 0L;
    }

    public final Object clone()
    {
        return p();
    }

    public final void close()
    {
    }

    public final byte d()
    {
        if (b == 0L)
        {
            throw new IllegalStateException("size == 0");
        }
        lf lf1 = a;
        int i1 = lf1.b;
        int j1 = lf1.c;
        byte abyte0[] = lf1.a;
        int k1 = i1 + 1;
        byte byte0 = abyte0[i1];
        b = b - 1L;
        if (k1 == j1)
        {
            a = lf1.a();
            lg.a(lf1);
            return byte0;
        } else
        {
            lf1.b = k1;
            return byte0;
        }
    }

    public final kq d(int i1)
    {
        lf lf1 = e(4);
        byte abyte0[] = lf1.a;
        int k1 = lf1.c;
        int j1 = k1 + 1;
        abyte0[k1] = i1 >> 24;
        k1 = j1 + 1;
        abyte0[j1] = (byte)(i1 >>> 16);
        j1 = k1 + 1;
        abyte0[k1] = (byte)(i1 >>> 8);
        abyte0[j1] = (byte)i1;
        lf1.c = j1 + 1;
        b = b + 4L;
        return this;
    }

    final String d(long l1)
    {
        if (l1 > 0L && b(l1 - 1L) == 13)
        {
            String s = i(l1 - 1L);
            f(2L);
            return s;
        } else
        {
            String s1 = i(l1);
            f(1L);
            return s1;
        }
    }

    final lf e(int i1)
    {
        if (i1 <= 0 || i1 > 2048)
        {
            throw new IllegalArgumentException();
        }
        if (a != null) goto _L2; else goto _L1
_L1:
        lf lf1;
        a = lg.a();
        lf lf2 = a;
        lf lf4 = a;
        lf1 = a;
        lf4.g = lf1;
        lf2.f = lf1;
_L4:
        return lf1;
_L2:
        lf lf3;
        lf3 = a.g;
        if (lf3.c + i1 > 2048)
        {
            break; /* Loop/switch isn't completed */
        }
        lf1 = lf3;
        if (lf3.e) goto _L4; else goto _L3
_L3:
        return lf3.a(lg.a());
    }

    public final short e()
    {
        if (b < 2L)
        {
            throw new IllegalStateException((new StringBuilder("size < 2: ")).append(b).toString());
        }
        lf lf1 = a;
        int k1 = lf1.b;
        int i1 = lf1.c;
        if (i1 - k1 < 2)
        {
            return (short)((d() & 0xff) << 8 | d() & 0xff);
        }
        byte abyte0[] = lf1.a;
        int j1 = k1 + 1;
        k1 = abyte0[k1];
        int l1 = j1 + 1;
        j1 = abyte0[j1];
        b = b - 2L;
        if (l1 == i1)
        {
            a = lf1.a();
            lg.a(lf1);
        } else
        {
            lf1.b = l1;
        }
        return (short)((k1 & 0xff) << 8 | j1 & 0xff);
    }

    public final byte[] e(long l1)
    {
        lm.a(b, 0L, l1);
        if (l1 > 0x7fffffffL)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount > Integer.MAX_VALUE: ")).append(l1).toString());
        } else
        {
            byte abyte0[] = new byte[(int)l1];
            c(abyte0);
            return abyte0;
        }
    }

    public final boolean equals(Object obj)
    {
        long l2 = 0L;
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof kq))
        {
            return false;
        }
        obj = (kq)obj;
        if (b != ((kq) (obj)).b)
        {
            return false;
        }
        if (b == 0L)
        {
            return true;
        }
        lf lf2 = a;
        obj = ((kq) (obj)).a;
        int j1 = lf2.b;
        int i1 = ((lf) (obj)).b;
        while (l2 < b) 
        {
            long l3 = Math.min(lf2.c - j1, ((lf) (obj)).c - i1);
            for (int k1 = 0; (long)k1 < l3;)
            {
                if (lf2.a[j1] != ((lf) (obj)).a[i1])
                {
                    return false;
                }
                k1++;
                i1++;
                j1++;
            }

            int l1 = j1;
            lf lf1 = lf2;
            if (j1 == lf2.c)
            {
                lf1 = lf2.f;
                l1 = lf1.b;
            }
            j1 = i1;
            Object obj1 = obj;
            if (i1 == ((lf) (obj)).c)
            {
                obj1 = ((lf) (obj)).f;
                j1 = ((lf) (obj1)).b;
            }
            l2 += l3;
            i1 = j1;
            j1 = l1;
            lf2 = lf1;
            obj = obj1;
        }
        return true;
    }

    public final int f()
    {
        if (b < 4L)
        {
            throw new IllegalStateException((new StringBuilder("size < 4: ")).append(b).toString());
        }
        lf lf1 = a;
        int j1 = lf1.b;
        int i1 = lf1.c;
        if (i1 - j1 < 4)
        {
            return (d() & 0xff) << 24 | (d() & 0xff) << 16 | (d() & 0xff) << 8 | d() & 0xff;
        }
        byte abyte0[] = lf1.a;
        int k1 = j1 + 1;
        j1 = abyte0[j1];
        int i2 = k1 + 1;
        k1 = abyte0[k1];
        int l1 = i2 + 1;
        byte byte0 = abyte0[i2];
        i2 = l1 + 1;
        j1 = (j1 & 0xff) << 24 | (k1 & 0xff) << 16 | (byte0 & 0xff) << 8 | abyte0[l1] & 0xff;
        b = b - 4L;
        if (i2 == i1)
        {
            a = lf1.a();
            lg.a(lf1);
            return j1;
        } else
        {
            lf1.b = i2;
            return j1;
        }
    }

    public final kr f(int i1)
    {
        return d(i1);
    }

    public final void f(long l1)
    {
        do
        {
            if (l1 <= 0L)
            {
                break;
            }
            if (a == null)
            {
                throw new EOFException();
            }
            int i1 = (int)Math.min(l1, a.c - a.b);
            b = b - (long)i1;
            long l2 = l1 - (long)i1;
            lf lf1 = a;
            lf1.b = i1 + lf1.b;
            l1 = l2;
            if (a.b == a.c)
            {
                lf lf2 = a;
                a = lf2.a();
                lg.a(lf2);
                l1 = l2;
            }
        } while (true);
    }

    public final void flush()
    {
    }

    public final kq g(long l1)
    {
        if (l1 == 0L)
        {
            return b(48);
        }
        int j1 = Long.numberOfTrailingZeros(Long.highestOneBit(l1)) / 4 + 1;
        lf lf1 = e(j1);
        byte abyte0[] = lf1.a;
        int i1 = (lf1.c + j1) - 1;
        for (int k1 = lf1.c; i1 >= k1; i1--)
        {
            abyte0[i1] = c[(int)(15L & l1)];
            l1 >>>= 4;
        }

        lf1.c = lf1.c + j1;
        l1 = b;
        b = (long)j1 + l1;
        return this;
    }

    public final kr g(int i1)
    {
        return c(i1);
    }

    public final short g()
    {
        return lm.a(e());
    }

    public final int h()
    {
        return lm.a(f());
    }

    public final kr h(int i1)
    {
        return b(i1);
    }

    public final kr h(long l1)
    {
        return g(l1);
    }

    public final int hashCode()
    {
        lf lf1 = a;
        if (lf1 == null)
        {
            return 0;
        }
        int j1 = 1;
        lf lf2;
        int i1;
        do
        {
            int k1 = lf1.b;
            int l1 = lf1.c;
            for (i1 = j1; k1 < l1; i1 = j1 + i1 * 31)
            {
                j1 = lf1.a[k1];
                k1++;
            }

            lf2 = lf1.f;
            j1 = i1;
            lf1 = lf2;
        } while (lf2 != a);
        return i1;
    }

    public final long i()
    {
        int i1;
        int j1;
        long l3;
        if (b == 0L)
        {
            throw new IllegalStateException("size == 0");
        }
        l3 = 0L;
        i1 = 0;
        j1 = 0;
_L6:
        Object obj;
        byte abyte0[];
        int k1;
        int l1;
        int i2;
        long l2;
        obj = a;
        abyte0 = ((lf) (obj)).a;
        l1 = ((lf) (obj)).b;
        i2 = ((lf) (obj)).c;
        l2 = l3;
        k1 = i1;
_L7:
        byte byte0;
        i1 = j1;
        if (l1 >= i2)
        {
            break MISSING_BLOCK_LABEL_238;
        }
        byte0 = abyte0[l1];
        if (byte0 < 48 || byte0 > 57) goto _L2; else goto _L1
_L1:
        i1 = byte0 - 48;
_L4:
        if ((0xf000000000000000L & l2) != 0L)
        {
            obj = (new kq()).g(l2).b(byte0);
            throw new NumberFormatException((new StringBuilder("Number too large: ")).append(((kq) (obj)).k()).toString());
        }
        break MISSING_BLOCK_LABEL_293;
_L2:
        if (byte0 >= 97 && byte0 <= 102)
        {
            i1 = (byte0 - 97) + 10;
            continue; /* Loop/switch isn't completed */
        }
        if (byte0 < 65 || byte0 > 70)
        {
            break; /* Loop/switch isn't completed */
        }
        i1 = (byte0 - 65) + 10;
        if (true) goto _L4; else goto _L3
_L3:
        if (k1 == 0)
        {
            throw new NumberFormatException((new StringBuilder("Expected leading [0-9a-fA-F] character but was 0x")).append(Integer.toHexString(byte0)).toString());
        }
        i1 = 1;
        if (l1 == i2)
        {
            a = ((lf) (obj)).a();
            lg.a(((lf) (obj)));
        } else
        {
            obj.b = l1;
        }
        if (i1 != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        j1 = i1;
        i1 = k1;
        l3 = l2;
        if (a != null) goto _L6; else goto _L5
_L5:
        b = b - (long)k1;
        return l2;
        l3 = i1;
        k1++;
        l1++;
        l2 = l3 | l2 << 4;
          goto _L7
    }

    public final kt j()
    {
        return new kt(m());
    }

    public final String k()
    {
        String s;
        try
        {
            s = a(b, lm.a);
        }
        catch (EOFException eofexception)
        {
            throw new AssertionError(eofexception);
        }
        return s;
    }

    public final String l()
    {
        long l1 = a((byte)10, 0L);
        if (l1 == -1L)
        {
            kq kq1 = new kq();
            a(kq1, 0L, Math.min(32L, b));
            throw new EOFException((new StringBuilder("\\n not found: size=")).append(b).append(" content=").append(kq1.j().b()).append("...").toString());
        } else
        {
            return d(l1);
        }
    }

    public final byte[] m()
    {
        byte abyte0[];
        try
        {
            abyte0 = e(b);
        }
        catch (EOFException eofexception)
        {
            throw new AssertionError(eofexception);
        }
        return abyte0;
    }

    public final void n()
    {
        try
        {
            f(b);
            return;
        }
        catch (EOFException eofexception)
        {
            throw new AssertionError(eofexception);
        }
    }

    public final volatile kr o()
    {
        return this;
    }

    public final String toString()
    {
        if (b == 0L)
        {
            return "Buffer[size=0]";
        }
        if (b <= 16L)
        {
            kt kt1 = p().j();
            return String.format("Buffer[size=%s data=%s]", new Object[] {
                Long.valueOf(b), kt1.b()
            });
        }
        String s;
        MessageDigest messagedigest;
        try
        {
            messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(a.a, a.b, a.c - a.b);
            for (lf lf1 = a.f; lf1 != a; lf1 = lf1.f)
            {
                messagedigest.update(lf1.a, lf1.b, lf1.c - lf1.b);
            }

        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            throw new AssertionError();
        }
        s = String.format("Buffer[size=%s md5=%s]", new Object[] {
            Long.valueOf(b), kt.a(messagedigest.digest()).b()
        });
        return s;
    }

}
