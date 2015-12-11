// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.tips;

import android.os.Parcel;
import android.os.Parcelable;
import com.groupon.models.support.ParcelableCreator;

public class MerchantTip
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new ParcelableCreator(com/groupon/models/tips/MerchantTip);
    public String createdAtString;
    public int likes;
    public String maskedName;
    public String text;
    public String updatedAtString;

    public MerchantTip()
    {
    }

    public MerchantTip(Parcel parcel)
    {
        likes = parcel.readInt();
        maskedName = parcel.readString();
        text = parcel.readString();
        createdAtString = parcel.readString();
        updatedAtString = parcel.readString();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(likes);
        parcel.writeString(maskedName);
        parcel.writeString(text);
        parcel.writeString(createdAtString);
        parcel.writeString(updatedAtString);
    }

}
