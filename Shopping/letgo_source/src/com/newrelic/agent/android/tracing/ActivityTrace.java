// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.tracing;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.Measurements;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.activity.NamedActivity;
import com.newrelic.agent.android.harvest.ActivitySighting;
import com.newrelic.agent.android.harvest.ConnectInformation;
import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.Metric;
import com.newrelic.com.google.gson.Gson;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.newrelic.agent.android.tracing:
//            Trace, Sample, TraceType

public class ActivityTrace extends HarvestableArray
{

    private static final HashMap ACTIVITY_HISTORY_TYPE = new HashMap() {

            
            {
                put("type", "ACTIVITY_HISTORY");
            }
    };
    private static final HashMap ENVIRONMENT_TYPE = new HashMap() {

            
            {
                put("type", "ENVIRONMENT");
            }
    };
    public static final int MAX_TRACES = 2000;
    private static final String SIZE_NORMAL = "NORMAL";
    public static final String TRACE_VERSION = "1.0";
    private static final HashMap VITALS_TYPE = new HashMap() {

            
            {
                put("type", "VITALS");
            }
    };
    private boolean complete;
    public long lastUpdatedAt;
    private final AgentLog log;
    private NamedActivity measuredActivity;
    private final Set missingChildren;
    public final Metric networkCountMetric;
    public final Metric networkTimeMetric;
    private final HashMap params;
    public ActivitySighting previousActivity;
    private long reportAttemptCount;
    public Trace rootTrace;
    public long startedAt;
    private int traceCount;
    private final ConcurrentHashMap traces;
    private Map vitals;

    public ActivityTrace()
    {
        traces = new ConcurrentHashMap();
        traceCount = 0;
        missingChildren = Collections.synchronizedSet(new HashSet());
        reportAttemptCount = 0L;
        complete = false;
        params = new HashMap();
        log = AgentLogManager.getAgentLog();
        networkCountMetric = new Metric("Mobile/Activity/Network/<activity>/Count");
        networkTimeMetric = new Metric("Mobile/Activity/Network/<activity>/Time");
    }

    public ActivityTrace(Trace trace)
    {
        traces = new ConcurrentHashMap();
        traceCount = 0;
        missingChildren = Collections.synchronizedSet(new HashSet());
        reportAttemptCount = 0L;
        complete = false;
        params = new HashMap();
        log = AgentLogManager.getAgentLog();
        networkCountMetric = new Metric("Mobile/Activity/Network/<activity>/Count");
        networkTimeMetric = new Metric("Mobile/Activity/Network/<activity>/Time");
        rootTrace = trace;
        lastUpdatedAt = trace.entryTimestamp;
        startedAt = lastUpdatedAt;
        params.put("traceVersion", "1.0");
        params.put("type", "ACTIVITY");
        measuredActivity = (NamedActivity)Measurements.startActivity(trace.displayName);
        measuredActivity.setStartTime(trace.entryTimestamp);
    }

    private JsonArray getEnvironment()
    {
        JsonArray jsonarray = new JsonArray();
        jsonarray.add((new Gson()).toJsonTree(ENVIRONMENT_TYPE, GSON_STRING_MAP_TYPE));
        jsonarray.addAll((new ConnectInformation(Agent.getApplicationInformation(), Agent.getDeviceInformation())).asJsonArray());
        HashMap hashmap = new HashMap();
        hashmap.put("size", "NORMAL");
        jsonarray.add((new Gson()).toJsonTree(hashmap, GSON_STRING_MAP_TYPE));
        return jsonarray;
    }

    private JsonArray getPreviousActivityAsJson()
    {
        JsonArray jsonarray = new JsonArray();
        jsonarray.add((new Gson()).toJsonTree(ACTIVITY_HISTORY_TYPE, GSON_STRING_MAP_TYPE));
        jsonarray.addAll(previousActivity.asJsonArray());
        return jsonarray;
    }

    private JsonArray getVitalsAsJson()
    {
        JsonArray jsonarray = new JsonArray();
        jsonarray.add((new Gson()).toJsonTree(VITALS_TYPE, GSON_STRING_MAP_TYPE));
        JsonObject jsonobject = new JsonObject();
        if (vitals != null)
        {
            java.util.Map.Entry entry;
            JsonArray jsonarray1;
label0:
            for (Iterator iterator = vitals.entrySet().iterator(); iterator.hasNext(); jsonobject.add(((Sample.SampleType)entry.getKey()).toString(), jsonarray1))
            {
                entry = (java.util.Map.Entry)iterator.next();
                jsonarray1 = new JsonArray();
                Iterator iterator1 = ((Collection)entry.getValue()).iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        continue label0;
                    }
                    Sample sample = (Sample)iterator1.next();
                    if (sample.getTimestamp() <= lastUpdatedAt)
                    {
                        jsonarray1.add(sample.asJsonArray());
                    }
                } while (true);
            }

        }
        jsonarray.add(jsonobject);
        return jsonarray;
    }

    private JsonArray traceToTree(Trace trace)
    {
        JsonArray jsonarray = new JsonArray();
        trace.prepareForSerialization();
        jsonarray.add((new Gson()).toJsonTree(trace.getParams(), GSON_STRING_MAP_TYPE));
        jsonarray.add(new JsonPrimitive(Long.valueOf(trace.entryTimestamp)));
        jsonarray.add(new JsonPrimitive(Long.valueOf(trace.exitTimestamp)));
        jsonarray.add(new JsonPrimitive(trace.displayName));
        JsonArray jsonarray1 = new JsonArray();
        jsonarray1.add(new JsonPrimitive(Long.valueOf(trace.threadId)));
        jsonarray1.add(new JsonPrimitive(trace.threadName));
        jsonarray.add(jsonarray1);
        if (trace.getChildren().isEmpty())
        {
            jsonarray.add(new JsonArray());
            return jsonarray;
        }
        jsonarray1 = new JsonArray();
        trace = trace.getChildren().iterator();
        do
        {
            if (!trace.hasNext())
            {
                break;
            }
            Object obj = (UUID)trace.next();
            obj = (Trace)traces.get(obj);
            if (obj != null)
            {
                jsonarray1.add(traceToTree(((Trace) (obj))));
            }
        } while (true);
        jsonarray.add(jsonarray1);
        return jsonarray;
    }

    public void addCompletedTrace(Trace trace)
    {
        if (trace.getType() == TraceType.NETWORK)
        {
            networkCountMetric.sample(1.0D);
            networkTimeMetric.sample(trace.getDurationAsSeconds());
        }
        trace.traceMachine = null;
        missingChildren.remove(trace.myUUID);
        if (traceCount > 2000)
        {
            log.debug((new StringBuilder()).append("Maximum trace limit reached, discarding trace ").append(trace.myUUID).toString());
            return;
        }
        traces.put(trace.myUUID, trace);
        traceCount = traceCount + 1;
        if (trace.exitTimestamp > rootTrace.exitTimestamp)
        {
            rootTrace.exitTimestamp = trace.exitTimestamp;
        }
        if (log.getLevel() == 5)
        {
            log.debug((new StringBuilder()).append("Added trace ").append(trace.myUUID.toString()).append(" missing children: ").append(missingChildren.size()).toString());
        }
        lastUpdatedAt = System.currentTimeMillis();
    }

    public void addTrace(Trace trace)
    {
        missingChildren.add(trace.myUUID);
        lastUpdatedAt = System.currentTimeMillis();
    }

    public JsonArray asJsonArray()
    {
        JsonArray jsonarray = new JsonArray();
        if (!complete)
        {
            log.debug((new StringBuilder()).append("Attempted to serialize trace ").append(rootTrace.myUUID.toString()).append(" but it has yet to be finalized").toString());
            return null;
        }
        jsonarray.add((new Gson()).toJsonTree(params, GSON_STRING_MAP_TYPE));
        jsonarray.add(new JsonPrimitive(Long.valueOf(rootTrace.entryTimestamp)));
        jsonarray.add(new JsonPrimitive(Long.valueOf(rootTrace.exitTimestamp)));
        jsonarray.add(new JsonPrimitive(rootTrace.displayName));
        JsonArray jsonarray1 = new JsonArray();
        jsonarray1.add(getEnvironment());
        jsonarray1.add(traceToTree(rootTrace));
        jsonarray1.add(getVitalsAsJson());
        if (previousActivity != null)
        {
            jsonarray1.add(getPreviousActivityAsJson());
        }
        jsonarray.add(jsonarray1);
        return jsonarray;
    }

    public void complete()
    {
        if (log.getLevel() == 5)
        {
            log.debug((new StringBuilder()).append("Completing trace of ").append(rootTrace.displayName).append(":").append(rootTrace.myUUID.toString()).append("(").append(traces.size()).append(" traces)").toString());
        }
        if (rootTrace.exitTimestamp == 0L)
        {
            rootTrace.exitTimestamp = System.currentTimeMillis();
        }
        if (traces.isEmpty())
        {
            rootTrace.traceMachine = null;
            complete = true;
            Measurements.endActivityWithoutMeasurement(measuredActivity);
            return;
        } else
        {
            measuredActivity.setEndTime(rootTrace.exitTimestamp);
            Measurements.endActivity(measuredActivity);
            rootTrace.traceMachine = null;
            complete = true;
            TaskQueue.queue(this);
            return;
        }
    }

    public void discard()
    {
        if (log.getLevel() == 5)
        {
            log.debug((new StringBuilder()).append("Discarding trace of ").append(rootTrace.displayName).append(":").append(rootTrace.myUUID.toString()).append("(").append(traces.size()).append(" traces)").toString());
        }
        rootTrace.traceMachine = null;
        complete = true;
        Measurements.endActivityWithoutMeasurement(measuredActivity);
    }

    public String getActivityName()
    {
        String s = "<activity>";
        if (rootTrace != null)
        {
            String s1 = rootTrace.displayName;
            s = s1;
            if (s1 != null)
            {
                int i = s1.indexOf("#");
                s = s1;
                if (i > 0)
                {
                    s = s1.substring(0, i);
                }
            }
        }
        return s;
    }

    public String getId()
    {
        if (rootTrace == null)
        {
            return null;
        } else
        {
            return rootTrace.myUUID.toString();
        }
    }

    public long getLastUpdatedAt()
    {
        return lastUpdatedAt;
    }

    public long getReportAttemptCount()
    {
        return reportAttemptCount;
    }

    public Map getTraces()
    {
        return traces;
    }

    public boolean hasMissingChildren()
    {
        return !missingChildren.isEmpty();
    }

    public void incrementReportAttemptCount()
    {
        reportAttemptCount = reportAttemptCount + 1L;
    }

    public boolean isComplete()
    {
        return complete;
    }

    public void setLastUpdatedAt(long l)
    {
        lastUpdatedAt = l;
    }

    public void setVitals(Map map)
    {
        vitals = map;
    }

}
