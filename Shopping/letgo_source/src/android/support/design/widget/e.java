// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class e
{
    static interface a
    {

        public abstract void a();

        public abstract void b();
    }

    private static class b
    {

        private final WeakReference a;
        private int b;

        static WeakReference a(b b1)
        {
            return b1.a;
        }

        static int b(b b1)
        {
            return b1.b;
        }

        boolean a(a a1)
        {
            return a1 != null && a.get() == a1;
        }
    }


    private static e a;
    private final Object b = new Object();
    private final Handler c = new Handler(Looper.getMainLooper(), new android.os.Handler.Callback() {

        final e a;

        public boolean handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                return false;

            case 0: // '\0'
                e.a(a, (b)message.obj);
                break;
            }
            return true;
        }

            
            {
                a = e.this;
                super();
            }
    });
    private b d;
    private b e;

    private e()
    {
    }

    static e a()
    {
        if (a == null)
        {
            a = new e();
        }
        return a;
    }

    static void a(e e1, b b1)
    {
        e1.c(b1);
    }

    private boolean a(b b1)
    {
        b1 = (a)b.a(b1).get();
        if (b1 != null)
        {
            b1.b();
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
                a a1 = (a)b.a(d).get();
                if (a1 == null)
                {
                    break label0;
                }
                a1.a();
            }
            return;
        }
        d = null;
    }

    private void b(b b1)
    {
        c.removeCallbacksAndMessages(b1);
        Handler handler = c;
        Message message = Message.obtain(c, 0, b1);
        long l;
        if (b.b(b1) == 0)
        {
            l = 2750L;
        } else
        {
            l = 1500L;
        }
        handler.sendMessageDelayed(message, l);
    }

    private void c(b b1)
    {
        synchronized (b)
        {
            if (d == b1 || e == b1)
            {
                a(b1);
            }
        }
        return;
        b1;
        obj;
        JVM INSTR monitorexit ;
        throw b1;
    }

    private boolean f(a a1)
    {
        return d != null && d.a(a1);
    }

    private boolean g(a a1)
    {
        return e != null && e.a(a1);
    }

    public void a(a a1)
    {
        synchronized (b)
        {
            if (f(a1))
            {
                a(d);
            }
            if (g(a1))
            {
                a(e);
            }
        }
        return;
        a1;
        obj;
        JVM INSTR monitorexit ;
        throw a1;
    }

    public void b(a a1)
    {
        synchronized (b)
        {
            if (f(a1))
            {
                d = null;
                if (e != null)
                {
                    b();
                }
            }
        }
        return;
        a1;
        obj;
        JVM INSTR monitorexit ;
        throw a1;
    }

    public void c(a a1)
    {
        synchronized (b)
        {
            if (f(a1))
            {
                b(d);
            }
        }
        return;
        a1;
        obj;
        JVM INSTR monitorexit ;
        throw a1;
    }

    public void d(a a1)
    {
        synchronized (b)
        {
            if (f(a1))
            {
                c.removeCallbacksAndMessages(d);
            }
        }
        return;
        a1;
        obj;
        JVM INSTR monitorexit ;
        throw a1;
    }

    public void e(a a1)
    {
        synchronized (b)
        {
            if (f(a1))
            {
                b(d);
            }
        }
        return;
        a1;
        obj;
        JVM INSTR monitorexit ;
        throw a1;
    }
}
