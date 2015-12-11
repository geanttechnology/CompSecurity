// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.platform.metric;


// Referenced classes of package com.amazon.identity.platform.metric:
//            PlatformMetricsTimer

static final class mTimerName extends PlatformMetricsTimer
{

    private static final String TAG = com/amazon/identity/platform/metric/PlatformMetricsTimer$FakeMetricsTimer.getName();
    private String mTimerName;

    public void discard()
    {
        String s = mTimerName;
    }

    public void setTimerName(String s)
    {
        s = mTimerName;
    }

    public void start()
    {
        String s = mTimerName;
    }

    public void stop()
    {
        String s = mTimerName;
    }

    public void stopAndDiscard()
    {
        String s = mTimerName;
    }

    public void stopClock()
    {
        String s = mTimerName;
    }


    (String s)
    {
        mTimerName = s;
    }
}
