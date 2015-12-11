// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import android.location.Location;
import android.os.Parcel;
import com.offerup.android.dto.OfferUpBoolean;

// Referenced classes of package com.offerup.android.utils:
//            OfferUpLocation

final class ar
    implements android.os.Parcelable.Creator
{

    ar()
    {
    }

    public final Object createFromParcel(Parcel parcel)
    {
        OfferUpLocation offeruplocation = new OfferUpLocation();
        OfferUpLocation.a(offeruplocation, parcel.readString());
        OfferUpLocation.b(offeruplocation, parcel.readString());
        OfferUpLocation.a(offeruplocation, parcel.readDouble());
        OfferUpLocation.b(offeruplocation, parcel.readDouble());
        OfferUpLocation.a(offeruplocation, (new OfferUpBoolean(parcel.readInt())).value);
        OfferUpLocation.c(offeruplocation, parcel.readString());
        OfferUpLocation.d(offeruplocation, parcel.readString());
        OfferUpLocation.b(offeruplocation, (new OfferUpBoolean(parcel.readInt())).value);
        offeruplocation.a = (Location)parcel.readParcelable(android/location/Location.getClassLoader());
        return offeruplocation;
    }

    public final volatile Object[] newArray(int i)
    {
        return new OfferUpLocation[i];
    }
}
