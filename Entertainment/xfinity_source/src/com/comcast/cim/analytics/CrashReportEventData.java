// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.analytics;


// Referenced classes of package com.comcast.cim.analytics:
//            XfinityEventData

public class CrashReportEventData extends XfinityEventData
{

    public CrashReportEventData(Thread thread, Throwable throwable, String s)
    {
        super("appCrash");
        addData("thread", thread.getName());
        thread = getFinalCause(throwable);
        addData("exceptionType", thread.getClass().getName());
        addData("stacktrace", createRelevantStackTraceItem(thread));
        addData("message", thread.getMessage());
        addData("appVersion", s);
    }

    private String createRelevantStackTraceItem(Throwable throwable)
    {
        StackTraceElement astacktraceelement[] = throwable.getStackTrace();
        throwable = null;
        boolean flag1 = false;
        int j = astacktraceelement.length;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < j)
                {
                    throwable = astacktraceelement[i].toString();
                    if (!throwable.startsWith("com.comcast") && !throwable.startsWith("com.xfinity") && !throwable.startsWith("com.commonsware") && !throwable.startsWith("com.devsmart") && !throwable.startsWith("com.ijsbrandslob"))
                    {
                        break label0;
                    }
                    flag = true;
                }
                Object obj = throwable;
                if (!flag)
                {
                    obj = throwable;
                    if (astacktraceelement.length > 0)
                    {
                        obj = astacktraceelement[0].toString();
                    }
                }
                return ((String) (obj));
            }
            i++;
        } while (true);
    }

    private Throwable getFinalCause(Throwable throwable)
    {
        for (; throwable.getCause() != null; throwable = throwable.getCause()) { }
        return throwable;
    }
}
