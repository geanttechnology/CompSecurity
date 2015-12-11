// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class anl
{

    final Handler a = new ano(this);
    final anp b;
    final CopyOnWriteArraySet c = new CopyOnWriteArraySet();
    final boolean d[];
    boolean e;
    int f;
    int g;

    public anl(int j, int k, int l)
    {
        boolean flag = false;
        super();
        e = false;
        f = 1;
        d = new boolean[j];
        for (j = ((flag) ? 1 : 0); j < d.length; j++)
        {
            d[j] = true;
        }

        b = new anp(a, e, d, k, l);
    }

    public Looper a()
    {
        return b.b.getLooper();
    }

    public void a(int j, boolean flag)
    {
        if (d[1] != flag)
        {
            d[1] = flag;
            Handler handler = b.a;
            if (flag)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            handler.obtainMessage(8, 1, j).sendToTarget();
        }
    }

    public void a(long l)
    {
        b.a.obtainMessage(6, Long.valueOf(l)).sendToTarget();
    }

    void a(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1 3: default 32
    //                   1 33
    //                   2 86
    //                   3 137;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        f = message.arg1;
        message = c.iterator();
        while (message.hasNext()) 
        {
            ann ann1 = (ann)message.next();
            boolean flag = e;
            ann1.a(f);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        g = g - 1;
        if (g == 0)
        {
            message = c.iterator();
            while (message.hasNext()) 
            {
                ((ann)message.next()).a();
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        message = (ank)message.obj;
        Iterator iterator = c.iterator();
        while (iterator.hasNext()) 
        {
            ((ann)iterator.next()).a(message);
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void a(anm anm, int j, Object obj)
    {
        anp anp1 = b;
        anp1.c = anp1.c + 1;
        anp1.a.obtainMessage(9, j, 0, Pair.create(anm, obj)).sendToTarget();
    }

    public void a(ann ann1)
    {
        c.add(ann1);
    }

    public void a(boolean flag)
    {
        if (e != flag)
        {
            e = flag;
            g = g + 1;
            Handler handler = b.a;
            int j;
            if (flag)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            handler.obtainMessage(3, j, 0).sendToTarget();
            for (Iterator iterator = c.iterator(); iterator.hasNext(); ((ann)iterator.next()).a(f)) { }
        }
    }

    public transient void a(aou aaou[])
    {
        b.a.obtainMessage(1, aaou).sendToTarget();
    }

    public int b()
    {
        return f;
    }

    public void b(anm anm, int j, Object obj)
    {
        b.a(anm, 1, obj);
    }

    public boolean c()
    {
        return e;
    }

    public boolean d()
    {
        return g == 0;
    }

    public void e()
    {
        b.a.sendEmptyMessage(4);
    }

    public void f()
    {
        b.a();
        a.removeCallbacksAndMessages(null);
    }

    public long g()
    {
        anp anp1 = b;
        if (anp1.d == -1L)
        {
            return -1L;
        } else
        {
            return anp1.d / 1000L;
        }
    }

    public long h()
    {
        return b.e / 1000L;
    }

    public long i()
    {
        anp anp1 = b;
        if (anp1.f == -1L)
        {
            return -1L;
        } else
        {
            return anp1.f / 1000L;
        }
    }
}
