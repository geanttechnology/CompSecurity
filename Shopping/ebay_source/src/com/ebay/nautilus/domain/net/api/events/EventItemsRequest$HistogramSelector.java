// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.events;


// Referenced classes of package com.ebay.nautilus.domain.net.api.events:
//            EventItemsRequest

public static final class Q extends Enum
{

    private static final ASPECT_HISTOGRAM $VALUES[];
    public static final ASPECT_HISTOGRAM ASPECT_HISTOGRAM;
    public static final ASPECT_HISTOGRAM CATEGORY_HISTOGRAM;

    public static Q valueOf(String s)
    {
        return (Q)Enum.valueOf(com/ebay/nautilus/domain/net/api/events/EventItemsRequest$HistogramSelector, s);
    }

    public static Q[] values()
    {
        return (Q[])$VALUES.clone();
    }

    static 
    {
        CATEGORY_HISTOGRAM = new <init>("CATEGORY_HISTOGRAM", 0);
        ASPECT_HISTOGRAM = new <init>("ASPECT_HISTOGRAM", 1);
        $VALUES = (new .VALUES[] {
            CATEGORY_HISTOGRAM, ASPECT_HISTOGRAM
        });
    }

    private Q(String s, int i)
    {
        super(s, i);
    }
}
