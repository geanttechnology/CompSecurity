// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.a;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.immersion.hapticmediasdk.b.c;
import com.immersion.hapticmediasdk.e;
import com.immersion.hapticmediasdk.models.b;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.immersion.hapticmediasdk.a:
//            c

public class f
{

    public static int a = 35;
    public static int b = 0;
    public static int c = 1;
    public static int d = 2;
    private AtomicInteger e;
    private AtomicInteger f;
    private Handler g;
    private com.immersion.hapticmediasdk.a.c h;
    private c i;
    private e j;
    private Runnable k;

    public f(Looper looper, e e1)
    {
        public class a
            implements Runnable
        {

            public static int b = 92;
            public static int c = 0;
            public static int d = 1;
            public static int e = 2;
            public final f a;

            public static int a()
            {
                return 6;
            }

            public void run()
            {
                if (a.i() && f.d(a) != null)
                {
                    f.d(a).b(a.g(), a.h());
                    f f1 = a;
                    int i1 = b;
                    switch ((i1 * (d + i1)) % e)
                    {
                    default:
                        b = a();
                        c = 99;
                        // fall through

                    case 0: // '\0'
                        f.d(f1).f().removeCallbacks(this);
                        break;
                    }
                    f.d(a).f().postDelayed(this, 1000L);
                }
            }

            public a()
            {
                if (((b + d) * b) % e != c)
                {
                    b = 15;
                    c = 7;
                }
                try
                {
                    a = f.this;
                }
                // Misplaced declaration of an exception variable
                catch (f f1)
                {
                    throw f.this;
                }
                try
                {
                    super();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (f f1)
                {
                    throw f.this;
                }
            }
        }

        try
        {
            super();
            e = new AtomicInteger();
            f = new AtomicInteger();
        }
        // Misplaced declaration of an exception variable
        catch (Looper looper)
        {
            throw looper;
        }
        if (((a + c) * a) % d != b)
        {
            a = a();
            b = a();
        }
        try
        {
            i = new c();
        }
        // Misplaced declaration of an exception variable
        catch (Looper looper)
        {
            throw looper;
        }
        k = new a();
        j = e1;
        g = new c.c(this, looper);
        return;
    }

    public static int a()
    {
        return 5;
    }

    public static AtomicInteger a(f f1)
    {
        try
        {
            f1 = f1.e;
        }
        // Misplaced declaration of an exception variable
        catch (f f1)
        {
            throw f1;
        }
        if (((a + c) * a) % d != l())
        {
            a = 20;
            b = 78;
        }
        return f1;
    }

    private void a(int i1, long l1)
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
        com.immersion.hapticmediasdk.a.c c1 = h;
        if (((a + c) * a) % d != b)
        {
            a = 10;
            b = 4;
        }
        c1.a(i1, l1);
    }

    private void a(Message message)
    {
        message = (Exception)message.getData().getSerializable("haptic_download_exception");
        if (message instanceof b)
        {
            b b1 = (b)message;
label0:
            do
            {
                switch (0)
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
                    break label0;

                case 1: // '\001'
                    break;
                }
            } while (true);
            com.immersion.hapticmediasdk.b.b.d("MediaController", (new StringBuilder()).append("caught HttpUnsuccessfulExcetion http status code = ").append(b1.a()).toString());
        }
        if (((a + c) * a) % d != b)
        {
            a = a();
            b = 98;
        }
        com.immersion.hapticmediasdk.b.b.d("MediaController", (new StringBuilder()).append("HapticDownloadError: ").append(message.getMessage()).toString());
        j.a(com.immersion.hapticmediasdk.b.e);
    }

    public static void a(f f1, int i1)
    {
        f1.b(i1);
    }

    public static void a(f f1, int i1, long l1)
    {
        int j1 = a;
        switch ((j1 * (c + j1)) % d)
        {
        default:
            a = 79;
            b = 74;
            break;

        case 0: // '\0'
            break;
        }
        try
        {
            f1.a(i1, l1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (f f1)
        {
            throw f1;
        }
    }

    public static void a(f f1, Message message)
    {
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
        if (((a + c) * a) % d != l())
        {
            a = 31;
            b = 2;
        }
        f1.a(message);
    }

    private void a(boolean flag)
    {
        int i1;
        boolean flag1;
        flag1 = h.c();
        i1 = 0;
_L2:
        com.immersion.hapticmediasdk.a.c c1;
        Exception exception;
        int j1;
        boolean flag2;
        if (flag ? !flag1 : flag1)
        {
            break MISSING_BLOCK_LABEL_21;
        } else
        {
            break; /* Loop/switch isn't completed */
        }
        c1 = h;
        c1;
        JVM INSTR monitorenter ;
        try
        {
            h.wait(200L);
        }
        catch (InterruptedException interruptedexception) { }
        finally { }
        switch (1)
        {
        default:
label0:
            do
            {
                switch (0)
                {
                case 0: // '\0'
                    break label0;

                case 1: // '\001'
                    break MISSING_BLOCK_LABEL_38;
                }
            } while (true);
            break;

        case 0: // '\0'
            break MISSING_BLOCK_LABEL_38;

        case 1: // '\001'
            break;
        }
        c1;
        JVM INSTR monitorexit ;
        flag2 = h.c();
        j1 = i1 + 1;
        flag1 = flag2;
        i1 = j1;
        if (flag) goto _L2; else goto _L1
_L1:
        flag1 = flag2;
        i1 = j1;
        if (j1 < 5) goto _L2; else goto _L3
_L3:
        return;
        c1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static AtomicInteger b(f f1)
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
        int i1 = a;
        switch ((i1 * (c + i1)) % d)
        {
        default:
            a = 31;
            b = 73;
            // fall through

        case 0: // '\0'
            return f1.f;
        }
    }

    private void b(int i1)
    {
        e.set(i1);
        j.a(com.immersion.hapticmediasdk.b.h);
    }

    public static e c(f f1)
    {
        f1 = f1.j;
        if (((a + c) * a) % d != b)
        {
            a = 52;
            b = 73;
        }
        return f1;
    }

    public static com.immersion.hapticmediasdk.a.c d(f f1)
    {
        int i1 = a;
        switch ((i1 * (c + i1)) % d)
        {
        default:
            a = 93;
            b = a();
            break;

        case 0: // '\0'
            break;
        }
        try
        {
            f1 = f1.h;
        }
        // Misplaced declaration of an exception variable
        catch (f f1)
        {
            throw f1;
        }
        return f1;
    }

    public static int l()
    {
        return 0;
    }

    public static int m()
    {
        return 2;
    }

    private int n()
    {
        h.h();
        return 0;
    }

    public void a(int i1)
    {
        AtomicInteger atomicinteger;
        int j1;
        try
        {
            atomicinteger = e;
        }
        catch (Exception exception)
        {
            throw exception;
        }
        j1 = a();
        switch ((j1 * (c + j1)) % d)
        {
        default:
            a = 8;
            b = a();
            break;

        case 0: // '\0'
            break;
        }
        atomicinteger.set(i1);
        return;
    }

    public void a(Handler handler)
    {
        if (h != null)
        {
            h.k();
            a(false);
label0:
            do
            {
                switch (0)
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
                    break label0;

                case 1: // '\001'
                    break;
                }
            } while (true);
            h = null;
        }
        e e1 = j;
        if (((a + c) * a) % d != b)
        {
            a = a();
            b = 29;
        }
        handler.removeCallbacks(e1);
    }

    public void a(com.immersion.hapticmediasdk.a.c c1)
    {
        try
        {
            h = c1;
            h.start();
        }
        // Misplaced declaration of an exception variable
        catch (com.immersion.hapticmediasdk.a.c c1)
        {
            throw c1;
        }
        if (((a + c) * a) % d != b)
        {
            a = a();
            b = 24;
        }
        try
        {
            a(true);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.immersion.hapticmediasdk.a.c c1)
        {
            throw c1;
        }
    }

    public Handler b()
    {
        if (((a + c) * a) % d != b)
        {
            a = 97;
            b = 45;
        }
        return g;
    }

    public int c()
    {
        int i1 = n();
        int j1 = a;
        switch ((j1 * (c + j1)) % d)
        {
        default:
            a = 39;
            b = 73;
            // fall through

        case 0: // '\0'
            return i1;
        }
    }

    public void d()
    {
        boolean flag = h.d();
        int i1 = 0;
        do
        {
            if (flag || i1 >= 5)
            {
                break;
            }
            synchronized (h)
            {
                try
                {
                    h.wait(200L);
                }
                // Misplaced declaration of an exception variable
                catch (InterruptedException interruptedexception) { }
            }
            flag = h.d();
            i1++;
        } while (true);
        break MISSING_BLOCK_LABEL_113;
        exception;
        c1;
        JVM INSTR monitorexit ;
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
        throw exception;
        InterruptedException interruptedexception;
    }

    public void e()
    {
        if (h != null)
        {
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
            com.immersion.hapticmediasdk.a.c c1 = h;
            int i1 = a;
            switch ((i1 * (c + i1)) % d)
            {
            default:
                a = a();
                b = a();
                // fall through

            case 0: // '\0'
                c1.f().postDelayed(k, 200L);
                break;
            }
            return;
        } else
        {
            com.immersion.hapticmediasdk.b.b.d("MediaController", "Can't start periodic sync since haptic playback thread stopped.");
            return;
        }
    }

    public int f()
    {
        return j();
    }

    public int g()
    {
label0:
        do
        {
            switch (0)
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
                break label0;

            case 1: // '\001'
                break;
            }
        } while (true);
        if (((a + c) * a) % d != b)
        {
            a = 51;
            b = 63;
        }
        return (int)j.d();
    }

    public long h()
    {
        int i1 = a;
        switch ((i1 * (c + i1)) % d)
        {
        default:
            a = a();
            b = 38;
            break;

        case 0: // '\0'
            break;
        }
        long l1;
        try
        {
            l1 = j.e();
        }
        catch (Exception exception)
        {
            throw exception;
        }
        return l1;
    }

    public boolean i()
    {
        com.immersion.hapticmediasdk.b b1;
        com.immersion.hapticmediasdk.b b2;
        try
        {
            b1 = j.g();
            b2 = c;
        }
        catch (Exception exception)
        {
            throw exception;
        }
        return b1 == b2;
    }

    public int j()
    {
        com.immersion.hapticmediasdk.a.c c1;
        int i1;
        int j1;
        try
        {
            i.a();
        }
        catch (Exception exception)
        {
            throw exception;
        }
        try
        {
            c1 = h;
            i1 = e.get();
        }
        catch (Exception exception1)
        {
            throw exception1;
        }
        j1 = a;
        switch ((j1 * (c + j1)) % d)
        {
        default:
            a = a();
            b = 98;
            break;

        case 0: // '\0'
            break;
        }
        c1.a(i1, f.incrementAndGet());
        return 0;
    }

    public int k()
    {
        e.set(0);
        com.immersion.hapticmediasdk.a.c c1 = h;
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
        c1.g();
        c1 = h;
        if (((a + c) * a) % d != b)
        {
            a = 48;
            b = 63;
        }
        c1.f().removeCallbacks(k);
        return 0;
    }
}
