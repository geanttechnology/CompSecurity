// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

final class ah extends r
{

    private final ao a;
    private final ScheduledExecutorService b;
    private final Runnable c = new ai(this, (byte)0);
    private volatile boolean d;
    private ac e;

    ah(ao ao, ScheduledExecutorService scheduledexecutorservice, ab ab1)
    {
        e = new ac() {

            private ah a;

            public final void a(Object obj)
            {
                obj = (ad)obj;
                final class _cls2
                {

                    static final int a[];

                    static 
                    {
                        a = new int[ad.a().length];
                        try
                        {
                            a[ad.b.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            a[ad.c.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                switch (_cls2.a[((ad) (obj)).ordinal()])
                {
                default:
                    return;

                case 1: // '\001'
                case 2: // '\002'
                    ah.b(a).execute(ah.a(a));
                    break;
                }
            }

            
            {
                a = ah.this;
                super();
            }
        };
        a = ao;
        b = scheduledexecutorservice;
        d = true;
        scheduledexecutorservice.scheduleAtFixedRate(new ak(this, (byte)0), 0L, 30000L, TimeUnit.MILLISECONDS);
        ab1.a(ad, e);
    }

    static Runnable a(ah ah1)
    {
        return ah1.c;
    }

    static boolean a(ah ah1, boolean flag)
    {
        ah1.d = false;
        return false;
    }

    static ScheduledExecutorService b(ah ah1)
    {
        return ah1.b;
    }

    static boolean c(ah ah1)
    {
        return ah1.d;
    }

    static ao d(ah ah1)
    {
        return ah1.a;
    }

    final void a()
    {
        b.execute(c);
    }

    final void a(Runnable runnable, int i)
    {
        b.scheduleAtFixedRate(runnable, 0L, i, TimeUnit.MILLISECONDS);
    }

    final void a(Runnable runnable, long l)
    {
        b.schedule(runnable, 0L, TimeUnit.MILLISECONDS);
    }

    final void b()
    {
        d = true;
    }
}
