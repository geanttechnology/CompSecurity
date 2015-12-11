// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AAXParameter, AdRequest

static class  extends 
{

    protected Boolean getDerivedValue( )
    {
        if (cess._mth200().getAdvertisingIdentifierInfo().sAdvertisingIdentifier())
        {
            return Boolean.valueOf(cess._mth200().getAdvertisingIdentifierInfo().LimitAdTrackingEnabled());
        } else
        {
            return null;
        }
    }

    protected volatile Object getDerivedValue(LimitAdTrackingEnabled limitadtrackingenabled)
    {
        return getDerivedValue(limitadtrackingenabled);
    }

    ()
    {
        super("oo", "debug.optOut");
    }
}
