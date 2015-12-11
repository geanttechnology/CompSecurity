// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.data.NameValue;
import java.io.Serializable;
import java.util.ArrayList;

public class ItemTransactionVariation
    implements Parcelable, Serializable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ItemTransactionVariation createFromParcel(Parcel parcel)
        {
            return new ItemTransactionVariation(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ItemTransactionVariation[] newArray(int i)
        {
            return new ItemTransactionVariation[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static final long serialVersionUID = 1L;
    public ArrayList nameValueList;
    public String sku;
    public String variationTitle;
    public String variationViewItemURL;

    public ItemTransactionVariation()
    {
        nameValueList = new ArrayList();
    }

    ItemTransactionVariation(Parcel parcel)
    {
        nameValueList = new ArrayList();
        sku = parcel.readString();
        variationTitle = parcel.readString();
        variationViewItemURL = parcel.readString();
        parcel.readTypedList(nameValueList, NameValue.CREATOR);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(sku);
        parcel.writeString(variationTitle);
        parcel.writeString(variationViewItemURL);
        parcel.writeTypedList(nameValueList);
    }

}
