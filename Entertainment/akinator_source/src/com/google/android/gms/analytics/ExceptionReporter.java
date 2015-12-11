// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.internal.zzae;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.analytics:
//            StandardExceptionParser, ExceptionParser, Tracker, GoogleAnalytics

public class ExceptionReporter
    implements Thread.UncaughtExceptionHandler
{

    private final Context mContext;
    private final Thread.UncaughtExceptionHandler zzLv;
    private final Tracker zzLw;
    private ExceptionParser zzLx;
    private GoogleAnalytics zzLy;

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
        zzLv = uncaughtexceptionhandler;
        zzLw = tracker;
        zzLx = new StandardExceptionParser(context, new ArrayList());
        mContext = context.getApplicationContext();
        context = (new StringBuilder()).append("ExceptionReporter created, original handler is ");
        if (uncaughtexceptionhandler == null)
        {
            tracker = "null";
        } else
        {
            tracker = uncaughtexceptionhandler.getClass().getName();
        }
        zzae.v(context.append(tracker).toString());
    }

    public ExceptionParser getExceptionParser()
    {
        return zzLx;
    }

    public void setExceptionParser(ExceptionParser exceptionparser)
    {
        zzLx = exceptionparser;
    }

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        Object obj = "UncaughtException";
        if (zzLx != null)
        {
            if (thread != null)
            {
                obj = thread.getName();
            } else
            {
                obj = null;
            }
            obj = zzLx.getDescription(((String) (obj)), throwable);
        }
        zzae.v((new StringBuilder()).append("Reporting uncaught exception: ").append(((String) (obj))).toString());
        zzLw.send((new HitBuilders.ExceptionBuilder()).setDescription(((String) (obj))).setFatal(true).build());
        obj = zzhK();
        ((GoogleAnalytics) (obj)).dispatchLocalHits();
        ((GoogleAnalytics) (obj)).zzhO();
        if (zzLv != null)
        {
            zzae.v("Passing exception to the original handler");
            zzLv.uncaughtException(thread, throwable);
        }
    }

    GoogleAnalytics zzhK()
    {
        if (zzLy == null)
        {
            zzLy = GoogleAnalytics.getInstance(mContext);
        }
        return zzLy;
    }

    Thread.UncaughtExceptionHandler zzhL()
    {
        return zzLv;
    }
}
