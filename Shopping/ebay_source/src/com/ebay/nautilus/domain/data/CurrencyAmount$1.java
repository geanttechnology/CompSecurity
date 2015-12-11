// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            CurrencyAmount

static final class 
    implements android.os.r
{

    public CurrencyAmount createFromParcel(Parcel parcel)
    {
        return new CurrencyAmount(parcel.readString(), parcel.readString());
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public CurrencyAmount[] newArray(int i)
    {
        return new CurrencyAmount[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
