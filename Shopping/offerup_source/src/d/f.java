// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package d;

import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Referenced classes of package d:
//            i, j, ae, y, 
//            z, ab, k, g, 
//            h, ac

public final class f
    implements i, j, Cloneable
{

    private static final byte c[] = {
        48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 
        97, 98, 99, 100, 101, 102
    };
    y a;
    long b;

    public f()
    {
    }

    private String a(long l1, Charset charset)
    {
        ae.a(b, 0L, l1);
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
            y y1 = a;
            if ((long)y1.b + l1 > (long)y1.c)
            {
                return new String(e(l1), charset);
            }
            String s1 = new String(y1.a, y1.b, (int)l1, charset);
            y1.b = (int)((long)y1.b + l1);
            b = b - l1;
            charset = s1;
            if (y1.b == y1.c)
            {
                a = y1.a();
                z.a(y1);
                return s1;
            }
        }
        return charset;
    }

    private void c(byte abyte0[])
    {
        int j1;
        for (int i1 = 0; i1 < abyte0.length; i1 += j1)
        {
            j1 = a(abyte0, i1, abyte0.length - i1);
            if (j1 == -1)
            {
                throw new EOFException();
            }
        }

    }

    private String k(long l1)
    {
        return a(l1, ae.a);
    }

    private String s()
    {
        String s1;
        try
        {
            s1 = a(b, ae.a);
        }
        catch (EOFException eofexception)
        {
            throw new AssertionError(eofexception);
        }
        return s1;
    }

    private f t()
    {
        f f1 = new f();
        if (b == 0L)
        {
            return f1;
        }
        f1.a = new y(a);
        y y1 = f1.a;
        y y3 = f1.a;
        y y4 = f1.a;
        y3.g = y4;
        y1.f = y4;
        for (y y2 = a.f; y2 != a; y2 = y2.f)
        {
            f1.a.g.a(new y(y2));
        }

        f1.b = b;
        return f1;
    }

    public final int a(byte abyte0[], int i1, int j1)
    {
        ae.a(abyte0.length, i1, j1);
        y y1 = a;
        if (y1 == null)
        {
            i1 = -1;
        } else
        {
            j1 = Math.min(j1, y1.c - y1.b);
            System.arraycopy(y1.a, y1.b, abyte0, i1, j1);
            y1.b = y1.b + j1;
            b = b - (long)j1;
            i1 = j1;
            if (y1.b == y1.c)
            {
                a = y1.a();
                z.a(y1);
                return j1;
            }
        }
        return i1;
    }

    public final long a()
    {
        return b;
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
        y y1 = a;
        if (y1 == null)
        {
            return -1L;
        }
        long l2 = 0L;
        do
        {
            int i1 = y1.c - y1.b;
            y y2;
            if (l1 >= (long)i1)
            {
                l1 -= i1;
            } else
            {
                byte abyte0[] = y1.a;
                l1 = (long)y1.b + l1;
                for (long l3 = y1.c; l1 < l3; l1++)
                {
                    if (abyte0[(int)l1] == byte0)
                    {
                        return (l2 + l1) - (long)y1.b;
                    }
                }

                l1 = 0L;
            }
            l2 += i1;
            y2 = y1.f;
            y1 = y2;
        } while (y2 != a);
        return -1L;
    }

    public final long a(ab ab1)
    {
        if (ab1 == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        long l1 = 0L;
        do
        {
            long l2 = ab1.read(this, 2048L);
            if (l2 != -1L)
            {
                l1 += l2;
            } else
            {
                return l1;
            }
        } while (true);
    }

    public final f a(int i1)
    {
        y y1 = d(1);
        byte abyte0[] = y1.a;
        int j1 = y1.c;
        y1.c = j1 + 1;
        abyte0[j1] = (byte)i1;
        b = b + 1L;
        return this;
    }

    public final f a(f f1, long l1, long l2)
    {
        if (f1 == null)
        {
            throw new IllegalArgumentException("out == null");
        }
        ae.a(b, l1, l2);
        if (l2 != 0L)
        {
            f1.b = f1.b + l2;
            y y1 = a;
            y y3;
            long l3;
            long l4;
            do
            {
                y3 = y1;
                l3 = l1;
                l4 = l2;
                if (l1 < (long)(y1.c - y1.b))
                {
                    break;
                }
                l1 -= y1.c - y1.b;
                y1 = y1.f;
            } while (true);
            while (l4 > 0L) 
            {
                y y2 = new y(y3);
                y2.b = (int)((long)y2.b + l3);
                y2.c = Math.min(y2.b + (int)l4, y2.c);
                if (f1.a == null)
                {
                    y2.g = y2;
                    y2.f = y2;
                    f1.a = y2;
                } else
                {
                    f1.a.g.a(y2);
                }
                l4 -= y2.c - y2.b;
                y3 = y3.f;
                l3 = 0L;
            }
        }
        return this;
    }

    public final f a(k k1)
    {
        if (k1 == null)
        {
            throw new IllegalArgumentException("byteString == null");
        } else
        {
            b(k1.b, 0, k1.b.length);
            return this;
        }
    }

    public final f a(String s1)
    {
        if (s1 == null)
        {
            throw new IllegalArgumentException("string == null");
        }
        int l1 = s1.length();
        for (int i1 = 0; i1 < l1;)
        {
            char c1 = s1.charAt(i1);
            if (c1 < '\200')
            {
                y y1 = d(1);
                byte abyte0[] = y1.a;
                int i2 = y1.c - i1;
                int j2 = Math.min(l1, 2048 - i2);
                int j1 = i1 + 1;
                abyte0[i1 + i2] = (byte)c1;
                i1 = j1;
                do
                {
                    if (i1 >= j2)
                    {
                        break;
                    }
                    j1 = s1.charAt(i1);
                    if (j1 >= '\200')
                    {
                        break;
                    }
                    abyte0[i1 + i2] = (byte)j1;
                    i1++;
                } while (true);
                j1 = (i1 + i2) - y1.c;
                y1.c = y1.c + j1;
                b = b + (long)j1;
            } else
            if (c1 < '\u0800')
            {
                a(c1 >> 6 | 0xc0);
                a(c1 & 0x3f | 0x80);
                i1++;
            } else
            if (c1 < '\uD800' || c1 > '\uDFFF')
            {
                a(c1 >> 12 | 0xe0);
                a(c1 >> 6 & 0x3f | 0x80);
                a(c1 & 0x3f | 0x80);
                i1++;
            } else
            {
                int k1;
                if (i1 + 1 < l1)
                {
                    k1 = s1.charAt(i1 + 1);
                } else
                {
                    k1 = 0;
                }
                if (c1 > '\uDBFF' || k1 < '\uDC00' || k1 > '\uDFFF')
                {
                    a(63);
                    i1++;
                } else
                {
                    k1 = (k1 & 0xffff23ff | (c1 & 0xffff27ff) << 10) + 0x10000;
                    a(k1 >> 18 | 0xf0);
                    a(k1 >> 12 & 0x3f | 0x80);
                    a(k1 >> 6 & 0x3f | 0x80);
                    a(k1 & 0x3f | 0x80);
                    i1 += 2;
                }
            }
        }

        return this;
    }

    public final f a(String s1, Charset charset)
    {
        if (s1 == null)
        {
            throw new IllegalArgumentException("string == null");
        }
        if (charset == null)
        {
            throw new IllegalArgumentException("charset == null");
        }
        if (charset.equals(ae.a))
        {
            return a(s1);
        } else
        {
            s1 = s1.getBytes(charset);
            return b(s1, 0, s1.length);
        }
    }

    public final f a(byte abyte0[])
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("source == null");
        } else
        {
            return b(abyte0, 0, abyte0.length);
        }
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

    public final byte b(long l1)
    {
        ae.a(b, l1, 1L);
        y y1 = a;
        do
        {
            int i1 = y1.c - y1.b;
            if (l1 < (long)i1)
            {
                return y1.a[y1.b + (int)l1];
            }
            l1 -= i1;
            y1 = y1.f;
        } while (true);
    }

    public final f b()
    {
        return this;
    }

    public final f b(int i1)
    {
        y y1 = d(2);
        byte abyte0[] = y1.a;
        int j1 = y1.c;
        int k1 = j1 + 1;
        abyte0[j1] = (byte)(i1 >>> 8);
        abyte0[k1] = (byte)i1;
        y1.c = k1 + 1;
        b = b + 2L;
        return this;
    }

    public final f b(byte abyte0[], int i1, int j1)
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        ae.a(abyte0.length, i1, j1);
        for (int k1 = i1 + j1; i1 < k1;)
        {
            y y1 = d(1);
            int l1 = Math.min(k1 - i1, 2048 - y1.c);
            System.arraycopy(abyte0, i1, y1.a, y1.c, l1);
            i1 += l1;
            y1.c = l1 + y1.c;
        }

        b = b + (long)j1;
        return this;
    }

    public final i b(k k1)
    {
        return a(k1);
    }

    public final i b(String s1)
    {
        return a(s1);
    }

    public final i b(byte abyte0[])
    {
        return a(abyte0);
    }

    public final f c(int i1)
    {
        y y1 = d(4);
        byte abyte0[] = y1.a;
        int k1 = y1.c;
        int j1 = k1 + 1;
        abyte0[k1] = (byte)(i1 >>> 24);
        k1 = j1 + 1;
        abyte0[j1] = (byte)(i1 >>> 16);
        j1 = k1 + 1;
        abyte0[k1] = (byte)(i1 >>> 8);
        abyte0[j1] = (byte)i1;
        y1.c = j1 + 1;
        b = b + 4L;
        return this;
    }

    public final i c(byte abyte0[], int i1, int j1)
    {
        return b(abyte0, i1, j1);
    }

    public final k c(long l1)
    {
        return new k(e(l1));
    }

    public final OutputStream c()
    {
        return new g(this);
    }

    public final Object clone()
    {
        return t();
    }

    public final void close()
    {
    }

    public final i d()
    {
        return this;
    }

    final y d(int i1)
    {
        if (i1 <= 0 || i1 > 2048)
        {
            throw new IllegalArgumentException();
        }
        if (a != null) goto _L2; else goto _L1
_L1:
        y y1;
        a = z.a();
        y y2 = a;
        y y4 = a;
        y1 = a;
        y4.g = y1;
        y2.f = y1;
_L4:
        return y1;
_L2:
        y y3;
        y3 = a.g;
        if (y3.c + i1 > 2048)
        {
            break; /* Loop/switch isn't completed */
        }
        y1 = y3;
        if (y3.e) goto _L4; else goto _L3
_L3:
        return y3.a(z.a());
    }

    final String d(long l1)
    {
        if (l1 > 0L && b(l1 - 1L) == 13)
        {
            String s1 = k(l1 - 1L);
            f(2L);
            return s1;
        } else
        {
            String s2 = k(l1);
            f(1L);
            return s2;
        }
    }

    public final i e(int i1)
    {
        return c(i1);
    }

    public final boolean e()
    {
        return b == 0L;
    }

    public final byte[] e(long l1)
    {
        ae.a(b, 0L, l1);
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
        if (!(obj instanceof f))
        {
            return false;
        }
        obj = (f)obj;
        if (b != ((f) (obj)).b)
        {
            return false;
        }
        if (b == 0L)
        {
            return true;
        }
        y y2 = a;
        obj = ((f) (obj)).a;
        int j1 = y2.b;
        int i1 = ((y) (obj)).b;
        while (l2 < b) 
        {
            long l3 = Math.min(y2.c - j1, ((y) (obj)).c - i1);
            for (int k1 = 0; (long)k1 < l3;)
            {
                if (y2.a[j1] != ((y) (obj)).a[i1])
                {
                    return false;
                }
                k1++;
                i1++;
                j1++;
            }

            int l1 = j1;
            y y1 = y2;
            if (j1 == y2.c)
            {
                y1 = y2.f;
                l1 = y1.b;
            }
            j1 = i1;
            Object obj1 = obj;
            if (i1 == ((y) (obj)).c)
            {
                obj1 = ((y) (obj)).f;
                j1 = ((y) (obj1)).b;
            }
            l2 += l3;
            i1 = j1;
            j1 = l1;
            y2 = y1;
            obj = obj1;
        }
        return true;
    }

    public final i f(int i1)
    {
        return b(i1);
    }

    public final InputStream f()
    {
        return new h(this);
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
            y y1 = a;
            y1.b = i1 + y1.b;
            l1 = l2;
            if (a.b == a.c)
            {
                y y2 = a;
                a = y2.a();
                z.a(y2);
                l1 = l2;
            }
        } while (true);
    }

    public final void flush()
    {
    }

    public final byte g()
    {
        if (b == 0L)
        {
            throw new IllegalStateException("size == 0");
        }
        y y1 = a;
        int i1 = y1.b;
        int j1 = y1.c;
        byte abyte0[] = y1.a;
        int k1 = i1 + 1;
        byte byte0 = abyte0[i1];
        b = b - 1L;
        if (k1 == j1)
        {
            a = y1.a();
            z.a(y1);
            return byte0;
        } else
        {
            y1.b = k1;
            return byte0;
        }
    }

    public final f g(long l1)
    {
        if (l1 == 0L)
        {
            return a(48);
        }
        y y1;
        byte abyte0[];
        int i1;
        boolean flag;
        int j1;
        if (l1 < 0L)
        {
            l1 = -l1;
            if (l1 < 0L)
            {
                return a("-9223372036854775808");
            }
            flag = true;
        } else
        {
            flag = false;
        }
        if (l1 < 0x5f5e100L)
        {
            if (l1 < 10000L)
            {
                if (l1 < 100L)
                {
                    if (l1 < 10L)
                    {
                        i1 = 1;
                    } else
                    {
                        i1 = 2;
                    }
                } else
                if (l1 < 1000L)
                {
                    i1 = 3;
                } else
                {
                    i1 = 4;
                }
            } else
            if (l1 < 0xf4240L)
            {
                if (l1 < 0x186a0L)
                {
                    i1 = 5;
                } else
                {
                    i1 = 6;
                }
            } else
            if (l1 < 0x989680L)
            {
                i1 = 7;
            } else
            {
                i1 = 8;
            }
        } else
        if (l1 < 0xe8d4a51000L)
        {
            if (l1 < 0x2540be400L)
            {
                if (l1 < 0x3b9aca00L)
                {
                    i1 = 9;
                } else
                {
                    i1 = 10;
                }
            } else
            if (l1 < 0x174876e800L)
            {
                i1 = 11;
            } else
            {
                i1 = 12;
            }
        } else
        if (l1 < 0x38d7ea4c68000L)
        {
            if (l1 < 0x9184e72a000L)
            {
                i1 = 13;
            } else
            if (l1 < 0x5af3107a4000L)
            {
                i1 = 14;
            } else
            {
                i1 = 15;
            }
        } else
        if (l1 < 0x16345785d8a0000L)
        {
            if (l1 < 0x2386f26fc10000L)
            {
                i1 = 16;
            } else
            {
                i1 = 17;
            }
        } else
        if (l1 < 0xde0b6b3a7640000L)
        {
            i1 = 18;
        } else
        {
            i1 = 19;
        }
        j1 = i1;
        if (flag)
        {
            j1 = i1 + 1;
        }
        y1 = d(j1);
        abyte0 = y1.a;
        i1 = y1.c + j1;
        for (; l1 != 0L; l1 /= 10L)
        {
            int k1 = (int)(l1 % 10L);
            i1--;
            abyte0[i1] = c[k1];
        }

        if (flag)
        {
            abyte0[i1 - 1] = 45;
        }
        y1.c = y1.c + j1;
        l1 = b;
        b = (long)j1 + l1;
        return this;
    }

    public final i g(int i1)
    {
        return a(i1);
    }

    public final f h(long l1)
    {
        if (l1 == 0L)
        {
            return a(48);
        }
        int j1 = Long.numberOfTrailingZeros(Long.highestOneBit(l1)) / 4 + 1;
        y y1 = d(j1);
        byte abyte0[] = y1.a;
        int i1 = (y1.c + j1) - 1;
        for (int k1 = y1.c; i1 >= k1; i1--)
        {
            abyte0[i1] = c[(int)(15L & l1)];
            l1 >>>= 4;
        }

        y1.c = y1.c + j1;
        l1 = b;
        b = (long)j1 + l1;
        return this;
    }

    public final short h()
    {
        if (b < 2L)
        {
            throw new IllegalStateException((new StringBuilder("size < 2: ")).append(b).toString());
        }
        y y1 = a;
        int k1 = y1.b;
        int i1 = y1.c;
        if (i1 - k1 < 2)
        {
            return (short)((g() & 0xff) << 8 | g() & 0xff);
        }
        byte abyte0[] = y1.a;
        int j1 = k1 + 1;
        k1 = abyte0[k1];
        int l1 = j1 + 1;
        j1 = abyte0[j1];
        b = b - 2L;
        if (l1 == i1)
        {
            a = y1.a();
            z.a(y1);
        } else
        {
            y1.b = l1;
        }
        return (short)((k1 & 0xff) << 8 | j1 & 0xff);
    }

    public final int hashCode()
    {
        y y1 = a;
        if (y1 == null)
        {
            return 0;
        }
        int j1 = 1;
        y y2;
        int i1;
        do
        {
            int k1 = y1.b;
            int l1 = y1.c;
            for (i1 = j1; k1 < l1; i1 = j1 + i1 * 31)
            {
                j1 = y1.a[k1];
                k1++;
            }

            y2 = y1.f;
            j1 = i1;
            y1 = y2;
        } while (y2 != a);
        return i1;
    }

    public final int i()
    {
        if (b < 4L)
        {
            throw new IllegalStateException((new StringBuilder("size < 4: ")).append(b).toString());
        }
        y y1 = a;
        int j1 = y1.b;
        int i1 = y1.c;
        if (i1 - j1 < 4)
        {
            return (g() & 0xff) << 24 | (g() & 0xff) << 16 | (g() & 0xff) << 8 | g() & 0xff;
        }
        byte abyte0[] = y1.a;
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
            a = y1.a();
            z.a(y1);
            return j1;
        } else
        {
            y1.b = i2;
            return j1;
        }
    }

    public final i i(long l1)
    {
        return h(l1);
    }

    public final i j(long l1)
    {
        return g(l1);
    }

    public final short j()
    {
        return ae.a(h());
    }

    public final int k()
    {
        return ae.a(i());
    }

    public final long l()
    {
        byte byte0;
        int k1;
        int l1;
        long l3;
        long l4;
        if (b == 0L)
        {
            throw new IllegalStateException("size == 0");
        }
        l3 = 0L;
        k1 = 0;
        l1 = 0;
        byte0 = 0;
        l4 = -7L;
_L6:
        Object obj;
        byte abyte0[];
        int i1;
        boolean flag;
        int j1;
        int i2;
        long l2;
        obj = a;
        abyte0 = ((y) (obj)).a;
        j1 = ((y) (obj)).b;
        i2 = ((y) (obj)).c;
        l2 = l3;
        i1 = k1;
        flag = l1;
        l3 = l4;
_L2:
        k1 = byte0;
        if (j1 >= i2)
        {
            break MISSING_BLOCK_LABEL_282;
        }
        k1 = abyte0[j1];
        if (k1 < 48 || k1 > 57)
        {
            break; /* Loop/switch isn't completed */
        }
        l1 = 48 - k1;
        if (l2 < 0xf333333333333334L || l2 == 0xf333333333333334L && (long)l1 < l3)
        {
            obj = (new f()).g(l2).a(k1);
            if (!flag)
            {
                ((f) (obj)).g();
            }
            throw new NumberFormatException((new StringBuilder("Number too large: ")).append(((f) (obj)).s()).toString());
        }
        l2 = l2 * 10L + (long)l1;
_L3:
        j1++;
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
label0:
        {
            if (k1 != 45 || i1 != 0)
            {
                break label0;
            }
            flag = true;
            l3--;
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
        if (i1 == 0)
        {
            throw new NumberFormatException((new StringBuilder("Expected leading [0-9] or '-' character but was 0x")).append(Integer.toHexString(k1)).toString());
        }
        k1 = 1;
        if (j1 == i2)
        {
            a = ((y) (obj)).a();
            z.a(((y) (obj)));
        } else
        {
            obj.b = j1;
        }
        if (k1 != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        l4 = l3;
        byte0 = k1;
        l1 = ((flag) ? 1 : 0);
        k1 = i1;
        l3 = l2;
        if (a != null) goto _L6; else goto _L5
_L5:
        b = b - (long)i1;
        if (flag)
        {
            return l2;
        } else
        {
            return -l2;
        }
    }

    public final long m()
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
        abyte0 = ((y) (obj)).a;
        l1 = ((y) (obj)).b;
        i2 = ((y) (obj)).c;
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
            obj = (new f()).h(l2).a(byte0);
            throw new NumberFormatException((new StringBuilder("Number too large: ")).append(((f) (obj)).s()).toString());
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
            a = ((y) (obj)).a();
            z.a(((y) (obj)));
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

    public final k n()
    {
        return new k(p());
    }

    public final String o()
    {
        long l1 = a((byte)10, 0L);
        if (l1 == -1L)
        {
            f f1 = new f();
            a(f1, 0L, Math.min(32L, b));
            throw new EOFException((new StringBuilder("\\n not found: size=")).append(b).append(" content=").append(f1.n().c()).append("...").toString());
        } else
        {
            return d(l1);
        }
    }

    public final byte[] p()
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

    public final void q()
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

    public final volatile i r()
    {
        return this;
    }

    public final long read(f f1, long l1)
    {
        if (f1 == null)
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
        f1.write(this, l2);
        return l2;
    }

    public final ac timeout()
    {
        return ac.NONE;
    }

    public final String toString()
    {
        if (b == 0L)
        {
            return "Buffer[size=0]";
        }
        if (b <= 16L)
        {
            k k1 = t().n();
            return String.format("Buffer[size=%s data=%s]", new Object[] {
                Long.valueOf(b), k1.c()
            });
        }
        String s1;
        MessageDigest messagedigest;
        try
        {
            messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(a.a, a.b, a.c - a.b);
            for (y y1 = a.f; y1 != a; y1 = y1.f)
            {
                messagedigest.update(y1.a, y1.b, y1.c - y1.b);
            }

        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            throw new AssertionError();
        }
        s1 = String.format("Buffer[size=%s md5=%s]", new Object[] {
            Long.valueOf(b), d.k.a(messagedigest.digest()).c()
        });
        return s1;
    }

    public final void write(f f1, long l1)
    {
        if (f1 == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        if (f1 == this)
        {
            throw new IllegalArgumentException("source == this");
        }
        ae.a(f1.b, 0L, l1);
_L2:
        y y3;
        long l3;
label0:
        {
label1:
            {
                if (l1 > 0L)
                {
                    if (l1 >= (long)(f1.a.c - f1.a.b))
                    {
                        break label0;
                    }
                    y y1;
                    int i1;
                    long l2;
                    if (a != null)
                    {
                        y1 = a.g;
                    } else
                    {
                        y1 = null;
                    }
                    if (y1 == null || !y1.e)
                    {
                        break label1;
                    }
                    l2 = y1.c;
                    if (y1.d)
                    {
                        i1 = 0;
                    } else
                    {
                        i1 = y1.b;
                    }
                    if ((l2 + l1) - (long)i1 > 2048L)
                    {
                        break label1;
                    }
                    f1.a.a(y1, (int)l1);
                    f1.b = f1.b - l1;
                    b = b + l1;
                }
                return;
            }
            y y2 = f1.a;
            int j1 = (int)l1;
            if (j1 <= 0 || j1 > y2.c - y2.b)
            {
                throw new IllegalArgumentException();
            }
            y y4 = new y(y2);
            y4.c = y4.b + j1;
            y2.b = j1 + y2.b;
            y2.g.a(y4);
            f1.a = y4;
        }
        y3 = f1.a;
        l3 = y3.c - y3.b;
        f1.a = y3.a();
        if (a != null)
        {
            break; /* Loop/switch isn't completed */
        }
        a = y3;
        y3 = a;
        y y5 = a;
        y y6 = a;
        y5.g = y6;
        y3.f = y6;
_L3:
        f1.b = f1.b - l3;
        b = b + l3;
        l1 -= l3;
        if (true) goto _L2; else goto _L1
_L1:
        y3 = a.g.a(y3);
        if (y3.g == y3)
        {
            throw new IllegalStateException();
        }
        if (y3.g.e)
        {
            int i2 = y3.c - y3.b;
            int j2 = y3.g.c;
            int k1;
            if (y3.g.d)
            {
                k1 = 0;
            } else
            {
                k1 = y3.g.b;
            }
            if (i2 <= k1 + (2048 - j2))
            {
                y3.a(y3.g, i2);
                y3.a();
                z.a(y3);
            }
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

}
