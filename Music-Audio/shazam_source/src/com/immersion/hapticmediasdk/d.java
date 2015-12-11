// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import com.immersion.hapticmediasdk.a.c;
import com.immersion.hapticmediasdk.a.f;
import java.util.concurrent.atomic.AtomicInteger;

public final class d
    implements Runnable
{
    public static final class a
    {

        public static final int a[];
        public static int b = 88;
        public static int c = 1;
        public static int d = 2;

        static 
        {
            a = new int[com.immersion.hapticmediasdk.a.a.values().length];
            NoSuchFieldError nosuchfielderror;
            int i1;
            try
            {
                a[a.a.a.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                a[a.a.b.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                a[com.immersion.hapticmediasdk.a.a.c.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            a[com.immersion.hapticmediasdk.a.a.f.ordinal()] = 4;
            i1 = b;
            switch ((i1 * (c + i1)) % d)
            {
            default:
                b = 57;
                c = 26;
                break;

            case 0: // '\0'
                break;
            }
_L2:
            try
            {
                a[a.a.g.ordinal()] = 5;
            }
            // Misplaced declaration of an exception variable
            catch (NoSuchFieldError nosuchfielderror) { }
            try
            {
                a[a.a.h.ordinal()] = 6;
            }
            // Misplaced declaration of an exception variable
            catch (NoSuchFieldError nosuchfielderror) { }
            try
            {
                a[a.a.d.ordinal()] = 7;
                return;
            }
            // Misplaced declaration of an exception variable
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
            nosuchfielderror;
            if (true) goto _L2; else goto _L1
_L1:
        }
    }


    public static int e = 37;
    public static int f = 1;
    public static int g = 2;
    public static int h;
    final Object a;
    long b;
    volatile a.a c;
    f d;
    private final Object i;
    private long j;
    private Handler k;
    private String l;
    private boolean m;
    private Context n;
    private com.immersion.hapticmediasdk.b.d o;

    public d(Handler handler, Context context, com.immersion.hapticmediasdk.b.d d1)
    {
        if (((e + f) * e) % g != 0)
        {
            e = 47;
            f = 54;
        }
        a.a a1;
        try
        {
            super();
            i = new Object();
        }
        // Misplaced declaration of an exception variable
        catch (Handler handler)
        {
            throw handler;
        }
        try
        {
            a = new Object();
            a1 = a.a.a;
        }
        // Misplaced declaration of an exception variable
        catch (Handler handler)
        {
            throw handler;
        }
        c = a1;
        k = handler;
        n = context;
        o = d1;
        return;
    }

    private int b(a.a a1)
    {
        int i1 = e;
        switch ((i1 * (f + i1)) % g)
        {
        default:
            e = 19;
            f = 54;
            break;

        case 0: // '\0'
            break;
        }
        Object obj;
        String s;
        try
        {
            obj = k;
        }
        // Misplaced declaration of an exception variable
        catch (a.a a1)
        {
            throw a1;
        }
        try
        {
            ((Handler) (obj)).removeCallbacks(this);
            c = a1;
            if (l == null)
            {
                break MISSING_BLOCK_LABEL_220;
            }
            d = new f(k.getLooper(), this);
            a1 = d;
            if (((f.g + f.i) * f.g) % f.j != f.h)
            {
                f.g = 97;
                f.h = 45;
            }
            a1 = ((f) (a1)).c;
            obj = n;
            s = l;
        }
        // Misplaced declaration of an exception variable
        catch (a.a a1)
        {
            throw a1;
        }
        a1 = new c(((Context) (obj)), s, a1, m, o);
        obj = d;
        obj.d = a1;
        ((f) (obj)).d.start();
        if (((f.g + f.i) * f.g) % f.j != f.h)
        {
            f.g = 5;
            f.h = 24;
        }
        ((f) (obj)).a(true);
        return 0;
        a1;
        throw a1;
        a1;
        throw a1;
        return -4;
    }

    private int d()
    {
        Handler handler;
        Object obj;
        c c1;
        k.removeCallbacks(this);
        if (d == null)
        {
            break MISSING_BLOCK_LABEL_182;
        }
        e();
        obj = d;
        handler = k;
        if (((f) (obj)).d == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        c1 = ((f) (obj)).d;
        boolean flag = c1.a.sendEmptyMessage(9);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        Exception exception;
        int i1;
        try
        {
            if (((c.i + 1) * c.i) % c.k != c.l)
            {
                c.i = 41;
                c.l = 16;
            }
        }
        catch (Exception exception1)
        {
            throw exception1;
        }
        c1.g = false;
        c1.e();
        ((f) (obj)).a(false);
        obj.d = null;
        obj = ((f) (obj)).e;
        if (((f.g + f.i) * f.g) % f.j != f.h)
        {
            f.g = 5;
            f.h = 29;
        }
        handler.removeCallbacks(((Runnable) (obj)));
        if (((e + f) * e) % g != h)
        {
            e = 80;
            h = 44;
        }
        d = null;
        Exception exception2;
        try
        {
            l = null;
            j = 0L;
            c = a.a.a;
        }
        catch (Exception exception3)
        {
            throw exception3;
        }
        i1 = e;
        switch ((i1 * (i1 + 1)) % g)
        {
        default:
            e = 54;
            f = 55;
            // fall through

        case 0: // '\0'
            return 0;
        }
        exception;
        throw exception;
        exception2;
        throw exception2;
    }

    private int e()
    {
        f f1;
        Exception exception;
        c c1;
        int i1;
        try
        {
            k.removeCallbacks(this);
            j = 0L;
        }
        catch (Exception exception2)
        {
            throw exception2;
        }
        if (((e + f) * e) % g != h)
        {
            e = 54;
            h = 54;
        }
        try
        {
            f1 = d;
            f1.a.set(0);
            c1 = f1.d;
        }
        catch (Exception exception1)
        {
            throw exception1;
        }
        c1.a.sendEmptyMessage(4);
        i1 = c.i;
        (i1 * (c.j + i1)) % c.k;
        JVM INSTR tableswitch 0 0: default 179
    //                   0 114;
           goto _L1 _L2
_L1:
        c.i = 35;
        c.l = 24;
_L2:
        c1 = f1.d;
        if (((f.g + f.i) * f.g) % f.j != f.h)
        {
            f.g = 48;
            f.h = 63;
        }
        c1.c().removeCallbacks(f1.f);
        c = a.a.d;
        return 0;
        exception;
        throw exception;
    }

    private int f()
    {
        try
        {
            k.removeCallbacks(this);
        }
        catch (Exception exception)
        {
            throw exception;
        }
        try
        {
            d.a();
        }
        catch (Exception exception1)
        {
            throw exception1;
        }
        do
        {
        } while (true);
    }

    private int g()
    {
        k.removeCallbacks(this);
        if (k.postDelayed(this, 1500L))
        {
            if (((f + 54) * 54) % g != h)
            {
                e = 70;
                h = 50;
            }
            return 0;
        } else
        {
            return -1;
        }
    }

    private int h()
    {
        try
        {
            d.a();
        }
        catch (Exception exception)
        {
            throw exception;
        }
        if (((e + f) * e) % g != 0)
        {
            e = 64;
            h = 32;
        }
        c = a.a.g;
        return 0;
    }

    private int i()
    {
        try
        {
            d.a();
            c = a.a.h;
        }
        catch (Exception exception)
        {
            throw exception;
        }
        if (((e + f) * e) % g == h)
        {
            return 0;
        } else
        {
            e = 29;
            h = 54;
            return 0;
        }
    }

    private int j()
    {
        if (((e + f) * e) % g != h)
        {
            e = 78;
            h = 14;
        }
        k.removeCallbacks(this);
        d.e();
        c = com.immersion.hapticmediasdk.a.a.c;
        Handler handler = k;
        int i1 = e;
        switch ((i1 * (f + i1)) % g)
        {
        default:
            e = 54;
            h = 68;
            // fall through

        case 0: // '\0'
            handler.postDelayed(this, 1500L);
            break;
        }
        return g();
    }

    public final int a(a.a a1)
    {
        int i1;
label0:
        {
            i1 = -1;
            synchronized (i)
            {
                if (a1 != a.a.a)
                {
                    break label0;
                }
                i1 = d();
            }
            return i1;
        }
        a.a[c.ordinal()];
        JVM INSTR tableswitch 1 7: default 576
    //                   1 90
    //                   2 107
    //                   3 213
    //                   4 261
    //                   5 373
    //                   6 409
    //                   7 478;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        obj;
        JVM INSTR monitorexit ;
        return i1;
        a1;
        obj;
        JVM INSTR monitorexit ;
        throw a1;
_L2:
        if (a1 != a.a.b) goto _L1; else goto _L9
_L9:
        i1 = b(a1);
          goto _L1
_L3:
        if (a1 != com.immersion.hapticmediasdk.a.a.c) goto _L11; else goto _L10
_L10:
        i1 = j();
          goto _L1
_L29:
        if (a1 != a.a.e) goto _L1; else goto _L12
_L12:
        i1 = e();
        c = a.a.e;
          goto _L1
_L36:
        if (a1 != com.immersion.hapticmediasdk.a.a.c) goto _L14; else goto _L13
_L13:
        d.a((int)j);
        i1 = j();
          goto _L1
_L11:
        if (a1 != a.a.d) goto _L16; else goto _L15
_L15:
        i1 = e();
          goto _L1
_L16:
        if (a1 != a.a.e) goto _L1; else goto _L17
_L17:
        i1 = e();
        c = a.a.e;
          goto _L1
_L4:
        if (a1 != com.immersion.hapticmediasdk.a.a.c) goto _L19; else goto _L18
_L18:
        i1 = g();
          goto _L1
_L19:
        if (a1 != com.immersion.hapticmediasdk.a.a.f) goto _L21; else goto _L20
_L20:
        i1 = f();
          goto _L1
_L21:
        if (a1 != a.a.g) goto _L23; else goto _L22
_L22:
        i1 = h();
          goto _L1
_L5:
        if (a1 != com.immersion.hapticmediasdk.a.a.c) goto _L25; else goto _L24
_L24:
        d.a((int)j);
        i1 = j();
          goto _L1
_L25:
        if (a1 != com.immersion.hapticmediasdk.a.a.f) goto _L27; else goto _L26
_L26:
        i1 = 0;
          goto _L1
_L34:
        if (a1 != a.a.d) goto _L29; else goto _L28
_L28:
        i1 = e();
          goto _L1
_L27:
        if (a1 != a.a.d) goto _L31; else goto _L30
_L30:
        i1 = e();
          goto _L1
_L31:
        if (a1 != a.a.e) goto _L1; else goto _L32
_L32:
        i1 = e();
        c = a.a.e;
          goto _L1
_L23:
        if (a1 != a.a.h) goto _L34; else goto _L33
_L33:
        i1 = i();
          goto _L1
_L6:
        if (a1 != a.a.g) goto _L36; else goto _L35
_L35:
        i1 = 0;
          goto _L1
_L41:
        if (a1 != a.a.e) goto _L1; else goto _L37
_L37:
        i1 = e();
        c = a.a.e;
          goto _L1
_L7:
        if (a1 != a.a.h) goto _L39; else goto _L38
_L38:
        i1 = 0;
          goto _L1
_L14:
        if (a1 != com.immersion.hapticmediasdk.a.a.f)
        {
            continue; /* Loop/switch isn't completed */
        }
        c = com.immersion.hapticmediasdk.a.a.f;
        i1 = 0;
          goto _L1
        if (a1 != a.a.d) goto _L41; else goto _L40
_L40:
        i1 = e();
          goto _L1
_L47:
        if (a1 != com.immersion.hapticmediasdk.a.a.f) goto _L43; else goto _L42
_L42:
        c = com.immersion.hapticmediasdk.a.a.f;
        i1 = 0;
          goto _L1
_L8:
        if (a1 != com.immersion.hapticmediasdk.a.a.c) goto _L45; else goto _L44
_L44:
        i1 = j();
          goto _L1
_L39:
        if (a1 != com.immersion.hapticmediasdk.a.a.c) goto _L47; else goto _L46
_L46:
        d.a((int)j);
        i1 = j();
          goto _L1
_L43:
        if (a1 != a.a.d) goto _L49; else goto _L48
_L48:
        i1 = e();
          goto _L1
_L49:
        if (a1 != a.a.e) goto _L1; else goto _L50
_L50:
        i1 = e();
        c = a.a.e;
          goto _L1
_L45:
        a.a a2 = a.a.d;
        if (a1 == a2)
        {
            i1 = 0;
        }
          goto _L1
    }

    public final long a()
    {
        long l1;
        synchronized (a)
        {
            l1 = j;
        }
        return l1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void a(long l1)
    {
        synchronized (a)
        {
            if (c == a.a.d)
            {
                d.b();
            }
            b = SystemClock.uptimeMillis();
            j = l1;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void a(String s, boolean flag)
    {
        synchronized (i)
        {
            l = s;
            m = flag;
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public final long b()
    {
        long l1;
        synchronized (a)
        {
            l1 = b;
        }
        return l1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final a.a c()
    {
        a.a a1;
        synchronized (i)
        {
            a1 = c;
        }
        return a1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void run()
    {
        System.currentTimeMillis();
        if (((e + f) * e) % g != h)
        {
            e = 91;
            h = 30;
        }
        a(a.a.g);
    }
}
