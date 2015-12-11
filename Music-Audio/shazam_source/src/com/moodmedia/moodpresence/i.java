// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.moodmedia.moodpresence;

import java.util.concurrent.ArrayBlockingQueue;

// Referenced classes of package com.moodmedia.moodpresence:
//            c, f, e, j, 
//            k, h

class i
{
    static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        private static final a d[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/moodmedia/moodpresence/i$a, s);
        }

        public static a[] values()
        {
            a aa[] = d;
            int i1 = aa.length;
            a aa1[] = new a[i1];
            System.arraycopy(aa, 0, aa1, 0, i1);
            return aa1;
        }

        static 
        {
            a = new a("IDLE", 0);
            b = new a("READY", 1);
            c = new a("LISTENING", 2);
            d = (new a[] {
                a, b, c
            });
        }

        private a(String s, int i1)
        {
            super(s, i1);
        }
    }


    private a a;
    private h b;
    private Boolean c;
    private Integer d;
    private Integer e;
    private ArrayBlockingQueue f;
    private ArrayBlockingQueue g;
    private ArrayBlockingQueue h;
    private Thread i;
    private Thread j;
    private Thread k;
    private Thread l;
    private c m[];
    private int n;

    i(h h1, Boolean boolean1, Integer integer)
    {
        int i1 = 0;
        super();
        m = new c[64];
        n = 0;
        if (integer.intValue() != 44100 && integer.intValue() != 48000)
        {
            throw new IllegalArgumentException("Only 44100 and 48000 Hz sample rates are supported in this version");
        }
        b = h1;
        c = boolean1;
        d = integer;
        if (integer.intValue() == 44100)
        {
            e = Integer.valueOf(2048);
        } else
        if (integer.intValue() == 48000)
        {
            e = Integer.valueOf(2229);
        }
        f = new ArrayBlockingQueue(64);
        g = new ArrayBlockingQueue(64);
        h = new ArrayBlockingQueue(64);
        do
        {
            if (i1 >= 64)
            {
                a = a.a;
                return;
            }
            m[i1] = new c(e.intValue());
            i1++;
        } while (true);
    }

    private void c(short aword0[])
    {
        if (aword0.length != e.intValue())
        {
            throw new IllegalArgumentException((new StringBuilder("Incorrect buffer length (expected ")).append(e).append(")").toString());
        }
        c c1 = m[n % 64];
        c1.a(n);
        c1.a(aword0);
        n = n + 1;
        try
        {
            f.add(c1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (short aword0[])
        {
            return;
        }
    }

    Integer a()
    {
        return e;
    }

    void a(int i1)
    {
    }

    void a(short aword0[])
    {
        this;
        JVM INSTR monitorenter ;
        if (a != a.b)
        {
            throw new IllegalStateException("Detector instance is not ready");
        }
        break MISSING_BLOCK_LABEL_27;
        aword0;
        this;
        JVM INSTR monitorexit ;
        throw aword0;
        c(aword0);
        this;
        JVM INSTR monitorexit ;
    }

    a b()
    {
        return a;
    }

    void b(short aword0[])
    {
        if (a != a.c)
        {
            throw new IllegalStateException("Detector instance is not listening");
        } else
        {
            c(aword0);
            return;
        }
    }

    void c()
    {
        this;
        JVM INSTR monitorenter ;
        j = new Thread(new f(f, g, d.intValue()));
        j.setName("Demodulator");
        j.start();
        k = new Thread(new e(g, h, c.booleanValue()));
        k.setName("Decoder");
        k.start();
        l = new Thread(new j(h, b));
        l.setName("HitCounter");
        l.start();
        a = a.b;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    void d()
    {
        this;
        JVM INSTR monitorenter ;
        if (l != null)
        {
            l.interrupt();
        }
        if (k != null)
        {
            k.interrupt();
        }
        if (j != null)
        {
            j.interrupt();
        }
        if (l != null)
        {
            l.join();
        }
        if (k != null)
        {
            k.join();
        }
        if (j != null)
        {
            j.join();
        }
_L1:
        l = null;
        k = null;
        j = null;
        a = a.a;
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        Thread.currentThread().interrupt();
          goto _L1
        obj;
        throw obj;
    }

    void e()
    {
        this;
        JVM INSTR monitorenter ;
        f.clear();
        g.clear();
        h.clear();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    void f()
    {
        this;
        JVM INSTR monitorenter ;
        d();
        e();
        c();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    void g()
    {
        this;
        JVM INSTR monitorenter ;
        if (a != a.a)
        {
            throw new IllegalStateException("Detector instance already in use");
        }
        break MISSING_BLOCK_LABEL_27;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        c();
        i = new Thread(new k(this));
        i.setName("Recorder");
        i.setPriority(10);
        i.start();
        a = a.c;
        this;
        JVM INSTR monitorexit ;
    }

    void h()
    {
        this;
        JVM INSTR monitorenter ;
        if (a != a.c)
        {
            throw new IllegalStateException("Detector instance is not listening");
        }
        break MISSING_BLOCK_LABEL_27;
        Object obj;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        if (i != null)
        {
            i.interrupt();
        }
        if (i != null)
        {
            i.join();
        }
_L1:
        d();
        e();
        a = a.a;
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        Thread.currentThread().interrupt();
          goto _L1
    }
}
