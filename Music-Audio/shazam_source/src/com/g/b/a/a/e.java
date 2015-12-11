// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.a;

import c.d;
import c.j;
import c.m;
import c.r;
import c.s;
import c.t;
import com.g.b.a.k;
import com.g.b.i;
import com.g.b.o;
import com.g.b.u;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.g.b.a.a:
//            s, j, g

public final class com.g.b.a.a.e
{
    private abstract class a
        implements s
    {

        protected final j a;
        protected boolean b;
        final com.g.b.a.a.e c;

        protected final void a(boolean flag)
        {
            if (c.e != 5)
            {
                throw new IllegalStateException((new StringBuilder("state: ")).append(c.e).toString());
            }
            com.g.b.a.a.e.a(a);
            c.e = 0;
            if (flag && c.f == 1)
            {
                c.f = 0;
                com.g.b.a.d.b.a(c.a, c.b);
            } else
            if (c.f == 2)
            {
                c.e = 6;
                c.b.c.close();
                return;
            }
        }

        protected final void b()
        {
            k.a(c.b.c);
            c.e = 6;
        }

        public final t w_()
        {
            return a;
        }

        private a()
        {
            c = com.g.b.a.a.e.this;
            super();
            a = new j(c.c.w_());
        }

        a(byte byte0)
        {
            this();
        }
    }

    private final class b
        implements r
    {

        final com.g.b.a.a.e a;
        private final j b;
        private boolean c;

        public final void a_(c.c c1, long l)
        {
            if (c)
            {
                throw new IllegalStateException("closed");
            }
            if (l == 0L)
            {
                return;
            } else
            {
                a.d.i(l);
                a.d.b("\r\n");
                a.d.a_(c1, l);
                a.d.b("\r\n");
                return;
            }
        }

        public final void close()
        {
            this;
            JVM INSTR monitorenter ;
            boolean flag = c;
            if (!flag) goto _L2; else goto _L1
_L1:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            c = true;
            a.d.b("0\r\n\r\n");
            com.g.b.a.a.e.a(b);
            a.e = 3;
            if (true) goto _L1; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        public final void flush()
        {
            this;
            JVM INSTR monitorenter ;
            boolean flag = c;
            if (!flag) goto _L2; else goto _L1
_L1:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            a.d.flush();
            if (true) goto _L1; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        public final t w_()
        {
            return b;
        }

        private b()
        {
            a = com.g.b.a.a.e.this;
            super();
            b = new j(a.d.w_());
        }

        b(byte byte0)
        {
            this();
        }
    }

    private final class c extends a
    {

        final com.g.b.a.a.e d;
        private long e;
        private boolean f;
        private final g g;

        public final long a(c.c c1, long l)
        {
            if (l < 0L)
            {
                throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
            }
            if (b)
            {
                throw new IllegalStateException("closed");
            }
            if (f) goto _L2; else goto _L1
_L1:
            return -1L;
_L2:
            if (e != 0L && e != -1L)
            {
                break; /* Loop/switch isn't completed */
            }
            if (e != -1L)
            {
                d.c.p();
            }
            try
            {
                e = d.c.m();
                String s1 = d.c.p().trim();
                if (e < 0L || !s1.isEmpty() && !s1.startsWith(";"))
                {
                    throw new ProtocolException((new StringBuilder("expected chunk size and optional extensions but was \"")).append(e).append(s1).append("\"").toString());
                }
            }
            // Misplaced declaration of an exception variable
            catch (c.c c1)
            {
                throw new ProtocolException(c1.getMessage());
            }
            if (e == 0L)
            {
                f = false;
                com.g.b.o.a a1 = new com.g.b.o.a();
                d.a(a1);
                g.a(a1.a());
                a(true);
            }
            if (!f) goto _L1; else goto _L3
_L3:
            l = d.c.a(c1, Math.min(l, e));
            if (l == -1L)
            {
                b();
                throw new IOException("unexpected end of stream");
            } else
            {
                e = e - l;
                return l;
            }
        }

        public final void close()
        {
            if (b)
            {
                return;
            }
            if (f && !k.a(this, TimeUnit.MILLISECONDS))
            {
                b();
            }
            b = true;
        }

        c(g g1)
        {
            d = com.g.b.a.a.e.this;
            super((byte)0);
            e = -1L;
            f = true;
            g = g1;
        }
    }

    private final class d
        implements r
    {

        final com.g.b.a.a.e a;
        private final j b;
        private boolean c;
        private long d;

        public final void a_(c.c c1, long l)
        {
            if (c)
            {
                throw new IllegalStateException("closed");
            }
            k.a(c1.b, l);
            if (l > d)
            {
                throw new ProtocolException((new StringBuilder("expected ")).append(d).append(" bytes but received ").append(l).toString());
            } else
            {
                a.d.a_(c1, l);
                d = d - l;
                return;
            }
        }

        public final void close()
        {
            if (c)
            {
                return;
            }
            c = true;
            if (d > 0L)
            {
                throw new ProtocolException("unexpected end of stream");
            } else
            {
                com.g.b.a.a.e.a(b);
                a.e = 3;
                return;
            }
        }

        public final void flush()
        {
            if (c)
            {
                return;
            } else
            {
                a.d.flush();
                return;
            }
        }

        public final t w_()
        {
            return b;
        }

        private d(long l)
        {
            a = com.g.b.a.a.e.this;
            super();
            b = new j(a.d.w_());
            d = l;
        }

        d(long l, byte byte0)
        {
            this(l);
        }
    }

    private final class e extends a
    {

        final com.g.b.a.a.e d;
        private long e;

        public final long a(c.c c1, long l)
        {
            if (l < 0L)
            {
                throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
            }
            if (b)
            {
                throw new IllegalStateException("closed");
            }
            if (e == 0L)
            {
                return -1L;
            }
            l = d.c.a(c1, Math.min(e, l));
            if (l == -1L)
            {
                b();
                throw new ProtocolException("unexpected end of stream");
            }
            e = e - l;
            if (e == 0L)
            {
                a(true);
            }
            return l;
        }

        public final void close()
        {
            if (b)
            {
                return;
            }
            if (e != 0L && !k.a(this, TimeUnit.MILLISECONDS))
            {
                b();
            }
            b = true;
        }

        public e(long l)
        {
            d = com.g.b.a.a.e.this;
            super((byte)0);
            e = l;
            if (e == 0L)
            {
                a(true);
            }
        }
    }

    private final class f extends a
    {

        final com.g.b.a.a.e d;
        private boolean e;

        public final long a(c.c c1, long l)
        {
            if (l < 0L)
            {
                throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
            }
            if (b)
            {
                throw new IllegalStateException("closed");
            }
            if (e)
            {
                return -1L;
            }
            l = d.c.a(c1, l);
            if (l == -1L)
            {
                e = true;
                a(false);
                return -1L;
            } else
            {
                return l;
            }
        }

        public final void close()
        {
            if (b)
            {
                return;
            }
            if (!e)
            {
                b();
            }
            b = true;
        }

        private f()
        {
            d = com.g.b.a.a.e.this;
            super((byte)0);
        }

        f(byte byte0)
        {
            this();
        }
    }


    final com.g.b.j a;
    final i b;
    final c.e c;
    final c.d d;
    int e;
    int f;
    private final Socket g;

    public com.g.b.a.a.e(com.g.b.j j1, i i, Socket socket)
    {
        e = 0;
        f = 0;
        a = j1;
        b = i;
        g = socket;
        c = m.a(m.b(socket));
        d = m.a(m.a(socket));
    }

    static void a(j j1)
    {
        t t1 = j1.a;
        t t2 = t.b;
        if (t2 == null)
        {
            throw new IllegalArgumentException("delegate == null");
        } else
        {
            j1.a = t2;
            t1.B_();
            t1.d();
            return;
        }
    }

    public final s a(long l)
    {
        if (e != 4)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(e).toString());
        } else
        {
            e = 5;
            return new e(l);
        }
    }

    public final void a()
    {
        d.flush();
    }

    public final void a(int i, int k)
    {
        if (i != 0)
        {
            c.w_().a(i, TimeUnit.MILLISECONDS);
        }
        if (k != 0)
        {
            d.w_().a(k, TimeUnit.MILLISECONDS);
        }
    }

    public final void a(com.g.b.o.a a1)
    {
        do
        {
            String s1 = c.p();
            if (s1.length() != 0)
            {
                com.g.b.a.d.b.a(a1, s1);
            } else
            {
                return;
            }
        } while (true);
    }

    public final void a(o o1, String s1)
    {
        if (e != 0)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(e).toString());
        }
        d.b(s1).b("\r\n");
        int i = 0;
        for (int k = o1.a.length / 2; i < k; i++)
        {
            d.b(o1.a(i)).b(": ").b(o1.b(i)).b("\r\n");
        }

        d.b("\r\n");
        e = 1;
    }

    public final boolean b()
    {
        Exception exception;
        int i;
        boolean flag;
        try
        {
            i = g.getSoTimeout();
        }
        catch (SocketTimeoutException sockettimeoutexception)
        {
            return true;
        }
        catch (IOException ioexception)
        {
            return false;
        }
        g.setSoTimeout(1);
        flag = c.e();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        g.setSoTimeout(i);
        return false;
        g.setSoTimeout(i);
        return true;
        exception;
        g.setSoTimeout(i);
        throw exception;
    }

    public final com.g.b.x.a c()
    {
        if (e != 1 && e != 3)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(e).toString());
        }
        com.g.b.x.a a1;
        try
        {
            com.g.b.a.a.s s1;
            do
            {
                s1 = s.a(c.p());
                a1 = new com.g.b.x.a();
                a1.b = s1.a;
                a1.c = s1.b;
                a1.d = s1.c;
                com.g.b.o.a a2 = new com.g.b.o.a();
                a(a2);
                a2.a(com.g.b.a.a.j.d, s1.a.toString());
                a1.a(a2.a());
            } while (s1.b == 100);
            e = 4;
        }
        catch (EOFException eofexception)
        {
            IOException ioexception = new IOException((new StringBuilder("unexpected end of stream on ")).append(b).append(" (recycle count=").append(com.g.b.a.d.b.b(b)).append(")").toString());
            ioexception.initCause(eofexception);
            throw ioexception;
        }
        return a1;
    }
}
