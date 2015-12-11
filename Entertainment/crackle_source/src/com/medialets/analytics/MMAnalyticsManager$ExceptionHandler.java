// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.analytics;


// Referenced classes of package com.medialets.analytics:
//            MMAnalyticsManager, MMEvent

protected class a
    implements eptionHandler
{

    private MMAnalyticsManager a;

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        StringBuffer stringbuffer = new StringBuffer();
        StackTraceElement astacktraceelement[] = throwable.getStackTrace();
        int j = astacktraceelement.length;
        for (int i = 0; i < j; i++)
        {
            stringbuffer.append(astacktraceelement[i]);
            stringbuffer.append("@br@");
        }

        MMEvent mmevent = new MMEvent("RuntimeException");
        mmevent.setStringForKey("StackTrace", stringbuffer.toString());
        a.trackEvent(mmevent);
        a.pause();
        a.stop();
        thread.getThreadGroup().uncaughtException(thread, throwable);
    }

    protected A(MMAnalyticsManager mmanalyticsmanager)
    {
        a = mmanalyticsmanager;
        super();
    }
}
