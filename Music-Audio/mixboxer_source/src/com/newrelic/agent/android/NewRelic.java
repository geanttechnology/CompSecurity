// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android;

import android.content.Context;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.logging.AndroidAgentLog;
import com.newrelic.agent.android.logging.NullAgentLog;

// Referenced classes of package com.newrelic.agent.android:
//            AndroidAgentImpl

public class NewRelic
{

    private static final String DEFAULT_COLLECTOR_ADDR = "mobile-collector.newrelic.com";
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private String appName;
    private String collectorAddress;
    private boolean locationServicesEnabled;
    private boolean loggingEnabled;
    private boolean ssl;
    private final String token;

    private NewRelic(String s)
    {
        collectorAddress = "mobile-collector.newrelic.com";
        ssl = true;
        loggingEnabled = true;
        locationServicesEnabled = false;
        token = s;
    }

    private boolean isInstrumented()
    {
        return true;
    }

    public static NewRelic withApplicationToken(String s)
    {
        return new NewRelic(s);
    }

    public void start(Context context)
    {
        Object obj;
        if (!loggingEnabled)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        obj = new AndroidAgentLog();
_L1:
        AgentLogManager.setAgentLog(((AgentLog) (obj)));
        if (isInstrumented())
        {
            AndroidAgentImpl.init(context, token, collectorAddress, ssl, locationServicesEnabled, appName);
            return;
        }
        break MISSING_BLOCK_LABEL_75;
        try
        {
            obj = new NullAgentLog();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            log.error("Error occurred while starting the New Relic agent!", context);
            return;
        }
          goto _L1
        log.error("Failed to detect New Relic instrumentation.  Something likely went wrong during your build process and you should contact support@newrelic.com.");
        return;
    }

    public NewRelic usingCollectorAddress(String s)
    {
        collectorAddress = s;
        return this;
    }

    public NewRelic usingSsl(boolean flag)
    {
        ssl = flag;
        return this;
    }

    public NewRelic withLocationServiceEnabled(boolean flag)
    {
        locationServicesEnabled = flag;
        return this;
    }

    public NewRelic withLoggingEnabled(boolean flag)
    {
        loggingEnabled = flag;
        return this;
    }

}
