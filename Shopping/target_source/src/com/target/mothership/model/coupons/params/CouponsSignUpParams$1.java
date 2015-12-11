// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.params;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.coupons.params:
//            CouponsSignUpParams

static final class 
    implements android.os.ns.params.CouponsSignUpParams._cls1
{

    public CouponsSignUpParams a(Parcel parcel)
    {
        return new CouponsSignUpParams(parcel);
    }

    public CouponsSignUpParams[] a(int i)
    {
        return new CouponsSignUpParams[i];
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
