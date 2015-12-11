// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.os.Parcel;

// Referenced classes of package com.ebay.mobile.viewitem:
//            BiddingDataManager

static final class 
    implements android.os.r.KeyParams._cls1
{

    public  createFromParcel(Parcel parcel)
    {
        long l = parcel.readLong();
        return new nit>(parcel.readString(), l);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public createFromParcel[] newArray(int i)
    {
        return new createFromParcel[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
