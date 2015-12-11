// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.ConditionVariable;
import android.os.Process;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package crittercism.android:
//            au, av, aw, f, 
//            df, di, ba, e, 
//            co, h, dg, g, 
//            bd, bj, cn, da, 
//            dd, bi, de, cf, 
//            at, c, cq, ce, 
//            cs, ck, cj, cl, 
//            bt

public final class ay
    implements au, av, aw, f
{

    static ay a;
    int A;
    private bj B;
    private bj C;
    public boolean b;
    public Context c;
    public String d;
    public final ConditionVariable e = new ConditionVariable(false);
    public final ConditionVariable f = new ConditionVariable(false);
    public df g;
    bj h;
    bj i;
    bj j;
    bj k;
    bj l;
    bj m;
    public cf n;
    public co o;
    public g p;
    ExecutorService q;
    public ExecutorService r;
    public at s;
    public boolean t;
    public boolean u;
    public String v;
    public ba w;
    public e x;
    public da y;
    de z;

    protected ay()
    {
        b = false;
        c = null;
        d = null;
        g = new df();
        n = null;
        o = null;
        p = null;
        q = Executors.newCachedThreadPool(new di());
        r = Executors.newSingleThreadExecutor(new di());
        t = false;
        u = false;
        v = "";
        w = new ba();
        z = null;
        A = 0;
        x = new e(r);
    }

    public static ay t()
    {
        if (a == null)
        {
            a = new ay();
        }
        return a;
    }

    public final String a()
    {
        String s2 = d;
        String s1 = s2;
        if (s2 == null)
        {
            s1 = "";
        }
        return s1;
    }

    public final String a(String s1, String s2)
    {
        Object obj = null;
        SharedPreferences sharedpreferences = c.getSharedPreferences(s1, 0);
        s1 = obj;
        if (sharedpreferences != null)
        {
            s1 = sharedpreferences.getString(s2, null);
        }
        return s1;
    }

    public final void a(c c1)
    {
        c1 = new cq(c1) {

            final c a;
            final ay b;

            public final void a()
            {
                b.m.a(a);
            }

            
            {
                b = ay.this;
                a = c1;
                super();
            }
        };
        if (!o.a(c1))
        {
            r.execute(c1);
        }
    }

    public final void a(h h1)
    {
        while (!t || !w.isOptmzEnabled() || !h1.a || h1.c) 
        {
            return;
        }
        dg.a("Crittercism", "Enabling OPTMZ");
        p.a(h1.d, TimeUnit.SECONDS);
        p.a();
    }

    public final void a(String s1, String s2, int i1)
    {
        s1 = c.getSharedPreferences(s1, 0);
        if (s1 != null)
        {
            s1 = s1.edit();
            if (s1 != null)
            {
                s1.remove(s2);
                s1.putInt(s2, i1);
                s1.commit();
            }
        }
    }

    public final void a(String s1, String s2, String s3)
    {
        s1 = c.getSharedPreferences(s1, 0);
        if (s1 != null)
        {
            s1 = s1.edit();
            if (s1 != null)
            {
                s1.remove(s2);
                s1.putString(s2, s3);
                s1.commit();
            }
        }
    }

    final void a(Throwable throwable)
    {
        throwable = new bd(throwable, Thread.currentThread().getId());
        throwable.a("crashed_session", l);
        if (C.b() > 0)
        {
            throwable.a("previous_session", C);
        }
        throwable.a(m);
        throwable.b = new JSONArray();
        Iterator iterator = Thread.getAllStackTraces().entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            HashMap hashmap = new HashMap();
            Thread thread = (Thread)entry.getKey();
            if (thread.getId() != ((bd) (throwable)).a)
            {
                hashmap.put("name", thread.getName());
                hashmap.put("id", Long.valueOf(thread.getId()));
                hashmap.put("state", thread.getState().name());
                hashmap.put("stacktrace", new JSONArray(Arrays.asList((Object[])entry.getValue())));
                ((bd) (throwable)).b.put(new JSONObject(hashmap));
            }
        } while (true);
        k.a(throwable);
        throwable = new cn(c);
        throwable.a(h, new ci.a(), w.a(), this);
        throwable.a(i, new ci.a(), w.a(), this);
        throwable.a(j, new ci.a(), w.a(), this);
        throwable.a(k, new ci.a(), w.a(), this);
        try
        {
            throwable.a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            (new StringBuilder("InterruptedException in logCrashException: ")).append(throwable.getMessage());
            dg.b();
            dg.c();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            (new StringBuilder("Unexpected throwable in logCrashException: ")).append(throwable.getMessage());
        }
        dg.b();
        dg.c();
    }

    public final void a(JSONObject jsonobject)
    {
        if (!u)
        {
            if (!o.a(jsonobject = new cq(this, jsonobject) {

        final ay a;
        final JSONObject b;
        final ay c;

        public final void a()
        {
            if (!a.g.c())
            {
                a.z.a(b);
                if (a.z.b())
                {
                    a.y();
                    return;
                }
            }
        }

            
            {
                c = ay.this;
                a = ay2;
                b = jsonobject;
                super();
            }
    }))
            {
                r.execute(jsonobject);
                return;
            }
        }
    }

    public final int b(String s1, String s2)
    {
        int i1 = 0;
        s1 = c.getSharedPreferences(s1, 0);
        if (s1 != null)
        {
            i1 = s1.getInt(s2, 0);
        }
        return i1;
    }

    public final String b()
    {
        return (new bn.c()).a;
    }

    public final void b(Throwable throwable)
    {
        this;
        JVM INSTR monitorenter ;
        if (throwable != null) goto _L2; else goto _L1
_L1:
        dg.c("Crittercism", "Calling logHandledException with a null java.lang.Throwable. Nothing will be reported to Crittercism");
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!u)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        throwable = new cq(throwable, Thread.currentThread().getId()) {

            final Throwable a;
            final long b;
            final ay c;

            public final void a()
            {
                if (c.g.c())
                {
                    return;
                }
                synchronized (c.n)
                {
                    if (c.A < 10)
                    {
                        Object obj = new bd(a, b);
                        ((bd) (obj)).a("current_session", c.l);
                        ((bd) (obj)).a(c.m);
                        obj.c = "he";
                        if (c.n.a())
                        {
                            obj = (new JSONArray()).put(((bd) (obj)).a());
                            (new cs((new ce(ay.a)).a(bi.b.g(), ((JSONArray) (obj))), new ck((new cj(c.w.a(), "/android_v2/handle_exceptions")).a()), null)).run();
                            obj = c;
                            obj.A = ((ay) (obj)).A + 1;
                            c.n.b();
                        }
                    }
                }
            }

            
            {
                c = ay.this;
                a = throwable;
                b = l1;
                super();
            }
        };
        if (!o.a(throwable))
        {
            r.execute(throwable);
        }
          goto _L3
        throwable;
        throw throwable;
        throwable = new cq(throwable, Thread.currentThread().getId()) {

            final Throwable a;
            final long b;
            final ay c;

            public final void a()
            {
                if (!c.g.c())
                {
                    bd bd1 = new bd(a, b);
                    bd1.a("current_session", c.l);
                    bd1.c = "he";
                    if (c.i.a(bd1) && c.n.a())
                    {
                        cn cn1 = new cn(c.c);
                        cn1.a(c.i, new ci.a(), c.w.a(), ay.a);
                        cn1.a(c.o, c.q);
                        c.n.b();
                        return;
                    }
                }
            }

            
            {
                c = ay.this;
                a = throwable;
                b = l1;
                super();
            }
        };
        if (!o.a(throwable))
        {
            r.execute(throwable);
        }
          goto _L3
    }

    public final String c()
    {
        String s1 = "";
        if (y != null)
        {
            s1 = y.a();
        }
        return s1;
    }

    public final boolean c(String s1, String s2)
    {
        boolean flag = false;
        s1 = c.getSharedPreferences(s1, 0);
        if (s1 != null)
        {
            flag = s1.getBoolean(s2, false);
        }
        return flag;
    }

    public final int d()
    {
        int i1 = -1;
        if (g != null)
        {
            i1 = Integer.valueOf(g.b().a).intValue();
        }
        return i1;
    }

    public final String e()
    {
        return (new bn.f()).a;
    }

    public final String f()
    {
        return "Android";
    }

    public final String g()
    {
        return Build.MODEL;
    }

    public final String h()
    {
        return android.os.Build.VERSION.RELEASE;
    }

    public final df i()
    {
        return g;
    }

    public final bj j()
    {
        return h;
    }

    public final bj k()
    {
        return i;
    }

    public final bj l()
    {
        return B;
    }

    public final bj m()
    {
        return j;
    }

    public final bj n()
    {
        return k;
    }

    public final bj o()
    {
        return l;
    }

    public final bj p()
    {
        return m;
    }

    public final bj q()
    {
        return C;
    }

    public final de r()
    {
        return z;
    }

    public final void s()
    {
        if (u)
        {
            l = (new bj(c, bi.f)).a(c);
        } else
        {
            l = new bj(c, bi.f);
        }
        C = new bj(c, bi.h);
        m = new bj(c, bi.g);
        h = new bj(c, bi.a);
        i = new bj(c, bi.b);
        B = new bj(c, bi.c);
        j = new bj(c, bi.d);
        k = new bj(c, bi.e);
        if (!u)
        {
            z = new de(c, d);
        }
    }

    public final void u()
    {
        int j1 = Process.myUid();
        int k1 = Process.myPid();
        Object obj = (ActivityManager)c.getSystemService("activity");
        Iterator iterator = ((ActivityManager) (obj)).getRunningAppProcesses().iterator();
        int i1 = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (((android.app.ActivityManager.RunningAppProcessInfo)iterator.next()).uid == j1)
            {
                i1++;
            }
        } while (true);
        if (i1 <= 1)
        {
            u = false;
        } else
        {
            obj = ((ActivityManager) (obj)).getRunningServices(0x7fffffff).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                if (((android.app.ActivityManager.RunningServiceInfo)((Iterator) (obj)).next()).pid == k1)
                {
                    u = true;
                    return;
                }
            }
        }
    }

    public final void y()
    {
        cq cq;
        if (!u)
        {
            if (!o.a(cq = new cq(this) {

        final ay a;
        final ay b;

        public final void a()
        {
            if (a.g.c())
            {
                return;
            } else
            {
                ce ce1 = new ce(a);
                JSONObject jsonobject = a.z.a();
                ce1.a.put("metadata", jsonobject);
                (new cs(ce1, new ck((new cj(b.w.a(), "/android_v2/update_user_metadata")).a()), new cl(a.z))).run();
                return;
            }
        }

            
            {
                b = ay.this;
                a = ay2;
                super();
            }
    }))
            {
                q.execute(cq);
                return;
            }
        }
    }

    // Unreferenced inner class crittercism/android/ay$8

/* anonymous class */
    public final class _cls8 extends cq
    {

        final bt a;
        final ay b;

        public final void a()
        {
            b.l.a(a);
        }

            public 
            {
                b = ay.this;
                a = bt;
                super();
            }
    }

}
