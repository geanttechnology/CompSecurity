// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;


// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPDiscoveryClient

static final class  extends Enum
{

    private static final TPSDK_DISC_FATAL_ERR $VALUES[];
    public static final TPSDK_DISC_FATAL_ERR TPSDK_DISC_COMPLETE_SUCCESS;
    public static final TPSDK_DISC_FATAL_ERR TPSDK_DISC_ERR;
    public static final TPSDK_DISC_FATAL_ERR TPSDK_DISC_FATAL_ERR;
    public static final TPSDK_DISC_FATAL_ERR TPSDK_DISC_INIT;
    public static final TPSDK_DISC_FATAL_ERR TPSDK_DISC_SENT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/twinprime/TwinPrimeSDK/TPDiscoveryClient$TPDiscState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TPSDK_DISC_INIT = new <init>("TPSDK_DISC_INIT", 0);
        TPSDK_DISC_SENT = new <init>("TPSDK_DISC_SENT", 1);
        TPSDK_DISC_COMPLETE_SUCCESS = new <init>("TPSDK_DISC_COMPLETE_SUCCESS", 2);
        TPSDK_DISC_ERR = new <init>("TPSDK_DISC_ERR", 3);
        TPSDK_DISC_FATAL_ERR = new <init>("TPSDK_DISC_FATAL_ERR", 4);
        $VALUES = (new .VALUES[] {
            TPSDK_DISC_INIT, TPSDK_DISC_SENT, TPSDK_DISC_COMPLETE_SUCCESS, TPSDK_DISC_ERR, TPSDK_DISC_FATAL_ERR
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
