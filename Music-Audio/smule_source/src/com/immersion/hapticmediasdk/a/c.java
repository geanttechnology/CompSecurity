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
import c.d;
import com.immersion.content.EndpointWarp;
import com.immersion.hapticmediasdk.b.a;
import com.immersion.hapticmediasdk.b.b;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.immersion.hapticmediasdk.a:
//            d, b

public class c extends Thread
{

    public static int d = 86;
    public static int e = 1;
    public static int f = 2;
    public static int g;
    private boolean A;
    private boolean B;
    private ArrayList C;
    private com.immersion.hapticmediasdk.b.d D;
    private boolean E;
    private a F;
    private final Runnable G = new b();
    private final Runnable H = new a();
    public Context a;
    public volatile boolean b;
    public volatile boolean c;
    private int h;
    private final String i;
    private Handler j;
    private final Handler k;
    private com.immersion.hapticmediasdk.a.b l;
    private Looper m;
    private com.immersion.hapticmediasdk.a.d n;
    private EndpointWarp o;
    private final com.immersion.hapticmediasdk.b.c p = new com.immersion.hapticmediasdk.b.c();
    private Object q;
    private Object r;
    private int s;
    private int t;
    private int u;
    private long v;
    private int w;
    private int x;
    private int y;
    private long z;

    public c(Context context, String s1, Handler handler, boolean flag, com.immersion.hapticmediasdk.b.d d1)
    {
        super("HapticPlaybackThread");
        h = 0;
        q = new Object();
        r = new Object();
        int i1 = d;
        switch ((i1 * (e + i1)) % f)
        {
        default:
            d = a();
            e = a();
            // fall through

        case 0: // '\0'
            A = false;
            break;
        }
        B = false;
        b = false;
        c = false;
        E = false;
        public class b
            implements Runnable
        {

            public static int b = 2;
            public static int c = 1;
            public static int d = 2;
            public static int e;
            public final c a;

            public static int a()
            {
                return 54;
            }

            public void run()
            {
                c.c(a);
            }

            public b()
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
                int i1 = b;
                switch ((i1 * (c + i1)) % d)
                {
                default:
                    b = a();
                    c = a();
                    // fall through

                case 0: // '\0'
                    a = c.this;
                    break;
                }
                super();
            }
        }

        public class a
            implements Runnable
        {

            public static int b = 48;
            public static int c = 0;
            public static int d = 1;
            public static int e = 2;
            public final c a;

            public static int a()
            {
                return 2;
            }

            public static int b()
            {
                return 15;
            }

            public void run()
            {
                c c1;
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
                    b = b();
                    c = 40;
                }
                try
                {
                    c.k(c1);
                    return;
                }
                catch (Exception exception)
                {
                    throw exception;
                }
            }

            public a()
            {
                a = c.this;
                if (((b + d) * b) % a() != c)
                {
                    b = b();
                    c = b();
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
                super();
            }
        }

        i = s1;
        k = handler;
        a = context;
        E = flag;
        F = new a(context);
        D = d1;
        C = new ArrayList();
    }

    public static int a()
    {
        return 41;
    }

    public static int a(c c1, int i1)
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
        int j1 = d;
        switch ((j1 * (e + j1)) % f)
        {
        default:
            d = 74;
            g = a();
            // fall through

        case 0: // '\0'
            c1.s = i1;
            break;
        }
        return i1;
    }

    public static long a(c c1, long l1)
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
        if (((d + e) * d) % f != g)
        {
            d = a();
            g = 90;
        }
        c1.z = l1;
        return l1;
    }

    public static com.immersion.hapticmediasdk.a.d a(c c1, com.immersion.hapticmediasdk.a.d d1)
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
        if (((d + e) * d) % f != g)
        {
            d = a();
            g = a();
        }
        c1.n = d1;
        return d1;
    }

    public static Runnable a(c c1)
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
        c1 = c1.G;
        if (((d + e) * d) % f != b())
        {
            d = a();
            g = 18;
        }
        return c1;
    }

    private void a(Message message)
    {
        A = true;
        Message message1 = k.obtainMessage(8);
        message1.setData(message.getData());
        k.sendMessage(message1);
        if (((d + e) * d) % f != g)
        {
            d = 41;
            g = a();
        }
    }

    public static void a(c c1, int i1, long l1)
    {
        if (((d + e) * d) % f != g)
        {
            d = a();
            g = 45;
        }
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
        c1.c(i1, l1);
    }

    public static void a(c c1, Message message)
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
        int i1 = d;
        switch ((i1 * (e() + i1)) % f)
        {
        default:
            d = 56;
            g = 92;
            // fall through

        case 0: // '\0'
            c1.a(message);
            break;
        }
    }

    public static int b()
    {
        return 0;
    }

    public static int b(c c1, int i1)
    {
        if (((d + e) * d) % i() != g)
        {
            d = 8;
            g = a();
        }
        try
        {
            c1.t = i1;
        }
        // Misplaced declaration of an exception variable
        catch (c c1)
        {
            throw c1;
        }
        return i1;
    }

    public static Handler b(c c1)
    {
        int i1;
        try
        {
            c1 = c1.j;
        }
        // Misplaced declaration of an exception variable
        catch (c c1)
        {
            throw c1;
        }
        i1 = d;
        switch ((i1 * (e + i1)) % f)
        {
        default:
            d = 9;
            g = 62;
            // fall through

        case 0: // '\0'
            return c1;
        }
    }

    public static int c(c c1, int i1)
    {
        if (((d + e) * d) % f != g)
        {
            d = a();
            g = 87;
        }
        c1.u = i1;
        return i1;
    }

    private void c(int i1, long l1)
    {
        if (B)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        if (n == null)
        {
            return;
        }
        Object obj;
        if (o != null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        obj = n.b();
        if (obj == null)
        {
            try
            {
                com.immersion.hapticmediasdk.b.b.d("HapticPlaybackThread", "corrupted hapt file or unsupported format");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.immersion.hapticmediasdk.b.b.d("HapticPlaybackThread", ((Error) (obj)).getMessage());
            }
            return;
        }
        o = new EndpointWarp(a, ((byte []) (obj)), obj.length);
        if (o == null)
        {
            com.immersion.hapticmediasdk.b.b.a("HapticPlaybackThread", "Error creating endpointwarp");
            return;
        }
        o.c();
        c = false;
        B = true;
        y = 0;
        synchronized (q)
        {
            x = i1;
            w = x;
            if (z != 0L)
            {
                z = SystemClock.uptimeMillis();
            }
        }
        v = l1;
        s();
        return;
        exception;
_L2:
        1;
        JVM INSTR tableswitch 0 1: default 192
    //                   0 169
    //                   1 219;
           goto _L1 _L2 _L3
_L1:
        1;
        JVM INSTR tableswitch 0 1: default 216
    //                   0 169
    //                   1 219;
           goto _L1 _L2 _L3
_L3:
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void c(c c1)
    {
        c1.o();
        int i1 = d;
        switch ((i1 * (e + i1)) % f)
        {
        default:
            d = a();
            g = a();
            // fall through

        case 0: // '\0'
            return;
        }
    }

    public static int d(c c1, int i1)
    {
        if (((d + e) * d) % f != g)
        {
            d = a();
            g = 23;
        }
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
        c1.h = i1;
        return i1;
    }

    public static com.immersion.hapticmediasdk.a.d d(c c1)
    {
        int i1 = d;
        switch ((i1 * (e + i1)) % f)
        {
        default:
            d = a();
            g = 19;
            // fall through

        case 0: // '\0'
            c1 = c1.n;
            break;
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
        return c1;
    }

    public static int e()
    {
        return 1;
    }

    public static int e(c c1, int i1)
    {
        i1 = c1.x + i1;
        if (((d + e) * d) % f != g)
        {
            d = 55;
            g = 1;
        }
        c1.x = i1;
        return i1;
    }

    public static String e(c c1)
    {
        return c1.i;
    }

    public static int f(c c1, int i1)
    {
        throw new Runtime("d2j fail translate: java.lang.IndexOutOfBoundsException: fromIndex < 0: -1\n\tat java.util.BitSet.nextSetBit(BitSet.java:701)\n\tat com.googlecode.dex2jar.ir.ts.array.FillArrayTransformer.makeSureAllElementAreAssigned(FillArrayTransformer.java:505)\n\tat com.googlecode.dex2jar.ir.ts.array.FillArrayTransformer.transformReportChanged(FillArrayTransformer.java:123)\n\tat com.googlecode.dex2jar.ir.ts.StatedTransformer.transform(StatedTransformer.java:10)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:149)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }

    public static a f(c c1)
    {
        throw new Runtime("d2j fail translate: java.lang.IndexOutOfBoundsException: fromIndex < 0: -1\n\tat java.util.BitSet.nextSetBit(BitSet.java:701)\n\tat com.googlecode.dex2jar.ir.ts.array.FillArrayTransformer.makeSureAllElementAreAssigned(FillArrayTransformer.java:505)\n\tat com.googlecode.dex2jar.ir.ts.array.FillArrayTransformer.transformReportChanged(FillArrayTransformer.java:123)\n\tat com.googlecode.dex2jar.ir.ts.StatedTransformer.transform(StatedTransformer.java:10)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:149)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }

    public static int g(c c1)
    {
        return c1.h;
    }

    public static void h(c c1)
    {
        int i1 = a();
        switch ((i1 * (e + i1)) % f)
        {
        default:
            d = a();
            g = a();
            // fall through

        case 0: // '\0'
            c1.q();
            break;
        }
    }

    public static int i()
    {
        return 2;
    }

    public static void i(c c1)
    {
        int i1 = d;
        switch ((i1 * (e + i1)) % f)
        {
        default:
            d = 25;
            g = 36;
            break;

        case 0: // '\0'
            break;
        }
        try
        {
            c1.r();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (c c1)
        {
            throw c1;
        }
    }

    public static void j(c c1)
    {
        c1.p();
        try
        {
            throw new NullPointerException();
        }
        // Misplaced declaration of an exception variable
        catch (c c1)
        {
            d = a();
        }
    }

    public static void k(c c1)
    {
        throw new Runtime("d2j fail translate: java.lang.IndexOutOfBoundsException: fromIndex < 0: -1\n\tat java.util.BitSet.nextSetBit(BitSet.java:701)\n\tat com.googlecode.dex2jar.ir.ts.array.FillArrayTransformer.makeSureAllElementAreAssigned(FillArrayTransformer.java:505)\n\tat com.googlecode.dex2jar.ir.ts.array.FillArrayTransformer.transformReportChanged(FillArrayTransformer.java:123)\n\tat com.googlecode.dex2jar.ir.ts.StatedTransformer.transform(StatedTransformer.java:10)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:149)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }

    private void l()
    {
        do
        {
            if (!l.isAlive())
            {
                break;
            }
            if (((d + e) * d) % f != b())
            {
                d = a();
                e = 65;
            }
            l.b();
            l.interrupt();
            Thread.currentThread();
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
            Thread.yield();
        } while (true);
    }

    public static boolean l(c c1)
    {
        boolean flag;
        try
        {
            flag = c1.B;
        }
        // Misplaced declaration of an exception variable
        catch (c c1)
        {
            throw c1;
        }
        if (((d + e) * d) % f != g)
        {
            d = a();
            g = a();
        }
        return flag;
    }

    public static Object m(c c1)
    {
        return c1.r;
    }

    private void m()
    {
        if (l != null)
        {
            l();
            l = null;
        }
        synchronized (r)
        {
            j.removeCallbacksAndMessages(null);
        }
        if (m != null)
        {
            m.quit();
            m = null;
        }
        if (n != null)
        {
            n.c();
            n = null;
        }
        if (o != null)
        {
            o.d();
            o.e();
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
            o = null;
        }
        F.c();
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static ArrayList n(c c1)
    {
        if (((d + e) * d) % f != g)
        {
            d = a();
            g = 92;
        }
        try
        {
            c1 = c1.C;
        }
        // Misplaced declaration of an exception variable
        catch (c c1)
        {
            throw c1;
        }
        return c1;
    }

    private void n()
    {
        this;
        JVM INSTR monitorenter ;
_L3:
        0;
        JVM INSTR tableswitch 0 1: default 24
    //                   0 51
    //                   1 2;
           goto _L1 _L2 _L3
_L1:
        0;
        JVM INSTR tableswitch 0 1: default 48
    //                   0 51
    //                   1 2;
           goto _L1 _L2 _L3
_L2:
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

    public static com.immersion.hapticmediasdk.b.d o(c c1)
    {
        int i1 = d;
        switch ((i1 * (e + i1)) % f)
        {
        default:
            d = a();
            g = 64;
            break;

        case 0: // '\0'
            break;
        }
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
        return c1.D;
    }

    private void o()
    {
        if (((d + e) * d) % f != g)
        {
            d = 74;
            g = 21;
        }
        if (!A)
        {
            int i1 = u;
            u = i1 + 1;
            if (i1 == 5)
            {
                k.sendMessage(k.obtainMessage(7, s, 0));
                j.postDelayed(G, 100L);
            } else
            if (n != null && n.b(s))
            {
                if (t != 0x80000000)
                {
                    k.sendMessage(k.obtainMessage(6, s, t));
                    return;
                }
            } else
            {
                j.postDelayed(G, 100L);
                return;
            }
        }
    }

    public static EndpointWarp p(c c1)
    {
        throw new Runtime("d2j fail translate: java.lang.IndexOutOfBoundsException: fromIndex < 0: -1\n\tat java.util.BitSet.nextSetBit(BitSet.java:701)\n\tat com.googlecode.dex2jar.ir.ts.array.FillArrayTransformer.makeSureAllElementAreAssigned(FillArrayTransformer.java:505)\n\tat com.googlecode.dex2jar.ir.ts.array.FillArrayTransformer.transformReportChanged(FillArrayTransformer.java:123)\n\tat com.googlecode.dex2jar.ir.ts.StatedTransformer.transform(StatedTransformer.java:10)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:149)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }

    private void p()
    {
        m();
        try
        {
            throw new NullPointerException();
        }
        catch (Exception exception)
        {
            d = a();
        }
        try
        {
            throw new NullPointerException();
        }
        catch (Exception exception1)
        {
            d = a();
        }
        try
        {
            throw new NullPointerException();
        }
        catch (Exception exception2)
        {
            d = 38;
        }
        b = false;
        n();
        return;
_L6:
        b = false;
        n();
        return;
        Object obj;
        obj;
        com.immersion.hapticmediasdk.b.b.d("HapticPlaybackThread", (new StringBuilder()).append("quit() : ").append(((Exception) (obj)).getMessage()).toString());
_L4:
        switch (0)
        {
        case 0: // '\0'
            break; /* Loop/switch isn't completed */

        case 1: // '\001'
            continue; /* Loop/switch isn't completed */
        }
_L2:
        switch (1)
        {
        default:
            continue; /* Loop/switch isn't completed */

        case 0: // '\0'
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */
        }
        break; /* Loop/switch isn't completed */
        obj;
        b = false;
        n();
        throw obj;
        if (true) goto _L2; else goto _L1
_L1:
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static Object q(c c1)
    {
        if (((d + e) * d) % f != g)
        {
            d = 18;
            g = a();
        }
        try
        {
            c1 = ((c) (c1.q));
        }
        // Misplaced declaration of an exception variable
        catch (c c1)
        {
            throw c1;
        }
        return c1;
    }

    private void q()
    {
        B = false;
        if (o != null)
        {
            o.d();
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
        j.removeCallbacks(G);
        j();
        synchronized (q)
        {
            x = 0;
            w = 0;
            z = 0L;
        }
        y = 0;
        v = 0L;
        c = true;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static int r(c c1)
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
        if (((a() + e) * a()) % f != g)
        {
            d = a();
            g = a();
        }
        return c1.x;
    }

    private void r()
    {
        B = false;
        j();
        int i1 = d;
        switch ((i1 * (e() + i1)) % f)
        {
        default:
            d = a();
            g = a();
            // fall through

        case 0: // '\0'
            return;
        }
    }

    public static Runnable s(c c1)
    {
        if (((a() + e) * a()) % f != g)
        {
            d = a();
            g = a();
        }
        try
        {
            c1 = c1.H;
        }
        // Misplaced declaration of an exception variable
        catch (c c1)
        {
            throw c1;
        }
        return c1;
    }

    private void s()
    {
        if (!B)
        {
            break MISSING_BLOCK_LABEL_208;
        }
        int i1;
        int j1;
        synchronized (q)
        {
            i1 = x;
            j1 = w;
        }
        c.a a1;
        int k1;
        long l1;
        long l2;
        long l3;
        try
        {
            obj = n.c(i1);
            k1 = n.b(i1);
            l1 = n.a(i1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            B = false;
            k.sendMessage(k.obtainMessage(7, i1, 0));
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        l2 = v;
        l3 = y;
        a1 = new c.a(this, i1, j1, ((byte []) (obj)), k1, l1);
        obj = r;
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
        obj;
        JVM INSTR monitorenter ;
        C.add(a1);
        obj;
        JVM INSTR monitorexit ;
        j.postAtTime(a1, (long)h + (l3 + l2));
        y = y + h;
        p.b();
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        Exception exception1;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        synchronized (q)
        {
            x = 0;
            w = 0;
        }
        y = 0;
        v = 0L;
        B = false;
        return;
        exception2;
        obj1;
        JVM INSTR monitorexit ;
        throw exception2;
    }

    public void a(int i1, int j1)
    {
        j.removeMessages(1);
        j.sendMessage(j.obtainMessage(1, i1, j1));
    }

    public void a(int i1, long l1)
    {
        boolean flag = false;
        j();
        j.removeMessages(2);
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
        Bundle bundle = new Bundle();
        bundle.putInt("playback_timecode", i1);
        bundle.putLong("playback_uptime", l1);
        Message message = j.obtainMessage(2);
        try
        {
            throw new NullPointerException();
        }
        catch (Exception exception)
        {
            d = 75;
        }
        i1 = ((flag) ? 1 : 0);
        Exception exception1;
        try
        {
            do
            {
                i1 /= 0;
            } while (true);
        }
        catch (Exception exception2)
        {
            d = a();
        }
        break MISSING_BLOCK_LABEL_162;
        exception1;
        d = 38;
        message.setData(bundle);
        j.sendMessage(message);
        return;
        throw new NullPointerException();
    }

    public void b(int i1, long l1)
    {
        Object obj = q;
        obj;
        JVM INSTR monitorenter ;
        long l2 = SystemClock.uptimeMillis();
        i1 = (int)((long)i1 + (l2 - l1));
        int j1;
        j1 = x;
        j1 = i1 - ((int)(l2 - z) + j1);
        if (50 >= Math.abs(j1)) goto _L2; else goto _L1
_L1:
        x = j1 + x;
          goto _L3
_L8:
        w = x;
        j.sendMessage(j.obtainMessage(1, i1, 0x80000000));
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L3:
        0;
        JVM INSTR tableswitch 0 1: default 132
    //                   0 68
    //                   1 108;
           goto _L4 _L5 _L3
_L5:
        continue; /* Loop/switch isn't completed */
_L4:
        1;
        JVM INSTR tableswitch 0 1: default 156
    //                   0 108
    //                   1 68;
           goto _L4 _L3 _L6
_L6:
        if (true) goto _L8; else goto _L7
_L7:
    }

    public boolean c()
    {
        boolean flag = b;
        int i1 = d;
        switch ((i1 * (e + i1)) % f)
        {
        default:
            d = 69;
            g = a();
            // fall through

        case 0: // '\0'
            return flag;
        }
    }

    public boolean d()
    {
        boolean flag = c;
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
        int i1 = d;
        switch ((i1 * (e() + i1)) % f)
        {
        default:
            d = 11;
            g = a();
            // fall through

        case 0: // '\0'
            return flag;
        }
    }

    public Handler f()
    {
        Handler handler;
        try
        {
            handler = j;
        }
        catch (Exception exception)
        {
            throw exception;
        }
        if (((d + e) * d) % f != g)
        {
            d = a();
            g = 58;
        }
        return handler;
    }

    public void g()
    {
        int i1;
        try
        {
            j.sendEmptyMessage(4);
        }
        catch (Exception exception)
        {
            throw exception;
        }
        i1 = d;
        switch ((i1 * (e + i1)) % f)
        {
        default:
            d = 35;
            g = 24;
            // fall through

        case 0: // '\0'
            return;
        }
    }

    public void h()
    {
        if (((d + e) * d) % i() != b())
        {
            d = 98;
            g = 68;
        }
        j.sendEmptyMessage(5);
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
    }

    public void j()
    {
        Object obj = r;
        obj;
        JVM INSTR monitorenter ;
        c.a a1;
        for (Iterator iterator = C.iterator(); iterator.hasNext(); j.removeCallbacks(a1))
        {
            a1 = (c.a)iterator.next();
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

    public void k()
    {
        boolean flag;
        try
        {
            flag = j.sendEmptyMessage(9);
        }
        catch (Exception exception)
        {
            throw exception;
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        if (((d + e()) * d) % f != g)
        {
            d = a();
            g = 16;
        }
        b = false;
        n();
        return;
        Exception exception1;
        exception1;
        throw exception1;
    }

    public void run()
    {
        Process.setThreadPriority(-19);
        Looper.prepare();
        m = Looper.myLooper();
        j = new d(this, null);
        try
        {
            throw new NullPointerException();
        }
        catch (Exception exception)
        {
            d = a();
        }
        l = new com.immersion.hapticmediasdk.a.b(i, j, E, F);
        l.start();
        b = true;
        n();
        Looper.loop();
    }
}
