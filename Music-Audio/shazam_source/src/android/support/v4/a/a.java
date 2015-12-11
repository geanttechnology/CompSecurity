// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.a;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.f.j;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

// Referenced classes of package android.support.v4.a:
//            d, f

public abstract class android.support.v4.a.a extends d
{
    final class a extends f
        implements Runnable
    {

        Object a;
        boolean b;
        final android.support.v4.a.a c;
        private CountDownLatch h;

        protected final void a()
        {
            c.a(this);
            h.countDown();
            return;
            Exception exception;
            exception;
            h.countDown();
            throw exception;
        }

        protected final void a(Object obj)
        {
            android.support.v4.a.a a1 = c;
            if (a1.a == this) goto _L2; else goto _L1
_L1:
            a1.a(this);
_L4:
            h.countDown();
            return;
_L2:
            if (((d) (a1)).j) goto _L4; else goto _L3
_L3:
            a1.m = false;
            a1.d = SystemClock.uptimeMillis();
            a1.a = null;
            a1.a(obj);
              goto _L4
            obj;
            h.countDown();
            throw obj;
        }

        protected final Object b()
        {
            a = c.c();
            return a;
        }

        public final void run()
        {
            b = false;
            c.b();
        }

        a()
        {
            c = android.support.v4.a.a.this;
            super();
            h = new CountDownLatch(1);
        }
    }


    volatile a a;
    volatile a b;
    long c;
    long d;
    Handler e;

    public android.support.v4.a.a(Context context)
    {
        super(context);
        d = -10000L;
    }

    protected final void a()
    {
        super.a();
        if (a == null) goto _L2; else goto _L1
_L1:
        if (b == null) goto _L4; else goto _L3
_L3:
        if (a.b)
        {
            a.b = false;
            e.removeCallbacks(a);
        }
        a = null;
_L2:
        a = new a();
        b();
        return;
_L4:
        if (!a.b)
        {
            break; /* Loop/switch isn't completed */
        }
        a.b = false;
        e.removeCallbacks(a);
_L7:
        a = null;
        if (true) goto _L2; else goto _L5
_L5:
        if (!((f) (a)).f.cancel(false)) goto _L7; else goto _L6
_L6:
        b = a;
          goto _L7
    }

    final void a(a a1)
    {
        if (b == a1)
        {
            if (super.m)
            {
                super.l = true;
            }
            d = SystemClock.uptimeMillis();
            b = null;
            b();
        }
    }

    public void a(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        super.a(s, filedescriptor, printwriter, as);
        if (a != null)
        {
            printwriter.print(s);
            printwriter.print("mTask=");
            printwriter.print(a);
            printwriter.print(" waiting=");
            printwriter.println(a.b);
        }
        if (b != null)
        {
            printwriter.print(s);
            printwriter.print("mCancellingTask=");
            printwriter.print(b);
            printwriter.print(" waiting=");
            printwriter.println(b.b);
        }
        if (c != 0L)
        {
            printwriter.print(s);
            printwriter.print("mUpdateThrottle=");
            j.a(c, printwriter);
            printwriter.print(" mLastLoadCompleteTime=");
            j.a(d, SystemClock.uptimeMillis(), printwriter);
            printwriter.println();
        }
    }

    final void b()
    {
        a a1;
        Executor executor;
label0:
        {
            if (b == null && a != null)
            {
                if (a.b)
                {
                    a.b = false;
                    e.removeCallbacks(a);
                }
                if (c <= 0L || SystemClock.uptimeMillis() >= d + c)
                {
                    break label0;
                }
                a.b = true;
                e.postAtTime(a, d + c);
            }
            return;
        }
        a1 = a;
        executor = f.d;
        if (((f) (a1)).g == f.c.a) goto _L2; else goto _L1
_L1:
        f._cls4.a[((f) (a1)).g.ordinal()];
        JVM INSTR tableswitch 1 2: default 152
    //                   1 178
    //                   2 188;
           goto _L2 _L3 _L4
_L2:
        a1.g = f.c.b;
        ((f) (a1)).e.b = null;
        executor.execute(((f) (a1)).f);
        return;
_L3:
        throw new IllegalStateException("Cannot execute task: the task is already running.");
_L4:
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    }

    public abstract Object c();
}
