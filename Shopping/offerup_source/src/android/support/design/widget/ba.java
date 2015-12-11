// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

// Referenced classes of package android.support.design.widget:
//            bb, bd, bc

final class ba
{

    private static ba a;
    private final Object b = new Object();
    private final Handler c = new Handler(Looper.getMainLooper(), new bb(this));
    private bd d;
    private bd e;

    private ba()
    {
    }

    static ba a()
    {
        if (a == null)
        {
            a = new ba();
        }
        return a;
    }

    static void a(ba ba1, bd bd1)
    {
        synchronized (ba1.b)
        {
            if (ba1.d == bd1 || ba1.e == bd1)
            {
                a(bd1, 2);
            }
        }
        return;
        ba1;
        obj;
        JVM INSTR monitorexit ;
        throw ba1;
    }

    private void a(bd bd1)
    {
        int i;
        if (bd.b(bd1) == -2)
        {
            return;
        }
        i = 2750;
        if (bd.b(bd1) <= 0) goto _L2; else goto _L1
_L1:
        i = bd.b(bd1);
_L4:
        c.removeCallbacksAndMessages(bd1);
        c.sendMessageDelayed(Message.obtain(c, 0, bd1), i);
        return;
_L2:
        if (bd.b(bd1) == -1)
        {
            i = 1500;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static boolean a(bd bd1, int i)
    {
        bd1 = (bc)bd.a(bd1).get();
        if (bd1 != null)
        {
            bd1.a(i);
            return true;
        } else
        {
            return false;
        }
    }

    private void b()
    {
label0:
        {
            if (e != null)
            {
                d = e;
                e = null;
                bc bc1 = (bc)bd.a(d).get();
                if (bc1 == null)
                {
                    break label0;
                }
                bc1.a();
            }
            return;
        }
        d = null;
    }

    private boolean e(bc bc1)
    {
        return d != null && d.a(bc1);
    }

    private boolean f(bc bc1)
    {
        return e != null && e.a(bc1);
    }

    public final void a(int i, bc bc1)
    {
label0:
        {
            synchronized (b)
            {
                if (!e(bc1))
                {
                    break label0;
                }
                bd.a(d, i);
                c.removeCallbacksAndMessages(d);
                a(d);
            }
            return;
        }
        if (!f(bc1))
        {
            break MISSING_BLOCK_LABEL_89;
        }
        bd.a(e, i);
_L1:
        if (d == null || !a(d, 4))
        {
            break MISSING_BLOCK_LABEL_105;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        bc1;
        obj;
        JVM INSTR monitorexit ;
        throw bc1;
        e = new bd(i, bc1);
          goto _L1
        d = null;
        b();
        obj;
        JVM INSTR monitorexit ;
    }

    public final void a(bc bc1)
    {
        synchronized (b)
        {
            if (e(bc1))
            {
                d = null;
                if (e != null)
                {
                    b();
                }
            }
        }
        return;
        bc1;
        obj;
        JVM INSTR monitorexit ;
        throw bc1;
    }

    public final void a(bc bc1, int i)
    {
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        if (!e(bc1)) goto _L2; else goto _L1
_L1:
        a(d, i);
_L4:
        return;
_L2:
        if (f(bc1))
        {
            a(e, i);
        }
        if (true) goto _L4; else goto _L3
_L3:
        bc1;
        obj;
        JVM INSTR monitorexit ;
        throw bc1;
    }

    public final void b(bc bc1)
    {
        synchronized (b)
        {
            if (e(bc1))
            {
                a(d);
            }
        }
        return;
        bc1;
        obj;
        JVM INSTR monitorexit ;
        throw bc1;
    }

    public final void c(bc bc1)
    {
        synchronized (b)
        {
            if (e(bc1))
            {
                c.removeCallbacksAndMessages(d);
            }
        }
        return;
        bc1;
        obj;
        JVM INSTR monitorexit ;
        throw bc1;
    }

    public final void d(bc bc1)
    {
        synchronized (b)
        {
            if (e(bc1))
            {
                a(d);
            }
        }
        return;
        bc1;
        obj;
        JVM INSTR monitorexit ;
        throw bc1;
    }
}
