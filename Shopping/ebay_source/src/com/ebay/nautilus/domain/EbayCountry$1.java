// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain;

import android.os.Parcel;

// Referenced classes of package com.ebay.nautilus.domain:
//            EbayCountry

static final class 
    implements android.os.ator
{

    public EbayCountry createFromParcel(Parcel parcel)
    {
        return EbayCountry.deserialize(parcel.readString());
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public EbayCountry[] newArray(int i)
    {
        return new EbayCountry[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
