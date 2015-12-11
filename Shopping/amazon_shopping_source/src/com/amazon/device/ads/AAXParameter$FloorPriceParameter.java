// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AAXParameter, AdTargetingOptions

static class  extends 
{

    protected Long getDerivedValue( )
    {
        if (._mth300().ptions().hasFloorPrice())
        {
            return Long.valueOf(._mth300().ptions().getFloorPrice());
        } else
        {
            return null;
        }
    }

    protected volatile Object getDerivedValue(ptions ptions)
    {
        return getDerivedValue(ptions);
    }

    ()
    {
        super("ec", "debug.ec");
    }
}
