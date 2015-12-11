// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.coupons;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.common.coupons:
//            CouponIdentifier

static final class 
    implements android.os.oupons.CouponIdentifier._cls1
{

    public CouponIdentifier a(Parcel parcel)
    {
        return new CouponIdentifier(parcel);
    }

    public CouponIdentifier[] a(int i)
    {
        return new CouponIdentifier[i];
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
