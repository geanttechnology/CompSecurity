// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            dh, dg, dm, df

static final class ception
{

    public static df a(ception ception)
    {
        switch (a[ception.ordinal()])
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("SISRequestType ")).append(ception).append(" is not a SISDeviceRequest").toString());

        case 1: // '\001'
            return new dg();

        case 2: // '\002'
            return new dm();
        }
    }

    ception()
    {
    }
}
