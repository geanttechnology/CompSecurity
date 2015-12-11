// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.analytics.AnalyticAttribute;
import com.newrelic.agent.android.analytics.AnalyticsEvent;
import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.newrelic.agent.android.harvest:
//            DataToken, HttpTransactions, HttpErrors, ActivityTraces, 
//            MachineMeasurements, AgentHealth, DeviceInformation, Harvest, 
//            HarvestConfiguration

public class HarvestData extends HarvestableArray
{

    private static final AgentLog log = AgentLogManager.getAgentLog();
    private ActivityTraces activityTraces;
    private AgentHealth agentHealth;
    private boolean analyticsEnabled;
    private Collection analyticsEvents;
    private DataToken dataToken;
    private DeviceInformation deviceInformation;
    private double harvestTimeDelta;
    private HttpErrors httpErrors;
    private HttpTransactions httpTransactions;
    private MachineMeasurements machineMeasurements;
    private Set sessionAttributes;

    public HarvestData()
    {
        dataToken = new DataToken();
        httpTransactions = new HttpTransactions();
        httpErrors = new HttpErrors();
        activityTraces = new ActivityTraces();
        machineMeasurements = new MachineMeasurements();
        deviceInformation = Agent.getDeviceInformation();
        agentHealth = new AgentHealth();
        sessionAttributes = new HashSet();
        analyticsEvents = new HashSet();
        analyticsEnabled = false;
    }

    public JsonArray asJsonArray()
    {
        JsonArray jsonarray;
        Object obj;
        jsonarray = new JsonArray();
        jsonarray.add(dataToken.asJson());
        jsonarray.add(deviceInformation.asJson());
        jsonarray.add(new JsonPrimitive(Double.valueOf(harvestTimeDelta)));
        jsonarray.add(httpTransactions.asJson());
        jsonarray.add(machineMeasurements.asJson());
        jsonarray.add(httpErrors.asJson());
        obj = activityTraces.asJson();
        Object obj1 = ((JsonElement) (obj)).toString();
        static class _cls1
        {

            static final int $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType[];

            static 
            {
                $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType = new int[com.newrelic.agent.android.analytics.AnalyticAttribute.AttributeDataType.values().length];
                try
                {
                    $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType[com.newrelic.agent.android.analytics.AnalyticAttribute.AttributeDataType.STRING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType[com.newrelic.agent.android.analytics.AnalyticAttribute.AttributeDataType.FLOAT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType[com.newrelic.agent.android.analytics.AnalyticAttribute.AttributeDataType.BOOLEAN.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        if (((String) (obj1)).length() < Harvest.getHarvestConfiguration().getActivity_trace_max_size())
        {
            jsonarray.add(((JsonElement) (obj)));
        } else
        {
            StatsEngine.get().sample("Supportability/AgentHealth/BigActivityTracesDropped", ((String) (obj1)).length());
        }
        jsonarray.add(agentHealth.asJson());
        if (!analyticsEnabled) goto _L2; else goto _L1
_L1:
        obj = new JsonObject();
        obj1 = sessionAttributes.iterator();
_L4:
        if (((Iterator) (obj1)).hasNext())
        {
            AnalyticAttribute analyticattribute = (AnalyticAttribute)((Iterator) (obj1)).next();
            switch (_cls1..SwitchMap.com.newrelic.agent.android.analytics.AnalyticAttribute.AttributeDataType[analyticattribute.getAttributeDataType().ordinal()])
            {
            case 1: // '\001'
                ((JsonObject) (obj)).addProperty(analyticattribute.getName(), analyticattribute.getStringValue());
                break;

            case 2: // '\002'
                ((JsonObject) (obj)).addProperty(analyticattribute.getName(), Float.valueOf(analyticattribute.getFloatValue()));
                break;

            case 3: // '\003'
                ((JsonObject) (obj)).addProperty(analyticattribute.getName(), Boolean.valueOf(analyticattribute.getBooleanValue()));
                break;
            }
            continue; /* Loop/switch isn't completed */
        }
        jsonarray.add(((JsonElement) (obj)));
        obj = new JsonArray();
        for (Iterator iterator = analyticsEvents.iterator(); iterator.hasNext(); ((JsonArray) (obj)).add(((AnalyticsEvent)iterator.next()).asJsonObject())) { }
        jsonarray.add(((JsonElement) (obj)));
_L2:
        return jsonarray;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public ActivityTraces getActivityTraces()
    {
        return activityTraces;
    }

    public AgentHealth getAgentHealth()
    {
        return agentHealth;
    }

    public Collection getAnalyticsEvents()
    {
        return analyticsEvents;
    }

    public DataToken getDataToken()
    {
        return dataToken;
    }

    public DeviceInformation getDeviceInformation()
    {
        return deviceInformation;
    }

    public HttpErrors getHttpErrors()
    {
        return httpErrors;
    }

    public HttpTransactions getHttpTransactions()
    {
        return httpTransactions;
    }

    public MachineMeasurements getMetrics()
    {
        return machineMeasurements;
    }

    public Set getSessionAttributes()
    {
        return sessionAttributes;
    }

    public boolean isAnalyticsEnabled()
    {
        return analyticsEnabled;
    }

    public boolean isValid()
    {
        return dataToken.isValid();
    }

    public void reset()
    {
        httpErrors.clear();
        httpTransactions.clear();
        activityTraces.clear();
        machineMeasurements.clear();
        agentHealth.clear();
        sessionAttributes.clear();
        analyticsEvents.clear();
    }

    public void setActivityTraces(ActivityTraces activitytraces)
    {
        activityTraces = activitytraces;
    }

    public void setAnalyticsEnabled(boolean flag)
    {
        analyticsEnabled = flag;
    }

    public void setAnalyticsEvents(Collection collection)
    {
        analyticsEvents = new HashSet(collection);
    }

    public void setDataToken(DataToken datatoken)
    {
        if (datatoken == null)
        {
            return;
        } else
        {
            dataToken = datatoken;
            return;
        }
    }

    public void setDeviceInformation(DeviceInformation deviceinformation)
    {
        deviceInformation = deviceinformation;
    }

    public void setHarvestTimeDelta(double d)
    {
        harvestTimeDelta = d;
    }

    public void setHttpErrors(HttpErrors httperrors)
    {
        httpErrors = httperrors;
    }

    public void setHttpTransactions(HttpTransactions httptransactions)
    {
        httpTransactions = httptransactions;
    }

    public void setMachineMeasurements(MachineMeasurements machinemeasurements)
    {
        machineMeasurements = machinemeasurements;
    }

    public void setSessionAttributes(Set set)
    {
        log.debug((new StringBuilder()).append("HarvestData.setSessionAttributes invoked with attribute set ").append(set).toString());
        sessionAttributes = new HashSet(set);
    }

    public String toString()
    {
        return (new StringBuilder()).append("HarvestData{\n\tdataToken=").append(dataToken).append(", \n\tdeviceInformation=").append(deviceInformation).append(", \n\tharvestTimeDelta=").append(harvestTimeDelta).append(", \n\thttpTransactions=").append(httpTransactions).append(", \n\tmachineMeasurements=").append(machineMeasurements).append(", \n\thttpErrors=").append(httpErrors).append(", \n\tactivityTraces=").append(activityTraces).append(", \n\tsessionAttributes=").append(sessionAttributes).append(", \n\tanalyticAttributes=").append(analyticsEvents).append('}').toString();
    }

}
