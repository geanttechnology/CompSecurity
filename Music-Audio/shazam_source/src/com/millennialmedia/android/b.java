// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.millennialmedia.android:
//            r, v, a

final class b
{
    private final class a
        implements Comparable, Runnable
    {

        final b a;
        private WeakReference b;
        private String c;
        private r d;
        private WeakReference e;

        public final volatile int compareTo(Object obj)
        {
            obj = (a)obj;
            return d.f - ((a) (obj)).d.f;
        }

        public final boolean equals(Object obj)
        {
            if (this == obj)
            {
                return true;
            }
            if (!(obj instanceof a))
            {
                return false;
            } else
            {
                obj = (a)obj;
                return d.equals(((a) (obj)).d);
            }
        }

        public final void run()
        {
            String s;
            Context context;
            a.a a1;
            String s1;
            boolean flag;
            if (e != null)
            {
                a1 = (a.a)e.get();
            } else
            {
                a1 = null;
            }
            if (a1 != null)
            {
                a1.a();
            }
            v.a((Context)b.get()).c(c);
            flag = d.a((Context)b.get());
            v.a((Context)b.get()).d(c);
            if (flag)
            {
                break MISSING_BLOCK_LABEL_226;
            }
            s = com.millennialmedia.android.a.d((Context)b.get(), c);
            if (s == null || !d.a.equals(s)) goto _L2; else goto _L1
_L1:
            d.b((Context)b.get());
            context = (Context)b.get();
            s = c;
_L4:
            s1 = null;
_L5:
            com.millennialmedia.android.a.b(context, s, s1);
_L6:
            if (a1 != null)
            {
                a1.a(d, flag);
            }
            return;
_L2:
            context = (Context)b.get();
            s = c;
            if (d.g) goto _L4; else goto _L3
_L3:
            s1 = d.a;
              goto _L5
            com.millennialmedia.android.a.b((Context)b.get(), c, null);
              goto _L6
        }

        a(Context context, String s, r r1, a.a a1)
        {
            a = b.this;
            super();
            b = new WeakReference(context.getApplicationContext());
            c = s;
            d = r1;
            if (a1 != null)
            {
                e = new WeakReference(a1);
            }
        }
    }


    private static b a;
    private PriorityBlockingQueue b;
    private ThreadPoolExecutor c;

    private b()
    {
        TimeUnit timeunit = TimeUnit.SECONDS;
        PriorityBlockingQueue priorityblockingqueue = new PriorityBlockingQueue(32);
        b = priorityblockingqueue;
        c = new ThreadPoolExecutor(1, 2, 30L, timeunit, priorityblockingqueue);
    }

    static b a()
    {
        com/millennialmedia/android/b;
        JVM INSTR monitorenter ;
        b b1;
        if (a == null)
        {
            a = new b();
        }
        b1 = a;
        com/millennialmedia/android/b;
        JVM INSTR monitorexit ;
        return b1;
        Exception exception;
        exception;
        throw exception;
    }

    final boolean a(Context context, String s, r r1, a.a a1)
    {
        this;
        JVM INSTR monitorenter ;
        if (context == null || r1 == null) goto _L2; else goto _L1
_L1:
        s = new a(context, s, r1, a1);
        if (b.contains(s) || r1.c(context)) goto _L2; else goto _L3
_L3:
        c.execute(s);
        boolean flag = true;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
        context;
        throw context;
    }
}
