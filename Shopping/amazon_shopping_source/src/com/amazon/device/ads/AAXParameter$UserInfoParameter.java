// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            AAXParameter, AdRequest, AdTargetingOptions, JSONUtils

static class r extends r
{

    protected volatile Object getDerivedValue(r r)
    {
        return getDerivedValue(r);
    }

    protected JSONObject getDerivedValue(getDerivedValue getderivedvalue)
    {
        if (ss._mth200(getderivedvalue).getAdTargetingOptions().hasAge())
        {
            int i = ss._mth200(getderivedvalue).getAdTargetingOptions().getAge();
            getderivedvalue = new JSONObject();
            JSONUtils.put(getderivedvalue, "age", String.valueOf(i));
            return getderivedvalue;
        } else
        {
            return null;
        }
    }

    r()
    {
        super("uinfo", "debug.ui");
    }
}
