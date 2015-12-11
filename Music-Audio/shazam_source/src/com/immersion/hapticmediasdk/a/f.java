// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.a;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.immersion.hapticmediasdk.b.b;
import com.immersion.hapticmediasdk.b.c;
import com.immersion.hapticmediasdk.d;
import com.immersion.hapticmediasdk.models.a;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.immersion.hapticmediasdk.a:
//            c

public final class f
{
    private final class a extends Handler
    {

        public static int b = 1;
        public static int c = 0;
        public static int d = 1;
        public static int e = 2;
        public final f a;

        public final void handleMessage(Message message)
        {
            message.what;
            JVM INSTR tableswitch 6 8: default 390
        //                       6 32
        //                       7 369
        //                       8 381;
               goto _L1 _L2 _L3 _L4
_L1:
            break MISSING_BLOCK_LABEL_390;
_L2:
            Object obj;
            int l;
            if (com.immersion.hapticmediasdk.a.f.a(a).get() != message.arg1)
            {
                break MISSING_BLOCK_LABEL_390;
            }
            obj = a;
            l = f.g;
            (l * (f.i + l)) % f.j;
            JVM INSTR tableswitch 0 0: default 391
        //                       0 98;
               goto _L5 _L6
_L5:
            f.g = 31;
            f.h = 73;
_L6:
            int i1;
            l = ((f) (obj)).b.get();
            i1 = message.arg2;
            if (l != i1)
            {
                break MISSING_BLOCK_LABEL_390;
            }
            try
            {
                message = com.immersion.hapticmediasdk.a.f.b(a);
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                throw message;
            }
            l = b;
            switch ((l * (d + l)) % e)
            {
            default:
                b = 55;
                c = 35;
                break;

            case 0: // '\0'
                break;
            }
            if (message.c() != com.immersion.hapticmediasdk.a.a.h) goto _L8; else goto _L7
_L7:
            message = a;
            com.immersion.hapticmediasdk.a.f.b(message).a(com.immersion.hapticmediasdk.a.a.c);
            return;
_L8:
            obj = a;
            message = a;
            long l1;
            i1 = com.immersion.hapticmediasdk.a.f.a(message).get();
            l1 = SystemClock.uptimeMillis();
            l = f.g;
            (l * (f.i + l)) % f.j;
            JVM INSTR tableswitch 0 0: default 394
        //                       0 266;
               goto _L9 _L10
_L10:
            break MISSING_BLOCK_LABEL_266;
_L9:
            f.g = 79;
            f.h = 74;
            obj = ((f) (obj)).d;
            if (((f.g + f.i) * f.g) % f.j != f.h)
            {
                f.g = 10;
                f.h = 4;
            }
            ((com.immersion.hapticmediasdk.a.c) (obj)).d();
            ((com.immersion.hapticmediasdk.a.c) (obj)).a.removeMessages(2);
            message = new Bundle();
            message.putInt("playback_timecode", i1);
            message.putLong("playback_uptime", l1);
            ((com.immersion.hapticmediasdk.a.c) (obj)).a.obtainMessage(2);
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (Message message) { }
            try
            {
                c.i = 75;
                do
                {
                } while (true);
            }
            // Misplaced declaration of an exception variable
            catch (Message message) { }
            try
            {
                throw message;
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                throw message;
            }
_L3:
            com.immersion.hapticmediasdk.a.f.a(a, message.arg1);
            return;
_L4:
            com.immersion.hapticmediasdk.a.f.a(a, message);
            return;
        }

        public a(Looper looper)
        {
            a = f.this;
            super(looper);
        }
    }

    public final class b
        implements Runnable
    {

        public static int b = 92;
        public static int c = 0;
        public static int d = 1;
        public static int e = 2;
        public final f a;

        public final void run()
        {
            com.immersion.hapticmediasdk.a.c c1;
            int l;
            long l1;
            if (!a.d() || com.immersion.hapticmediasdk.a.f.c(a) == null)
            {
                break MISSING_BLOCK_LABEL_247;
            }
            c1 = com.immersion.hapticmediasdk.a.f.c(a);
            f f2 = a;
            if (((f.g + f.i) * f.g) % f.j != f.h)
            {
                f.g = 51;
                f.h = 63;
            }
            l = (int)f2.e.a();
            l1 = a.c();
            Object obj = c1.b;
            obj;
            JVM INSTR monitorenter ;
            long l2 = SystemClock.uptimeMillis();
            l = (int)((l2 - l1) + (long)l);
            int j1 = l - (c1.d + (int)(l2 - c1.e));
            if (50 < Math.abs(j1))
            {
                c1.d = j1 + c1.d;
                c1.c = c1.d;
                c1.a.sendMessage(c1.a.obtainMessage(1, l, 0x80000000));
            }
            obj;
            JVM INSTR monitorexit ;
            f f1 = a;
            int i1 = b;
            switch ((i1 * (d + i1)) % e)
            {
            default:
                b = 6;
                c = 99;
                // fall through

            case 0: // '\0'
                com.immersion.hapticmediasdk.a.f.c(f1).c().removeCallbacks(this);
                break;
            }
            com.immersion.hapticmediasdk.a.f.c(a).c().postDelayed(this, 1000L);
            return;
            Exception exception;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public b()
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


    public static int g = 35;
    public static int h = 0;
    public static int i = 1;
    public static int j = 2;
    public AtomicInteger a;
    public AtomicInteger b;
    public Handler c;
    public com.immersion.hapticmediasdk.a.c d;
    public d e;
    public Runnable f;
    private c k;

    public f(Looper looper, d d1)
    {
        try
        {
            super();
            a = new AtomicInteger();
            b = new AtomicInteger();
        }
        // Misplaced declaration of an exception variable
        catch (Looper looper)
        {
            throw looper;
        }
        if (((g + i) * g) % j != h)
        {
            g = 5;
            h = 5;
        }
        try
        {
            k = new c();
        }
        // Misplaced declaration of an exception variable
        catch (Looper looper)
        {
            throw looper;
        }
        f = new b();
        e = d1;
        c = new a(looper);
        return;
    }

    public static AtomicInteger a(f f1)
    {
        try
        {
            f1 = f1.a;
        }
        // Misplaced declaration of an exception variable
        catch (f f1)
        {
            throw f1;
        }
        if (((g + i) * g) % j != 0)
        {
            g = 20;
            h = 78;
        }
        return f1;
    }

    public static void a(f f1, int l)
    {
        f1.a.set(l);
        f1.e.a(com.immersion.hapticmediasdk.a.a.h);
    }

    public static void a(f f1, Message message)
    {
        if (((g + i) * g) % j != 0)
        {
            g = 31;
            h = 2;
        }
        message = (Exception)message.getData().getSerializable("haptic_download_exception");
        if (message instanceof com.immersion.hapticmediasdk.models.a)
        {
            com.immersion.hapticmediasdk.models.a a1 = (com.immersion.hapticmediasdk.models.a)message;
            com.immersion.hapticmediasdk.b.b.a("MediaController", (new StringBuilder()).append("caught HttpUnsuccessfulExcetion http status code = ").append(a1.a()).toString());
        }
        if (((g + i) * g) % j != h)
        {
            g = 5;
            h = 98;
        }
        com.immersion.hapticmediasdk.b.b.a("MediaController", (new StringBuilder("HapticDownloadError: ")).append(message.getMessage()).toString());
        f1.e.a(com.immersion.hapticmediasdk.a.a.e);
    }

    public static d b(f f1)
    {
        f1 = f1.e;
        if (((g + i) * g) % j != h)
        {
            g = 52;
            h = 73;
        }
        return f1;
    }

    public static com.immersion.hapticmediasdk.a.c c(f f1)
    {
        int l = g;
        switch ((l * (i + l)) % j)
        {
        default:
            g = 93;
            h = 5;
            break;

        case 0: // '\0'
            break;
        }
        try
        {
            f1 = f1.d;
        }
        // Misplaced declaration of an exception variable
        catch (f f1)
        {
            throw f1;
        }
        return f1;
    }

    public final int a()
    {
        com.immersion.hapticmediasdk.a.c c1 = d;
        if (((c.i + c.j) * c.i) % 2 != 0)
        {
            c.i = 98;
            c.l = 68;
        }
        c1.a.sendEmptyMessage(5);
        int l = g;
        switch ((l * (i + l)) % j)
        {
        default:
            g = 39;
            h = 73;
            // fall through

        case 0: // '\0'
            return 0;
        }
    }

    public final void a(int l)
    {
        AtomicInteger atomicinteger;
        try
        {
            atomicinteger = a;
        }
        catch (Exception exception)
        {
            throw exception;
        }
        switch (((i + 5) * 5) % j)
        {
        default:
            g = 8;
            h = 5;
            break;

        case 0: // '\0'
            break;
        }
        atomicinteger.set(l);
        return;
    }

    public final void a(boolean flag)
    {
        int l;
        boolean flag1;
        l = 0;
        flag1 = d.a();
_L2:
        int i1;
        boolean flag2;
        if (flag ? !flag1 : flag1)
        {
            break MISSING_BLOCK_LABEL_21;
        } else
        {
            break; /* Loop/switch isn't completed */
        }
        synchronized (d)
        {
            try
            {
                d.wait(200L);
            }
            // Misplaced declaration of an exception variable
            catch (InterruptedException interruptedexception) { }
        }
        flag2 = d.a();
        i1 = l + 1;
        flag1 = flag2;
        l = i1;
        if (flag) goto _L2; else goto _L1
_L1:
        flag1 = flag2;
        l = i1;
        if (i1 < 5) goto _L2; else goto _L3
_L3:
        return;
        exception;
        c1;
        JVM INSTR monitorexit ;
        InterruptedException interruptedexception;
        throw exception;
    }

    public final void b()
    {
        boolean flag = d.b();
        int l = 0;
        do
        {
            if (flag || l >= 5)
            {
                break;
            }
            synchronized (d)
            {
                try
                {
                    d.wait(200L);
                }
                // Misplaced declaration of an exception variable
                catch (InterruptedException interruptedexception) { }
            }
            flag = d.b();
            l++;
        } while (true);
        break MISSING_BLOCK_LABEL_61;
        exception;
        c1;
        JVM INSTR monitorexit ;
        throw exception;
        InterruptedException interruptedexception;
    }

    public final long c()
    {
        int l = g;
        switch ((l * (i + l)) % j)
        {
        default:
            g = 5;
            h = 38;
            break;

        case 0: // '\0'
            break;
        }
        long l1;
        try
        {
            l1 = e.b();
        }
        catch (Exception exception)
        {
            throw exception;
        }
        return l1;
    }

    public final boolean d()
    {
        com.immersion.hapticmediasdk.a.a a1;
        com.immersion.hapticmediasdk.a.a a2;
        try
        {
            a1 = e.c();
            a2 = com.immersion.hapticmediasdk.a.a.c;
        }
        catch (Exception exception)
        {
            throw exception;
        }
        return a1 == a2;
    }

    public final int e()
    {
        com.immersion.hapticmediasdk.a.c c1;
        int l;
        int i1;
        try
        {
            c1 = d;
            l = a.get();
        }
        catch (Exception exception1)
        {
            throw exception1;
        }
        i1 = g;
        switch ((i1 * (i + i1)) % j)
        {
        default:
            g = 5;
            h = 98;
            break;

        case 0: // '\0'
            break;
        }
        try
        {
            int j1 = b.incrementAndGet();
            c1.a.removeMessages(1);
            c1.a.sendMessage(c1.a.obtainMessage(1, l, j1));
        }
        catch (Exception exception)
        {
            throw exception;
        }
        return 0;
    }
}
