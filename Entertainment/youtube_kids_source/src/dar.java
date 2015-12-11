// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

public final class dar extends ScheduledThreadPoolExecutor
{

    private final String a;
    private final boolean b;
    private final int c = 2;
    private final int d = 10;
    private final Object e = new Object();
    private final Map f;
    private final Queue g;
    private long h;
    private long i;

    public dar(String s, int j, ThreadFactory threadfactory, boolean flag, boolean flag1)
    {
        super(1, threadfactory);
        f.a(true);
        a = (String)f.b(s);
        if (flag1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b = flag;
        if (b)
        {
            f = ejr.b();
            g = a.g(40);
        } else
        {
            f = null;
            g = null;
        }
    }

    private static final String a(long l)
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s;
        if (l < 10L)
        {
            s = " ";
        } else
        {
            s = "";
        }
        return stringbuilder.append(s).append(l).toString();
    }

    private static String a(das das1, long l)
    {
        if (das1 != null)
        {
            String s1;
            long l1;
            if (das1.b != 0L)
            {
                String s;
                long l2;
                if (das1.c != 0L)
                {
                    l1 = das1.c;
                } else
                {
                    l1 = l;
                }
                l2 = das1.b;
                s1 = (new StringBuilder()).append("").append(", queue ").append(b(l1 - l2)).append("ms").toString();
            } else
            {
                s1 = "";
            }
            s = s1;
            if (das1.c != 0L)
            {
                if (das1.d != 0L)
                {
                    l1 = das1.d;
                } else
                {
                    l1 = l;
                }
                l2 = das1.c;
                s = (new StringBuilder()).append(s1).append(", execute ").append(b(l1 - l2)).append("ms").toString();
            }
            s1 = s;
            if (das1.d != 0L)
            {
                l1 = das1.d;
                s1 = (new StringBuilder()).append(s).append(", age ").append(b(l - l1)).append("ms").toString();
            }
            return (new StringBuilder()).append(s1).append(", ").append(das1.a).toString();
        } else
        {
            return (new StringBuilder()).append("").append("unknown: no task info").toString();
        }
    }

    private static Map a(Map map)
    {
        if (map == null)
        {
            return null;
        } else
        {
            return eij.a(map);
        }
    }

    private void a(int j)
    {
        boolean flag1 = true;
        if (j <= c) goto _L2; else goto _L1
_L1:
        Object obj1 = e;
        obj1;
        JVM INSTR monitorenter ;
        long l = SystemClock.uptimeMillis();
        if (l <= h + 5000L) goto _L4; else goto _L3
_L3:
        h = l;
        if (!b) goto _L6; else goto _L5
_L5:
        Object obj;
        eic eic1;
        das adas[];
        obj = a(f);
        eic1 = eic.a(getQueue());
        adas = a(g);
        boolean flag = true;
_L8:
        obj1;
        JVM INSTR monitorexit ;
        if (flag)
        {
            if (j <= d)
            {
                flag1 = false;
            }
            a(null, null, flag1, (new StringBuilder("Queue length for executor ")).append(a).append(" is now ").append(j).append(". Perhaps some tasks are too long, or the pool is too small.").toString());
            if (obj != null)
            {
                a(((Map) (obj)), ((List) (eic1)), adas, null, null, flag1);
            }
        }
_L2:
        return;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
_L6:
        flag = true;
        adas = null;
        eic1 = null;
        obj = null;
        continue; /* Loop/switch isn't completed */
_L4:
        flag = false;
        adas = null;
        eic1 = null;
        obj = null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void a(Object obj, RunnableScheduledFuture runnablescheduledfuture)
    {
        das das1 = new das(obj.toString());
        das1.b = SystemClock.uptimeMillis();
        synchronized (e)
        {
            f.put(runnablescheduledfuture, das1);
        }
        return;
        runnablescheduledfuture;
        obj;
        JVM INSTR monitorexit ;
        throw runnablescheduledfuture;
    }

    private static void a(String s, Iterator iterator, int j, boolean flag, Map map, long l, List list, 
            String s1, boolean flag1)
    {
        String s2 = (new StringBuilder()).append(s1).append("  ").toString();
        int k;
        for (k = 0; k < j && iterator.hasNext(); k++)
        {
            das das1 = (das)map.get(iterator.next());
            if (flag && (das1 == null || das1.c == 0L) || !flag && das1 != null && das1.c != 0L)
            {
                continue;
            }
            if (k == 0)
            {
                a(list, s1, flag1, s);
            }
            a(list, s2, flag1, (new StringBuilder()).append(a(k)).append(a(das1, l)).toString());
        }

        if (k == 0)
        {
            a(list, s1, flag1, (new StringBuilder()).append(s).append(" None").toString());
        }
    }

    private static void a(List list, String s, boolean flag, String s1)
    {
        if (list != null)
        {
            list.add(new Pair((new StringBuilder()).append(s).append(s1).toString(), ""));
            return;
        }
        if (flag)
        {
            Log.e("Search.ConcurrentUtils", s1);
            return;
        } else
        {
            Log.w("Search.ConcurrentUtils", s1);
            return;
        }
    }

    private void a(Map map, List list, das adas[], List list1, String s, boolean flag)
    {
        long l1 = SystemClock.uptimeMillis();
        int j = getPoolSize();
        int i1 = getCorePoolSize();
        s = (new StringBuilder("SafeScheduledThreadPoolExecutor: current threads ")).append(j).append(", maximum threads ");
        if (i1 == 0x7fffffff)
        {
            list1 = "unbounded";
        } else
        {
            list1 = (new StringBuilder()).append(i1).toString();
        }
        a(null, null, flag, s.append(list1).toString());
        if (map != null)
        {
            a("Executing tasks:", map.keySet().iterator(), 0x7fffffff, true, map, l1, null, null, flag);
        }
        if (map != null && list != null)
        {
            i1 = list.size();
            list1 = "Queued tasks:";
            int k = i1;
            if (i1 > 50)
            {
                list1 = "First 50 queued tasks:";
                k = 50;
            }
            a(((String) (list1)), list.iterator(), k, false, map, l1, null, null, flag);
        }
        if (adas != null)
        {
            if (adas.length == 0)
            {
                a(null, null, flag, (new StringBuilder()).append("Finished tasks:").append(" None").toString());
            } else
            {
                a(null, null, flag, "Finished tasks:");
                map = (new StringBuilder()).append(null).append("  ").toString();
                int j1 = 0;
                int k1 = adas.length;
                int l = 0;
                while (l < k1) 
                {
                    list = adas[l];
                    a(null, ((String) (map)), flag, (new StringBuilder()).append(a(j1)).append(a(((das) (list)), l1)).toString());
                    j1++;
                    l++;
                }
            }
        }
    }

    private static das[] a(Queue queue)
    {
        if (queue == null)
        {
            return null;
        } else
        {
            return (das[])queue.toArray(new das[queue.size()]);
        }
    }

    private static final String b(long l)
    {
        if (l < 10L)
        {
            return (new StringBuilder("    ")).append(l).toString();
        }
        if (l < 100L)
        {
            return (new StringBuilder("   ")).append(l).toString();
        }
        if (l < 1000L)
        {
            return (new StringBuilder("  ")).append(l).toString();
        }
        if (l < 10000L)
        {
            return (new StringBuilder(" ")).append(l).toString();
        } else
        {
            return (new StringBuilder()).append(l).toString();
        }
    }

    protected final void afterExecute(Runnable runnable, Throwable throwable)
    {
        long l;
        if (!b)
        {
            break MISSING_BLOCK_LABEL_172;
        }
        l = SystemClock.uptimeMillis();
        Object obj = e;
        obj;
        JVM INSTR monitorenter ;
        for (; g.size() >= 40; g.poll()) { }
        break MISSING_BLOCK_LABEL_51;
        runnable;
        obj;
        JVM INSTR monitorexit ;
        throw runnable;
        das das1 = (das)f.remove(runnable);
        if (das1 == null)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        das1.d = l;
        g.add(das1);
        obj;
        JVM INSTR monitorexit ;
        if (das1 != null)
        {
            l -= das1.c;
            if (l > 0x493e0L)
            {
                Log.w("Search.ConcurrentUtils", (new StringBuilder("Task ")).append(das1.a).append(" took ").append(l).append("ms, this is over the ").append(0x493e0L).append("ms threshold").toString());
            }
        }
        if (throwable instanceof RuntimeException)
        {
            throw (RuntimeException)throwable;
        }
        if (runnable instanceof Future)
        {
            Future future = (Future)runnable;
            try
            {
                future.get();
            }
            catch (CancellationException cancellationexception) { }
            // Misplaced declaration of an exception variable
            catch (Runnable runnable)
            {
                throw new RuntimeException(runnable);
            }
            catch (InterruptedException interruptedexception)
            {
                Thread.currentThread().interrupt();
            }
        }
        super.afterExecute(runnable, throwable);
        return;
    }

    protected final void beforeExecute(Thread thread, Runnable runnable)
    {
        if (!b) goto _L2; else goto _L1
_L1:
        long l = SystemClock.uptimeMillis();
        Object obj = e;
        obj;
        JVM INSTR monitorenter ;
        das das1 = (das)f.get(runnable);
        if (das1 != null) goto _L4; else goto _L3
_L3:
        das1 = new das("unknown: task not decorated");
        f.put(runnable, das1);
        das adas[];
        adas = null;
        runnable = null;
        thread = null;
_L6:
        das1.c = l;
        obj;
        JVM INSTR monitorexit ;
        if (thread != null)
        {
            Log.w("Search.ConcurrentUtils", (new StringBuilder("Task \"")).append(das1.a).append("\" was queued for ").append(l - das1.b).append("ms before starting on  executor \"").append(a).append("\"").toString());
            a(thread, runnable, adas, null, null, false);
        }
_L2:
        return;
_L4:
        if (l > i + 5000L && l > das1.b + 1000L)
        {
            i = l;
            thread = a(f);
            runnable = eic.a(getQueue());
            adas = a(g);
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_228;
        thread;
        obj;
        JVM INSTR monitorexit ;
        throw thread;
        adas = null;
        runnable = null;
        thread = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected final RunnableScheduledFuture decorateTask(Runnable runnable, RunnableScheduledFuture runnablescheduledfuture)
    {
        if (b)
        {
            a(runnable, runnablescheduledfuture);
        }
        a(getQueue().size());
        return runnablescheduledfuture;
    }

    protected final RunnableScheduledFuture decorateTask(Callable callable, RunnableScheduledFuture runnablescheduledfuture)
    {
        if (b)
        {
            a(callable, runnablescheduledfuture);
        }
        a(getQueue().size());
        return runnablescheduledfuture;
    }
}
