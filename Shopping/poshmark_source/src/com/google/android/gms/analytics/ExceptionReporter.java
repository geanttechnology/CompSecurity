// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.content.Context;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.analytics:
//            StandardExceptionParser, aa, ExceptionParser, Tracker, 
//            GoogleAnalytics

public class ExceptionReporter
    implements Thread.UncaughtExceptionHandler
{

    private final Context mContext;
    private final Thread.UncaughtExceptionHandler rd;
    private final Tracker re;
    private ExceptionParser rf;

    public ExceptionReporter(Tracker tracker, Thread.UncaughtExceptionHandler uncaughtexceptionhandler, Context context)
    {
        if (tracker == null)
        {
            throw new NullPointerException("tracker cannot be null");
        }
        if (context == null)
        {
            throw new NullPointerException("context cannot be null");
        }
        rd = uncaughtexceptionhandler;
        re = tracker;
        rf = new StandardExceptionParser(context, new ArrayList());
        mContext = context.getApplicationContext();
        context = (new StringBuilder()).append("ExceptionReporter created, original handler is ");
        if (uncaughtexceptionhandler == null)
        {
            tracker = "null";
        } else
        {
            tracker = uncaughtexceptionhandler.getClass().getName();
        }
        aa.v(context.append(tracker).toString());
    }

    public ExceptionParser getExceptionParser()
    {
        return rf;
    }

    public void setExceptionParser(ExceptionParser exceptionparser)
    {
        rf = exceptionparser;
    }

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        String s = "UncaughtException";
        if (rf != null)
        {
            if (thread != null)
            {
                s = thread.getName();
            } else
            {
                s = null;
            }
            s = rf.getDescription(s, throwable);
        }
        aa.v((new StringBuilder()).append("Tracking Exception: ").append(s).toString());
        re.send((new HitBuilders.ExceptionBuilder()).setDescription(s).setFatal(true).build());
        GoogleAnalytics.getInstance(mContext).dispatchLocalHits();
        if (rd != null)
        {
            aa.v("Passing exception to original handler.");
            rd.uncaughtException(thread, throwable);
        }
    }
}
