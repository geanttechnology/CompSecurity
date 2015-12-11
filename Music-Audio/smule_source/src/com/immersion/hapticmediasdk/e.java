// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import com.immersion.hapticmediasdk.a.c;
import com.immersion.hapticmediasdk.a.f;
import com.immersion.hapticmediasdk.b.b;
import com.immersion.hapticmediasdk.b.d;

// Referenced classes of package com.immersion.hapticmediasdk:
//            b

public class e
    implements Runnable
{

    public static int a = 37;
    public static int b = 1;
    public static int c = 2;
    public static int d;
    private final Object e;
    private final Object f;
    private long g;
    private long h;
    private Handler i;
    private volatile com.immersion.hapticmediasdk.b j;
    private f k;
    private String l;
    private boolean m;
    private Context n;
    private d o;

    public e(Handler handler, Context context, d d1)
    {
        if (((a + b) * a) % c != a())
        {
            a = 47;
            b = b();
        }
        com.immersion.hapticmediasdk.b b1;
        try
        {
            super();
            e = new Object();
        }
        // Misplaced declaration of an exception variable
        catch (Handler handler)
        {
            throw handler;
        }
        try
        {
            f = new Object();
            b1 = b.a;
        }
        // Misplaced declaration of an exception variable
        catch (Handler handler)
        {
            throw handler;
        }
        j = b1;
        i = handler;
        n = context;
        o = d1;
        return;
    }

    public static int a()
    {
        return 0;
    }

    public static int b()
    {
        return 54;
    }

    private int b(com.immersion.hapticmediasdk.b b1)
    {
        int i1 = a;
        switch ((i1 * (b + i1)) % c)
        {
        default:
            a = 19;
            b = b();
            break;

        case 0: // '\0'
            break;
        }
        Object obj;
        String s;
        try
        {
            obj = i;
        }
        // Misplaced declaration of an exception variable
        catch (com.immersion.hapticmediasdk.b b1)
        {
            throw b1;
        }
        try
        {
            ((Handler) (obj)).removeCallbacks(this);
            j = b1;
            if (l == null)
            {
                break MISSING_BLOCK_LABEL_135;
            }
            k = new f(i.getLooper(), this);
            b1 = k.b();
            obj = n;
            s = l;
        }
        // Misplaced declaration of an exception variable
        catch (com.immersion.hapticmediasdk.b b1)
        {
            throw b1;
        }
        b1 = new c(((Context) (obj)), s, b1, m, o);
        k.a(b1);
        return 0;
        return -4;
    }

    public static int c()
    {
        return 1;
    }

    private int h()
    {
        int i1;
        try
        {
            i.removeCallbacks(this);
            if (k != null && k() != 0)
            {
                com.immersion.hapticmediasdk.b.b.d("MediaTaskManager", "Could not dispose haptics, reset anyway.");
            }
        }
        catch (Exception exception)
        {
            throw exception;
        }
        try
        {
            l = null;
            g = 0L;
            j = b.a;
        }
        catch (Exception exception1)
        {
            throw exception1;
        }
        i1 = a;
        switch ((i1 * (c() + i1)) % c)
        {
        default:
            a = b();
            b = 55;
            // fall through

        case 0: // '\0'
            return 0;
        }
    }

    private int i()
    {
        i.removeCallbacks(this);
        int i1 = k.f();
        if (i1 == 0)
        {
            j = com.immersion.hapticmediasdk.b.c;
            Handler handler = i;
            int j1 = a;
            switch ((j1 * (b + j1)) % c)
            {
            default:
                a = b();
                d = 68;
                // fall through

            case 0: // '\0'
                handler.postDelayed(this, 1500L);
                break;
            }
        }
        return i1;
    }

    private int j()
    {
        int i1;
        try
        {
            i.removeCallbacks(this);
            g = 0L;
        }
        catch (Exception exception)
        {
            throw exception;
        }
        if (((a + b) * a) % c != d)
        {
            a = b();
            d = b();
        }
        try
        {
            i1 = k.k();
        }
        catch (Exception exception1)
        {
            throw exception1;
        }
        if (i1 != 0)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        j = d;
        return i1;
    }

    private int k()
    {
        int i1 = j();
        if (i1 == 0)
        {
label0:
            do
            {
                switch (0)
                {
                default:
                    while (true) 
                    {
                        switch (1)
                        {
                        default:
                            break;

                        case 0: // '\0'
                            continue label0;

                        case 1: // '\001'
                            break label0;
                        }
                    }
                    break;

                case 0: // '\0'
                    break label0;

                case 1: // '\001'
                    break;
                }
            } while (true);
            k.a(i);
            if (((a + b) * a) % c != d)
            {
                a = 80;
                d = 44;
            }
            k = null;
        }
        return i1;
    }

    private int l()
    {
        int i1 = 2;
        int j1;
        try
        {
            i.removeCallbacks(this);
        }
        catch (Exception exception1)
        {
            throw exception1;
        }
        try
        {
            j1 = k.c();
        }
        catch (Exception exception2)
        {
            throw exception2;
        }
        if (j1 != 0)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        try
        {
            do
            {
                i1 /= 0;
            } while (true);
        }
        catch (Exception exception)
        {
            a = b();
        }
        j = com.immersion.hapticmediasdk.b.f;
        return j1;
    }

    private int m()
    {
        i.removeCallbacks(this);
        if (i.postDelayed(this, 1500L))
        {
label0:
            do
            {
                switch (0)
                {
                default:
                    while (true) 
                    {
                        switch (1)
                        {
                        default:
                            break;

                        case 0: // '\0'
                            continue label0;

                        case 1: // '\001'
                            break label0;
                        }
                    }
                    break;

                case 0: // '\0'
                    break label0;

                case 1: // '\001'
                    break;
                }
            } while (true);
            if (((b() + b) * b()) % c != d)
            {
                a = 70;
                d = 50;
            }
            return 0;
        } else
        {
            return -1;
        }
    }

    private int n()
    {
        int i1;
        try
        {
            i1 = k.c();
        }
        catch (Exception exception)
        {
            throw exception;
        }
        if (i1 != 0)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        if (((a + b) * a) % c != a())
        {
            a = 64;
            d = 32;
        }
        j = b.g;
        return i1;
    }

    private int o()
    {
        int i1;
        try
        {
            i1 = k.c();
        }
        catch (Exception exception)
        {
            throw exception;
        }
        if (i1 != 0)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        j = b.h;
        if (((a + b) * a) % c != d)
        {
            a = 29;
            d = b();
        }
        return i1;
    }

    private int p()
    {
        if (((a + b) * a) % c != d)
        {
            a = 78;
            d = 14;
        }
        int j1 = i();
        int i1 = j1;
        if (j1 == 0)
        {
            i1 = m();
        }
label0:
        do
        {
            switch (0)
            {
            default:
                while (true) 
                {
                    switch (1)
                    {
                    default:
                        break;

                    case 0: // '\0'
                        continue label0;

                    case 1: // '\001'
                        break label0;
                    }
                }
                break;

            case 0: // '\0'
                break label0;

            case 1: // '\001'
                break;
            }
        } while (true);
        return i1;
    }

    public int a(com.immersion.hapticmediasdk.b b1)
    {
        int i1;
label0:
        {
            i1 = -1;
            synchronized (e)
            {
                if (b1 != b.a)
                {
                    break label0;
                }
                i1 = h();
            }
            return i1;
        }
        public class a
        {

            public static final int a[];
            public static int b = 88;
            public static int c = 1;
            public static int d = 2;

            static 
            {
                a = new int[com.immersion.hapticmediasdk.b.values().length];
                NoSuchFieldError nosuchfielderror;
                int j1;
                try
                {
                    a[b.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                a[b.ordinal()] = 2;
label0:
                do
                {
                    switch (1)
                    {
                    default:
                        while (true) 
                        {
                            switch (0)
                            {
                            default:
                                break;

                            case 0: // '\0'
                                break label0;

                            case 1: // '\001'
                                continue label0;
                            }
                        }
                        break;

                    case 0: // '\0'
                        break;

                    case 1: // '\001'
                        break label0;
                    }
                } while (true);
_L4:
                try
                {
                    a[com.immersion.hapticmediasdk.b.c.ordinal()] = 3;
                }
                // Misplaced declaration of an exception variable
                catch (NoSuchFieldError nosuchfielderror) { }
                a[com.immersion.hapticmediasdk.b.f.ordinal()] = 4;
                j1 = b;
                switch ((j1 * (c + j1)) % d)
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
                    a[b.g.ordinal()] = 5;
                }
                // Misplaced declaration of an exception variable
                catch (NoSuchFieldError nosuchfielderror) { }
                try
                {
                    a[b.h.ordinal()] = 6;
                }
                // Misplaced declaration of an exception variable
                catch (NoSuchFieldError nosuchfielderror) { }
                try
                {
                    a[d.ordinal()] = 7;
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
                nosuchfielderror;
                if (true) goto _L4; else goto _L3
_L3:
            }
        }

        a.a[j.ordinal()];
        JVM INSTR tableswitch 1 7: default 590
    //                   1 90
    //                   2 107
    //                   3 593
    //                   4 268
    //                   5 387
    //                   6 423
    //                   7 492;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        obj;
        JVM INSTR monitorexit ;
        return i1;
        b1;
        obj;
        JVM INSTR monitorexit ;
        throw b1;
_L2:
        if (b1 != b) goto _L1; else goto _L9
_L9:
        i1 = b(b1);
          goto _L1
_L3:
        if (b1 != com.immersion.hapticmediasdk.b.c) goto _L11; else goto _L10
_L10:
        i1 = p();
          goto _L1
_L29:
        if (b1 != b.e) goto _L1; else goto _L12
_L12:
        i1 = j();
        j = b.e;
          goto _L1
_L34:
        if (b1 != com.immersion.hapticmediasdk.b.c) goto _L14; else goto _L13
_L13:
        k.a((int)g);
        i1 = p();
          goto _L1
_L11:
        if (b1 != d) goto _L16; else goto _L15
_L15:
        i1 = j();
          goto _L1
_L16:
        if (b1 != b.e) goto _L1; else goto _L17
_L17:
        i1 = j();
        j = b.e;
          goto _L1
_L52:
        if (b1 != com.immersion.hapticmediasdk.b.c) goto _L19; else goto _L18
_L18:
        i1 = m();
          goto _L1
_L19:
        if (b1 != com.immersion.hapticmediasdk.b.f) goto _L21; else goto _L20
_L20:
        i1 = l();
          goto _L1
_L21:
        if (b1 != b.g) goto _L23; else goto _L22
_L22:
        com.immersion.hapticmediasdk.b.b.c("MediaTaskManager", "Haptic playback is paused due to update time-out. Call update() to resume playback");
        i1 = n();
          goto _L1
_L5:
        if (b1 != com.immersion.hapticmediasdk.b.c) goto _L25; else goto _L24
_L24:
        k.a((int)g);
        i1 = p();
          goto _L1
_L25:
        if (b1 != com.immersion.hapticmediasdk.b.f) goto _L27; else goto _L26
_L26:
        i1 = 0;
          goto _L1
_L23:
        if (b1 != b.h)
        {
            continue; /* Loop/switch isn't completed */
        }
        i1 = o();
        com.immersion.hapticmediasdk.b.b.c("MediaTaskManager", "Haptic playback is paused due to slow data buffering...");
          goto _L1
        if (b1 != d) goto _L29; else goto _L28
_L28:
        i1 = j();
          goto _L1
_L27:
        if (b1 != d) goto _L31; else goto _L30
_L30:
        i1 = j();
          goto _L1
_L31:
        if (b1 != b.e) goto _L1; else goto _L32
_L32:
        i1 = j();
        j = b.e;
          goto _L1
_L6:
        if (b1 != b.g) goto _L34; else goto _L33
_L33:
        i1 = 0;
          goto _L1
_L39:
        if (b1 != b.e) goto _L1; else goto _L35
_L35:
        i1 = j();
        j = b.e;
          goto _L1
_L7:
        if (b1 != b.h) goto _L37; else goto _L36
_L36:
        i1 = 0;
          goto _L1
_L14:
        if (b1 != com.immersion.hapticmediasdk.b.f)
        {
            continue; /* Loop/switch isn't completed */
        }
        j = com.immersion.hapticmediasdk.b.f;
        i1 = 0;
          goto _L1
        if (b1 != d) goto _L39; else goto _L38
_L38:
        i1 = j();
          goto _L1
_L45:
        if (b1 != com.immersion.hapticmediasdk.b.f) goto _L41; else goto _L40
_L40:
        j = com.immersion.hapticmediasdk.b.f;
        i1 = 0;
          goto _L1
_L8:
        if (b1 != com.immersion.hapticmediasdk.b.c) goto _L43; else goto _L42
_L42:
        i1 = p();
          goto _L1
_L37:
        if (b1 != com.immersion.hapticmediasdk.b.c) goto _L45; else goto _L44
_L44:
        k.a((int)g);
        i1 = p();
          goto _L1
_L41:
        if (b1 != d) goto _L47; else goto _L46
_L46:
        i1 = j();
          goto _L1
_L47:
        if (b1 != b.e) goto _L1; else goto _L48
_L48:
        i1 = j();
        j = b.e;
          goto _L1
_L43:
        com.immersion.hapticmediasdk.b b2 = d;
        if (b1 == b2)
        {
            i1 = 0;
        }
          goto _L1
_L4:
        1;
        JVM INSTR tableswitch 0 1: default 616
    //                   0 593
    //                   1 213;
           goto _L49 _L4 _L50
_L50:
        if (true) goto _L52; else goto _L51
_L51:
_L49:
        0;
        JVM INSTR tableswitch 0 1: default 640
    //                   0 213
    //                   1 593;
           goto _L49 _L52 _L4
    }

    public void a(long l1)
    {
        Object obj = f;
        obj;
        JVM INSTR monitorenter ;
        if (j == d)
        {
            k.d();
        }
        h = SystemClock.uptimeMillis();
          goto _L1
_L6:
        g = l1;
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
        1;
        JVM INSTR tableswitch 0 1: default 72
    //                   0 49
    //                   1 34;
           goto _L2 _L1 _L3
_L3:
        continue; /* Loop/switch isn't completed */
_L2:
        1;
        JVM INSTR tableswitch 0 1: default 96
    //                   0 49
    //                   1 34;
           goto _L2 _L1 _L4
_L4:
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void a(String s, boolean flag)
    {
        synchronized (e)
        {
            l = s;
            m = flag;
        }
        return;
_L2:
        obj;
        JVM INSTR monitorexit ;
        throw s;
        s;
_L3:
        0;
        JVM INSTR tableswitch 0 1: default 48
    //                   0 20
    //                   1 25;
           goto _L1 _L2 _L3
_L1:
        0;
        JVM INSTR tableswitch 0 1: default 72
    //                   0 20
    //                   1 25;
           goto _L1 _L2 _L3
    }

    public long d()
    {
        long l1;
        synchronized (f)
        {
            l1 = g;
        }
        return l1;
_L3:
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        exception;
_L2:
        1;
        JVM INSTR tableswitch 0 1: default 44
    //                   0 21
    //                   1 16;
           goto _L1 _L2 _L3
_L1:
        0;
        JVM INSTR tableswitch 0 1: default 68
    //                   0 16
    //                   1 21;
           goto _L1 _L3 _L2
    }

    public long e()
    {
        long l1;
        synchronized (f)
        {
            l1 = h;
        }
        return l1;
        exception;
        obj;
        JVM INSTR monitorexit ;
label0:
        do
        {
            switch (0)
            {
            default:
                while (true) 
                {
                    switch (1)
                    {
                    default:
                        break;

                    case 0: // '\0'
                        continue label0;

                    case 1: // '\001'
                        break label0;
                    }
                }
                break;

            case 0: // '\0'
                break label0;

            case 1: // '\001'
                break;
            }
        } while (true);
        throw exception;
    }

    public void f()
    {
        Object obj = f;
        obj;
        JVM INSTR monitorenter ;
        com.immersion.hapticmediasdk.b b1 = j;
          goto _L1
_L3:
        if (b1 == d)
        {
            k.d();
        }
        h = SystemClock.uptimeMillis();
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
        1;
        JVM INSTR tableswitch 0 1: default 68
    //                   0 44
    //                   1 15;
           goto _L2 _L1 _L3
_L2:
        0;
        JVM INSTR tableswitch 0 1: default 92
    //                   0 15
    //                   1 44;
           goto _L2 _L3 _L1
    }

    public com.immersion.hapticmediasdk.b g()
    {
        com.immersion.hapticmediasdk.b b1;
        synchronized (e)
        {
            b1 = j;
        }
        return b1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void run()
    {
        System.currentTimeMillis();
        if (((a + b) * a) % c != d)
        {
            a = 91;
            d = 30;
        }
label0:
        do
        {
            switch (1)
            {
            default:
                while (true) 
                {
                    switch (1)
                    {
                    default:
                        break;

                    case 0: // '\0'
                        continue label0;

                    case 1: // '\001'
                        break label0;
                    }
                }
                break;

            case 0: // '\0'
                break;

            case 1: // '\001'
                break label0;
            }
        } while (true);
        a(b.g);
    }
}
