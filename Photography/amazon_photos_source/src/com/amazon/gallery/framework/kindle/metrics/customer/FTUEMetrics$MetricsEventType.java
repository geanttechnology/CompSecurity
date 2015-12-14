// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.metrics.customer;


// Referenced classes of package com.amazon.gallery.framework.kindle.metrics.customer:
//            FTUEMetrics

private static final class  extends Enum
{

    private static final PMET_CLICKSTREAM $VALUES[];
    public static final PMET_CLICKSTREAM PMET;
    public static final PMET_CLICKSTREAM PMET_CLICKSTREAM;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/kindle/metrics/customer/FTUEMetrics$MetricsEventType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PMET = new <init>("PMET", 0);
        PMET_CLICKSTREAM = new <init>("PMET_CLICKSTREAM", 1);
        $VALUES = (new .VALUES[] {
            PMET, PMET_CLICKSTREAM
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
