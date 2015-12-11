// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.core;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.FrameLayout;
import com.sessionm.api.AchievementActivity;
import com.sessionm.api.AchievementData;
import com.sessionm.api.ActivityListener;
import com.sessionm.api.SessionListener;
import com.sessionm.api.SessionM;
import com.sessionm.b.a;
import com.sessionm.c.c;
import com.sessionm.net.Request;
import com.sessionm.net.RequestQueue;
import com.sessionm.net.d;
import com.sessionm.ui.ActivityController;
import com.sessionm.ui.ButtonManager;
import com.sessionm.ui.SessionMActivity;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

// Referenced classes of package com.sessionm.core:
//            h, i, e, d, 
//            StatsCollector, a, AchievementImpl, b, 
//            Config

public class f
    implements d
{
    public static interface a
    {

        public abstract void au();
    }

    private class b extends TimerTask
    {

        final f cM;

        public void run()
        {
            cM.stopSession();
        }

        private b()
        {
            cM = f.this;
            super();
        }

    }


    private static final String TAG = "SessionM.Session";
    public static final String bI = "SessionM Session Thread";
    private static final String bJ = "ad_forecast_global";
    private static final String bK = "apiKey";
    private static final String bL = "smApiKey";
    private static final String bM = "com.sessionm.appid";
    private static final String bN = "com.sessionm.requeststore.currentsession";
    private static final String bO = "com.sessionm.requeststore.backlog";
    private static final String bP = "com.sessionm.urls.file";
    private static final String bQ = "com.sessionm.urls.portal";
    private static final String bR = "com.sessionm.urls.session";
    private static final String bS = "com.sessionm.urls.events";
    private static final String bT = "com.sessionm.urls.ads";
    private static final String bU = "com.sessionm.urls.optout";
    private static final String bV = "com.sessionm.urls.interstitial";
    private static final int bW = -1;
    private static final int bX = 1;
    private static final int bY = 50;
    private static final int bZ = 30;
    private static final long cD = 60000L;
    private static f ca;
    private static final int cy = 600;
    private volatile String bD;
    private long bE;
    private Context bg;
    private ExecutorService bl;
    private Timer cA;
    private boolean cB;
    private boolean cC;
    private boolean cE;
    private boolean cF;
    private com.sessionm.net.a cG;
    private com.sessionm.core.d cH;
    com.sessionm.core.b cI;
    private com.sessionm.b.a cJ;
    private String cb;
    private int cc;
    private ActivityController cd;
    private com.sessionm.api.Activity ce;
    private Map cf;
    private volatile com.sessionm.b.a cg;
    private String ch;
    private boolean ci;
    private boolean cj;
    private volatile com.sessionm.api.SessionM.State ck;
    private final Map cl = new HashMap();
    private final ArrayList cm = new ArrayList();
    private Activity cn;
    private final List co = Collections.synchronizedList(new ArrayList());
    private h cp;
    private RequestQueue cq;
    private boolean cr;
    private AchievementImpl cs;
    private boolean ct;
    private Handler cu;
    private int cv;
    private boolean cw;
    private boolean cx;
    private int cz;
    private int fragmentFrameLayoutId;

    private f()
    {
        cc = -1;
        ck = com.sessionm.api.SessionM.State.STOPPED;
        ct = true;
        fragmentFrameLayoutId = -1;
        cz = 600;
        cC = true;
        if (Log.isLoggable("SessionM.Session", 3))
        {
            Log.d("SessionM.Session", "Instantiated Session object.");
        }
        Looper looper = Looper.getMainLooper();
        if (looper == null)
        {
            return;
        } else
        {
            cu = new Handler(looper);
            return;
        }
    }

    public static f E()
    {
        com/sessionm/core/f;
        JVM INSTR monitorenter ;
        if (ca == null) goto _L2; else goto _L1
_L1:
        f f1 = ca;
_L4:
        com/sessionm/core/f;
        JVM INSTR monitorexit ;
        return f1;
_L2:
        ca = new f();
        f1 = ca;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private void W()
    {
        h h1 = new h(cp);
        SessionM sessionm = SessionM.getInstance();
        SessionListener sessionlistener;
        for (Iterator iterator = aj().iterator(); iterator.hasNext(); cu.post(new Runnable(sessionlistener, sessionm, h1) {

        final f cM;
        final SessionListener cO;
        final SessionM cP;
        final h dc;

        public void run()
        {
            cO.onUserUpdated(cP, dc);
_L1:
            return;
            Throwable throwable;
            throwable;
            if (Log.isLoggable("SessionM", 6))
            {
                Log.e("SessionM", "Exception calling SessionListener.onUserUpdated()", throwable);
                return;
            }
              goto _L1
        }

            
            {
                cM = f.this;
                cO = sessionlistener;
                cP = sessionm;
                dc = h1;
                super();
            }
    }))
        {
            sessionlistener = (SessionListener)iterator.next();
        }

        Iterator iterator1 = cm.iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            Activity activity = (Activity)iterator1.next();
            if (activity instanceof SessionListener)
            {
                cu.post(new Runnable(activity, sessionm, h1) {

                    final f cM;
                    final Activity cN;
                    final SessionM cP;
                    final h dc;

                    public void run()
                    {
                        ((SessionListener)cN).onUserUpdated(cP, dc);
_L1:
                        return;
                        Throwable throwable;
                        throwable;
                        if (Log.isLoggable("SessionM", 6))
                        {
                            Log.e("SessionM", "Exception calling SessionListener.onUserUpdated()", throwable);
                            return;
                        }
                          goto _L1
                    }

            
            {
                cM = f.this;
                cN = activity;
                cP = sessionm;
                dc = h1;
                super();
            }
                });
            }
        } while (true);
    }

    private void X()
    {
        this;
        JVM INSTR monitorenter ;
        if (K() != null || cn != null) goto _L2; else goto _L1
_L1:
        boolean flag = getSessionState().isStarted();
        if (flag) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        Y();
        cA = new Timer();
        cA.schedule(new b(), cz * 1000);
        if (Log.isLoggable("SessionM.Session", 3))
        {
            Log.d("SessionM.Session", (new StringBuilder()).append("Started session timer, ").append(cz).append(" seconds").toString());
        }
        if (true) goto _L2; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    private void Y()
    {
        this;
        JVM INSTR monitorenter ;
        if (cA != null)
        {
            cA.cancel();
            cA = null;
            if (Log.isLoggable("SessionM.Session", 3))
            {
                Log.d("SessionM.Session", "Cancelled session timer");
            }
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void Z()
    {
        if (!f(true))
        {
            com.sessionm.b.a a1 = com.sessionm.b.a.aG();
            a1.put("_method", "delete");
            Request request = new Request(com.sessionm.net.Request.Type.fl);
            request.d(a1);
            M().e(request);
        }
    }

    static long a(f f1, long l1)
    {
        f1.bE = l1;
        return l1;
    }

    private transient Activity a(com.sessionm.api.Activity activity, Object aobj[])
    {
        if (!isExpandedPresentationMode() || aobj == null || aobj.length <= 0 || !(aobj[0] instanceof Activity)) goto _L2; else goto _L1
_L1:
        if (!cm.contains((Activity)aobj[0])) goto _L4; else goto _L3
_L3:
        Object obj = (Activity)aobj[0];
_L6:
label0:
        {
            aobj = ((Object []) (obj));
            if (obj == null)
            {
                aobj = cn;
            }
            obj = activity.getActivityType();
            if (obj != com.sessionm.api.SessionM.ActivityType.ACHIEVEMENT)
            {
                activity = ((com.sessionm.api.Activity) (aobj));
                if (obj != com.sessionm.api.SessionM.ActivityType.INTERSTITIAL)
                {
                    break label0;
                }
            }
            if (com.sessionm.core.i.l(bg))
            {
                activity = ((com.sessionm.api.Activity) (aobj));
                if (!cp.isOptedOut())
                {
                    break label0;
                }
            }
            activity = null;
        }
        return activity;
_L4:
        if (Log.isLoggable("SessionM", 6))
        {
            Log.e("SessionM", "Provided activity was not started, aborting presentation.");
        }
_L2:
        obj = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    static Context a(f f1, Context context)
    {
        f1.bg = context;
        return context;
    }

    private FrameLayout a(Activity activity)
    {
        SessionM sessionm;
        ActivityListener activitylistener;
        sessionm = SessionM.getInstance();
        activitylistener = sessionm.getActivityListener();
        if (activitylistener == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        FrameLayout framelayout = activitylistener.viewGroupForActivity(sessionm);
        return framelayout;
        Throwable throwable;
        throwable;
        if (Log.isLoggable("SessionM", 6))
        {
            Log.e("SessionM", "Exception calling ActivityListener.viewGroupForActivity()", throwable);
        }
        if (!(activity instanceof ActivityListener) || activity == activitylistener)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        activity = ((ActivityListener)activity).viewGroupForActivity(sessionm);
        return activity;
        activity;
        if (Log.isLoggable("SessionM", 6))
        {
            Log.e("SessionM", "Exception calling ActivityListener.viewGroupForActivity()", activity);
        }
        return null;
    }

    static h a(f f1, h h1)
    {
        f1.cp = h1;
        return h1;
    }

    static RequestQueue a(f f1, RequestQueue requestqueue)
    {
        f1.cq = requestqueue;
        return requestqueue;
    }

    public static void a(Context context, a a1)
    {
        f f1 = E();
        f1.getExecutorService().execute(new Runnable(f1, context, a1) {

            final a cS;
            final Context val$context;
            final f val$session;

            public void run()
            {
                f f2 = f.E();
                f2;
                JVM INSTR monitorenter ;
                RequestQueue requestqueue;
                com.sessionm.core.f.a(session, context.getApplicationContext());
                CookieSyncManager.createInstance(context);
                CookieManager.getInstance().removeAllCookie();
                ButtonManager.reset();
                session.O();
                session.T();
                session.b(0L);
                requestqueue = session.M();
                if (requestqueue == null)
                {
                    break MISSING_BLOCK_LABEL_85;
                }
                requestqueue.reset();
                com.sessionm.core.f.a(session, null);
                session.S();
                session.Q();
                session.ah();
                com.sessionm.core.f.a(session, null);
                if (cS != null)
                {
                    (new Handler(context.getMainLooper())).post(new Runnable(this) {

                        final _cls9 cT;

                        public void run()
                        {
                            cT.cS.au();
                        }

            
            {
                cT = _pcls9;
                super();
            }
                    });
                }
                session.aq().g(context);
                com.sessionm.c.b.i(false);
                com.sessionm.c.d.s(context);
                f2;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                f2;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                session = f1;
                context = context1;
                cS = a1;
                super();
            }
        });
    }

    private void a(AchievementImpl achievementimpl)
    {
        while (cp.isOptedOut() || achievementimpl != null && achievementimpl.equals(cs)) 
        {
            return;
        }
        cs = achievementimpl;
    }

    static void a(f f1, AchievementImpl achievementimpl)
    {
        f1.b(achievementimpl);
    }

    static void a(f f1, String s, int i1)
    {
        f1.b(s, i1);
    }

    private void a(Request request)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = null;
        int i1;
        if (request.aR() != null)
        {
            obj = request.aR().bA();
        }
        i1 = request.getStatusCode();
        if (Log.isLoggable("SessionM.Session", 3))
        {
            Log.d("SessionM.Session", String.format("Session start response: %s HTTP code: %d", new Object[] {
                obj, Integer.valueOf(i1)
            }));
        }
        if (i1 != 406) goto _L2; else goto _L1
_L1:
        l(2);
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        obj = request.aQ();
        request = request.aW();
        if (obj != null || request == null)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        if (bD != null)
        {
            Log.e("SessionM.Session", "Session id already set.");
        }
        bD = request.getString("id");
        if (bD == null || bD.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_415;
        }
        com.sessionm.core.e.v().g(bD);
        k(request.getString("uuid"));
        j(request.getInt("session_timeout"));
        if (Log.isLoggable("SessionM.Session", 3))
        {
            Log.d("SessionM.Session", (new StringBuilder()).append("Session time is set to : ").append(cz).toString());
        }
        k(request.getInt("max_process_request_time"));
        if (Log.isLoggable("SessionM.Session", 3))
        {
            Log.d("SessionM.Session", (new StringBuilder()).append("Request timeout interval is set to : ").append(cv).toString());
        }
        com.sessionm.core.e.v().g(request.getInt("batch_size"));
        if (Log.isLoggable("SessionM.Session", 3))
        {
            Log.d("SessionM.Session", (new StringBuilder()).append("Max synch size is set to : ").append(com.sessionm.core.e.v().A()).toString());
        }
        com.sessionm.core.e.v().h(request.getInt("max_request_store_size"));
        if (Log.isLoggable("SessionM.Session", 3))
        {
            Log.d("SessionM.Session", (new StringBuilder()).append("Max backlog size is set to : ").append(com.sessionm.core.e.v().z()).toString());
        }
        a(com.sessionm.api.SessionM.State.STARTED_ONLINE);
        if (Log.isLoggable("SessionM", 4))
        {
            Log.i("SessionM", "Session started successfully");
        }
        M().bg();
        aq().g(bg);
          goto _L3
        request;
        throw request;
        if (Log.isLoggable("SessionM.Session", 6))
        {
            Log.e("SessionM", "Session start response did not contain a session id.");
        }
        a(com.sessionm.api.SessionM.State.STARTED_OFFLINE);
        ai();
          goto _L3
    }

    static boolean a(f f1)
    {
        return f1.ao();
    }

    static boolean a(f f1, boolean flag)
    {
        return f1.f(flag);
    }

    private String[] a(int i1, int j1)
    {
        if (!collectsLocation())
        {
            return null;
        }
        LocationManager locationmanager = (LocationManager)bg.getSystemService("location");
        Object obj;
        if (i1 == 0)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (j1 == 0)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (i1 != 0 || j1 != 0)
        {
            obj = locationmanager.getLastKnownLocation("network");
            if (obj == null && j1 != 0)
            {
                obj = locationmanager.getLastKnownLocation("gps");
            }
        } else
        {
            if (Log.isLoggable("SessionM.Session", 5))
            {
                Log.w("SessionM.Session", String.format("Location permissions are not defined in the manifest.", new Object[0]));
            }
            obj = null;
        }
        if (obj != null)
        {
            double d1 = ((Location) (obj)).getLatitude();
            double d2 = ((Location) (obj)).getLongitude();
            obj = new String[2];
            obj[0] = String.valueOf(d1);
            obj[1] = String.valueOf(d2);
        } else
        {
            obj = null;
        }
        return ((String []) (obj));
    }

    private void aa()
    {
        this;
        JVM INSTR monitorenter ;
        ap();
        if (Log.isLoggable("SessionM.Session", 3))
        {
            Log.d("SessionM.Session", "Finishing up session stop.");
        }
        RequestQueue requestqueue = M();
        requestqueue.stop();
        if (!ao())
        {
            f(true);
        }
        requestqueue.b(this);
        a(com.sessionm.api.SessionM.State.STOPPED);
        com.sessionm.core.e.v().y();
        D().c(null);
        bD = null;
        cg = null;
        cs = null;
        cf = null;
        cp = null;
        cq.shutdown();
        cq = null;
        cJ = null;
        cI = null;
        if ((long)StatsCollector.Stat.dn.ay() == 0L)
        {
            com.sessionm.core.StatsCollector.a(StatsCollector.Stat.dn, System.currentTimeMillis() - bE);
        }
        StatsCollector.i(bg);
        bE = 0L;
        StatsCollector.reset();
        if (Log.isLoggable("SessionM.Session", 4))
        {
            Log.i("SessionM.Session", "Session stopped");
        }
        if (cB)
        {
            if (Log.isLoggable("SessionM.Session", 3))
            {
                Log.d("SessionM.Session", "Restarting session.");
            }
            cB = false;
            cu.post(new Runnable() {

                final f cM;

                public void run()
                {
                    f.E().a(f.g(cM), f.i(cM));
                }

            
            {
                cM = f.this;
                super();
            }
            });
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private com.sessionm.b.a ab()
    {
        com.sessionm.b.a a1 = com.sessionm.b.a.aG();
        com.sessionm.core.a a2;
        String s;
        for (Iterator iterator = cl.values().iterator(); iterator.hasNext(); a1.put(a2.getName(), s))
        {
            a2 = (com.sessionm.core.a)iterator.next();
            s = String.format(Locale.US, "%d", new Object[] {
                Integer.valueOf(a2.getCount())
            });
        }

        cl.clear();
        return a1;
    }

    private void ai()
    {
        long l1 = (long)((new Random()).nextFloat() * 60000F);
        long l2 = System.currentTimeMillis();
        if (Log.isLoggable("SessionM.Session", 3))
        {
            Log.d("SessionM.Session", (new StringBuilder()).append("Session restart threshold delay: ").append(l1).append("ms").toString());
        }
        b(l2 + l1);
    }

    private List aj()
    {
        return co;
    }

    private boolean al()
    {
        try
        {
            Class.forName("com.unity3d.player.UnityPlayerActivity");
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            return false;
        }
        return true;
    }

    private int am()
    {
        Object obj;
        int i1;
        obj = bg.getSharedPreferences("com.sessionm.session.stats", 0);
        i1 = ((SharedPreferences) (obj)).getInt("com.sessionm.session.stats.start", 0);
        obj = ((SharedPreferences) (obj)).edit();
        if (!cj)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        ((android.content.SharedPreferences.Editor) (obj)).clear();
        cj = false;
        ((android.content.SharedPreferences.Editor) (obj)).commit();
        i1 = 0;
        try
        {
            ((android.content.SharedPreferences.Editor) (obj)).putInt("com.sessionm.session.stats.start", i1 + 1);
            ((android.content.SharedPreferences.Editor) (obj)).commit();
        }
        catch (Exception exception)
        {
            if (Log.isLoggable("SessionM", 6))
            {
                Log.e("SessionM", "Exception getting/setting count", exception);
            }
            return 0;
        }
        return i1;
    }

    private boolean ao()
    {
        return cc == 2;
    }

    private void ap()
    {
        String s = Thread.currentThread().getName();
        if (!s.startsWith("SessionM Session Thread") && Log.isLoggable("SessionM.Session", 3))
        {
            Log.d("SessionM.Session", String.format("Session method called from wrong thread: %s", new Object[] {
                s
            }), new Throwable());
        }
    }

    static AchievementImpl b(f f1, String s, int i1)
    {
        return f1.c(s, i1);
    }

    private void b(Activity activity)
    {
        Y();
        if (isSessionAutoStartEnabled() && getSessionState() == com.sessionm.api.SessionM.State.STOPPED)
        {
            if (Log.isLoggable("SessionM.Session", 3))
            {
                Log.d("SessionM.Session", "auto starting session from lifecycle call.");
            }
            a(activity, cb);
        }
        cn = activity;
        getExecutorService().execute(new Runnable() {

            final f cM;

            public void run()
            {
                synchronized (cM)
                {
                    if (!cM.D().isOptedOut() && cM.getSessionState().isStarted())
                    {
                        com.sessionm.core.f.a(cM, null);
                    }
                }
                return;
                exception;
                f1;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                cM = f.this;
                super();
            }
        });
    }

    private void b(com.sessionm.b.a a1)
    {
        a1 = a1.x("hosts");
        if (a1 != null)
        {
            String s = a1.getString("events");
            if (s != null)
            {
                a(s, "com.sessionm.urls.events");
            }
            s = a1.getString("ads");
            if (s != null)
            {
                a(s, "com.sessionm.urls.ads");
            }
            s = a1.getString("optout");
            if (s != null)
            {
                a(s, "com.sessionm.urls.optout");
            }
            s = a1.getString("portal");
            if (s != null)
            {
                a(s, "com.sessionm.urls.portal");
            }
            s = a1.getString("sessions");
            if (s != null)
            {
                a(s, "com.sessionm.urls.session");
            }
            a1 = a1.getString("interstitials");
            if (a1 != null)
            {
                a(a1, "com.sessionm.urls.interstitial");
                return;
            }
        }
    }

    private void b(AchievementImpl achievementimpl)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        if (Log.isLoggable("SessionM.Session", 3))
        {
            Log.d("SessionM.Session", (new StringBuilder()).append("Process available achievement, activityData: ").append(achievementimpl).toString());
        }
        obj = K();
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (getCurrentActivity().getActivityType() != com.sessionm.api.SessionM.ActivityType.ACHIEVEMENT) goto _L2; else goto _L3
_L3:
        if (Log.isLoggable("SessionM.Session", 3))
        {
            Log.d("SessionM.Session", "Stop available achievement processing because it achievement UI is currently presented");
        }
_L9:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (achievementimpl == null) goto _L5; else goto _L4
_L4:
        if (achievementimpl.d()) goto _L5; else goto _L6
_L6:
        a(achievementimpl);
_L17:
        achievementimpl = J();
        if (obj == null) goto _L8; else goto _L7
_L7:
        if (((ActivityController) (obj)).isInForeground()) goto _L9; else goto _L8
_L8:
        if (achievementimpl == null) goto _L9; else goto _L10
_L10:
        if (cs == null) goto _L9; else goto _L11
_L11:
        boolean flag;
        obj = SessionM.getInstance();
        flag = achievementimpl instanceof ActivityListener;
        if (!flag) goto _L13; else goto _L12
_L12:
        flag = ((ActivityListener)achievementimpl).shouldPresentAchievement(((SessionM) (obj)), cs);
_L19:
        if (!flag) goto _L9; else goto _L14
_L14:
        if (cs.isCustom() || cs.d()) goto _L9; else goto _L15
_L15:
        b(new com.sessionm.api.Activity(com.sessionm.api.SessionM.ActivityType.ACHIEVEMENT), new Object[0]);
          goto _L9
        achievementimpl;
        throw achievementimpl;
_L5:
        if (getUnclaimedAchievement() != null) goto _L17; else goto _L16
_L16:
        if (Log.isLoggable("SessionM.Session", 3))
        {
            Log.d("SessionM.Session", "No achievement is available");
        }
          goto _L9
        achievementimpl;
        if (Log.isLoggable("SessionM", 6))
        {
            Log.e("SessionM", "Exception calling ActivityListener.shouldPresentAchievement()", achievementimpl);
        }
        break MISSING_BLOCK_LABEL_315;
_L13:
        flag = isAutopresentMode();
        achievementimpl = ((SessionM) (obj)).getActivityListener();
        if (achievementimpl == null) goto _L19; else goto _L18
_L18:
        boolean flag1 = achievementimpl.shouldPresentAchievement(((SessionM) (obj)), cs);
        flag = flag1;
          goto _L19
        achievementimpl;
        if (!Log.isLoggable("SessionM", 6)) goto _L19; else goto _L20
_L20:
        Log.e("SessionM", "Exception calling ActivityListener.shouldPresentAchievement()", achievementimpl);
          goto _L19
        flag = false;
          goto _L19
    }

    static void b(f f1)
    {
        f1.aa();
    }

    private void b(String s, int i1)
    {
        com.sessionm.core.a a1 = (com.sessionm.core.a)cl.get(s);
        boolean flag;
        if (m(s) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (a1 == null)
        {
            s = new com.sessionm.core.a(s, i1);
            cl.put(s.getName(), s);
        } else
        {
            a1.b(i1);
            s = a1;
        }
        s.b(flag);
    }

    private AchievementImpl c(String s, int i1)
    {
        for (s = m(s); s == null || !s.a(i1);)
        {
            return null;
        }

        return s;
    }

    private void c(Activity activity)
    {
        ActivityController activitycontroller = K();
        if (activitycontroller != null && activitycontroller.getActivityContext() == activity && !getCurrentActivity().isAndroidActivity())
        {
            activitycontroller.dismiss();
        }
        if (activity == cn)
        {
            cn = null;
        }
        getExecutorService().execute(new Runnable(activity) {

            final f cM;
            final Activity cN;

            public void run()
            {
                synchronized (cM)
                {
                    if (f.f(cM) != 0L)
                    {
                        com.sessionm.core.StatsCollector.a(StatsCollector.Stat.dn, System.currentTimeMillis() - f.f(cM));
                    }
                    StatsCollector.i(cN);
                    if (f.E().getSessionState() == com.sessionm.api.SessionM.State.STARTED_ONLINE)
                    {
                        com.sessionm.core.f.a(cM, false);
                    }
                }
                return;
                exception;
                f1;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                cM = f.this;
                cN = activity;
                super();
            }
        });
        X();
    }

    static void c(f f1)
    {
        f1.Z();
    }

    static void d(f f1)
    {
        f1.X();
    }

    static com.sessionm.api.SessionM.State e(f f1)
    {
        return f1.ck;
    }

    static long f(f f1)
    {
        return f1.bE;
    }

    private boolean f(boolean flag)
    {
        RequestQueue requestqueue = M();
        if (!L() || requestqueue == null)
        {
            return false;
        }
        if (Log.isLoggable("SessionM.Session", 3))
        {
            Log.d("SessionM.Session", String.format(Locale.US, "Sending action request isSessionEnd: %b", new Object[] {
                Boolean.valueOf(flag)
            }));
        }
        com.sessionm.b.a a1 = com.sessionm.b.a.aG();
        a1.put("e", ab().aI());
        if (flag)
        {
            a1.put("session[end]", "1");
        }
        Request request = new Request(com.sessionm.net.Request.Type.fk);
        request.d(a1);
        requestqueue.d(request);
        return true;
    }

    static Context g(f f1)
    {
        return f1.bg;
    }

    static com.sessionm.b.a h(f f1)
    {
        return f1.ab();
    }

    static String i(f f1)
    {
        return f1.cb;
    }

    private void k(int i1)
    {
        cv = i1;
        if (cv > 0)
        {
            V().n(cv * 1000);
        }
    }

    private void k(String s)
    {
        if (s == null || s.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        ch = s;
        android.content.SharedPreferences.Editor editor = bg.getSharedPreferences("deviceIDFile", 0).edit();
        editor.putString("uuid", s);
        editor.commit();
_L1:
        return;
        s;
        if (Log.isLoggable("SessionM", 6))
        {
            Log.e("SessionM", "Exception saving device ID", s);
            return;
        }
          goto _L1
    }

    private AchievementImpl l(String s)
    {
        AchievementImpl achievementimpl = null;
        Iterator iterator = D().getAchievements().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            AchievementImpl achievementimpl1 = (AchievementImpl)(AchievementData)iterator.next();
            if (achievementimpl1.a().equals(s))
            {
                achievementimpl = achievementimpl1;
            }
        } while (true);
        return achievementimpl;
    }

    private void l(int i1)
    {
        if (i1 == 2 || i1 == 5)
        {
            a(com.sessionm.api.SessionM.State.STOPPED);
            cc = i1;
        }
        SessionM sessionm = SessionM.getInstance();
        SessionListener sessionlistener;
        for (Iterator iterator = aj().iterator(); iterator.hasNext(); cu.post(new Runnable(sessionlistener, sessionm, i1) {

        final f cM;
        final SessionListener cO;
        final SessionM cP;
        final int cQ;

        public void run()
        {
            cO.onSessionFailed(cP, cQ);
_L1:
            return;
            Throwable throwable;
            throwable;
            if (Log.isLoggable("SessionM", 6))
            {
                Log.e("SessionM", "Exception calling SessionListener.onSessionFailed()", throwable);
                return;
            }
              goto _L1
        }

            
            {
                cM = f.this;
                cO = sessionlistener;
                cP = sessionm;
                cQ = i1;
                super();
            }
    }))
        {
            sessionlistener = (SessionListener)iterator.next();
        }

        Iterator iterator1 = cm.iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            Activity activity = (Activity)iterator1.next();
            if (activity instanceof SessionListener)
            {
                cu.post(new Runnable(activity, sessionm, i1) {

                    final f cM;
                    final Activity cN;
                    final SessionM cP;
                    final int cQ;

                    public void run()
                    {
                        ((SessionListener)cN).onSessionFailed(cP, cQ);
_L1:
                        return;
                        Throwable throwable;
                        throwable;
                        if (Log.isLoggable("SessionM", 6))
                        {
                            Log.e("SessionM", "Exception calling SessionListener.onSessionFailed()", throwable);
                            return;
                        }
                          goto _L1
                    }

            
            {
                cM = f.this;
                cN = activity;
                cP = sessionm;
                cQ = i1;
                super();
            }
                });
            }
        } while (true);
    }

    private AchievementImpl m(String s)
    {
        AchievementImpl achievementimpl;
        Object obj;
        Object obj1;
        achievementimpl = null;
        obj1 = null;
        obj = obj1;
        if (D() == null) goto _L2; else goto _L1
_L1:
        if (s != null) goto _L4; else goto _L3
_L3:
        obj = obj1;
_L2:
        return ((AchievementImpl) (obj));
_L4:
        Iterator iterator = D().getAchievements().iterator();
        do
        {
            obj = achievementimpl;
            if (!iterator.hasNext())
            {
                continue;
            }
            obj = (AchievementData)iterator.next();
            if (((AchievementData) (obj)).getDistance() > 0 && ((AchievementData) (obj)).getAction().equals(s) && (achievementimpl == null || ((AchievementData) (obj)).getDistance() < achievementimpl.getDistance()))
            {
                achievementimpl = (AchievementImpl)obj;
            }
        } while (true);
        if (true) goto _L2; else goto _L5
_L5:
    }

    private boolean m()
    {
        return cc != -1;
    }

    private boolean n(String s)
    {
        return s.length() == 40 && s.matches("([0-9a-f])*");
    }

    public h D()
    {
        this;
        JVM INSTR monitorenter ;
        if (cp == null) goto _L2; else goto _L1
_L1:
        h h1 = cp;
_L4:
        this;
        JVM INSTR monitorexit ;
        return h1;
_L2:
        cp = new h();
        h1 = cp;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public String F()
    {
        this;
        JVM INSTR monitorenter ;
        String s = cb;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public String G()
    {
        this;
        JVM INSTR monitorenter ;
        String s = bD;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public Map H()
    {
        this;
        JVM INSTR monitorenter ;
        Map map = cf;
        this;
        JVM INSTR monitorexit ;
        return map;
        Exception exception;
        exception;
        throw exception;
    }

    public com.sessionm.b.a I()
    {
        this;
        JVM INSTR monitorenter ;
        com.sessionm.b.a a1 = cg;
        this;
        JVM INSTR monitorexit ;
        return a1;
        Exception exception;
        exception;
        throw exception;
    }

    public Activity J()
    {
        this;
        JVM INSTR monitorenter ;
        Activity activity = cn;
        this;
        JVM INSTR monitorexit ;
        return activity;
        Exception exception;
        exception;
        throw exception;
    }

    public ActivityController K()
    {
        this;
        JVM INSTR monitorenter ;
        ActivityController activitycontroller = cd;
        this;
        JVM INSTR monitorexit ;
        return activitycontroller;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean L()
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = cl.size();
        boolean flag;
        if (i1 > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public RequestQueue M()
    {
        this;
        JVM INSTR monitorenter ;
        RequestQueue requestqueue;
        ap();
        if (cq == null && bg != null)
        {
            com.sessionm.c.d d1 = new com.sessionm.c.d(bg, "com.sessionm.requeststore.currentsession");
            com.sessionm.c.d d2 = new com.sessionm.c.d(bg, "com.sessionm.requeststore.backlog");
            ArrayList arraylist = new ArrayList();
            arraylist.add(d1);
            arraylist.add(d2);
            cq = new RequestQueue(bg, arraylist, com.sessionm.net.RequestQueue.RequestQueueType.gb, getExecutorService(), V());
            cq.p(1);
            cq.q(0);
        }
        requestqueue = cq;
        this;
        JVM INSTR monitorexit ;
        return requestqueue;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean N()
    {
        return cw;
    }

    public void O()
    {
        this;
        JVM INSTR monitorenter ;
        cc = -1;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public String P()
    {
        if (!ci)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        ch = null;
        android.content.SharedPreferences.Editor editor = bg.getSharedPreferences("deviceIDFile", 0).edit();
        editor.clear();
        editor.commit();
        ci = false;
_L2:
        return null;
        Exception exception;
        exception;
        if (!Log.isLoggable("SessionM", 6)) goto _L2; else goto _L1
_L1:
        Log.e("SessionM", "Exception resetting device ID", exception);
        return null;
        if (ch != null)
        {
            return ch;
        }
        if (bg != null)
        {
            ch = bg.getSharedPreferences("deviceIDFile", 0).getString("uuid", null);
        }
        return ch;
    }

    public void Q()
    {
        cE = true;
    }

    public void R()
    {
        M().reset();
        cq = null;
    }

    public void S()
    {
        this;
        JVM INSTR monitorenter ;
        ci = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void T()
    {
        this;
        JVM INSTR monitorenter ;
        cj = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void U()
    {
        Object obj;
        if (bg != null)
        {
            if ((obj = bg.getSharedPreferences("smApiKey", 0)) != null)
            {
                obj = ((SharedPreferences) (obj)).edit();
                ((android.content.SharedPreferences.Editor) (obj)).remove("apiKey");
                ((android.content.SharedPreferences.Editor) (obj)).commit();
                return;
            }
        }
    }

    public com.sessionm.net.a V()
    {
        this;
        JVM INSTR monitorenter ;
        com.sessionm.net.a a1;
        if (cG == null && bg != null)
        {
            cG = new com.sessionm.net.http.a(bg, true, true, new Object[0]);
        }
        a1 = cG;
        this;
        JVM INSTR monitorexit ;
        return a1;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(Context context, String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (context != null) goto _L2; else goto _L1
_L1:
        if (Log.isLoggable("SessionM", 3))
        {
            Log.d("SessionM", "Application context object is null");
        }
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        getExecutorService().execute(new Runnable(context, s) {

            final Context cK;
            final String cL;
            final f cM;

            public void run()
            {
                cM.b(cK, cL);
            }

            
            {
                cM = f.this;
                cK = context;
                cL = s;
                super();
            }
        });
        if (true) goto _L4; else goto _L3
_L3:
        context;
        throw context;
    }

    public void a(com.sessionm.api.ActivityListener.UserAction useraction, Map map)
    {
        getListenerHandler().post(new Runnable(useraction, map) {

            final f cM;
            final com.sessionm.api.ActivityListener.UserAction cW;
            final Map cX;

            public void run()
            {
                SessionM sessionm = SessionM.getInstance();
                ActivityListener activitylistener = sessionm.getActivityListener();
                Activity activity;
                if (activitylistener != null)
                {
                    try
                    {
                        activitylistener.onUserAction(sessionm, cW, cX);
                    }
                    catch (Throwable throwable1)
                    {
                        if (Log.isLoggable("SessionM", 6))
                        {
                            Log.e("SessionM.Session", "Exception calling ActivityListener.onUserAction()", throwable1);
                        }
                        continue; /* Loop/switch isn't completed */
                    }
                }
_L4:
                activity = cM.J();
                if (!(activity instanceof ActivityListener) || activity == activitylistener)
                {
                    break MISSING_BLOCK_LABEL_66;
                }
                ((ActivityListener)activity).onUserAction(sessionm, cW, cX);
_L2:
                return;
                Throwable throwable;
                throwable;
                if (!Log.isLoggable("SessionM", 6)) goto _L2; else goto _L1
_L1:
                Log.e("SessionM.Session", "Exception calling ActivityListener.onUserAction()", throwable);
                return;
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                cM = f.this;
                cW = useraction;
                cX = map;
                super();
            }
        });
    }

    public void a(SessionListener sessionlistener)
    {
        this;
        JVM INSTR monitorenter ;
        if (sessionlistener == null)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        aj().add(sessionlistener);
        this;
        JVM INSTR monitorexit ;
        return;
        sessionlistener;
        throw sessionlistener;
    }

    public void a(com.sessionm.api.SessionM.State state)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = ck;
        if (state != obj) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (Log.isLoggable("SessionM.Session", 3))
        {
            Log.d("SessionM.Session", String.format(Locale.US, "Moving session to state: %s", new Object[] {
                state
            }));
        }
        ck = state;
        obj = SessionM.getInstance();
        SessionListener sessionlistener;
        for (Iterator iterator = aj().iterator(); iterator.hasNext(); cu.post(new Runnable(sessionlistener, ((SessionM) (obj)), state) {

        final f cM;
        final SessionListener cO;
        final SessionM cP;
        final com.sessionm.api.SessionM.State cR;

        public void run()
        {
            cO.onSessionStateChanged(cP, cR);
_L1:
            return;
            Throwable throwable;
            throwable;
            if (Log.isLoggable("SessionM", 6))
            {
                Log.e("SessionM", "Exception calling SessionListener.onSessionStateChanged()", throwable);
                return;
            }
              goto _L1
        }

            
            {
                cM = f.this;
                cO = sessionlistener;
                cP = sessionm;
                cR = state;
                super();
            }
    }))
        {
            sessionlistener = (SessionListener)iterator.next();
        }

        break MISSING_BLOCK_LABEL_114;
        state;
        throw state;
        Iterator iterator1 = cm.iterator();
        while (iterator1.hasNext()) 
        {
            Activity activity = (Activity)iterator1.next();
            if (activity instanceof SessionListener)
            {
                cu.post(new Runnable(activity, ((SessionM) (obj)), state) {

                    final f cM;
                    final Activity cN;
                    final SessionM cP;
                    final com.sessionm.api.SessionM.State cR;

                    public void run()
                    {
                        ((SessionListener)cN).onSessionStateChanged(cP, cR);
_L1:
                        return;
                        Throwable throwable;
                        throwable;
                        if (Log.isLoggable("SessionM", 6))
                        {
                            Log.e("SessionM", "Exception calling SessionListener.onSessionStateChanged()", throwable);
                            return;
                        }
                          goto _L1
                    }

            
            {
                cM = f.this;
                cN = activity;
                cP = sessionm;
                cR = state;
                super();
            }
                });
            }
        }
          goto _L1
    }

    public void a(com.sessionm.b.a a1)
    {
        com.sessionm.b.a aa2[];
        Object obj;
        Object obj2;
        Object obj3;
        ap();
        if (Log.isLoggable("SessionM", 3))
        {
            Log.d("SessionM", "Updating session state");
        }
        b(a1);
        obj2 = a1.x("player");
        com.sessionm.b.a aa3[] = (com.sessionm.b.a[])a1.a("ad_forecast", com/sessionm/b/a);
        if (a1.has("cache_content"))
        {
            com.sessionm.b.a aa1[] = (com.sessionm.b.a[])a1.a("cache_content", com/sessionm/b/a);
            at().a(aa1);
        }
        aa2 = aa3;
        if (aa3 != null)
        {
            aa2 = aa3;
            if (aa3.length == 0)
            {
                aa2 = null;
            }
        }
        obj = a1.x("ad_forecast_global");
        obj3 = D();
        if (obj2 != null || obj != null || aa2 != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        cg = ((com.sessionm.b.a) (obj));
        boolean flag = ((h) (obj3)).c(((com.sessionm.b.a) (obj2)));
        if (((h) (obj3)).isOptedOut())
        {
            cs = null;
        }
        if (aa2 != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (((h) (obj3)).isOptedOut())
        {
            ((h) (obj3)).getAchievements().clear();
        }
        if (flag)
        {
            W();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        int i1;
        int j1;
        a1 = a1.getString("update_strategy");
        if (a1 != null && !a1.equals("update"))
        {
            if (Log.isLoggable("SessionM.Session", 3))
            {
                Log.d("SessionM.Session", "Cleared activity forecast");
            }
            D().getAchievements().clear();
        }
        obj3 = D().getAchievements();
        j1 = aa2.length;
        i1 = 0;
        a1 = null;
_L5:
        if (i1 >= j1)
        {
            break MISSING_BLOCK_LABEL_422;
        }
        obj = aa2[i1];
        obj2 = l(((com.sessionm.b.a) (obj)).getString("achievement_id"));
        if (obj2 != null)
        {
            ((List) (obj3)).remove(obj2);
        }
        obj2 = new AchievementImpl(((com.sessionm.b.a) (obj)));
        if (((AchievementImpl) (obj2)).isValid())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = a1;
_L9:
        i1++;
        a1 = ((com.sessionm.b.a) (obj));
        if (true) goto _L5; else goto _L4
_L4:
        ((List) (obj3)).add(obj2);
        String s = ((AchievementImpl) (obj2)).getAction();
        if (Log.isLoggable("SessionM.Session", 3))
        {
            Log.d("SessionM.Session", (new StringBuilder()).append("Updated forecast for action: ").append(s).append(", forecast: ").append(obj).toString());
        }
        if (((AchievementImpl) (obj2)).c()) goto _L7; else goto _L6
_L6:
        obj = a1;
        if (((AchievementImpl) (obj2)).b() != AchievementImpl.AchievementState.H) goto _L9; else goto _L8
_L8:
        obj = a1;
        if (a1 != null) goto _L9; else goto _L7
_L7:
        obj = obj2;
          goto _L9
        Iterator iterator = cl.values().iterator();
        boolean flag1 = false;
        do
        {
            boolean flag2;
label0:
            {
label1:
                {
                    if (iterator.hasNext())
                    {
                        Object obj1 = (com.sessionm.core.a)iterator.next();
                        if (((com.sessionm.core.a) (obj1)).g() || m(((com.sessionm.core.a) (obj1)).getName()) == null)
                        {
                            break label1;
                        }
                        ((com.sessionm.core.a) (obj1)).b(true);
                        obj1 = c(((com.sessionm.core.a) (obj1)).getName(), ((com.sessionm.core.a) (obj1)).getCount());
                        if (obj1 != null)
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        flag2 = flag1;
                        if (!flag1)
                        {
                            break label0;
                        }
                        f(false);
                        b(((AchievementImpl) (obj1)));
                    }
                    getExecutorService().execute(new Runnable(flag1, a1) {

                        final f cM;
                        final boolean cZ;
                        final AchievementImpl da;

                        public void run()
                        {
                            if (!cZ && da != null)
                            {
                                com.sessionm.core.f.a(cM, da);
                            }
                        }

            
            {
                cM = f.this;
                cZ = flag;
                da = achievementimpl;
                super();
            }
                    });
                    W();
                    return;
                }
                flag2 = flag1;
            }
            flag1 = flag2;
        } while (true);
    }

    public void a(RequestQueue requestqueue, Request request)
    {
    }

    public void a(RequestQueue requestqueue, com.sessionm.net.RequestQueue.RequestQueueNetworkState requestqueuenetworkstate)
    {
        ap();
        com.sessionm.api.SessionM.State state = getSessionState();
        if (requestqueuenetworkstate == com.sessionm.net.RequestQueue.RequestQueueNetworkState.fR && state == com.sessionm.api.SessionM.State.STARTED_ONLINE)
        {
            a(com.sessionm.api.SessionM.State.STARTED_OFFLINE);
            requestqueue.bh();
        } else
        if (requestqueuenetworkstate == com.sessionm.net.RequestQueue.RequestQueueNetworkState.fQ && state == com.sessionm.api.SessionM.State.STARTED_OFFLINE && !m() && bD != null && !ao())
        {
            a(com.sessionm.api.SessionM.State.STARTED_ONLINE);
            requestqueue.bg();
            return;
        }
    }

    public void a(RequestQueue requestqueue, com.sessionm.net.RequestQueue.RequestQueueSendState requestqueuesendstate)
    {
        ap();
        if (getSessionState() == com.sessionm.api.SessionM.State.STOPPING && requestqueuesendstate == com.sessionm.net.RequestQueue.RequestQueueSendState.fU)
        {
            if (Log.isLoggable("SessionM.Session", 3))
            {
                Log.d("SessionM.Session", "Queue transitioned to idle send state. Sending session stop request.");
            }
            M().bf();
        }
    }

    public void a(ActivityController activitycontroller)
    {
        this;
        JVM INSTR monitorenter ;
        if (activitycontroller != null) goto _L2; else goto _L1
_L1:
        Log.e("SessionM.Session", "Internal error: ActivityController was null");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Y();
        if (ce == null)
        {
            ce = new com.sessionm.api.Activity(com.sessionm.api.SessionM.ActivityType.INTERSTITIAL);
        }
        cd = activitycontroller;
        if (true) goto _L4; else goto _L3
_L3:
        activitycontroller;
        throw activitycontroller;
    }

    void a(String s, String s1)
    {
        if (s != null && s1 != null)
        {
            try
            {
                android.content.SharedPreferences.Editor editor = bg.getSharedPreferences("com.sessionm.urls.file", 0).edit();
                editor.putString(s1, s);
                editor.commit();
                return;
            }
            catch (Exception exception) { }
            if (Log.isLoggable("SessionM", 6))
            {
                Log.e("SessionM", String.format("Exception saving url %s with key: %s", new Object[] {
                    s, s1
                }));
                return;
            }
        }
    }

    public boolean a(AchievementActivity achievementactivity)
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        Activity activity = a(((com.sessionm.api.Activity) (achievementactivity)), new Object[0]);
        if (activity != null) goto _L2; else goto _L1
_L1:
        boolean flag = flag1;
        if (!Log.isLoggable("SessionM.CA", 5))
        {
            break MISSING_BLOCK_LABEL_45;
        }
        Log.w("SessionM.CA", "No started android activities found. Custom achievement will not be claimable.");
        flag = flag1;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        if (Log.isLoggable("SessionM", 4))
        {
            Log.i("SessionM", (new StringBuilder()).append("Custom achievement presented, Android activity: ").append(activity).toString());
        }
        cs = null;
        ce = achievementactivity;
        getExecutorService().execute(new Runnable(achievementactivity) {

            final f cM;
            final AchievementActivity db;

            public void run()
            {
                com.sessionm.b.a a1 = com.sessionm.b.a.aG();
                Object obj = (AchievementImpl)db.getAchievement();
                a1.put("achievement_id", (new StringBuilder()).append("").append(((AchievementImpl) (obj)).a()).toString());
                obj = new Request(com.sessionm.net.Request.Type.fo, new Object[] {
                    cM.F()
                });
                ((Request) (obj)).d(a1);
                cM.M().e(((Request) (obj)));
            }

            
            {
                cM = f.this;
                db = achievementactivity;
                super();
            }
        });
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
        achievementactivity;
        throw achievementactivity;
    }

    public boolean a(RequestQueue requestqueue)
    {
        this;
        JVM INSTR monitorenter ;
        com.sessionm.api.SessionM.State state;
        requestqueue = ck;
        state = com.sessionm.api.SessionM.State.STARTED_OFFLINE;
        boolean flag;
        if (requestqueue == state)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        requestqueue;
        throw requestqueue;
    }

    public String ac()
    {
        String s1 = j("com.sessionm.urls.ads");
        String s = s1;
        if (s1 == null)
        {
            s = Config.h().j();
        }
        return s;
    }

    public String ad()
    {
        String s1 = j("com.sessionm.urls.events");
        String s = s1;
        if (s1 == null)
        {
            s = Config.h().i();
        }
        return s;
    }

    public String ae()
    {
        String s1 = j("com.sessionm.urls.optout");
        String s = s1;
        if (s1 == null)
        {
            s = Config.h().i();
        }
        return s;
    }

    public String af()
    {
        String s1 = j("com.sessionm.urls.portal");
        String s = s1;
        if (s1 == null)
        {
            s = Config.h().k();
        }
        return s;
    }

    public String ag()
    {
        String s1 = j("com.sessionm.urls.session");
        String s = s1;
        if (s1 == null)
        {
            s = Config.h().i();
        }
        return s;
    }

    public void ah()
    {
        android.content.SharedPreferences.Editor editor = bg.getSharedPreferences("com.sessionm.urls.file", 0).edit();
        editor.clear();
        editor.commit();
_L1:
        return;
        Exception exception;
        exception;
        if (Log.isLoggable("SessionM", 6))
        {
            Log.e("SessionM", String.format("Exception clear host urls...", new Object[0]));
            return;
        }
          goto _L1
    }

    public com.sessionm.b.a ak()
    {
        Object obj;
        Object obj1;
        com.sessionm.b.a a1;
        if (cJ != null)
        {
            return cJ;
        }
        Object obj2 = bg.getPackageManager();
        a1 = com.sessionm.b.a.aG();
        obj1 = (TelephonyManager)bg.getSystemService("phone");
        Object obj3;
        String s1;
        boolean flag;
        if (obj1 != null)
        {
            String s;
            int i1;
            int j1;
            int k1;
            int l1;
            if (((TelephonyManager) (obj1)).getNetworkCountryIso() == null)
            {
                obj = "unknown";
            } else
            {
                obj = ((TelephonyManager) (obj1)).getNetworkCountryIso();
            }
            a1.put("isocountrycode", ((String) (obj)));
            if (((TelephonyManager) (obj1)).getNetworkOperatorName() == null)
            {
                obj = "unknown";
            } else
            {
                obj = ((TelephonyManager) (obj1)).getNetworkOperatorName();
            }
            a1.put("carriername", ((String) (obj)));
            if (((TelephonyManager) (obj1)).getNetworkOperator() == null)
            {
                obj = "unknown";
            } else
            {
                obj = ((TelephonyManager) (obj1)).getNetworkOperator();
            }
            a1.put("networkoperator", ((String) (obj)));
        } else
        {
            a1.put("isocountrycode", "unknown");
            a1.put("carriername", "unknown");
            a1.put("networkoperator", "unknown");
        }
        obj1 = com.sessionm.core.i.k(bg);
        a1.put("countrycode", String.valueOf(bg.getResources().getConfiguration().mcc));
        obj = bg.getApplicationInfo().packageName;
        a1.put("target_sdk_version", String.format(Locale.US, "%d", new Object[] {
            Integer.valueOf(bg.getApplicationInfo().targetSdkVersion)
        }));
        obj3 = Locale.US;
        if (!cF)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a1.put("hardware_acceleration_enabled", String.format(((Locale) (obj3)), "%b", new Object[] {
            Boolean.valueOf(flag)
        }));
        a1.put("packagename", ((String) (obj)));
        a1.put("connection", ((String) (obj1)));
        obj3 = (WindowManager)bg.getSystemService("window");
        obj1 = new DisplayMetrics();
        obj3 = ((WindowManager) (obj3)).getDefaultDisplay();
        if (com.sessionm.core.i.m(16))
        {
            ((Display) (obj3)).getRealMetrics(((DisplayMetrics) (obj1)));
        } else
        {
            ((Display) (obj3)).getMetrics(((DisplayMetrics) (obj1)));
        }
        obj1 = String.format(Locale.US, "%dx%d", new Object[] {
            Integer.valueOf(((DisplayMetrics) (obj1)).widthPixels), Integer.valueOf(((DisplayMetrics) (obj1)).heightPixels)
        });
        obj3 = getSDKVersion();
        s = P();
        s1 = com.sessionm.a.a.b("gpadvertiserid", "none");
        if (s != null)
        {
            a1.put("login", s);
        } else
        if (!s1.equals(""))
        {
            a1.put("transaction_id", s1);
        } else
        {
            a1.put("transaction_id", com.sessionm.a.a.b("androiddeviceid", "none"));
        }
        a1.put("gpadvertiserid", s1);
        a1.put("limitadtracking", com.sessionm.a.a.r(bg));
        s = TimeZone.getDefault().getDisplayName(true, 1);
        a1.put("screen", ((String) (obj1)));
        a1.put("density", String.valueOf(bg.getResources().getDisplayMetrics().density));
        a1.put("brand", com.sessionm.core.i.aD());
        a1.put("platform", "android");
        a1.put("model", com.sessionm.core.i.getModel());
        a1.put("version", android.os.Build.VERSION.INCREMENTAL);
        a1.put("manufacturer", Build.MANUFACTURER);
        a1.put("buildId", Build.DISPLAY);
        a1.put("platform_version", (new StringBuilder()).append("").append(android.os.Build.VERSION.SDK_INT).toString());
        a1.put("sdkVersion", ((String) (obj3)));
        a1.put("locale", Locale.getDefault().toString());
        a1.put("timezone", s);
        a1.put("se", aq().u());
        a1.put("pid", (new StringBuilder()).append("").append(com.sessionm.core.i.getPid()).toString());
        if (!at().m())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a1.put("cache_enabled", flag);
        a1.put("cache_size", at().size());
        a1.put("cache_items", at().r());
        a1.put("sc", (new StringBuilder()).append("").append(am()).toString());
        a1.put("app_version", ((PackageManager) (obj2)).getPackageInfo(((String) (obj)), 0).versionName);
        obj1 = ((PackageManager) (obj2)).getInstallerPackageName(((String) (obj)));
        obj = obj1;
        if (obj1 == null)
        {
            obj = "unknown";
        }
        try
        {
            a1.put("app_installer", ((String) (obj)));
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception) { }
        if (cr)
        {
            a1.put("skip_blacklist", "true");
        }
        i1 = ((PackageManager) (obj2)).checkPermission("android.permission.ACCESS_COARSE_LOCATION", bg.getPackageName());
        j1 = ((PackageManager) (obj2)).checkPermission("android.permission.ACCESS_FINE_LOCATION", bg.getPackageName());
        k1 = ((PackageManager) (obj2)).checkPermission("android.permission.ACCESS_WIFI_STATE", bg.getPackageName());
        l1 = ((PackageManager) (obj2)).checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", bg.getPackageName());
        if (i1 == 0)
        {
            obj1 = (new StringBuilder()).append("").append(",android.permission.ACCESS_COARSE_LOCATION").toString();
        } else
        {
            obj1 = "";
        }
        obj = obj1;
        if (j1 == 0)
        {
            obj = (new StringBuilder()).append(((String) (obj1))).append(",android.permission.ACCESS_FINE_LOCATION").toString();
        }
        obj1 = obj;
        if (k1 == 0)
        {
            obj1 = (new StringBuilder()).append(((String) (obj))).append(",android.permission.ACCESS_WIFI_STATE").toString();
            cw = true;
        }
        obj = obj1;
        if (l1 == 0)
        {
            obj = (new StringBuilder()).append(((String) (obj1))).append(",android.permission.WRITE_EXTERNAL_STORAGE").toString();
        }
        obj1 = a(i1, j1);
        if (obj1 != null && obj1.length > 1)
        {
            a1.put("latitude", obj1[0]);
            a1.put("longitude", obj1[1]);
        }
        obj1 = obj;
        if (((String) (obj)).startsWith(","))
        {
            obj1 = ((String) (obj)).substring(1);
        }
        a1.put("permissions", ((String) (obj1)));
        if (al())
        {
            a1.put("unity_sdk", "1");
        }
        cJ = com.sessionm.b.a.aG();
        obj2 = H();
        if (obj2 != null)
        {
            obj = com.sessionm.b.a.aG();
            obj1 = com.sessionm.b.a.aG();
            for (obj2 = ((Map) (obj2)).entrySet().iterator(); ((Iterator) (obj2)).hasNext(); ((com.sessionm.b.a) (obj1)).put((String)((java.util.Map.Entry) (obj3)).getKey(), (String)((java.util.Map.Entry) (obj3)).getValue()))
            {
                obj3 = (java.util.Map.Entry)((Iterator) (obj2)).next();
            }

            ((com.sessionm.b.a) (obj)).put("data", ((com.sessionm.b.a) (obj1)).aI());
            cJ.put("user", obj);
        }
        obj1 = com.sessionm.b.a.aG();
        if (D().isOptedOut())
        {
            obj = "1";
        } else
        {
            obj = "0";
        }
        ((com.sessionm.b.a) (obj1)).put("opted_out", ((String) (obj)));
        cJ.put("member", ((com.sessionm.b.a) (obj1)).aI());
        cJ.put("device", a1.aI());
        return cJ;
    }

    public void an()
    {
        if (cs != null)
        {
            if (Log.isLoggable("SessionM.Session", 3))
            {
                Log.d("SessionM.Session", "Unclaimed achievement ready in cache.");
            }
            b(cs);
        }
    }

    public com.sessionm.core.d aq()
    {
        this;
        JVM INSTR monitorenter ;
        com.sessionm.core.d d1;
        if (cH == null)
        {
            cH = new com.sessionm.core.d(bg);
        }
        d1 = cH;
        this;
        JVM INSTR monitorexit ;
        return d1;
        Exception exception;
        exception;
        throw exception;
    }

    public void ar()
    {
        this;
        JVM INSTR monitorenter ;
        getListenerHandler().post(new Runnable() {

            final f cM;

            public void run()
            {
                SessionM sessionm = SessionM.getInstance();
                ActivityListener activitylistener = sessionm.getActivityListener();
                Activity activity;
                if (activitylistener != null)
                {
                    try
                    {
                        activitylistener.onPresented(sessionm);
                    }
                    catch (Throwable throwable1)
                    {
                        if (Log.isLoggable("SessionM", 6))
                        {
                            Log.e("SessionM", "Exception calling ActivityListener.onPresented()", throwable1);
                        }
                        continue; /* Loop/switch isn't completed */
                    }
                }
_L4:
                activity = cM.J();
                if (!(activity instanceof ActivityListener) || activity == activitylistener)
                {
                    break MISSING_BLOCK_LABEL_50;
                }
                ((ActivityListener)activity).onPresented(sessionm);
_L2:
                return;
                Throwable throwable;
                throwable;
                if (!Log.isLoggable("SessionM", 6)) goto _L2; else goto _L1
_L1:
                Log.e("SessionM", "Exception calling ActivityListener.onPresented()", throwable);
                return;
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                cM = f.this;
                super();
            }
        });
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void as()
    {
        getListenerHandler().post(new Runnable() {

            final f cM;

            public void run()
            {
                SessionM sessionm = SessionM.getInstance();
                ActivityListener activitylistener = sessionm.getActivityListener();
                Activity activity;
                if (activitylistener != null)
                {
                    try
                    {
                        activitylistener.onDismissed(sessionm);
                    }
                    catch (Throwable throwable1)
                    {
                        if (Log.isLoggable("SessionM", 6))
                        {
                            Log.e("SessionM.Session", "Exception calling ActivityListener.onDismissed()", throwable1);
                        }
                        continue; /* Loop/switch isn't completed */
                    }
                }
_L4:
                activity = cM.J();
                if (!(activity instanceof ActivityListener) || activity == activitylistener)
                {
                    break MISSING_BLOCK_LABEL_50;
                }
                ((ActivityListener)activity).onDismissed(sessionm);
_L2:
                return;
                Throwable throwable;
                throwable;
                if (!Log.isLoggable("SessionM", 6)) goto _L2; else goto _L1
_L1:
                Log.e("SessionM.Session", "Exception calling ActivityListener.onDismissed()", throwable);
                return;
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                cM = f.this;
                super();
            }
        });
    }

    public com.sessionm.core.b at()
    {
        this;
        JVM INSTR monitorenter ;
        com.sessionm.core.b b1;
        if (cI == null)
        {
            cI = new com.sessionm.core.b(bg, getExecutorService());
        }
        b1 = cI;
        this;
        JVM INSTR monitorexit ;
        return b1;
        Exception exception;
        exception;
        throw exception;
    }

    public void b(long l1)
    {
        this;
        JVM INSTR monitorenter ;
        RequestQueue requestqueue;
        if (Log.isLoggable("SessionM.Session", 3))
        {
            Log.d("SessionM.Session", (new StringBuilder()).append("Set request send time threshold: ").append(l1).toString());
        }
        requestqueue = M();
        if (requestqueue == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        requestqueue.d(l1);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void b(AchievementActivity achievementactivity)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        achievementactivity = (AchievementImpl)achievementactivity.getAchievement();
        obj = Config.h().getValue("api.version");
        achievementactivity = String.format("%s/v%s/apps/%s/awards/%s/ads", new Object[] {
            ac(), obj, cb, achievementactivity.a()
        });
        obj = J();
        if (obj == null) goto _L2; else goto _L1
_L1:
        SessionMActivity.startSessionMActivity(((Context) (obj)), achievementactivity, null, false);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (Log.isLoggable("SessionM.Session", 6))
        {
            Log.e("SessionM.Session", "Cannot claim custom achievement since this is visible activity.");
        }
        if (true) goto _L4; else goto _L3
_L3:
        achievementactivity;
        throw achievementactivity;
    }

    public void b(SessionListener sessionlistener)
    {
        this;
        JVM INSTR monitorenter ;
        if (sessionlistener == null)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        aj().remove(sessionlistener);
        this;
        JVM INSTR monitorexit ;
        return;
        sessionlistener;
        throw sessionlistener;
    }

    public void b(RequestQueue requestqueue)
    {
    }

    public void b(RequestQueue requestqueue, Request request)
    {
        ap();
        if (request.ba().be())
        {
            if ((request.aP() == com.sessionm.net.Request.Type.fl || request.aP() == com.sessionm.net.Request.Type.fk) && getSessionState() == com.sessionm.api.SessionM.State.STOPPING)
            {
                aa();
            } else
            {
                if (request.aP() == com.sessionm.net.Request.Type.fj)
                {
                    a(request);
                }
                if (request.ba() == com.sessionm.net.Request.State.fg)
                {
                    requestqueue = request.aW();
                    if (requestqueue != null)
                    {
                        a(requestqueue);
                        return;
                    }
                }
            }
        }
    }

    public void b(ActivityController activitycontroller)
    {
        this;
        JVM INSTR monitorenter ;
        if (cd == activitycontroller)
        {
            cd = null;
            ce = null;
        }
        X();
        this;
        JVM INSTR monitorexit ;
        return;
        activitycontroller;
        throw activitycontroller;
    }

    boolean b(Context context, String s)
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        com.sessionm.api.SessionM.State state;
        ap();
        state = getSessionState();
        if (state == com.sessionm.api.SessionM.State.STOPPED) goto _L2; else goto _L1
_L1:
        if (Log.isLoggable("SessionM", 3))
        {
            Log.d("SessionM", "Starting session - already started.");
        }
        if (state != com.sessionm.api.SessionM.State.STOPPING)
        {
            flag = false;
        }
        cB = flag;
        flag = false;
_L10:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        if (!m())
        {
            break MISSING_BLOCK_LABEL_109;
        }
        if (Log.isLoggable("SessionM", 3))
        {
            Log.d("SessionM", "Starting session - disabled.");
        }
        l(cc);
        flag = false;
        continue; /* Loop/switch isn't completed */
        bg = context.getApplicationContext();
        if (bg.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", bg.getPackageName()) == 0)
        {
            break MISSING_BLOCK_LABEL_178;
        }
        if (Log.isLoggable("SessionM.Session", 6))
        {
            Log.e("SessionM.Session", String.format("ACCESS_NETWORK_STATE permissions are not defined in the manifest. This is a requirement for starting a session.", new Object[0]));
        }
        l(6);
        flag = false;
        continue; /* Loop/switch isn't completed */
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_426;
        }
        if (Log.isLoggable("SessionM", 3))
        {
            Log.d("SessionM", "looking for app id specified in the manifest");
        }
        context = bg.getPackageName();
        context = bg.getPackageManager().getApplicationInfo(context, 128);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_431;
        }
        if (((ApplicationInfo) (context)).metaData == null)
        {
            break MISSING_BLOCK_LABEL_431;
        }
        break MISSING_BLOCK_LABEL_264;
        context;
        if (Log.isLoggable("SessionM.Session", 6))
        {
            Log.e("SessionM", "Error querying manifest for app id - session not started", context);
        }
        break MISSING_BLOCK_LABEL_437;
        context = ((ApplicationInfo) (context)).metaData.getString("com.sessionm.appid");
        if (context == null) goto _L4; else goto _L3
_L3:
        if (!(context instanceof String)) goto _L4; else goto _L5
_L5:
        context = (String)context;
_L8:
        if (Log.isLoggable("SessionM.Session", 4))
        {
            Log.i("SessionM", "Starting session");
        }
        if (n(context)) goto _L7; else goto _L6
_L6:
        l(5);
        flag = false;
        continue; /* Loop/switch isn't completed */
_L4:
        if (Log.isLoggable("SessionM", 3))
        {
            Log.d("SessionM", "App id is not specified as either startSession() parameter or in the manifest - session not started.");
        }
        break MISSING_BLOCK_LABEL_443;
_L7:
        if (D().isOptedOut())
        {
            if (Log.isLoggable("SessionM.Session", 3))
            {
                Log.d("SessionM.Session", "User is opted out of mPOINTS not starting a session.");
            }
            break MISSING_BLOCK_LABEL_449;
        }
        a(com.sessionm.api.SessionM.State.STARTING);
        getExecutorService().execute(new Runnable() {

            final f cM;

            public void run()
            {
                Object obj = cM.ak();
                synchronized (cM)
                {
                    Object obj2 = cM.M();
                    ((RequestQueue) (obj2)).start();
                    Object obj1 = com.sessionm.core.e.v();
                    obj2 = ((e) (obj1)).a((c)((RequestQueue) (obj2)).bk().get(0), (c)((RequestQueue) (obj2)).bk().get(1));
                    StatsCollector.reset();
                    CookieSyncManager.createInstance(cM.getApplicationContext());
                    ((e) (obj1)).x();
                    obj1 = new Request(com.sessionm.net.Request.Type.fj, new Object[] {
                        cM.F()
                    });
                    ((com.sessionm.b.a) (obj)).put("sessions", obj2);
                    ((com.sessionm.b.a) (obj)).put("stats", StatsCollector.j(f.g(cM)).aI());
                    if (f.f(cM) == 0L)
                    {
                        com.sessionm.core.f.a(cM, System.currentTimeMillis());
                    }
                    ((com.sessionm.b.a) (obj)).put("e", f.h(cM).aI());
                    ((Request) (obj1)).d(((com.sessionm.b.a) (obj)));
                    obj = cM.M();
                    ((RequestQueue) (obj)).a(cM);
                    ((RequestQueue) (obj)).d(((Request) (obj1)));
                    com.sessionm.core.f.d(cM);
                    if (((RequestQueue) (obj)).bi() > 0L)
                    {
                        cM.a(com.sessionm.api.SessionM.State.STARTED_OFFLINE);
                    }
                }
                return;
                exception;
                f1;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                cM = f.this;
                super();
            }
        });
        cb = context;
        ButtonManager.getInstance();
        flag = true;
        continue; /* Loop/switch isn't completed */
        context;
        throw context;
        context = s;
          goto _L8
        flag = false;
        continue; /* Loop/switch isn't completed */
        flag = false;
        continue; /* Loop/switch isn't completed */
        flag = false;
        continue; /* Loop/switch isn't completed */
        flag = false;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public transient boolean b(com.sessionm.api.Activity activity, Object aobj[])
    {
        boolean flag1 = false;
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        com.sessionm.api.SessionM.ActivityType activitytype = activity.getActivityType();
        if (getSessionState().isStarted() || activitytype == com.sessionm.api.SessionM.ActivityType.PORTAL) goto _L2; else goto _L1
_L1:
        flag1 = flag;
        if (!Log.isLoggable("SessionM.Session", 3))
        {
            break MISSING_BLOCK_LABEL_76;
        }
        Log.d("SessionM.Session", (new StringBuilder()).append("Can't present in offline state, type: ").append(activity.getActivityType()).toString());
        flag1 = flag;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag1;
_L2:
        Activity activity1 = a(activity, aobj);
        if (activity1 != null)
        {
            break MISSING_BLOCK_LABEL_148;
        }
        flag1 = flag;
        if (!Log.isLoggable("SessionM.Session", 3)) goto _L4; else goto _L3
_L3:
        Log.d("SessionM.Session", (new StringBuilder()).append("Can't present when presenting activity is null, type: ").append(activity.getActivityType()).toString());
        flag1 = flag;
          goto _L4
        activity;
        throw activity;
        Object obj = K();
        if (obj == null) goto _L6; else goto _L5
_L5:
        if (!activity.isAndroidActivity() && ((ActivityController) (obj)).isInForeground()) goto _L8; else goto _L7
_L7:
        dismissActivity();
_L6:
        if (activitytype != com.sessionm.api.SessionM.ActivityType.ACHIEVEMENT) goto _L10; else goto _L9
_L9:
        if (cs != null) goto _L12; else goto _L11
_L11:
        flag1 = flag;
        if (!Log.isLoggable("SessionM.Session", 3)) goto _L4; else goto _L13
_L13:
        Log.d("SessionM.Session", (new StringBuilder()).append("Can't present when achievement data is null, type: ").append(activity.getActivityType()).toString());
        flag1 = flag;
          goto _L4
_L8:
        flag1 = flag;
        if (!Log.isLoggable("SessionM.Session", 3)) goto _L4; else goto _L14
_L14:
        Log.d("SessionM.Session", (new StringBuilder()).append("Can't present when in background state, type: ").append(activity.getActivityType()).toString());
        flag1 = flag;
          goto _L4
_L12:
        aobj = cs.e();
        int i1 = ((com.sessionm.b.a) (aobj)).getInt("cache_content_id");
        obj = at().f(i1);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_372;
        }
        flag1 = flag;
        if (!Log.isLoggable("SessionM.Session", 3)) goto _L4; else goto _L15
_L15:
        Log.d("SessionM.Session", (new StringBuilder()).append("Can't present when achievement content is null, type: ").append(activity.getActivityType()).toString());
        flag1 = flag;
          goto _L4
        String s = ((com.sessionm.b.a) (obj)).getString("url");
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_427;
        }
        if (Log.isLoggable("SessionM.Session", 6))
        {
            Log.e("SessionM.Session", String.format(Locale.US, "%s cache item has null url", new Object[] {
                ((com.sessionm.b.a) (obj)).aI().toString()
            }));
        }
        aobj = ActivityController.createActivityController(false, activity1, s, new Object[] {
            aobj, ((com.sessionm.b.a) (obj)).x("data")
        });
        ((ActivityController) (aobj)).setProvidedView(a(activity1));
        ((ActivityController) (aobj)).present(true);
        a(((ActivityController) (aobj)));
        cs.a(AchievementImpl.AchievementState.I);
        cs = null;
        flag = true;
_L19:
        ce = activity;
        flag1 = flag;
        if (!flag) goto _L4; else goto _L16
_L16:
        flag1 = flag;
        if (!Log.isLoggable("SessionM", 4)) goto _L4; else goto _L17
_L17:
        Log.i("SessionM", (new StringBuilder()).append("Presenting activity, type: ").append(activitytype).append(", presenting Android activity: ").append(activity1).toString());
        flag1 = flag;
          goto _L4
_L10:
        if (activitytype != com.sessionm.api.SessionM.ActivityType.INTERSTITIAL)
        {
            break MISSING_BLOCK_LABEL_618;
        }
        aobj = cI.o();
        flag = flag1;
        if (aobj == null) goto _L19; else goto _L18
_L18:
        com.sessionm.b.a a1 = ((com.sessionm.b.a) (aobj)).x("data");
        flag = SessionMActivity.startSessionMActivity(activity1, ((com.sessionm.b.a) (aobj)).getString("url"), a1, true);
          goto _L19
        flag = SessionMActivity.startSessionMActivity(activity1, com.sessionm.core.i.a(activity.getActivityType(), af(), F(), D().isOptedOut(), aobj), null, true);
          goto _L19
    }

    public void c(RequestQueue requestqueue)
    {
    }

    public boolean c(RequestQueue requestqueue, Request request)
    {
        return request.aP().equals(com.sessionm.net.Request.Type.fj);
    }

    public boolean collectsLocation()
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        boolean flag1;
        SharedPreferences sharedpreferences = bg.getSharedPreferences("com.sessionm.location", 0);
        if (cE)
        {
            android.content.SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.clear();
            editor.commit();
        }
        flag1 = sharedpreferences.getBoolean("com.sessionm.location.collect", true);
        flag = flag1;
_L2:
        this;
        JVM INSTR monitorexit ;
        return flag;
        Object obj;
        obj;
        throw obj;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void d(boolean flag)
    {
        cF = flag;
    }

    public void dismissActivity()
    {
        this;
        JVM INSTR monitorenter ;
        ActivityController activitycontroller = K();
        if (activitycontroller == null) goto _L2; else goto _L1
_L1:
        activitycontroller.dismiss();
        ce = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (ce instanceof AchievementActivity)
        {
            as();
            ce = null;
        }
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void e(boolean flag)
    {
        cw = flag;
    }

    public void f(com.sessionm.core.b b1)
    {
        cI = b1;
    }

    public Context getApplicationContext()
    {
        this;
        JVM INSTR monitorenter ;
        Context context = bg;
        this;
        JVM INSTR monitorexit ;
        return context;
        Exception exception;
        exception;
        throw exception;
    }

    public com.sessionm.api.Activity getCurrentActivity()
    {
        this;
        JVM INSTR monitorenter ;
        com.sessionm.api.Activity activity = ce;
        this;
        JVM INSTR monitorexit ;
        return activity;
        Exception exception;
        exception;
        throw exception;
    }

    public ExecutorService getExecutorService()
    {
        this;
        JVM INSTR monitorenter ;
        ExecutorService executorservice;
        if (bl == null)
        {
            bl = new ThreadPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(50));
            ((ThreadPoolExecutor)bl).setThreadFactory(new ThreadFactory() {

                final f cM;

                public Thread newThread(Runnable runnable)
                {
                    runnable = new Thread(runnable);
                    runnable.setName("SessionM Session Thread");
                    return runnable;
                }

            
            {
                cM = f.this;
                super();
            }
            });
        }
        executorservice = bl;
        this;
        JVM INSTR monitorexit ;
        return executorservice;
        Exception exception;
        exception;
        throw exception;
    }

    public int getFragmentFrameLayoutId()
    {
        return fragmentFrameLayoutId;
    }

    public Handler getListenerHandler()
    {
        this;
        JVM INSTR monitorenter ;
        Handler handler = cu;
        this;
        JVM INSTR monitorexit ;
        return handler;
        Exception exception;
        exception;
        throw exception;
    }

    public int getRequestCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = M().bn();
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getSDKVersion()
    {
        return Config.h().getValue("sdk.version");
    }

    public com.sessionm.api.SessionM.State getSessionState()
    {
        this;
        JVM INSTR monitorenter ;
        com.sessionm.api.SessionM.State state = ck;
        this;
        JVM INSTR monitorexit ;
        return state;
        Exception exception;
        exception;
        throw exception;
    }

    public AchievementData getUnclaimedAchievement()
    {
        this;
        JVM INSTR monitorenter ;
        AchievementImpl achievementimpl = cs;
        this;
        JVM INSTR monitorexit ;
        return achievementimpl;
        Exception exception;
        exception;
        throw exception;
    }

    public void h(Context context)
    {
        bg = context;
    }

    public void h(String s)
    {
        cb = s;
    }

    public void i(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        cc = i1;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void i(String s)
    {
    }

    public boolean isAutopresentMode()
    {
        return ct;
    }

    public boolean isExpandedPresentationMode()
    {
        return cx;
    }

    public boolean isHardwareAccelerationDisabled()
    {
        return cF;
    }

    public boolean isSessionAutoStartEnabled()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = cC;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    String j(String s)
    {
        String s1 = null;
        if (bg != null)
        {
            s1 = bg.getSharedPreferences("com.sessionm.urls.file", 0).getString(s, null);
        }
        return s1;
    }

    public void j(int i1)
    {
        int j1 = i1;
        if (i1 <= 0)
        {
            j1 = 600;
        }
        cz = j1;
    }

    public void logAction(final String action, int i1)
    {
        this;
        JVM INSTR monitorenter ;
        if (m() || action == null) goto _L2; else goto _L1
_L1:
        if (action.length() != 0 && ck != com.sessionm.api.SessionM.State.STOPPING && !D().isOptedOut()) goto _L3; else goto _L2
_L2:
        if (Log.isLoggable("SessionM.Session", 5))
        {
            Log.w("SessionM.Session", String.format("Throwing out log action for action : %s", new Object[] {
                action
            }));
        }
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        if (ck == com.sessionm.api.SessionM.State.STOPPED && isSessionAutoStartEnabled())
        {
            a(bg, cb);
        }
        if (Log.isLoggable("SessionM", 4))
        {
            Log.i("SessionM", (new StringBuilder()).append("Log action ").append(action).toString());
        }
        getExecutorService().execute(new Runnable(i1) {

            final f cM;
            final int cY;
            final String val$action;

            public void run()
            {
                f f1 = cM;
                f1;
                JVM INSTR monitorenter ;
                Object obj;
                com.sessionm.core.f.d(cM);
                com.sessionm.core.f.a(cM, action, cY);
                obj = f.b(cM, action, cY);
                if (obj == null)
                {
                    break MISSING_BLOCK_LABEL_57;
                }
                com.sessionm.core.f.a(cM, ((AchievementImpl) (obj)));
                if (obj == null) goto _L2; else goto _L1
_L1:
                com.sessionm.core.f.a(cM, false);
_L4:
                f1;
                JVM INSTR monitorexit ;
                return;
_L2:
                obj = cM.M();
                if (obj == null) goto _L4; else goto _L3
_L3:
                if (f.e(cM) != com.sessionm.api.SessionM.State.STARTED_OFFLINE || ((RequestQueue) (obj)).bo() != com.sessionm.net.RequestQueue.RequestQueueSendState.fU) goto _L4; else goto _L5
_L5:
                ((RequestQueue) (obj)).bf();
                  goto _L4
                Exception exception;
                exception;
                f1;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                cM = f.this;
                action = s;
                cY = i1;
                super();
            }
        });
        if (true) goto _L5; else goto _L4
_L4:
        action;
        throw action;
    }

    public void logError(String s, String s1, Throwable throwable)
    {
        Object obj = null;
        if (throwable != null)
        {
            obj = new StringWriter();
            throwable.printStackTrace(new PrintWriter(((java.io.Writer) (obj))));
            obj = ((StringWriter) (obj)).toString();
        }
        s1 = String.format(Locale.US, "Application Error: name=%s, message=%s, exception=%s", new Object[] {
            s, s1, obj
        });
        s = com.sessionm.b.a.aG();
        s.put("error[message]", s1);
        s1 = new Request(com.sessionm.net.Request.Type.fn, new Object[] {
            F()
        });
        s1.d(s);
        s1.send();
    }

    public void logPaymentTransaction(float f1)
    {
        if (bg != null)
        {
            getExecutorService().execute(new Runnable(f1) {

                final f cM;
                final float cU;

                public void run()
                {
                    cM.aq().a(cU);
                }

            
            {
                cM = f.this;
                cU = f2;
                super();
            }
            });
        }
        com.sessionm.core.d.t();
    }

    public void onActivityPause(Activity activity)
    {
        this;
        JVM INSTR monitorenter ;
        if (!cx)
        {
            c(activity);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        activity;
        throw activity;
    }

    public void onActivityResume(Activity activity)
    {
        this;
        JVM INSTR monitorenter ;
        if (!cx)
        {
            b(activity);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        activity;
        throw activity;
    }

    public void onActivityStart(Activity activity)
    {
        this;
        JVM INSTR monitorenter ;
        if (cm.size() == 0 && bE == 0L)
        {
            bE = System.currentTimeMillis();
        }
        cm.add(activity);
        if (cx)
        {
            b(activity);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        activity;
        throw activity;
    }

    public void onActivityStop(Activity activity)
    {
        this;
        JVM INSTR monitorenter ;
        cm.remove(activity);
        if (cx)
        {
            c(activity);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        activity;
        throw activity;
    }

    public void setAutopresentMode(boolean flag)
    {
        ct = flag;
    }

    public void setCollectionLocation(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        Exception exception;
        try
        {
            android.content.SharedPreferences.Editor editor = bg.getSharedPreferences("com.sessionm.location", 0).edit();
            editor.putBoolean("com.sessionm.location.collect", flag);
            editor.commit();
        }
        catch (Exception exception1) { }
        finally
        {
            this;
        }
        return;
        throw exception;
    }

    public void setExecutorService(ExecutorService executorservice)
    {
        this;
        JVM INSTR monitorenter ;
        if (executorservice != null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        throw new NullPointerException("executorService is null");
        executorservice;
        this;
        JVM INSTR monitorexit ;
        throw executorservice;
        bl = executorservice;
        this;
        JVM INSTR monitorexit ;
    }

    public void setExpandedPresentationMode(boolean flag)
    {
        if (Log.isLoggable("SessionM", 4))
        {
            Log.i("SessionM", (new StringBuilder()).append("Set expanded presentation mode: ").append(flag).toString());
        }
        cx = flag;
    }

    public void setFragmentFrameLayoutId(int i1)
    {
        fragmentFrameLayoutId = i1;
    }

    public void setListenerHandler(Handler handler)
    {
        this;
        JVM INSTR monitorenter ;
        if (handler != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        cu = handler;
        if (true) goto _L1; else goto _L3
_L3:
        handler;
        throw handler;
    }

    public void setMetaData(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        if (s != null && s1 != null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        throw new NullPointerException();
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        if (cf == null)
        {
            cf = new HashMap();
        }
        cf.put(s, s1);
        if (Log.isLoggable("SessionM", 3))
        {
            Log.d("SessionM", (new StringBuilder()).append("Set meta data, key: ").append(s).append(", value: ").append(s1).toString());
        }
        this;
        JVM INSTR monitorexit ;
    }

    public void setMetaData(Map map)
    {
        this;
        JVM INSTR monitorenter ;
        if (map == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        cf = new HashMap(map);
_L1:
        if (Log.isLoggable("SessionM", 3))
        {
            Log.d("SessionM", (new StringBuilder()).append("Set meta data: ").append(map).toString());
        }
        this;
        JVM INSTR monitorexit ;
        return;
        cf = null;
          goto _L1
        map;
        throw map;
    }

    public void setSessionAutoStartEnabled(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        cC = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setSkipBlacklist(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        cr = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void stopSession()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = getSessionState().isStarted();
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        ActivityController activitycontroller;
        Y();
        activitycontroller = K();
        if (activitycontroller == null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        activitycontroller.dismiss();
        Exception exception;
        if (getSessionState() == com.sessionm.api.SessionM.State.STARTED_ONLINE)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a(com.sessionm.api.SessionM.State.STOPPING);
        if (Log.isLoggable("SessionM.Session", 4))
        {
            Log.i("SessionM.Session", "Stopping session.");
        }
        getExecutorService().execute(new Runnable(flag) {

            final f cM;
            final boolean cV;

            public void run()
            {
                boolean flag1 = true;
                f f1 = cM;
                f1;
                JVM INSTR monitorenter ;
                Locale locale;
                if (!cM.D().isOptedOut() && !com.sessionm.core.f.a(cM) && (cV || cM.M().bo() != com.sessionm.net.RequestQueue.RequestQueueSendState.fU))
                {
                    break MISSING_BLOCK_LABEL_121;
                }
                if (!Log.isLoggable("SessionM.Session", 3))
                {
                    break MISSING_BLOCK_LABEL_111;
                }
                locale = Locale.US;
                Exception exception1;
                if (cV)
                {
                    flag1 = false;
                }
                Log.d("SessionM.Session", String.format(locale, "stopping offline(%b)/refused(%b) session. ", new Object[] {
                    Boolean.valueOf(flag1), Boolean.valueOf(com.sessionm.core.f.a(cM))
                }));
                f.b(cM);
                return;
                com.sessionm.core.f.c(cM);
                return;
                exception1;
                f1;
                JVM INSTR monitorexit ;
                throw exception1;
            }

            
            {
                cM = f.this;
                cV = flag;
                super();
            }
        });
        if (true) goto _L1; else goto _L3
_L3:
        exception;
        throw exception;
    }
}
