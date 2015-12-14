// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.location.Criteria;
import com.flurry.sdk.bx;
import com.flurry.sdk.eg;
import com.flurry.sdk.eh;
import com.flurry.sdk.ei;
import com.flurry.sdk.ex;
import com.flurry.sdk.ey;
import com.flurry.sdk.fh;
import java.util.Date;
import java.util.Map;

public final class FlurryAgent
{

    private static final String a = com/flurry/android/FlurryAgent.getSimpleName();

    private FlurryAgent()
    {
    }

    public static void endTimedEvent(String s)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            ex.b(a, "Device SDK Version older than 10");
            return;
        }
        if (s == null)
        {
            ex.b(a, "String eventId passed to endTimedEvent was null.");
            return;
        }
        try
        {
            bx.a().b(s);
            return;
        }
        catch (Throwable throwable)
        {
            ex.b(a, (new StringBuilder()).append("Failed to signify the end of event: ").append(s).toString(), throwable);
        }
    }

    public static void endTimedEvent(String s, Map map)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            ex.b(a, "Device SDK Version older than 10");
            return;
        }
        if (s == null)
        {
            ex.b(a, "String eventId passed to endTimedEvent was null.");
            return;
        }
        if (map == null)
        {
            ex.b(a, "String eventId passed to endTimedEvent was null.");
            return;
        }
        try
        {
            bx.a().b(s, map);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            ex.b(a, (new StringBuilder()).append("Failed to signify the end of event: ").append(s).toString(), map);
        }
    }

    public static int getAgentVersion()
    {
        return bx.a().b();
    }

    public static String getReleaseVersion()
    {
        return bx.a().g();
    }

    public static boolean getUseHttps()
    {
        return ((Boolean)eh.a().a("UseHttps")).booleanValue();
    }

    public static void logEvent(String s)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            ex.b(a, "Device SDK Version older than 10");
            return;
        }
        if (s == null)
        {
            ex.b(a, "String eventId passed to logEvent was null.");
            return;
        }
        try
        {
            bx.a().a(s);
            return;
        }
        catch (Throwable throwable)
        {
            ex.b(a, (new StringBuilder()).append("Failed to log event: ").append(s).toString(), throwable);
        }
    }

    public static void logEvent(String s, Map map)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            ex.b(a, "Device SDK Version older than 10");
            return;
        }
        if (s == null)
        {
            ex.b(a, "String eventId passed to logEvent was null.");
            return;
        }
        if (map == null)
        {
            ex.b(a, "String parameters passed to logEvent was null.");
            return;
        }
        try
        {
            bx.a().a(s, map);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            ex.b(a, (new StringBuilder()).append("Failed to log event: ").append(s).toString(), map);
        }
    }

    public static void logEvent(String s, Map map, boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            ex.b(a, "Device SDK Version older than 10");
            return;
        }
        if (s == null)
        {
            ex.b(a, "String eventId passed to logEvent was null.");
            return;
        }
        if (map == null)
        {
            ex.b(a, "String parameters passed to logEvent was null.");
            return;
        }
        try
        {
            bx.a().a(s, map, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            ex.b(a, (new StringBuilder()).append("Failed to log event: ").append(s).toString(), map);
        }
    }

    public static void logEvent(String s, boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            ex.b(a, "Device SDK Version older than 10");
            return;
        }
        if (s == null)
        {
            ex.b(a, "String eventId passed to logEvent was null.");
            return;
        }
        try
        {
            bx.a().a(s, flag);
            return;
        }
        catch (Throwable throwable)
        {
            ex.b(a, (new StringBuilder()).append("Failed to log event: ").append(s).toString(), throwable);
        }
    }

    public static void onEndSession(Context context)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            ex.b(a, "Device SDK Version older than 10");
            return;
        }
        if (context == null)
        {
            throw new NullPointerException("Null context");
        }
        ey.a().g(context);
        try
        {
            bx.a().a(context);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            ex.b(a, "", context);
        }
    }

    public static void onError(String s, String s1, String s2)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            ex.b(a, "Device SDK Version older than 10");
            return;
        }
        if (s == null)
        {
            ex.b(a, "String errorId passed to onError was null.");
            return;
        }
        if (s1 == null)
        {
            ex.b(a, "String message passed to onError was null.");
            return;
        }
        if (s2 == null)
        {
            ex.b(a, "String errorClass passed to onError was null.");
            return;
        }
        try
        {
            bx.a().a(s, s1, s2);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ex.b(a, "", s);
        }
    }

    public static void onError(String s, String s1, Throwable throwable)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            ex.b(a, "Device SDK Version older than 10");
            return;
        }
        if (s == null)
        {
            ex.b(a, "String errorId passed to onError was null.");
            return;
        }
        if (s1 == null)
        {
            ex.b(a, "String message passed to onError was null.");
            return;
        }
        if (throwable == null)
        {
            ex.b(a, "Throwable passed to onError was null.");
            return;
        }
        try
        {
            bx.a().a(s, s1, throwable);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ex.b(a, "", s);
        }
    }

    public static void onEvent(String s)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            ex.b(a, "Device SDK Version older than 10");
            return;
        }
        if (s == null)
        {
            ex.b(a, "String eventId passed to onEvent was null.");
            return;
        }
        try
        {
            bx.a().c(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ex.b(a, "", s);
        }
    }

    public static void onEvent(String s, Map map)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            ex.b(a, "Device SDK Version older than 10");
            return;
        }
        if (s == null)
        {
            ex.b(a, "String eventId passed to onEvent was null.");
            return;
        }
        if (map == null)
        {
            ex.b(a, "Parameters Map passed to onEvent was null.");
            return;
        }
        try
        {
            bx.a().c(s, map);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ex.b(a, "", s);
        }
    }

    public static void onPageView()
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            ex.b(a, "Device SDK Version older than 10");
            return;
        }
        try
        {
            bx.a().i();
            return;
        }
        catch (Throwable throwable)
        {
            ex.b(a, "", throwable);
        }
    }

    public static void onStartSession(Context context, String s)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            ex.b(a, "Device SDK Version older than 10");
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
        eg.a(context);
        try
        {
            bx.a().a(context, s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ex.b(a, "", s);
        }
        ey.a().f(context);
    }

    public static void setAge(int i)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            ex.b(a, "Device SDK Version older than 10");
        } else
        if (i > 0 && i < 110)
        {
            long l = (new Date((new Date(System.currentTimeMillis() - (long)i * 0x7528ad000L)).getYear(), 1, 1)).getTime();
            eh.a().a("Age", Long.valueOf(l));
            return;
        }
    }

    public static void setCaptureUncaughtExceptions(boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            ex.b(a, "Device SDK Version older than 10");
            return;
        } else
        {
            eh.a().a("CaptureUncaughtExceptions", Boolean.valueOf(flag));
            return;
        }
    }

    public static void setContinueSessionMillis(long l)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            ex.b(a, "Device SDK Version older than 10");
            return;
        }
        if (l < 5000L)
        {
            ex.b(a, (new StringBuilder()).append("Invalid time set for session resumption: ").append(l).toString());
            return;
        } else
        {
            eh.a().a("ContinueSessionMillis", Long.valueOf(l));
            return;
        }
    }

    public static void setGender(byte byte0)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            ex.b(a, "Device SDK Version older than 10");
            return;
        }
        switch (byte0)
        {
        default:
            eh.a().a("Gender", Byte.valueOf((byte)-1));
            return;

        case 0: // '\0'
        case 1: // '\001'
            eh.a().a("Gender", Byte.valueOf(byte0));
            break;
        }
    }

    static void setInternalLoggingEnabled(boolean flag)
    {
        bx.a().a(flag);
    }

    public static void setLocationCriteria(Criteria criteria)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            ex.b(a, "Device SDK Version older than 10");
            return;
        } else
        {
            eh.a().a("LocationCriteria", criteria);
            return;
        }
    }

    public static void setLogEnabled(boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            ex.b(a, "Device SDK Version older than 10");
            return;
        }
        if (flag)
        {
            ex.b();
            return;
        } else
        {
            ex.a();
            return;
        }
    }

    public static void setLogEvents(boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            ex.b(a, "Device SDK Version older than 10");
            return;
        } else
        {
            eh.a().a("LogEvents", Boolean.valueOf(flag));
            return;
        }
    }

    public static void setLogLevel(int i)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            ex.b(a, "Device SDK Version older than 10");
            return;
        } else
        {
            ex.a(i);
            return;
        }
    }

    public static void setReportLocation(boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            ex.b(a, "Device SDK Version older than 10");
            return;
        } else
        {
            eh.a().a("ReportLocation", Boolean.valueOf(flag));
            return;
        }
    }

    public static void setReportUrl(String s)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            ex.b(a, "Device SDK Version older than 10");
            return;
        } else
        {
            eh.a().a("ReportUrl", s);
            return;
        }
    }

    public static void setUseHttps(boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            ex.b(a, "Device SDK Version older than 10");
            return;
        } else
        {
            eh.a().a("UseHttps", Boolean.valueOf(flag));
            return;
        }
    }

    public static void setUserId(String s)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            ex.b(a, "Device SDK Version older than 10");
            return;
        }
        if (s == null)
        {
            ex.b(a, "String userId passed to setUserId was null.");
            return;
        } else
        {
            eh.a().a("UserId", fh.a(s));
            return;
        }
    }

    public static void setVersionName(String s)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            ex.b(a, "Device SDK Version older than 10");
            return;
        }
        if (s == null)
        {
            ex.b(a, "String versionName passed to setVersionName was null.");
            return;
        } else
        {
            eh.a().a("VesionName", s);
            return;
        }
    }

}
