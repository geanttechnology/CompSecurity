// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.exacttarget.etpushsdk.data.Attribute;
import com.exacttarget.etpushsdk.data.Message;
import com.exacttarget.etpushsdk.data.Region;
import com.exacttarget.etpushsdk.data.RegionMessage;
import com.exacttarget.etpushsdk.data.Registration;
import com.exacttarget.etpushsdk.database.e;
import com.exacttarget.etpushsdk.database.f;
import com.exacttarget.etpushsdk.database.g;
import com.exacttarget.etpushsdk.database.h;
import com.exacttarget.etpushsdk.event.ReadyAimFireInitCompletedEvent;
import com.exacttarget.etpushsdk.event.RegistrationEvent;
import com.exacttarget.etpushsdk.event.RegistrationEventListener;
import com.exacttarget.etpushsdk.util.EventBus;
import com.exacttarget.etpushsdk.util.b;
import com.exacttarget.etpushsdk.util.d;
import com.exacttarget.etpushsdk.util.j;
import com.exacttarget.etpushsdk.util.m;
import com.exacttarget.etpushsdk.util.o;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.exacttarget.etpushsdk:
//            y, ETException, s, t, 
//            u, v, w, ETPushReceiver, 
//            x, ETPushConfig, o, ETLocationReceiver, 
//            ETPushService, ETLocationService, ETLandingPagePresenter, ETLocationManager, 
//            ETAnalytics, q, r, z, 
//            p

public class ETPush
    implements RegistrationEventListener
{

    private static final Object a = new Object();
    private static final Object b = new Object();
    private static CountDownLatch c = new CountDownLatch(0);
    private static CountDownLatch d = new CountDownLatch(0);
    private static AlarmManager e;
    private static Context f;
    private static ETPush g;
    private static Boolean h = null;
    private static Registration i;
    private static Integer j = Integer.valueOf(5);
    private static a k = null;
    private static a l = null;
    private static a m = new a(1);
    private static Thread n = null;
    private static Class o;
    private static Class p;
    private static Class q;
    private static String r = null;
    private static Uri s = null;
    private static Integer t = null;
    private Object u;

    private ETPush()
    {
        u = null;
    }

    ETPush(com.exacttarget.etpushsdk.o o1)
    {
        this();
    }

    private static void A()
    {
        if (k.d() > 0L)
        {
            com.exacttarget.etpushsdk.util.m.a("~!ETPush", "waitForRAF_toInitializeLatch aborted.");
            k.a();
        }
        if (l.d() > 0L)
        {
            com.exacttarget.etpushsdk.util.m.a("~!ETPush", "waitForPushManager_toInitializeLatch aborted.");
            l.a();
        }
        if (m.d() > 0L)
        {
            com.exacttarget.etpushsdk.util.m.a("~!ETPush", "waitForRAF_toStartLatch aborted.");
            m.a();
        }
    }

    private void B()
    {
        C();
        (new Thread(new y(this))).start();
    }

    private void C()
    {
        com.exacttarget.etpushsdk.util.d.a(f, "et_android_version", android.os.Build.VERSION.RELEASE);
    }

    private Object D()
    {
        if (u == null)
        {
            try
            {
                u = Class.forName("com.amazon.device.messaging.ADM").getConstructor(new Class[] {
                    android/content/Context
                }).newInstance(new Object[] {
                    f
                });
            }
            catch (ClassNotFoundException classnotfoundexception)
            {
                com.exacttarget.etpushsdk.util.m.c("~!ETPush", classnotfoundexception.getMessage(), classnotfoundexception);
                A();
                throw new ETException("unable to find com.amazon.device.messaging.ADM");
            }
            catch (Exception exception)
            {
                com.exacttarget.etpushsdk.util.m.c("~!ETPush", exception.getMessage(), exception);
                A();
                throw new ETException(exception.getCause().getMessage());
            }
        }
        return u;
    }

    private void E()
    {
        C();
        try
        {
            com.exacttarget.etpushsdk.util.m.a("~!ETPush", "Requesting ADM Registration");
            Class.forName("com.amazon.device.messaging.ADM").getMethod("startRegister", new Class[0]).invoke(D(), new Object[0]);
            return;
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            com.exacttarget.etpushsdk.util.m.c("~!ETPush", classnotfoundexception.getMessage(), classnotfoundexception);
            A();
            throw new ETException("unable to find com.amazon.device.messaging.ADM");
        }
        catch (Exception exception)
        {
            com.exacttarget.etpushsdk.util.m.c("~!ETPush", exception.getMessage(), exception);
            A();
            throw new ETException(exception.getCause().getMessage());
        }
    }

    public static Context a()
    {
        return f;
    }

    static a a(a a1)
    {
        l = a1;
        return a1;
    }

    static ETPush a(ETPush etpush)
    {
        g = etpush;
        return etpush;
    }

    static Registration a(Registration registration)
    {
        i = registration;
        return registration;
    }

    static Boolean a(Boolean boolean1)
    {
        h = boolean1;
        return boolean1;
    }

    static CountDownLatch a(CountDownLatch countdownlatch)
    {
        c = countdownlatch;
        return countdownlatch;
    }

    static void a(Activity activity, boolean flag)
    {
        d(activity, flag);
    }

    private static void a(Application application)
    {
        if (android.os.Build.VERSION.SDK_INT < 14)
        {
            return;
        } else
        {
            application.registerActivityLifecycleCallbacks(new s());
            return;
        }
    }

    protected static void a(Uri uri, boolean flag)
    {
        if (uri != null)
        {
            s = uri;
            return;
        } else
        {
            throw new RuntimeException("Notification Action URI may not be null.");
        }
    }

    static void a(ETPush etpush, boolean flag)
    {
        etpush.a(flag);
    }

    protected static void a(Class class1, boolean flag)
    {
        if (flag && !a(class1))
        {
            throw new RuntimeException(String.format("%s is not found in AndroidManifest.", new Object[] {
                class1.getName()
            }));
        } else
        {
            o = class1;
            return;
        }
    }

    protected static void a(Integer integer, boolean flag)
    {
        if (flag && !a(integer))
        {
            throw new RuntimeException("Notification Icon is not found in Application Resources.");
        } else
        {
            t = integer;
            return;
        }
    }

    protected static void a(String s1, boolean flag)
    {
        if (!TextUtils.isEmpty(s1))
        {
            r = s1;
            return;
        } else
        {
            throw new RuntimeException("Notification Action may not be empty or null.");
        }
    }

    private void a(boolean flag)
    {
        com.exacttarget.etpushsdk.util.d.a(f, "et_push_enabled", Boolean.valueOf(flag));
    }

    private static boolean a(Class class1)
    {
        Intent intent = new Intent();
        intent.setClass(f, class1);
        return f.getPackageManager().queryIntentActivities(intent, 0x10000).size() >= 1;
    }

    private static boolean a(Integer integer)
    {
        String s1;
        if (integer != null && integer.intValue() != 0)
        {
            if ((s1 = f.getResources().getResourceName(integer.intValue())) != null && s1.startsWith(f.getPackageName()) && (integer = BitmapFactory.decodeResource(f.getResources(), integer.intValue())) != null)
            {
                if (!integer.hasAlpha())
                {
                    com.exacttarget.etpushsdk.util.m.c("~!ETPush", "Notification icon should have alpha channel colors only to be properly displayed in Android 5.0");
                }
                return true;
            }
        }
        return false;
    }

    private static boolean a(List list, Class class1, String s1)
    {
        String s2;
        boolean flag;
        Object obj;
        ResolveInfo resolveinfo;
        int i1;
        if (list != null)
        {
            i1 = list.size();
        } else
        {
            i1 = 0;
        }
        obj = class1.getName();
        if (!TextUtils.isEmpty(s1))
        {
            s2 = s1;
        } else
        {
            s2 = "NULL or Empty String";
        }
        com.exacttarget.etpushsdk.util.m.b("~!ETPush", String.format("Receivers Info Size: %d, Receiver Class Name: %s, Package Name: %s", new Object[] {
            Integer.valueOf(i1), obj, s2
        }));
        if (list == null) goto _L2; else goto _L1
_L1:
        obj = list.iterator();
_L5:
        if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L3
_L3:
        resolveinfo = (ResolveInfo)((Iterator) (obj)).next();
        if (resolveinfo.activityInfo != null)
        {
            list = resolveinfo.activityInfo.name;
        } else
        {
            list = "NULL";
        }
        if (resolveinfo.activityInfo != null)
        {
            s2 = resolveinfo.activityInfo.packageName;
        } else
        {
            s2 = "NULL";
        }
        com.exacttarget.etpushsdk.util.m.b("~!ETPush", String.format("ActivityInfo Name: %s, ActivityInfo Package: %s", new Object[] {
            list, s2
        }));
        if (resolveinfo.activityInfo == null || !resolveinfo.activityInfo.name.equals(class1.getName()) || !resolveinfo.activityInfo.packageName.equals(s1)) goto _L5; else goto _L4
_L4:
        com.exacttarget.etpushsdk.util.m.a("~!ETPush", String.format("Receiver %s Found", new Object[] {
            class1.getName()
        }));
        flag = true;
_L7:
        if (!flag)
        {
            com.exacttarget.etpushsdk.util.m.a("~!ETPush", String.format("Did NOT find %s Receiver", new Object[] {
                class1.getName()
            }));
        }
        return flag;
_L2:
        flag = false;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static void activityPaused(Activity activity)
    {
        com/exacttarget/etpushsdk/ETPush;
        JVM INSTR monitorenter ;
        c(activity, false);
        com/exacttarget/etpushsdk/ETPush;
        JVM INSTR monitorexit ;
        return;
        activity;
        throw activity;
    }

    public static void activityResumed(Activity activity)
    {
        com/exacttarget/etpushsdk/ETPush;
        JVM INSTR monitorenter ;
        d(activity, false);
        com/exacttarget/etpushsdk/ETPush;
        JVM INSTR monitorexit ;
        return;
        activity;
        throw activity;
    }

    protected static Registration b()
    {
        return i;
    }

    static CountDownLatch b(CountDownLatch countdownlatch)
    {
        d = countdownlatch;
        return countdownlatch;
    }

    static void b(Activity activity, boolean flag)
    {
        c(activity, flag);
    }

    protected static void b(Class class1, boolean flag)
    {
        if (flag && !a(class1))
        {
            throw new RuntimeException((new StringBuilder()).append(class1.getName()).append(" is not found in AndroidManifest.").toString());
        } else
        {
            p = class1;
            return;
        }
    }

    protected static void c()
    {
        com/exacttarget/etpushsdk/ETPush;
        JVM INSTR monitorenter ;
        x();
        if (k.d() > 0L && !k.a(30000L, TimeUnit.MILLISECONDS))
        {
            throw new ETException("ETPush did not initialize in a timely fashion.");
        }
        break MISSING_BLOCK_LABEL_81;
        Object obj;
        obj;
        throw new ETException((new StringBuilder()).append("Error waiting for ETPush to be initialized. Our error was: ").append(((ETException) (obj)).getMessage()).toString());
        obj;
        com/exacttarget/etpushsdk/ETPush;
        JVM INSTR monitorexit ;
        throw obj;
        com/exacttarget/etpushsdk/ETPush;
        JVM INSTR monitorexit ;
    }

    private static void c(Activity activity, boolean flag)
    {
        if (!flag && android.os.Build.VERSION.SDK_INT >= 14)
        {
            return;
        }
        com.exacttarget.etpushsdk.util.m.a("~!ETPush", String.format("Pausing as a result of callback? '%1$s'", new Object[] {
            String.valueOf(flag)
        }));
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        activity = new Thread(new t(activity));
        if (c.getCount() != 0L)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        com.exacttarget.etpushsdk.util.m.a("~!ETPush", "activityResumedThread is not running.  So continue with pausing activity.");
        c = new CountDownLatch(1);
        activity.start();
_L1:
        return;
        activity;
        obj;
        JVM INSTR monitorexit ;
        throw activity;
        (new Thread(new u(activity))).start();
          goto _L1
    }

    protected static void c(Class class1, boolean flag)
    {
        if (flag && !a(class1))
        {
            throw new RuntimeException((new StringBuilder()).append(class1.getName()).append(" is not found in AndroidManifest.").toString());
        } else
        {
            q = class1;
            return;
        }
    }

    protected static void d()
    {
        com.exacttarget.etpushsdk.util.m.a("~!ETPush", "Cancelling activityPausedPendingIntent");
        e.cancel(e());
    }

    private static void d(Activity activity, boolean flag)
    {
        if (!flag && android.os.Build.VERSION.SDK_INT >= 14)
        {
            return;
        }
        com.exacttarget.etpushsdk.util.m.a("~!ETPush", String.format("Resuming as a result of callback? '%1$s'", new Object[] {
            String.valueOf(flag)
        }));
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        activity = new Thread(new v(activity));
        if (c.getCount() != 0L)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        com.exacttarget.etpushsdk.util.m.a("~!ETPush", "activityPausedThread is not running.  So continue with resuming activity.");
        c = new CountDownLatch(1);
        activity.start();
_L1:
        return;
        activity;
        obj;
        JVM INSTR monitorexit ;
        throw activity;
        (new Thread(new w(activity))).start();
          goto _L1
    }

    protected static PendingIntent e()
    {
        Intent intent = new Intent(a(), com/exacttarget/etpushsdk/ETPushReceiver);
        intent.setAction("et_push_app_in_background");
        intent.putExtra("time_went_in_background", System.currentTimeMillis());
        return PendingIntent.getBroadcast(a(), 1000, intent, 0x8000000);
    }

    protected static void f()
    {
        com.exacttarget.etpushsdk.util.m.a("~!ETPush", "sendRegistration() started...");
        if (!TextUtils.isEmpty(i.getSystemToken()))
        {
            com.exacttarget.etpushsdk.util.m.a("~!ETPush", "have systemToken, send registration...");
            (new Thread(new x())).start();
        }
        com.exacttarget.etpushsdk.util.m.a("~!ETPush", "sendRegistration() ended...");
    }

    protected static Class g()
    {
        return p;
    }

    public static ETPush getInstance()
    {
        com/exacttarget/etpushsdk/ETPush;
        JVM INSTR monitorenter ;
        long l1;
        x();
        l1 = l.d();
        if (l1 <= 0L)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        com.exacttarget.etpushsdk.util.m.a("~!ETPush", "Waiting for PushManager to initialize");
        if (!l.a(25000L, TimeUnit.MILLISECONDS))
        {
            throw new ETException("ETPush singleton getInstance did not initialize in a timely fashion.");
        }
        break MISSING_BLOCK_LABEL_92;
        Object obj;
        obj;
        throw new ETException((new StringBuilder()).append("ETPush singleton getInstance initialized failed with an error. Our error was: ").append(((ETException) (obj)).getMessage()).toString());
        obj;
        com/exacttarget/etpushsdk/ETPush;
        JVM INSTR monitorexit ;
        throw obj;
        ETPush etpush = g;
        com/exacttarget/etpushsdk/ETPush;
        JVM INSTR monitorexit ;
        return etpush;
    }

    public static int getLogLevel()
    {
        return j.intValue();
    }

    public static Class getNotificationRecipientClass()
    {
        return o;
    }

    public static Integer getNotificationResourceId()
    {
        return t;
    }

    public static int getSdkVersionCode()
    {
        return com.exacttarget.etpushsdk.util.o.b();
    }

    public static String getSdkVersionName()
    {
        return com.exacttarget.etpushsdk.util.o.a();
    }

    protected static Class h()
    {
        return q;
    }

    static Context k()
    {
        return f;
    }

    static boolean l()
    {
        return z();
    }

    static Boolean m()
    {
        return h;
    }

    static Registration n()
    {
        return i;
    }

    static a o()
    {
        return l;
    }

    static void p()
    {
        y();
    }

    public static ETPush pushManager()
    {
        com/exacttarget/etpushsdk/ETPush;
        JVM INSTR monitorenter ;
        ETPush etpush = getInstance();
        com/exacttarget/etpushsdk/ETPush;
        JVM INSTR monitorexit ;
        return etpush;
        Exception exception;
        exception;
        throw exception;
    }

    static void q()
    {
        A();
    }

    static a r()
    {
        return k;
    }

    public static void readyAimFire(Application application, String s1, String s2, String s3, boolean flag, boolean flag1, boolean flag2)
    {
        readyAimFire(application, s1, s2, s3, flag, false, flag1, flag2);
    }

    public static void readyAimFire(Application application, String s1, String s2, String s3, boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        readyAimFire((new ETPushConfig.Builder(application)).setEtAppId(s1).setAccessToken(s2).setGcmSenderId(s3).setAnalyticsEnabled(flag).setPiAnalyticsEnabled(flag1).setLocationEnabled(flag2).setCloudPagesEnabled(flag3).build());
    }

    public static void readyAimFire(ETPushConfig etpushconfig)
    {
        com.exacttarget.etpushsdk.util.m.a("~!ETPush", "readyAimFire()");
        k = new a(1);
        f = etpushconfig.a;
        a((Application)f);
        e = (AlarmManager)f.getSystemService("alarm");
        m.c();
        if (g == null)
        {
            if (TextUtils.isEmpty(etpushconfig.b) || !etpushconfig.b.toLowerCase().matches("[0-9a-f]{8}-[a-f0-9]{4}-4[a-f0-9]{3}-[89aAbB][a-f0-9]{3}-[a-f0-9]{12}"))
            {
                com.exacttarget.etpushsdk.util.m.d("~!ETPush:readyAimFire", "ERROR: The etAppId is not a valid UUID. Did you copy/paste incorrectly?");
                etpushconfig = new ETException("The etAppId is not a valid UUID. Did you copy/paste incorrectly?");
                EventBus.getInstance().a(new ReadyAimFireInitCompletedEvent(false, etpushconfig));
                throw etpushconfig;
            }
            if (TextUtils.isEmpty(etpushconfig.c) || etpushconfig.c.length() != 24)
            {
                com.exacttarget.etpushsdk.util.m.d("~!ETPush:readyAimFire", "ERROR: The accessToken is not 24 characters. Did you copy/paste incorrectly?");
                etpushconfig = new ETException("The accessToken is not 24 characters. Did you copy/paste incorrectly?");
                EventBus.getInstance().a(new ReadyAimFireInitCompletedEvent(false, etpushconfig));
                throw etpushconfig;
            }
            if (TextUtils.isEmpty(etpushconfig.d))
            {
                com.exacttarget.etpushsdk.util.m.d("~!ETPush:readyAimFire", "ERROR: The gcmSenderId may not be null or empty. Did you copy/paste incorrectly?");
                etpushconfig = new ETException("The gcmSenderId may not be null or empty. Did you copy/paste incorrectly?");
                EventBus.getInstance().a(new ReadyAimFireInitCompletedEvent(false, etpushconfig));
                throw etpushconfig;
            }
            if (com.exacttarget.etpushsdk.util.b.a() && etpushconfig.g)
            {
                com.exacttarget.etpushsdk.util.m.d("~!ETPush:readyAimFire", "ERROR: LocationManager is enabled but Location Services are not available on this Amazon Device.");
                etpushconfig = new ETException("LocationManager is enabled but Location Services are not available on this Amazon Device.");
                EventBus.getInstance().a(new ReadyAimFireInitCompletedEvent(false, etpushconfig));
                throw etpushconfig;
            } else
            {
                n = new Thread(new com.exacttarget.etpushsdk.o(etpushconfig));
                n.start();
                return;
            }
        } else
        {
            throw new ETException("You must have called readyAimFire more than once. It should only be called from your Application's Application#onCreate() method.");
        }
    }

    static ETPush s()
    {
        return g;
    }

    public static void setLogLevel(int i1)
    {
        if (i1 >= 2 && i1 <= 7)
        {
            j = Integer.valueOf(i1);
        } else
        {
            Log.w("~!ETPush", "Invalid log level set.  Setting to Log.WARN.");
            j = Integer.valueOf(5);
        }
        if (i1 >= 3)
        {
            Log.d("~!ETPush", (new StringBuilder()).append("Logging set to :").append(j).toString());
        }
    }

    static AlarmManager t()
    {
        return e;
    }

    static CountDownLatch u()
    {
        return c;
    }

    static CountDownLatch v()
    {
        return d;
    }

    static Thread w()
    {
        return n;
    }

    private static void x()
    {
        com/exacttarget/etpushsdk/ETPush;
        JVM INSTR monitorenter ;
        if (m == null)
        {
            throw new ETException("No readyAimFire() call.  Please see documentation and add to your Application class.");
        }
        break MISSING_BLOCK_LABEL_26;
        Object obj;
        obj;
        com/exacttarget/etpushsdk/ETPush;
        JVM INSTR monitorexit ;
        throw obj;
        if (k != null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        com.exacttarget.etpushsdk.util.m.a("~!ETPush", "Wait for readyAimFire() to be called.");
        if (!m.a(15000L, TimeUnit.MILLISECONDS))
        {
            m = null;
            throw new ETException("Waiting for readyAimFire() to be called timed out.  Did you forget to call readyAimFire()?");
        }
        break MISSING_BLOCK_LABEL_107;
        obj;
        m = null;
        throw new ETException((new StringBuilder()).append("Error waiting for readyAimFire() to be called. Our error was: ").append(((ETException) (obj)).getMessage()).toString());
        if (k.b())
        {
            throw new ETException("readyAimFire() initialization aborted.  See LogCat for more information.");
        }
        com/exacttarget/etpushsdk/ETPush;
        JVM INSTR monitorexit ;
    }

    private static void y()
    {
label0:
        {
            PackageManager packagemanager = f.getPackageManager();
            String s1 = f.getPackageName();
            Object obj1 = new ArrayList();
            Object obj;
            if (com.exacttarget.etpushsdk.util.j.a(f))
            {
                com.exacttarget.etpushsdk.util.m.a("~!ETPush", "Google Device.");
                ((List) (obj1)).add((new StringBuilder()).append(s1).append(".permission.C2D_MESSAGE").toString());
                ((List) (obj1)).add("com.google.android.c2dm.permission.RECEIVE");
                obj = "com.google.android.c2dm.permission.SEND";
            } else
            if (com.exacttarget.etpushsdk.util.b.a(f))
            {
                com.exacttarget.etpushsdk.util.m.a("~!ETPush", "Amazon Device.");
                ((List) (obj1)).add((new StringBuilder()).append(s1).append(".permission.RECEIVE_ADM_MESSAGE").toString());
                ((List) (obj1)).add("com.amazon.device.messaging.permission.RECEIVE");
                obj = "com.amazon.device.messaging.permission.SEND";
            } else
            {
                A();
                throw new ETException("Unable to continue.  Neither Google Services nor Amazon Device Messaging is available");
            }
            ((List) (obj1)).add("android.permission.INTERNET");
            ((List) (obj1)).add("android.permission.GET_ACCOUNTS");
            ((List) (obj1)).add("android.permission.WAKE_LOCK");
            ((List) (obj1)).add("android.permission.ACCESS_NETWORK_STATE");
            ((List) (obj1)).add("android.permission.ACCESS_WIFI_STATE");
            if (com.exacttarget.etpushsdk.util.d.h())
            {
                ((List) (obj1)).add("android.permission.ACCESS_COARSE_LOCATION");
                ((List) (obj1)).add("android.permission.ACCESS_FINE_LOCATION");
                ((List) (obj1)).add("android.permission.RECEIVE_BOOT_COMPLETED");
            }
            for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext();)
            {
                String s2 = (String)((Iterator) (obj1)).next();
                if (packagemanager.checkPermission(s2, s1) != 0)
                {
                    A();
                    throw new RuntimeException((new StringBuilder()).append("ApplicationManifest.xml missing required permission: ").append(s2).toString());
                }
            }

            obj1 = packagemanager.queryBroadcastReceivers(new Intent(f, com/exacttarget/etpushsdk/ETPushReceiver), 0);
            boolean flag2;
            if (obj1 != null)
            {
                obj1 = ((List) (obj1)).iterator();
                boolean flag = false;
                do
                {
                    flag2 = flag;
                    if (!((Iterator) (obj1)).hasNext())
                    {
                        break;
                    }
                    ResolveInfo resolveinfo = (ResolveInfo)((Iterator) (obj1)).next();
                    if (resolveinfo.activityInfo != null && resolveinfo.activityInfo.name.equals(com/exacttarget/etpushsdk/ETPushReceiver.getName()) && resolveinfo.activityInfo.packageName.equals(s1))
                    {
                        if (resolveinfo.activityInfo.permission == null || !resolveinfo.activityInfo.permission.equals(obj))
                        {
                            A();
                            throw new RuntimeException(String.format("%1$s definition in AndroidManifest.xml missing permission %2$s", new Object[] {
                                com/exacttarget/etpushsdk/ETPushReceiver.getName(), obj
                            }));
                        }
                        flag = true;
                    }
                } while (true);
            } else
            {
                flag2 = false;
            }
            if (!flag2)
            {
                A();
                throw new RuntimeException(String.format("%1$s definition not found in AndroidManifest.xml", new Object[] {
                    com/exacttarget/etpushsdk/ETPushReceiver.getName()
                }));
            }
            if (com.exacttarget.etpushsdk.util.j.a(f))
            {
                obj = new Intent("com.google.android.c2dm.intent.REGISTRATION");
                ((Intent) (obj)).addCategory(s1);
                obj = packagemanager.queryBroadcastReceivers(((Intent) (obj)), 0);
                com.exacttarget.etpushsdk.util.m.a("~!ETPush", String.format("Looking for com.google.android.c2dm.intent.REGISTRATION Intent Filter w/Category %s", new Object[] {
                    s1
                }));
                if (!a(((List) (obj)), com/exacttarget/etpushsdk/ETPushReceiver, s1))
                {
                    A();
                    throw new RuntimeException(String.format("%1$s definition in AndroidManifest.xml missing intent filter for com.google.android.c2dm.intent.REGISTRATION with category %2$s", new Object[] {
                        com/exacttarget/etpushsdk/ETPushReceiver.getName(), s1
                    }));
                }
                obj = new Intent("com.google.android.c2dm.intent.RECEIVE");
                ((Intent) (obj)).addCategory(s1);
                obj = packagemanager.queryBroadcastReceivers(((Intent) (obj)), 0);
                com.exacttarget.etpushsdk.util.m.a("~!ETPush", String.format("Looking for com.google.android.c2dm.intent.RECEIVE Intent Filter w/Category %s", new Object[] {
                    s1
                }));
                if (!a(((List) (obj)), com/exacttarget/etpushsdk/ETPushReceiver, s1))
                {
                    A();
                    throw new RuntimeException(String.format("%1$s definition in AndroidManifest.xml missing intent filter for com.google.android.c2dm.intent.RECEIVE with category %2$s", new Object[] {
                        com/exacttarget/etpushsdk/ETPushReceiver.getName(), s1
                    }));
                }
            } else
            if (com.exacttarget.etpushsdk.util.b.a(f))
            {
                obj = new Intent("com.amazon.device.messaging.intent.REGISTRATION");
                ((Intent) (obj)).addCategory(s1);
                obj = packagemanager.queryBroadcastReceivers(((Intent) (obj)), 0);
                com.exacttarget.etpushsdk.util.m.a("~!ETPush", String.format("Looking for com.amazon.device.messaging.intent.REGISTRATION Intent Filter w/Category %s", new Object[] {
                    s1
                }));
                if (!a(((List) (obj)), com/exacttarget/etpushsdk/ETPushReceiver, s1))
                {
                    A();
                    throw new RuntimeException(String.format("%1$s definition in AndroidManifest.xml missing intent filter for com.amazon.device.messaging.intent.REGISTRATION with category %2$s", new Object[] {
                        com/exacttarget/etpushsdk/ETPushReceiver.getName(), s1
                    }));
                }
                obj = new Intent("com.amazon.device.messaging.intent.RECEIVE");
                ((Intent) (obj)).addCategory(s1);
                obj = packagemanager.queryBroadcastReceivers(((Intent) (obj)), 0);
                com.exacttarget.etpushsdk.util.m.a("~!ETPush", String.format("Looking for com.amazon.device.messaging.intent.RECEIVE Intent Filter w/Category %s", new Object[] {
                    s1
                }));
                if (!a(((List) (obj)), com/exacttarget/etpushsdk/ETPushReceiver, s1))
                {
                    A();
                    throw new RuntimeException(String.format("%1$s definition in AndroidManifest.xml missing intent filter for com.amazon.device.messaging.intent.RECEIVE with category %2$s", new Object[] {
                        com/exacttarget/etpushsdk/ETPushReceiver.getName(), s1
                    }));
                }
            } else
            {
                A();
                throw new ETException("Unable to continue.  Neither Google Services nor Amazon Device Messaging is available");
            }
            obj = new Intent("android.intent.action.PACKAGE_REPLACED");
            ((Intent) (obj)).setData(Uri.parse("package://"));
            obj = packagemanager.queryBroadcastReceivers(((Intent) (obj)), 0);
            com.exacttarget.etpushsdk.util.m.a("~!ETPush", String.format("Looking for %s Intent Filter w/Scheme %s", new Object[] {
                "android.intent.action.PACKAGE_REPLACED", "package"
            }));
            if (!a(((List) (obj)), com/exacttarget/etpushsdk/ETPushReceiver, s1))
            {
                A();
                throw new RuntimeException(String.format("%1$s definition in AndroidManifest.xml missing intent filter for %2$s with data element containing <data android:scheme=\"package\" />", new Object[] {
                    com/exacttarget/etpushsdk/ETPushReceiver.getName(), "android.intent.action.PACKAGE_REPLACED"
                }));
            }
            obj = packagemanager.queryBroadcastReceivers(new Intent((new StringBuilder()).append(s1).append(".MESSAGE_OPENED").toString()), 0);
            com.exacttarget.etpushsdk.util.m.a("~!ETPush", String.format("Looking for %s Intent Filter", new Object[] {
                (new StringBuilder()).append(s1).append(".MESSAGE_OPENED").toString()
            }));
            if (!a(((List) (obj)), com/exacttarget/etpushsdk/ETPushReceiver, s1))
            {
                A();
                throw new RuntimeException(String.format("%1$s definition in AndroidManifest.xml missing intent filter for %2$s", new Object[] {
                    com/exacttarget/etpushsdk/ETPushReceiver.getName(), (new StringBuilder()).append(s1).append(".MESSAGE_OPENED").toString()
                }));
            }
            obj = packagemanager.queryBroadcastReceivers(new Intent("android.net.conn.CONNECTIVITY_CHANGE"), 0);
            com.exacttarget.etpushsdk.util.m.a("~!ETPush", String.format("Looking for %s Intent Filter", new Object[] {
                "android.net.conn.CONNECTIVITY_CHANGE"
            }));
            if (!a(((List) (obj)), com/exacttarget/etpushsdk/ETPushReceiver, s1))
            {
                A();
                throw new RuntimeException(String.format("%1$s definition in AndroidManifest.xml missing intent filter for android.net.conn.CONNECTIVITY_CHANGE", new Object[] {
                    com/exacttarget/etpushsdk/ETPushReceiver.getName()
                }));
            }
            obj = packagemanager.queryBroadcastReceivers(new Intent("android.intent.action.ACTION_SHUTDOWN"), 0);
            com.exacttarget.etpushsdk.util.m.a("~!ETPush", String.format("Looking for %s Intent Filter", new Object[] {
                "android.intent.action.ACTION_SHUTDOWN"
            }));
            if (!a(((List) (obj)), com/exacttarget/etpushsdk/ETPushReceiver, s1))
            {
                A();
                throw new RuntimeException(String.format("%1$s definition in AndroidManifest.xml missing intent filter for %2$s", new Object[] {
                    com/exacttarget/etpushsdk/ETPushReceiver.getName(), "android.intent.action.ACTION_SHUTDOWN"
                }));
            }
            if (com.exacttarget.etpushsdk.util.d.h())
            {
                obj = packagemanager.queryBroadcastReceivers(new Intent("android.intent.action.BOOT_COMPLETED"), 0);
                com.exacttarget.etpushsdk.util.m.a("~!ETPush", String.format("Looking for %s Intent Filter", new Object[] {
                    "android.intent.action.BOOT_COMPLETED"
                }));
                if (!a(((List) (obj)), com/exacttarget/etpushsdk/ETPushReceiver, s1))
                {
                    A();
                    throw new RuntimeException(String.format("%1$s definition in AndroidManifest.xml missing intent filter for %2$s", new Object[] {
                        com/exacttarget/etpushsdk/ETPushReceiver.getName(), "android.intent.action.BOOT_COMPLETED"
                    }));
                }
                obj = packagemanager.queryBroadcastReceivers(new Intent("android.intent.action.BATTERY_LOW"), 0);
                com.exacttarget.etpushsdk.util.m.a("~!ETPush", String.format("Looking for %s Intent Filter", new Object[] {
                    "android.intent.action.BATTERY_LOW"
                }));
                if (!a(((List) (obj)), com/exacttarget/etpushsdk/ETPushReceiver, s1))
                {
                    A();
                    throw new RuntimeException(String.format("%1$s definition in AndroidManifest.xml missing intent filter for %2$s", new Object[] {
                        com/exacttarget/etpushsdk/ETPushReceiver.getName(), "android.intent.action.BATTERY_LOW"
                    }));
                }
                obj = packagemanager.queryBroadcastReceivers(new Intent("android.intent.action.BATTERY_OKAY"), 0);
                com.exacttarget.etpushsdk.util.m.a("~!ETPush", String.format("Looking for %s Intent Filter", new Object[] {
                    "android.intent.action.BATTERY_OKAY"
                }));
                if (!a(((List) (obj)), com/exacttarget/etpushsdk/ETPushReceiver, s1))
                {
                    A();
                    throw new RuntimeException(String.format("%1$s definition in AndroidManifest.xml missing intent filter for %2$s", new Object[] {
                        com/exacttarget/etpushsdk/ETPushReceiver.getName(), "android.intent.action.BATTERY_OKAY"
                    }));
                }
            }
            obj = a().getPackageManager();
            obj1 = new ComponentName(a(), com/exacttarget/etpushsdk/ETLocationReceiver);
            if (com.exacttarget.etpushsdk.util.d.h() && ((PackageManager) (obj)).getComponentEnabledSetting(((ComponentName) (obj1))) == 0)
            {
                obj = packagemanager.queryBroadcastReceivers(new Intent(f, com/exacttarget/etpushsdk/ETLocationReceiver), 0);
                com.exacttarget.etpushsdk.util.m.a("~!ETPush", "Looking for instanceof ETLocationReceiver");
                if (!a(((List) (obj)), com/exacttarget/etpushsdk/ETLocationReceiver, s1))
                {
                    A();
                    throw new RuntimeException(String.format("%1$s definition in AndroidManifest.xml is missing.", new Object[] {
                        com/exacttarget/etpushsdk/ETLocationReceiver.getName()
                    }));
                }
                obj = new Intent("android.location.PROVIDERS_CHANGED");
                ((Intent) (obj)).addCategory("android.intent.category.DEFAULT");
                obj = packagemanager.queryBroadcastReceivers(((Intent) (obj)), 0);
                com.exacttarget.etpushsdk.util.m.a("~!ETPush", String.format("Looking for android.location.PROVIDERS_CHANGED Intent Filter w/Category %s", new Object[] {
                    "android.intent.category.DEFAULT"
                }));
                if (!a(((List) (obj)), com/exacttarget/etpushsdk/ETLocationReceiver, s1))
                {
                    A();
                    throw new RuntimeException(String.format("%1$s definition in AndroidManifest.xml missing intent filter for android.location.PROVIDERS_CHANGED with category %2$s", new Object[] {
                        com/exacttarget/etpushsdk/ETLocationReceiver.getName(), "android.intent.category.DEFAULT"
                    }));
                }
            }
            obj = new ArrayList();
            ((List) (obj)).add(com/exacttarget/etpushsdk/ETPushService);
            if (com.exacttarget.etpushsdk.util.d.h())
            {
                ((List) (obj)).add(com/exacttarget/etpushsdk/ETLocationService);
            }
            obj = ((List) (obj)).iterator();
label1:
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
                obj1 = (Class)((Iterator) (obj)).next();
                Object obj2 = packagemanager.queryIntentServices(new Intent(f, ((Class) (obj1))), 0);
                if (obj2 != null)
                {
                    obj2 = ((List) (obj2)).iterator();
                    boolean flag1 = false;
                    do
                    {
                        ResolveInfo resolveinfo1;
                        do
                        {
                            flag2 = flag1;
                            if (!((Iterator) (obj2)).hasNext())
                            {
                                continue label1;
                            }
                            resolveinfo1 = (ResolveInfo)((Iterator) (obj2)).next();
                        } while (resolveinfo1.serviceInfo == null || !resolveinfo1.serviceInfo.name.equals(((Class) (obj1)).getName()) || !resolveinfo1.serviceInfo.packageName.equals(s1));
                        flag1 = true;
                    } while (true);
                }
                flag2 = false;
            } while (flag2);
            A();
            throw new RuntimeException(String.format("ApplicationManifest.xml missing definition for service: %1$s", new Object[] {
                ((Class) (obj1)).getName()
            }));
        }
        if (!a(com/exacttarget/etpushsdk/ETLandingPagePresenter) && com.exacttarget.etpushsdk.util.d.j() && h() == null)
        {
            com.exacttarget.etpushsdk.util.m.c("~!ETPush", String.format("%s is not found in AndroidManifest.  This will impact the ability to display CloudPages without setting a class with setCloudPageRecipient(Class<?>). If you're setting this class after the call to readyAimFire() you can remove this warning by adding your class in the ETPushConfig.Builder() implementation of readyAimFire().", new Object[] {
                com/exacttarget/etpushsdk/ETLandingPagePresenter.getName()
            }));
        } else
        if (h() != null && !a(h()))
        {
            throw new RuntimeException(String.format("%s is not found in AndroidManifest.", new Object[] {
                h().getSimpleName()
            }));
        }
        if (!a(com/exacttarget/etpushsdk/ETLandingPagePresenter) && g() == null)
        {
            com.exacttarget.etpushsdk.util.m.c("~!ETPush", String.format("%s is not found in AndroidManifest.  This will impact the ability to display OpenDirect URLs without setting a class with setOpenDirectRecipient(Class<?>). If you're setting this class after the call to readyAimFire() you can remove this warning by adding your class in the ETPushConfig.Builder() implementation of readyAimFire().", new Object[] {
                com/exacttarget/etpushsdk/ETLandingPagePresenter.getName()
            }));
        } else
        if (g() != null && !a(g()))
        {
            throw new RuntimeException(String.format("%s is not found in AndroidManifest.", new Object[] {
                g().getSimpleName()
            }));
        }
        if (getNotificationRecipientClass() != null && !a(getNotificationRecipientClass()))
        {
            throw new RuntimeException(String.format("%s is not found in AndroidManifest.", new Object[] {
                getNotificationRecipientClass().getSimpleName()
            }));
        }
        if (getNotificationResourceId() != null && !a(getNotificationResourceId()))
        {
            throw new RuntimeException("Notification Icon is not found in Application Resources.");
        } else
        {
            return;
        }
    }

    private static boolean z()
    {
        return ((Boolean)com.exacttarget.etpushsdk.util.d.a(f, "et_push_enabled", Boolean.valueOf(true), new Object[] {
            f.getSharedPreferences("~!ETPush", 0)
        })).booleanValue();
    }

    protected void a(String s1)
    {
        if (!com.exacttarget.etpushsdk.util.d.a(f))
        {
            i.setSystemTokenInCache(s1);
            f();
        }
    }

    protected void a(String s1, int i1, int j1)
    {
        com.exacttarget.etpushsdk.util.m.a("~!ETPush", "showFenceOrProximityMessage()");
        if (!isPushEnabled())
        {
            com.exacttarget.etpushsdk.util.m.a("~!ETPush", "Push is disabled, no fence or proximity messages will show. Thanks for playing.");
            return;
        }
        if (ETLocationManager.getInstance().isWatchingLocation() || i1 != 1 && i1 != 2) goto _L2; else goto _L1
_L1:
        try
        {
            com.exacttarget.etpushsdk.util.m.a("~!ETPush", "Location is disabled, no fence messages will show. Thanks for playing.");
            return;
        }
        catch (ETException etexception)
        {
            com.exacttarget.etpushsdk.util.m.c("~!ETPush", etexception.getMessage(), etexception);
        }
_L10:
        Date date;
        Region region;
        ArrayList arraylist;
        Object obj;
        Object obj1;
        date = new Date();
        Iterator iterator;
        try
        {
            region = com.exacttarget.etpushsdk.database.g.a(s1);
            com.exacttarget.etpushsdk.util.m.a("~!ETPush", (new StringBuilder()).append("Geofence Region: ").append(region.getId()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.exacttarget.etpushsdk.util.m.c("~!ETPush", s1.getMessage(), s1);
            return;
        }
        i1;
        JVM INSTR tableswitch 1 2: default 2223
    //                   1 397
    //                   2 313;
           goto _L3 _L4 _L5
_L3:
        arraylist = new ArrayList();
        iterator = com.exacttarget.etpushsdk.database.f.a("region_id = ?", new String[] {
            s1
        }, null, null, null).iterator();
_L8:
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_2195;
            }
            obj1 = (RegionMessage)iterator.next();
            obj = com.exacttarget.etpushsdk.database.e.a(((RegionMessage) (obj1)).getMessage().getId());
        } while (obj == null);
        if (!Message.d.equals(((Message) (obj)).getMessageType()) || 2 != i1) goto _L7; else goto _L6
_L6:
        com.exacttarget.etpushsdk.util.m.a("~!ETPush", (new StringBuilder()).append("ignoring message ").append(((Message) (obj)).getId()).append(" because it's an entry and we were triggered by an exit").toString());
          goto _L8
_L2:
        if (ETLocationManager.getInstance().isWatchingProximity() || i1 == 1 || i1 == 2) goto _L10; else goto _L9
_L9:
        com.exacttarget.etpushsdk.util.m.a("~!ETPush", "Proximity is disabled, no beacon messages will show. Thanks for playing.");
        return;
_L5:
        region.setExitCount(Integer.valueOf(region.getExitCount().intValue() + 1));
        com.exacttarget.etpushsdk.database.g.c(region);
        com.exacttarget.etpushsdk.util.m.a("~!ETPush", (new StringBuilder()).append("GeofenceExitCount: ").append(region.getId()).append(": ").append(region.getExitCount()).toString());
        if (com.exacttarget.etpushsdk.util.d.f())
        {
            ETAnalytics.a().a(s1);
        }
          goto _L3
_L4:
        region.setEntryCount(Integer.valueOf(region.getEntryCount().intValue() + 1));
        com.exacttarget.etpushsdk.database.g.c(region);
        com.exacttarget.etpushsdk.util.m.a("~!ETPush", (new StringBuilder()).append("GeofenceEntryCount: ").append(region.getId()).append(": ").append(region.getEntryCount()).toString());
        if (com.exacttarget.etpushsdk.util.d.f())
        {
            ETAnalytics.a().a(s1, false);
        }
          goto _L3
_L7:
        if (!Message.e.equals(((Message) (obj)).getMessageType()) || 1 != i1)
        {
            break MISSING_BLOCK_LABEL_540;
        }
        com.exacttarget.etpushsdk.util.m.a("~!ETPush", (new StringBuilder()).append("ignoring message ").append(((Message) (obj)).getId()).append(" because it's an exit and we were triggered by an entry").toString());
          goto _L8
label0:
        {
            if (((Message) (obj)).getEndDate() == null || !((Message) (obj)).getEndDate().before(date))
            {
                break label0;
            }
            com.exacttarget.etpushsdk.util.m.a("~!ETPush", (new StringBuilder()).append("fence or proximity message ").append(((Message) (obj)).getId()).append(" has expired, deleting...").toString());
            com.exacttarget.etpushsdk.database.e.b(((Message) (obj)).getId());
            com.exacttarget.etpushsdk.database.f.a(((RegionMessage) (obj1)).getId().intValue());
        }
          goto _L8
label1:
        {
            if (((Message) (obj)).getStartDate() == null || !((Message) (obj)).getStartDate().after(date))
            {
                break label1;
            }
            com.exacttarget.etpushsdk.util.m.a("~!ETPush", (new StringBuilder()).append("fence or proximity message ").append(((Message) (obj)).getId()).append(" hasn't started yet: ").append(((Message) (obj)).getStartDate()).toString());
        }
          goto _L8
label2:
        {
            if (((Message) (obj)).getMessageLimit().intValue() <= -1 || ((Message) (obj)).getShowCount().intValue() < ((Message) (obj)).getMessageLimit().intValue())
            {
                break label2;
            }
            com.exacttarget.etpushsdk.util.m.a("~!ETPush", (new StringBuilder()).append("fence or proximity message ").append(((Message) (obj)).getId()).append(" hit its messageLimit, not showing.").toString());
        }
          goto _L8
label3:
        {
            if (((Message) (obj)).getMessagesPerPeriod().intValue() <= -1 || ((Message) (obj)).getPeriodShowCount().intValue() < ((Message) (obj)).getMessagesPerPeriod().intValue() || !((Message) (obj)).getNextAllowedShow().after(date))
            {
                break label3;
            }
            com.exacttarget.etpushsdk.util.m.a("~!ETPush", (new StringBuilder()).append("fence or proximity message ").append(((Message) (obj)).getId()).append(" hit its messagesPerPeriod Limit, not showing.").toString());
        }
          goto _L8
label4:
        {
            if (!((Message) (obj)).getNextAllowedShow().after(date))
            {
                break label4;
            }
            com.exacttarget.etpushsdk.util.m.a("~!ETPush", (new StringBuilder()).append("fence or proximity message ").append(((Message) (obj)).getId()).append(" hit before nextAllowedShow, not showing.").toString());
        }
          goto _L8
        if (2 != i1)
        {
            break MISSING_BLOCK_LABEL_957;
        }
        if (((Message) (obj)).getMinTripped().intValue() <= region.getExitCount().intValue())
        {
            break MISSING_BLOCK_LABEL_1015;
        }
        com.exacttarget.etpushsdk.util.m.a("~!ETPush", (new StringBuilder()).append("fence message ").append(((Message) (obj)).getId()).append(" hit before minTripped reached, not showing.").toString());
          goto _L8
        if (((Message) (obj)).getMinTripped().intValue() <= region.getEntryCount().intValue())
        {
            break MISSING_BLOCK_LABEL_1015;
        }
        com.exacttarget.etpushsdk.util.m.a("~!ETPush", (new StringBuilder()).append("fence or proximity message ").append(((Message) (obj)).getId()).append(" hit before minTripped reached, not showing.").toString());
          goto _L8
        if (!ETLocationManager.getInstance().isWatchingProximity() || i1 == 1 || i1 == 2)
        {
            break MISSING_BLOCK_LABEL_1137;
        }
        if (j1 == 0)
        {
            break MISSING_BLOCK_LABEL_1047;
        }
        if (j1 <= ((Message) (obj)).getProximity())
        {
            break MISSING_BLOCK_LABEL_1114;
        }
        com.exacttarget.etpushsdk.util.m.a("~!ETPush", (new StringBuilder()).append("Proximity was ").append(j1).append(", but message.proximity was ").append(((Message) (obj)).getProximity()).append(", not showing.").toString());
          goto _L8
        obj;
        com.exacttarget.etpushsdk.util.m.c("~!ETPush", ((ETException) (obj)).getMessage(), ((Throwable) (obj)));
          goto _L8
        if (!((Message) (obj)).getHasEntered().booleanValue())
        {
            break MISSING_BLOCK_LABEL_1137;
        }
        com.exacttarget.etpushsdk.util.m.a("~!ETPush", "We're still inside the region and have never left, not showing.");
          goto _L8
        ((Message) (obj)).setLastShownDate(date);
        ((Message) (obj)).setShowCount(Integer.valueOf(((Message) (obj)).getShowCount().intValue() + 1));
        if (((Message) (obj)).getMessagesPerPeriod().intValue() <= -1 || ((Message) (obj)).getNumberOfPeriods().intValue() <= -1 || ((Message) (obj)).getPeriodType().equals(Integer.valueOf(0))) goto _L12; else goto _L11
_L11:
        ((Message) (obj)).setPeriodShowCount(Integer.valueOf(((Message) (obj)).getPeriodShowCount().intValue() + 1));
        if (((Message) (obj)).getPeriodShowCount().intValue() < ((Message) (obj)).getMessagesPerPeriod().intValue()) goto _L12; else goto _L13
_L13:
        long l1 = 0L;
        ((Message) (obj)).getPeriodType().intValue();
        JVM INSTR tableswitch 1 5: default 2226
    //                   1 1593
    //                   2 1575
    //                   3 1557
    //                   4 1539
    //                   5 1521;
           goto _L14 _L15 _L16 _L17 _L18 _L19
_L14:
        ((Message) (obj)).setNextAllowedShow(new Date(l1 + date.getTime()));
        if (((Message) (obj)).getIsRollingPeriod().booleanValue()) goto _L12; else goto _L20
_L20:
        obj1 = Calendar.getInstance();
        ((Calendar) (obj1)).setTimeInMillis(((Message) (obj)).getNextAllowedShow().getTime());
        ((Calendar) (obj1)).set(14, 0);
        ((Calendar) (obj1)).set(13, 0);
        ((Message) (obj)).getPeriodType().intValue();
        JVM INSTR tableswitch 1 5: default 2229
    //                   1 1694
    //                   2 1668
    //                   3 1641
    //                   4 1622
    //                   5 1611;
           goto _L21 _L22 _L23 _L24 _L25 _L26
_L21:
        ((Message) (obj)).setNextAllowedShow(((Calendar) (obj1)).getTime());
_L12:
        if (((Message) (obj)).getPeriodShowCount().intValue() > -1 && ((Message) (obj)).getMessagesPerPeriod().intValue() > -1 && ((Message) (obj)).getPeriodShowCount().intValue() > ((Message) (obj)).getMessagesPerPeriod().intValue())
        {
            ((Message) (obj)).setPeriodShowCount(Integer.valueOf(0));
        }
        if (i1 == 1 || i1 == 2) goto _L28; else goto _L27
_L27:
        l1 = System.currentTimeMillis();
        if (((Message) (obj)).getLoiterSeconds().intValue() <= 0)
        {
            break MISSING_BLOCK_LABEL_2077;
        }
        if (((Message) (obj)).getEntryTime().longValue() != 0L) goto _L30; else goto _L29
_L29:
        ((Message) (obj)).setEntryTime(Long.valueOf(l1));
        com.exacttarget.etpushsdk.util.m.a("~!ETPush", "Entered, but loiteringTime has not yet triggered.");
        com.exacttarget.etpushsdk.database.e.c(((Message) (obj)));
          goto _L8
_L19:
        l1 = (long)((Message) (obj)).getNumberOfPeriods().intValue() * 0x36ee80L;
          goto _L14
_L18:
        l1 = (long)((Message) (obj)).getNumberOfPeriods().intValue() * 0x5265c00L;
          goto _L14
_L17:
        l1 = (long)((Message) (obj)).getNumberOfPeriods().intValue() * 0x240c8400L;
          goto _L14
_L16:
        l1 = (long)((Message) (obj)).getNumberOfPeriods().intValue() * 0x9a7ec800L;
          goto _L14
_L15:
        l1 = (long)((Message) (obj)).getNumberOfPeriods().intValue() * 0x757b12c00L;
          goto _L14
_L26:
        ((Calendar) (obj1)).set(12, 0);
          goto _L21
_L25:
        ((Calendar) (obj1)).set(10, 0);
        ((Calendar) (obj1)).set(12, 0);
          goto _L21
_L24:
        ((Calendar) (obj1)).set(7, 1);
        ((Calendar) (obj1)).set(10, 0);
        ((Calendar) (obj1)).set(12, 0);
          goto _L21
_L23:
        ((Calendar) (obj1)).set(5, 1);
        ((Calendar) (obj1)).set(10, 0);
        ((Calendar) (obj1)).set(12, 0);
          goto _L21
_L22:
        ((Calendar) (obj1)).set(2, 0);
        ((Calendar) (obj1)).set(5, 1);
        ((Calendar) (obj1)).set(10, 0);
        ((Calendar) (obj1)).set(12, 0);
          goto _L21
_L30:
        if (l1 <= ((Message) (obj)).getEntryTime().longValue() + (long)((Message) (obj)).getLoiterSeconds().intValue() * 1000L) goto _L32; else goto _L31
_L31:
        ((Message) (obj)).setHasEntered(Boolean.TRUE);
_L28:
        com.exacttarget.etpushsdk.database.e.c(((Message) (obj)));
        obj1 = new Intent("com.google.android.c2dm.intent.RECEIVE");
        ((Intent) (obj1)).addCategory(f.getPackageName());
        if (((Message) (obj)).getCategory() != null && ((Message) (obj)).getCategory().length() > 0)
        {
            ((Intent) (obj1)).putExtra("category", ((Message) (obj)).getCategory());
        }
        if (((Message) (obj)).getOpenDirect() != null && ((Message) (obj)).getOpenDirect().length() > 0)
        {
            ((Intent) (obj1)).putExtra("_od", ((Message) (obj)).getOpenDirect());
        }
        if (((Message) (obj)).getContentType() != null && Message.j.equals(((Message) (obj)).getContentType()) && ((Message) (obj)).getUrl() != null && ((Message) (obj)).getUrl().length() > 0)
        {
            ((Intent) (obj1)).putExtra("_x", ((Message) (obj)).getUrl());
        }
        ((Intent) (obj1)).putExtra("_m", ((Message) (obj)).getId());
        if (((Message) (obj)).getSubject() != null && ((Message) (obj)).getSubject().length() > -1)
        {
            ((Intent) (obj1)).putExtra("alert", ((Message) (obj)).getSubject());
        }
        if (((Message) (obj)).getSound() != null && ((Message) (obj)).getSound().length() > 0)
        {
            ((Intent) (obj1)).putExtra("sound", ((Message) (obj)).getSound());
        }
        if (((Message) (obj)).getKeys() != null && ((Message) (obj)).getKeys().size() > 0)
        {
            Attribute attribute;
            for (Iterator iterator1 = ((Message) (obj)).getKeys().iterator(); iterator1.hasNext(); ((Intent) (obj1)).putExtra(attribute.getKey(), attribute.getValue()))
            {
                attribute = (Attribute)iterator1.next();
            }

        }
        break MISSING_BLOCK_LABEL_2088;
_L32:
        com.exacttarget.etpushsdk.util.m.a("~!ETPush", "Entered, but loiteringTime has not yet triggered.");
          goto _L8
        ((Message) (obj)).setHasEntered(Boolean.TRUE);
          goto _L28
        if (((Message) (obj)).getCustom() != null && ((Message) (obj)).getCustom().length() > 0)
        {
            ((Intent) (obj1)).putExtra("custom", ((Message) (obj)).getCustom());
        }
        ((Intent) (obj1)).putExtra("transitionType", i1);
        ((Intent) (obj1)).putExtra("regionId", s1);
        arraylist.add(((Message) (obj)).getId());
        com.exacttarget.etpushsdk.util.m.a("~!ETPush", (new StringBuilder()).append("Sending broadcast Intent to display fence/proximity message: ").append(((Message) (obj)).getId()).toString());
        f.sendBroadcast(((Intent) (obj1)));
          goto _L8
        if (com.exacttarget.etpushsdk.util.d.f() && arraylist.size() > 0)
        {
            ETAnalytics.a().a(s1, i1, j1, arraylist);
        }
        return;
          goto _L3
    }

    public void addAttribute(String s1, String s2)
    {
        if (!com.exacttarget.etpushsdk.util.d.a(f))
        {
            i.addAttribute(new Attribute(s1, s2));
            f();
        }
    }

    public void addTag(String s1)
    {
        if (!com.exacttarget.etpushsdk.util.d.a(f))
        {
            i.addTag(s1);
            f();
        }
    }

    public void disablePush()
    {
        this;
        JVM INSTR monitorenter ;
        if (com.exacttarget.etpushsdk.util.d.a(f))
        {
            break MISSING_BLOCK_LABEL_86;
        }
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        Thread thread;
        h = Boolean.valueOf(false);
        i.setPushEnabled(Boolean.valueOf(false));
        thread = new Thread(new q(this));
        if (d.getCount() != 0L)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        com.exacttarget.etpushsdk.util.m.a("~!ETPush", "enablePushThread is not running.  So continue with disabling push.");
        d = new CountDownLatch(1);
        thread.start();
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        (new Thread(new r(this, thread))).start();
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception1;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void enablePush()
    {
        this;
        JVM INSTR monitorenter ;
        if (com.exacttarget.etpushsdk.util.d.a(f))
        {
            break MISSING_BLOCK_LABEL_86;
        }
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        Thread thread;
        h = Boolean.valueOf(true);
        i.setPushEnabled(Boolean.valueOf(true));
        thread = new Thread(new z(this));
        if (d.getCount() != 0L)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        com.exacttarget.etpushsdk.util.m.a("~!ETPush", "disablePushThread is not running.  So continue with enabling push.");
        d = new CountDownLatch(1);
        thread.start();
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        (new Thread(new p(this, thread))).start();
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception1;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public ArrayList getAttributes()
    {
        return i.getAttributes();
    }

    public Class getCloudPageRecipient()
    {
        return q;
    }

    public String getNotificationAction()
    {
        return r;
    }

    public Uri getNotificationActionUri()
    {
        return s;
    }

    public Class getOpenDirectRecipient()
    {
        return p;
    }

    public String getSystemToken()
    {
        return i.getSystemTokenFromCache();
    }

    public TreeSet getTags()
    {
        return i.getTags();
    }

    protected void i()
    {
        if (com.exacttarget.etpushsdk.util.b.a(f))
        {
            E();
            return;
        }
        if (com.exacttarget.etpushsdk.util.j.a(f))
        {
            B();
            return;
        } else
        {
            A();
            throw new ETException("Unable to continue.  Neither Google Services nor Amazon Device Messaging is available");
        }
    }

    public boolean isPushEnabled()
    {
        try
        {
            c();
            if (h == null)
            {
                h = Boolean.valueOf(z());
            }
        }
        catch (ETException etexception)
        {
            com.exacttarget.etpushsdk.util.m.c("~!ETPush", etexception.getMessage(), etexception);
            h = Boolean.valueOf(false);
        }
        return h.booleanValue();
    }

    protected boolean j()
    {
        return com.exacttarget.etpushsdk.util.j.a(f) || com.exacttarget.etpushsdk.util.b.a(f);
    }

    public void onEvent(RegistrationEvent registrationevent)
    {
        com.exacttarget.etpushsdk.util.m.a("~!ETPush", String.format("onEvent(final RegistrationEvent event){ event.getId(); } // ID = %d", new Object[] {
            registrationevent.getId()
        }));
        if (registrationevent.getId() == null || registrationevent.getId().intValue() <= 0)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        int i1 = com.exacttarget.etpushsdk.database.h.a("id <= ?", new String[] {
            String.valueOf(registrationevent.getId())
        });
        if (i1 >= 1)
        {
            try
            {
                com.exacttarget.etpushsdk.util.m.a("~!ETPush", (new StringBuilder()).append("success, removed sent registration id from db: ").append(registrationevent.getId()).toString());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (RegistrationEvent registrationevent)
            {
                com.exacttarget.etpushsdk.util.m.c("~!ETPush", registrationevent.getMessage(), registrationevent);
            }
            break MISSING_BLOCK_LABEL_135;
        }
        com.exacttarget.etpushsdk.util.m.d("~!ETPush", (new StringBuilder()).append("Error: rowsUpdated = ").append(i1).toString());
        return;
    }

    public void removeAttribute(String s1)
    {
        if (!com.exacttarget.etpushsdk.util.d.a(f))
        {
            i.removeAttribute(new Attribute(s1, ""));
            f();
        }
    }

    public void removeTag(String s1)
    {
        if (!com.exacttarget.etpushsdk.util.d.a(f))
        {
            i.removeTag(s1);
            f();
        }
    }

    public void setCloudPageRecipient(Class class1)
    {
        c(class1, true);
    }

    public void setNotificationAction(String s1)
    {
        a(s1, true);
    }

    public void setNotificationActionUri(Uri uri)
    {
        a(uri, true);
    }

    public void setNotificationRecipientClass(Class class1)
    {
        a(class1, true);
    }

    public void setNotificationResourceId(Integer integer)
    {
        a(integer, true);
    }

    public void setOpenDirectRecipient(Class class1)
    {
        b(class1, true);
    }

    public void setSubscriberKey(String s1)
    {
        if (!com.exacttarget.etpushsdk.util.d.a(f))
        {
            i.setSubscriberKey(s1);
            f();
        }
    }


    private class a
    {

        private boolean a;
        private CountDownLatch b;

        public void a()
        {
            a = true;
            b.countDown();
        }

        public boolean a(long l1, TimeUnit timeunit)
        {
            boolean flag;
            try
            {
                flag = b.await(l1, timeunit);
            }
            // Misplaced declaration of an exception variable
            catch (TimeUnit timeunit)
            {
                com.exacttarget.etpushsdk.util.m.c("~!ETPush", timeunit.getMessage(), timeunit);
                throw new ETException(String.format("Exception in latch.await: %1$s", new Object[] {
                    timeunit.getMessage()
                }));
            }
            if (a)
            {
                if (ETPush.w() != null)
                {
                    ETPush.w().interrupt();
                }
                throw new ETException("Aborting readyAimFire() due to Exception in initialization.  See logcat for more information.");
            } else
            {
                return flag;
            }
        }

        public boolean b()
        {
            return a;
        }

        public void c()
        {
            b.countDown();
        }

        public long d()
        {
            return b.getCount();
        }

        public a(int i1)
        {
            b = new CountDownLatch(i1);
        }
    }

}
