// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;

// Referenced classes of package com.offerup.android.dto:
//            GoogleWalletMetaData

final class 
    implements android.os.etMetaData._cls1
{

    public final GoogleWalletMetaData createFromParcel(Parcel parcel)
    {
        GoogleWalletMetaData googlewalletmetadata = new GoogleWalletMetaData(null);
        googlewalletmetadata.displayName = parcel.readString();
        googlewalletmetadata.lastFour = parcel.readString();
        return googlewalletmetadata;
    }

    public final volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public final GoogleWalletMetaData[] newArray(int i)
    {
        return new GoogleWalletMetaData[i];
    }

    public final volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
