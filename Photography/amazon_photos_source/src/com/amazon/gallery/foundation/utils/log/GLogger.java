// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.log;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

// Referenced classes of package com.amazon.gallery.foundation.utils.log:
//            LogOverrider

public class GLogger
{

    private static final LogManager logManager = LogManager.getLogManager();
    private static LogOverrider logOverride = null;
    private static final ConcurrentMap tagMap = new ConcurrentHashMap();
    private static final ThreadLocal time = new ThreadLocal();

    public static transient void d(String s, String s1, Object aobj[])
    {
        if (getStoredLogger(s).isLoggable(Level.FINE))
        {
            Log.d(getPrefixedTag(s), getMessage(s1, aobj));
        }
    }

    public static void dx(String s, String s1, Throwable throwable)
    {
        if (getStoredLogger(s).isLoggable(Level.FINE))
        {
            Log.d(getPrefixedTag(s), s1, throwable);
        }
    }

    public static transient void e(String s, String s1, Object aobj[])
    {
        if (getStoredLogger(s).isLoggable(Level.SEVERE))
        {
            Log.e(getPrefixedTag(s), getMessage(s1, aobj));
        }
    }

    public static transient void errorStackTrace(String s, String s1, Object aobj[])
    {
        e(s, stackTraceHelper(2, s1, aobj).toString(), new Object[0]);
    }

    public static void ex(String s, String s1, Throwable throwable)
    {
        if (getStoredLogger(s).isLoggable(Level.SEVERE))
        {
            Log.e(getPrefixedTag(s), s1, throwable);
        }
    }

    public static transient void exf(String s, Throwable throwable, String s1, Object aobj[])
    {
        if (getStoredLogger(s).isLoggable(Level.SEVERE))
        {
            Log.e(getPrefixedTag(s), getMessage(s1, aobj), throwable);
        }
    }

    private static transient String getMessage(String s, Object aobj[])
    {
        String s1;
        if (s == null)
        {
            s1 = "<null>";
        } else
        {
            s1 = s;
            if (aobj.length > 0)
            {
                return String.format(s, aobj);
            }
        }
        return s1;
    }

    private static String getPrefixedTag(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "<null>";
        }
        String s2 = (String)tagMap.get(s1);
        s = s2;
        if (s2 == null)
        {
            StringBuilder stringbuilder = (new StringBuilder()).append("AmznGallery_");
            if (s1.lastIndexOf('.') > 0)
            {
                s = s1.substring(s1.lastIndexOf('.') + 1, s1.length());
            } else
            {
                s = s1;
            }
            s = stringbuilder.append(s).toString();
            tagMap.putIfAbsent(s1, s);
        }
        return s;
    }

    private static Logger getStoredLogger(String s)
    {
        Logger logger;
        if (s == null)
        {
            logger = Logger.getAnonymousLogger();
        } else
        {
            Logger logger1 = Logger.getLogger(s);
            logger = logger1;
            if (logOverride != null)
            {
                s = logOverride.getOverrideLevel(s);
                logger = logger1;
                if (s != null)
                {
                    logger1.setLevel(s);
                    return logger1;
                }
            }
        }
        return logger;
    }

    public static transient void i(String s, String s1, Object aobj[])
    {
        if (getStoredLogger(s).isLoggable(Level.INFO))
        {
            Log.i(getPrefixedTag(s), getMessage(s1, aobj));
        }
    }

    public static void initLogProperties(Context context, String s)
    {
_L2:
        return;
        if (context == null || s == null) goto _L2; else goto _L1
_L1:
        try
        {
            context = context.getAssets().open(s);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Logger.getAnonymousLogger().log(Level.SEVERE, "Failed to open Logging Properties file!");
            Logger.getLogger("global").setLevel(Level.INFO);
            return;
        }
        if (context == null) goto _L2; else goto _L3
_L3:
        if (logManager == null) goto _L2; else goto _L4
_L4:
        logManager.readConfiguration(context);
        return;
    }

    public static boolean isLoggable(String s, int j)
    {
        String s1 = getPrefixedTag(s);
        s = s1;
        if (s1.length() > 23)
        {
            s = s1.substring(0, 23);
        }
        return Log.isLoggable(s, j);
    }

    public static void ix(String s, String s1, Throwable throwable)
    {
        if (getStoredLogger(s).isLoggable(Level.INFO))
        {
            Log.i(getPrefixedTag(s), s1, throwable);
        }
    }

    public static transient void logCustomerEvent(String s, Object aobj[])
    {
        Log.i(getPrefixedTag("CustomerEvent"), getMessage(s, aobj));
    }

    public static void setLogOverride(LogOverrider logoverrider)
    {
        logOverride = logoverrider;
    }

    private static transient StringBuilder stackTraceHelper(int j, String s, Object aobj[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        StackTraceElement astacktraceelement[] = (new Throwable()).getStackTrace();
        if (s == null)
        {
            stringbuilder.append(astacktraceelement[j].toString()).append(" was called.");
        } else
        if (aobj != null && aobj.length != 0)
        {
            stringbuilder.append(String.format(s, aobj));
        } else
        {
            stringbuilder.append(s);
        }
        stringbuilder.append("\nStack Trace:\n");
        for (int k = astacktraceelement.length; j < k; j++)
        {
            stringbuilder.append(astacktraceelement[j]);
            stringbuilder.append("\n");
        }

        return stringbuilder;
    }

    public static transient void t(String s, long l, String s1, Object aobj[])
    {
        if (getStoredLogger(s).isLoggable(Level.ALL))
        {
            long l1 = SystemClock.uptimeMillis();
            Log.v(getPrefixedTag(s), (new StringBuilder()).append(getMessage(s1, aobj)).append(" (").append(l1 - l).append(" ms)").toString());
            time.set(Long.valueOf(l1));
        }
    }

    public static transient void t(String s, String s1, Object aobj[])
    {
        if (getStoredLogger(s).isLoggable(Level.ALL))
        {
            t(s, ((Long)time.get()).longValue(), s1, aobj);
        }
    }

    public static transient void t0(String s, String s1, Object aobj[])
    {
        if (getStoredLogger(s).isLoggable(Level.ALL))
        {
            Log.v(getPrefixedTag(s), getMessage(s1, aobj));
            time.set(Long.valueOf(SystemClock.uptimeMillis()));
        }
    }

    public static transient void v(String s, String s1, Object aobj[])
    {
        if (getStoredLogger(s).isLoggable(Level.ALL))
        {
            Log.v(getPrefixedTag(s), getMessage(s1, aobj));
        }
    }

    public static transient void w(String s, String s1, Object aobj[])
    {
        if (getStoredLogger(s).isLoggable(Level.WARNING))
        {
            Log.w(getPrefixedTag(s), getMessage(s1, aobj));
        }
    }

    public static transient void warnStackTrace(String s, String s1, Object aobj[])
    {
        w(s, stackTraceHelper(2, s1, aobj).toString(), new Object[0]);
    }

    public static void wx(String s, String s1, Throwable throwable)
    {
        if (getStoredLogger(s).isLoggable(Level.WARNING))
        {
            Log.w(getPrefixedTag(s), s1, throwable);
        }
    }

    public static transient void wxf(String s, Throwable throwable, String s1, Object aobj[])
    {
        if (getStoredLogger(s).isLoggable(Level.WARNING))
        {
            Log.w(getPrefixedTag(s), getMessage(s1, aobj), throwable);
        }
    }

}
