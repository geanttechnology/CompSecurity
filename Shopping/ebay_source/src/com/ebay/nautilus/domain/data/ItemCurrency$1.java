// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ItemCurrency

static final class 
    implements android.os.tor
{

    public ItemCurrency createFromParcel(Parcel parcel)
    {
        return new ItemCurrency(parcel.readString(), parcel.readString());
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public ItemCurrency[] newArray(int i)
    {
        return new ItemCurrency[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
