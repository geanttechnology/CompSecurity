// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;

// Referenced classes of package com.offerup.android.dto:
//            FilterOption, OfferUpBoolean

final class 
    implements android.os.tor
{

    public final FilterOption createFromParcel(Parcel parcel)
    {
        FilterOption filteroption = new FilterOption();
        FilterOption.access$002(filteroption, parcel.readString());
        FilterOption.access$102(filteroption, (new OfferUpBoolean(parcel.readInt())).value);
        FilterOption.access$202(filteroption, parcel.readString());
        FilterOption.access$302(filteroption, parcel.readString());
        FilterOption.access$402(filteroption, (new OfferUpBoolean(parcel.readInt())).value);
        return filteroption;
    }

    public final volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public final FilterOption[] newArray(int i)
    {
        return new FilterOption[i];
    }

    public final volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
