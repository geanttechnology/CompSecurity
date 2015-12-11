// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.os.Handler;
import android.os.Message;
import com.appnexus.opensdk.b.b;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.appnexus.opensdk:
//            ao, c, z, l, 
//            o, v, ak, ai

public final class e
{
    private final class a
        implements Runnable
    {

        final e a;

        public final void run()
        {
            com.appnexus.opensdk.b.b.a(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.handler_message_pass));
            a.a.sendEmptyMessage(0);
        }

        private a()
        {
            a = e.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

    private static final class b extends Handler
    {

        private final WeakReference a;

        public final void handleMessage(Message message)
        {
            this;
            JVM INSTR monitorenter ;
            message = (e)a.get();
            if (message == null) goto _L2; else goto _L1
_L1:
            boolean flag = ((e) (message)).d.a();
            if (flag) goto _L3; else goto _L2
_L2:
            this;
            JVM INSTR monitorexit ;
            return;
_L3:
            if (((e) (message)).b != -1L)
            {
                com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.new_ad_since, Math.max(0, (int)(System.currentTimeMillis() - ((e) (message)).b))));
            }
            message.b = System.currentTimeMillis();
            static final class _cls1
            {

                static final int a[];
                static final int b[];

                static 
                {
                    b = new int[z.values().length];
                    try
                    {
                        b[z.a.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    try
                    {
                        b[com.appnexus.opensdk.z.b.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        b[z.c.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    a = new int[c.values().length];
                    try
                    {
                        a[c.a.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        a[com.appnexus.opensdk.c.b.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        a[c.c.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            com.appnexus.opensdk._cls1.b[((e) (message)).d.getMediaType().ordinal()];
            JVM INSTR tableswitch 1 3: default 198
        //                       1 135
        //                       2 156
        //                       3 177;
               goto _L4 _L5 _L6 _L7
_L4:
            break; /* Loop/switch isn't completed */
_L7:
            break MISSING_BLOCK_LABEL_177;
_L8:
            ((e) (message)).e.d();
              goto _L2
            message;
            throw message;
_L5:
            message.e = new l((o)((e) (message)).d);
              goto _L8
_L6:
            message.e = new l((v)((e) (message)).d);
              goto _L8
            message.e = new ak((ai)((e) (message)).d);
              goto _L8
        }

        b(e e1)
        {
            a = new WeakReference(e1);
        }
    }

    static final class c extends Enum
    {

        public static final c a;
        public static final c b;
        public static final c c;
        private static final c d[];

        public static c valueOf(String s)
        {
            return (c)Enum.valueOf(com/appnexus/opensdk/e$c, s);
        }

        public static c[] values()
        {
            return (c[])d.clone();
        }

        static 
        {
            a = new c("STOPPED", 0);
            b = new c("SINGLE_REQUEST", 1);
            c = new c("AUTO_REFRESH", 2);
            d = (new c[] {
                a, b, c
            });
        }

        private c(String s, int i)
        {
            super(s, i);
        }
    }


    final b a = new b(this);
    public long b;
    public long c;
    final com.appnexus.opensdk.c d;
    ao e;
    private ScheduledExecutorService f;
    private int g;
    private c h;

    public e(com.appnexus.opensdk.c c1)
    {
        g = -1;
        b = -1L;
        c = -1L;
        h = c.a;
        d = c1;
    }

    public final void a()
    {
        if (e != null)
        {
            e.c();
            e = null;
        }
        if (f == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        f.shutdownNow();
        f.awaitTermination(g, TimeUnit.MILLISECONDS);
        f = null;
_L2:
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.stop));
        c = System.currentTimeMillis();
        h = c.a;
        return;
        Object obj;
        obj;
        f = null;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        f = null;
        throw obj;
    }

    final void a(int i)
    {
        boolean flag;
        if (g != i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        g = i;
        if (flag && !h.equals(c.a))
        {
            com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.b, (new StringBuilder("AdFetcher refresh period changed to ")).append(g).toString());
            com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.b, "Resetting AdFetcher");
            a();
            b();
        }
    }

    public final void b()
    {
        long l1 = 0L;
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.start));
        if (f == null)
        {
            f = Executors.newScheduledThreadPool(4);
        }
        switch (_cls1.a[h.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (g <= 0)
            {
                com.appnexus.opensdk.b.b.a(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.fetcher_start_single));
                f.schedule(new a((byte)0), 0L, TimeUnit.SECONDS);
                h = com.appnexus.opensdk.c.b;
                return;
            }
            com.appnexus.opensdk.b.b.a(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.fetcher_start_auto));
            int i = g;
            long l = l1;
            if (c != -1L)
            {
                l = l1;
                if (b != -1L)
                {
                    l = Math.min(i, Math.max(0L, (long)i - (c - b)));
                }
            }
            com.appnexus.opensdk.b.b.a(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.request_delayed_by_x_ms, l));
            f.scheduleAtFixedRate(new a((byte)0), l, i, TimeUnit.MILLISECONDS);
            h = c.c;
            return;

        case 2: // '\002'
            com.appnexus.opensdk.b.b.a(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.fetcher_start_single));
            f.schedule(new a((byte)0), 0L, TimeUnit.SECONDS);
            return;
        }
    }
}
