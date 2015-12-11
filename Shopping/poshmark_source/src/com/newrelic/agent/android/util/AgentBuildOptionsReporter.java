// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.util;

import com.newrelic.agent.android.Agent;
import java.io.PrintStream;

public class AgentBuildOptionsReporter
{

    public AgentBuildOptionsReporter()
    {
    }

    public static void main(String args[])
    {
        System.out.println((new StringBuilder()).append("Agent version: ").append(Agent.getVersion()).toString());
        System.out.println((new StringBuilder()).append("Unity instrumentation: ").append(Agent.getUnityInstrumentationFlag()).toString());
        System.out.println((new StringBuilder()).append("Build ID: ").append(Agent.getBuildId()).toString());
    }
}
