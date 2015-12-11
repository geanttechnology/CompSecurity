// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AdError

public static final class  extends Enum
{

    private static final REQUEST_ERROR $VALUES[];
    public static final REQUEST_ERROR INTERNAL_ERROR;
    public static final REQUEST_ERROR NETWORK_ERROR;
    public static final REQUEST_ERROR NETWORK_TIMEOUT;
    public static final REQUEST_ERROR NO_FILL;
    public static final REQUEST_ERROR REQUEST_ERROR;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/device/ads/AdError$ErrorCode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NETWORK_ERROR = new <init>("NETWORK_ERROR", 0);
        NETWORK_TIMEOUT = new <init>("NETWORK_TIMEOUT", 1);
        NO_FILL = new <init>("NO_FILL", 2);
        INTERNAL_ERROR = new <init>("INTERNAL_ERROR", 3);
        REQUEST_ERROR = new <init>("REQUEST_ERROR", 4);
        $VALUES = (new .VALUES[] {
            NETWORK_ERROR, NETWORK_TIMEOUT, NO_FILL, INTERNAL_ERROR, REQUEST_ERROR
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
