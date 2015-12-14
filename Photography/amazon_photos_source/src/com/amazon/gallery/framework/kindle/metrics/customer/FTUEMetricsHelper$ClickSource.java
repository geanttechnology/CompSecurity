// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.metrics.customer;


// Referenced classes of package com.amazon.gallery.framework.kindle.metrics.customer:
//            FTUEMetricsHelper

public static final class  extends Enum
{

    private static final MOBILE_CLICK $VALUES[];
    public static final MOBILE_CLICK DESKTOP_CLICK;
    public static final MOBILE_CLICK FACEBOOK_CLICK;
    public static final MOBILE_CLICK MOBILE_CLICK;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/kindle/metrics/customer/FTUEMetricsHelper$ClickSource, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        FACEBOOK_CLICK = new <init>("FACEBOOK_CLICK", 0);
        DESKTOP_CLICK = new <init>("DESKTOP_CLICK", 1);
        MOBILE_CLICK = new <init>("MOBILE_CLICK", 2);
        $VALUES = (new .VALUES[] {
            FACEBOOK_CLICK, DESKTOP_CLICK, MOBILE_CLICK
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
