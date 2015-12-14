// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.abtest.cache;

import com.amazon.insights.core.InsightsContext;

// Referenced classes of package com.amazon.insights.abtest.cache:
//            FileVariationCache, VariationCache

public class VariationCaches
{

    public static VariationCache tryGetFileVariationCache(InsightsContext insightscontext)
    {
        return new FileVariationCache(insightscontext);
    }
}
