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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import myobfuscated.f.m;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package io.branch.referral:
//            s, o, ao, af, 
//            BranchApp, c, u, f, 
//            m, i, aj, ai, 
//            InstallListener, j, ah, ad, 
//            h, l, an, x, 
//            ae

public final class Branch
{

    private static Branch c;
    private static boolean s = false;
    private static boolean t = false;
    private static CUSTOM_REFERRABLE_SETTINGS w;
    public Context a;
    Map b;
    private o d;
    private s e;
    private ao f;
    private Object g;
    private Timer h;
    private Timer i;
    private Semaphore j;
    private af k;
    private int l;
    private boolean m;
    private SparseArray n;
    private android.view.View.OnTouchListener o;
    private Handler p;
    private boolean q;
    private ScheduledFuture r;
    private SESSION_STATE u;
    private Activity v;
    private boolean x;

    private Branch(Context context)
    {
        u = SESSION_STATE.UNINITIALISED;
        x = false;
        e = io.branch.referral.s.a(context);
        d = new o(context);
        f = new ao(context);
        k = af.a(context);
        j = new Semaphore(1);
        h = new Timer();
        i = new Timer();
        g = new Object();
        l = 0;
        m = true;
        n = new SparseArray();
        if (o == null)
        {
            o = new _cls1();
        }
        o = o;
        p = new Handler();
        q = false;
        b = new HashMap();
    }

    static Activity a(Branch branch, Activity activity)
    {
        branch.v = activity;
        return activity;
    }

    static SESSION_STATE a(Branch branch, SESSION_STATE session_state)
    {
        branch.u = session_state;
        return session_state;
    }

    public static Branch a()
    {
        if (c != null) goto _L2; else goto _L1
_L1:
        Log.e("BranchSDK", "Branch instance is not created yet. Make sure you have initialised Branch. [Consider Calling getInstance(Context ctx) if you still have issue.]");
_L4:
        return c;
_L2:
        if (s && !t)
        {
            Log.e("BranchSDK", "Branch instance is not properly initialised. Make sure your Application class is extending BranchApp class. If you are not extending BranchApp class make sure you are initialising Branch in your Applications onCreate()");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static Branch a(Context context)
    {
        return a(context, true);
    }

    private static Branch a(Context context, boolean flag)
    {
        if (c == null)
        {
            Object obj = new Branch(context.getApplicationContext());
            c = ((Branch) (obj));
            obj = ((Branch) (obj)).e.a(flag);
            if (obj == null || ((String) (obj)).equalsIgnoreCase("bnc_no_value"))
            {
                Log.i("BranchSDK", "Branch Warning: Please enter your branch_key in your project's Manifest file!");
                flag = c.e.a("bnc_no_value");
            } else
            {
                flag = c.e.a(((String) (obj)));
            }
            if (flag)
            {
                c.b.clear();
                c.k.e();
            }
        }
        c.a = context.getApplicationContext();
        if (context instanceof BranchApp)
        {
            s = true;
            c.a((Application)context);
        }
        return c;
    }

    static s a(Branch branch)
    {
        return branch.e;
    }

    private static JSONObject a(String s1)
    {
        if (s1.equals("bnc_no_value"))
        {
            return new JSONObject();
        }
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject(s1);
        }
        catch (JSONException jsonexception)
        {
            s1 = s1.getBytes();
            int i1 = s1.length;
            c c1 = new c(2, new byte[(i1 * 3) / 4]);
            if (!c1.a(s1, 0, i1))
            {
                throw new IllegalArgumentException("bad base-64");
            }
            if (c1.b == c1.a.length)
            {
                s1 = c1.a;
            } else
            {
                s1 = new byte[c1.b];
                System.arraycopy(c1.a, 0, s1, 0, c1.b);
            }
            try
            {
                s1 = new JSONObject(new String(s1));
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
        u u1;
        if (i1 >= k.b())
        {
            u1 = k.a(k.b() - 1);
        } else
        {
            u1 = k.a(i1);
        }
        if (u1 != null)
        {
            u1.a(j1, "");
        }
    }

    private void a(Application application)
    {
        try
        {
            f f1 = new f(this, (byte)0);
            application.unregisterActivityLifecycleCallbacks(f1);
            application.registerActivityLifecycleCallbacks(f1);
            t = true;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Application application) { }
        // Misplaced declaration of an exception variable
        catch (Application application) { }
        t = false;
        s = false;
        Log.w("BranchSDK", (new io.branch.referral.m("", -108)).a);
    }

    static void a(Branch branch, int i1)
    {
        branch.a(0, i1);
    }

    static void a(Branch branch, u u1)
    {
        branch.a(u1);
    }

    private void a(i i1, Activity activity, boolean flag)
    {
        v = activity;
        if (h() && g() && u == SESSION_STATE.INITIALISED)
        {
            if (i1 != null)
            {
                if (s)
                {
                    if (!x)
                    {
                        i1.a(b(), null);
                        x = true;
                    } else
                    {
                        i1.a(new JSONObject(), null);
                    }
                } else
                {
                    i1.a(new JSONObject(), null);
                }
            }
            if (i != null)
            {
                i.cancel();
                i.purge();
                i = new Timer();
            }
            synchronized (g)
            {
                if (h != null)
                {
                    h.cancel();
                    h.purge();
                    h = new Timer();
                }
                h.schedule(new _cls3(), 2000L);
            }
        } else
        {
            if (flag)
            {
                io.branch.referral.s.e("bnc_is_referrable", 1);
            } else
            {
                io.branch.referral.s.e("bnc_is_referrable", 0);
            }
            if (u == SESSION_STATE.INITIALISING)
            {
                k.a(i1);
            } else
            {
                u = SESSION_STATE.INITIALISING;
                if ((io.branch.referral.s.d() == null || io.branch.referral.s.d().equalsIgnoreCase("bnc_no_value")) && (e.c() == null || e.c().equalsIgnoreCase("bnc_no_value")))
                {
                    u = SESSION_STATE.UNINITIALISED;
                    if (i1 != null)
                    {
                        i1.a(null, new io.branch.referral.m("Trouble initializing Branch.", -1234));
                    }
                    Log.i("BranchSDK", "Branch Warning: Please enter your branch_key in your project's res/values/strings.xml!");
                } else
                {
                    if (io.branch.referral.s.d() != null && io.branch.referral.s.d().startsWith("key_test_"))
                    {
                        Log.i("BranchSDK", "Branch Warning: You are using your test app's Branch Key. Remember to change it to live Branch Key during deployment.");
                    }
                    if (h())
                    {
                        a(((u) (new aj(a, i1, d.a))), i1);
                    } else
                    {
                        a(((u) (new ai(a, i1, d.a, InstallListener.a()))), i1);
                    }
                }
            }
        }
        if (io.branch.referral.s.k() && activity != null && n.get(System.identityHashCode(activity)) == null)
        {
            n.put(System.identityHashCode(activity), "init");
            i1 = activity.getWindow().getDecorView().findViewById(0x1020002);
            if (i1 != null)
            {
                i1.setOnTouchListener(o);
            }
        }
        return;
        activity;
        i1;
        JVM INSTR monitorexit ;
        throw activity;
    }

    private void a(u u1, i i1)
    {
        if (k.g()) goto _L2; else goto _L1
_L1:
        if (l == 0)
        {
            k.a(u1, 0);
        } else
        {
            k.a(u1, 1);
        }
_L6:
        f();
        return;
_L2:
        af af1;
        int j1;
        k.a(i1);
        af1 = k;
        j1 = l;
        i1 = af1.a;
        i1;
        JVM INSTR monitorenter ;
        Iterator iterator = af1.a.iterator();
_L4:
        u u2;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_130;
            }
            u2 = (u)iterator.next();
        } while (u2 == null);
        if (!(u2 instanceof ai) && !(u2 instanceof aj)) goto _L4; else goto _L3
_L3:
        iterator.remove();
        i1;
        JVM INSTR monitorexit ;
        if (j1 == 0)
        {
            af1.a(u1, 0);
        } else
        {
            af1.a(u1, 1);
        }
        if (true) goto _L6; else goto _L5
_L5:
        u1;
        i1;
        JVM INSTR monitorexit ;
        throw u1;
    }

    static boolean a(Branch branch, boolean flag)
    {
        branch.m = flag;
        return flag;
    }

    private static boolean a(JSONObject jsonobject, ActivityInfo activityinfo)
    {
        String as[] = null;
        if (!jsonobject.has(Defines.Jsonkey.AndroidDeepLinkPath.getKey())) goto _L2; else goto _L1
_L1:
        Object obj = jsonobject.getString(Defines.Jsonkey.AndroidDeepLinkPath.getKey());
_L7:
        if (activityinfo.metaData.getString("io.branch.sdk.auto_link_path") == null || obj == null) goto _L4; else goto _L3
_L3:
        int j1;
        int k1;
        jsonobject = activityinfo.metaData.getString("io.branch.sdk.auto_link_path").split(",");
        k1 = jsonobject.length;
        j1 = 0;
_L10:
        int i1;
        if (j1 >= k1) goto _L4; else goto _L5
_L2:
        obj = as;
        if (!jsonobject.has(Defines.Jsonkey.DeepLinkPath.getKey())) goto _L7; else goto _L6
_L6:
        obj = jsonobject.getString(Defines.Jsonkey.DeepLinkPath.getKey());
          goto _L7
_L5:
        activityinfo = jsonobject[j1].trim().split("\\?")[0].split("/");
        as = ((String) (obj)).split("\\?")[0].split("/");
        if (activityinfo.length != as.length)
        {
            i1 = 0;
            break MISSING_BLOCK_LABEL_122;
        }
        i1 = 0;
_L9:
label0:
        {
            if (i1 >= activityinfo.length || i1 >= as.length)
            {
                break MISSING_BLOCK_LABEL_236;
            }
            String s1 = activityinfo[i1];
            if (s1.equals(as[i1]) || s1.contains("*"))
            {
                break label0;
            }
            i1 = 0;
        }
          goto _L8
        i1++;
          goto _L9
_L8:
        if (i1 != 0)
        {
            return true;
        }
        j1++;
          goto _L10
_L4:
        return false;
        jsonobject;
        obj = as;
          goto _L7
        i1 = 1;
          goto _L8
    }

    static Handler b(Branch branch)
    {
        return branch.p;
    }

    public static Branch b(Context context)
    {
        return a(context, false);
    }

    static void b(Branch branch, Activity activity)
    {
        if (activity != null && branch.n.get(System.identityHashCode(activity)) == null)
        {
            branch.n.put(System.identityHashCode(activity), "init");
            activity.getWindow().setCallback(new j(branch, activity.getWindow().getCallback()));
        }
    }

    static boolean b(Branch branch, boolean flag)
    {
        branch.x = flag;
        return flag;
    }

    public static Branch c(Context context)
    {
        boolean flag = true;
        s = true;
        w = CUSTOM_REFERRABLE_SETTINGS.USE_DEFAULT;
        if (myobfuscated.f.m.c(context))
        {
            flag = false;
        }
        a(context, flag);
        c.a((Application)context);
        return c;
    }

    static ao c(Branch branch)
    {
        return branch.f;
    }

    static void c(Branch branch, Activity activity)
    {
        if (activity.getWindow().getCallback() instanceof j)
        {
            android.view.Window.Callback callback = io.branch.referral.j.a((j)activity.getWindow().getCallback());
            activity.getWindow().setCallback(callback);
            branch.n.remove(System.identityHashCode(activity));
            if (branch.p != null)
            {
                branch.p.removeCallbacksAndMessages(null);
            }
        }
    }

    static boolean c()
    {
        return false;
    }

    static boolean c(Branch branch, boolean flag)
    {
        branch.q = flag;
        return flag;
    }

    static Context d(Branch branch)
    {
        return branch.a;
    }

    static m d()
    {
        return null;
    }

    static Branch e()
    {
        return c;
    }

    static void e(Branch branch)
    {
        int i1 = 7;
        if (branch.u == SESSION_STATE.UNINITIALISED) goto _L2; else goto _L1
_L1:
        if (branch.m) goto _L4; else goto _L3
_L3:
        u u1 = branch.k.d();
        if (u1 != null && (u1 instanceof ai) || (u1 instanceof aj))
        {
            branch.k.c();
        }
_L6:
        branch.u = SESSION_STATE.UNINITIALISED;
_L2:
        if (io.branch.referral.s.j() && branch.r == null)
        {
            ScheduledThreadPoolExecutor scheduledthreadpoolexecutor = (ScheduledThreadPoolExecutor)Executors.newScheduledThreadPool(1);
            _cls2 _lcls2 = new _cls2(branch);
            Date date = new Date();
            Calendar calendar = GregorianCalendar.getInstance();
            calendar.setTime(date);
            int j1 = 7 - calendar.get(7);
            int k1 = 2 - calendar.get(11);
            if (j1 != 0 || k1 >= 0)
            {
                i1 = j1;
            }
            branch.r = scheduledthreadpoolexecutor.scheduleAtFixedRate(_lcls2, (i1 * 24 + k1) * 60 * 60, 0x93a80L, TimeUnit.SECONDS);
        }
        return;
_L4:
        if (!branch.k.f())
        {
            branch.a(new ah(branch.a));
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    static Activity f(Branch branch)
    {
        return branch.v;
    }

    private void f()
    {
        boolean flag = true;
        j.acquire();
        if (l != 0 || k.b() <= 0) goto _L2; else goto _L1
_L1:
        Object obj;
        l = 1;
        obj = k.d();
        j.release();
        if (obj == null) goto _L4; else goto _L3
_L3:
        if (!(obj instanceof ai) && !h())
        {
            Log.i("BranchSDK", "Branch Error: User session has not been initialized!");
            l = 0;
            a(k.b() - 1, -101);
            return;
        }
        if (obj instanceof ad) goto _L6; else goto _L5
_L5:
        if (!g()) goto _L8; else goto _L7
_L7:
        if (io.branch.referral.s.c("bnc_device_fingerprint_id").equals("bnc_no_value"))
        {
            flag = false;
        }
          goto _L9
_L8:
        try
        {
            l = 0;
            a(k.b() - 1, -101);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
        }
        return;
_L6:
        (new h(this, ((u) (obj)))).execute(new Void[0]);
        return;
_L4:
        k.a(null);
        return;
_L2:
        j.release();
        return;
_L9:
        if (flag) goto _L6; else goto _L8
    }

    static o g(Branch branch)
    {
        return branch.d;
    }

    private boolean g()
    {
        return !io.branch.referral.s.c("bnc_session_id").equals("bnc_no_value");
    }

    static af h(Branch branch)
    {
        return branch.k;
    }

    private boolean h()
    {
        return !io.branch.referral.s.c("bnc_identity_id").equals("bnc_no_value");
    }

    static int i(Branch branch)
    {
        branch.l = 0;
        return 0;
    }

    static Map j(Branch branch)
    {
        return branch.b;
    }

    static void k(Branch branch)
    {
        int i1 = 0;
_L10:
        if (i1 >= branch.k.b()) goto _L2; else goto _L1
_L1:
        u u1;
        Iterator iterator;
        u1 = branch.k.a(i1);
        if (u1.a == null)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        iterator = u1.a.keys();
_L5:
        String s1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_158;
        }
        s1 = (String)iterator.next();
        if (!s1.equals(Defines.Jsonkey.SessionID.getKey())) goto _L4; else goto _L3
_L3:
        u1.a.put(s1, io.branch.referral.s.c("bnc_session_id"));
          goto _L5
        branch;
        branch.printStackTrace();
_L2:
        return;
_L4:
        if (!s1.equals(Defines.Jsonkey.IdentityID.getKey())) goto _L7; else goto _L6
_L6:
        u1.a.put(s1, io.branch.referral.s.c("bnc_identity_id"));
          goto _L5
_L7:
        if (!s1.equals(Defines.Jsonkey.DeviceFingerprintID.getKey())) goto _L5; else goto _L8
_L8:
        u1.a.put(s1, io.branch.referral.s.c("bnc_device_fingerprint_id"));
          goto _L5
        i1++;
        if (true) goto _L10; else goto _L9
_L9:
    }

    static void l(Branch branch)
    {
        String s1;
        Object obj;
        JSONObject jsonobject;
        jsonobject = branch.b();
        obj = null;
        s1 = ((String) (obj));
        if (!jsonobject.has(Defines.Jsonkey.Clicked_Branch_Link.getKey()))
        {
            break MISSING_BLOCK_LABEL_498;
        }
        s1 = ((String) (obj));
        if (!jsonobject.getBoolean(Defines.Jsonkey.Clicked_Branch_Link.getKey()))
        {
            return;
        }
        s1 = ((String) (obj));
        if (jsonobject.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_498;
        }
        s1 = ((String) (obj));
        Object obj1 = branch.a.getPackageManager().getApplicationInfo(branch.a.getPackageName(), 128);
        s1 = ((String) (obj));
        if (((ApplicationInfo) (obj1)).metaData == null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        s1 = ((String) (obj));
        if (((ApplicationInfo) (obj1)).metaData.getBoolean("io.branch.sdk.auto_link_disable", false))
        {
            break MISSING_BLOCK_LABEL_498;
        }
        s1 = ((String) (obj));
        ActivityInfo aactivityinfo[] = branch.a.getPackageManager().getPackageInfo(branch.a.getPackageName(), 129).activities;
        if (aactivityinfo == null) goto _L2; else goto _L1
_L1:
        s1 = ((String) (obj));
        int k1 = aactivityinfo.length;
        int i1 = 0;
_L19:
        if (i1 >= k1) goto _L2; else goto _L3
_L3:
        obj1 = aactivityinfo[i1];
        if (obj1 == null) goto _L5; else goto _L4
_L4:
        s1 = ((String) (obj));
        if (((ActivityInfo) (obj1)).metaData == null) goto _L5; else goto _L6
_L6:
        s1 = ((String) (obj));
        if (((ActivityInfo) (obj1)).metaData.getString("io.branch.sdk.auto_link_keys") != null) goto _L8; else goto _L7
_L7:
        s1 = ((String) (obj));
        if (((ActivityInfo) (obj1)).metaData.getString("io.branch.sdk.auto_link_path") == null) goto _L5; else goto _L8
_L8:
        s1 = ((String) (obj));
        if (((ActivityInfo) (obj1)).metaData.getString("io.branch.sdk.auto_link_keys") == null) goto _L10; else goto _L9
_L9:
        s1 = ((String) (obj));
        String as[] = ((ActivityInfo) (obj1)).metaData.getString("io.branch.sdk.auto_link_keys").split(",");
        s1 = ((String) (obj));
        int l1 = as.length;
        int j1 = 0;
_L17:
        if (j1 >= l1) goto _L10; else goto _L11
_L11:
        s1 = ((String) (obj));
        if (!jsonobject.has(as[j1])) goto _L13; else goto _L12
_L12:
        j1 = 1;
_L18:
        if (j1 != 0) goto _L15; else goto _L14
_L14:
        s1 = ((String) (obj));
        if (!a(jsonobject, ((ActivityInfo) (obj1)))) goto _L5; else goto _L15
_L15:
        s1 = ((String) (obj));
        obj = ((ActivityInfo) (obj1)).name;
        s1 = ((String) (obj));
        i1 = ((ActivityInfo) (obj1)).metaData.getInt("io.branch.sdk.auto_link_request_code", 1501);
        s1 = ((String) (obj));
_L21:
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_498;
        }
        if (branch.v == null)
        {
            break MISSING_BLOCK_LABEL_498;
        }
        obj = new Intent(branch.v, Class.forName(s1));
        ((Intent) (obj)).putExtra("io.branch.sdk.auto_linked", "true");
        ((Intent) (obj)).putExtra(Defines.Jsonkey.ReferringData.getKey(), jsonobject.toString());
        String s2;
        for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); ((Intent) (obj)).putExtra(s2, jsonobject.getString(s2)))
        {
            s2 = (String)iterator.next();
        }

          goto _L16
_L13:
        j1++;
          goto _L17
_L10:
        j1 = 0;
          goto _L18
_L5:
        i1++;
          goto _L19
_L16:
        try
        {
            branch.v.startActivityForResult(((Intent) (obj)), i1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Branch branch)
        {
            Log.i("BranchSDK", "Branch Warning: Please make sure Activity names set for auto deep link are correct!");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Branch branch) { }
        // Misplaced declaration of an exception variable
        catch (Branch branch)
        {
            return;
        }
_L20:
        Log.i("BranchSDK", (new StringBuilder("Branch Warning: Please make sure Activity names set for auto deep link are correct! Error while looking for activity ")).append(s1).toString());
        return;
        branch;
        if (true) goto _L20; else goto _L2
_L2:
        i1 = 0;
        s1 = null;
          goto _L21
          goto _L18
    }

    static boolean m(Branch branch)
    {
        return branch.m;
    }

    static SESSION_STATE n(Branch branch)
    {
        return branch.u;
    }

    static void o(Branch branch)
    {
        branch.f();
    }

    static boolean p(Branch branch)
    {
        return branch.q;
    }

    final String a(x x1)
    {
        if (u != SESSION_STATE.INITIALISED) goto _L2; else goto _L1
_L1:
        an an1;
        int i1 = io.branch.referral.s.b();
        an1 = (an)(new l(this, (byte)0)).execute(new u[] {
            x1
        }).get(i1 + 2000, TimeUnit.MILLISECONDS);
_L4:
        x1 = x1.f();
        if (an1 == null || an1.a != 200)
        {
            break; /* Loop/switch isn't completed */
        }
        InterruptedException interruptedexception;
        String s1;
        try
        {
            s1 = an1.a().getString("url");
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return x1;
        }
        x1 = s1;
        if (an1.d == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        x1 = s1;
        b.put(an1.d, s1);
        return s1;
        interruptedexception;
_L5:
        interruptedexception = null;
        if (true) goto _L4; else goto _L3
_L2:
        Log.i("BranchSDK", "Branch Warning: User session has not been initialized");
        return null;
        Object obj;
        obj;
          goto _L5
        obj;
          goto _L5
_L3:
        return x1;
    }

    public final void a(u u1)
    {
        if (u != SESSION_STATE.INITIALISED && !(u1 instanceof ad))
        {
            if (u1 instanceof ae)
            {
                u1.a(-101, "");
                Log.i("BranchSDK", "Branch is not initialized, cannot logout");
                return;
            }
            if (u1 instanceof ah)
            {
                Log.i("BranchSDK", "Branch is not initialized, cannot close session");
                return;
            }
            af af1;
            if (w == CUSTOM_REFERRABLE_SETTINGS.USE_DEFAULT)
            {
                a(null, v, true);
            } else
            {
                boolean flag;
                if (w == CUSTOM_REFERRABLE_SETTINGS.REFERRABLE)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                a(null, v, flag);
            }
        }
        af1 = k;
        if (u1 != null)
        {
            af1.a.add(u1);
            if (af1.b() >= 25)
            {
                af1.a.remove(1);
            }
            af1.a();
        }
        f();
    }

    public final boolean a(Uri uri, Activity activity)
    {
        if (uri != null && uri.isHierarchical() && activity != null)
        {
            if (uri.getQueryParameter(Defines.Jsonkey.LinkClickID.getKey()) != null)
            {
                io.branch.referral.s.a("bnc_link_click_identifier", uri.getQueryParameter(Defines.Jsonkey.LinkClickID.getKey()));
                String s3 = (new StringBuilder("link_click_id=")).append(uri.getQueryParameter(Defines.Jsonkey.LinkClickID.getKey())).toString();
                String s1 = activity.getIntent().getDataString();
                if (uri.getQuery().length() == s3.length())
                {
                    uri = (new StringBuilder("\\?")).append(s3).toString();
                } else
                if (s1.length() - s3.length() == s1.indexOf(s3))
                {
                    uri = (new StringBuilder("&")).append(s3).toString();
                } else
                {
                    uri = (new StringBuilder()).append(s3).append("&").toString();
                }
                uri = Uri.parse(s1.replaceFirst(uri, ""));
                activity.getIntent().setData(uri);
                return true;
            }
            String s2 = uri.getScheme();
            if (s2 != null && (s2.equalsIgnoreCase("http") || s2.equalsIgnoreCase("https")) && uri.getHost() != null && uri.getHost().length() > 0)
            {
                io.branch.referral.s.a("bnc_app_link", uri.toString());
                return false;
            }
        }
        if (uri == null)
        {
            break MISSING_BLOCK_LABEL_275;
        }
        io.branch.referral.s.a("bnc_external_intent_uri", uri.toString());
        if (activity == null)
        {
            break MISSING_BLOCK_LABEL_383;
        }
        if (activity.getIntent() == null || activity.getIntent().getExtras() == null)
        {
            break MISSING_BLOCK_LABEL_383;
        }
        uri = activity.getIntent().getExtras();
        Object obj = uri.keySet();
        if (((Set) (obj)).size() <= 0)
        {
            break MISSING_BLOCK_LABEL_383;
        }
        activity = new JSONObject();
        String s4;
        for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); activity.put(s4, uri.get(s4)))
        {
            s4 = (String)((Iterator) (obj)).next();
        }

        try
        {
            io.branch.referral.s.a("bnc_external_intent_extra", activity.toString());
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri) { }
        return false;
    }

    public final boolean a(i i1, Activity activity)
    {
        boolean flag = true;
        if (w == CUSTOM_REFERRABLE_SETTINGS.USE_DEFAULT)
        {
            a(i1, activity, true);
            return false;
        }
        if (w != CUSTOM_REFERRABLE_SETTINGS.REFERRABLE)
        {
            flag = false;
        }
        a(i1, activity, flag);
        return false;
    }

    public final JSONObject b()
    {
        return a(io.branch.referral.s.c("bnc_session_params"));
    }

    static 
    {
        w = CUSTOM_REFERRABLE_SETTINGS.USE_DEFAULT;
    }

    /* member class not found */
    class SESSION_STATE {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class CUSTOM_REFERRABLE_SETTINGS {}


    /* member class not found */
    class _cls2 {}

}
