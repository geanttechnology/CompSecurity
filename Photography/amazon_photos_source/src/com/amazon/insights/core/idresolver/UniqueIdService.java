// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.idresolver;

import com.amazon.insights.core.InsightsContext;

// Referenced classes of package com.amazon.insights.core.idresolver:
//            Id

public interface UniqueIdService
{

    public abstract Id getUniqueId(InsightsContext insightscontext);
}
