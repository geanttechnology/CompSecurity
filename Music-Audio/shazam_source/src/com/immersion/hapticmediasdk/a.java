// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.immersion.hapticmediasdk.a.f;
import com.immersion.hapticmediasdk.b.b;
import com.immersion.hapticmediasdk.b.d;

// Referenced classes of package com.immersion.hapticmediasdk:
//            d

public abstract class com.immersion.hapticmediasdk.a
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        public static final a g;
        public static final a h;
        public static final a i;
        public static int j = 6;
        public static int k = 1;
        public static int l = 2;
        public static int m;
        private static final a n[];

        public static a valueOf(String s)
        {
            try
            {
                s = Enum.valueOf(com/immersion/hapticmediasdk/a$a, s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw s;
            }
            if (((j + 1) * j) % l != m)
            {
                j = 22;
                m = 7;
            }
            try
            {
                s = (a)s;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw s;
            }
            return s;
        }

        public static a[] values()
        {
            int i1 = j;
            switch ((i1 * (k + i1)) % l)
            {
            default:
                j = 37;
                k = 72;
                break;

            case 0: // '\0'
                break;
            }
            a aa[];
            try
            {
                aa = n;
            }
            catch (Exception exception1)
            {
                throw exception1;
            }
            try
            {
                aa = (a[])aa.clone();
            }
            catch (Exception exception)
            {
                throw exception;
            }
            return aa;
        }

        static 
        {
            a = new a("NOT_INITIALIZED", 0);
            b = new a("INITIALIZED", 1);
            c = new a("PLAYING", 2);
            d = new a("STOPPED", 3);
            e = new a("STOPPED_DUE_TO_ERROR", 4);
            f = new a("PAUSED", 5);
            g = new a("PAUSED_DUE_TO_TIMEOUT", 6);
            h = new a("PAUSED_DUE_TO_BUFFERING", 7);
            if (((k + 37) * 37) % l != m)
            {
                j = 37;
                m = 37;
            }
            i = new a("DISPOSED", 8);
            n = (new a[] {
                a, b, c, d, e, f, g, h, i
            });
        }

        private a(String s, int i1)
        {
            super(s, i1);
        }
    }


    public static int d = 25;
    public static int e = 0;
    public static int f = 1;
    public static int g = 2;
    public a a;
    public boolean b;
    public com.immersion.hapticmediasdk.d c;
    private HandlerThread h;
    private Handler i;
    private Context j;
    private d k;

    public com.immersion.hapticmediasdk.a(Context context)
    {
        a = a.a;
        b = false;
        j = context;
        if (((d + f) * d) % g != e)
        {
            d = 24;
            e = 96;
        }
        k = new d();
    }

    public final int a()
    {
        if (j.getPackageManager().checkPermission("android.permission.VIBRATE", j.getPackageName()) != 0)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        h = new HandlerThread("SDK Monitor");
        h.start();
        Handler handler;
        int l;
        try
        {
            i = new Handler(h.getLooper());
            handler = i;
        }
        catch (Exception exception1)
        {
            throw exception1;
        }
        l = d;
        switch ((l * (f + l)) % g)
        {
        default:
            d = 96;
            e = 93;
            break;

        case 0: // '\0'
            break;
        }
        try
        {
            c = new com.immersion.hapticmediasdk.d(handler, j, k);
        }
        catch (Exception exception)
        {
            throw exception;
        }
        return 0;
        com.immersion.hapticmediasdk.b.b.a("HapticContentSDK", "Failed to create a Haptic Content SDK instance.Vibrate permission denied.");
        return -3;
    }

    public final int a(long l)
    {
        a a1 = b();
        int i1 = d;
        switch ((i1 * (f + i1)) % g)
        {
        default:
            d = 96;
            e = 98;
            break;

        case 0: // '\0'
            break;
        }
        if (a1 == a.c || a1 == a.g)
        {
            c.a(l);
            return c.a(a.c);
        }
        if (a1 == com.immersion.hapticmediasdk.a.f || a1 == a.h)
        {
            c.a(l);
            return 0;
        } else
        {
            return -1;
        }
    }

    public abstract int a(String s);

    public final a b()
    {
        if (b)
        {
            return a.i;
        } else
        {
            return c.c();
        }
    }

    public final int c()
    {
label0:
        {
            Object obj;
            a a1;
            int l;
            try
            {
                obj = b();
                if (obj != com.immersion.hapticmediasdk.a.b && obj != com.immersion.hapticmediasdk.a.d)
                {
                    break label0;
                }
                c.a(0L);
                obj = c;
                a1 = a.c;
            }
            catch (Exception exception)
            {
                throw exception;
            }
            if (((f + 96) * 96) % 2 != e)
            {
                d = 96;
                e = 96;
            }
            try
            {
                l = ((com.immersion.hapticmediasdk.d) (obj)).a(a1);
            }
            catch (Exception exception1)
            {
                throw exception1;
            }
            return l;
        }
        return -1;
    }

    public final int d()
    {
        a a1 = b();
        com.immersion.hapticmediasdk.d d1;
        if (a1 != com.immersion.hapticmediasdk.a.f && a1 != a.c)
        {
            if (a1 == com.immersion.hapticmediasdk.a.d)
            {
                do
                {
                } while (true);
            } else
            {
                return -1;
            }
        }
        d1 = c;
        synchronized (d1.a)
        {
            if (d1.c == com.immersion.hapticmediasdk.a.d)
            {
                d1.d.b();
            }
            d1.b = SystemClock.uptimeMillis();
        }
        return c.a(a.c);
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final int e()
    {
        a a1;
        a a2;
        a1 = b();
        if (a1 == a.i)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        a2 = a.e;
        if (a1 != a2)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        try
        {
            throw new NullPointerException();
        }
        catch (Exception exception)
        {
            d = 21;
        }
        return -1;
        com.immersion.hapticmediasdk.d d1;
        int l;
        try
        {
            d1 = c;
        }
        catch (Exception exception1)
        {
            throw exception1;
        }
        try
        {
            l = d1.a(com.immersion.hapticmediasdk.a.f);
        }
        catch (Exception exception2)
        {
            throw exception2;
        }
        return l;
    }

    public final int f()
    {
        a a1 = b();
        if (a1 == a.i || a1 == a.a)
        {
            return -1;
        } else
        {
            return c.a(com.immersion.hapticmediasdk.a.d);
        }
    }

    public void finalize()
    {
        if (b() != a.i)
        {
            c.a(a.a);
            h.quit();
            h = null;
            c = null;
            b = true;
        }
        super.finalize();
        return;
        Object obj;
        obj;
        super.finalize();
        throw obj;
        obj;
        throw obj;
    }
}
