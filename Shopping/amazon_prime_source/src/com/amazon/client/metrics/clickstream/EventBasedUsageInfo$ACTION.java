// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.clickstream;


// Referenced classes of package com.amazon.client.metrics.clickstream:
//            EventBasedUsageInfo

public static final class  extends Enum
{

    private static final CONSUMPTION $VALUES[];
    public static final CONSUMPTION CONSUMPTION;
    public static final CONSUMPTION DISCOVERY;
    public static final CONSUMPTION INTENTION;
    public static final CONSUMPTION TRANSACTION;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/client/metrics/clickstream/EventBasedUsageInfo$ACTION, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        INTENTION = new <init>("INTENTION", 0);
        DISCOVERY = new <init>("DISCOVERY", 1);
        TRANSACTION = new <init>("TRANSACTION", 2);
        CONSUMPTION = new <init>("CONSUMPTION", 3);
        $VALUES = (new .VALUES[] {
            INTENTION, DISCOVERY, TRANSACTION, CONSUMPTION
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
