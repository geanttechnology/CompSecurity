// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AAXParameter, AdRequest, InternalAdRegistration, IInternalAdRegistration, 
//            DeviceInfo

static class nit> extends nit>
{

    protected volatile Object getDerivedValue(nit> nit>)
    {
        return getDerivedValue(nit>);
    }

    protected String getDerivedValue(getDerivedValue getderivedvalue)
    {
        if (!ss._mth200(getderivedvalue).getAdvertisingIdentifierInfo().dvertisingIdentifier())
        {
            return InternalAdRegistration.getInstance().getDeviceInfo().getUdidSha1();
        } else
        {
            return null;
        }
    }

    ()
    {
        super("sha1_udid", "debug.sha1udid");
    }
}
