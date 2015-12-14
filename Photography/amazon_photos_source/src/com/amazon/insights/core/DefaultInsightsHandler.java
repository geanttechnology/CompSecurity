// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core;

import com.amazon.insights.InsightsCallback;
import com.amazon.insights.InsightsHandler;
import com.amazon.insights.error.InsightsError;

public class DefaultInsightsHandler
    implements InsightsHandler
{

    private InsightsCallback callback;
    private InsightsError error;
    private Object response;

    public DefaultInsightsHandler()
    {
        callback = null;
        response = null;
        error = null;
    }

    public void onComplete(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        response = obj;
        obj = callback;
        if (obj != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (response != null)
        {
            callback.onComplete(response);
        }
        if (true) goto _L1; else goto _L3
_L3:
        obj;
        throw obj;
    }

    public void onError(InsightsError insightserror)
    {
        this;
        JVM INSTR monitorenter ;
        error = insightserror;
        insightserror = callback;
        if (insightserror != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (error != null)
        {
            callback.onError(error);
        }
        if (true) goto _L1; else goto _L3
_L3:
        insightserror;
        throw insightserror;
    }

    public void setCallback(InsightsCallback insightscallback)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        if (callback != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        callback = insightscallback;
        if (flag) goto _L2; else goto _L1
_L1:
        if (response == null) goto _L4; else goto _L3
_L3:
        onComplete(response);
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        if (error != null)
        {
            onError(error);
        }
        if (true) goto _L2; else goto _L5
_L5:
        insightscallback;
        throw insightscallback;
    }
}
