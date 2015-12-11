// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package android.support.v7:
//            apw, apv, aqk, aqj, 
//            aqm, apy, aql

final class aqf
    implements apw
{

    public final apv a;
    public final aqj b;
    private boolean c;

    public aqf(aqj aqj1)
    {
        this(aqj1, new apv());
    }

    public aqf(aqj aqj1, apv apv1)
    {
        if (aqj1 == null)
        {
            throw new IllegalArgumentException("sink == null");
        } else
        {
            a = apv1;
            b = aqj1;
            return;
        }
    }

    static boolean a(aqf aqf1)
    {
        return aqf1.c;
    }

    public long a(aqk aqk1)
        throws IOException
    {
        if (aqk1 == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        long l = 0L;
        do
        {
            long l1 = aqk1.read(a, 2048L);
            if (l1 != -1L)
            {
                l += l1;
                v();
            } else
            {
                return l;
            }
        } while (true);
    }

    public apv b()
    {
        return a;
    }

    public apw b(apy apy)
        throws IOException
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.a(apy);
            return v();
        }
    }

    public apw b(String s)
        throws IOException
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.a(s);
            return v();
        }
    }

    public apw c(byte abyte0[])
        throws IOException
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.b(abyte0);
            return v();
        }
    }

    public apw c(byte abyte0[], int i, int l)
        throws IOException
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.b(abyte0, i, l);
            return v();
        }
    }

    public OutputStream c()
    {
        return new OutputStream() {

            final aqf a;

            public void close()
                throws IOException
            {
                a.close();
            }

            public void flush()
                throws IOException
            {
                if (!aqf.a(a))
                {
                    a.flush();
                }
            }

            public String toString()
            {
                return (new StringBuilder()).append(a).append(".outputStream()").toString();
            }

            public void write(int i)
                throws IOException
            {
                if (aqf.a(a))
                {
                    throw new IOException("closed");
                } else
                {
                    a.a.a((byte)i);
                    a.v();
                    return;
                }
            }

            public void write(byte abyte0[], int i, int l)
                throws IOException
            {
                if (aqf.a(a))
                {
                    throw new IOException("closed");
                } else
                {
                    a.a.b(abyte0, i, l);
                    a.v();
                    return;
                }
            }

            
            {
                a = aqf.this;
                super();
            }
        };
    }

    public void close()
        throws IOException
    {
        if (!c) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Throwable throwable;
        Throwable throwable1;
        throwable1 = null;
        throwable = throwable1;
        if (a.b <= 0L)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        b.write(a, a.b);
        throwable = throwable1;
_L4:
        b.close();
        throwable1 = throwable;
_L3:
        c = true;
        if (throwable1 != null)
        {
            aqm.a(throwable1);
            return;
        }
          goto _L1
        Throwable throwable2;
        throwable2;
        throwable1 = throwable;
        if (throwable == null)
        {
            throwable1 = throwable2;
        }
          goto _L3
        throwable;
          goto _L4
    }

    public apw e()
        throws IOException
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        }
        long l = a.a();
        if (l > 0L)
        {
            b.write(a, l);
        }
        return this;
    }

    public apw e(int i)
        throws IOException
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.c(i);
            return v();
        }
    }

    public apw f(int i)
        throws IOException
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.b(i);
            return v();
        }
    }

    public void flush()
        throws IOException
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        }
        if (a.b > 0L)
        {
            b.write(a, a.b);
        }
        b.flush();
    }

    public apw g(int i)
        throws IOException
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.a(i);
            return v();
        }
    }

    public apw j(long l)
        throws IOException
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.i(l);
            return v();
        }
    }

    public apw k(long l)
        throws IOException
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.h(l);
            return v();
        }
    }

    public aql timeout()
    {
        return b.timeout();
    }

    public String toString()
    {
        return (new StringBuilder()).append("buffer(").append(b).append(")").toString();
    }

    public apw v()
        throws IOException
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        }
        long l = a.h();
        if (l > 0L)
        {
            b.write(a, l);
        }
        return this;
    }

    public void write(apv apv1, long l)
        throws IOException
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.write(apv1, l);
            v();
            return;
        }
    }
}
