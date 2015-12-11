// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import android.util.Log;

// Referenced classes of package com.amazon.sdk.availability:
//            StringUtil, Stage

public final class Logger
{
    public static interface AvailabilityLogObserver
    {

        public abstract void e(String s);

        public abstract void e(String s, Throwable throwable);

        public abstract void i(String s);

        public abstract void measurementRecorded(String s, String s1);

        public abstract void measurementsSubmitted(boolean flag, long l, String s, String s1);

        public abstract void syncConfigurationScheduled(long l, boolean flag);

        public abstract void v(String s);

        public abstract void v(String s, Throwable throwable);

        public abstract void w(String s);

        public abstract void w(String s, Throwable throwable);
    }

    private static class LogcatLogObserver
        implements AvailabilityLogObserver
    {

        public void e(String s)
        {
            Log.e("AvailabilitySDK", s);
        }

        public void e(String s, Throwable throwable)
        {
            Log.e("AvailabilitySDK", s, throwable);
        }

        public void i(String s)
        {
            Log.i("AvailabilitySDK", s);
        }

        public void measurementRecorded(String s, String s1)
        {
            i(String.format("putMeasurement - %s", new Object[] {
                s1
            }));
            v(String.format("putMeasurement - %s (%s)", new Object[] {
                s, s1
            }));
        }

        public void measurementsSubmitted(boolean flag, long l, String s, String s1)
        {
            if (flag)
            {
                s = (new StringBuilder()).append("successful submission of ").append(l).append(" measurements to ").append(s).append("/").append(s1).toString();
            } else
            {
                s = (new StringBuilder()).append("failed submission of ").append(l).append(" measurements to ").append(s).append("/").append(s1).toString();
            }
            v(s);
        }

        public void syncConfigurationScheduled(long l, boolean flag)
        {
            String s;
            if (flag)
            {
                s = (new StringBuilder()).append("scheduled configuration update @ ").append(StringUtil.dateToString(Long.valueOf(l))).append(" (repeating)").toString();
            } else
            {
                s = (new StringBuilder()).append("scheduled configuration update @ ").append(StringUtil.dateToString(Long.valueOf(l))).toString();
            }
            i(s);
        }

        public void v(String s)
        {
            if (!Stage.isProduction())
            {
                Log.v("AvailabilitySDK", s);
            }
        }

        public void v(String s, Throwable throwable)
        {
            if (!Stage.isProduction())
            {
                Log.v("AvailabilitySDK", s, throwable);
            }
        }

        public void w(String s)
        {
            Log.w("AvailabilitySDK", s);
        }

        public void w(String s, Throwable throwable)
        {
            Log.w("AvailabilitySDK", s, throwable);
        }

        private LogcatLogObserver()
        {
        }

    }


    private static AvailabilityLogObserver logObserver = new LogcatLogObserver();

    private Logger()
    {
    }

    public static void e(String s)
    {
        logObserver.e(s);
    }

    public static void e(String s, Throwable throwable)
    {
        logObserver.e(s, throwable);
    }

    public static void i(String s)
    {
        logObserver.i(s);
    }

    public static void measurementRecorded(String s, String s1)
    {
        logObserver.measurementRecorded(s, s1);
    }

    public static void measurementsSubmitted(boolean flag, long l, String s, String s1)
    {
        logObserver.measurementsSubmitted(flag, l, s, s1);
    }

    public static void syncConfigurationScheduled(Long long1, boolean flag)
    {
        long l;
        if (long1 == null)
        {
            l = 0L;
        } else
        {
            l = long1.longValue();
        }
        logObserver.syncConfigurationScheduled(l, flag);
    }

    public static void v(String s)
    {
        logObserver.v(s);
    }

    public static void v(String s, Throwable throwable)
    {
        logObserver.v(s, throwable);
    }

    public static void w(String s)
    {
        logObserver.w(s);
    }

    public static void w(String s, Throwable throwable)
    {
        logObserver.w(s, throwable);
    }

}
