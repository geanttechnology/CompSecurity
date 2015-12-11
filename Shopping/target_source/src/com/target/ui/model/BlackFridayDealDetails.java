// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.ui.model.pi_blackfriday_deals.PiBaseProduct;
import java.util.ArrayList;
import java.util.List;

public class BlackFridayDealDetails
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public BlackFridayDealDetails a(Parcel parcel)
        {
            return new BlackFridayDealDetails(parcel);
        }

        public BlackFridayDealDetails[] a(int i)
        {
            return new BlackFridayDealDetails[i];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i)
        {
            return a(i);
        }

    };
    private String mDescription;
    private String mEventLocation;
    private List mProducts;

    public BlackFridayDealDetails()
    {
    }

    private BlackFridayDealDetails(Parcel parcel)
    {
        mDescription = parcel.readString();
        mEventLocation = parcel.readString();
        mProducts = new ArrayList();
        parcel.readList(mProducts, com/target/ui/model/pi_blackfriday_deals/PiBaseProduct.getClassLoader());
    }


    public String a()
    {
        return mEventLocation;
    }

    public void a(String s)
    {
        mDescription = s;
    }

    public void a(List list)
    {
        mProducts = list;
    }

    public List b()
    {
        return mProducts;
    }

    public void b(String s)
    {
        mEventLocation = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mDescription);
        parcel.writeString(mEventLocation);
        parcel.writeList(mProducts);
    }

}
