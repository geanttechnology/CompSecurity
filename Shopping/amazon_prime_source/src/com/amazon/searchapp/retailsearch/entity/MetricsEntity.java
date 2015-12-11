// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Metrics;
import java.util.Map;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class MetricsEntity extends RetailSearchEntity
    implements Metrics
{

    private Map latencies;

    public MetricsEntity()
    {
    }

    public Map getLatencies()
    {
        return latencies;
    }

    public void setLatencies(Map map)
    {
        latencies = map;
    }
}
