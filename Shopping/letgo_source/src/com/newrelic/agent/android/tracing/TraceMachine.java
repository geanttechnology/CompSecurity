// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.tracing;

import com.newrelic.agent.android.Measurements;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.api.v2.TraceMachineInterface;
import com.newrelic.agent.android.harvest.ActivityHistory;
import com.newrelic.agent.android.harvest.ActivitySighting;
import com.newrelic.agent.android.harvest.AgentHealth;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.HarvestAdapter;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.newrelic.agent.android.tracing:
//            ActivityTrace, TracingInactiveException, Trace, TraceLifecycleAware, 
//            TraceType

public class TraceMachine extends HarvestAdapter
{
    private static class TraceStack extends Stack
    {

        private TraceStack()
        {
        }

    }


    public static final String ACTIVITY_BACKGROUND_METRIC_PREFIX = "Mobile/Activity/Background/Name/";
    public static final String ACTIVITY_METRIC_PREFIX = "Mobile/Activity/Name/";
    public static final String ACTIVTY_DISPLAY_NAME_PREFIX = "Display ";
    public static final int HEALTHY_TRACE_TIMEOUT = 500;
    public static final String NR_TRACE_FIELD = "_nr_trace";
    public static final String NR_TRACE_TYPE = "Lcom/newrelic/agent/android/tracing/Trace;";
    public static final int UNHEALTHY_TRACE_TIMEOUT = 60000;
    private static final List activityHistory = new CopyOnWriteArrayList();
    public static final AtomicBoolean disabled = new AtomicBoolean(false);
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private static final ThreadLocal threadLocalTrace = new ThreadLocal();
    private static final ThreadLocal threadLocalTraceStack = new ThreadLocal();
    private static final Collection traceListeners = new CopyOnWriteArrayList();
    private static TraceMachine traceMachine = null;
    private static TraceMachineInterface traceMachineInterface;
    private ActivityTrace activityTrace;

    protected TraceMachine(Trace trace)
    {
        activityTrace = new ActivityTrace(trace);
        Harvest.addHarvestListener(this);
    }

    public static void addTraceListener(TraceLifecycleAware tracelifecycleaware)
    {
        traceListeners.add(tracelifecycleaware);
    }

    public static void clearActivityHistory()
    {
        activityHistory.clear();
    }

    public static void endLastActivitySighting()
    {
        ActivitySighting activitysighting = getLastActivitySighting();
        if (activitysighting != null)
        {
            activitysighting.end(System.currentTimeMillis());
        }
    }

    public static void endTrace()
    {
        traceMachine.completeActivityTrace();
    }

    public static void endTrace(String s)
    {
        try
        {
            if (getActivityTrace().rootTrace.myUUID.toString().equals(s))
            {
                traceMachine.completeActivityTrace();
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    public static void enterMethod(Trace trace, String s, ArrayList arraylist)
    {
        if (isTracingInactive())
        {
            return;
        }
        long l;
        long l1;
        long l2;
        l = System.currentTimeMillis();
        l1 = traceMachine.activityTrace.lastUpdatedAt;
        l2 = traceMachine.activityTrace.startedAt;
        if (l1 + 500L >= l)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        if (!traceMachine.activityTrace.hasMissingChildren())
        {
            log.debug("Completing activity trace after hitting healthy timeout (500ms)");
            traceMachine.completeActivityTrace();
            return;
        }
        if (60000L + l2 < l)
        {
            try
            {
                log.debug("Completing activity trace after hitting unhealthy timeout (60000ms)");
                traceMachine.completeActivityTrace();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Trace trace)
            {
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Trace trace)
            {
                log.error("Caught error while calling enterMethod()", trace);
            }
            AgentHealth.noticeException(trace);
            return;
        }
        loadTraceContext(trace);
        trace = registerNewTrace(s);
        pushTraceContext(trace);
        trace.scope = getCurrentScope();
        trace.setAnnotationParams(arraylist);
        for (s = traceListeners.iterator(); s.hasNext(); ((TraceLifecycleAware)s.next()).onEnterMethod()) { }
        trace.entryTimestamp = System.currentTimeMillis();
        return;
    }

    public static void enterMethod(String s)
    {
        enterMethod(null, s, null);
    }

    public static void enterMethod(String s, ArrayList arraylist)
    {
        enterMethod(null, s, arraylist);
    }

    public static void enterNetworkSegment(String s)
    {
        if (isTracingInactive())
        {
            return;
        }
        try
        {
            if (getCurrentTrace().getType() == TraceType.NETWORK)
            {
                exitMethod();
            }
            enterMethod(null, s, null);
            getCurrentTrace().setType(TraceType.NETWORK);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log.error("Caught error while calling enterNetworkSegment()", s);
        }
        AgentHealth.noticeException(s);
        return;
    }

    public static void exitMethod()
    {
        if (isTracingInactive())
        {
            return;
        }
        Object obj = (Trace)threadLocalTrace.get();
        if (obj == null)
        {
            try
            {
                log.debug("threadLocalTrace is null");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                log.error("Caught error while calling exitMethod()", ((Throwable) (obj)));
            }
            AgentHealth.noticeException(((Exception) (obj)));
            return;
        }
        obj.exitTimestamp = System.currentTimeMillis();
        if (((Trace) (obj)).threadId == 0L && traceMachineInterface != null)
        {
            obj.threadId = traceMachineInterface.getCurrentThreadId();
            obj.threadName = traceMachineInterface.getCurrentThreadName();
        }
        for (Iterator iterator = traceListeners.iterator(); iterator.hasNext(); ((TraceLifecycleAware)iterator.next()).onExitMethod()) { }
        ((Trace) (obj)).complete();
        ((TraceStack)threadLocalTraceStack.get()).pop();
        if (!((TraceStack)threadLocalTraceStack.get()).empty())
        {
            break MISSING_BLOCK_LABEL_214;
        }
        threadLocalTrace.set(null);
_L1:
        if (((Trace) (obj)).getType() == TraceType.TRACE)
        {
            TaskQueue.queue(obj);
            return;
        }
        break MISSING_BLOCK_LABEL_253;
        TracingInactiveException tracinginactiveexception;
        tracinginactiveexception;
        threadLocalTrace.remove();
        threadLocalTraceStack.remove();
        if (((Trace) (obj)).getType() == TraceType.TRACE)
        {
            TaskQueue.queue(obj);
            return;
        }
        break MISSING_BLOCK_LABEL_253;
        Trace trace = (Trace)((TraceStack)threadLocalTraceStack.get()).peek();
        threadLocalTrace.set(trace);
        trace.childExclusiveTime = trace.childExclusiveTime + ((Trace) (obj)).getDurationAsMilliseconds();
          goto _L1
    }

    public static String formatActivityBackgroundMetricName(String s)
    {
        return (new StringBuilder()).append("Mobile/Activity/Background/Name/").append(s).toString();
    }

    public static String formatActivityDisplayName(String s)
    {
        return (new StringBuilder()).append("Display ").append(s).toString();
    }

    public static String formatActivityMetricName(String s)
    {
        return (new StringBuilder()).append("Mobile/Activity/Name/").append(s).toString();
    }

    public static ActivityHistory getActivityHistory()
    {
        return new ActivityHistory(activityHistory);
    }

    public static ActivityTrace getActivityTrace()
        throws TracingInactiveException
    {
        ActivityTrace activitytrace;
        try
        {
            activitytrace = traceMachine.activityTrace;
        }
        catch (NullPointerException nullpointerexception)
        {
            throw new TracingInactiveException();
        }
        return activitytrace;
    }

    public static String getCurrentScope()
    {
        if (isTracingInactive())
        {
            return null;
        }
        String s;
        try
        {
            if (traceMachineInterface == null || traceMachineInterface.isUIThread())
            {
                return traceMachine.activityTrace.rootTrace.metricName;
            }
            s = traceMachine.activityTrace.rootTrace.metricBackgroundName;
        }
        catch (Exception exception)
        {
            log.error("Caught error while calling getCurrentScope()", exception);
            AgentHealth.noticeException(exception);
            return null;
        }
        return s;
    }

    public static Trace getCurrentTrace()
        throws TracingInactiveException
    {
        if (isTracingInactive())
        {
            throw new TracingInactiveException();
        }
        Trace trace = (Trace)threadLocalTrace.get();
        if (trace != null)
        {
            return trace;
        } else
        {
            return getRootTrace();
        }
    }

    public static Map getCurrentTraceParams()
        throws TracingInactiveException
    {
        return getCurrentTrace().getParams();
    }

    public static ActivitySighting getLastActivitySighting()
    {
        if (activityHistory.isEmpty())
        {
            return null;
        } else
        {
            return (ActivitySighting)activityHistory.get(activityHistory.size() - 1);
        }
    }

    public static Trace getRootTrace()
        throws TracingInactiveException
    {
        Trace trace;
        try
        {
            trace = traceMachine.activityTrace.rootTrace;
        }
        catch (NullPointerException nullpointerexception)
        {
            throw new TracingInactiveException();
        }
        return trace;
    }

    public static TraceMachine getTraceMachine()
    {
        return traceMachine;
    }

    public static void haltTracing()
    {
        if (isTracingInactive())
        {
            return;
        } else
        {
            TraceMachine tracemachine = traceMachine;
            traceMachine = null;
            tracemachine.activityTrace.discard();
            endLastActivitySighting();
            Harvest.removeHarvestListener(tracemachine);
            threadLocalTrace.remove();
            threadLocalTraceStack.remove();
            return;
        }
    }

    public static boolean isTracingActive()
    {
        return traceMachine != null;
    }

    public static boolean isTracingInactive()
    {
        return traceMachine == null;
    }

    private static void loadTraceContext(Trace trace)
    {
        if (!isTracingInactive()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Trace trace1;
        if (threadLocalTrace.get() != null)
        {
            break; /* Loop/switch isn't completed */
        }
        threadLocalTrace.set(trace);
        threadLocalTraceStack.set(new TraceStack());
        if (trace == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ((TraceStack)threadLocalTraceStack.get()).push(trace);
        trace1 = trace;
_L4:
        if (log.getLevel() == 5)
        {
            log.debug((new StringBuilder()).append("Trace ").append(trace1.myUUID.toString()).append(" is now active").toString());
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        trace1 = trace;
        if (trace == null)
        {
            if (((TraceStack)threadLocalTraceStack.get()).isEmpty())
            {
                if (log.getLevel() == 5)
                {
                    log.debug("No context to load!");
                }
                threadLocalTrace.set(null);
                return;
            }
            trace1 = (Trace)((TraceStack)threadLocalTraceStack.get()).peek();
            threadLocalTrace.set(trace1);
        }
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    private static void pushTraceContext(Trace trace)
    {
        TraceStack tracestack;
        if (isTracingInactive() || trace == null)
        {
            return;
        }
        tracestack = (TraceStack)threadLocalTraceStack.get();
        if (!tracestack.empty()) goto _L2; else goto _L1
_L1:
        tracestack.push(trace);
_L4:
        threadLocalTrace.set(trace);
        return;
_L2:
        if (tracestack.peek() != trace)
        {
            tracestack.push(trace);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static Trace registerNewTrace(String s)
        throws TracingInactiveException
    {
        if (isTracingInactive())
        {
            log.debug("Tried to register a new trace but tracing is inactive!");
            throw new TracingInactiveException();
        }
        Trace trace = getCurrentTrace();
        Trace trace1 = new Trace(s, trace.myUUID, traceMachine);
        try
        {
            traceMachine.activityTrace.addTrace(trace1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new TracingInactiveException();
        }
        if (log.getLevel() == 5)
        {
            log.debug((new StringBuilder()).append("Registering trace of ").append(s).append(" with parent ").append(trace.displayName).toString());
        }
        trace.addChild(trace1);
        return trace1;
    }

    public static void removeTraceListener(TraceLifecycleAware tracelifecycleaware)
    {
        traceListeners.remove(tracelifecycleaware);
    }

    private static void renameActivityHistory(String s, String s1)
    {
        Iterator iterator = activityHistory.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ActivitySighting activitysighting = (ActivitySighting)iterator.next();
            if (activitysighting.getName().equals(s))
            {
                activitysighting.setName(s1);
            }
        } while (true);
    }

    public static void setCurrentDisplayName(String s)
    {
        if (isTracingInactive())
        {
            return;
        }
        try
        {
            getCurrentTrace().displayName = s;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    public static void setCurrentTraceParam(String s, Object obj)
    {
        if (isTracingInactive())
        {
            return;
        }
        try
        {
            getCurrentTrace().getParams().put(s, obj);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    public static void setRootDisplayName(String s)
    {
        if (isTracingInactive())
        {
            return;
        }
        try
        {
            Trace trace = getRootTrace();
            Measurements.renameActivity(trace.displayName, s);
            renameActivityHistory(trace.displayName, s);
            trace.metricName = formatActivityMetricName(s);
            trace.metricBackgroundName = formatActivityBackgroundMetricName(s);
            trace.displayName = s;
            getCurrentTrace().scope = getCurrentScope();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    public static void setTraceMachineInterface(TraceMachineInterface tracemachineinterface)
    {
        traceMachineInterface = tracemachineinterface;
    }

    public static void startTracing(String s)
    {
        startTracing(s, false);
    }

    public static void startTracing(String s, boolean flag)
    {
        if (disabled.get())
        {
            break MISSING_BLOCK_LABEL_294;
        }
        if (!Harvest.shouldCollectActivityTraces())
        {
            return;
        }
        Trace trace;
        try
        {
            if (isTracingActive())
            {
                traceMachine.completeActivityTrace();
            }
            threadLocalTrace.remove();
            threadLocalTraceStack.set(new TraceStack());
            trace = new Trace();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log.error("Caught error while initializing TraceMachine, shutting it down", s);
            AgentHealth.noticeException(s);
            traceMachine = null;
            threadLocalTrace.remove();
            threadLocalTraceStack.remove();
            return;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        trace.displayName = s;
_L4:
        trace.metricName = formatActivityMetricName(trace.displayName);
        trace.metricBackgroundName = formatActivityBackgroundMetricName(trace.displayName);
        trace.entryTimestamp = System.currentTimeMillis();
        if (log.getLevel() == 5)
        {
            log.debug((new StringBuilder()).append("Started trace of ").append(s).append(":").append(trace.myUUID.toString()).toString());
        }
        traceMachine = new TraceMachine(trace);
        trace.traceMachine = traceMachine;
        pushTraceContext(trace);
        traceMachine.activityTrace.previousActivity = getLastActivitySighting();
        activityHistory.add(new ActivitySighting(trace.entryTimestamp, trace.displayName));
        for (s = traceListeners.iterator(); s.hasNext(); ((TraceLifecycleAware)s.next()).onTraceStart(traceMachine.activityTrace)) { }
        break MISSING_BLOCK_LABEL_294;
_L2:
        trace.displayName = formatActivityDisplayName(s);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void unloadTraceContext(Object obj)
    {
        if (isTracingInactive())
        {
            return;
        }
        if (traceMachineInterface != null && traceMachineInterface.isUIThread())
        {
            break MISSING_BLOCK_LABEL_173;
        }
        if (threadLocalTrace.get() != null && log.getLevel() == 5)
        {
            log.debug((new StringBuilder()).append("Trace ").append(((Trace)threadLocalTrace.get()).myUUID.toString()).append(" is now inactive").toString());
        }
        threadLocalTrace.remove();
        threadLocalTraceStack.remove();
        try
        {
            ((TraceFieldInterface)obj)._nr_setTrace(null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        try
        {
            ExceptionHelper.recordSupportabilityMetric(((Exception) (obj)), "TraceFieldInterface");
            log.error((new StringBuilder()).append("Not a TraceFieldInterface: ").append(((ClassCastException) (obj)).getMessage()).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            log.error("Caught error while calling unloadTraceContext()", ((Throwable) (obj)));
        }
        AgentHealth.noticeException(((Exception) (obj)));
    }

    public void completeActivityTrace()
    {
        if (isTracingInactive())
        {
            return;
        }
        TraceMachine tracemachine = traceMachine;
        traceMachine = null;
        tracemachine.activityTrace.complete();
        endLastActivitySighting();
        for (Iterator iterator = traceListeners.iterator(); iterator.hasNext(); ((TraceLifecycleAware)iterator.next()).onTraceComplete(tracemachine.activityTrace)) { }
        Harvest.removeHarvestListener(tracemachine);
    }

    public void onHarvestBefore()
    {
        long l;
        long l1;
        long l2;
        if (!isTracingActive())
        {
            break MISSING_BLOCK_LABEL_112;
        }
        l = System.currentTimeMillis();
        l1 = traceMachine.activityTrace.lastUpdatedAt;
        l2 = traceMachine.activityTrace.startedAt;
        if (l1 + 500L >= l || traceMachine.activityTrace.hasMissingChildren()) goto _L2; else goto _L1
_L1:
        log.debug("Completing activity trace after hitting healthy timeout (500ms)");
        completeActivityTrace();
        StatsEngine.get().inc("Supportability/AgentHealth/HealthyActivityTraces");
_L4:
        return;
_L2:
        if (60000L + l2 >= l) goto _L4; else goto _L3
_L3:
        log.debug("Completing activity trace after hitting unhealthy timeout (60000ms)");
        completeActivityTrace();
        StatsEngine.get().inc("Supportability/AgentHealth/UnhealthyActivityTraces");
        return;
        log.debug("TraceMachine is inactive");
        return;
    }

    public void onHarvestSendFailed()
    {
        try
        {
            traceMachine.activityTrace.incrementReportAttemptCount();
            return;
        }
        catch (NullPointerException nullpointerexception)
        {
            return;
        }
    }

    public void storeCompletedTrace(Trace trace)
    {
        if (isTracingInactive())
        {
            log.debug("Attempted to store a completed trace with no trace machine!");
            return;
        }
        try
        {
            activityTrace.addCompletedTrace(trace);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Trace trace)
        {
            log.error("Caught error while calling storeCompletedTrace()", trace);
        }
        AgentHealth.noticeException(trace);
        return;
    }

}
