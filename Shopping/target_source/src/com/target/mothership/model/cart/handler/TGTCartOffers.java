// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.model.cart.interfaces.CartOffers;
import java.util.ArrayList;
import java.util.List;

class TGTCartOffers
    implements CartOffers
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTCartOffers a(Parcel parcel)
        {
            return new TGTCartOffers(parcel);
        }

        public TGTCartOffers[] a(int i)
        {
            return new TGTCartOffers[i];
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
    private List mListPrices;

    TGTCartOffers()
    {
    }

    private TGTCartOffers(Parcel parcel)
    {
        mListPrices = new ArrayList();
        parcel.readList(mListPrices, com/target/mothership/model/cart/handler/TGTCartOffers.getClassLoader());
    }


    public void a(List list)
    {
        mListPrices = list;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeList(mListPrices);
    }

}
