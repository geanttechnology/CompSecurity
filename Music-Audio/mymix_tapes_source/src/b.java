// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;

public final class b extends Thread
{
    static final class a
    {

        public final Runnable a;
        public final int b;

        public a(Runnable runnable, int i)
        {
            a = runnable;
            b = i;
        }
    }


    private Handler a;
    private final ArrayList b = new ArrayList();
    private final Object c;

    public b(Object obj)
    {
        a = null;
        c = obj;
        start();
    }

    public static void a()
    {
        Looper.myLooper().quit();
    }

    public final void a(Runnable runnable, int i)
    {
        if (a != null)
        {
            if (i > 0)
            {
                a.postDelayed(runnable, i);
                return;
            } else
            {
                a.post(runnable);
                return;
            }
        } else
        {
            b.add(new a(runnable, i));
            return;
        }
    }

    public final void run()
    {
        Looper.prepare();
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        int j;
        a = new Handler();
        j = b.size();
        int i = 0;
_L2:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        a a1;
        a1 = (a)b.get(i);
        if (a1.b > 0)
        {
            a.postDelayed(a1.a, a1.b);
            break MISSING_BLOCK_LABEL_110;
        }
        a.post(a1.a);
        break MISSING_BLOCK_LABEL_110;
        Exception exception;
        exception;
        throw exception;
        b.clear();
        obj;
        JVM INSTR monitorexit ;
        Looper.loop();
        return;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
