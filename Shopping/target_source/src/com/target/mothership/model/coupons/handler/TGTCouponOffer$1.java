// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.handler;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.coupons.handler:
//            TGTCouponOffer

static final class 
    implements android.os.r
{

    public TGTCouponOffer a(Parcel parcel)
    {
        return new TGTCouponOffer(parcel, null);
    }

    public TGTCouponOffer[] a(int i)
    {
        return new TGTCouponOffer[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }

    ()
    {
    }
}
