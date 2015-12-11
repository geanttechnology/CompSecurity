// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.AgentImpl;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.activity.config.ActivityTraceConfiguration;
import com.newrelic.agent.android.activity.config.ActivityTraceConfigurationDeserializer;
import com.newrelic.agent.android.analytics.AnalyticsControllerImpl;
import com.newrelic.agent.android.analytics.EventManager;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.tracing.ActivityTrace;
import com.newrelic.com.google.gson.Gson;
import com.newrelic.com.google.gson.GsonBuilder;
import com.newrelic.com.google.gson.JsonSyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.newrelic.agent.android.harvest:
//            HarvestConfiguration, HarvestData, Harvest, HarvestLifecycleAware, 
//            AgentHealth, HarvestResponse, HttpTransactions, HttpErrors, 
//            ActivityTraces, HarvestConnection, DataToken, HttpError, 
//            HttpTransaction, ConnectInformation

public class Harvester
{
    protected static final class State extends Enum
    {

        private static final State $VALUES[];
        public static final State CONNECTED;
        public static final State DISABLED;
        public static final State DISCONNECTED;
        public static final State UNINITIALIZED;

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/newrelic/agent/android/harvest/Harvester$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        static 
        {
            UNINITIALIZED = new State("UNINITIALIZED", 0);
            DISCONNECTED = new State("DISCONNECTED", 1);
            CONNECTED = new State("CONNECTED", 2);
            DISABLED = new State("DISABLED", 3);
            $VALUES = (new State[] {
                UNINITIALIZED, DISCONNECTED, CONNECTED, DISABLED
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }


    private AgentConfiguration agentConfiguration;
    private HarvestConfiguration configuration;
    private HarvestConnection harvestConnection;
    private HarvestData harvestData;
    private final Collection harvestListeners = new ArrayList();
    private final AgentLog log = AgentLogManager.getAgentLog();
    private State state;
    protected boolean stateChanged;

    public Harvester()
    {
        state = State.UNINITIALIZED;
        configuration = HarvestConfiguration.getDefaultHarvestConfiguration();
    }

    private void changeState(State state1)
    {
        log.debug((new StringBuilder()).append("Harvester changing state: ").append(state).append(" -> ").append(state1).toString());
        if (state != State.CONNECTED) goto _L2; else goto _L1
_L1:
        if (state1 != State.DISCONNECTED) goto _L4; else goto _L3
_L3:
        fireOnHarvestDisconnected();
_L2:
        state = state1;
        stateChanged = true;
        return;
_L4:
        if (state1 == State.DISABLED)
        {
            fireOnHarvestDisabled();
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    private void configureHarvester(HarvestConfiguration harvestconfiguration)
    {
        configuration.reconfigure(harvestconfiguration);
        harvestData.setDataToken(configuration.getDataToken());
        Harvest.setHarvestConfiguration(configuration);
    }

    private void fireOnHarvest()
    {
        try
        {
            for (Iterator iterator = getHarvestListeners().iterator(); iterator.hasNext(); ((HarvestLifecycleAware)iterator.next()).onHarvest()) { }
        }
        catch (Exception exception)
        {
            log.error("Error in fireOnHarvest", exception);
            AgentHealth.noticeException(exception);
        }
    }

    private void fireOnHarvestBefore()
    {
        try
        {
            for (Iterator iterator = getHarvestListeners().iterator(); iterator.hasNext(); ((HarvestLifecycleAware)iterator.next()).onHarvestBefore()) { }
        }
        catch (Exception exception)
        {
            log.error("Error in fireOnHarvestBefore", exception);
            AgentHealth.noticeException(exception);
        }
    }

    private void fireOnHarvestComplete()
    {
        try
        {
            for (Iterator iterator = getHarvestListeners().iterator(); iterator.hasNext(); ((HarvestLifecycleAware)iterator.next()).onHarvestComplete()) { }
        }
        catch (Exception exception)
        {
            log.error("Error in fireOnHarvestComplete", exception);
            AgentHealth.noticeException(exception);
        }
    }

    private void fireOnHarvestConnected()
    {
        try
        {
            for (Iterator iterator = getHarvestListeners().iterator(); iterator.hasNext(); ((HarvestLifecycleAware)iterator.next()).onHarvestConnected()) { }
        }
        catch (Exception exception)
        {
            log.error("Error in fireOnHarvestConnected", exception);
            AgentHealth.noticeException(exception);
        }
    }

    private void fireOnHarvestDisabled()
    {
        try
        {
            for (Iterator iterator = getHarvestListeners().iterator(); iterator.hasNext(); ((HarvestLifecycleAware)iterator.next()).onHarvestDisabled()) { }
        }
        catch (Exception exception)
        {
            log.error("Error in fireOnHarvestDisabled", exception);
            AgentHealth.noticeException(exception);
        }
    }

    private void fireOnHarvestDisconnected()
    {
        try
        {
            for (Iterator iterator = getHarvestListeners().iterator(); iterator.hasNext(); ((HarvestLifecycleAware)iterator.next()).onHarvestDisconnected()) { }
        }
        catch (Exception exception)
        {
            log.error("Error in fireOnHarvestDisconnected", exception);
            AgentHealth.noticeException(exception);
        }
    }

    private void fireOnHarvestError()
    {
        try
        {
            for (Iterator iterator = getHarvestListeners().iterator(); iterator.hasNext(); ((HarvestLifecycleAware)iterator.next()).onHarvestError()) { }
        }
        catch (Exception exception)
        {
            log.error("Error in fireOnHarvestError", exception);
            AgentHealth.noticeException(exception);
        }
    }

    private void fireOnHarvestFinalize()
    {
        try
        {
            for (Iterator iterator = getHarvestListeners().iterator(); iterator.hasNext(); ((HarvestLifecycleAware)iterator.next()).onHarvestFinalize()) { }
        }
        catch (Exception exception)
        {
            log.error("Error in fireOnHarvestFinalize", exception);
            AgentHealth.noticeException(exception);
        }
    }

    private void fireOnHarvestSendFailed()
    {
        try
        {
            for (Iterator iterator = getHarvestListeners().iterator(); iterator.hasNext(); ((HarvestLifecycleAware)iterator.next()).onHarvestSendFailed()) { }
        }
        catch (Exception exception)
        {
            log.error("Error in fireOnHarvestSendFailed", exception);
            AgentHealth.noticeException(exception);
        }
    }

    private void fireOnHarvestStart()
    {
        try
        {
            for (Iterator iterator = getHarvestListeners().iterator(); iterator.hasNext(); ((HarvestLifecycleAware)iterator.next()).onHarvestStart()) { }
        }
        catch (Exception exception)
        {
            log.error("Error in fireOnHarvestStart", exception);
            AgentHealth.noticeException(exception);
        }
    }

    private void fireOnHarvestStop()
    {
        try
        {
            for (Iterator iterator = getHarvestListeners().iterator(); iterator.hasNext(); ((HarvestLifecycleAware)iterator.next()).onHarvestStop()) { }
        }
        catch (Exception exception)
        {
            log.error("Error in fireOnHarvestStop", exception);
            AgentHealth.noticeException(exception);
        }
    }

    private Collection getHarvestListeners()
    {
        return new ArrayList(harvestListeners);
    }

    private HarvestConfiguration parseHarvesterConfiguration(HarvestResponse harvestresponse)
    {
        Object obj = new GsonBuilder();
        ((GsonBuilder) (obj)).registerTypeAdapter(com/newrelic/agent/android/activity/config/ActivityTraceConfiguration, new ActivityTraceConfigurationDeserializer());
        obj = ((GsonBuilder) (obj)).create();
        try
        {
            harvestresponse = (HarvestConfiguration)((Gson) (obj)).fromJson(harvestresponse.getResponseBody(), com/newrelic/agent/android/harvest/HarvestConfiguration);
        }
        // Misplaced declaration of an exception variable
        catch (HarvestResponse harvestresponse)
        {
            log.error((new StringBuilder()).append("Unable to parse collector configuration: ").append(harvestresponse.getMessage()).toString());
            AgentHealth.noticeException(harvestresponse);
            return null;
        }
        return harvestresponse;
    }

    private transient boolean stateIn(State state1, State astate[])
    {
        boolean flag1 = false;
        int j = astate.length;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < j)
                {
                    if (state1 != astate[i])
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i++;
        } while (true);
    }

    public void addHarvestListener(HarvestLifecycleAware harvestlifecycleaware)
    {
        if (harvestlifecycleaware == null)
        {
            log.error("Can't add null harvest listener");
            (new Exception()).printStackTrace();
            return;
        }
        synchronized (harvestListeners)
        {
            if (!harvestListeners.contains(harvestlifecycleaware))
            {
                break MISSING_BLOCK_LABEL_55;
            }
        }
        return;
        harvestlifecycleaware;
        collection;
        JVM INSTR monitorexit ;
        throw harvestlifecycleaware;
        harvestListeners.add(harvestlifecycleaware);
        collection;
        JVM INSTR monitorexit ;
    }

    protected void connected()
    {
        log.info("Harvester: connected");
        log.info((new StringBuilder()).append("Harvester: Sending ").append(harvestData.getHttpTransactions().count()).append(" HTTP transactions.").toString());
        log.info((new StringBuilder()).append("Harvester: Sending ").append(harvestData.getHttpErrors().count()).append(" HTTP errors.").toString());
        log.info((new StringBuilder()).append("Harvester: Sending ").append(harvestData.getActivityTraces().count()).append(" activity traces.").toString());
        harvestData.setAnalyticsEnabled(agentConfiguration.getEnableAnalyticsEvents());
        if (agentConfiguration.getEnableAnalyticsEvents() && FeatureFlag.featureEnabled(FeatureFlag.AnalyticsEvents))
        {
            EventManager eventmanager = AnalyticsControllerImpl.getInstance().getEventManager();
            if (eventmanager.isTransmitRequired())
            {
                Object obj1 = new HashSet();
                ((Set) (obj1)).addAll(AnalyticsControllerImpl.getInstance().getSystemAttributes());
                ((Set) (obj1)).addAll(AnalyticsControllerImpl.getInstance().getUserAttributes());
                harvestData.setSessionAttributes(((Set) (obj1)));
                log.info((new StringBuilder()).append("Harvester: Sending ").append(harvestData.getSessionAttributes().size()).append(" session attributes.").toString());
                obj1 = eventmanager.getQueuedEvents();
                harvestData.setAnalyticsEvents(((Collection) (obj1)));
                eventmanager.empty();
            }
            log.info((new StringBuilder()).append("Harvester: Sending ").append(harvestData.getAnalyticsEvents().size()).append(" analytics events.").toString());
        }
        Object obj = harvestConnection.sendData(harvestData);
        if (obj == null || ((HarvestResponse) (obj)).isUnknown())
        {
            fireOnHarvestSendFailed();
            return;
        }
        harvestData.reset();
        StatsEngine.get().sampleTimeMs("Supportability/AgentHealth/Collector/Harvest", ((HarvestResponse) (obj)).getResponseTime());
        log.debug((new StringBuilder()).append("Harvest data response: ").append(((HarvestResponse) (obj)).getResponseCode()).toString());
        log.debug((new StringBuilder()).append("Harvest data response status code: ").append(((HarvestResponse) (obj)).getStatusCode()).toString());
        log.debug((new StringBuilder()).append("Harvest data response BODY: ").append(((HarvestResponse) (obj)).getResponseBody()).toString());
        if (((HarvestResponse) (obj)).isError())
        {
            fireOnHarvestError();
            static class _cls1
            {

                static final int $SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code[];
                static final int $SwitchMap$com$newrelic$agent$android$harvest$Harvester$State[];

                static 
                {
                    $SwitchMap$com$newrelic$agent$android$harvest$Harvester$State = new int[State.values().length];
                    try
                    {
                        $SwitchMap$com$newrelic$agent$android$harvest$Harvester$State[State.UNINITIALIZED.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror8) { }
                    try
                    {
                        $SwitchMap$com$newrelic$agent$android$harvest$Harvester$State[State.DISCONNECTED.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror7) { }
                    try
                    {
                        $SwitchMap$com$newrelic$agent$android$harvest$Harvester$State[State.CONNECTED.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror6) { }
                    try
                    {
                        $SwitchMap$com$newrelic$agent$android$harvest$Harvester$State[State.DISABLED.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    $SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code = new int[HarvestResponse.Code.values().length];
                    try
                    {
                        $SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code[HarvestResponse.Code.UNAUTHORIZED.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        $SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code[HarvestResponse.Code.INVALID_AGENT_ID.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code[HarvestResponse.Code.FORBIDDEN.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code[HarvestResponse.Code.UNSUPPORTED_MEDIA_TYPE.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code[HarvestResponse.Code.ENTITY_TOO_LARGE.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1..SwitchMap.com.newrelic.agent.android.harvest.HarvestResponse.Code[((HarvestResponse) (obj)).getResponseCode().ordinal()])
            {
            default:
                log.error("An unknown error occurred when connecting to the Collector.");
                return;

            case 1: // '\001'
            case 2: // '\002'
                harvestData.getDataToken().clear();
                transition(State.DISCONNECTED);
                return;

            case 3: // '\003'
                if (((HarvestResponse) (obj)).isDisableCommand())
                {
                    log.error("Collector has commanded Agent to disable.");
                    transition(State.DISABLED);
                    return;
                } else
                {
                    log.error("Unexpected Collector response: FORBIDDEN");
                    transition(State.DISCONNECTED);
                    return;
                }

            case 4: // '\004'
            case 5: // '\005'
                log.error("Invalid ConnectionInformation was sent to the Collector.");
                return;
            }
        }
        obj = parseHarvesterConfiguration(((HarvestResponse) (obj)));
        if (obj == null)
        {
            log.error("Unable to configure Harvester using Collector configuration.");
            return;
        } else
        {
            configureHarvester(((HarvestConfiguration) (obj)));
            fireOnHarvestComplete();
            return;
        }
    }

    protected void disabled()
    {
        Harvest.stop();
        fireOnHarvestDisabled();
    }

    protected void disconnected()
    {
        HarvestResponse harvestresponse;
        if (configuration == null)
        {
            configureHarvester(HarvestConfiguration.getDefaultHarvestConfiguration());
        }
        if (harvestData.isValid())
        {
            log.verbose((new StringBuilder()).append("Skipping connect call, saved state is available: ").append(harvestData.getDataToken()).toString());
            StatsEngine.get().sample("Session/Start", 1.0F);
            fireOnHarvestConnected();
            transition(State.CONNECTED);
            execute();
            return;
        }
        log.info((new StringBuilder()).append("Connecting, saved state is not available: ").append(harvestData.getDataToken()).toString());
        harvestresponse = harvestConnection.sendConnect();
        if (harvestresponse == null)
        {
            log.error("Unable to connect to the Collector.");
            return;
        }
        if (harvestresponse.isOK())
        {
            HarvestConfiguration harvestconfiguration = parseHarvesterConfiguration(harvestresponse);
            if (harvestconfiguration == null)
            {
                log.error("Unable to configure Harvester using Collector configuration.");
                return;
            } else
            {
                configureHarvester(harvestconfiguration);
                StatsEngine.get().sampleTimeMs("Supportability/AgentHealth/Collector/Harvest", harvestresponse.getResponseTime());
                fireOnHarvestConnected();
                transition(State.CONNECTED);
                return;
            }
        }
        log.debug((new StringBuilder()).append("Harvest connect response: ").append(harvestresponse.getResponseCode()).toString());
        _cls1..SwitchMap.com.newrelic.agent.android.harvest.HarvestResponse.Code[harvestresponse.getResponseCode().ordinal()];
        JVM INSTR tableswitch 1 5: default 284
    //                   1 301
    //                   2 301
    //                   3 316
    //                   4 362
    //                   5 362;
           goto _L1 _L2 _L2 _L3 _L4 _L4
_L1:
        log.error("An unknown error occurred when connecting to the Collector.");
_L6:
        fireOnHarvestError();
        return;
_L2:
        harvestData.getDataToken().clear();
        fireOnHarvestDisconnected();
        return;
_L3:
        if (harvestresponse.isDisableCommand())
        {
            log.error("Collector has commanded Agent to disable.");
            fireOnHarvestDisabled();
            transition(State.DISABLED);
            return;
        }
        log.error("Unexpected Collector response: FORBIDDEN");
        continue; /* Loop/switch isn't completed */
_L4:
        log.error("Invalid ConnectionInformation was sent to the Collector.");
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void execute()
    {
        log.debug((new StringBuilder()).append("Harvester state: ").append(state).toString());
        stateChanged = false;
        expireHarvestData();
        _cls1..SwitchMap.com.newrelic.agent.android.harvest.Harvester.State[state.ordinal()];
        JVM INSTR tableswitch 1 4: default 150
    //                   1 111
    //                   2 116
    //                   3 125
    //                   4 145;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        Exception exception;
        throw new IllegalStateException();
_L2:
        try
        {
            uninitialized();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            log.error("Exception encountered while attempting to harvest", exception);
            AgentHealth.noticeException(exception);
            return;
        }
_L3:
        fireOnHarvestBefore();
        disconnected();
        return;
_L4:
        fireOnHarvestBefore();
        fireOnHarvest();
        fireOnHarvestFinalize();
        TaskQueue.synchronousDequeue();
        connected();
        return;
_L5:
        disabled();
        return;
    }

    public void expireActivityTraces()
    {
        ActivityTraces activitytraces = harvestData.getActivityTraces();
        activitytraces;
        JVM INSTR monitorenter ;
        Object obj;
        obj = new ArrayList();
        long l = configuration.getActivity_trace_max_report_attempts();
        Iterator iterator = activitytraces.getActivityTraces().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ActivityTrace activitytrace = (ActivityTrace)iterator.next();
            if (activitytrace.getReportAttemptCount() >= l)
            {
                log.debug((new StringBuilder()).append("ActivityTrace has had ").append(activitytrace.getReportAttemptCount()).append(" report attempts, purging: ").append(activitytrace).toString());
                ((Collection) (obj)).add(activitytrace);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_130;
        obj;
        activitytraces;
        JVM INSTR monitorexit ;
        throw obj;
        for (obj = ((Collection) (obj)).iterator(); ((Iterator) (obj)).hasNext(); activitytraces.remove((ActivityTrace)((Iterator) (obj)).next())) { }
        activitytraces;
        JVM INSTR monitorexit ;
    }

    public void expireHarvestData()
    {
        expireHttpErrors();
        expireHttpTransactions();
        expireActivityTraces();
    }

    public void expireHttpErrors()
    {
        HttpErrors httperrors = harvestData.getHttpErrors();
        httperrors;
        JVM INSTR monitorenter ;
        Object obj;
        obj = new ArrayList();
        long l = System.currentTimeMillis();
        long l1 = configuration.getReportMaxTransactionAgeMilliseconds();
        Iterator iterator = httperrors.getHttpErrors().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            HttpError httperror = (HttpError)iterator.next();
            if (httperror.getTimestamp().longValue() < l - l1)
            {
                log.debug((new StringBuilder()).append("HttpError too old, purging: ").append(httperror).toString());
                ((Collection) (obj)).add(httperror);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_126;
        obj;
        httperrors;
        JVM INSTR monitorexit ;
        throw obj;
        for (obj = ((Collection) (obj)).iterator(); ((Iterator) (obj)).hasNext(); httperrors.removeHttpError((HttpError)((Iterator) (obj)).next())) { }
        httperrors;
        JVM INSTR monitorexit ;
    }

    public void expireHttpTransactions()
    {
        HttpTransactions httptransactions = harvestData.getHttpTransactions();
        httptransactions;
        JVM INSTR monitorenter ;
        Object obj;
        obj = new ArrayList();
        long l = System.currentTimeMillis();
        long l1 = configuration.getReportMaxTransactionAgeMilliseconds();
        Iterator iterator = httptransactions.getHttpTransactions().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            HttpTransaction httptransaction = (HttpTransaction)iterator.next();
            if (httptransaction.getTimestamp().longValue() < l - l1)
            {
                log.debug((new StringBuilder()).append("HttpTransaction too old, purging: ").append(httptransaction).toString());
                ((Collection) (obj)).add(httptransaction);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_126;
        obj;
        httptransactions;
        JVM INSTR monitorexit ;
        throw obj;
        for (obj = ((Collection) (obj)).iterator(); ((Iterator) (obj)).hasNext(); httptransactions.remove((HttpTransaction)((Iterator) (obj)).next())) { }
        httptransactions;
        JVM INSTR monitorexit ;
    }

    public State getCurrentState()
    {
        return state;
    }

    public HarvestConnection getHarvestConnection()
    {
        return harvestConnection;
    }

    public HarvestData getHarvestData()
    {
        return harvestData;
    }

    public boolean isDisabled()
    {
        return State.DISABLED == state;
    }

    public void removeHarvestListener(HarvestLifecycleAware harvestlifecycleaware)
    {
label0:
        {
            synchronized (harvestListeners)
            {
                if (harvestListeners.contains(harvestlifecycleaware))
                {
                    break label0;
                }
            }
            return;
        }
        harvestListeners.remove(harvestlifecycleaware);
        collection;
        JVM INSTR monitorexit ;
        return;
        harvestlifecycleaware;
        collection;
        JVM INSTR monitorexit ;
        throw harvestlifecycleaware;
    }

    public void setAgentConfiguration(AgentConfiguration agentconfiguration)
    {
        agentConfiguration = agentconfiguration;
    }

    public void setConfiguration(HarvestConfiguration harvestconfiguration)
    {
        configuration = harvestconfiguration;
    }

    public void setHarvestConnection(HarvestConnection harvestconnection)
    {
        harvestConnection = harvestconnection;
    }

    public void setHarvestData(HarvestData harvestdata)
    {
        harvestData = harvestdata;
    }

    public void start()
    {
        fireOnHarvestStart();
    }

    public void stop()
    {
        fireOnHarvestStop();
    }

    protected void transition(State state1)
    {
        if (!stateChanged) goto _L2; else goto _L1
_L1:
        log.debug((new StringBuilder()).append("Ignoring multiple transition: ").append(state1).toString());
_L4:
        return;
_L2:
        if (state == state1) goto _L4; else goto _L3
_L3:
        _cls1..SwitchMap.com.newrelic.agent.android.harvest.Harvester.State[state.ordinal()];
        JVM INSTR tableswitch 1 3: default 84
    //                   1 92
    //                   2 140
    //                   3 178;
           goto _L5 _L6 _L7 _L8
_L5:
        throw new IllegalStateException();
_L6:
        if (!stateIn(state1, new State[] {
            State.DISCONNECTED, state1, State.CONNECTED, State.DISABLED
        })) goto _L10; else goto _L9
_L9:
        changeState(state1);
        return;
_L10:
        throw new IllegalStateException();
_L7:
        if (!stateIn(state1, new State[] {
    State.UNINITIALIZED, State.CONNECTED, State.DISABLED
}))
        {
            throw new IllegalStateException();
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (!stateIn(state1, new State[] {
    State.DISCONNECTED, State.DISABLED
}))
        {
            throw new IllegalStateException();
        }
        if (true) goto _L9; else goto _L11
_L11:
    }

    protected void uninitialized()
    {
        if (agentConfiguration == null)
        {
            log.error("Agent configuration unavailable.");
            return;
        }
        if (Agent.getImpl().updateSavedConnectInformation())
        {
            configureHarvester(HarvestConfiguration.getDefaultHarvestConfiguration());
            harvestData.getDataToken().clear();
        }
        Harvest.setHarvestConnectInformation(new ConnectInformation(Agent.getApplicationInformation(), Agent.getDeviceInformation()));
        harvestConnection.setApplicationToken(agentConfiguration.getApplicationToken());
        harvestConnection.setCollectorHost(agentConfiguration.getCollectorHost());
        harvestConnection.useSsl(agentConfiguration.useSsl());
        transition(State.DISCONNECTED);
        execute();
    }
}
