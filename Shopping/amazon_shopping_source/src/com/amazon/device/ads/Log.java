// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.amazon.device.ads:
//            DebugProperties, ILog, Version

class Log
{
    private static class LogcatLogger
        implements ILog
    {

        private static final int MAX_LENGTH = 1000;

        public void d(String s, String s1)
        {
            for (s1 = Log.split(s1, 1000).iterator(); s1.hasNext(); android.util.Log.d(s, (String)s1.next())) { }
        }

        public transient void d(String s, String s1, Object aobj[])
        {
            d(s, String.format(s1, aobj));
        }

        public void e(String s, String s1)
        {
            for (s1 = Log.split(s1, 1000).iterator(); s1.hasNext(); android.util.Log.e(s, (String)s1.next())) { }
        }

        public transient void e(String s, String s1, Object aobj[])
        {
            e(s, String.format(s1, aobj));
        }

        public void i(String s, String s1)
        {
            for (s1 = Log.split(s1, 1000).iterator(); s1.hasNext(); android.util.Log.i(s, (String)s1.next())) { }
        }

        public transient void i(String s, String s1, Object aobj[])
        {
            i(s, String.format(s1, aobj));
        }

        public void v(String s, String s1)
        {
            for (s1 = Log.split(s1, 1000).iterator(); s1.hasNext(); android.util.Log.v(s, (String)s1.next())) { }
        }

        public transient void v(String s, String s1, Object aobj[])
        {
            v(s, String.format(s1, aobj));
        }

        public void w(String s, String s1)
        {
            for (s1 = Log.split(s1, 1000).iterator(); s1.hasNext(); android.util.Log.w(s, (String)s1.next())) { }
        }

        public transient void w(String s, String s1, Object aobj[])
        {
            w(s, String.format(s1, aobj));
        }

        private LogcatLogger()
        {
        }

    }


    protected static final String LOGTAG = "AmazonMobileAds ";
    private static ILog logger = new LogcatLogger();
    private static boolean loggingEnabled_ = false;

    Log()
    {
    }

    public static boolean canLog()
    {
        if (logger == null)
        {
            return false;
        } else
        {
            return DebugProperties.getDebugPropertyAsBoolean("debug.logging", loggingEnabled_);
        }
    }

    public static void d(String s, String s1)
    {
        d(false, s, s1);
    }

    public static transient void d(String s, String s1, Object aobj[])
    {
        d(false, s, s1, aobj);
    }

    public static void d(boolean flag, String s, String s1)
    {
        if (canLog() || flag)
        {
            logger.d((new StringBuilder()).append("AmazonMobileAds ").append(s).toString(), s1);
        }
    }

    public static transient void d(boolean flag, String s, String s1, Object aobj[])
    {
        if (canLog() || flag)
        {
            logger.d((new StringBuilder()).append("AmazonMobileAds ").append(s).toString(), s1, aobj);
        }
    }

    public static void e(String s, String s1)
    {
        e(false, s, s1);
    }

    public static transient void e(String s, String s1, Object aobj[])
    {
        e(false, s, s1, aobj);
    }

    public static void e(boolean flag, String s, String s1)
    {
        if (canLog() || flag)
        {
            logger.e((new StringBuilder()).append("AmazonMobileAds ").append(s).toString(), s1);
        }
    }

    public static transient void e(boolean flag, String s, String s1, Object aobj[])
    {
        if (canLog() || flag)
        {
            logger.e((new StringBuilder()).append("AmazonMobileAds ").append(s).toString(), s1, aobj);
        }
    }

    public static void enableLogging(boolean flag)
    {
        loggingEnabled_ = flag;
    }

    public static final void enableLoggingWithSetterNotification(String s, boolean flag)
    {
        if (!flag)
        {
            logSetterNotification(s, "Debug logging", Boolean.valueOf(flag));
        }
        enableLogging(flag);
        if (flag)
        {
            logSetterNotification(s, "Debug logging", Boolean.valueOf(flag));
            d(s, "Amazon Mobile Ads API Version: %s", new Object[] {
                Version.getRawSDKVersion()
            });
        }
    }

    public static ILog getLogger()
    {
        return logger;
    }

    public static void i(String s, String s1)
    {
        i(false, s, s1);
    }

    public static transient void i(String s, String s1, Object aobj[])
    {
        i(false, s, s1, aobj);
    }

    public static void i(boolean flag, String s, String s1)
    {
        if (canLog() || flag)
        {
            logger.i((new StringBuilder()).append("AmazonMobileAds ").append(s).toString(), s1);
        }
    }

    public static transient void i(boolean flag, String s, String s1, Object aobj[])
    {
        if (canLog() || flag)
        {
            logger.i((new StringBuilder()).append("AmazonMobileAds ").append(s).toString(), s1, aobj);
        }
    }

    public static final void logSetterNotification(String s, String s1, Object obj)
    {
        if (!canLog())
        {
            return;
        }
        if (obj instanceof Boolean)
        {
            if (((Boolean)obj).booleanValue())
            {
                obj = "enabled";
            } else
            {
                obj = "disabled";
            }
            d(s, "%s has been %s.", new Object[] {
                s1, obj
            });
            return;
        } else
        {
            d(s, "%s has been set: %s", new Object[] {
                s1, String.valueOf(obj)
            });
            return;
        }
    }

    public static void setLogger(ILog ilog)
    {
        logger = ilog;
    }

    static Iterable split(String s, int j)
    {
        ArrayList arraylist = new ArrayList();
        if (s != null && s.length() != 0)
        {
            int k = 0;
            while (k < s.length()) 
            {
                arraylist.add(s.substring(k, Math.min(s.length(), k + j)));
                k += j;
            }
        }
        return arraylist;
    }

    public static void v(String s, String s1)
    {
        v(false, s, s1);
    }

    public static transient void v(String s, String s1, Object aobj[])
    {
        v(false, s, s1, aobj);
    }

    public static void v(boolean flag, String s, String s1)
    {
        if (canLog() || flag)
        {
            logger.v((new StringBuilder()).append("AmazonMobileAds ").append(s).toString(), s1);
        }
    }

    public static transient void v(boolean flag, String s, String s1, Object aobj[])
    {
        if (canLog() || flag)
        {
            logger.v((new StringBuilder()).append("AmazonMobileAds ").append(s).toString(), s1, aobj);
        }
    }

    public static void w(String s, String s1)
    {
        w(false, s, s1);
    }

    public static transient void w(String s, String s1, Object aobj[])
    {
        w(false, s, s1, aobj);
    }

    public static void w(boolean flag, String s, String s1)
    {
        if (canLog() || flag)
        {
            logger.w((new StringBuilder()).append("AmazonMobileAds ").append(s).toString(), s1);
        }
    }

    public static transient void w(boolean flag, String s, String s1, Object aobj[])
    {
        if (canLog() || flag)
        {
            logger.w((new StringBuilder()).append("AmazonMobileAds ").append(s).toString(), s1, aobj);
        }
    }

}
