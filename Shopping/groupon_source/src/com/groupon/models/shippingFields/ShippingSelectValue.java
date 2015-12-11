// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.shippingFields;

import android.os.Parcel;
import android.os.Parcelable;
import com.groupon.models.support.ParcelableCreator;

public class ShippingSelectValue
    implements Parcelable
{

    public static android.os.Parcelable.Creator CREATOR = new ParcelableCreator(com/groupon/models/shippingFields/ShippingSelectValue);
    public String label;
    public String value;

    public ShippingSelectValue()
    {
    }

    public ShippingSelectValue(Parcel parcel)
    {
        value = parcel.readString();
        label = parcel.readString();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(value);
        parcel.writeString(label);
    }

}
