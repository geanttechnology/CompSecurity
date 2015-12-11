// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import android.os.ConditionVariable;
import android.os.Process;
import android.os.SystemClock;
import com.crittercism.app.Transaction;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package a.a:
//            cv, es, ak, en, 
//            aj, cu, ew, aa, 
//            x, ay, aw, ch, 
//            ed, et, eb

public final class ai extends Transaction
    implements cv
{

    private static ExecutorService b = Executors.newSingleThreadExecutor(new es());
    private static ScheduledExecutorService c = Executors.newScheduledThreadPool(1, new es());
    private static List o = new LinkedList();
    private static volatile long p = 0L;
    private static volatile long q = 0L;
    private static final int r[] = {
        32, 544, 32, 32, 32, 32, 32, 32, 32, 32, 
        32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 
        32, 8224
    };
    private static ai s = null;
    private static ak t = new ak();
    private String d;
    private long e;
    private int f;
    private long g;
    private long h;
    private long i;
    private aj j;
    private Map k;
    private String l;
    private long m;
    private ScheduledFuture n;

    public ai(aa aa1, String s1)
    {
        int i1 = -1;
        super();
        e = -1L;
        f = -1;
        n = null;
        if (s1.length() > 255)
        {
            en.c("Transaction name exceeds 255 characters! Truncating to first 255 characters.");
            d = s1.substring(0, 255);
        } else
        {
            d = s1;
        }
        j = aj.a;
        k = new HashMap();
        a = aa1;
        l = cu.a.a();
        e = -1L;
        aa1 = t.d.optJSONObject(s1);
        if (aa1 != null)
        {
            i1 = aa1.optInt("value", -1);
        }
        f = i1;
    }

    private ai(ai ai1)
    {
        e = -1L;
        f = -1;
        n = null;
        d = ai1.d;
        e = ai1.e;
        f = ai1.f;
        g = ai1.g;
        h = ai1.h;
        j = ai1.j;
        k = ai1.k;
        l = ai1.l;
        i = ai1.i;
        m = ai1.m;
    }

    public ai(JSONArray jsonarray)
    {
        e = -1L;
        f = -1;
        n = null;
        d = jsonarray.getString(0);
        j = aj.values()[jsonarray.getInt(1)];
        e = (int)(jsonarray.getDouble(2) * 1000D);
        f = jsonarray.optInt(3, -1);
        k = new HashMap();
        JSONObject jsonobject = jsonarray.getJSONObject(4);
        String s1;
        for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); k.put(s1, jsonobject.getString(s1)))
        {
            s1 = (String)iterator.next();
        }

        g = ew.a.a(jsonarray.getString(5));
        h = ew.a.a(jsonarray.getString(6));
        i = (long)(jsonarray.optDouble(7, 0.0D) * Math.pow(10D, 9D));
        l = cu.a.a();
    }

    static aj a(ai ai1)
    {
        return ai1.j;
    }

    public static List a(aa aa1, boolean flag)
    {
        LinkedList linkedlist;
        int i1;
        linkedlist = new LinkedList();
        long l1;
        long l2;
        synchronized (o)
        {
            linkedlist.addAll(o);
        }
        l1 = System.currentTimeMillis();
        l2 = System.nanoTime();
        i1 = linkedlist.size() - 1;
_L4:
        if (i1 < 0)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        obj = (ai)linkedlist.get(i1);
        obj;
        JVM INSTR monitorenter ;
        if (((ai) (obj)).j != aj.b)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        obj.h = l1;
        obj.j = aj.g;
        if (h())
        {
            obj.i = (l2 - Math.max(p, ((ai) (obj)).m)) + ((ai) (obj)).i;
        }
_L1:
        ((ai) (obj)).k();
        i1--;
        continue; /* Loop/switch isn't completed */
        linkedlist.remove(i1);
          goto _L1
        aa1;
        throw aa1;
        FutureTask futuretask = new FutureTask(new ed(aa1) {

            final aa a;

            public final void a()
            {
                et et1 = et.j;
                a.n.a();
            }

            
            {
                a = aa1;
                super();
            }
        }, null);
        ExecutorService executorservice = b;
        executorservice;
        JVM INSTR monitorenter ;
        b.execute(futuretask);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_209;
        }
        b.shutdown();
_L2:
        executorservice;
        JVM INSTR monitorexit ;
        futuretask.get();
        return linkedlist;
        aa1.z.clear();
          goto _L2
        aa1;
        throw aa1;
        aa1;
        en.a(aa1);
        return linkedlist;
        aa1;
        en.a(aa1);
        return linkedlist;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void a()
    {
        p = System.nanoTime();
        LinkedList linkedlist = new LinkedList();
        synchronized (o)
        {
            linkedlist.addAll(o);
        }
        if (s != null && q == 0L)
        {
            synchronized (s)
            {
                ai ai1 = s;
                ai1.i = ai1.i + (p - s.m);
            }
        }
        obj1 = linkedlist.iterator();
_L7:
        if (!((Iterator) (obj1)).hasNext())
        {
            break MISSING_BLOCK_LABEL_194;
        }
        obj = (ai)((Iterator) (obj1)).next();
        obj;
        JVM INSTR monitorenter ;
        if (((ai) (obj)).j != aj.b) goto _L2; else goto _L1
_L1:
        if (((ai) (obj)).n == null || !((ai) (obj)).n.isCancelled()) goto _L4; else goto _L3
_L3:
        ((ai) (obj)).a(((ai) (obj)).e - TimeUnit.MILLISECONDS.convert(((ai) (obj)).i, TimeUnit.NANOSECONDS));
_L2:
        continue; /* Loop/switch isn't completed */
        obj1;
        throw obj1;
_L4:
        if (((ai) (obj)).n == null)
        {
            ((ai) (obj)).a(((ai) (obj)).e);
        }
        if (true) goto _L2; else goto _L5
_L5:
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void a(long l1)
    {
        if (h())
        {
            n = c.schedule(new ed() {

                final ai a;

                public final void a()
                {
                    ai.b(a);
                }

            
            {
                a = ai.this;
                super();
            }
            }, l1, TimeUnit.MILLISECONDS);
        }
    }

    public static void a(aa aa1)
    {
        Object obj;
        q = System.nanoTime();
        obj = new LinkedList();
        Iterator iterator;
        synchronized (o)
        {
            ((List) (obj)).addAll(o);
        }
        iterator = ((List) (obj)).iterator();
_L4:
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_147;
        }
        obj1 = (ai)iterator.next();
        obj1;
        JVM INSTR monitorenter ;
        if (((ai) (obj1)).j == aj.b)
        {
            if (((ai) (obj1)).m < p)
            {
                break MISSING_BLOCK_LABEL_128;
            }
            if (((ai) (obj1)).m <= q)
            {
                obj1.i = ((ai) (obj1)).i + (q - ((ai) (obj1)).m);
            }
        }
_L2:
        ((ai) (obj1)).k();
        continue; /* Loop/switch isn't completed */
        aa1;
        throw aa1;
        obj1.i = ((ai) (obj1)).i + (q - p);
        if (true) goto _L2; else goto _L1
_L1:
        obj = new FutureTask(new ed(((List) (obj)), aa1) {

            final List a;
            final aa b;

            public final void a()
            {
                for (Iterator iterator1 = a.iterator(); iterator1.hasNext();)
                {
                    synchronized ((ai)iterator1.next())
                    {
                        if (ai.a(ai1) == aj.b)
                        {
                            b.n.b(ai1);
                        }
                    }
                }

            }

            
            {
                a = list;
                b = aa1;
                super();
            }
        }, null);
        synchronized (b)
        {
            b.execute(((Runnable) (obj)));
        }
        try
        {
            ((FutureTask) (obj)).get();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (aa aa1)
        {
            en.a(aa1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (aa aa1)
        {
            en.a(aa1);
        }
        return;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(aj aj1)
    {
        aj aj2;
        if (aj1 != aj.c && aj1 != aj.e)
        {
            aj2 = aj.i;
        }
        if (j == aj.b)
        {
            k();
            b(aj1);
        } else
        if (j != aj.f)
        {
            en.b((new StringBuilder("Transaction ")).append(d).append(" is not running. Either it has not been started or it has been stopped.").toString(), new IllegalStateException("Transaction is not running"));
            return;
        }
    }

    public static void a(ak ak1)
    {
        t = ak1;
    }

    public static void a(x x1)
    {
        ay ay1;
        Object obj;
        long l1;
        ay1 = x1.w();
        obj = ay1.c();
        l1 = System.currentTimeMillis();
        obj = ((List) (obj)).iterator();
_L1:
        Object obj1;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_117;
            }
            obj1 = (JSONArray)((ch)(aw)((Iterator) (obj)).next()).a();
        } while (obj1 == null);
        obj1 = new ai(((JSONArray) (obj1)));
        obj1.h = l1;
        obj1.j = aj.h;
        x1.x().a(((cv) (obj1)));
          goto _L1
        Object obj2;
        obj2;
        try
        {
            en.a(((Throwable) (obj2)));
        }
        // Misplaced declaration of an exception variable
        catch (x x1)
        {
            throw x1;
        }
        // Misplaced declaration of an exception variable
        catch (x x1)
        {
            en.a(x1);
            return;
        }
          goto _L1
        obj2;
        en.a(((Throwable) (obj2)));
          goto _L1
        ay1.a();
        return;
    }

    public static void b()
    {
        try
        {
            if (s != null)
            {
                s.c();
            }
            return;
        }
        catch (ThreadDeath threaddeath)
        {
            throw threaddeath;
        }
        catch (Throwable throwable)
        {
            en.a(throwable);
        }
    }

    public static void b(aa aa1)
    {
        ai ai1 = new ai(aa1, "App Load");
        s = ai1;
        ai1;
        JVM INSTR monitorenter ;
        long l1 = i();
        if (l1 == -1L)
        {
            break MISSING_BLOCK_LABEL_187;
        }
        s.j = aj.b;
        ai ai2 = s;
        long l2 = SystemClock.elapsedRealtime();
        ai2.g = System.currentTimeMillis() - (l2 - l1);
        ai2 = s;
        l1 = TimeUnit.NANOSECONDS.convert(l1, TimeUnit.MILLISECONDS);
        l2 = TimeUnit.NANOSECONDS.convert(SystemClock.elapsedRealtime(), TimeUnit.MILLISECONDS);
        ai2.m = System.nanoTime() - (l2 - l1);
        s.e = t.a(s.d);
        synchronized (o)
        {
            o.add(s);
        }
        obj = new ed(aa1, new ai(s)) {

            final aa a;
            final ai b;

            public final void a()
            {
                a.q.a.block();
                a.n.a(b);
            }

            
            {
                a = aa1;
                b = ai1;
                super();
            }
        };
        synchronized (b)
        {
            b.execute(((Runnable) (obj)));
            s.a(s.e);
        }
        ai1;
        JVM INSTR monitorexit ;
        return;
        aa1;
        obj;
        JVM INSTR monitorexit ;
        throw aa1;
        aa1;
        ai1;
        JVM INSTR monitorexit ;
        throw aa1;
        aa1;
        throw aa1;
        exception;
        aa1;
        JVM INSTR monitorexit ;
        throw exception;
        aa1;
        en.a(aa1);
        return;
    }

    static void b(ai ai1)
    {
        ai1.l();
    }

    private void b(aj aj1)
    {
        j = aj1;
        h = System.currentTimeMillis();
        long l1 = System.nanoTime();
        if (h())
        {
            i = (l1 - Math.max(p, m)) + i;
        }
        ed ed;
        synchronized (o)
        {
            o.remove(this);
        }
        ed = new ed(new ai(this)) {

            final ai a;
            final ai b;

            public final void a()
            {
                if (ai.a(a) != aj.c)
                {
                    Object obj = new Runnable(this) {

                        final _cls5 a;

                        public final void run()
                        {
                        }

            
            {
                a = _pcls5;
                super();
            }
                    };
                    ExecutorService executorservice = b.a.s;
                    obj = new FutureTask(((Runnable) (obj)), null);
                    executorservice.execute(((Runnable) (obj)));
                    try
                    {
                        ((FutureTask) (obj)).get();
                    }
                    catch (InterruptedException interruptedexception)
                    {
                        en.a(interruptedexception);
                    }
                    catch (ExecutionException executionexception)
                    {
                        en.a(executionexception);
                    }
                }
                b.a.q.a.block();
                b.a.n.a(ai.c(b));
                b.a.o.a(a);
            }

            
            {
                b = ai.this;
                a = ai2;
                super();
            }
        };
        synchronized (b)
        {
            b.execute(ed);
        }
    }

    static String c(ai ai1)
    {
        return ai1.l;
    }

    public static void d()
    {
        Object obj1 = new LinkedList();
        synchronized (o)
        {
            ((List) (obj1)).addAll(o);
        }
        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext();)
        {
            synchronized ((ai)((Iterator) (obj1)).next())
            {
                if (((ai) (obj)).j == aj.b)
                {
                    obj.e = t.a(((ai) (obj)).d);
                    ((ai) (obj)).k();
                    ((ai) (obj)).a(((ai) (obj)).e);
                }
            }
        }

    }

    private static boolean h()
    {
        return p > q;
    }

    private static long i()
    {
        Object obj = new long[1];
        int i1 = Process.myPid();
        String s1 = (new StringBuilder("/proc/")).append(i1).append("/stat").toString();
        boolean flag;
        try
        {
            flag = ((Boolean)android/os/Process.getDeclaredMethod("readProcFile", new Class[] {
                java/lang/String, [I, [Ljava/lang/String;, [J, [F
            }).invoke(null, new Object[] {
                s1, r, null, obj, null
            })).booleanValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            en.a(((Throwable) (obj)));
            return -1L;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            en.a(((Throwable) (obj)));
            return -1L;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            en.a(((Throwable) (obj)));
            return -1L;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            en.a(((Throwable) (obj)));
            return -1L;
        }
        if (!flag)
        {
            return -1L;
        } else
        {
            return obj[0] * 10L;
        }
    }

    private void j()
    {
        this;
        JVM INSTR monitorenter ;
        a(aj.c);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void k()
    {
        this;
        JVM INSTR monitorenter ;
        if (n != null)
        {
            n.cancel(false);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void l()
    {
        this;
        JVM INSTR monitorenter ;
        if (j == aj.b)
        {
            b(aj.f);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(OutputStream outputstream)
    {
        JSONArray jsonarray = null;
        JSONArray jsonarray1 = e();
        jsonarray = jsonarray1;
_L2:
        if (jsonarray != null)
        {
            outputstream.write(jsonarray.toString().getBytes());
        }
        return;
        JSONException jsonexception;
        jsonexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final void c()
    {
        try
        {
            j();
            return;
        }
        catch (ThreadDeath threaddeath)
        {
            throw threaddeath;
        }
        catch (Throwable throwable)
        {
            en.a(throwable);
        }
    }

    public final JSONArray e()
    {
        JSONArray jsonarray = (new JSONArray()).put(d).put(j.ordinal()).put((double)e / 1000D);
        Object obj;
        if (f == -1)
        {
            obj = JSONObject.NULL;
        } else
        {
            obj = Integer.valueOf(f);
        }
        obj = jsonarray.put(obj).put(new JSONObject(k)).put(ew.a.a(new Date(g))).put(ew.a.a(new Date(h)));
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            ((JSONArray) (obj)).put((double)Math.round(((double)i / Math.pow(10D, 9D)) * 1000D) / 1000D);
            return ((JSONArray) (obj));
        } else
        {
            ((JSONArray) (obj)).put(JSONObject.NULL);
            return ((JSONArray) (obj));
        }
    }

    public final String f()
    {
        return l;
    }

    public final aj g()
    {
        return j;
    }

}
