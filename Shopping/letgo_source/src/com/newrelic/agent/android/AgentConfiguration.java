// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android;

import com.newrelic.agent.android.analytics.AnalyticAttributeStore;
import com.newrelic.agent.android.crashes.CrashStore;
import java.util.UUID;

public class AgentConfiguration
{

    private static final String DEFAULT_COLLECTOR_HOST = "mobile-collector.newrelic.com";
    private static final String DEFAULT_CRASH_COLLECTOR_HOST = "mobile-crash.newrelic.com";
    private AnalyticAttributeStore analyticAttributeStore;
    private String appName;
    private String applicationToken;
    private String collectorHost;
    private String crashCollectorHost;
    private CrashStore crashStore;
    private String customApplicationVersion;
    private String customBuildId;
    private boolean enableAnalyticsEvents;
    private boolean reportCrashes;
    private String sessionID;
    private boolean useLocationService;
    private boolean useSsl;

    public AgentConfiguration()
    {
        collectorHost = "mobile-collector.newrelic.com";
        crashCollectorHost = "mobile-crash.newrelic.com";
        useSsl = true;
        reportCrashes = true;
        enableAnalyticsEvents = true;
        sessionID = UUID.randomUUID().toString();
        customApplicationVersion = null;
        customBuildId = null;
    }

    public AnalyticAttributeStore getAnalyticAttributeStore()
    {
        return analyticAttributeStore;
    }

    public String getAppName()
    {
        return appName;
    }

    public String getApplicationToken()
    {
        return applicationToken;
    }

    public String getCollectorHost()
    {
        return collectorHost;
    }

    public String getCrashCollectorHost()
    {
        return crashCollectorHost;
    }

    public CrashStore getCrashStore()
    {
        return crashStore;
    }

    public String getCustomApplicationVersion()
    {
        return customApplicationVersion;
    }

    public String getCustomBuildIdentifier()
    {
        return customBuildId;
    }

    public boolean getEnableAnalyticsEvents()
    {
        return enableAnalyticsEvents;
    }

    public boolean getReportCrashes()
    {
        return reportCrashes;
    }

    public String getSessionID()
    {
        return sessionID;
    }

    public void setAnalyticAttributeStore(AnalyticAttributeStore analyticattributestore)
    {
        analyticAttributeStore = analyticattributestore;
    }

    public void setAppName(String s)
    {
        appName = s;
    }

    public void setApplicationToken(String s)
    {
        applicationToken = s;
    }

    public void setCollectorHost(String s)
    {
        collectorHost = s;
    }

    public void setCrashCollectorHost(String s)
    {
        crashCollectorHost = s;
    }

    public void setCrashStore(CrashStore crashstore)
    {
        crashStore = crashstore;
    }

    public void setCustomApplicationVersion(String s)
    {
        customApplicationVersion = s;
    }

    public void setCustomBuildIdentifier(String s)
    {
        customBuildId = s;
    }

    public void setEnableAnalyticsEvents(boolean flag)
    {
        enableAnalyticsEvents = flag;
    }

    public void setReportCrashes(boolean flag)
    {
        reportCrashes = flag;
    }

    public void setSessionID(String s)
    {
        sessionID = s;
    }

    public void setUseLocationService(boolean flag)
    {
        useLocationService = flag;
    }

    public void setUseSsl(boolean flag)
    {
        useSsl = flag;
    }

    public boolean useLocationService()
    {
        return useLocationService;
    }

    public boolean useSsl()
    {
        return useSsl;
    }
}
