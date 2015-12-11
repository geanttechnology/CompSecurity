// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.analytics;

import java.util.List;

// Referenced classes of package com.newrelic.agent.android.analytics:
//            AnalyticAttribute

public interface AnalyticAttributeStore
{

    public abstract void clear();

    public abstract int count();

    public abstract void delete(AnalyticAttribute analyticattribute);

    public abstract List fetchAll();

    public abstract boolean store(AnalyticAttribute analyticattribute);
}
