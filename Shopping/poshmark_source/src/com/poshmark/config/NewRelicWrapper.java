// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.config;

import android.content.Context;
import com.newrelic.agent.android.NewRelic;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.logging.AndroidAgentLog;

public class NewRelicWrapper
{

    public NewRelicWrapper()
    {
    }

    public static void initNewRelic(Context context)
    {
        AndroidAgentLog androidagentlog = new AndroidAgentLog();
        androidagentlog.setLevel(1);
        AgentLogManager.setAgentLog(androidagentlog);
        NewRelic.withApplicationToken("AAa319871d49ffd4ff9af36e15b2c6c6ed2d34ad2c").withCrashReportingEnabled(false).start(context);
    }

    public static void setNewRelicFragmentClassName(Class class1)
    {
        NewRelic.setInteractionName(class1.getName());
    }

    public static void startCustomInteraction(String s)
    {
        NewRelic.startInteraction(s);
    }

    public static void stopCustomInteraction(String s)
    {
        NewRelic.startInteraction(s);
    }
}
