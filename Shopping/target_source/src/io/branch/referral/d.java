// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package io.branch.referral:
//            m, h, ag, y, 
//            e, c, f, ac, 
//            ab, k, o, x, 
//            aa, i, ShareLinkManager

public class d
{

    private static d b;
    private static boolean u = false;
    private static boolean v = false;
    private final int A = 1501;
    final Object a = new Object();
    private h c;
    private m d;
    private ag e;
    private Context f;
    private Timer g;
    private Timer h;
    private boolean i;
    private Semaphore j;
    private y k;
    private int l;
    private boolean m;
    private SparseArray n;
    private android.view.View.OnTouchListener o;
    private Handler p;
    private boolean q;
    private Map r;
    private ScheduledFuture s;
    private a t;
    private h w;
    private ShareLinkManager x;
    private Activity y;
    private final String z = "io.branch.sdk.auto_link_request_code";

    private d(Context context)
    {
    /* block-local class not found */
    class h {}

        w = h.c;
        d = io.branch.referral.m.a(context);
        c = new h(context);
        e = new ag(context);
        k = io.branch.referral.y.a(context);
        j = new Semaphore(1);
        g = new Timer();
        h = new Timer();
        i = false;
        l = 0;
        m = true;
        n = new SparseArray();
        o = f();
        p = new Handler();
        q = false;
        r = new HashMap();
    }

    static int a(d d1, int i1)
    {
        d1.l = i1;
        return i1;
    }

    static Activity a(d d1, Activity activity)
    {
        d1.y = activity;
        return activity;
    }

    static h a(d d1, h h1)
    {
        d1.w = h1;
        return h1;
    }

    public static d a()
    {
        if (b != null) goto _L2; else goto _L1
_L1:
        Log.e("BranchSDK", "Branch instance is not created yet. Make sure you have initialised Branch. [Consider Calling getInstance(Context ctx) if you still have issue.]");
_L4:
        return b;
_L2:
        if (u && !v)
        {
            Log.e("BranchSDK", "Branch instance is not properly initialised. Make sure your Application class is extending BranchApp class. If you are not extending BranchApp class make sure you are initialising Branch in your Applications onCreate()");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static d a(Context context)
    {
        return a(context, true);
    }

    private static d a(Context context, boolean flag)
    {
        if (b == null)
        {
            b = d(context);
            String s1 = b.d.a(flag);
            if (s1 == null || s1.equalsIgnoreCase("bnc_no_value"))
            {
                Log.i("BranchSDK", "Branch Warning: Please enter your branch_key in your project's Manifest file!");
                flag = b.d.b("bnc_no_value");
            } else
            {
                flag = b.d.b(s1);
            }
            if (flag)
            {
                b.r.clear();
                b.k.d();
            }
        }
        b.f = context;
        if (context instanceof e)
        {
            u = true;
            b.a((Application)context);
        }
        return b;
    }

    static m a(d d1)
    {
        return d1.d;
    }

    private JSONObject a(String s1)
    {
        if (s1.equals("bnc_no_value"))
        {
            return new JSONObject();
        }
        JSONObject jsonobject;
        try
        {
            jsonobject = JSONObjectInstrumentation.init(s1);
        }
        catch (JSONException jsonexception)
        {
            s1 = io.branch.referral.c.a(s1.getBytes(), 2);
            try
            {
                s1 = JSONObjectInstrumentation.init(new String(s1));
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                s1.printStackTrace();
                return new JSONObject();
            }
            return s1;
        }
        return jsonobject;
    }

    private void a(int i1, int j1)
    {
        o o1;
        if (i1 >= k.a())
        {
            o1 = k.a(k.a() - 1);
        } else
        {
            o1 = k.a(i1);
        }
        a(o1, j1);
    }

    private void a(Activity activity)
    {
        if (activity != null && n.get(System.identityHashCode(activity)) == null)
        {
            n.put(System.identityHashCode(activity), "init");
    /* block-local class not found */
    class g {}

            activity.getWindow().setCallback(new g(activity.getWindow().getCallback()));
        }
    }

    private void a(Application application)
    {
        try
        {
    /* block-local class not found */
    class a {}

            t = new a(null);
            application.unregisterActivityLifecycleCallbacks(t);
            application.registerActivityLifecycleCallbacks(t);
            v = true;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Application application)
        {
            v = false;
            u = false;
            Log.w("BranchSDK", (new f("", -108)).a());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Application application)
        {
            v = false;
        }
        u = false;
        Log.w("BranchSDK", (new f("", -108)).a());
    }

    private void a(e e1)
    {
        if ((d.g() == null || d.g().equalsIgnoreCase("bnc_no_value")) && (d.f() == null || d.f().equalsIgnoreCase("bnc_no_value")))
        {
            w = h.c;
    /* block-local class not found */
    class e {}

            if (e1 != null)
            {
                e1.a(null, new f("Trouble initializing Branch.", -1234));
            }
            Log.i("BranchSDK", "Branch Warning: Please enter your branch_key in your project's res/values/strings.xml!");
            return;
        }
        if (d.g() != null && d.g().startsWith("key_test_"))
        {
            Log.i("BranchSDK", "Branch Warning: You are using your test app's Branch Key. Remember to change it to live Branch Key during deployment.");
        }
        if (q())
        {
            a(((o) (new ac(f, e1, c.c()))), e1);
            return;
        } else
        {
            a(((o) (new ab(f, e1, c.c(), io.branch.referral.k.a()))), e1);
            return;
        }
    }

    static void a(d d1, int i1, int j1)
    {
        d1.a(i1, j1);
    }

    static void a(d d1, o o1)
    {
        d1.b(o1);
    }

    private void a(o o1)
    {
        if (l == 0)
        {
            k.a(o1, 0);
            return;
        } else
        {
            k.a(o1, 1);
            return;
        }
    }

    private void a(o o1, int i1)
    {
        if (o1 == null)
        {
            return;
        } else
        {
            o1.a(i1);
            return;
        }
    }

    private void a(o o1, e e1)
    {
        if (!k.f())
        {
            a(o1);
        } else
        {
            k.a(e1);
            k.a(o1, l, e1);
        }
        j();
    }

    static boolean a(d d1, boolean flag)
    {
        d1.i = flag;
        return flag;
    }

    private boolean a(String s1, String s2)
    {
        s1 = s1.split("\\?")[0].split("/");
        s2 = s2.split("\\?")[0].split("/");
        if (s1.length == s2.length) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int i1 = 0;
label0:
        do
        {
label1:
            {
                if (i1 >= s1.length || i1 >= s2.length)
                {
                    break label1;
                }
                String s3 = s1[i1];
                if (!s3.equals(s2[i1]) && !s3.contains("*"))
                {
                    break label0;
                }
                i1++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    private boolean a(JSONObject jsonobject, ActivityInfo activityinfo)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (activityinfo.metaData.getString("io.branch.sdk.auto_link_keys") == null) goto _L2; else goto _L1
_L1:
        int i1;
        int j1;
        activityinfo = activityinfo.metaData.getString("io.branch.sdk.auto_link_keys").split(",");
        j1 = activityinfo.length;
        i1 = 0;
_L7:
        flag = flag1;
        if (i1 >= j1) goto _L2; else goto _L3
_L3:
        if (!jsonobject.has(activityinfo[i1])) goto _L5; else goto _L4
_L4:
        flag = true;
_L2:
        return flag;
_L5:
        i1++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    static Handler b(d d1)
    {
        return d1.p;
    }

    public static d b(Context context)
    {
        return a(context, false);
    }

    private void b(Activity activity)
    {
        if (activity.getWindow().getCallback() instanceof g)
        {
            android.view.Window.Callback callback = g.a((g)activity.getWindow().getCallback());
            activity.getWindow().setCallback(callback);
            n.remove(System.identityHashCode(activity));
            if (p != null)
            {
                p.removeCallbacksAndMessages(null);
            }
        }
    }

    private void b(e e1, Activity activity)
    {
        y = activity;
        if (q() && o() && w == h.a)
        {
            if (e1 != null)
            {
                if (u)
                {
                    e1.a(d(), null);
                } else
                {
                    e1.a(new JSONObject(), null);
                }
            }
            l();
            n();
        } else
        if (w == h.b)
        {
            k.a(e1);
        } else
        {
            w = h.b;
            a(e1);
        }
        if (d.x() && activity != null && n.get(System.identityHashCode(activity)) == null)
        {
            n.put(System.identityHashCode(activity), "init");
            e1 = activity.getWindow().getDecorView().findViewById(0x1020002);
            if (e1 != null)
            {
                e1.setOnTouchListener(o);
            }
        }
    }

    static void b(d d1, Activity activity)
    {
        d1.a(activity);
    }

    private void b(o o1)
    {
        if (w != h.a && !o1.d())
        {
            if (o1 instanceof x)
            {
                Log.i("BranchSDK", "Branch is not initialized, cannot logout");
                return;
            }
            if (o1 instanceof aa)
            {
                Log.i("BranchSDK", "Branch is not initialized, cannot close session");
                return;
            }
            a(((e) (null)));
        }
        k.a(o1);
        j();
    }

    private boolean b(Uri uri, Activity activity)
    {
        if (uri != null && uri.isHierarchical() && activity != null && uri.getQueryParameter(j.a.e.a()) != null)
        {
            d.h(uri.getQueryParameter(j.a.e.a()));
            String s2 = (new StringBuilder()).append("link_click_id=").append(uri.getQueryParameter(j.a.e.a())).toString();
            String s1 = activity.getIntent().getDataString();
            if (uri.getQuery().length() == s2.length())
            {
                uri = (new StringBuilder()).append("\\?").append(s2).toString();
            } else
            if (s1.length() - s2.length() == s1.indexOf(s2))
            {
                uri = (new StringBuilder()).append("&").append(s2).toString();
            } else
            {
                uri = (new StringBuilder()).append(s2).append("&").toString();
            }
            uri = Uri.parse(s1.replaceFirst(uri, ""));
            activity.getIntent().setData(uri);
            return true;
        } else
        {
            return false;
        }
    }

    static boolean b(d d1, boolean flag)
    {
        d1.m = flag;
        return flag;
    }

    private boolean b(JSONObject jsonobject, ActivityInfo activityinfo)
    {
        Object obj = null;
        if (!jsonobject.has(j.a.Z.a())) goto _L2; else goto _L1
_L1:
        String s1 = jsonobject.getString(j.a.Z.a());
_L7:
        if (activityinfo.metaData.getString("io.branch.sdk.auto_link_path") == null || s1 == null) goto _L4; else goto _L3
_L3:
        int i1;
        int j1;
        jsonobject = activityinfo.metaData.getString("io.branch.sdk.auto_link_path").split(",");
        j1 = jsonobject.length;
        i1 = 0;
_L5:
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (a(jsonobject[i1].trim(), s1))
        {
            return true;
        }
        i1++;
        continue; /* Loop/switch isn't completed */
_L2:
        s1 = obj;
        try
        {
            if (jsonobject.has(j.a.aa.a()))
            {
                s1 = jsonobject.getString(j.a.aa.a());
            }
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            s1 = obj;
        }
        continue; /* Loop/switch isn't completed */
        if (true) goto _L5; else goto _L4
_L4:
        return false;
        if (true) goto _L7; else goto _L6
_L6:
    }

    static ag c(d d1)
    {
        return d1.e;
    }

    public static d c(Context context)
    {
        boolean flag = true;
        u = true;
        if (io.branch.referral.i.a(context))
        {
            flag = false;
        }
        a(context, flag);
        b.a((Application)context);
        return b;
    }

    static void c(d d1, Activity activity)
    {
        d1.b(activity);
    }

    static boolean c(d d1, boolean flag)
    {
        d1.q = flag;
        return flag;
    }

    static Context d(d d1)
    {
        return d1.f;
    }

    private static d d(Context context)
    {
        return new d(context.getApplicationContext());
    }

    static ShareLinkManager e(d d1)
    {
        return d1.x;
    }

    static d e()
    {
        return b;
    }

    private android.view.View.OnTouchListener f()
    {
        if (o == null)
        {
            o = new _cls1();
        }
        return o;
    }

    static void f(d d1)
    {
        d1.g();
    }

    static Activity g(d d1)
    {
        return d1.y;
    }

    private void g()
    {
        h();
        if (d.w() && s == null)
        {
            i();
        }
    }

    static h h(d d1)
    {
        return d1.c;
    }

    private void h()
    {
        if (w == h.c) goto _L2; else goto _L1
_L1:
        if (m) goto _L4; else goto _L3
_L3:
        o o1 = k.c();
        if (o1 != null && (o1 instanceof ab) || (o1 instanceof ac))
        {
            k.b();
        }
_L6:
        w = h.c;
_L2:
        return;
_L4:
        if (!k.e())
        {
            b(new aa(f));
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    static y i(d d1)
    {
        return d1.k;
    }

    private void i()
    {
        int i1 = 7;
        ScheduledThreadPoolExecutor scheduledthreadpoolexecutor = (ScheduledThreadPoolExecutor)Executors.newScheduledThreadPool(1);
        _cls2 _lcls2 = new _cls2();
        Date date = new Date();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        int j1 = 7 - calendar.get(7);
        int k1 = 2 - calendar.get(11);
        if (j1 != 0 || k1 >= 0)
        {
            i1 = j1;
        }
        s = scheduledthreadpoolexecutor.scheduleAtFixedRate(_lcls2, (i1 * 24 + k1) * 60 * 60, 0x93a80, TimeUnit.SECONDS);
    }

    static Map j(d d1)
    {
        return d1.r;
    }

    private void j()
    {
        Object obj;
        j.acquire();
        if (l != 0 || k.a() <= 0)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        l = 1;
        obj = k.c();
        j.release();
        if (!(obj instanceof ab) && !q())
        {
            Log.i("BranchSDK", "Branch Error: User session has not been initialized!");
            l = 0;
            a(k.a() - 1, -101);
            return;
        }
        try
        {
            if (!((o) (obj)).d() && (!o() || !p()))
            {
                l = 0;
                a(k.a() - 1, -101);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            return;
        }
        Void avoid[];
    /* block-local class not found */
    class d {}

        obj = new d(((o) (obj)));
        avoid = new Void[0];
        if (!(obj instanceof AsyncTask))
        {
            ((d) (obj)).execute(avoid);
            return;
        }
        AsyncTaskInstrumentation.execute((AsyncTask)obj, avoid);
        return;
        j.release();
        return;
    }

    private void k()
    {
        int i1 = 0;
_L8:
        if (i1 >= k.a()) goto _L2; else goto _L1
_L1:
        Object obj;
        Iterator iterator;
        obj = k.a(i1);
        if (((o) (obj)).g() == null)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        iterator = ((o) (obj)).g().keys();
_L5:
        String s1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_129;
        }
        s1 = (String)iterator.next();
        if (!s1.equals(j.a.d.a())) goto _L4; else goto _L3
_L3:
        ((o) (obj)).g().put(s1, d.i());
          goto _L5
        obj;
        ((JSONException) (obj)).printStackTrace();
_L2:
        return;
_L4:
        if (!s1.equals(j.a.a.a())) goto _L5; else goto _L6
_L6:
        ((o) (obj)).g().put(s1, d.j());
          goto _L5
        i1++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    static void k(d d1)
    {
        d1.k();
    }

    private void l()
    {
        if (h == null)
        {
            return;
        } else
        {
            h.cancel();
            h.purge();
            h = new Timer();
            return;
        }
    }

    static void l(d d1)
    {
        d1.r();
    }

    private void m()
    {
        if (g == null)
        {
            return;
        } else
        {
            g.cancel();
            g.purge();
            g = new Timer();
            return;
        }
    }

    static boolean m(d d1)
    {
        return d1.m;
    }

    static h n(d d1)
    {
        return d1.w;
    }

    private void n()
    {
        i = true;
        synchronized (a)
        {
            m();
            g.schedule(new _cls3(), 2000L);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static void o(d d1)
    {
        d1.j();
    }

    private boolean o()
    {
        return !d.i().equals("bnc_no_value");
    }

    private boolean p()
    {
        return !d.h().equals("bnc_no_value");
    }

    static boolean p(d d1)
    {
        return d1.q;
    }

    private boolean q()
    {
        return !d.j().equals("bnc_no_value");
    }

    private void r()
    {
        Object obj;
        Object obj1;
        JSONObject jsonobject;
        int i1;
        i1 = 0;
        jsonobject = d();
        obj1 = null;
        obj = obj1;
        if (!jsonobject.has(j.a.X.a())) goto _L2; else goto _L1
_L1:
        obj = obj1;
        if (!jsonobject.getBoolean(j.a.X.a()))
        {
            return;
        }
        obj = obj1;
        if (jsonobject.length() <= 0) goto _L2; else goto _L3
_L3:
        obj = obj1;
        Object obj2 = f.getPackageManager().getApplicationInfo(f.getPackageName(), 128);
        obj = obj1;
        if (((ApplicationInfo) (obj2)).metaData == null) goto _L5; else goto _L4
_L4:
        obj = obj1;
        if (((ApplicationInfo) (obj2)).metaData.getBoolean("io.branch.sdk.auto_link_disable", false)) goto _L2; else goto _L5
_L5:
        obj = obj1;
        ActivityInfo aactivityinfo[] = f.getPackageManager().getPackageInfo(f.getPackageName(), 129).activities;
        obj = obj1;
        int j1 = aactivityinfo.length;
_L21:
        if (i1 >= j1) goto _L7; else goto _L6
_L6:
        obj2 = aactivityinfo[i1];
        obj = obj1;
        if (((ActivityInfo) (obj2)).metaData == null) goto _L9; else goto _L8
_L8:
        obj = obj1;
        if (((ActivityInfo) (obj2)).metaData.getString("io.branch.sdk.auto_link_keys") != null) goto _L11; else goto _L10
_L10:
        obj = obj1;
        if (((ActivityInfo) (obj2)).metaData.getString("io.branch.sdk.auto_link_path") == null) goto _L9; else goto _L11
_L11:
        obj = obj1;
        if (a(jsonobject, ((ActivityInfo) (obj2)))) goto _L13; else goto _L12
_L12:
        obj = obj1;
        if (!b(jsonobject, ((ActivityInfo) (obj2)))) goto _L9; else goto _L13
_L13:
        obj = obj1;
        obj1 = ((ActivityInfo) (obj2)).name;
        obj = obj1;
        i1 = ((ActivityInfo) (obj2)).metaData.getInt("io.branch.sdk.auto_link_request_code", 1501);
        obj = obj1;
_L19:
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        String s1;
        if (y == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj2 = new Intent(y, Class.forName(((String) (obj))));
        ((Intent) (obj2)).putExtra("io.branch.sdk.auto_linked", "true");
        s1 = j.a.x.a();
        if (jsonobject instanceof JSONObject) goto _L15; else goto _L14
_L14:
        obj1 = jsonobject.toString();
_L17:
        ((Intent) (obj2)).putExtra(s1, ((String) (obj1)));
        String s2;
        for (obj1 = jsonobject.keys(); ((Iterator) (obj1)).hasNext(); ((Intent) (obj2)).putExtra(s2, jsonobject.getString(s2)))
        {
            s2 = (String)((Iterator) (obj1)).next();
        }

          goto _L16
_L9:
        if (false)
        {
            i1 = 1501;
            obj = null;
            continue; /* Loop/switch isn't completed */
        }
        i1++;
        continue; /* Loop/switch isn't completed */
_L15:
        obj1 = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
          goto _L17
_L16:
        try
        {
            y.startActivityForResult(((Intent) (obj2)), i1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.i("BranchSDK", "Branch Warning: Please make sure Activity names set for auto deep link are correct!");
            return;
        }
        catch (ClassNotFoundException classnotfoundexception) { }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
_L18:
        Log.i("BranchSDK", (new StringBuilder()).append("Branch Warning: Please make sure Activity names set for auto deep link are correct! Error while looking for activity ").append(((String) (obj))).toString());
        return;
        ClassNotFoundException classnotfoundexception1;
        classnotfoundexception1;
        if (true) goto _L18; else goto _L7
_L7:
        i1 = 1501;
        obj = null;
        if (true) goto _L19; else goto _L2
_L2:
        return;
        if (true) goto _L21; else goto _L20
_L20:
    }

    public boolean a(Uri uri, Activity activity)
    {
        boolean flag = b(uri, activity);
        a(((e) (null)), activity);
        return flag;
    }

    public boolean a(e e1, Activity activity)
    {
        d.r();
        b(e1, activity);
        return false;
    }

    public boolean a(e e1, Uri uri, Activity activity)
    {
        boolean flag = b(uri, activity);
        a(e1, activity);
        return flag;
    }

    public void b()
    {
        d.u();
    }

    public JSONObject c()
    {
        return a(d.o());
    }

    public JSONObject d()
    {
        return a(d.n());
    }


    // Unreferenced inner class io/branch/referral/d$b
    /* block-local class not found */
    class b {}


    // Unreferenced inner class io/branch/referral/d$c
    /* block-local class not found */
    class c {}


    // Unreferenced inner class io/branch/referral/d$f
    /* block-local class not found */
    class f {}


    // Unreferenced inner class io/branch/referral/d$i
    /* block-local class not found */
    class i {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}

}
