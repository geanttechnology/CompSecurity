// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.location.Location;

// Referenced classes of package com.amazon.device.ads:
//            AAXParameter, Configuration, AdRequest, AdTargetingOptions, 
//            AdLocation

static class > extends >
{

    protected volatile Object getDerivedValue(> >)
    {
        return getDerivedValue(>);
    }

    protected String getDerivedValue(getDerivedValue getderivedvalue)
    {
label0:
        {
            if (Configuration.getInstance().getBoolean(O) && _mth200(getderivedvalue).getAdTargetingOptions().isGeoLocationEnabled())
            {
                getderivedvalue = (new AdLocation()).getLocation();
                if (getderivedvalue != null)
                {
                    break label0;
                }
            }
            return null;
        }
        return (new StringBuilder()).append(getderivedvalue.getLatitude()).append(",").append(getderivedvalue.getLongitude()).toString();
    }

    ()
    {
        super("geoloc", "debug.geoloc");
    }
}
