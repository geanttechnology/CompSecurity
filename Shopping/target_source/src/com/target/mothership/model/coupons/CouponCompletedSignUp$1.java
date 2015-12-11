// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.coupons:
//            CouponCompletedSignUp

static final class A
    implements android.os..CouponCompletedSignUp._cls1
{

    public CouponCompletedSignUp a(Parcel parcel)
    {
        return new CouponCompletedSignUp(parcel);
    }

    public CouponCompletedSignUp[] a(int i)
    {
        return new CouponCompletedSignUp[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }

    A()
    {
    }
}
