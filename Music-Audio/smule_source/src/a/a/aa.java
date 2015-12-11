// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.ConditionVariable;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Process;
import com.crittercism.app.CrittercismConfig;
import java.io.File;
import java.net.URL;
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

// Referenced classes of package a.a:
//            ez, v, x, y, 
//            em, es, eq, eb, 
//            ai, ak, al, fb, 
//            en, fa, ae, u, 
//            eg, do, be, co, 
//            ah, ep, ev, z, 
//            ab, ds, fc, w, 
//            de, ao, ay, au, 
//            ea, dv, dj, dn, 
//            ek, bl, bu, bv, 
//            ax, el, ej, cj, 
//            cw, ed, dm, ee, 
//            dx, dw, dy, cg, 
//            cs

public final class aa
    implements ez, v, x, y
{

    static aa a;
    public ej A;
    int B;
    public boolean C;
    private String D;
    private ay E;
    private ay F;
    private fa G;
    private u H;
    private boolean I;
    private String J;
    public boolean b;
    public Context c;
    public final ConditionVariable d = new ConditionVariable(false);
    public final ConditionVariable e = new ConditionVariable(false);
    public em f;
    ay g;
    ay h;
    ay i;
    ay j;
    ay k;
    ay l;
    ay m;
    ay n;
    ay o;
    do p;
    public eb q;
    ExecutorService r;
    public ExecutorService s;
    public boolean t;
    public ae u;
    protected eq v;
    public eg w;
    el x;
    public al y;
    public Map z;

    protected aa()
    {
        b = false;
        c = null;
        D = null;
        f = new em();
        p = null;
        q = null;
        G = null;
        r = Executors.newCachedThreadPool(new es());
        s = Executors.newSingleThreadExecutor(new es());
        I = false;
        t = false;
        J = "";
        x = null;
        z = new HashMap();
        A = null;
        B = 0;
        C = false;
        v = new eq(s);
    }

    public static aa A()
    {
        if (a == null)
        {
            a = new aa();
        }
        return a;
    }

    private static boolean C()
    {
        boolean flag1 = false;
        StackTraceElement astacktraceelement[] = Thread.currentThread().getStackTrace();
        int i1 = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i1 < astacktraceelement.length)
                {
                    StackTraceElement stacktraceelement = astacktraceelement[i1];
                    if (!stacktraceelement.getMethodName().equals("onCreate") && !stacktraceelement.getMethodName().equals("onResume"))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i1++;
        } while (true);
    }

    private void D()
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
            t = false;
        } else
        {
            obj = ((ActivityManager) (obj)).getRunningServices(0x7fffffff).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                if (((android.app.ActivityManager.RunningServiceInfo)((Iterator) (obj)).next()).pid == k1)
                {
                    t = true;
                    return;
                }
            }
        }
    }

    public final void B()
    {
        ed ed;
        if (!t)
        {
            if (!q.a(ed = new ed(this) {

        final aa a;
        final aa b;

        public final void a()
        {
            if (a.f.b())
            {
                return;
            } else
            {
                dm dm1 = new dm(a);
                JSONObject jsonobject = a.x.a();
                dm1.a.put("metadata", jsonobject);
                (new ee(dm1, new dx((new dw(b.u.k(), "/android_v2/update_user_metadata")).a()), new dy(a.x))).run();
                return;
            }
        }

            
            {
                b = aa.this;
                a = aa2;
                super();
            }
    }))
            {
                r.execute(ed);
                return;
            }
        }
    }

    public final String a()
    {
        String s2 = D;
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

    public final void a(ak ak1)
    {
        al al1 = y;
        if (y != null)
        {
            ai.a(ak1);
            ai.d();
            if (ak1.a)
            {
                y.a(ak1.b, TimeUnit.SECONDS);
                y.b();
                return;
            }
        }
    }

    public final void a(cj cj)
    {
        cj = new ed(cj) {

            final cj a;
            final aa b;

            public final void a()
            {
                b.l.a(a);
            }

            
            {
                b = aa.this;
                a = cj;
                super();
            }
        };
        if (!q.a(cj))
        {
            s.execute(cj);
        }
    }

    public final void a(cw cw)
    {
        if (!f.b())
        {
            if (!q.a(cw = new ed(cw) {

        final cw a;
        final aa b;

        public final void a()
        {
            b.m.a(a);
        }

            
            {
                b = aa.this;
                a = cw;
                super();
            }
    }))
            {
                s.execute(cw);
                return;
            }
        }
    }

    public final void a(fb fb1)
    {
        while (G == null || !fb1.a || fb1.c) 
        {
            return;
        }
        en.a("Enabling OPTMZ");
        G.a(fb1.d, TimeUnit.SECONDS);
        G.a();
    }

    public final void a(Context context, String s1, CrittercismConfig crittercismconfig)
    {
        en.a((new StringBuilder("Initializing Crittercism 5.0.6 for App ID ")).append(s1).toString());
        D = s1;
        u = new ae(s1, crittercismconfig);
        c = context;
        H = new u(c, u);
        J = context.getPackageName();
        w = new eg(context);
        D();
        long l1 = 0xdf8475800L;
        if (t)
        {
            l1 = 0x2cb417800L;
        }
        p = new do(l1);
        if (!C())
        {
            en.c("Crittercism should be initialized in onCreate() of MainActivity");
        }
        be.a(H);
        be.a(c);
        be.a(new co());
        be.a(new ah(c, u));
        boolean flag;
        v.a(u.j());
        v.b(u.b());
        G = new fa(this, new URL((new StringBuilder()).append(u.l()).append("/api/apm/network").toString()));
        v.a(G);
        v.a(this);
        (new ep(G, "OPTMZ")).start();
        if (fb.a(c).exists())
        {
            break MISSING_BLOCK_LABEL_306;
        }
        flag = u.h();
        if (flag)
        {
            try
            {
                s1 = new ds(c);
                I = (new fc(v, s1)).a();
                (new StringBuilder("installedApm = ")).append(I);
                en.b();
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                (new StringBuilder("Exception in startApm: ")).append(s1.getClass().getName());
                en.b();
                en.c();
            }
        }
        q = new eb(u, context, this, this, this);
        if (!t)
        {
            en.a(new ev(this, s, q, f));
        }
        context = Thread.getDefaultUncaughtExceptionHandler();
        if (!(context instanceof z))
        {
            Thread.setDefaultUncaughtExceptionHandler(new z(this, context));
        }
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            if (!(c instanceof Application))
            {
                en.c("Application context not provided. Automatic breadcrumbs will not be recorded.");
            } else
            {
                en.b();
                ((Application)c).registerActivityLifecycleCallbacks(new w(c, this));
            }
        } else
        {
            en.a("API Level is less than 14. Automatic breadcrumbs are not supported.");
        }
        if (!t)
        {
            ai.b(this);
            if (Looper.myLooper() == Looper.getMainLooper())
            {
                Looper.myQueue().addIdleHandler(new ab((byte)0));
            }
        }
        (new ep(q)).start();
        b = true;
        return;
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

    final void a(Throwable throwable)
    {
        List list = ai.a(this, throwable instanceof de);
        throwable = new ao(throwable, Thread.currentThread().getId());
        throwable.a("crashed_session", k);
        if (F.b() > 0)
        {
            throwable.a("previous_session", F);
        }
        throwable.a(l);
        throwable.b = (new au(m)).a;
        throwable.e = new JSONArray();
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
            if (thread.getId() != ((ao) (throwable)).a)
            {
                hashmap.put("name", thread.getName());
                hashmap.put("id", Long.valueOf(thread.getId()));
                hashmap.put("state", thread.getState().name());
                hashmap.put("stacktrace", new JSONArray(Arrays.asList((Object[])entry.getValue())));
                ((ao) (throwable)).e.put(new JSONObject(hashmap));
            }
        } while (true);
        throwable.a(list);
        j.a(throwable);
        throwable = new ea(c);
        throwable.a(g, new dv(), u.n(), "/v0/appload/", null, this, new dj());
        throwable.a(h, new dv(), u.k(), "/android_v2/handle_exceptions", null, this, new dn());
        throwable.a(i, new dv(), u.k(), "/android_v2/handle_ndk_crashes", null, this, new dn());
        throwable.a(j, new dv(), u.k(), "/android_v2/handle_crashes", null, this, new dn());
        try
        {
            throwable.a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            (new StringBuilder("InterruptedException in logCrashException: ")).append(throwable.getMessage());
            en.b();
            en.c();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            (new StringBuilder("Unexpected throwable in logCrashException: ")).append(throwable.getMessage());
        }
        en.b();
        en.c();
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
        return H.a;
    }

    public final void b(Throwable throwable)
    {
        this;
        JVM INSTR monitorenter ;
        if (throwable != null) goto _L2; else goto _L1
_L1:
        en.c("Calling logHandledException with a null java.lang.Throwable. Nothing will be reported to Crittercism");
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!t)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        throwable = new ed(throwable, Thread.currentThread().getId()) {

            final Throwable a;
            final long b;
            final aa c;

            public final void a()
            {
                if (c.f.b())
                {
                    return;
                }
                synchronized (c.p)
                {
                    if (c.B < 10)
                    {
                        Object obj = new ao(a, b);
                        ((ao) (obj)).a("current_session", c.k);
                        ((ao) (obj)).a(c.l);
                        obj.f = "he";
                        if (c.p.a())
                        {
                            obj = (new JSONArray()).put(((ao) (obj)).a());
                            (new ee((new dm(aa.a)).a(ax.b.f(), ((JSONArray) (obj))), new dx((new dw(c.u.k(), "/android_v2/handle_exceptions")).a()), null)).run();
                            obj = c;
                            obj.B = ((aa) (obj)).B + 1;
                            c.p.b();
                        }
                    }
                }
            }

            
            {
                c = aa.this;
                a = throwable;
                b = l1;
                super();
            }
        };
        if (!q.a(throwable))
        {
            s.execute(throwable);
        }
          goto _L3
        throwable;
        throw throwable;
        throwable = new ed(throwable, Thread.currentThread().getId()) {

            final Throwable a;
            final long b;
            final aa c;

            public final void a()
            {
                if (!c.f.b())
                {
                    ao ao1 = new ao(a, b);
                    ao1.a("current_session", c.k);
                    ao1.f = "he";
                    if (c.h.a(ao1))
                    {
                        aa.a.a(new cg(ao1.c, ao1.d));
                        if (c.p.a())
                        {
                            ea ea1 = new ea(c.c);
                            ea1.a(c.h, new dv(), c.u.k(), "/android_v2/handle_exceptions", null, aa.a, new dn());
                            ea1.a(c.q, c.r);
                            c.p.b();
                            return;
                        }
                    }
                }
            }

            
            {
                c = aa.this;
                a = throwable;
                b = l1;
                super();
            }
        };
        if (!q.a(throwable))
        {
            s.execute(throwable);
        }
          goto _L3
    }

    public final String c()
    {
        String s1 = "";
        if (w != null)
        {
            s1 = w.a();
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

    public final String d()
    {
        return "5.0.6";
    }

    public final int e()
    {
        int i1 = -1;
        if (f != null)
        {
            i1 = Integer.valueOf(f.a().a).intValue();
        }
        return i1;
    }

    public final String f()
    {
        return (new bl()).a;
    }

    public final int g()
    {
        return (new bu()).a.intValue();
    }

    public final int h()
    {
        return (new bv()).a.intValue();
    }

    public final String i()
    {
        return "Android";
    }

    public final String j()
    {
        return Build.MODEL;
    }

    public final String k()
    {
        return android.os.Build.VERSION.RELEASE;
    }

    public final em l()
    {
        return f;
    }

    public final ej m()
    {
        return A;
    }

    public final ay n()
    {
        return g;
    }

    public final ay o()
    {
        return h;
    }

    public final ay p()
    {
        return E;
    }

    public final ay q()
    {
        return i;
    }

    public final ay r()
    {
        return j;
    }

    public final ay s()
    {
        return k;
    }

    public final ay t()
    {
        return l;
    }

    public final ay u()
    {
        return F;
    }

    public final ay v()
    {
        return m;
    }

    public final ay w()
    {
        return n;
    }

    public final ay x()
    {
        return o;
    }

    public final el y()
    {
        return x;
    }

    public final void z()
    {
        if (t)
        {
            k = (new ay(c, ax.f)).a(c);
        } else
        {
            k = new ay(c, ax.f);
        }
        F = new ay(c, ax.h);
        l = new ay(c, ax.g);
        m = new ay(c, ax.k);
        g = new ay(c, ax.a);
        h = new ay(c, ax.b);
        E = new ay(c, ax.c);
        i = new ay(c, ax.d);
        j = new ay(c, ax.e);
        n = new ay(c, ax.i);
        o = new ay(c, ax.j);
        if (!t)
        {
            x = new el(c, D);
        }
    }

    // Unreferenced inner class a/a/aa$4

/* anonymous class */
    public final class _cls4 extends ed
    {

        final cs a;
        final aa b;

        public final void a()
        {
            b.k.a(a);
        }

            public 
            {
                b = aa.this;
                a = cs;
                super();
            }
    }

}
