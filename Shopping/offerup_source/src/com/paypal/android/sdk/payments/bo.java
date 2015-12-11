// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import android.os.Parcel;

// Referenced classes of package com.paypal.android.sdk.payments:
//            PayPalTouchResponseBundle

final class bo
    implements android.os.Parcelable.Creator
{

    bo()
    {
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return new PayPalTouchResponseBundle(parcel, (byte)0);
    }

    public final volatile Object[] newArray(int i)
    {
        return new PayPalTouchResponseBundle[i];
    }
}
