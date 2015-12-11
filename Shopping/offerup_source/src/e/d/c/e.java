// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.c;

import android.support.v4.e.a;
import e.d.d.c;
import e.d.d.p;
import e.f.d;
import e.f.f;
import e.h;
import e.h.b;
import e.k;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package e.d.c:
//            f, g

public class e extends h
    implements k
{

    private static final boolean d;
    private static int e = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();
    private static final ConcurrentHashMap f = new ConcurrentHashMap();
    private static final AtomicReference g = new AtomicReference();
    private static volatile Object h;
    private static final Object i = new Object();
    private final ScheduledExecutorService a;
    private final f b = e.f.d.a().d();
    private volatile boolean c;

    public e(ThreadFactory threadfactory)
    {
        threadfactory = Executors.newScheduledThreadPool(1, threadfactory);
        if (!a(threadfactory) && (threadfactory instanceof ScheduledThreadPoolExecutor))
        {
            ScheduledThreadPoolExecutor scheduledthreadpoolexecutor = (ScheduledThreadPoolExecutor)threadfactory;
            do
            {
                if ((ScheduledExecutorService)g.get() != null)
                {
                    break;
                }
                ScheduledExecutorService scheduledexecutorservice = Executors.newScheduledThreadPool(1, new e.d.d.h("RxSchedulerPurge-"));
                if (!g.compareAndSet(null, scheduledexecutorservice))
                {
                    continue;
                }
                scheduledexecutorservice.scheduleAtFixedRate(new e.d.c.f(), e, e, TimeUnit.MILLISECONDS);
                break;
            } while (true);
            f.putIfAbsent(scheduledthreadpoolexecutor, scheduledthreadpoolexecutor);
        }
        a = threadfactory;
    }

    static void a()
    {
_L1:
        Object obj;
label0:
        {
            try
            {
                ScheduledThreadPoolExecutor scheduledthreadpoolexecutor;
                for (obj = f.keySet().iterator(); ((Iterator) (obj)).hasNext(); scheduledthreadpoolexecutor.purge())
                {
                    scheduledthreadpoolexecutor = (ScheduledThreadPoolExecutor)((Iterator) (obj)).next();
                    if (scheduledthreadpoolexecutor.isShutdown())
                    {
                        break label0;
                    }
                }

            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                android.support.v4.e.a.a(((Throwable) (obj)));
                e.f.d.a().b();
            }
            return;
        }
        ((Iterator) (obj)).remove();
          goto _L1
    }

    private static boolean a(ScheduledExecutorService scheduledexecutorservice)
    {
        if (!d)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        Object obj;
        if (scheduledexecutorservice instanceof ScheduledThreadPoolExecutor)
        {
            obj = h;
            if (obj == i)
            {
                return false;
            }
            if (obj == null)
            {
                obj = b(scheduledexecutorservice);
                Object obj1;
                if (obj != null)
                {
                    obj1 = obj;
                } else
                {
                    obj1 = i;
                }
                h = obj1;
            } else
            {
                obj = (Method)obj;
            }
        } else
        {
            obj = b(scheduledexecutorservice);
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        ((Method) (obj)).invoke(scheduledexecutorservice, new Object[] {
            Boolean.valueOf(true)
        });
        return true;
        scheduledexecutorservice;
        e.f.d.a().b();
        return false;
    }

    private static Method b(ScheduledExecutorService scheduledexecutorservice)
    {
        scheduledexecutorservice = scheduledexecutorservice.getClass().getMethods();
        int l = scheduledexecutorservice.length;
        for (int j = 0; j < l; j++)
        {
            Method method = scheduledexecutorservice[j];
            if (!method.getName().equals("setRemoveOnCancelPolicy"))
            {
                continue;
            }
            Class aclass[] = method.getParameterTypes();
            if (aclass.length == 1 && aclass[0] == Boolean.TYPE)
            {
                return method;
            }
        }

        return null;
    }

    public final g a(e.c.a a1, long l, TimeUnit timeunit, p p1)
    {
        timeunit = new g(e.f.f.a(a1), p1);
        p1.a(timeunit);
        if (0L <= 0L)
        {
            a1 = a.submit(timeunit);
        } else
        {
            a1 = a.schedule(timeunit, 0L, null);
        }
        timeunit.a(a1);
        return timeunit;
    }

    public final g a(e.c.a a1, long l, TimeUnit timeunit, b b1)
    {
        g g1 = new g(e.f.f.a(a1), b1);
        b1.a(g1);
        if (l <= 0L)
        {
            a1 = a.submit(g1);
        } else
        {
            a1 = a.schedule(g1, l, timeunit);
        }
        g1.a(a1);
        return g1;
    }

    public final k a(e.c.a a1)
    {
        return a(a1, 0L, null);
    }

    public final k a(e.c.a a1, long l, TimeUnit timeunit)
    {
        if (c)
        {
            return e.h.e.b();
        } else
        {
            return b(a1, l, timeunit);
        }
    }

    public final g b(e.c.a a1, long l, TimeUnit timeunit)
    {
        g g1 = new g(e.f.f.a(a1));
        if (l <= 0L)
        {
            a1 = a.submit(g1);
        } else
        {
            a1 = a.schedule(g1, l, timeunit);
        }
        g1.a(a1);
        return g1;
    }

    public final void b()
    {
        c = true;
        a.shutdownNow();
        ScheduledExecutorService scheduledexecutorservice = a;
        f.remove(scheduledexecutorservice);
    }

    public final boolean c()
    {
        return c;
    }

    static 
    {
        boolean flag = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
        int j = e.d.d.c.b();
        if (!flag && (j == 0 || j >= 21))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d = flag;
    }
}
