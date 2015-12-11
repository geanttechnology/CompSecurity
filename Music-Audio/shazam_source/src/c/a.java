// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c;

import java.io.IOException;
import java.io.InterruptedIOException;

// Referenced classes of package c:
//            t, r, c, s

public class c.a extends t
{
    private static final class a extends Thread
    {

        public final void run()
        {
            do
            {
                c.a a1;
                do
                {
                    a1 = c.a.e();
                } while (a1 == null);
                try
                {
                    a1.a();
                }
                catch (InterruptedException interruptedexception) { }
            } while (true);
        }

        public a()
        {
            super("Okio Watchdog");
            setDaemon(true);
        }
    }


    private static c.a a;
    private boolean c;
    private c.a d;
    private long e;

    public c.a()
    {
    }

    private static void a(c.a a1, long l, boolean flag)
    {
        c/a;
        JVM INSTR monitorenter ;
        long l1;
        if (a == null)
        {
            a = new c.a();
            (new a()).start();
        }
        l1 = System.nanoTime();
        if (l == 0L || !flag) goto _L2; else goto _L1
_L1:
        a1.e = Math.min(l, a1.c() - l1) + l1;
_L3:
        l = a1.e;
        for (c.a a2 = a; a2.d != null && l - l1 >= a2.d.e - l1; a2 = a2.d)
        {
            break MISSING_BLOCK_LABEL_177;
        }

        a1.d = a2.d;
        a2.d = a1;
        if (a2 == a)
        {
            c/a.notify();
        }
        c/a;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (l == 0L)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        a1.e = l1 + l;
          goto _L3
        a1;
        throw a1;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        a1.e = a1.c();
          goto _L3
        throw new AssertionError();
    }

    private static boolean a(c.a a1)
    {
        c/a;
        JVM INSTR monitorenter ;
        c.a a2 = a;
_L8:
        if (a2 == null) goto _L2; else goto _L1
_L1:
        if (a2.d != a1) goto _L4; else goto _L3
_L3:
        a2.d = a1.d;
        a1.d = null;
        boolean flag = false;
_L6:
        c/a;
        JVM INSTR monitorexit ;
        return flag;
_L4:
        a2 = a2.d;
        continue; /* Loop/switch isn't completed */
_L2:
        flag = true;
        if (true) goto _L6; else goto _L5
_L5:
        a1;
        throw a1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    static c.a e()
    {
        return g();
    }

    private static c.a g()
    {
        Object obj = null;
        c/a;
        JVM INSTR monitorenter ;
        c.a a1 = a.d;
        if (a1 != null) goto _L2; else goto _L1
_L1:
        c/a.wait();
_L4:
        c/a;
        JVM INSTR monitorexit ;
        return ((c.a) (obj));
_L2:
        long l;
        l = System.nanoTime();
        l = a1.e - l;
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        long l1 = l / 0xf4240L;
        c/a.wait(l1, (int)(l - 0xf4240L * l1));
        continue; /* Loop/switch isn't completed */
        obj;
        throw obj;
        a.d = a1.d;
        a1.d = null;
        obj = a1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    final IOException a(IOException ioexception)
    {
        if (!y_())
        {
            return ioexception;
        } else
        {
            InterruptedIOException interruptedioexception = new InterruptedIOException("timeout");
            interruptedioexception.initCause(ioexception);
            return interruptedioexception;
        }
    }

    public void a()
    {
    }

    final void a(boolean flag)
    {
        if (y_() && flag)
        {
            throw new InterruptedIOException("timeout");
        } else
        {
            return;
        }
    }

    public final void x_()
    {
        if (c)
        {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long l = z_();
        boolean flag = A_();
        if (l == 0L && !flag)
        {
            return;
        } else
        {
            c = true;
            a(this, l, flag);
            return;
        }
    }

    public final boolean y_()
    {
        if (!c)
        {
            return false;
        } else
        {
            c = false;
            return a(this);
        }
    }

    // Unreferenced inner class c/a$1

/* anonymous class */
    final class _cls1
        implements r
    {

        final r a;
        final c.a b;

        public final void a_(c c1, long l)
        {
            b.x_();
            a.a_(c1, l);
            b.a(true);
            return;
            c1;
            throw b.a(c1);
            c1;
            b.a(false);
            throw c1;
        }

        public final void close()
        {
            b.x_();
            a.close();
            b.a(true);
            return;
            Object obj;
            obj;
            throw b.a(((IOException) (obj)));
            obj;
            b.a(false);
            throw obj;
        }

        public final void flush()
        {
            b.x_();
            a.flush();
            b.a(true);
            return;
            Object obj;
            obj;
            throw b.a(((IOException) (obj)));
            obj;
            b.a(false);
            throw obj;
        }

        public final String toString()
        {
            return (new StringBuilder("AsyncTimeout.sink(")).append(a).append(")").toString();
        }

        public final t w_()
        {
            return b;
        }

            
            {
                b = c.a.this;
                a = r1;
                super();
            }
    }


    // Unreferenced inner class c/a$2

/* anonymous class */
    final class _cls2
        implements s
    {

        final s a;
        final c.a b;

        public final long a(c c1, long l)
        {
            b.x_();
            l = a.a(c1, l);
            b.a(true);
            return l;
            c1;
            throw b.a(c1);
            c1;
            b.a(false);
            throw c1;
        }

        public final void close()
        {
            a.close();
            b.a(true);
            return;
            Object obj;
            obj;
            throw b.a(((IOException) (obj)));
            obj;
            b.a(false);
            throw obj;
        }

        public final String toString()
        {
            return (new StringBuilder("AsyncTimeout.source(")).append(a).append(")").toString();
        }

        public final t w_()
        {
            return b;
        }

            
            {
                b = c.a.this;
                a = s1;
                super();
            }
    }

}
