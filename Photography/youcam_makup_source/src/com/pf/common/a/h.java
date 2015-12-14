// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.a;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.pf.common.utility.m;
import com.pf.common.utility.s;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.pf.common.a:
//            b, c, e

class h extends b
{

    final c a;
    private final Object b = this;
    private int c;

    h(c c1, int i)
    {
        a = c1;
        super(i, "BitmapSwap");
    }

    static Object a(h h1)
    {
        return h1.b;
    }

    static int b(h h1)
    {
        int i = h1.c - 1;
        h1.c = i;
        return i;
    }

    public void a(int i)
    {
        a.c();
        super.a(i);
        if (i < 40)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        a((i * 1000) / 16, TimeUnit.MILLISECONDS);
        return;
        InterruptedException interruptedexception;
        interruptedexception;
        m.b("BitmapSwap", "Unexpected interruption.", interruptedexception);
        return;
    }

    void a(long l, TimeUnit timeunit)
    {
        long l1;
        long l2;
        l1 = System.nanoTime();
        l2 = timeunit.toNanos(l) + l1;
        timeunit = ((TimeUnit) (b));
        timeunit;
        JVM INSTR monitorenter ;
        l = l1;
_L1:
        if (c <= 0 || l >= l2)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        TimeUnit.NANOSECONDS.timedWait(b, l2 - l);
        l = System.nanoTime();
          goto _L1
        timeunit;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        timeunit;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void a(boolean flag, e e1, Bitmap bitmap, Bitmap bitmap1)
    {
        if (flag && bitmap != null)
        {
            synchronized (b)
            {
                c = c + 1;
            }
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable(bitmap, e1) {

                final Bitmap a;
                final e b;
                final h c;

                private void a()
                {
                    int i = 0;
_L7:
                    if (i >= 10) goto _L2; else goto _L1
_L1:
                    if (!a.isRecycled()) goto _L4; else goto _L3
_L3:
                    m.e("BitmapSwap", (new StringBuilder()).append("BUG! FIX IT! A bitmap has been recycled but it is still in BitmapSwap. ").append(b).toString());
_L2:
                    return;
_L4:
                    e.a(b, a);
                    if (i <= 0) goto _L2; else goto _L5
_L5:
                    try
                    {
                        m.c("BitmapSwap", (new StringBuilder()).append("Swapped out successfully after retry ").append(i).append(" times. ").append(b).toString());
                        return;
                    }
                    catch (Throwable throwable)
                    {
                        if (i == 9)
                        {
                            m.e("BitmapSwap", (new StringBuilder()).append("Could not swap out ").append(b).toString());
                            throw s.a(throwable);
                        }
                    }
                    int j = 1 << Math.min(i, 4);
                    m.d("BitmapSwap", (new StringBuilder()).append("Failed to swap out (low memory?), retry after ").append(j).append(" seconds. ").append(b).toString());
                    com.pf.common.a.c.a(j);
                    i++;
                    if (true) goto _L7; else goto _L6
_L6:
                }

                public void run()
                {
                    a();
                    synchronized (h.a(c))
                    {
                        if (h.b(c) == 0)
                        {
                            h.a(c).notifyAll();
                        }
                    }
                    return;
                    exception;
                    obj;
                    JVM INSTR monitorexit ;
                    throw exception;
                    Exception exception1;
                    exception1;
                    synchronized (h.a(c))
                    {
                        if (h.b(c) == 0)
                        {
                            h.a(c).notifyAll();
                        }
                    }
                    throw exception1;
                    exception2;
                    obj1;
                    JVM INSTR monitorexit ;
                    throw exception2;
                }

            
            {
                c = h.this;
                a = bitmap;
                b = e1;
                super();
            }
            });
        }
        return;
        e1;
        bitmap1;
        JVM INSTR monitorexit ;
        throw e1;
    }

    protected void entryRemoved(boolean flag, Object obj, Object obj1, Object obj2)
    {
        a(flag, (e)obj, (Bitmap)obj1, (Bitmap)obj2);
    }
}
