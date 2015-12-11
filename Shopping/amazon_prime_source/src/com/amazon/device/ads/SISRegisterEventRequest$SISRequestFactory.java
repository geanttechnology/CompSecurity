// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONArray;

// Referenced classes of package com.amazon.device.ads:
//            SISRegisterEventRequest, SISGenerateDIDRequest, SISUpdateDeviceInfoRequest, SISDeviceRequest

static class 
{

    public SISDeviceRequest createDeviceRequest( )
    {
        switch (mazon.device.ads.SISRegisterEventRequest.SISRequestType[.inal()])
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("SISRequestType ").append().append(" is not a SISDeviceRequest").toString());

        case 1: // '\001'
            return new SISGenerateDIDRequest();

        case 2: // '\002'
            return new SISUpdateDeviceInfoRequest();
        }
    }

    public SISRegisterEventRequest createRegisterEventRequest(inal inal, JSONArray jsonarray)
    {
        return new SISRegisterEventRequest(inal, jsonarray);
    }

    ()
    {
    }
}
