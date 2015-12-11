// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.tracing.ActivityTrace;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceLifecycleAware;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.newrelic.agent.android.analytics:
//            AnalyticsControllerImpl, AnalyticAttribute, AnalyticsEventCategory, AnalyticsEventFactory, 
//            AnalyticsController, AnalyticsEvent

class this._cls0
    implements TraceLifecycleAware
{

    final AnalyticsControllerImpl this$0;

    private AnalyticsEvent createTraceEvent(ActivityTrace activitytrace)
    {
        float f = activitytrace.rootTrace.getDurationAsSeconds();
        HashSet hashset = new HashSet();
        hashset.add(new AnalyticAttribute("interactionDuration", f));
        return AnalyticsEventFactory.createEvent(activitytrace.rootTrace.displayName, AnalyticsEventCategory.Interaction, "Mobile", hashset);
    }

    public void onEnterMethod()
    {
    }

    public void onExitMethod()
    {
    }

    public void onTraceComplete(ActivityTrace activitytrace)
    {
        AnalyticsControllerImpl.log.verbose("AnalyticsControllerImpl.InteractionCompleteListener.onTraceComplete invoke.");
        activitytrace = createTraceEvent(activitytrace);
        AnalyticsControllerImpl.getInstance().addEvent(activitytrace);
    }

    public void onTraceStart(ActivityTrace activitytrace)
    {
    }

    ()
    {
        this$0 = AnalyticsControllerImpl.this;
        super();
    }
}
