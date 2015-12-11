// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tapjoy.TJConnectListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.tapjoy.internal:
//            AndroidListenerProxy, df

public abstract class TapjoyConnectAutoRetry
{
    final class a
    {

        public final Context a;
        public final String b;
        public final Hashtable c;
        final TapjoyConnectAutoRetry d;

        public a(Context context, String s, Hashtable hashtable)
        {
            d = TapjoyConnectAutoRetry.this;
            super();
            a = context;
            b = s;
            c = hashtable;
        }
    }

    final class b extends df
    {

        final TapjoyConnectAutoRetry a;
        private boolean b;
        private boolean c;
        private Context d;
        private BroadcastReceiver e = new _cls2(this);

        static boolean a(b b1)
        {
            b1.c = true;
            return true;
        }

        private void j()
        {
            d.unregisterReceiver(e);
        }

        protected final void a()
        {
            TapjoyConnectAutoRetry tapjoyconnectautoretry = a;
            c c1 = c.c;
            c c2 = c.b;
            TapjoyConnectAutoRetry.a(tapjoyconnectautoretry, c1);
        }

        protected final void b()
        {
            d = TapjoyConnectAutoRetry.b(a).a;
            IntentFilter intentfilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            d.registerReceiver(e, intentfilter);
_L1:
            Object obj;
            if (b)
            {
                break MISSING_BLOCK_LABEL_208;
            }
            obj = new CountDownLatch(1);
            a a1 = TapjoyConnectAutoRetry.b(a);
            if (a.a(a1.a, a1.b, a1.c, new TJConnectListener(this, ((CountDownLatch) (obj))) {

        final CountDownLatch a;
        final b b;

        public final void onConnectFailure()
        {
            a.countDown();
        }

        public final void onConnectSuccess()
        {
            b.a(b);
            a.countDown();
        }

            
            {
                b = b1;
                a = countdownlatch;
                super();
            }
    }))
            {
                break MISSING_BLOCK_LABEL_105;
            }
            TapjoyConnectAutoRetry.a(a, false);
            j();
            return;
            Exception exception;
            c c1;
            c c2;
            try
            {
                ((CountDownLatch) (obj)).await();
            }
            catch (InterruptedException interruptedexception) { }
            if (!c)
            {
                break MISSING_BLOCK_LABEL_147;
            }
            obj = a;
            c1 = c.e;
            c2 = c.c;
            TapjoyConnectAutoRetry.a(((TapjoyConnectAutoRetry) (obj)), c1);
            TapjoyConnectAutoRetry.a(a, true);
            j();
            return;
            TapjoyConnectAutoRetry.a(a, false);
            long l = Math.max(TapjoyConnectAutoRetry.c(a), 1000L);
            TapjoyConnectAutoRetry.a(a, Math.min(l << 2, 0x36ee80L));
            a.a(l);
              goto _L1
            exception;
            j();
            throw exception;
            j();
            return;
        }

        protected final void c()
        {
            if (TapjoyConnectAutoRetry.a(a) == this)
            {
                TapjoyConnectAutoRetry.a(a, null);
            }
            if (a.a() == c.c)
            {
                TapjoyConnectAutoRetry tapjoyconnectautoretry = a;
                c c1 = c.a;
                c c2 = c.c;
                TapjoyConnectAutoRetry.a(tapjoyconnectautoretry, c1);
            }
        }

        protected final void d()
        {
            b = true;
            a.b();
        }

        private b()
        {
            a = TapjoyConnectAutoRetry.this;
            super();
        }

        b(byte byte0)
        {
            this();
        }
    }

    static final class c extends Enum
    {

        public static final c a;
        public static final c b;
        public static final c c;
        public static final c d;
        public static final c e;
        private static final c f[];

        public static c valueOf(String s)
        {
            return (c)Enum.valueOf(com/tapjoy/internal/TapjoyConnectAutoRetry$c, s);
        }

        public static c[] values()
        {
            return (c[])f.clone();
        }

        static 
        {
            a = new c("STOPPED", 0);
            b = new c("TRYING", 1);
            c = new c("RETRYING", 2);
            d = new c("BACKOFF", 3);
            e = new c("CONNECTED", 4);
            f = (new c[] {
                a, b, c, d, e
            });
        }

        private c(String s, int i)
        {
            super(s, i);
        }
    }


    private final ReentrantLock a = new ReentrantLock();
    private final Condition b;
    private volatile c c;
    private final LinkedList d = new LinkedList();
    private b e;
    private long f;
    private a g;
    private a h;

    public TapjoyConnectAutoRetry()
    {
        b = a.newCondition();
        c = c.a;
        f = 1000L;
    }

    static long a(TapjoyConnectAutoRetry tapjoyconnectautoretry, long l)
    {
        tapjoyconnectautoretry.f = l;
        return l;
    }

    static b a(TapjoyConnectAutoRetry tapjoyconnectautoretry)
    {
        return tapjoyconnectautoretry.e;
    }

    static b a(TapjoyConnectAutoRetry tapjoyconnectautoretry, b b1)
    {
        tapjoyconnectautoretry.e = b1;
        return b1;
    }

    private void a(c c1)
    {
        a.lock();
        c c2 = c;
        c = c1;
        a.unlock();
        return;
        c1;
        a.unlock();
        throw c1;
    }

    static void a(TapjoyConnectAutoRetry tapjoyconnectautoretry, c c1)
    {
        tapjoyconnectautoretry.a(c1);
    }

    static void a(TapjoyConnectAutoRetry tapjoyconnectautoretry, boolean flag)
    {
        tapjoyconnectautoretry.a(flag);
    }

    private void a(boolean flag)
    {
        a.lock();
        int i = d.size();
        if (i != 0) goto _L2; else goto _L1
_L1:
        a.unlock();
_L4:
        return;
_L2:
        Object obj;
        obj = new ArrayList(d);
        d.clear();
        a.unlock();
        obj = ((ArrayList) (obj)).iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            TJConnectListener tjconnectlistener = (TJConnectListener)((Iterator) (obj)).next();
            Exception exception;
            if (flag)
            {
                tjconnectlistener.onConnectSuccess();
            } else
            {
                tjconnectlistener.onConnectFailure();
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        exception;
        a.unlock();
        throw exception;
    }

    static a b(TapjoyConnectAutoRetry tapjoyconnectautoretry)
    {
        return tapjoyconnectautoretry.c();
    }

    static long c(TapjoyConnectAutoRetry tapjoyconnectautoretry)
    {
        return tapjoyconnectautoretry.f;
    }

    private a c()
    {
        a.lock();
        a a1;
        if (h != null)
        {
            g = h;
            h = null;
        }
        a1 = g;
        a.unlock();
        return a1;
        Exception exception;
        exception;
        a.unlock();
        throw exception;
    }

    final c a()
    {
        return c;
    }

    final boolean a(long l)
    {
        Exception exception;
        c c5;
        a.lock();
        c c2;
        try
        {
            c c1 = c.d;
            c c4 = c.c;
            a(c1);
            if (b.await(l, TimeUnit.MILLISECONDS))
            {
                f = 1000L;
            }
        }
        catch (InterruptedException interruptedexception)
        {
            c c3 = c.c;
            c5 = c.d;
            a(c3);
            a.unlock();
            return false;
        }
        finally
        {
            c5 = c.c;
        }
        c2 = c.c;
        c5 = c.d;
        a(c2);
        a.unlock();
        return false;
        c c6 = c.d;
        a(c5);
        a.unlock();
        throw exception;
    }

    protected abstract boolean a(Context context, String s, Hashtable hashtable, TJConnectListener tjconnectlistener);

    final void b()
    {
        a.lock();
        f = 1000L;
        b.signal();
        a.unlock();
        return;
        Exception exception;
        exception;
        a.unlock();
        throw exception;
    }

    public boolean connect(Context context, String s, Hashtable hashtable, TJConnectListener tjconnectlistener)
    {
        a.lock();
        if (tjconnectlistener == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        d.addLast(AndroidListenerProxy.newProxyInstance(tjconnectlistener, com/tapjoy/TJConnectListener));
        if (!(context instanceof Application)) goto _L2; else goto _L1
_L1:
        context = new a(context, s, hashtable);
        static final class _cls2
        {

            static final int a[];

            static 
            {
                a = new int[c.values().length];
                try
                {
                    a[c.e.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[c.a.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[c.b.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[c.c.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[c.d.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2.a[c.ordinal()];
        JVM INSTR tableswitch 1 5: default 242
    //                   1 116
    //                   2 130
    //                   3 200
    //                   4 200
    //                   5 214;
           goto _L3 _L4 _L5 _L6 _L6 _L7
_L3:
        a(c.a);
        a.unlock();
        return false;
_L2:
        context = context.getApplicationContext();
          goto _L1
_L4:
        a(true);
        a.unlock();
        return true;
_L5:
        g = context;
        if (!a(((a) (context)).a, ((a) (context)).b, ((a) (context)).c, new TJConnectListener() {

            final TapjoyConnectAutoRetry a;

            public final void onConnectFailure()
            {
                TapjoyConnectAutoRetry.a(a, a. new b((byte)0));
                TapjoyConnectAutoRetry.a(a).f();
                TapjoyConnectAutoRetry.a(a, false);
            }

            public final void onConnectSuccess()
            {
                TapjoyConnectAutoRetry tapjoyconnectautoretry = a;
                c c1 = c.e;
                c c2 = c.b;
                TapjoyConnectAutoRetry.a(tapjoyconnectautoretry, c1);
                TapjoyConnectAutoRetry.a(a, true);
            }

            
            {
                a = TapjoyConnectAutoRetry.this;
                super();
            }
        })) goto _L9; else goto _L8
_L8:
        context = c.b;
        s = c.a;
        a(context);
        a.unlock();
        return true;
_L9:
        d.clear();
        a.unlock();
        return false;
_L6:
        h = context;
        a.unlock();
        return true;
_L7:
        h = context;
        b();
        a.unlock();
        return true;
        context;
        a.unlock();
        throw context;
    }

    public boolean isConnected()
    {
        return c == c.e;
    }

    // Unreferenced inner class com/tapjoy/internal/TapjoyConnectAutoRetry$b$2

/* anonymous class */
    final class b._cls2 extends BroadcastReceiver
    {

        final b a;

        public final void onReceive(Context context, Intent intent)
        {
            a.a.b();
        }

            
            {
                a = b1;
                super();
            }
    }

}
