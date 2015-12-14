// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights;

import com.amazon.insights.core.log.Logger;
import com.amazon.insights.error.InsightsError;

public abstract class InsightsCallback
{

    private static final Logger logger = Logger.getLogger(com/amazon/insights/InsightsCallback);

    protected InsightsCallback()
    {
    }

    public abstract void onComplete(Object obj);

    public void onError(InsightsError insightserror)
    {
        logger.deve(insightserror.getMessage());
    }

}
