// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.metrics;


// Referenced classes of package com.amazon.gallery.framework.gallery.metrics:
//            NavigationMetrics

private static final class  extends Enum
{

    private static final COLLECTION_TIMER $VALUES[];
    public static final COLLECTION_TIMER COLLECTION_TIMER;
    public static final COLLECTION_TIMER SINGLE_VIEW_TIMER;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/gallery/metrics/NavigationMetrics$TimerType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SINGLE_VIEW_TIMER = new <init>("SINGLE_VIEW_TIMER", 0);
        COLLECTION_TIMER = new <init>("COLLECTION_TIMER", 1);
        $VALUES = (new .VALUES[] {
            SINGLE_VIEW_TIMER, COLLECTION_TIMER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
