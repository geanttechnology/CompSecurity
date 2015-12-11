// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package android.support.v7:
//            apx, apv, aqk, aqj, 
//            apy, aql, aqm

final class aqg
    implements apx
{

    public final apv a;
    public final aqk b;
    private boolean c;

    public aqg(aqk aqk1)
    {
        this(aqk1, new apv());
    }

    public aqg(aqk aqk1, apv apv1)
    {
        if (aqk1 == null)
        {
            throw new IllegalArgumentException("source == null");
        } else
        {
            a = apv1;
            b = aqk1;
            return;
        }
    }

    static boolean a(aqg aqg1)
    {
        return aqg1.c;
    }

    public long a(byte byte0)
        throws IOException
    {
        return a(byte0, 0L);
    }

    public long a(byte byte0, long l1)
        throws IOException
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        }
        do
        {
            long l2 = l1;
            if (l1 >= a.b)
            {
                if (b.read(a, 2048L) == -1L)
                {
                    return -1L;
                }
            } else
            {
                do
                {
                    l1 = a.a(byte0, l2);
                    if (l1 == -1L)
                    {
                        l2 = a.b;
                        if (b.read(a, 2048L) == -1L)
                        {
                            return -1L;
                        }
                    } else
                    {
                        return l1;
                    }
                } while (true);
            }
        } while (true);
    }

    public long a(aqj aqj1)
        throws IOException
    {
        if (aqj1 == null)
        {
            throw new IllegalArgumentException("sink == null");
        }
        long l1 = 0L;
        do
        {
            if (b.read(a, 2048L) == -1L)
            {
                break;
            }
            long l2 = a.h();
            if (l2 > 0L)
            {
                l1 += l2;
                aqj1.write(a, l2);
            }
        } while (true);
        long l3 = l1;
        if (a.a() > 0L)
        {
            l3 = l1 + a.a();
            aqj1.write(a, a.a());
        }
        return l3;
    }

    public void a(long l1)
        throws IOException
    {
        if (!b(l1))
        {
            throw new EOFException();
        } else
        {
            return;
        }
    }

    public apv b()
    {
        return a;
    }

    public boolean b(long l1)
        throws IOException
    {
        if (l1 < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("byteCount < 0: ").append(l1).toString());
        }
        if (c)
        {
            throw new IllegalStateException("closed");
        }
        while (a.b < l1) 
        {
            if (b.read(a, 2048L) == -1L)
            {
                return false;
            }
        }
        return true;
    }

    public apy c(long l1)
        throws IOException
    {
        a(l1);
        return a.c(l1);
    }

    public void close()
        throws IOException
    {
        if (c)
        {
            return;
        } else
        {
            c = true;
            b.close();
            a.t();
            return;
        }
    }

    public boolean f()
        throws IOException
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        }
        return a.f() && b.read(a, 2048L) == -1L;
    }

    public byte[] f(long l1)
        throws IOException
    {
        a(l1);
        return a.f(l1);
    }

    public InputStream g()
    {
        return new InputStream() {

            final aqg a;

            public int available()
                throws IOException
            {
                if (aqg.a(a))
                {
                    throw new IOException("closed");
                } else
                {
                    return (int)Math.min(a.a.b, 0x7fffffffL);
                }
            }

            public void close()
                throws IOException
            {
                a.close();
            }

            public int read()
                throws IOException
            {
                if (aqg.a(a))
                {
                    throw new IOException("closed");
                }
                if (a.a.b == 0L && a.b.read(a.a, 2048L) == -1L)
                {
                    return -1;
                } else
                {
                    return a.a.i() & 0xff;
                }
            }

            public int read(byte abyte0[], int i1, int j1)
                throws IOException
            {
                if (aqg.a(a))
                {
                    throw new IOException("closed");
                }
                aqm.a(abyte0.length, i1, j1);
                if (a.a.b == 0L && a.b.read(a.a, 2048L) == -1L)
                {
                    return -1;
                } else
                {
                    return a.a.a(abyte0, i1, j1);
                }
            }

            public String toString()
            {
                return (new StringBuilder()).append(a).append(".inputStream()").toString();
            }

            
            {
                a = aqg.this;
                super();
            }
        };
    }

    public void g(long l1)
        throws IOException
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        }
_L3:
        if (l1 > 0L)
        {
            if (a.b == 0L && b.read(a, 2048L) == -1L)
            {
                throw new EOFException();
            }
        } else
        {
            return;
        }
        if (true) goto _L2; else goto _L1
_L2:
        long l2 = Math.min(l1, a.a());
        a.g(l2);
        l1 -= l2;
        if (true) goto _L3; else goto _L1
_L1:
    }

    public byte i()
        throws IOException
    {
        a(1L);
        return a.i();
    }

    public short j()
        throws IOException
    {
        a(2L);
        return a.j();
    }

    public int k()
        throws IOException
    {
        a(4L);
        return a.k();
    }

    public short l()
        throws IOException
    {
        a(2L);
        return a.l();
    }

    public int m()
        throws IOException
    {
        a(4L);
        return a.m();
    }

    public long n()
        throws IOException
    {
        int i1 = 0;
_L5:
        if (b(i1 + 1)) goto _L2; else goto _L1
_L1:
        byte byte0;
        if (i1 == 0)
        {
            throw new NumberFormatException((new StringBuilder()).append("Expected leading [0-9] or '-' character but was 0x").append(Integer.toHexString(a.b(0L))).toString());
        } else
        {
            return a.n();
        }
_L2:
        if (((byte0 = a.b(i1)) < 48 || byte0 > 57) && (i1 != 0 || byte0 != 45)) goto _L1; else goto _L3
_L3:
        i1++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public long o()
        throws IOException
    {
        int i1 = 0;
_L5:
        if (b(i1 + 1)) goto _L2; else goto _L1
_L1:
        byte byte0;
        if (i1 == 0)
        {
            throw new NumberFormatException((new StringBuilder()).append("Expected leading [0-9a-fA-F] character but was 0x").append(Integer.toHexString(a.b(0L))).toString());
        } else
        {
            return a.o();
        }
_L2:
        if (((byte0 = a.b(i1)) < 48 || byte0 > 57) && (byte0 < 97 || byte0 > 102) && (byte0 < 65 || byte0 > 70)) goto _L1; else goto _L3
_L3:
        i1++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public String r()
        throws IOException
    {
        long l1 = a((byte)10);
        if (l1 == -1L)
        {
            apv apv1 = new apv();
            a.a(apv1, 0L, Math.min(32L, a.a()));
            throw new EOFException((new StringBuilder()).append("\\n not found: size=").append(a.a()).append(" content=").append(apv1.p().d()).append("...").toString());
        } else
        {
            return a.e(l1);
        }
    }

    public long read(apv apv1, long l1)
        throws IOException
    {
        if (apv1 == null)
        {
            throw new IllegalArgumentException("sink == null");
        }
        if (l1 < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("byteCount < 0: ").append(l1).toString());
        }
        if (c)
        {
            throw new IllegalStateException("closed");
        }
        if (a.b == 0L && b.read(a, 2048L) == -1L)
        {
            return -1L;
        } else
        {
            l1 = Math.min(l1, a.b);
            return a.read(apv1, l1);
        }
    }

    public byte[] s()
        throws IOException
    {
        a.a(b);
        return a.s();
    }

    public aql timeout()
    {
        return b.timeout();
    }

    public String toString()
    {
        return (new StringBuilder()).append("buffer(").append(b).append(")").toString();
    }
}
