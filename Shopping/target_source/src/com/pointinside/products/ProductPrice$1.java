// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;

import android.os.Parcel;

// Referenced classes of package com.pointinside.products:
//            ProductPrice

static final class 
    implements android.os.tor
{

    public ProductPrice createFromParcel(Parcel parcel)
    {
        String s = parcel.readString();
        return new ProductPrice(parcel.readDouble(), s);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public ProductPrice[] newArray(int i)
    {
        return new ProductPrice[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
