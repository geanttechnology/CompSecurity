// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Referenced classes of package android.support.v7:
//            apw, apx, aqm, aqh, 
//            aqi, aqj, aqk, apy, 
//            aql

public final class apv
    implements apw, apx, Cloneable
{

    private static final byte c[] = {
        48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 
        97, 98, 99, 100, 101, 102
    };
    aqh a;
    long b;

    public apv()
    {
    }

    public int a(byte abyte0[], int i1, int j1)
    {
        aqm.a(abyte0.length, i1, j1);
        aqh aqh1 = a;
        if (aqh1 == null)
        {
            i1 = -1;
        } else
        {
            j1 = Math.min(j1, aqh1.c - aqh1.b);
            System.arraycopy(aqh1.a, aqh1.b, abyte0, i1, j1);
            aqh1.b = aqh1.b + j1;
            b = b - (long)j1;
            i1 = j1;
            if (aqh1.b == aqh1.c)
            {
                a = aqh1.a();
                aqi.a(aqh1);
                return j1;
            }
        }
        return i1;
    }

    public long a()
    {
        return b;
    }

    public long a(byte byte0)
    {
        return a(byte0, 0L);
    }

    public long a(byte byte0, long l1)
    {
        if (l1 < 0L)
        {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        aqh aqh1 = a;
        if (aqh1 == null)
        {
            return -1L;
        }
        long l2 = 0L;
        do
        {
            int i1 = aqh1.c - aqh1.b;
            aqh aqh2;
            if (l1 >= (long)i1)
            {
                l1 -= i1;
            } else
            {
                byte abyte0[] = aqh1.a;
                l1 = (long)aqh1.b + l1;
                for (long l3 = aqh1.c; l1 < l3; l1++)
                {
                    if (abyte0[(int)l1] == byte0)
                    {
                        return (l2 + l1) - (long)aqh1.b;
                    }
                }

                l1 = 0L;
            }
            l2 += i1;
            aqh2 = aqh1.f;
            aqh1 = aqh2;
        } while (aqh2 != a);
        return -1L;
    }

    public long a(aqj aqj1)
        throws IOException
    {
        long l1 = b;
        if (l1 > 0L)
        {
            aqj1.write(this, l1);
        }
        return l1;
    }

    public long a(aqk aqk1)
        throws IOException
    {
        if (aqk1 == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        long l1 = 0L;
        do
        {
            long l2 = aqk1.read(this, 2048L);
            if (l2 != -1L)
            {
                l1 += l2;
            } else
            {
                return l1;
            }
        } while (true);
    }

    public apv a(int i1)
    {
        aqh aqh1 = d(1);
        byte abyte0[] = aqh1.a;
        int j1 = aqh1.c;
        aqh1.c = j1 + 1;
        abyte0[j1] = (byte)i1;
        b = b + 1L;
        return this;
    }

    public apv a(apv apv1, long l1, long l2)
    {
        if (apv1 == null)
        {
            throw new IllegalArgumentException("out == null");
        }
        aqm.a(b, l1, l2);
        if (l2 != 0L)
        {
            apv1.b = apv1.b + l2;
            aqh aqh1 = a;
            aqh aqh3;
            long l3;
            long l4;
            do
            {
                aqh3 = aqh1;
                l3 = l1;
                l4 = l2;
                if (l1 < (long)(aqh1.c - aqh1.b))
                {
                    break;
                }
                l1 -= aqh1.c - aqh1.b;
                aqh1 = aqh1.f;
            } while (true);
            while (l4 > 0L) 
            {
                aqh aqh2 = new aqh(aqh3);
                aqh2.b = (int)((long)aqh2.b + l3);
                aqh2.c = Math.min(aqh2.b + (int)l4, aqh2.c);
                if (apv1.a == null)
                {
                    aqh2.g = aqh2;
                    aqh2.f = aqh2;
                    apv1.a = aqh2;
                } else
                {
                    apv1.a.g.a(aqh2);
                }
                l4 -= aqh2.c - aqh2.b;
                aqh3 = aqh3.f;
                l3 = 0L;
            }
        }
        return this;
    }

    public apv a(apy apy1)
    {
        if (apy1 == null)
        {
            throw new IllegalArgumentException("byteString == null");
        } else
        {
            apy1.a(this);
            return this;
        }
    }

    public apv a(String s1)
    {
        if (s1 == null)
        {
            throw new IllegalArgumentException("string == null");
        }
        int i2 = s1.length();
        int i1 = 0;
label0:
        do
        {
            if (i1 >= i2)
            {
                break;
            }
            char c1 = s1.charAt(i1);
            if (c1 < '\200')
            {
                aqh aqh1 = d(1);
                byte abyte0[] = aqh1.a;
                int j2 = aqh1.c - i1;
                int k2 = Math.min(i2, 2048 - j2);
                int j1 = i1 + 1;
                abyte0[i1 + j2] = (byte)c1;
                i1 = j1;
                do
                {
                    int k1;
label1:
                    {
                        if (i1 < k2)
                        {
                            k1 = s1.charAt(i1);
                            if (k1 < 128)
                            {
                                break label1;
                            }
                        }
                        k1 = (i1 + j2) - aqh1.c;
                        aqh1.c = aqh1.c + k1;
                        b = b + (long)k1;
                        continue label0;
                    }
                    abyte0[i1 + j2] = (byte)k1;
                    i1++;
                } while (true);
            }
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
                int l1;
                if (i1 + 1 < i2)
                {
                    l1 = s1.charAt(i1 + 1);
                } else
                {
                    l1 = 0;
                }
                if (c1 > '\uDBFF' || l1 < '\uDC00' || l1 > '\uDFFF')
                {
                    a(63);
                    i1++;
                } else
                {
                    l1 = (l1 & 0xffff23ff | (c1 & 0xffff27ff) << 10) + 0x10000;
                    a(l1 >> 18 | 0xf0);
                    a(l1 >> 12 & 0x3f | 0x80);
                    a(l1 >> 6 & 0x3f | 0x80);
                    a(l1 & 0x3f | 0x80);
                    i1 += 2;
                }
            }
        } while (true);
        return this;
    }

    public apv a(String s1, Charset charset)
    {
        if (s1 == null)
        {
            throw new IllegalArgumentException("string == null");
        }
        if (charset == null)
        {
            throw new IllegalArgumentException("charset == null");
        }
        if (charset.equals(aqm.a))
        {
            return a(s1);
        } else
        {
            s1 = s1.getBytes(charset);
            return b(s1, 0, s1.length);
        }
    }

    public String a(long l1, Charset charset)
        throws EOFException
    {
        aqm.a(b, 0L, l1);
        if (charset == null)
        {
            throw new IllegalArgumentException("charset == null");
        }
        if (l1 > 0x7fffffffL)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("byteCount > Integer.MAX_VALUE: ").append(l1).toString());
        }
        if (l1 == 0L)
        {
            charset = "";
        } else
        {
            aqh aqh1 = a;
            if ((long)aqh1.b + l1 > (long)aqh1.c)
            {
                return new String(f(l1), charset);
            }
            String s1 = new String(aqh1.a, aqh1.b, (int)l1, charset);
            aqh1.b = (int)((long)aqh1.b + l1);
            b = b - l1;
            charset = s1;
            if (aqh1.b == aqh1.c)
            {
                a = aqh1.a();
                aqi.a(aqh1);
                return s1;
            }
        }
        return charset;
    }

    public void a(long l1)
        throws EOFException
    {
        if (b < l1)
        {
            throw new EOFException();
        } else
        {
            return;
        }
    }

    public void a(byte abyte0[])
        throws EOFException
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

    public byte b(long l1)
    {
        aqm.a(b, l1, 1L);
        aqh aqh1 = a;
        do
        {
            int i1 = aqh1.c - aqh1.b;
            if (l1 < (long)i1)
            {
                return aqh1.a[aqh1.b + (int)l1];
            }
            l1 -= i1;
            aqh1 = aqh1.f;
        } while (true);
    }

    public apv b()
    {
        return this;
    }

    public apv b(int i1)
    {
        aqh aqh1 = d(2);
        byte abyte0[] = aqh1.a;
        int j1 = aqh1.c;
        int k1 = j1 + 1;
        abyte0[j1] = (byte)(i1 >>> 8 & 0xff);
        abyte0[k1] = (byte)(i1 & 0xff);
        aqh1.c = k1 + 1;
        b = b + 2L;
        return this;
    }

    public apv b(byte abyte0[])
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("source == null");
        } else
        {
            return b(abyte0, 0, abyte0.length);
        }
    }

    public apv b(byte abyte0[], int i1, int j1)
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        aqm.a(abyte0.length, i1, j1);
        for (int k1 = i1 + j1; i1 < k1;)
        {
            aqh aqh1 = d(1);
            int l1 = Math.min(k1 - i1, 2048 - aqh1.c);
            System.arraycopy(abyte0, i1, aqh1.a, aqh1.c, l1);
            i1 += l1;
            aqh1.c = l1 + aqh1.c;
        }

        b = b + (long)j1;
        return this;
    }

    public apw b(apy apy1)
        throws IOException
    {
        return a(apy1);
    }

    public apw b(String s1)
        throws IOException
    {
        return a(s1);
    }

    public apv c(int i1)
    {
        aqh aqh1 = d(4);
        byte abyte0[] = aqh1.a;
        int k1 = aqh1.c;
        int j1 = k1 + 1;
        abyte0[k1] = (byte)(i1 >>> 24 & 0xff);
        k1 = j1 + 1;
        abyte0[j1] = (byte)(i1 >>> 16 & 0xff);
        j1 = k1 + 1;
        abyte0[k1] = (byte)(i1 >>> 8 & 0xff);
        abyte0[j1] = (byte)(i1 & 0xff);
        aqh1.c = j1 + 1;
        b = b + 4L;
        return this;
    }

    public apw c(byte abyte0[])
        throws IOException
    {
        return b(abyte0);
    }

    public apw c(byte abyte0[], int i1, int j1)
        throws IOException
    {
        return b(abyte0, i1, j1);
    }

    public apy c(long l1)
        throws EOFException
    {
        return new apy(f(l1));
    }

    public OutputStream c()
    {
        return new OutputStream() {

            final apv a;

            public void close()
            {
            }

            public void flush()
            {
            }

            public String toString()
            {
                return (new StringBuilder()).append(this).append(".outputStream()").toString();
            }

            public void write(int i1)
            {
                a.a((byte)i1);
            }

            public void write(byte abyte0[], int i1, int j1)
            {
                a.b(abyte0, i1, j1);
            }

            
            {
                a = apv.this;
                super();
            }
        };
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return u();
    }

    public void close()
    {
    }

    public apv d()
    {
        return this;
    }

    aqh d(int i1)
    {
        if (i1 < 1 || i1 > 2048)
        {
            throw new IllegalArgumentException();
        }
        if (a != null) goto _L2; else goto _L1
_L1:
        aqh aqh1;
        a = aqi.a();
        aqh aqh2 = a;
        aqh aqh4 = a;
        aqh1 = a;
        aqh4.g = aqh1;
        aqh2.f = aqh1;
_L4:
        return aqh1;
_L2:
        aqh aqh3;
        aqh3 = a.g;
        if (aqh3.c + i1 > 2048)
        {
            break; /* Loop/switch isn't completed */
        }
        aqh1 = aqh3;
        if (aqh3.e) goto _L4; else goto _L3
_L3:
        return aqh3.a(aqi.a());
    }

    public String d(long l1)
        throws EOFException
    {
        return a(l1, aqm.a);
    }

    public apw e()
    {
        return this;
    }

    public apw e(int i1)
        throws IOException
    {
        return c(i1);
    }

    String e(long l1)
        throws EOFException
    {
        if (l1 > 0L && b(l1 - 1L) == 13)
        {
            String s1 = d(l1 - 1L);
            g(2L);
            return s1;
        } else
        {
            String s2 = d(l1);
            g(1L);
            return s2;
        }
    }

    public boolean equals(Object obj)
    {
        long l2 = 0L;
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof apv))
        {
            return false;
        }
        obj = (apv)obj;
        if (b != ((apv) (obj)).b)
        {
            return false;
        }
        if (b == 0L)
        {
            return true;
        }
        Object obj1 = a;
        obj = ((apv) (obj)).a;
        int j1 = ((aqh) (obj1)).b;
        int i1 = ((aqh) (obj)).b;
        while (l2 < b) 
        {
            long l3 = Math.min(((aqh) (obj1)).c - j1, ((aqh) (obj)).c - i1);
            for (int k1 = 0; (long)k1 < l3;)
            {
                if (((aqh) (obj1)).a[j1] != ((aqh) (obj)).a[i1])
                {
                    return false;
                }
                k1++;
                i1++;
                j1++;
            }

            int l1 = j1;
            aqh aqh1 = ((aqh) (obj1));
            if (j1 == ((aqh) (obj1)).c)
            {
                aqh1 = ((aqh) (obj1)).f;
                l1 = aqh1.b;
            }
            j1 = i1;
            obj1 = obj;
            if (i1 == ((aqh) (obj)).c)
            {
                obj1 = ((aqh) (obj)).f;
                j1 = ((aqh) (obj1)).b;
            }
            l2 += l3;
            i1 = j1;
            j1 = l1;
            obj = obj1;
            obj1 = aqh1;
        }
        return true;
    }

    public apw f(int i1)
        throws IOException
    {
        return b(i1);
    }

    public boolean f()
    {
        return b == 0L;
    }

    public byte[] f(long l1)
        throws EOFException
    {
        aqm.a(b, 0L, l1);
        if (l1 > 0x7fffffffL)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("byteCount > Integer.MAX_VALUE: ").append(l1).toString());
        } else
        {
            byte abyte0[] = new byte[(int)l1];
            a(abyte0);
            return abyte0;
        }
    }

    public void flush()
    {
    }

    public apw g(int i1)
        throws IOException
    {
        return a(i1);
    }

    public InputStream g()
    {
        return new InputStream() {

            final apv a;

            public int available()
            {
                return (int)Math.min(a.b, 0x7fffffffL);
            }

            public void close()
            {
            }

            public int read()
            {
                if (a.b > 0L)
                {
                    return a.i() & 0xff;
                } else
                {
                    return -1;
                }
            }

            public int read(byte abyte0[], int i1, int j1)
            {
                return a.a(abyte0, i1, j1);
            }

            public String toString()
            {
                return (new StringBuilder()).append(a).append(".inputStream()").toString();
            }

            
            {
                a = apv.this;
                super();
            }
        };
    }

    public void g(long l1)
        throws EOFException
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
            aqh aqh1 = a;
            aqh1.b = i1 + aqh1.b;
            l1 = l2;
            if (a.b == a.c)
            {
                aqh aqh2 = a;
                a = aqh2.a();
                aqi.a(aqh2);
                l1 = l2;
            }
        } while (true);
    }

    public long h()
    {
        long l2 = b;
        long l1;
        if (l2 == 0L)
        {
            l1 = 0L;
        } else
        {
            aqh aqh1 = a.g;
            l1 = l2;
            if (aqh1.c < 2048)
            {
                l1 = l2;
                if (aqh1.e)
                {
                    return l2 - (long)(aqh1.c - aqh1.b);
                }
            }
        }
        return l1;
    }

    public apv h(long l1)
    {
        if (l1 == 0L)
        {
            return a(48);
        }
        aqh aqh1;
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
        aqh1 = d(j1);
        abyte0 = aqh1.a;
        i1 = aqh1.c + j1;
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
        aqh1.c = aqh1.c + j1;
        l1 = b;
        b = (long)j1 + l1;
        return this;
    }

    public int hashCode()
    {
        aqh aqh1 = a;
        if (aqh1 == null)
        {
            return 0;
        }
        int j1 = 1;
        aqh aqh2;
        int i1;
        do
        {
            int k1 = aqh1.b;
            int l1 = aqh1.c;
            for (i1 = j1; k1 < l1; i1 = j1 + i1 * 31)
            {
                j1 = aqh1.a[k1];
                k1++;
            }

            aqh2 = aqh1.f;
            j1 = i1;
            aqh1 = aqh2;
        } while (aqh2 != a);
        return i1;
    }

    public byte i()
    {
        if (b == 0L)
        {
            throw new IllegalStateException("size == 0");
        }
        aqh aqh1 = a;
        int i1 = aqh1.b;
        int j1 = aqh1.c;
        byte abyte0[] = aqh1.a;
        int k1 = i1 + 1;
        byte byte0 = abyte0[i1];
        b = b - 1L;
        if (k1 == j1)
        {
            a = aqh1.a();
            aqi.a(aqh1);
            return byte0;
        } else
        {
            aqh1.b = k1;
            return byte0;
        }
    }

    public apv i(long l1)
    {
        if (l1 == 0L)
        {
            return a(48);
        }
        int j1 = Long.numberOfTrailingZeros(Long.highestOneBit(l1)) / 4 + 1;
        aqh aqh1 = d(j1);
        byte abyte0[] = aqh1.a;
        int i1 = (aqh1.c + j1) - 1;
        for (int k1 = aqh1.c; i1 >= k1; i1--)
        {
            abyte0[i1] = c[(int)(15L & l1)];
            l1 >>>= 4;
        }

        aqh1.c = aqh1.c + j1;
        l1 = b;
        b = (long)j1 + l1;
        return this;
    }

    public apw j(long l1)
        throws IOException
    {
        return i(l1);
    }

    public short j()
    {
        if (b < 2L)
        {
            throw new IllegalStateException((new StringBuilder()).append("size < 2: ").append(b).toString());
        }
        aqh aqh1 = a;
        int k1 = aqh1.b;
        int i1 = aqh1.c;
        if (i1 - k1 < 2)
        {
            return (short)((i() & 0xff) << 8 | i() & 0xff);
        }
        byte abyte0[] = aqh1.a;
        int j1 = k1 + 1;
        k1 = abyte0[k1];
        int l1 = j1 + 1;
        j1 = abyte0[j1];
        b = b - 2L;
        if (l1 == i1)
        {
            a = aqh1.a();
            aqi.a(aqh1);
        } else
        {
            aqh1.b = l1;
        }
        return (short)((k1 & 0xff) << 8 | j1 & 0xff);
    }

    public int k()
    {
        if (b < 4L)
        {
            throw new IllegalStateException((new StringBuilder()).append("size < 4: ").append(b).toString());
        }
        aqh aqh1 = a;
        int j1 = aqh1.b;
        int i1 = aqh1.c;
        if (i1 - j1 < 4)
        {
            return (i() & 0xff) << 24 | (i() & 0xff) << 16 | (i() & 0xff) << 8 | i() & 0xff;
        }
        byte abyte0[] = aqh1.a;
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
            a = aqh1.a();
            aqi.a(aqh1);
            return j1;
        } else
        {
            aqh1.b = i2;
            return j1;
        }
    }

    public apw k(long l1)
        throws IOException
    {
        return h(l1);
    }

    public short l()
    {
        return aqm.a(j());
    }

    public int m()
    {
        return aqm.a(k());
    }

    public long n()
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
        abyte0 = ((aqh) (obj)).a;
        j1 = ((aqh) (obj)).b;
        i2 = ((aqh) (obj)).c;
        l2 = l3;
        i1 = k1;
        flag = l1;
        l3 = l4;
_L2:
        k1 = byte0;
        if (j1 >= i2)
        {
            break MISSING_BLOCK_LABEL_288;
        }
        k1 = abyte0[j1];
        if (k1 < 48 || k1 > 57)
        {
            break; /* Loop/switch isn't completed */
        }
        l1 = 48 - k1;
        if (l2 < 0xf333333333333334L || l2 == 0xf333333333333334L && (long)l1 < l3)
        {
            obj = (new apv()).h(l2).a(k1);
            if (!flag)
            {
                ((apv) (obj)).i();
            }
            throw new NumberFormatException((new StringBuilder()).append("Number too large: ").append(((apv) (obj)).q()).toString());
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
            throw new NumberFormatException((new StringBuilder()).append("Expected leading [0-9] or '-' character but was 0x").append(Integer.toHexString(k1)).toString());
        }
        k1 = 1;
        if (j1 == i2)
        {
            a = ((aqh) (obj)).a();
            aqi.a(((aqh) (obj)));
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

    public long o()
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
        abyte0 = ((aqh) (obj)).a;
        l1 = ((aqh) (obj)).b;
        i2 = ((aqh) (obj)).c;
        l2 = l3;
        k1 = i1;
_L7:
        byte byte0;
        i1 = j1;
        if (l1 >= i2)
        {
            break MISSING_BLOCK_LABEL_244;
        }
        byte0 = abyte0[l1];
        if (byte0 < 48 || byte0 > 57) goto _L2; else goto _L1
_L1:
        i1 = byte0 - 48;
_L4:
        if ((0xf000000000000000L & l2) != 0L)
        {
            obj = (new apv()).i(l2).a(byte0);
            throw new NumberFormatException((new StringBuilder()).append("Number too large: ").append(((apv) (obj)).q()).toString());
        }
        break MISSING_BLOCK_LABEL_299;
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
            throw new NumberFormatException((new StringBuilder()).append("Expected leading [0-9a-fA-F] character but was 0x").append(Integer.toHexString(byte0)).toString());
        }
        i1 = 1;
        if (l1 == i2)
        {
            a = ((aqh) (obj)).a();
            aqi.a(((aqh) (obj)));
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

    public apy p()
    {
        return new apy(s());
    }

    public String q()
    {
        String s1;
        try
        {
            s1 = a(b, aqm.a);
        }
        catch (EOFException eofexception)
        {
            throw new AssertionError(eofexception);
        }
        return s1;
    }

    public String r()
        throws EOFException
    {
        long l1 = a((byte)10);
        if (l1 == -1L)
        {
            apv apv1 = new apv();
            a(apv1, 0L, Math.min(32L, b));
            throw new EOFException((new StringBuilder()).append("\\n not found: size=").append(a()).append(" content=").append(apv1.p().d()).append("...").toString());
        } else
        {
            return e(l1);
        }
    }

    public long read(apv apv1, long l1)
    {
        if (apv1 == null)
        {
            throw new IllegalArgumentException("sink == null");
        }
        if (l1 < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("byteCount < 0: ").append(l1).toString());
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
        apv1.write(this, l2);
        return l2;
    }

    public byte[] s()
    {
        byte abyte0[];
        try
        {
            abyte0 = f(b);
        }
        catch (EOFException eofexception)
        {
            throw new AssertionError(eofexception);
        }
        return abyte0;
    }

    public void t()
    {
        try
        {
            g(b);
            return;
        }
        catch (EOFException eofexception)
        {
            throw new AssertionError(eofexception);
        }
    }

    public aql timeout()
    {
        return aql.NONE;
    }

    public String toString()
    {
        if (b == 0L)
        {
            return "Buffer[size=0]";
        }
        if (b <= 16L)
        {
            apy apy1 = u().p();
            return String.format("Buffer[size=%s data=%s]", new Object[] {
                Long.valueOf(b), apy1.d()
            });
        }
        String s1;
        MessageDigest messagedigest;
        try
        {
            messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(a.a, a.b, a.c - a.b);
            for (aqh aqh1 = a.f; aqh1 != a; aqh1 = aqh1.f)
            {
                messagedigest.update(aqh1.a, aqh1.b, aqh1.c - aqh1.b);
            }

        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            throw new AssertionError();
        }
        s1 = String.format("Buffer[size=%s md5=%s]", new Object[] {
            Long.valueOf(b), apy.a(messagedigest.digest()).d()
        });
        return s1;
    }

    public apv u()
    {
        apv apv1 = new apv();
        if (b == 0L)
        {
            return apv1;
        }
        apv1.a = new aqh(a);
        aqh aqh1 = apv1.a;
        aqh aqh3 = apv1.a;
        aqh aqh4 = apv1.a;
        aqh3.g = aqh4;
        aqh1.f = aqh4;
        for (aqh aqh2 = a.f; aqh2 != a; aqh2 = aqh2.f)
        {
            apv1.a.g.a(new aqh(aqh2));
        }

        apv1.b = b;
        return apv1;
    }

    public apw v()
        throws IOException
    {
        return d();
    }

    public void write(apv apv1, long l1)
    {
        if (apv1 == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        if (apv1 == this)
        {
            throw new IllegalArgumentException("source == this");
        }
        aqm.a(apv1.b, 0L, l1);
        do
        {
label0:
            {
label1:
                {
                    if (l1 > 0L)
                    {
                        if (l1 >= (long)(apv1.a.c - apv1.a.b))
                        {
                            break label0;
                        }
                        aqh aqh1;
                        int i1;
                        long l2;
                        if (a != null)
                        {
                            aqh1 = a.g;
                        } else
                        {
                            aqh1 = null;
                        }
                        if (aqh1 == null || !aqh1.e)
                        {
                            break label1;
                        }
                        l2 = aqh1.c;
                        if (aqh1.d)
                        {
                            i1 = 0;
                        } else
                        {
                            i1 = aqh1.b;
                        }
                        if ((l2 + l1) - (long)i1 > 2048L)
                        {
                            break label1;
                        }
                        apv1.a.a(aqh1, (int)l1);
                        apv1.b = apv1.b - l1;
                        b = b + l1;
                    }
                    return;
                }
                apv1.a = apv1.a.a((int)l1);
            }
            aqh aqh2 = apv1.a;
            long l3 = aqh2.c - aqh2.b;
            apv1.a = aqh2.a();
            if (a == null)
            {
                a = aqh2;
                aqh2 = a;
                aqh aqh3 = a;
                aqh aqh4 = a;
                aqh3.g = aqh4;
                aqh2.f = aqh4;
            } else
            {
                a.g.a(aqh2).b();
            }
            apv1.b = apv1.b - l3;
            b = b + l3;
            l1 -= l3;
        } while (true);
    }

}
