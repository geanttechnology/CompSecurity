// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AAXParameter, AdRequest, InternalAdRegistration, IInternalAdRegistration, 
//            DeviceInfo

static class init> extends init>
{

    protected volatile Object getDerivedValue(init> init>)
    {
        return getDerivedValue(init>);
    }

    protected String getDerivedValue(getDerivedValue getderivedvalue)
    {
        if (!ess._mth200(getderivedvalue).getAdvertisingIdentifierInfo().AdvertisingIdentifier())
        {
            return InternalAdRegistration.getInstance().getDeviceInfo().getUdidMd5();
        } else
        {
            return null;
        }
    }

    _cls9()
    {
        super("md5_udid", "debug.md5udid");
    }
}
