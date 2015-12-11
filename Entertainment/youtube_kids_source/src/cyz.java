// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

public final class cyz
{

    final czc a;
    final Executor b;
    final bmi c;
    volatile boolean d;
    public volatile czg e;
    public volatile cyx f;
    public boolean g;
    public final LinkedBlockingQueue h = new LinkedBlockingQueue();
    private final Runnable i = new cza(this);

    public cyz(Executor executor, czc czc, bmi bmi)
    {
        a = new czd(this, czc);
        b = executor;
        c = bmi;
        d = false;
    }

    void a()
    {
        a(i);
    }

    public void a(Runnable runnable)
    {
        boolean flag;
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            runnable.run();
            return;
        } else
        {
            b.execute(runnable);
            return;
        }
    }

    public final void a(boolean flag)
    {
        d = flag;
        a();
    }
}
