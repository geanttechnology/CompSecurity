// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public class VariationPictureSet
    implements Parcelable
{
    public class SpecificValue
    {

        String Name;
        final VariationPictureSet this$0;

        public SpecificValue()
        {
            this$0 = VariationPictureSet.this;
            super();
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VariationPictureSet createFromParcel(Parcel parcel)
        {
            return new VariationPictureSet(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VariationPictureSet[] newArray(int i)
        {
            return new VariationPictureSet[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public ArrayList pictureUrls;
    public String specificName;

    public VariationPictureSet()
    {
        pictureUrls = new ArrayList();
    }

    private VariationPictureSet(Parcel parcel)
    {
        pictureUrls = new ArrayList();
        specificName = parcel.readString();
        parcel.readStringList(pictureUrls);
    }


    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(specificName);
        parcel.writeStringList(pictureUrls);
    }

}
