// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.metrics.clickstream;

import com.amazon.client.metrics.MetricsFactory;
import java.util.Map;

// Referenced classes of package com.amazon.gallery.framework.metrics.clickstream:
//            AbstractClickstreamRecorder

public class ComponentClickstreamRecorder extends AbstractClickstreamRecorder
{

    public ComponentClickstreamRecorder(String s, MetricsFactory metricsfactory)
    {
        super(s, metricsfactory);
    }

    public void recordEvent(String s, Map map)
    {
        recordClickstreamEvent(createUsageInfo("PhotosApp", (String)map.get("componentName"), (String)map.get("hitType"), s));
    }
}
