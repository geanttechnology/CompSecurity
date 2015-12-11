// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import com.immersion.content.EndpointWarp;
import com.immersion.hapticmediasdk.b.a;
import com.immersion.hapticmediasdk.b.b;
import com.immersion.hapticmediasdk.b.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.immersion.hapticmediasdk.a:
//            d, b, a

public final class com.immersion.hapticmediasdk.a.c extends Thread
{
    private final class a
        implements Runnable
    {

        public static int b = 45;
        public static int c = 1;
        public static int d = 2;
        public final com.immersion.hapticmediasdk.a.c a;
        private final byte e[];
        private final long f;
        private final long g;
        private final int h;
        private final long i;

        public final void run()
        {
            if (com.immersion.hapticmediasdk.a.c.l(a))
            {
                synchronized (com.immersion.hapticmediasdk.a.c.m(a))
                {
                    com.immersion.hapticmediasdk.a.c.n(a).remove(this);
                }
                if (f >= g)
                {
                    if (com.immersion.hapticmediasdk.a.c.o(a).a())
                    {
                        obj = com.immersion.hapticmediasdk.a.c.g();
                        byte abyte0[] = e;
                        int i1 = e.length;
                        long l1 = i;
                        long l2 = h;
                        try
                        {
                            ((EndpointWarp) (obj)).updateWarp(((EndpointWarp) (obj)).a, abyte0, i1, l1, l2);
                        }
                        catch (Exception exception)
                        {
                            throw exception;
                        }
                        if (((EndpointWarp.b + EndpointWarp.e) * EndpointWarp.b) % EndpointWarp.d != EndpointWarp.c)
                        {
                            EndpointWarp.b = 29;
                            EndpointWarp.c = 29;
                        }
                    }
                    synchronized (com.immersion.hapticmediasdk.a.c.p(a))
                    {
                        com.immersion.hapticmediasdk.a.c.d(a, com.immersion.hapticmediasdk.a.c.g(a));
                        com.immersion.hapticmediasdk.a.c.q(a);
                        com.immersion.hapticmediasdk.a.c.a(a, SystemClock.uptimeMillis());
                    }
                }
                com.immersion.hapticmediasdk.a.c.b(a).post(com.immersion.hapticmediasdk.a.c.r(a));
            }
            return;
            exception1;
            obj;
            JVM INSTR monitorexit ;
            throw exception1;
            exception2;
            obj;
            JVM INSTR monitorexit ;
            throw exception2;
        }

        public a(long l1, long l2, byte abyte0[], int i1, 
                long l3)
        {
            int j1;
            try
            {
                a = com.immersion.hapticmediasdk.a.c.this;
                super();
                e = abyte0;
                f = l1;
            }
            // Misplaced declaration of an exception variable
            catch (com.immersion.hapticmediasdk.a.c c1)
            {
                throw com.immersion.hapticmediasdk.a.c.this;
            }
            j1 = b;
            switch ((j1 * (c + j1)) % d)
            {
            default:
                b = 15;
                c = 32;
                break;

            case 0: // '\0'
                break;
            }
            try
            {
                g = l2;
                h = i1;
                i = l3;
                return;
            }
            // Misplaced declaration of an exception variable
            catch (com.immersion.hapticmediasdk.a.c c1)
            {
                throw com.immersion.hapticmediasdk.a.c.this;
            }
        }
    }

    public final class b
        implements Runnable
    {

        public static int b = 48;
        public static int c = 0;
        public static int d = 1;
        public static int e = 2;
        public final com.immersion.hapticmediasdk.a.c a;

        public final void run()
        {
            com.immersion.hapticmediasdk.a.c c1;
            try
            {
                c1 = a;
            }
            catch (Exception exception1)
            {
                throw exception1;
            }
            if (((b + d) * b) % e != c)
            {
                b = 15;
                c = 40;
            }
            try
            {
                com.immersion.hapticmediasdk.a.c.k(c1);
                return;
            }
            catch (Exception exception)
            {
                throw exception;
            }
        }

        public b()
        {
            a = com.immersion.hapticmediasdk.a.c.this;
            if (((b + d) * b) % 2 != c)
            {
                b = 15;
                c = 15;
            }
            super();
        }
    }

    private final class c extends Handler
    {

        public final com.immersion.hapticmediasdk.a.c a;

        public final void handleMessage(Message message)
        {
            message.what;
            JVM INSTR tableswitch 1 9: default 56
        //                       1 57
        //                       2 114
        //                       3 139
        //                       4 237
        //                       5 247
        //                       6 56
        //                       7 56
        //                       8 255
        //                       9 264;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L1 _L1 _L7 _L8
_L1:
            return;
_L2:
            com.immersion.hapticmediasdk.a.c.b(a).removeCallbacks(com.immersion.hapticmediasdk.a.c.a(a));
            com.immersion.hapticmediasdk.a.c.a(a, message.arg1);
            com.immersion.hapticmediasdk.a.c.b(a, message.arg2);
            com.immersion.hapticmediasdk.a.c.c(a);
            com.immersion.hapticmediasdk.a.c.d(a);
            return;
_L3:
            message = message.getData();
            com.immersion.hapticmediasdk.a.c.a(a, message.getInt("playback_timecode"), message.getLong("playback_uptime"));
            return;
_L4:
            if (com.immersion.hapticmediasdk.a.c.e(a) == null)
            {
                com.immersion.hapticmediasdk.a.c.a(a, com.immersion.hapticmediasdk.a.a.a(com.immersion.hapticmediasdk.a.c.f(a), com.immersion.hapticmediasdk.a.c.f()));
            }
            if (com.immersion.hapticmediasdk.a.c.e(a) != null && com.immersion.hapticmediasdk.a.c.g(a) == 0)
            {
                com.immersion.hapticmediasdk.a.c.c(a, com.immersion.hapticmediasdk.a.c.e(a).a());
            }
            if (com.immersion.hapticmediasdk.a.c.e(a) != null)
            {
                com.immersion.hapticmediasdk.a.c.e(a).a(message.arg1);
                return;
            }
              goto _L1
_L5:
            com.immersion.hapticmediasdk.a.c.h(a);
            do
            {
            } while (true);
_L6:
            com.immersion.hapticmediasdk.a.c.i(a);
            return;
_L7:
            com.immersion.hapticmediasdk.a.c.a(a, message);
            return;
_L8:
            com.immersion.hapticmediasdk.a.c.j(a);
            return;
        }

        private c()
        {
            do
            {
            } while (true);
        }
    }

    public final class d
        implements Runnable
    {

        public static int b = 2;
        public static int c = 1;
        public static int d = 2;
        public final com.immersion.hapticmediasdk.a.c a;

        public final void run()
        {
            com.immersion.hapticmediasdk.a.c.d(a);
        }

        public d()
        {
            int i1 = b;
            switch ((i1 * (c + i1)) % d)
            {
            default:
                b = 54;
                c = 54;
                // fall through

            case 0: // '\0'
                a = com.immersion.hapticmediasdk.a.c.this;
                break;
            }
            super();
        }
    }


    public static int i = 86;
    public static int j = 1;
    public static int k = 2;
    public static int l;
    private boolean A;
    private boolean B;
    private ArrayList C;
    private com.immersion.hapticmediasdk.b.d D;
    private boolean E;
    private com.immersion.hapticmediasdk.b.a F;
    private final Runnable G = new d();
    private final Runnable H = new b();
    public Handler a;
    public Object b;
    public int c;
    public int d;
    public long e;
    public Context f;
    public volatile boolean g;
    public volatile boolean h;
    private int m;
    private final String n;
    private final Handler o;
    private com.immersion.hapticmediasdk.a.b p;
    private Looper q;
    private com.immersion.hapticmediasdk.a.d r;
    private EndpointWarp s;
    private final com.immersion.hapticmediasdk.b.c t = new com.immersion.hapticmediasdk.b.c();
    private Object u;
    private int v;
    private int w;
    private int x;
    private long y;
    private int z;

    public com.immersion.hapticmediasdk.a.c(Context context, String s1, Handler handler, boolean flag, com.immersion.hapticmediasdk.b.d d1)
    {
        super("HapticPlaybackThread");
        m = 0;
        b = new Object();
        u = new Object();
        int i1 = i;
        switch ((i1 * (j + i1)) % k)
        {
        default:
            i = 41;
            j = 41;
            // fall through

        case 0: // '\0'
            A = false;
            break;
        }
        B = false;
        g = false;
        h = false;
        E = false;
        n = s1;
        o = handler;
        f = context;
        E = flag;
        F = new com.immersion.hapticmediasdk.b.a();
        D = d1;
        C = new ArrayList();
    }

    public static int a(com.immersion.hapticmediasdk.a.c c1, int i1)
    {
        int j1 = i;
        switch ((j1 * (j + j1)) % k)
        {
        default:
            i = 74;
            l = 41;
            // fall through

        case 0: // '\0'
            c1.v = i1;
            break;
        }
        return i1;
    }

    public static long a(com.immersion.hapticmediasdk.a.c c1, long l1)
    {
        if (((i + j) * i) % k != l)
        {
            i = 41;
            l = 90;
        }
        c1.e = l1;
        return l1;
    }

    public static com.immersion.hapticmediasdk.a.d a(com.immersion.hapticmediasdk.a.c c1, com.immersion.hapticmediasdk.a.d d1)
    {
        if (((i + j) * i) % k != l)
        {
            i = 41;
            l = 41;
        }
        c1.r = d1;
        return d1;
    }

    public static Runnable a(com.immersion.hapticmediasdk.a.c c1)
    {
        c1 = c1.G;
        if (((i + j) * i) % k != 0)
        {
            i = 41;
            l = 18;
        }
        return c1;
    }

    public static void a(com.immersion.hapticmediasdk.a.c c1, int i1, long l1)
    {
        if (((i + j) * i) % k != l)
        {
            i = 41;
            l = 45;
        }
        if (c1.B) goto _L2; else goto _L1
_L1:
        if (c1.r == null)
        {
            return;
        }
        if (c1.s != null) goto _L4; else goto _L3
_L3:
        byte abyte0[] = c1.r.b();
        if (abyte0 == null)
        {
            try
            {
                com.immersion.hapticmediasdk.b.b.a("HapticPlaybackThread", "corrupted hapt file or unsupported format");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (com.immersion.hapticmediasdk.a.c c1)
            {
                com.immersion.hapticmediasdk.b.b.a("HapticPlaybackThread", c1.getMessage());
            }
            return;
        }
        c1.s = new EndpointWarp(c1.f, abyte0, abyte0.length);
        if (c1.s == null) goto _L5; else goto _L4
_L4:
        EndpointWarp endpointwarp = c1.s;
        long l2 = endpointwarp.a;
        int j1 = EndpointWarp.b;
        (j1 * (EndpointWarp.e + j1)) % EndpointWarp.d;
        JVM INSTR tableswitch 0 0: default 260
    //                   0 174;
           goto _L6 _L7
_L6:
        EndpointWarp.b = 27;
        EndpointWarp.c = 29;
_L7:
        endpointwarp.startWarp(l2);
_L2:
        c1.h = false;
        c1.B = true;
        c1.z = 0;
        synchronized (c1.b)
        {
            c1.d = i1;
            c1.c = c1.d;
            if (c1.e != 0L)
            {
                c1.e = SystemClock.uptimeMillis();
            }
        }
        c1.y = l1;
        c1.h();
        return;
        c1;
        obj;
        JVM INSTR monitorexit ;
        throw c1;
        c1;
        throw c1;
        c1;
        throw c1;
_L5:
    }

    public static void a(com.immersion.hapticmediasdk.a.c c1, Message message)
    {
        int i1 = i;
        switch ((i1 * (i1 + 1)) % k)
        {
        default:
            i = 56;
            l = 92;
            // fall through

        case 0: // '\0'
            c1.A = true;
            break;
        }
        Message message1 = c1.o.obtainMessage(8);
        message1.setData(message.getData());
        c1.o.sendMessage(message1);
        if (((i + j) * i) % k != l)
        {
            i = 41;
            l = 41;
        }
    }

    public static int b(com.immersion.hapticmediasdk.a.c c1, int i1)
    {
        if (((i + j) * i) % 2 != l)
        {
            i = 8;
            l = 41;
        }
        try
        {
            c1.w = i1;
        }
        // Misplaced declaration of an exception variable
        catch (com.immersion.hapticmediasdk.a.c c1)
        {
            throw c1;
        }
        return i1;
    }

    public static Handler b(com.immersion.hapticmediasdk.a.c c1)
    {
        int i1;
        try
        {
            c1 = c1.a;
        }
        // Misplaced declaration of an exception variable
        catch (com.immersion.hapticmediasdk.a.c c1)
        {
            throw c1;
        }
        i1 = i;
        switch ((i1 * (j + i1)) % k)
        {
        default:
            i = 9;
            l = 62;
            // fall through

        case 0: // '\0'
            return c1;
        }
    }

    public static int c(com.immersion.hapticmediasdk.a.c c1)
    {
        if (((i + j) * i) % k != l)
        {
            i = 41;
            l = 87;
        }
        c1.x = 0;
        return 0;
    }

    public static int c(com.immersion.hapticmediasdk.a.c c1, int i1)
    {
        if (((i + j) * i) % k != l)
        {
            i = 41;
            l = 23;
        }
        c1.m = i1;
        return i1;
    }

    public static int d(com.immersion.hapticmediasdk.a.c c1, int i1)
    {
        i1 = c1.d + i1;
        if (((i + j) * i) % k != l)
        {
            i = 55;
            l = 1;
        }
        c1.d = i1;
        return i1;
    }

    public static void d(com.immersion.hapticmediasdk.a.c c1)
    {
        if (((i + j) * i) % k != l)
        {
            i = 74;
            l = 21;
        }
        if (c1.A) goto _L2; else goto _L1
_L1:
        int i1;
        i1 = c1.x;
        c1.x = i1 + 1;
        if (i1 != 5) goto _L4; else goto _L3
_L3:
        c1.o.sendMessage(c1.o.obtainMessage(7, c1.v, 0));
        c1.a.postDelayed(c1.G, 100L);
_L2:
        int j1 = i;
        switch ((j1 * (j + j1)) % k)
        {
        default:
            i = 41;
            l = 41;
            // fall through

        case 0: // '\0'
            return;
        }
_L4:
        if (c1.r != null && c1.r.b(c1.v))
        {
            if (c1.w != 0x80000000)
            {
                c1.o.sendMessage(c1.o.obtainMessage(6, c1.v, c1.w));
            }
        } else
        {
            c1.a.postDelayed(c1.G, 100L);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public static com.immersion.hapticmediasdk.a.d e(com.immersion.hapticmediasdk.a.c c1)
    {
        int i1 = i;
        switch ((i1 * (j + i1)) % k)
        {
        default:
            i = 41;
            l = 19;
            // fall through

        case 0: // '\0'
            return c1.r;
        }
    }

    public static com.immersion.hapticmediasdk.b.a f()
    {
        do
        {
        } while (true);
    }

    public static String f(com.immersion.hapticmediasdk.a.c c1)
    {
        return c1.n;
    }

    public static int g(com.immersion.hapticmediasdk.a.c c1)
    {
        return c1.m;
    }

    public static EndpointWarp g()
    {
        do
        {
        } while (true);
    }

    private void h()
    {
        if (B)
        {
            int i1;
            int j1;
            synchronized (b)
            {
                i1 = d;
                j1 = c;
            }
            a a1;
            int k1;
            long l1;
            long l2;
            long l3;
            try
            {
                obj = r.c(i1);
                k1 = r.b(i1);
                l1 = r.a(i1);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                B = false;
                o.sendMessage(o.obtainMessage(7, i1, 0));
                return;
            }
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_195;
            }
            l2 = y;
            l3 = z;
            a1 = new a(i1, j1, ((byte []) (obj)), k1, l1);
            synchronized (u)
            {
                C.add(a1);
            }
            a.postAtTime(a1, (long)m + (l3 + l2));
            z = z + m;
            t.a();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        synchronized (b)
        {
            d = 0;
            c = 0;
        }
        z = 0;
        y = 0L;
        B = false;
        return;
        exception2;
        obj1;
        JVM INSTR monitorexit ;
        throw exception2;
    }

    public static void h(com.immersion.hapticmediasdk.a.c c1)
    {
        switch (((j + 41) * 41) % k)
        {
        default:
            i = 41;
            l = 41;
            // fall through

        case 0: // '\0'
            c1.B = false;
            break;
        }
        if (c1.s != null)
        {
            c1.s.a();
        }
        c1.a.removeCallbacks(c1.G);
        c1.d();
        synchronized (c1.b)
        {
            c1.d = 0;
            c1.c = 0;
            c1.e = 0L;
        }
        c1.z = 0;
        c1.y = 0L;
        c1.h = true;
        return;
        c1;
        obj;
        JVM INSTR monitorexit ;
        throw c1;
    }

    public static void i(com.immersion.hapticmediasdk.a.c c1)
    {
        int i1 = i;
        switch ((i1 * (j + i1)) % k)
        {
        default:
            i = 25;
            l = 36;
            break;

        case 0: // '\0'
            break;
        }
        try
        {
            c1.B = false;
            c1.d();
            int j1 = i;
            switch ((j1 * (j1 + 1)) % k)
            {
            default:
                i = 41;
                l = 41;
                // fall through

            case 0: // '\0'
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (com.immersion.hapticmediasdk.a.c c1)
        {
            throw c1;
        }
    }

    public static void j(com.immersion.hapticmediasdk.a.c c1)
    {
        if (c1.p == null) goto _L2; else goto _L1
_L1:
        for (; c1.p.isAlive(); Thread.yield())
        {
            if (((i + j) * i) % k != 0)
            {
                i = 41;
                j = 65;
            }
            com.immersion.hapticmediasdk.a.b b1 = c1.p;
            if (((com.immersion.hapticmediasdk.a.b.b + com.immersion.hapticmediasdk.a.b.d) * com.immersion.hapticmediasdk.a.b.b) % com.immersion.hapticmediasdk.a.b.e != 0)
            {
                com.immersion.hapticmediasdk.a.b.b = 53;
                com.immersion.hapticmediasdk.a.b.c = 19;
            }
            b1.a = true;
            c1.p.interrupt();
            Thread.currentThread();
        }

          goto _L3
        Object obj;
        obj;
        com.immersion.hapticmediasdk.b.b.a("HapticPlaybackThread", (new StringBuilder("quit() : ")).append(((Exception) (obj)).getMessage()).toString());
        c1.g = false;
        c1.e();
_L12:
        try
        {
            throw new NullPointerException();
        }
        // Misplaced declaration of an exception variable
        catch (com.immersion.hapticmediasdk.a.c c1)
        {
            i = 41;
        }
        return;
_L3:
        c1.p = null;
_L2:
        synchronized (c1.u)
        {
            c1.a.removeCallbacksAndMessages(null);
        }
        com.immersion.hapticmediasdk.b.a a1;
        if (c1.q != null)
        {
            c1.q.quit();
            c1.q = null;
        }
        if (c1.r != null)
        {
            c1.r.c();
            c1.r = null;
        }
        if (c1.s != null)
        {
            c1.s.a();
            c1.s = null;
        }
        a1 = c1.F;
        File afile[] = (new File(a1.a())).listFiles();
        if (afile == null) goto _L5; else goto _L4
_L4:
        ((com.immersion.hapticmediasdk.b.a.c + 28) * 28) % com.immersion.hapticmediasdk.b.a.d;
        JVM INSTR tableswitch 0 0: default 452
    //                   0 293;
           goto _L6 _L7
_L7:
        break MISSING_BLOCK_LABEL_293;
_L6:
        com.immersion.hapticmediasdk.b.a.c = 63;
        int j1 = afile.length;
        int i1 = 0;
_L10:
        File file;
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        file = afile[i1];
        obj1 = file.getName();
        StringBuilder stringbuilder;
        int k1;
        stringbuilder = new StringBuilder();
        k1 = a1.a;
        boolean flag = ((String) (obj1)).endsWith(stringbuilder.append(k1).append("dat.hapt").toString());
        if (!flag) goto _L9; else goto _L8
_L8:
        file.delete();
_L9:
        i1++;
        if (true) goto _L10; else goto _L5
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
        exception;
        c1.g = false;
        c1.e();
        throw exception;
        exception;
        throw exception;
        exception;
        throw exception;
_L5:
        try
        {
            throw new NullPointerException();
        }
        catch (Exception exception1)
        {
            i = 41;
        }
        try
        {
            throw new NullPointerException();
        }
        catch (Exception exception2)
        {
            i = 41;
        }
        try
        {
            throw new NullPointerException();
        }
        catch (Exception exception3)
        {
            i = 38;
        }
        c1.g = false;
        c1.e();
        if (true) goto _L12; else goto _L11
_L11:
    }

    public static void k(com.immersion.hapticmediasdk.a.c c1)
    {
        c1.h();
        do
        {
        } while (true);
    }

    public static boolean l(com.immersion.hapticmediasdk.a.c c1)
    {
        boolean flag;
        try
        {
            flag = c1.B;
        }
        // Misplaced declaration of an exception variable
        catch (com.immersion.hapticmediasdk.a.c c1)
        {
            throw c1;
        }
        if (((i + j) * i) % k != l)
        {
            i = 41;
            l = 41;
        }
        return flag;
    }

    public static Object m(com.immersion.hapticmediasdk.a.c c1)
    {
        return c1.u;
    }

    public static ArrayList n(com.immersion.hapticmediasdk.a.c c1)
    {
        if (((i + j) * i) % k != l)
        {
            i = 41;
            l = 92;
        }
        try
        {
            c1 = c1.C;
        }
        // Misplaced declaration of an exception variable
        catch (com.immersion.hapticmediasdk.a.c c1)
        {
            throw c1;
        }
        return c1;
    }

    public static com.immersion.hapticmediasdk.b.d o(com.immersion.hapticmediasdk.a.c c1)
    {
        int i1 = i;
        switch ((i1 * (j + i1)) % k)
        {
        default:
            i = 41;
            l = 64;
            // fall through

        case 0: // '\0'
            return c1.D;
        }
    }

    public static Object p(com.immersion.hapticmediasdk.a.c c1)
    {
        if (((i + j) * i) % k != l)
        {
            i = 18;
            l = 41;
        }
        try
        {
            c1 = ((com.immersion.hapticmediasdk.a.c) (c1.b));
        }
        // Misplaced declaration of an exception variable
        catch (com.immersion.hapticmediasdk.a.c c1)
        {
            throw c1;
        }
        return c1;
    }

    public static int q(com.immersion.hapticmediasdk.a.c c1)
    {
        if (((j + 41) * 41) % k != l)
        {
            i = 41;
            l = 41;
        }
        return c1.d;
    }

    public static Runnable r(com.immersion.hapticmediasdk.a.c c1)
    {
        if (((j + 41) * 41) % k != l)
        {
            i = 41;
            l = 41;
        }
        try
        {
            c1 = c1.H;
        }
        // Misplaced declaration of an exception variable
        catch (com.immersion.hapticmediasdk.a.c c1)
        {
            throw c1;
        }
        return c1;
    }

    public final boolean a()
    {
        boolean flag = g;
        int i1 = i;
        switch ((i1 * (j + i1)) % k)
        {
        default:
            i = 69;
            l = 41;
            // fall through

        case 0: // '\0'
            return flag;
        }
    }

    public final boolean b()
    {
        boolean flag = h;
        int i1 = i;
        switch ((i1 * (i1 + 1)) % k)
        {
        default:
            i = 11;
            l = 41;
            // fall through

        case 0: // '\0'
            return flag;
        }
    }

    public final Handler c()
    {
        Handler handler;
        try
        {
            handler = a;
        }
        catch (Exception exception)
        {
            throw exception;
        }
        if (((i + j) * i) % k != l)
        {
            i = 41;
            l = 58;
        }
        return handler;
    }

    public final void d()
    {
        Object obj = u;
        obj;
        JVM INSTR monitorenter ;
        a a1;
        for (Iterator iterator = C.iterator(); iterator.hasNext(); a.removeCallbacks(a1))
        {
            a1 = (a)iterator.next();
        }

        break MISSING_BLOCK_LABEL_50;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        C.clear();
        obj;
        JVM INSTR monitorexit ;
    }

    public final void e()
    {
        this;
        JVM INSTR monitorenter ;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void run()
    {
        Process.setThreadPriority(-19);
        Looper.prepare();
        q = Looper.myLooper();
        a = JVM INSTR new #12  <Class c$c>;
        try
        {
            throw new NullPointerException();
        }
        catch (Exception exception)
        {
            i = 41;
        }
        p = new com.immersion.hapticmediasdk.a.b(n, a, E, F);
        p.start();
        g = true;
        e();
        Looper.loop();
    }
}
