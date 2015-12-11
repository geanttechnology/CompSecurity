// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.com.google.gson.JsonArray;
import java.text.MessageFormat;

// Referenced classes of package com.newrelic.agent.android.harvest:
//            AgentHealthExceptions, AgentHealthException

public class AgentHealth extends HarvestableArray
{

    public static final String DEFAULT_KEY = "Exception";
    private static final AgentLog log = AgentLogManager.getAgentLog();
    protected final AgentHealthExceptions agentHealthExceptions = new AgentHealthExceptions();

    public AgentHealth()
    {
    }

    public static void noticeException(AgentHealthException agenthealthexception)
    {
        noticeException(agenthealthexception, "Exception");
    }

    public static void noticeException(AgentHealthException agenthealthexception, String s)
    {
        if (agenthealthexception != null)
        {
            StatsEngine statsengine = StatsEngine.get();
            if (statsengine != null)
            {
                if (s == null)
                {
                    log.warning("Passed metric key is null. Defaulting to Exception");
                }
                String s1 = s;
                if (s == null)
                {
                    s1 = "Exception";
                }
                statsengine.inc(MessageFormat.format("Supportability/AgentHealth/{0}/{1}/{2}/{3}", new Object[] {
                    s1, agenthealthexception.getSourceClass(), agenthealthexception.getSourceMethod(), agenthealthexception.getExceptionClass()
                }));
                TaskQueue.queue(agenthealthexception);
                return;
            } else
            {
                log.error("StatsEngine is null. Exception not recorded.");
                return;
            }
        } else
        {
            log.error("AgentHealthException is null. StatsEngine not updated");
            return;
        }
    }

    public static void noticeException(Exception exception)
    {
        AgentHealthException agenthealthexception = null;
        if (exception != null)
        {
            agenthealthexception = new AgentHealthException(exception);
        }
        noticeException(agenthealthexception);
    }

    public void addException(AgentHealthException agenthealthexception)
    {
        agentHealthExceptions.add(agenthealthexception);
    }

    public JsonArray asJsonArray()
    {
        JsonArray jsonarray = new JsonArray();
        if (!agentHealthExceptions.isEmpty())
        {
            jsonarray.add(agentHealthExceptions.asJsonObject());
        }
        return jsonarray;
    }

    public void clear()
    {
        agentHealthExceptions.clear();
    }

}
