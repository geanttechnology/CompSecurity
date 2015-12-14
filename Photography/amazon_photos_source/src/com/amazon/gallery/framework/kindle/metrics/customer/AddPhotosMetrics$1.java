// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.metrics.customer;


// Referenced classes of package com.amazon.gallery.framework.kindle.metrics.customer:
//            AddPhotosMetrics

static class lickSource
{

    static final int $SwitchMap$com$amazon$gallery$framework$kindle$metrics$customer$FTUEMetricsHelper$ClickSource[];

    static 
    {
        $SwitchMap$com$amazon$gallery$framework$kindle$metrics$customer$FTUEMetricsHelper$ClickSource = new int[lickSource.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$kindle$metrics$customer$FTUEMetricsHelper$ClickSource[lickSource.FACEBOOK_CLICK.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$kindle$metrics$customer$FTUEMetricsHelper$ClickSource[lickSource.DESKTOP_CLICK.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$kindle$metrics$customer$FTUEMetricsHelper$ClickSource[lickSource.MOBILE_CLICK.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
