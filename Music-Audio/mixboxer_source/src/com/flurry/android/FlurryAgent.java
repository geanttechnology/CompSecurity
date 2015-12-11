// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.flurry.android:
//            fr, cy, FlurryAppCloud, d, 
//            ay, IFlurryAds, b, c, 
//            ReportedIdType, cb, fx, fl, 
//            k, o, gr, ar, 
//            ce, IAppCloudModule, n, eb, 
//            am, cn, an, f, 
//            fp

public final class FlurryAgent
    implements LocationListener
{

    static FlurryAgent an = new FlurryAgent();
    private static long ao = 10000L;
    private static boolean ap = true;
    private static Criteria aq = null;
    private static AtomicInteger as = new AtomicInteger(0);
    private static AtomicInteger at = new AtomicInteger(0);
    private String aA;
    private String aB;
    private String aC;
    private boolean aD;
    private List aE;
    private LocationManager aF;
    private String aG;
    private Map aH;
    private boolean aI;
    private long aJ;
    private List aK;
    private long aL;
    private long aM;
    private long aN;
    private String aO;
    private String aP;
    private byte aQ;
    private String aR;
    private byte aS;
    private Long aT;
    private int aU;
    private Location aV;
    private Map aW;
    private List aX;
    private boolean aY;
    private int aZ;
    private final Handler ar;
    private File au;
    private File av;
    private volatile boolean aw;
    private volatile boolean ax;
    private long ay;
    private Map az;
    private List ba;
    private int bb;
    private Map bc;
    private Map bd;
    IFlurryAds be;
    private IAppCloudModule bf;
    ce bg;
    private fr bh;

    private FlurryAgent()
    {
        au = null;
        av = null;
        aw = false;
        ax = false;
        az = new WeakHashMap();
        aD = true;
        aH = new HashMap();
        aK = new ArrayList();
        aO = "";
        aP = "";
        aQ = -1;
        aR = "";
        aS = -1;
        aW = new HashMap();
        aX = new ArrayList();
        ba = new ArrayList();
        be = o();
        bf = n();
        bg = null;
        bh = null;
        HandlerThread handlerthread = new HandlerThread("FlurryAgent");
        handlerthread.start();
        ar = new Handler(handlerthread.getLooper());
    }

    static long A()
    {
        return ao;
    }

    private void a(Context context, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        if (bh == null)
        {
            bh = new fr(context.getApplicationContext(), this);
            bh.bv();
        }
        if (aA != null && !aA.equals(s1))
        {
            cy.d("FlurryAgent", (new StringBuilder()).append("onStartSession called with different api keys: ").append(aA).append(" and ").append(s1).toString());
        }
        if ((Context)az.put(context, context) != null)
        {
            cy.g("FlurryAgent", "onStartSession called with duplicate context, use a specific Activity or Service as context instead of using a global context");
        }
        FlurryAppCloud.G();
        a(((fp) (new d(this, context, s1))));
        if (aw)
        {
            break MISSING_BLOCK_LABEL_747;
        }
        cy.c("FlurryAgent", "Initializing Flurry session");
        aA = s1;
        au = context.getFileStreamPath((new StringBuilder()).append(".flurryagent.").append(Integer.toString(aA.hashCode(), 16)).toString());
        av = context.getFileStreamPath(".flurryinstallreceiver.");
        com.flurry.android.ay.Y();
        s1 = context.getApplicationContext();
        if (aC == null)
        {
            aC = e(s1);
        }
        String s2 = s1.getPackageName();
        if (aB != null && !aB.equals(s2))
        {
            cy.d("FlurryAgent", (new StringBuilder()).append("onStartSession called from different application packages: ").append(aB).append(" and ").append(s2).toString());
        }
        aB = s2;
        long l = SystemClock.elapsedRealtime();
        if (l - ay <= ao)
        {
            break MISSING_BLOCK_LABEL_685;
        }
        cy.c("FlurryAgent", "New session");
        aL = System.currentTimeMillis();
        aM = l;
        aN = -1L;
        aR = "";
        aU = 0;
        aV = null;
        aP = TimeZone.getDefault().getID();
        aO = (new StringBuilder()).append(Locale.getDefault().getLanguage()).append("_").append(Locale.getDefault().getCountry()).toString();
        aW = new HashMap();
        aX = new ArrayList();
        aY = true;
        ba = new ArrayList();
        aZ = 0;
        bb = 0;
        as.set(0);
        at.set(0);
        if (r())
        {
            be.onStartNewSession(context, aL, aM);
        }
        a(((fp) (new b(this, s1, aD))));
        if (!(context instanceof Activity))
        {
            break MISSING_BLOCK_LABEL_742;
        }
        s1 = ((Activity)context).getIntent().getExtras();
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_742;
        }
        Iterator iterator;
        (new StringBuilder()).append("Launch Options Bundle is present ").append(s1.toString()).toString();
        bd = new HashMap();
        iterator = s1.keySet().iterator();
_L2:
        String s3;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_742;
            }
            s3 = (String)iterator.next();
        } while (s3 == null);
        context = ((Context) (s1.get(s3)));
        if (context == null)
        {
            break; /* Loop/switch isn't completed */
        }
        context = context.toString();
_L3:
        bd.put(s3, new ArrayList(Arrays.asList(new String[] {
            context
        })));
        (new StringBuilder()).append("Launch options Key: ").append(s3).append(". Its value: ").append(context).toString();
        if (true) goto _L2; else goto _L1
        context;
        throw context;
_L1:
        context = "null";
          goto _L3
        cy.c("FlurryAgent", "Continuing previous session");
        if (!aK.isEmpty())
        {
            aK.remove(aK.size() - 1);
        }
        if (r())
        {
            be.onContinueSession(context);
        }
        aw = true;
        this;
        JVM INSTR monitorexit ;
    }

    private void a(Context context, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        FlurryAppCloud.H();
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        if ((Context)az.remove(context) == null)
        {
            cy.g("FlurryAgent", "onEndSession called without context from corresponding onStartSession");
        }
        if (aw && r())
        {
            be.cleanUpSession(context);
        }
        if (!aw || !az.isEmpty()) goto _L2; else goto _L1
_L1:
        cy.c("FlurryAgent", "Ending session");
        x();
        if (context != null) goto _L4; else goto _L3
_L3:
        Context context1 = null;
_L6:
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        String s1 = context1.getPackageName();
        if (!aB.equals(s1))
        {
            cy.d("FlurryAgent", (new StringBuilder()).append("onEndSession called from different application package, expected: ").append(aB).append(" actual: ").append(s1).toString());
        }
        long l = SystemClock.elapsedRealtime();
        ay = l;
        aN = l - aM;
        b(aN);
        if (id() == null)
        {
            cy.d("FlurryAgent", "Not creating report because of bad Android ID or generated ID is null");
        }
        a(((fp) (new c(this, flag, context1))));
        if (r())
        {
            be.onEndSession(context);
        }
        aw = false;
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        context1 = context.getApplicationContext();
        if (true) goto _L6; else goto _L5
_L5:
        context;
        throw context;
    }

    static void a(FlurryAgent flurryagent, Context context)
    {
        flurryagent.d(context);
    }

    static void a(FlurryAgent flurryagent, Context context, boolean flag)
    {
        Location location;
        location = null;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        location = flurryagent.f(context);
        flurryagent;
        JVM INSTR monitorenter ;
        flurryagent.aV = location;
        flurryagent;
        JVM INSTR monitorexit ;
        context = flurryagent.fetchHashedImei(context);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        flurryagent.aH.put(ReportedIdType.Sha1Imei, ByteBuffer.wrap(context));
        flurryagent.v();
        return;
        context;
        flurryagent;
        JVM INSTR monitorexit ;
        try
        {
            throw context;
        }
        // Misplaced declaration of an exception variable
        catch (FlurryAgent flurryagent)
        {
            cy.b("FlurryAgent", "", flurryagent);
        }
        return;
    }

    private void a(fp fp)
    {
        ar.post(fp);
    }

    private void a(String s1, String s2, String s3, Throwable throwable)
    {
        this;
        JVM INSTR monitorenter ;
        if (ba != null) goto _L2; else goto _L1
_L1:
        cy.d("FlurryAgent", (new StringBuilder()).append("onError called before onStartSession.  Error: ").append(s1).toString());
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        if (!"uncaught".equals(s1))
        {
            break MISSING_BLOCK_LABEL_157;
        }
        int i = 1;
_L4:
        aU = aU + 1;
        if (ba.size() >= 50)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        long l = System.currentTimeMillis();
        s1 = new cb(at.incrementAndGet(), Long.valueOf(l).longValue(), s1, s2, s3, throwable);
        ba.add(s1);
        cy.c("FlurryAgent", (new StringBuilder()).append("Error logged: ").append(s1.at()).toString());
          goto _L3
        s1;
        throw s1;
        i = 0;
          goto _L4
        if (!i) goto _L6; else goto _L5
_L5:
        i = 0;
_L8:
        if (i >= ba.size()) goto _L3; else goto _L7
_L7:
        cb cb1 = (cb)ba.get(i);
        if (cb1.at() == null || "uncaught".equals(cb1.at()))
        {
            break MISSING_BLOCK_LABEL_282;
        }
        long l1 = System.currentTimeMillis();
        s1 = new cb(at.incrementAndGet(), Long.valueOf(l1).longValue(), s1, s2, s3, throwable);
        ba.set(i, s1);
          goto _L3
_L6:
        cy.c("FlurryAgent", "Max errors logged. No more errors logged.");
          goto _L3
        i++;
          goto _L8
    }

    private void a(String s1, Map map)
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = aX.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        fx fx1 = (fx)iterator.next();
        if (!fx1.K(s1)) goto _L4; else goto _L3
_L3:
        long l;
        long l1;
        l = SystemClock.elapsedRealtime();
        l1 = aM;
        if (map == null) goto _L6; else goto _L5
_L5:
        if (map.size() <= 0 || aZ >= 0x27100) goto _L6; else goto _L7
_L7:
        int i;
        i = aZ - fx1.getBytes().length;
        s1 = new HashMap(fx1.getParameters());
        fx1.d(map);
        if (fx1.getBytes().length + i > 0x27100)
        {
            break MISSING_BLOCK_LABEL_203;
        }
        if (fx1.getParameters().size() <= 10) goto _L9; else goto _L8
_L8:
        cy.g("FlurryAgent", (new StringBuilder()).append("MaxEventParams exceeded on endEvent: ").append(fx1.getParameters().size()).toString());
        fx1.e(s1);
_L6:
        fx1.h(l - l1);
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L9:
        aZ = i + fx1.getBytes().length;
          goto _L6
        s1;
        throw s1;
        fx1.e(s1);
        aY = false;
        aZ = 0x27100;
        cy.g("FlurryAgent", "Event Log size exceeded. No more event details logged.");
          goto _L6
    }

    private void a(String s1, Map map, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (aX != null) goto _L2; else goto _L1
_L1:
        cy.d("FlurryAgent", (new StringBuilder()).append("onEvent called before onStartSession.  Event: ").append(s1).toString());
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        String s2;
        long l;
        long l1;
        l = SystemClock.elapsedRealtime();
        l1 = aM;
        s2 = fl.sanitize(s1);
        if (s2.length() == 0) goto _L4; else goto _L3
_L3:
        s1 = (k)aW.get(s2);
        if (s1 != null) goto _L6; else goto _L5
_L5:
        if (aW.size() >= 100) goto _L8; else goto _L7
_L7:
        s1 = new k();
        s1.value = 1;
        aW.put(s2, s1);
        cy.c("FlurryAgent", (new StringBuilder()).append("Event count incremented: ").append(s2).toString());
_L13:
        if (!ap || aX.size() >= 1000 || aZ >= 0x27100) goto _L10; else goto _L9
_L9:
        if (map != null)
        {
            break MISSING_BLOCK_LABEL_379;
        }
        s1 = Collections.emptyMap();
_L14:
        if (s1.size() <= 10) goto _L12; else goto _L11
_L11:
        cy.g("FlurryAgent", (new StringBuilder()).append("MaxEventParams exceeded: ").append(s1.size()).toString());
          goto _L4
        s1;
        throw s1;
_L8:
        cy.g("FlurryAgent", (new StringBuilder()).append("Too many different events. Event not counted: ").append(s2).toString());
          goto _L13
_L6:
        s1.value = ((k) (s1)).value + 1;
          goto _L13
_L12:
label0:
        {
            s1 = new fx(as.incrementAndGet(), s2, s1, l - l1, flag);
            if (s1.getBytes().length + aZ > 0x27100)
            {
                break label0;
            }
            aX.add(s1);
            int i = aZ;
            aZ = s1.getBytes().length + i;
        }
          goto _L4
        aZ = 0x27100;
        aY = false;
        cy.g("FlurryAgent", "Event Log size exceeded. No more event details logged.");
          goto _L4
_L10:
        aY = false;
          goto _L4
        s1 = map;
          goto _L14
    }

    static boolean a(FlurryAgent flurryagent)
    {
        return flurryagent.ax;
    }

    static am b(FlurryAgent flurryagent)
    {
        return flurryagent.t();
    }

    private void b(long l)
    {
        Iterator iterator = aX.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            fx fx1 = (fx)iterator.next();
            if (fx1.bC() && !fx1.isFinished())
            {
                fx1.h(l);
            }
        } while (true);
    }

    static void b(FlurryAgent flurryagent, Context context)
    {
        flurryagent;
        JVM INSTR monitorenter ;
        long l;
        long l1;
        l = SystemClock.elapsedRealtime();
        l1 = flurryagent.ay;
        boolean flag;
        if (!flurryagent.aw && l - l1 > ao && flurryagent.aK.size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flurryagent;
        JVM INSTR monitorexit ;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        flurryagent.v();
        return;
        context;
        flurryagent;
        JVM INSTR monitorexit ;
        try
        {
            throw context;
        }
        // Misplaced declaration of an exception variable
        catch (FlurryAgent flurryagent)
        {
            cy.b("FlurryAgent", "", flurryagent);
        }
        return;
    }

    static List c(FlurryAgent flurryagent)
    {
        return flurryagent.aK;
    }

    private void d(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        aG = com.flurry.android.o.a(context);
        if (!au.exists()) goto _L2; else goto _L1
_L1:
        cy.e("FlurryAgent", (new StringBuilder()).append("loading persistent data: ").append(au.getAbsolutePath()).toString());
        Object obj = new DataInputStream(new FileInputStream(au));
        context = ((Context) (obj));
        gr gr1 = new gr();
        context = ((Context) (obj));
        ax = gr1.a(((DataInputStream) (obj)), aA);
        context = ((Context) (obj));
        if (!ax)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        context = ((Context) (obj));
        aJ = gr1.bR();
        context = ((Context) (obj));
        aI = gr1.bP();
        context = ((Context) (obj));
        aK = gr1.bQ();
_L7:
        fl.a(((java.io.Closeable) (obj)));
_L8:
        if (ax) goto _L4; else goto _L3
_L3:
        if (!au.delete()) goto _L6; else goto _L5
_L5:
        cy.c("FlurryAgent", "Deleted persistence file");
_L4:
        if (!ax)
        {
            aI = false;
            aJ = aL;
            ax = true;
        }
        if (r())
        {
            be.setReportedIds(aH);
        }
        bc = (new ar(av)).W();
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj1;
        obj1;
        context = ((Context) (obj));
        ((IOException) (obj1)).printStackTrace();
          goto _L7
        obj1;
_L10:
        context = ((Context) (obj));
        cy.b("FlurryAgent", "Error when loading persistent file", ((Throwable) (obj1)));
        fl.a(((java.io.Closeable) (obj)));
          goto _L8
        context;
        throw context;
        obj;
        context = null;
_L9:
        fl.a(context);
        throw obj;
_L6:
        cy.d("FlurryAgent", "Cannot delete persistence file");
          goto _L4
        context;
        cy.b("FlurryAgent", "", context);
          goto _L4
_L2:
        cy.e("FlurryAgent", "Agent cache file doesn't exist.");
          goto _L4
        obj;
          goto _L9
        obj1;
        obj = null;
          goto _L10
    }

    static void d(FlurryAgent flurryagent)
    {
        flurryagent.w();
    }

    static Handler e(FlurryAgent flurryagent)
    {
        return flurryagent.ar;
    }

    private static String e(Context context)
    {
        context = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        if (((PackageInfo) (context)).versionName != null)
        {
            return ((PackageInfo) (context)).versionName;
        }
        if (((PackageInfo) (context)).versionCode == 0)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        context = Integer.toString(((PackageInfo) (context)).versionCode);
        return context;
        context;
        cy.b("FlurryAgent", "", context);
        return "Unknown";
    }

    public static void endTimedEvent(String s1)
    {
        if (s1 == null)
        {
            cy.d("FlurryAgent", "String eventId passed to endTimedEvent was null.");
            return;
        }
        try
        {
            an.a(s1, ((Map) (null)));
            return;
        }
        catch (Throwable throwable)
        {
            cy.b("FlurryAgent", (new StringBuilder()).append("Failed to signify the end of event: ").append(s1).toString(), throwable);
        }
    }

    public static void endTimedEvent(String s1, Map map)
    {
        if (s1 == null)
        {
            cy.d("FlurryAgent", "String eventId passed to endTimedEvent was null.");
            return;
        }
        if (map == null)
        {
            cy.d("FlurryAgent", "String eventId passed to endTimedEvent was null.");
            return;
        }
        try
        {
            an.a(s1, map);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            cy.b("FlurryAgent", (new StringBuilder()).append("Failed to signify the end of event: ").append(s1).toString(), map);
        }
    }

    private Location f(Context context)
    {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0 && context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        context = (LocationManager)context.getSystemService("location");
        this;
        JVM INSTR monitorenter ;
        if (aF != null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        aF = context;
_L1:
        this;
        JVM INSTR monitorexit ;
        Criteria criteria = aq;
        Object obj = criteria;
        if (criteria == null)
        {
            obj = new Criteria();
        }
        obj = context.getBestProvider(((Criteria) (obj)), true);
        if (obj != null)
        {
            context.requestLocationUpdates(((String) (obj)), 0L, 0.0F, this, Looper.getMainLooper());
            return context.getLastKnownLocation(((String) (obj)));
        }
        break MISSING_BLOCK_LABEL_106;
        context = aF;
          goto _L1
        context;
        this;
        JVM INSTR monitorexit ;
        throw context;
        return null;
    }

    public static int getAgentVersion()
    {
        return 150;
    }

    static String getLocale()
    {
        return an.aO;
    }

    static Location getLocation()
    {
        return an.aV;
    }

    public static String getPhoneId()
    {
        return an.id();
    }

    public static boolean getUseHttps()
    {
        return ce.getUseHttps();
    }

    private String id()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = aG;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public static void logEvent(String s1)
    {
        if (s1 == null)
        {
            cy.d("FlurryAgent", "String eventId passed to logEvent was null.");
            return;
        }
        try
        {
            an.a(s1, ((Map) (null)), false);
            return;
        }
        catch (Throwable throwable)
        {
            cy.b("FlurryAgent", (new StringBuilder()).append("Failed to log event: ").append(s1).toString(), throwable);
        }
    }

    public static void logEvent(String s1, Map map)
    {
        if (s1 == null)
        {
            cy.d("FlurryAgent", "String eventId passed to logEvent was null.");
            return;
        }
        if (map == null)
        {
            cy.d("FlurryAgent", "String parameters passed to logEvent was null.");
            return;
        }
        try
        {
            an.a(s1, map, false);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            cy.b("FlurryAgent", (new StringBuilder()).append("Failed to log event: ").append(s1).toString(), map);
        }
    }

    public static void logEvent(String s1, Map map, boolean flag)
    {
        if (s1 == null)
        {
            cy.d("FlurryAgent", "String eventId passed to logEvent was null.");
            return;
        }
        if (map == null)
        {
            cy.d("FlurryAgent", "String parameters passed to logEvent was null.");
            return;
        }
        try
        {
            an.a(s1, map, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            cy.b("FlurryAgent", (new StringBuilder()).append("Failed to log event: ").append(s1).toString(), map);
        }
    }

    public static void logEvent(String s1, boolean flag)
    {
        if (s1 == null)
        {
            cy.d("FlurryAgent", "String eventId passed to logEvent was null.");
            return;
        }
        try
        {
            an.a(s1, ((Map) (null)), flag);
            return;
        }
        catch (Throwable throwable)
        {
            cy.b("FlurryAgent", (new StringBuilder()).append("Failed to log event: ").append(s1).toString(), throwable);
        }
    }

    private static IAppCloudModule n()
    {
        if (!q())
        {
            return null;
        }
        IAppCloudModule iappcloudmodule;
        try
        {
            iappcloudmodule = (IAppCloudModule)Class.forName("com.flurry.android.es").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        }
        catch (Exception exception)
        {
            exception.toString();
            return null;
        }
        return iappcloudmodule;
    }

    private static IFlurryAds o()
    {
        if (!r())
        {
            return null;
        }
        IFlurryAds iflurryads;
        try
        {
            iflurryads = (IFlurryAds)Class.forName("com.flurry.android.FlurryAds").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        }
        catch (Exception exception)
        {
            exception.toString();
            return null;
        }
        return iflurryads;
    }

    public static void onEndSession(Context context)
    {
        if (context == null)
        {
            throw new NullPointerException("Null context");
        }
        try
        {
            an.a(context, false);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            cy.b("FlurryAgent", "", context);
        }
    }

    public static void onError(String s1, String s2, String s3)
    {
        if (s1 == null)
        {
            cy.d("FlurryAgent", "String errorId passed to onError was null.");
            return;
        }
        if (s2 == null)
        {
            cy.d("FlurryAgent", "String message passed to onError was null.");
            return;
        }
        if (s3 == null)
        {
            cy.d("FlurryAgent", "String errorClass passed to onError was null.");
            return;
        }
        StackTraceElement astacktraceelement[] = Thread.currentThread().getStackTrace();
        if (astacktraceelement == null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        StackTraceElement astacktraceelement1[];
        if (astacktraceelement.length <= 2)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        astacktraceelement1 = new StackTraceElement[astacktraceelement.length - 2];
        System.arraycopy(astacktraceelement, 2, astacktraceelement1, 0, astacktraceelement1.length);
        astacktraceelement = astacktraceelement1;
        try
        {
            Throwable throwable = new Throwable(s2);
            throwable.setStackTrace(astacktraceelement);
            an.a(s1, s2, s3, throwable);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            cy.b("FlurryAgent", "", s1);
        }
        return;
    }

    public static void onError(String s1, String s2, Throwable throwable)
    {
        if (s1 == null)
        {
            cy.d("FlurryAgent", "String errorId passed to onError was null.");
            return;
        }
        if (s2 == null)
        {
            cy.d("FlurryAgent", "String message passed to onError was null.");
            return;
        }
        if (throwable == null)
        {
            cy.d("FlurryAgent", "Throwable passed to onError was null.");
            return;
        }
        try
        {
            an.a(s1, s2, throwable.getClass().getName(), throwable);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            cy.b("FlurryAgent", "", s1);
        }
    }

    public static void onEvent(String s1)
    {
        if (s1 == null)
        {
            cy.d("FlurryAgent", "String eventId passed to onEvent was null.");
            return;
        }
        try
        {
            an.a(s1, ((Map) (null)), false);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            cy.b("FlurryAgent", "", s1);
        }
    }

    public static void onEvent(String s1, Map map)
    {
        if (s1 == null)
        {
            cy.d("FlurryAgent", "String eventId passed to onEvent was null.");
            return;
        }
        if (map == null)
        {
            cy.d("FlurryAgent", "Parameters Map passed to onEvent was null.");
            return;
        }
        try
        {
            an.a(s1, map, false);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            cy.b("FlurryAgent", "", s1);
        }
    }

    public static void onPageView()
    {
        try
        {
            an.u();
            return;
        }
        catch (Throwable throwable)
        {
            cy.b("FlurryAgent", "", throwable);
        }
    }

    public static void onStartSession(Context context, String s1)
    {
        if (context == null)
        {
            throw new NullPointerException("Null context");
        }
        if (s1 == null || s1.length() == 0)
        {
            throw new IllegalArgumentException("Api key not specified");
        }
        try
        {
            an.a(context, s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            cy.b("FlurryAgent", "", context);
        }
    }

    static boolean p()
    {
        return an.ax && an.aw;
    }

    static boolean q()
    {
        if (n.SDK_INT > 8)
        {
            if (an != null && an.bf != null)
            {
                return true;
            }
            Class class1;
            try
            {
                class1 = Class.forName("com.flurry.android.es");
            }
            catch (Throwable throwable)
            {
                (new StringBuilder()).append("isAppCloudEnabled caught:").append(throwable.toString()).toString();
                return false;
            }
            if (class1 != null)
            {
                return true;
            }
        }
        return false;
    }

    static boolean r()
    {
        if (n.SDK_INT > 8)
        {
            if (an != null && an.be != null)
            {
                return true;
            }
            Class class1;
            try
            {
                class1 = Class.forName("com.flurry.android.FlurryAds");
            }
            catch (Throwable throwable)
            {
                (new StringBuilder()).append("isAppSpotEnabled caught:").append(throwable.toString()).toString();
                return false;
            }
            if (class1 != null)
            {
                return true;
            }
        }
        return false;
    }

    public static void setAge(int i)
    {
        if (i > 0 && i < 110)
        {
            Date date = new Date((new Date(System.currentTimeMillis() - (long)i * 0x7528ad000L)).getYear(), 1, 1);
            an.aT = Long.valueOf(date.getTime());
        }
    }

    public static void setCaptureUncaughtExceptions(boolean flag)
    {
        com.flurry.android.ay.Y().setEnabled(flag);
    }

    public static void setContinueSessionMillis(long l)
    {
        if (l < 5000L)
        {
            cy.d("FlurryAgent", (new StringBuilder()).append("Invalid time set for session resumption: ").append(l).toString());
            return;
        }
        synchronized (an)
        {
            ao = l;
        }
        return;
        exception;
        flurryagent;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void setGender(byte byte0)
    {
        switch (byte0)
        {
        default:
            an.aS = -1;
            return;

        case 0: // '\0'
        case 1: // '\001'
            an.aS = byte0;
            break;
        }
    }

    public static void setLocationCriteria(Criteria criteria)
    {
        synchronized (an)
        {
            aq = criteria;
        }
        return;
        criteria;
        flurryagent;
        JVM INSTR monitorexit ;
        throw criteria;
    }

    public static void setLogEnabled(boolean flag)
    {
        FlurryAgent flurryagent = an;
        flurryagent;
        JVM INSTR monitorenter ;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        cy.aE();
_L2:
        flurryagent;
        JVM INSTR monitorexit ;
        return;
        cy.aD();
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        flurryagent;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void setLogEvents(boolean flag)
    {
        synchronized (an)
        {
            ap = flag;
        }
        return;
        exception;
        flurryagent;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void setLogLevel(int i)
    {
        synchronized (an)
        {
            cy.setLogLevel(i);
        }
        return;
        exception;
        flurryagent;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void setReportLocation(boolean flag)
    {
        synchronized (an)
        {
            an.aD = flag;
        }
        return;
        exception;
        flurryagent;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void setReportUrl(String s1)
    {
        ce.setReportUrl(s1);
    }

    public static void setUseHttps(boolean flag)
    {
        ce.setUseHttps(flag);
    }

    public static void setUserId(String s1)
    {
        if (s1 == null)
        {
            cy.d("FlurryAgent", "String userId passed to setUserId was null.");
            return;
        }
        synchronized (an)
        {
            an.aR = fl.sanitize(s1);
        }
        return;
        s1;
        flurryagent;
        JVM INSTR monitorexit ;
        throw s1;
    }

    public static void setVersionName(String s1)
    {
        if (s1 == null)
        {
            cy.d("FlurryAgent", "String versionName passed to setVersionName was null.");
            return;
        }
        synchronized (an)
        {
            an.aC = s1;
        }
        return;
        s1;
        flurryagent;
        JVM INSTR monitorexit ;
        throw s1;
    }

    private am t()
    {
        this;
        JVM INSTR monitorenter ;
        eb eb1;
        eb1 = new eb();
        eb1.setVersion(aC);
        eb1.d(aL);
        eb1.e(aN);
        eb1.f(0L);
        eb1.y(aO);
        eb1.setTimeZone(aP);
        eb1.b(aQ);
        if (aR != null) goto _L2; else goto _L1
_L1:
        Object obj = "";
_L6:
        eb1.setUserId(((String) (obj)));
        eb1.a(aV);
        eb1.c(bb);
        eb1.setGender(aS);
        eb1.c(aT);
        eb1.e(aX);
        eb1.b(aW);
        eb1.f(ba);
        eb1.d(aU);
        eb1.a(aY);
        obj = new am(eb1);
_L4:
        this;
        JVM INSTR monitorexit ;
        return ((am) (obj));
_L2:
        obj = aR;
        continue; /* Loop/switch isn't completed */
        Object obj1;
        obj1;
        ((IOException) (obj1)).printStackTrace();
        obj1 = null;
        if (true) goto _L4; else goto _L3
_L3:
        obj1;
        throw obj1;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void u()
    {
        this;
        JVM INSTR monitorenter ;
        bb = bb + 1;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void v()
    {
        StringBuilder stringbuilder;
        cy.c("FlurryAgent", "generating agent report");
        cn cn1 = new cn(aA, aC, id(), aJ, aL, aK, av, aH, bc, bd);
        aE = new ArrayList(aK);
        if (cn1.N() == null)
        {
            break MISSING_BLOCK_LABEL_215;
        }
        cy.c("FlurryAgent", (new StringBuilder()).append("generated report of size ").append(cn1.N().length).append(" with ").append(aK.size()).append(" reports.").toString());
        bg.a(cn1.N());
        aI = true;
        aK.removeAll(aE);
        aE = null;
        stringbuilder = (new StringBuilder()).append("Done sending ");
        Object obj;
        if (aw)
        {
            obj = "initial ";
        } else
        {
            obj = "";
        }
        try
        {
            cy.c("FlurryAgent", stringbuilder.append(((String) (obj))).append("agent report").toString());
            w();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            cy.b("FlurryAgent", "", ((Throwable) (obj)));
        }
        break MISSING_BLOCK_LABEL_233;
        cy.c("FlurryAgent", "Error generating report");
        return;
    }

    private void w()
    {
        this;
        JVM INSTR monitorenter ;
        if (com.flurry.android.an.a(au)) goto _L2; else goto _L1
_L1:
        cy.d("FlurryAgent", "ERROR! CREATE PARENT DIR DIDN'T PROCCEED");
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(au));
        gr gr1 = new gr();
        gr1.i(aJ);
        gr1.b(aI);
        gr1.k(aK);
        gr1.a(dataoutputstream, aA, id());
          goto _L3
        Object obj;
        obj;
        ((FileNotFoundException) (obj)).printStackTrace();
          goto _L3
        obj;
        throw obj;
        obj;
        ((IOException) (obj)).printStackTrace();
          goto _L3
    }

    private void x()
    {
        this;
        JVM INSTR monitorenter ;
        if (aF != null)
        {
            aF.removeUpdates(this);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static String y()
    {
        return an.aA;
    }

    static String z()
    {
        return an.aP;
    }

    final void a(Throwable throwable)
    {
        Object obj;
        StackTraceElement astacktraceelement[];
        throwable.printStackTrace();
        obj = "";
        astacktraceelement = throwable.getStackTrace();
        if (astacktraceelement == null || astacktraceelement.length <= 0) goto _L2; else goto _L1
_L1:
        obj = new StringBuilder();
        if (throwable.getMessage() != null)
        {
            ((StringBuilder) (obj)).append((new StringBuilder()).append(" (").append(throwable.getMessage()).append(")\n").toString());
        }
        obj = ((StringBuilder) (obj)).toString();
_L4:
        onError("uncaught", ((String) (obj)), throwable);
        az.clear();
        a(((Context) (null)), true);
        return;
_L2:
        if (throwable.getMessage() != null)
        {
            obj = throwable.getMessage();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected final byte[] fetchHashedImei(Context context)
    {
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        context = (TelephonyManager)context.getSystemService("phone");
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        context = context.getDeviceId();
        if (context == null || context.trim().length() <= 0)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        context = fl.F(context);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        if (context.length == 20)
        {
            return context;
        }
        try
        {
            cy.d("FlurryAgent", (new StringBuilder()).append("sha1 is not 20 bytes long: ").append(Arrays.toString(context)).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        return null;
    }

    public final boolean getNetworkStatus()
    {
        if (bh != null)
        {
            return bh.bu();
        } else
        {
            return true;
        }
    }

    public final void onLocationChanged(Location location)
    {
        this;
        JVM INSTR monitorenter ;
        aV = location;
        x();
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        location;
        cy.b("FlurryAgent", "", location);
        if (true) goto _L2; else goto _L1
_L1:
        location;
        throw location;
    }

    public final void onNetworkStateChanged(boolean flag)
    {
        Log.e("myNetworkListener", (new StringBuilder()).append("onNetworkStateChanged = ").append(flag).toString());
        while (an == null || an.bg == null) 
        {
            return;
        }
        an.a(new f(flag));
    }

    public final void onProviderDisabled(String s1)
    {
    }

    public final void onProviderEnabled(String s1)
    {
    }

    public final void onStatusChanged(String s1, int i, Bundle bundle)
    {
    }

    final ce s()
    {
        return bg;
    }

}
