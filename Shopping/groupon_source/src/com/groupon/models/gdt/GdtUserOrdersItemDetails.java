// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.gdt;

import android.os.Parcel;
import android.os.Parcelable;

public class GdtUserOrdersItemDetails
    implements Parcelable
{
    private static class GdtUserOrdersItemCreator
        implements android.os.Parcelable.Creator
    {

        public GdtUserOrdersItemDetails createFromParcel(Parcel parcel)
        {
            return new GdtUserOrdersItemDetails(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public GdtUserOrdersItemDetails[] newArray(int i)
        {
            return new GdtUserOrdersItemDetails[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        private GdtUserOrdersItemCreator()
        {
        }

    }


    public static final android.os.Parcelable.Creator CREATOR = new GdtUserOrdersItemCreator();
    public String consumerId;
    public String id;
    public String merchantPlaceId;

    public GdtUserOrdersItemDetails()
    {
    }

    private GdtUserOrdersItemDetails(Parcel parcel)
    {
        id = parcel.readString();
        merchantPlaceId = parcel.readString();
        consumerId = parcel.readString();
    }


    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(id);
        parcel.writeString(merchantPlaceId);
        parcel.writeString(consumerId);
    }

}
