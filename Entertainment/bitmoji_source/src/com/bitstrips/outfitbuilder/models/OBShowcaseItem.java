// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.outfitbuilder.models;

import android.os.Parcel;
import android.os.Parcelable;

public class OBShowcaseItem
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public OBShowcaseItem createFromParcel(Parcel parcel)
        {
            return new OBShowcaseItem(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public OBShowcaseItem[] newArray(int i)
        {
            return new OBShowcaseItem[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    String image;

    protected OBShowcaseItem(Parcel parcel)
    {
        image = parcel.readString();
    }

    public OBShowcaseItem(String s)
    {
        image = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getImageURL()
    {
        return image;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(image);
    }

}
