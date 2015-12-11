// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            AAXParameter, InternalAdRegistration, IInternalAdRegistration, AppInfo

static class init> extends init>
{

    protected volatile Object getDerivedValue(init> init>)
    {
        return getDerivedValue(init>);
    }

    protected JSONObject getDerivedValue(getDerivedValue getderivedvalue)
    {
        return InternalAdRegistration.getInstance().getAppInfo().getPackageInfoJSON();
    }

    ()
    {
        super("pkg", "debug.pkg");
    }
}
