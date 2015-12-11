// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.tracing;

import com.newrelic.agent.android.instrumentation.MetricCategory;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.util.Util;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.newrelic.agent.android.tracing:
//            TraceType, TracingInactiveException, TraceMachine

public class Trace
{

    private static final String CATEGORY_PARAMETER = "category";
    private static final AgentLog log = AgentLogManager.getAgentLog();
    public long childExclusiveTime;
    private volatile Set children;
    public String displayName;
    public long entryTimestamp;
    public long exclusiveTime;
    public long exitTimestamp;
    private boolean isComplete;
    public String metricBackgroundName;
    public String metricName;
    public final UUID myUUID;
    private volatile Map params;
    public final UUID parentUUID;
    private List rawAnnotationParams;
    public String scope;
    public long threadId;
    public String threadName;
    public TraceMachine traceMachine;
    private TraceType type;

    public Trace()
    {
        myUUID = new UUID(Util.getRandom().nextLong(), Util.getRandom().nextLong());
        entryTimestamp = 0L;
        exitTimestamp = 0L;
        exclusiveTime = 0L;
        childExclusiveTime = 0L;
        threadId = 0L;
        threadName = "main";
        type = TraceType.TRACE;
        isComplete = false;
        parentUUID = null;
    }

    public Trace(String s, UUID uuid, TraceMachine tracemachine)
    {
        myUUID = new UUID(Util.getRandom().nextLong(), Util.getRandom().nextLong());
        entryTimestamp = 0L;
        exitTimestamp = 0L;
        exclusiveTime = 0L;
        childExclusiveTime = 0L;
        threadId = 0L;
        threadName = "main";
        type = TraceType.TRACE;
        isComplete = false;
        displayName = s;
        parentUUID = uuid;
        traceMachine = tracemachine;
    }

    private static Object createParameter(String s, String s1, String s2)
    {
        try
        {
            s = Class.forName(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log.error((new StringBuilder()).append("Unable to resolve parameter class in enterMethod: ").append(s.getMessage()).toString(), s);
            return null;
        }
        if (com/newrelic/agent/android/instrumentation/MetricCategory == s)
        {
            s2 = MetricCategory.valueOf(s2);
        } else
        if (java/lang/String != s)
        {
            return null;
        }
        return s2;
    }

    public void addChild(Trace trace)
    {
        if (children != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (children == null)
        {
            children = Collections.synchronizedSet(new HashSet());
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        children.add(trace.myUUID);
        return;
        trace;
        this;
        JVM INSTR monitorexit ;
        throw trace;
    }

    public void complete()
        throws TracingInactiveException
    {
        if (isComplete)
        {
            log.warning((new StringBuilder()).append("Attempted to double complete trace ").append(myUUID.toString()).toString());
            return;
        }
        if (exitTimestamp == 0L)
        {
            exitTimestamp = System.currentTimeMillis();
        }
        exclusiveTime = getDurationAsMilliseconds() - childExclusiveTime;
        isComplete = true;
        try
        {
            traceMachine.storeCompletedTrace(this);
            return;
        }
        catch (NullPointerException nullpointerexception)
        {
            throw new TracingInactiveException();
        }
    }

    public Map getAnnotationParams()
    {
        HashMap hashmap = new HashMap();
        if (rawAnnotationParams != null && rawAnnotationParams.size() > 0)
        {
            Iterator iterator = rawAnnotationParams.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s = (String)iterator.next();
                Object obj = createParameter(s, (String)iterator.next(), (String)iterator.next());
                if (obj != null)
                {
                    hashmap.put(s, obj);
                }
            } while (true);
        }
        return hashmap;
    }

    public MetricCategory getCategory()
    {
        if (!getAnnotationParams().containsKey("category"))
        {
            return null;
        }
        Object obj = getAnnotationParams().get("category");
        if (!(obj instanceof MetricCategory))
        {
            log.error("Category annotation parameter is not of type MetricCategory");
            return null;
        } else
        {
            return (MetricCategory)obj;
        }
    }

    public Set getChildren()
    {
        if (children != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (children == null)
        {
            children = Collections.synchronizedSet(new HashSet());
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        return children;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public long getDurationAsMilliseconds()
    {
        return exitTimestamp - entryTimestamp;
    }

    public float getDurationAsSeconds()
    {
        return (float)(exitTimestamp - entryTimestamp) / 1000F;
    }

    public Map getParams()
    {
        if (params != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (params == null)
        {
            params = new ConcurrentHashMap();
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        return params;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public TraceType getType()
    {
        return type;
    }

    public boolean isComplete()
    {
        return isComplete;
    }

    public void prepareForSerialization()
    {
        getParams().put("type", type.toString());
    }

    public void setAnnotationParams(List list)
    {
        rawAnnotationParams = list;
    }

    public void setType(TraceType tracetype)
    {
        type = tracetype;
    }

}
