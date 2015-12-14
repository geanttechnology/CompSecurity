// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.text.TextUtils;
import com.flurry.sdk.hl;
import com.flurry.sdk.je;
import com.flurry.sdk.js;
import com.flurry.sdk.jt;
import com.flurry.sdk.ju;
import com.flurry.sdk.ka;
import com.flurry.sdk.kb;
import com.flurry.sdk.kc;
import com.flurry.sdk.kg;
import com.flurry.sdk.lg;
import com.flurry.sdk.lh;
import com.flurry.sdk.lk;
import com.flurry.sdk.lt;
import com.flurry.sdk.md;
import java.util.Date;
import java.util.Map;

// Referenced classes of package com.flurry.android:
//            FlurryEventRecordStatus, FlurrySyndicationEventName, FlurryAgentListener

public final class FlurryAgent
{

    private static final String a = com/flurry/android/FlurryAgent.getSimpleName();
    private static FlurryAgentListener b;
    private static final kb c = new kb() {

        public volatile void a(ka ka)
        {
            a((lg)ka);
        }

        public void a(lg lg1)
        {
            js.a().a(new Runnable(this, lg1) {

                final lg a;
                final _cls1 b;

                public void run()
                {
                    class _cls2
                    {

                        static final int a[];

                        static 
                        {
                            a = new int[com.flurry.sdk.lg.a.values().length];
                            try
                            {
                                a[com.flurry.sdk.lg.a.b.ordinal()] = 1;
                            }
                            catch (NoSuchFieldError nosuchfielderror) { }
                        }
                    }

                    _cls2.a[a.c.ordinal()];
                    JVM INSTR tableswitch 1 1: default 32
                //                               1 33;
                       goto _L1 _L2
_L1:
                    return;
_L2:
                    if (FlurryAgent.a() != null)
                    {
                        FlurryAgent.a().onSessionStarted();
                        return;
                    }
                    if (true) goto _L1; else goto _L3
_L3:
                }

            
            {
                b = _pcls1;
                a = lg1;
                super();
            }
            });
        }

    };

    private FlurryAgent()
    {
    }

    static FlurryAgentListener a()
    {
        return b;
    }

    public static void addOrigin(String s, String s1)
    {
        addOrigin(s, s1, null);
    }

    public static void addOrigin(String s, String s1, Map map)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return;
        }
        if (s == null || s.length() == 0)
        {
            throw new IllegalArgumentException("originName not specified");
        }
        if (s1 == null || s1.length() == 0)
        {
            throw new IllegalArgumentException("originVersion not specified");
        }
        try
        {
            ju.a().a(s, s1, map);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            kg.a(a, "", s);
        }
    }

    public static void addSessionProperty(String s, String s1)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return;
        }
        if (TextUtils.isEmpty(s) || TextUtils.isEmpty(s1))
        {
            kg.b(a, "String name or value passed to addSessionProperty was null or empty.");
            return;
        } else
        {
            je.a().a(s, s1);
            return;
        }
    }

    public static void clearLocation()
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return;
        } else
        {
            lk.a().a("ExplicitLocation", null);
            return;
        }
    }

    public static void endTimedEvent(String s)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return;
        }
        if (s == null)
        {
            kg.b(a, "String eventId passed to endTimedEvent was null.");
            return;
        }
        try
        {
            hl.a().b(s);
            return;
        }
        catch (Throwable throwable)
        {
            kg.a(a, (new StringBuilder()).append("Failed to signify the end of event: ").append(s).toString(), throwable);
        }
    }

    public static void endTimedEvent(String s, Map map)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return;
        }
        if (s == null)
        {
            kg.b(a, "String eventId passed to endTimedEvent was null.");
            return;
        }
        if (map == null)
        {
            kg.b(a, "String eventId passed to endTimedEvent was null.");
            return;
        }
        try
        {
            hl.a().b(s, map);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            kg.a(a, (new StringBuilder()).append("Failed to signify the end of event: ").append(s).toString(), map);
        }
    }

    public static int getAgentVersion()
    {
        return jt.a();
    }

    public static String getReleaseVersion()
    {
        return jt.f();
    }

    public static String getSessionId()
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return null;
        }
        String s;
        try
        {
            s = je.a().c();
        }
        catch (Throwable throwable)
        {
            kg.a(a, "", throwable);
            return null;
        }
        return s;
    }

    public static void init(Context context, String s)
    {
        com/flurry/android/FlurryAgent;
        JVM INSTR monitorenter ;
        if (android.os.Build.VERSION.SDK_INT >= 10) goto _L2; else goto _L1
_L1:
        kg.b(a, "Device SDK Version older than 10");
_L3:
        com/flurry/android/FlurryAgent;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        throw new NullPointerException("Null context");
        context;
        com/flurry/android/FlurryAgent;
        JVM INSTR monitorexit ;
        throw context;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        if (s.length() != 0)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        throw new IllegalArgumentException("apiKey not specified");
        md.a();
        js.a(context, s);
          goto _L3
        context;
        kg.a(a, "", context);
          goto _L3
    }

    public static boolean isSessionActive()
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return false;
        }
        boolean flag;
        try
        {
            flag = lh.a().f();
        }
        catch (Throwable throwable)
        {
            kg.a(a, "", throwable);
            return false;
        }
        return flag;
    }

    public static FlurryEventRecordStatus logEvent(FlurrySyndicationEventName flurrysyndicationeventname, String s, Map map)
    {
        FlurryEventRecordStatus flurryeventrecordstatus = FlurryEventRecordStatus.kFlurryEventFailed;
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return flurryeventrecordstatus;
        }
        if (flurrysyndicationeventname == null)
        {
            kg.b(a, "String eventName passed to logEvent was null.");
            return flurryeventrecordstatus;
        }
        if (TextUtils.isEmpty(s))
        {
            kg.b(a, "String syndicationId passed to logEvent was null or empty.");
            return flurryeventrecordstatus;
        }
        if (map == null)
        {
            kg.b(a, "String parameters passed to logEvent was null.");
            return flurryeventrecordstatus;
        }
        try
        {
            s = hl.a().a(flurrysyndicationeventname.toString(), s, map);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            kg.a(a, (new StringBuilder()).append("Failed to log event: ").append(flurrysyndicationeventname.toString()).toString(), s);
            return flurryeventrecordstatus;
        }
        return s;
    }

    public static FlurryEventRecordStatus logEvent(String s)
    {
        FlurryEventRecordStatus flurryeventrecordstatus = FlurryEventRecordStatus.kFlurryEventFailed;
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return flurryeventrecordstatus;
        }
        if (s == null)
        {
            kg.b(a, "String eventId passed to logEvent was null.");
            return flurryeventrecordstatus;
        }
        FlurryEventRecordStatus flurryeventrecordstatus1;
        try
        {
            flurryeventrecordstatus1 = hl.a().a(s);
        }
        catch (Throwable throwable)
        {
            kg.a(a, (new StringBuilder()).append("Failed to log event: ").append(s).toString(), throwable);
            return flurryeventrecordstatus;
        }
        return flurryeventrecordstatus1;
    }

    public static FlurryEventRecordStatus logEvent(String s, Map map)
    {
        FlurryEventRecordStatus flurryeventrecordstatus = FlurryEventRecordStatus.kFlurryEventFailed;
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return flurryeventrecordstatus;
        }
        if (s == null)
        {
            kg.b(a, "String eventId passed to logEvent was null.");
            return flurryeventrecordstatus;
        }
        if (map == null)
        {
            kg.b(a, "String parameters passed to logEvent was null.");
            return flurryeventrecordstatus;
        }
        try
        {
            map = hl.a().a(s, map);
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            kg.a(a, (new StringBuilder()).append("Failed to log event: ").append(s).toString(), map);
            return flurryeventrecordstatus;
        }
        return map;
    }

    public static FlurryEventRecordStatus logEvent(String s, Map map, boolean flag)
    {
        FlurryEventRecordStatus flurryeventrecordstatus = FlurryEventRecordStatus.kFlurryEventFailed;
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return flurryeventrecordstatus;
        }
        if (s == null)
        {
            kg.b(a, "String eventId passed to logEvent was null.");
            return flurryeventrecordstatus;
        }
        if (map == null)
        {
            kg.b(a, "String parameters passed to logEvent was null.");
            return flurryeventrecordstatus;
        }
        try
        {
            map = hl.a().a(s, map, flag);
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            kg.a(a, (new StringBuilder()).append("Failed to log event: ").append(s).toString(), map);
            return flurryeventrecordstatus;
        }
        return map;
    }

    public static FlurryEventRecordStatus logEvent(String s, boolean flag)
    {
        FlurryEventRecordStatus flurryeventrecordstatus = FlurryEventRecordStatus.kFlurryEventFailed;
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return flurryeventrecordstatus;
        }
        if (s == null)
        {
            kg.b(a, "String eventId passed to logEvent was null.");
            return flurryeventrecordstatus;
        }
        FlurryEventRecordStatus flurryeventrecordstatus1;
        try
        {
            flurryeventrecordstatus1 = hl.a().a(s, flag);
        }
        catch (Throwable throwable)
        {
            kg.a(a, (new StringBuilder()).append("Failed to log event: ").append(s).toString(), throwable);
            return flurryeventrecordstatus;
        }
        return flurryeventrecordstatus1;
    }

    public static void onEndSession(Context context)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return;
        }
        if (context == null)
        {
            throw new NullPointerException("Null context");
        }
        if (js.a() == null)
        {
            throw new IllegalStateException("Flurry SDK must be initialized before ending a session");
        }
        try
        {
            lh.a().c(context);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            kg.a(a, "", context);
        }
    }

    public static void onError(String s, String s1, String s2)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return;
        }
        if (s == null)
        {
            kg.b(a, "String errorId passed to onError was null.");
            return;
        }
        if (s1 == null)
        {
            kg.b(a, "String message passed to onError was null.");
            return;
        }
        if (s2 == null)
        {
            kg.b(a, "String errorClass passed to onError was null.");
            return;
        }
        try
        {
            hl.a().a(s, s1, s2);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            kg.a(a, "", s);
        }
    }

    public static void onError(String s, String s1, Throwable throwable)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return;
        }
        if (s == null)
        {
            kg.b(a, "String errorId passed to onError was null.");
            return;
        }
        if (s1 == null)
        {
            kg.b(a, "String message passed to onError was null.");
            return;
        }
        if (throwable == null)
        {
            kg.b(a, "Throwable passed to onError was null.");
            return;
        }
        try
        {
            hl.a().a(s, s1, throwable);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            kg.a(a, "", s);
        }
    }

    public static void onEvent(String s)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return;
        }
        if (s == null)
        {
            kg.b(a, "String eventId passed to onEvent was null.");
            return;
        }
        try
        {
            hl.a().c(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            kg.a(a, "", s);
        }
    }

    public static void onEvent(String s, Map map)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return;
        }
        if (s == null)
        {
            kg.b(a, "String eventId passed to onEvent was null.");
            return;
        }
        if (map == null)
        {
            kg.b(a, "Parameters Map passed to onEvent was null.");
            return;
        }
        try
        {
            hl.a().c(s, map);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            kg.a(a, "", s);
        }
    }

    public static void onPageView()
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return;
        }
        try
        {
            hl.a().g();
            return;
        }
        catch (Throwable throwable)
        {
            kg.a(a, "", throwable);
        }
    }

    public static void onStartSession(Context context)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return;
        }
        if (context == null)
        {
            throw new NullPointerException("Null context");
        }
        if (js.a() == null)
        {
            throw new IllegalStateException("Flurry SDK must be initialized before starting a session");
        }
        try
        {
            lh.a().b(context);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            kg.a(a, "", context);
        }
    }

    public static void onStartSession(Context context, String s)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return;
        }
        if (context == null)
        {
            throw new NullPointerException("Null context");
        }
        if (s == null || s.length() == 0)
        {
            throw new IllegalArgumentException("Api key not specified");
        }
        if (js.a() == null)
        {
            throw new IllegalStateException("Flurry SDK must be initialized before starting a session");
        }
        try
        {
            lh.a().b(context);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            kg.a(a, "", context);
        }
    }

    public static void setAge(int i)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
        } else
        if (i > 0 && i < 110)
        {
            long l = (new Date((new Date(System.currentTimeMillis() - (long)i * 0x7528ad000L)).getYear(), 1, 1)).getTime();
            lk.a().a("Age", Long.valueOf(l));
            return;
        }
    }

    public static void setCaptureUncaughtExceptions(boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return;
        } else
        {
            lk.a().a("CaptureUncaughtExceptions", Boolean.valueOf(flag));
            return;
        }
    }

    public static void setContinueSessionMillis(long l)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return;
        }
        if (l < 5000L)
        {
            kg.b(a, (new StringBuilder()).append("Invalid time set for session resumption: ").append(l).toString());
            return;
        } else
        {
            lk.a().a("ContinueSessionMillis", Long.valueOf(l));
            return;
        }
    }

    public static void setFlurryAgentListener(FlurryAgentListener flurryagentlistener)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return;
        }
        if (flurryagentlistener == null)
        {
            kg.b(a, "Listener cannot be null");
            kc.a().b("com.flurry.android.sdk.FlurrySessionEvent", c);
            return;
        } else
        {
            b = flurryagentlistener;
            kc.a().a("com.flurry.android.sdk.FlurrySessionEvent", c);
            return;
        }
    }

    public static void setGender(byte byte0)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return;
        }
        switch (byte0)
        {
        default:
            lk.a().a("Gender", Byte.valueOf((byte)-1));
            return;

        case 0: // '\0'
        case 1: // '\001'
            lk.a().a("Gender", Byte.valueOf(byte0));
            break;
        }
    }

    public static void setLocation(float f, float f1)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return;
        } else
        {
            Location location = new Location("Explicit");
            location.setLatitude(f);
            location.setLongitude(f1);
            lk.a().a("ExplicitLocation", location);
            return;
        }
    }

    public static void setLocationCriteria(Criteria criteria)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
        }
    }

    public static void setLogEnabled(boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return;
        }
        if (flag)
        {
            kg.b();
            return;
        } else
        {
            kg.a();
            return;
        }
    }

    public static void setLogEvents(boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return;
        } else
        {
            lk.a().a("LogEvents", Boolean.valueOf(flag));
            return;
        }
    }

    public static void setLogLevel(int i)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return;
        } else
        {
            kg.a(i);
            return;
        }
    }

    public static void setPulseEnabled(boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
        } else
        {
            lk.a().a("ProtonEnabled", Boolean.valueOf(flag));
            if (!flag)
            {
                lk.a().a("analyticsEnabled", Boolean.valueOf(true));
                return;
            }
        }
    }

    public static void setReportLocation(boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return;
        } else
        {
            lk.a().a("ReportLocation", Boolean.valueOf(flag));
            return;
        }
    }

    public static void setSessionOrigin(String s, String s1)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return;
        }
        if (TextUtils.isEmpty(s))
        {
            kg.b(a, "String originName passed to setSessionOrigin was null or empty.");
            return;
        } else
        {
            je.a().a(s);
            je.a().b(s1);
            return;
        }
    }

    public static void setUserId(String s)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return;
        }
        if (s == null)
        {
            kg.b(a, "String userId passed to setUserId was null.");
            return;
        } else
        {
            lk.a().a("UserId", lt.b(s));
            return;
        }
    }

    public static void setVersionName(String s)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return;
        }
        if (s == null)
        {
            kg.b(a, "String versionName passed to setVersionName was null.");
            return;
        } else
        {
            lk.a().a("VersionName", s);
            return;
        }
    }

}
