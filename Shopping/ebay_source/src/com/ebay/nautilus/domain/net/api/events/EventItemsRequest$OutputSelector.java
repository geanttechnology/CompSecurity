// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.events;


// Referenced classes of package com.ebay.nautilus.domain.net.api.events:
//            EventItemsRequest

public static final class  extends Enum
{

    private static final itemWithShippingInfo $VALUES[];
    public static final itemWithShippingInfo itemWithShippingInfo;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/events/EventItemsRequest$OutputSelector, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        itemWithShippingInfo = new <init>("itemWithShippingInfo", 0);
        $VALUES = (new .VALUES[] {
            itemWithShippingInfo
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
