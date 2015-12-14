// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.metrics.customer;


// Referenced classes of package com.amazon.gallery.framework.kindle.metrics.customer:
//            FTUEMetrics

static class per.ClickSource
{

    static final int $SwitchMap$com$amazon$gallery$framework$kindle$metrics$customer$FTUEMetrics$MetricsEventType[];
    static final int $SwitchMap$com$amazon$gallery$framework$kindle$metrics$customer$FTUEMetricsHelper$ClickSource[];

    static 
    {
        $SwitchMap$com$amazon$gallery$framework$kindle$metrics$customer$FTUEMetrics$MetricsEventType = new int[tricsEventType.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$kindle$metrics$customer$FTUEMetrics$MetricsEventType[tricsEventType.PMET.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$kindle$metrics$customer$FTUEMetrics$MetricsEventType[tricsEventType.PMET_CLICKSTREAM.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        $SwitchMap$com$amazon$gallery$framework$kindle$metrics$customer$FTUEMetricsHelper$ClickSource = new int[per.ClickSource.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$kindle$metrics$customer$FTUEMetricsHelper$ClickSource[per.ClickSource.FACEBOOK_CLICK.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$kindle$metrics$customer$FTUEMetricsHelper$ClickSource[per.ClickSource.DESKTOP_CLICK.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$kindle$metrics$customer$FTUEMetricsHelper$ClickSource[per.ClickSource.MOBILE_CLICK.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
