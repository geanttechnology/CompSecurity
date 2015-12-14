// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.crash.ers;

import com.amazon.insights.core.InsightsContext;
import com.amazon.insights.core.crash.CrashAppender;
import com.amazon.insights.core.crash.CrashReporter;
import com.amazon.insights.core.crash.ExceptionUtils;
import com.amazon.insights.core.util.StringUtil;
import com.amazon.insights.event.DefaultEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

// Referenced classes of package com.amazon.insights.core.crash.ers:
//            ERSClient

public class ERSCrashAppender
    implements CrashAppender
{

    private final InsightsContext context;
    private final ERSClient ersClient;

    public ERSCrashAppender(InsightsContext insightscontext, ERSClient ersclient)
    {
        context = insightscontext;
        ersClient = ersclient;
    }

    private static String clipStringForERS(String s)
    {
        return StringUtil.clipString(s, 1000, false);
    }

    private DefaultEvent createEvent(CrashReporter crashreporter, String s, Throwable throwable)
    {
        DefaultEvent defaultevent = DefaultEvent.newInstance(context, Long.valueOf(System.currentTimeMillis()), "_sdkError");
        defaultevent.addAttribute("ver", "v1.2");
        defaultevent.addAttribute("message", clipStringForERS(s));
        defaultevent.addAttribute("reporting_class", clipStringForERS(crashreporter.getReportingClass().getName()));
        if (throwable != null)
        {
            crashreporter = ExceptionUtils.getThrowableList(throwable);
            defaultevent.addAttribute("exception_type", clipStringForERS(((Throwable)crashreporter.get(crashreporter.size() - 1)).getClass().getName()));
            int j = Math.min(crashreporter.size(), 10);
            crashreporter = crashreporter.listIterator(crashreporter.size());
            for (int i = 0; crashreporter.hasPrevious() && i < j; i++)
            {
                s = (Throwable)crashreporter.previous();
                defaultevent.addAttribute((new StringBuilder()).append("stack_trace").append(i).toString(), clipStringForERS(ExceptionUtils.getStackTraceString(s)));
            }

        }
        return defaultevent;
    }

    public void report(CrashReporter crashreporter, String s, Throwable throwable)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(createEvent(crashreporter, s, throwable));
        ersClient.submitEvents(arraylist);
    }
}
