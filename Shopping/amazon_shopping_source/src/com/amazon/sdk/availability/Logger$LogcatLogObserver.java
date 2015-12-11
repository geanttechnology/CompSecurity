// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import android.util.Log;

// Referenced classes of package com.amazon.sdk.availability:
//            Logger, StringUtil, Stage

private static class <init>
    implements erver
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

    private erver()
    {
    }

    erver(erver erver)
    {
        this();
    }
}
