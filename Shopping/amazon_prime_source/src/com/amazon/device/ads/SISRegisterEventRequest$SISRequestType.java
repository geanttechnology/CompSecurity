// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            SISRegisterEventRequest

static final class  extends Enum
{

    private static final REGISTER_EVENT $VALUES[];
    public static final REGISTER_EVENT GENERATE_DID;
    public static final REGISTER_EVENT REGISTER_EVENT;
    public static final REGISTER_EVENT UPDATE_DEVICE_INFO;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/device/ads/SISRegisterEventRequest$SISRequestType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        GENERATE_DID = new <init>("GENERATE_DID", 0);
        UPDATE_DEVICE_INFO = new <init>("UPDATE_DEVICE_INFO", 1);
        REGISTER_EVENT = new <init>("REGISTER_EVENT", 2);
        $VALUES = (new .VALUES[] {
            GENERATE_DID, UPDATE_DEVICE_INFO, REGISTER_EVENT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
