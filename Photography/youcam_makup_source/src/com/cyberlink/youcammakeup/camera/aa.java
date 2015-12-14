// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.graphics.PointF;
import android.os.Handler;
import android.os.HandlerThread;
import com.cyberlink.clgpuimage.CLMakeupLiveFilter;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierManager;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            ab, y

class aa extends HandlerThread
{

    final y a;
    private Handler b;
    private ab c;
    private boolean d;
    private ab e;
    private boolean f;

    aa(y y1)
    {
        a = y1;
        super("FrameProcessingHandlerThread");
        b = null;
        c = new ab(this);
        d = false;
        e = new ab(this);
        f = false;
        start();
        b = new Handler(getLooper());
    }

    static ab a(aa aa1)
    {
        return aa1.e;
    }

    static ab a(aa aa1, ab ab1)
    {
        aa1.c = ab1;
        return ab1;
    }

    static boolean a(aa aa1, boolean flag)
    {
        aa1.f = flag;
        return flag;
    }

    static ab b(aa aa1, ab ab1)
    {
        aa1.e = ab1;
        return ab1;
    }

    static boolean b(aa aa1)
    {
        return aa1.d;
    }

    static boolean b(aa aa1, boolean flag)
    {
        aa1.d = flag;
        return flag;
    }

    static ab c(aa aa1)
    {
        return aa1.c;
    }

    void a()
    {
        this;
        JVM INSTR monitorenter ;
        b.post(new Runnable() {

            final aa a;

            public void run()
            {
                ab ab1 = aa.a(a);
                ab1;
                JVM INSTR monitorenter ;
                aa.a(a, true);
_L1:
                if (!aa.b(a))
                {
                    break MISSING_BLOCK_LABEL_135;
                }
                synchronized (aa.c(a))
                {
                    ab ab2 = aa.c(a);
                    aa.a(a, aa.a(a));
                    aa.b(a, ab2);
                    aa.b(a, false);
                }
                a.a.a(aa.a(a).c, aa.a(a).a, aa.a(a).b);
                  goto _L1
                obj;
                ab1;
                JVM INSTR monitorexit ;
                throw obj;
                exception1;
                obj;
                JVM INSTR monitorexit ;
                throw exception1;
                aa.a(a, false);
                ab1;
                JVM INSTR monitorexit ;
            }

            
            {
                a = aa.this;
                super();
            }
        });
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    void a(byte abyte0[], int i, int j)
    {
        if (!y.d(a).get())
        {
            int k = Math.min(y.b(a).height, y.b(a).width) / 2;
            int l = (k * 2) / 3;
            PointF apointf[] = new PointF[4];
            apointf[0] = new PointF(142F, 143.5F);
            apointf[1] = new PointF(229F, 106.5F);
            apointf[2] = new PointF(316.5F, 143.5F);
            apointf[3] = new PointF(229F, 181F);
            y.e(a).a(450, 300, apointf, k, l, 2);
            synchronized (y.f(a))
            {
                y.f(a).a(apointf, 450, 300);
            }
            y.d(a).set(true);
        }
        synchronized (c)
        {
            if (c.a != i || c.b != j || c.c.length != abyte0.length)
            {
                c.a = i;
                c.b = j;
                c.c = new byte[abyte0.length];
            }
            System.arraycopy(abyte0, 0, c.c, 0, abyte0.length);
            d = true;
        }
        if (!f)
        {
            a();
        }
        return;
        abyte0;
        obj;
        JVM INSTR monitorexit ;
        throw abyte0;
        abyte0;
        obj;
        JVM INSTR monitorexit ;
        throw abyte0;
    }
}
