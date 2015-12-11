// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;

// Referenced classes of package com.offerup.android.dto:
//            BraintreeTokenResponse

final class ta
    implements android.os.enResponse._cls1
{

    public final BraintreeTokenResponse createFromParcel(Parcel parcel)
    {
        BraintreeTokenResponse braintreetokenresponse = new BraintreeTokenResponse();
        braintreetokenresponse.data = (ta)parcel.readParcelable(com/offerup/android/dto/BraintreeTokenResponse$Data.getClassLoader());
        return braintreetokenresponse;
    }

    public final volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public final BraintreeTokenResponse[] newArray(int i)
    {
        return new BraintreeTokenResponse[i];
    }

    public final volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ta()
    {
    }
}
