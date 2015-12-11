// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.model.cart.interfaces.GiftOptionsInfo;
import java.util.ArrayList;
import java.util.List;

public class TGTGiftOptionsInfo
    implements GiftOptionsInfo
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTGiftOptionsInfo a(Parcel parcel)
        {
            return new TGTGiftOptionsInfo(parcel);
        }

        public TGTGiftOptionsInfo[] a(int i)
        {
            return new TGTGiftOptionsInfo[i];
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
    private String mOrderId;
    private List mProductsWithGiftOptionsInfo;

    TGTGiftOptionsInfo()
    {
    }

    private TGTGiftOptionsInfo(Parcel parcel)
    {
        mOrderId = parcel.readString();
        mProductsWithGiftOptionsInfo = new ArrayList();
        parcel.readList(mProductsWithGiftOptionsInfo, com/target/mothership/model/cart/handler/TGTGiftOptionsInfo.getClassLoader());
    }


    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mOrderId);
        parcel.writeList(mProductsWithGiftOptionsInfo);
    }

}
