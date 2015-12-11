// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.harvest.crash;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.AgentImpl;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.analytics.AnalyticAttribute;
import com.newrelic.agent.android.analytics.AnalyticsEvent;
import com.newrelic.agent.android.crashes.CrashReporter;
import com.newrelic.agent.android.harvest.ActivityHistory;
import com.newrelic.agent.android.harvest.DataToken;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.HarvestConfiguration;
import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.agent.android.util.Util;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonParser;
import com.newrelic.com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

// Referenced classes of package com.newrelic.agent.android.harvest.crash:
//            DeviceInfo, ApplicationInfo, ExceptionInfo, ThreadInfo

public class Crash extends HarvestableObject
{

    public static final int PROTOCOL_VERSION = 1;
    private ActivityHistory activityHistory;
    private final boolean analyticsEnabled;
    private final String appToken;
    private ApplicationInfo applicationInfo;
    private final String buildId;
    private DeviceInfo deviceInfo;
    private Collection events;
    private ExceptionInfo exceptionInfo;
    private Set sessionAttributes;
    private List threads;
    private final long timestamp;
    private final UUID uuid;

    public Crash(Throwable throwable)
    {
        this(throwable, ((Set) (new HashSet())), ((Collection) (new HashSet())), false);
    }

    public Crash(Throwable throwable, Set set, Collection collection, boolean flag)
    {
        AgentImpl agentimpl = Agent.getImpl();
        throwable = getRootCause(throwable);
        uuid = new UUID(Util.getRandom().nextLong(), Util.getRandom().nextLong());
        buildId = getBuildId();
        timestamp = System.currentTimeMillis() / 1000L;
        appToken = CrashReporter.getAgentConfiguration().getApplicationToken();
        deviceInfo = new DeviceInfo(agentimpl.getDeviceInformation(), agentimpl.getEnvironmentInformation());
        applicationInfo = new ApplicationInfo(agentimpl.getApplicationInformation());
        exceptionInfo = new ExceptionInfo(throwable);
        threads = ThreadInfo.extractThreads(throwable);
        activityHistory = TraceMachine.getActivityHistory();
        sessionAttributes = set;
        events = collection;
        analyticsEnabled = flag;
    }

    public Crash(UUID uuid1, String s, long l)
    {
        AgentImpl agentimpl = Agent.getImpl();
        uuid = uuid1;
        buildId = s;
        timestamp = l;
        appToken = CrashReporter.getAgentConfiguration().getApplicationToken();
        deviceInfo = new DeviceInfo(agentimpl.getDeviceInformation(), agentimpl.getEnvironmentInformation());
        applicationInfo = new ApplicationInfo(agentimpl.getApplicationInformation());
        exceptionInfo = new ExceptionInfo();
        threads = new ArrayList();
        activityHistory = new ActivityHistory(new ArrayList());
        sessionAttributes = new HashSet();
        events = new HashSet();
        analyticsEnabled = false;
    }

    public static Crash crashFromJsonString(String s)
    {
        s = (new JsonParser()).parse(s).getAsJsonObject();
        Object obj = s.get("uuid").getAsString();
        String s1 = s.get("buildId").getAsString();
        long l = s.get("timestamp").getAsLong();
        obj = new Crash(UUID.fromString(((String) (obj))), s1, l);
        obj.deviceInfo = DeviceInfo.newFromJson(s.get("deviceInfo").getAsJsonObject());
        obj.applicationInfo = ApplicationInfo.newFromJson(s.get("appInfo").getAsJsonObject());
        obj.exceptionInfo = ExceptionInfo.newFromJson(s.get("exception").getAsJsonObject());
        obj.threads = ThreadInfo.newListFromJson(s.get("threads").getAsJsonArray());
        obj.activityHistory = ActivityHistory.newFromJson(s.get("activityHistory").getAsJsonArray());
        return ((Crash) (obj));
    }

    public static String getBuildId()
    {
        return "1c0c63fe-f3f4-46a8-8ddb-02c5f5ce2c99";
    }

    protected static Throwable getRootCause(Throwable throwable)
    {
        if (throwable != null)
        {
            Throwable throwable1 = throwable.getCause();
            if (throwable1 == null)
            {
                return throwable;
            } else
            {
                return getRootCause(throwable1);
            }
        } else
        {
            return new Throwable("Unknown cause");
        }
    }

    public JsonObject asJsonObject()
    {
        JsonObject jsonobject = new JsonObject();
        jsonobject.add("protocolVersion", new JsonPrimitive(Integer.valueOf(1)));
        jsonobject.add("platform", new JsonPrimitive("Android"));
        jsonobject.add("uuid", SafeJsonPrimitive.factory(uuid.toString()));
        jsonobject.add("buildId", SafeJsonPrimitive.factory(buildId));
        jsonobject.add("timestamp", SafeJsonPrimitive.factory(Long.valueOf(timestamp)));
        jsonobject.add("appToken", SafeJsonPrimitive.factory(appToken));
        jsonobject.add("deviceInfo", deviceInfo.asJsonObject());
        jsonobject.add("appInfo", applicationInfo.asJsonObject());
        jsonobject.add("exception", exceptionInfo.asJsonObject());
        jsonobject.add("threads", getThreadsAsJson());
        jsonobject.add("activityHistory", activityHistory.asJsonArrayWithoutDuration());
        if (analyticsEnabled && FeatureFlag.featureEnabled(FeatureFlag.AnalyticsEvents))
        {
            Object obj = new JsonObject();
            if (sessionAttributes != null)
            {
                AnalyticAttribute analyticattribute;
                for (Iterator iterator = sessionAttributes.iterator(); iterator.hasNext(); jsonobject.add(analyticattribute.getName(), analyticattribute.asJsonElement()))
                {
                    analyticattribute = (AnalyticAttribute)iterator.next();
                }

            }
            jsonobject.add("sessionAttributes", ((JsonElement) (obj)));
            obj = new JsonArray();
            if (events != null)
            {
                for (Iterator iterator1 = events.iterator(); iterator1.hasNext(); ((JsonArray) (obj)).add(((AnalyticsEvent)iterator1.next()).asJsonObject())) { }
            }
            jsonobject.add("analyticsEvents", ((JsonElement) (obj)));
        }
        DataToken datatoken = Harvest.getHarvestConfiguration().getDataToken();
        if (datatoken != null)
        {
            jsonobject.add("dataToken", datatoken.asJsonArray());
        }
        return jsonobject;
    }

    public ExceptionInfo getExceptionInfo()
    {
        return exceptionInfo;
    }

    protected JsonArray getThreadsAsJson()
    {
        JsonArray jsonarray = new JsonArray();
        if (threads != null)
        {
            for (Iterator iterator = threads.iterator(); iterator.hasNext(); jsonarray.add(((ThreadInfo)iterator.next()).asJsonObject())) { }
        }
        return jsonarray;
    }

    public long getTimestamp()
    {
        return timestamp;
    }

    public UUID getUuid()
    {
        return uuid;
    }

    public void setAnalyticsEvents(List list)
    {
        events = list;
    }

    public void setSessionAttributes(Set set)
    {
        sessionAttributes = set;
    }
}
