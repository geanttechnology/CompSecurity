// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.atomic.AtomicReference;

final class ckc extends HandlerThread
{

    final Runnable a;
    Handler b;
    int c;
    volatile int d;
    private cjx e;

    public ckc(cjx cjx1)
    {
        e = cjx1;
        super("YouTubePlayer.ProgressDetector");
        a = new ckd(this, cjx1);
    }

    static void a(ckc ckc1)
    {
        cjv cjv1 = (cjv)cjx.w(ckc1.e).get();
        if (cjv1 != null && cjx.t(ckc1.e) && cjv1.e() > ckc1.c)
        {
            ckc1.b();
            return;
        } else
        {
            ckc1.b.postDelayed(ckc1.a, 1000L);
            return;
        }
    }

    public final void a()
    {
        this;
        JVM INSTR monitorenter ;
        d = d + 1;
        int i = d;
        bmo.c((new StringBuilder(63)).append("Retrying MediaPlayer error [retry=").append(i).append(", max=3").append("]").toString());
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void b()
    {
        d = 0;
        b.removeCallbacksAndMessages(null);
    }

    public final boolean quit()
    {
        b.removeCallbacksAndMessages(null);
        return super.quit();
    }

    public final void start()
    {
        super.start();
        b = new Handler(getLooper());
    }
}
