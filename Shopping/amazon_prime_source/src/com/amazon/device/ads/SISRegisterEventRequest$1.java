// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            SISRegisterEventRequest

static class SRequestType
{

    static final int $SwitchMap$com$amazon$device$ads$SISRegisterEventRequest$SISRequestType[];

    static 
    {
        $SwitchMap$com$amazon$device$ads$SISRegisterEventRequest$SISRequestType = new int[SRequestType.values().length];
        try
        {
            $SwitchMap$com$amazon$device$ads$SISRegisterEventRequest$SISRequestType[SRequestType.GENERATE_DID.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$device$ads$SISRegisterEventRequest$SISRequestType[SRequestType.UPDATE_DEVICE_INFO.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$device$ads$SISRegisterEventRequest$SISRequestType[SRequestType.REGISTER_EVENT.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
