// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            AAXParameter, InternalAdRegistration, IInternalAdRegistration, AdRequest, 
//            DeviceInfo

static class <init> extends <init>
{

    protected volatile Object getDerivedValue(<init> <init>1)
    {
        return getDerivedValue(<init>1);
    }

    protected JSONObject getDerivedValue(getDerivedValue getderivedvalue)
    {
        return InternalAdRegistration.getInstance().getDeviceInfo().toJsonObject(._mth200(getderivedvalue).getOrientation());
    }

    ()
    {
        super("dinfo", "debug.dinfo");
    }
}
