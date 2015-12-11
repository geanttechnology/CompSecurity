// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.unity;

import com.newrelic.agent.android.NewRelic;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.util.NetworkFailure;

// Referenced classes of package com.newrelic.agent.android.unity:
//            UnityEvent, UnityException

public class NewRelicUnity
{

    private static final String ROOT_TRACE_NAME = "Unity";
    private static final AgentLog log = AgentLogManager.getAgentLog();

    public NewRelicUnity()
    {
    }

    static void handleUnityCrash(UnityException unityexception)
    {
        Thread.UncaughtExceptionHandler uncaughtexceptionhandler = Thread.getDefaultUncaughtExceptionHandler();
        if (uncaughtexceptionhandler != null && (uncaughtexceptionhandler instanceof com.newrelic.agent.android.crashes.CrashReporter.UncaughtExceptionHandler))
        {
            uncaughtexceptionhandler.uncaughtException(Thread.currentThread(), unityexception);
        }
    }

    static void noticeNetworkFailure(String s, String s1, long l, long l1, int i, String s2)
    {
        NewRelic.noticeNetworkFailure(s, s1, l, l1, NetworkFailure.fromErrorCode(i), s2);
    }

    static boolean recordEvent(UnityEvent unityevent)
    {
        return NewRelic.recordEvent(unityevent.getName(), unityevent.getAttributes());
    }

}
