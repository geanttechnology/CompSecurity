// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AAXParameter, InternalAdRegistration, IInternalAdRegistration, RegistrationInfo

static class <init> extends <init>
{

    protected volatile Object getDerivedValue(<init> <init>1)
    {
        return getDerivedValue(<init>1);
    }

    protected String getDerivedValue(getDerivedValue getderivedvalue)
    {
        return InternalAdRegistration.getInstance().getRegistrationInfo().getAppKey();
    }

    ()
    {
        super("appId", "debug.appid");
    }
}
