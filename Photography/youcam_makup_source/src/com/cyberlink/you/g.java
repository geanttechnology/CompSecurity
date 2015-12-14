// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.CountDownTimer;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import com.cyberlink.you.database.o;
import com.cyberlink.you.friends.UserInfo;
import com.cyberlink.you.friends.l;
import com.cyberlink.you.friends.s;
import com.cyberlink.you.utility.aa;
import com.cyberlink.you.utility.ab;
import com.cyberlink.you.utility.d;
import com.cyberlink.you.utility.n;
import com.cyberlink.you.utility.q;
import com.cyberlink.you.utility.r;
import com.cyberlink.you.utility.x;
import com.cyberlink.you.utility.y;
import com.cyberlink.you.utility.z;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.e;
import com.nostra13.universalimageloader.core.f;
import com.nostra13.universalimageloader.core.i;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.you:
//            h, d, a, e, 
//            r

public class g extends ContextWrapper
{

    private static h D = new h();
    public static Activity a = null;
    public static boolean b = true;
    public static final SimpleDateFormat c = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS", Locale.getDefault());
    public static com.nostra13.universalimageloader.core.d d = null;
    public static com.nostra13.universalimageloader.core.d e = null;
    public static q f;
    public static q g;
    public static q h;
    public static ThreadPoolExecutor i;
    private static g j;
    private static Context k;
    private static Application l;
    private static String n;
    private static String o;
    private static String p;
    private static List r = new ArrayList();
    private static CountDownTimer s;
    private static q t;
    private static String u = null;
    private static long v = 0L;
    private static long w = 0L;
    private static final int x;
    private static ThreadGroup y = new ThreadGroup("NetAsyncTask");
    private File A;
    private boolean B;
    private boolean C;
    private Map E;
    private String m;
    private s q;
    private File z;

    private g(Context context)
    {
        super(context);
        m = "";
        q = null;
        z = null;
        A = null;
        B = false;
        C = false;
        E = null;
    }

    public static Context I()
    {
        return a();
    }

    public static Resources J()
    {
        Context context = I();
        if (context == null)
        {
            return null;
        } else
        {
            return context.getResources();
        }
    }

    public static String O()
    {
        String s1 = "ymk";
        String s2 = a().getPackageName();
        if (s2.equalsIgnoreCase("com.cyberlink.youperfect"))
        {
            s1 = "ycp";
        } else
        {
            if (s2.equalsIgnoreCase("com.cyberlink.youcammakeup"))
            {
                return "ymk";
            }
            if (s2.equalsIgnoreCase("com.perfectcorp.beautycircle"))
            {
                return "bc";
            }
        }
        return s1;
    }

    static ThreadGroup P()
    {
        return y;
    }

    static List Q()
    {
        return r;
    }

    static CountDownTimer R()
    {
        return s;
    }

    private boolean S()
    {
        return (new File((new StringBuilder()).append(com.cyberlink.you.utility.d.d(d.a)).append("debug").toString())).exists();
    }

    static CountDownTimer a(CountDownTimer countdowntimer)
    {
        s = countdowntimer;
        return countdowntimer;
    }

    public static g a()
    {
        return c(a);
    }

    static void a(g g1, Throwable throwable)
    {
        g1.a(throwable);
    }

    private void a(Throwable throwable)
    {
        Process.killProcess(Process.myPid());
    }

    public static String b(int i1)
    {
        Resources resources = J();
        if (resources == null)
        {
            return null;
        } else
        {
            return resources.getString(i1);
        }
    }

    public static void b(Context context)
    {
        k = context;
    }

    public static g c(Context context)
    {
        if (j == null)
        {
            Context context1 = context;
            if (context == null)
            {
                context1 = k;
            }
            (new g(context1.getApplicationContext())).a(context1);
            com.cyberlink.you.a.a().b();
        }
        return j;
    }

    private void h(Context context)
    {
        int i1 = (int)Runtime.getRuntime().maxMemory() / 8;
        Object obj = new x();
        i(context);
        obj = new aa(z, ((com.nostra13.universalimageloader.a.a.b.a) (obj)), 0x3200000);
        ((aa) (obj)).a(android.graphics.Bitmap.CompressFormat.JPEG);
        ((aa) (obj)).a(60);
        obj = (new i(context)).b(3).a(((com.nostra13.universalimageloader.a.a.a) (obj))).c(i1).a(1280, 1280, null).a(QueueProcessingType.b).a(new z(context)).a(new y(false)).b().c();
        com.nostra13.universalimageloader.core.f.b().a(((com.nostra13.universalimageloader.core.h) (obj)));
        if (d == null)
        {
            d = (new e()).a(ImageScaleType.a).b(true).c(true).d(true).a(android.graphics.Bitmap.Config.RGB_565).a();
        }
        obj = new ab();
        j(context);
        obj = new aa(A, ((com.nostra13.universalimageloader.a.a.b.a) (obj)), 0x500000);
        ((aa) (obj)).a(android.graphics.Bitmap.CompressFormat.PNG);
        ((aa) (obj)).a(60);
        context = (new i(context)).b(3).a(((com.nostra13.universalimageloader.a.a.a) (obj))).c(0x200000).a(1280, 1280, null).a(QueueProcessingType.b).a(new z(context)).a(new y(false)).b().c();
        com.cyberlink.you.utility.n.a().a(context);
        if (e == null)
        {
            e = (new e()).a(ImageScaleType.a).b(true).c(true).d(true).a(android.graphics.Bitmap.Config.ARGB_8888).a();
        }
    }

    private String i(Context context)
    {
        Object obj = null;
        this;
        JVM INSTR monitorenter ;
        if (z != null && !z.exists())
        {
            z = null;
        }
        if (z != null) goto _L2; else goto _L1
_L1:
        context = context.getCacheDir();
        if (context != null) goto _L4; else goto _L3
_L3:
        context = obj;
_L6:
        this;
        JVM INSTR monitorexit ;
        return context;
_L4:
        context = (new StringBuilder()).append(context.getAbsolutePath()).append("/imagecache/").toString();
        z = new File(context);
        if (!z.exists())
        {
            z.mkdir();
        }
_L2:
        context = z.getAbsolutePath();
        continue; /* Loop/switch isn't completed */
        context;
        Log.e("Globals", (new StringBuilder()).append("exception happened, e=").append(context.toString()).toString());
        context = obj;
        if (true) goto _L6; else goto _L5
_L5:
        context;
        throw context;
    }

    private String j(Context context)
    {
        Object obj = null;
        this;
        JVM INSTR monitorenter ;
        if (A != null && !A.exists())
        {
            A = null;
        }
        if (A != null) goto _L2; else goto _L1
_L1:
        context = context.getCacheDir();
        if (context != null) goto _L4; else goto _L3
_L3:
        context = obj;
_L6:
        this;
        JVM INSTR monitorexit ;
        return context;
_L4:
        context = (new StringBuilder()).append(context.getAbsolutePath()).append("/PNGcache/").toString();
        A = new File(context);
        if (!A.exists())
        {
            A.mkdir();
        }
_L2:
        context = A.getAbsolutePath();
        continue; /* Loop/switch isn't completed */
        context;
        Log.e("Globals", (new StringBuilder()).append("exception happened, e=").append(context.toString()).toString());
        context = obj;
        if (true) goto _L6; else goto _L5
_L5:
        context;
        throw context;
    }

    public static String l()
    {
        return n;
    }

    public static boolean m()
    {
        return n.contains("you");
    }

    public static String n()
    {
        return "https://bcm-demo2-api.cyberlink.com/api/init";
    }

    public static String o()
    {
        return o;
    }

    public static String p()
    {
        return p;
    }

    public static boolean t()
    {
        return r.isEmpty();
    }

    public boolean A()
    {
        return f.a("needToUpdateTopSticker", true);
    }

    public boolean B()
    {
        return f.a("stickerTopTabPressed", false);
    }

    public boolean C()
    {
        return f.a("stickerNewTabPressed", false);
    }

    public String D()
    {
        return u;
    }

    public long E()
    {
        return v;
    }

    public long F()
    {
        return w;
    }

    public boolean G()
    {
        return f.a("enableGcm", true);
    }

    public String H()
    {
        return f.a("oldBuildNumber", "");
    }

    public JSONObject K()
    {
        Object obj = t.a("DeletedMessageList", "");
        if (obj == null || ((String) (obj)).isEmpty())
        {
            return new JSONObject();
        }
        try
        {
            obj = new JSONObject(((String) (obj)));
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return new JSONObject();
        }
        return ((JSONObject) (obj));
    }

    public void L()
    {
        JSONObject jsonobject;
        JSONObject jsonobject1;
        Iterator iterator;
        long l1;
        l1 = r();
        jsonobject = a().K();
        jsonobject1 = new JSONObject();
        iterator = jsonobject.keys();
_L2:
        String s1;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = (String)iterator.next();
        long l2 = jsonobject.getLong(s1);
        if (l2 > l1)
        {
            try
            {
                jsonobject1.put(s1, l2);
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
            }
        }
        if (true) goto _L2; else goto _L1
_L1:
        if (jsonobject1.length() > 0)
        {
            a().a(jsonobject1);
        }
        return;
    }

    public Map M()
    {
        if (E == null)
        {
            E = com.cyberlink.you.e.g().a();
        }
        return E;
    }

    public String N()
    {
        return f.a("queryMessageAPIVersion", "v2");
    }

    public void a(int i1)
    {
        f.b("heartbeatResult", i1);
    }

    public void a(long l1)
    {
        f.b("registrationTime", l1);
    }

    public void a(long l1, boolean flag)
    {
        long l2 = r();
        if (flag || l1 > l2)
        {
            g.b("finishTime", l1);
        }
        L();
    }

    public void a(Application application)
    {
        if (application != null && l == null)
        {
            l = application;
            l.registerActivityLifecycleCallbacks(D);
        }
    }

    public void a(Context context)
    {
        if (!d(context))
        {
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

                final g a;

                public void uncaughtException(Thread thread, Throwable throwable)
                {
                    g.a(a, throwable);
                }

            
            {
                a = g.this;
                super();
            }
            });
        }
        j = this;
        g(context);
        f = new q(context, "U", 0);
        g = new q(context, "FinishTimePref", 0);
        h = new q(context, "NotificationPref", 0);
        t = new q(context, "DeletedMessagePref", 0);
        try
        {
            PackageInfo packageinfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            n = context.getPackageName();
            o = packageinfo.versionName;
            p = b(r.CONFIG_REVISION);
            h(context);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }

    public void a(UserInfo userinfo)
    {
        if (userinfo != null)
        {
            userinfo = userinfo.a();
            if (!userinfo.isEmpty())
            {
                f.b("selfInfo", userinfo);
            }
        }
    }

    public void a(String s1)
    {
        f.b("BCToken", s1);
    }

    public void a(String s1, String s2)
    {
        (new q(this, (new StringBuilder()).append("StrickerShopList_").append(s1).toString(), 0)).b("stickerPackList", s2);
        if (s1.equals("Top"))
        {
            b(false);
        } else
        if (s1.equals("New"))
        {
            a(false);
            return;
        }
    }

    public void a(JSONObject jsonobject)
    {
        t.b("DeletedMessageList", jsonobject.toString());
    }

    public void a(boolean flag)
    {
        f.b("needToUpdateNewSticker", flag);
    }

    public void b(long l1)
    {
        f.b("lastStickerDate", l1);
    }

    public void b(boolean flag)
    {
        f.b("needToUpdateTopSticker", flag);
    }

    public boolean b()
    {
        if (!B)
        {
            C = S();
            B = true;
        }
        return C;
    }

    public boolean b(String s1)
    {
        return String.valueOf(f.a("UserID", 0L)).equals(s1);
    }

    public void c()
    {
        C = S();
    }

    public void c(long l1)
    {
        f.b("lastStickerCheckDate", l1);
    }

    public void c(String s1)
    {
        f.b("ResJid", s1);
    }

    public void c(boolean flag)
    {
        f.b("stickerTopTabPressed", flag);
    }

    public s d()
    {
        return q;
    }

    public void d(long l1)
    {
        f.b("lastTopStickerCheckDate", l1);
    }

    public void d(String s1)
    {
        f.b("cv", s1);
    }

    public void d(boolean flag)
    {
        f.b("stickerNewTabPressed", flag);
    }

    public boolean d(Context context)
    {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public String e()
    {
        return f.a("BCToken", "");
    }

    public String e(Context context)
    {
        return context.getSharedPreferences("BeautyCircle", 0).getString("registration_id", "");
    }

    public String e(String s1)
    {
        return (new q(this, (new StringBuilder()).append("StrickerShopList_").append(s1).toString(), 0)).a("stickerPackList", "");
    }

    public void e(boolean flag)
    {
        b = flag;
        Log.d("Globals", (new StringBuilder()).append("Heartbeat enable changed=").append(b).toString());
    }

    public boolean e(long l1)
    {
        v = l1;
        return true;
    }

    public String f()
    {
        UserInfo userinfo = h();
        if (userinfo != null)
        {
            return userinfo.f;
        } else
        {
            return "";
        }
    }

    public void f(Context context)
    {
        if (context == null)
        {
            return;
        }
        Log.e("Globals", "clearApplicationData begin");
        com.cyberlink.you.e.c();
        context = new File(context.getCacheDir().getParent());
        if (context.exists())
        {
            String as[] = context.list();
            int j1 = as.length;
            int i1 = 0;
            while (i1 < j1) 
            {
                String s1 = as[i1];
                if (!s1.equals("lib"))
                {
                    if (com.cyberlink.you.utility.d.a(new File(context, s1)))
                    {
                        Log.i("Globals", (new StringBuilder()).append("Delete folder : ").append(s1.toString()).append(" complete. \n").toString());
                    } else
                    {
                        Log.i("Globals", (new StringBuilder()).append("Delete folder : ").append(s1.toString()).append(" fail. \n").toString());
                    }
                }
                i1++;
            }
        }
        Log.e("Globals", "clearApplicationData end");
    }

    public void f(boolean flag)
    {
        f.b("isCallingOtherApp", flag);
    }

    public boolean f(long l1)
    {
        w = l1;
        return true;
    }

    public boolean f(String s1)
    {
        u = s1;
        return true;
    }

    public Long g()
    {
        UserInfo userinfo = h();
        if (userinfo != null)
        {
            return Long.valueOf(userinfo.a);
        } else
        {
            return Long.valueOf(0L);
        }
    }

    public void g(Context context)
    {
        if (!context.getPackageName().contains("you") || android.os.Build.VERSION.SDK_INT >= 21)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder()).detectAll().penaltyLog().build());
        StrictMode.setVmPolicy((new android.os.StrictMode.VmPolicy.Builder()).detectAll().penaltyLog().build());
        return;
        context;
        context.printStackTrace();
        return;
    }

    public void g(String s1)
    {
        Object obj = f.a("updateUserTask", "");
        if (!((String) (obj)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_49;
        }
        obj = new JSONObject();
_L1:
        ((JSONObject) (obj)).put(s1, "");
        f.b("updateUserTask", ((JSONObject) (obj)).toString());
        return;
        try
        {
            obj = new JSONObject(((String) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1.printStackTrace();
            return;
        }
          goto _L1
    }

    public UserInfo h()
    {
        UserInfo userinfo = new UserInfo();
        if (userinfo != null && userinfo.a(f.a("selfInfo", "")))
        {
            return userinfo;
        } else
        {
            return null;
        }
    }

    public final String i()
    {
        return (new StringBuilder()).append("an-").append(O()).append("-").append(com.cyberlink.you.utility.r.a(a())).toString();
    }

    public String j()
    {
        return f.a("ResJid", "");
    }

    public String k()
    {
        return m;
    }

    public Date q()
    {
        return new Date(f.a("registrationTime", 0L) + l.e);
    }

    public long r()
    {
        long l2 = g.a("finishTime", 0L);
        long l1 = l2;
        if (l2 == 0L)
        {
            l1 = f.a("finishTime", 0L);
        }
        return l1;
    }

    public String s()
    {
        return f.a("cv", "0");
    }

    public void u()
    {
        u = null;
        v = 0L;
        w = 0L;
    }

    public void v()
    {
        Log.e("Globals", "forceLogout");
        u();
        com.cyberlink.you.friends.l.d();
        f.a();
        h.a();
        t.a();
        f(this);
    }

    public long w()
    {
        return f.a("lastStickerDate", 0L);
    }

    public long x()
    {
        return f.a("lastStickerCheckDate", 0L);
    }

    public long y()
    {
        return f.a("lastTopStickerCheckDate", 0L);
    }

    public boolean z()
    {
        return f.a("needToUpdateNewSticker", true);
    }

    static 
    {
        x = Runtime.getRuntime().availableProcessors();
        i = new ThreadPoolExecutor(x + 1, x * 5 + 1, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new ThreadFactory() {

            private final AtomicInteger a = new AtomicInteger(1);

            public Thread newThread(Runnable runnable)
            {
                return new Thread(g.P(), runnable, (new StringBuilder()).append("Network AsyncTask #").append(a.getAndIncrement()).toString());
            }

        });
    }
}
