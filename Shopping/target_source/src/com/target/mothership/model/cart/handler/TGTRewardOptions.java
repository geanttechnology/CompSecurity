// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.model.cart.interfaces.RewardOptions;
import java.util.ArrayList;
import java.util.List;

public class TGTRewardOptions
    implements RewardOptions
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTRewardOptions a(Parcel parcel)
        {
            return new TGTRewardOptions(parcel);
        }

        public TGTRewardOptions[] a(int i)
        {
            return new TGTRewardOptions[i];
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
    private List mGiftProducts;
    private String mRewardOptionId;

    TGTRewardOptions()
    {
    }

    private TGTRewardOptions(Parcel parcel)
    {
        mGiftProducts = new ArrayList();
        parcel.readList(mGiftProducts, com/target/mothership/model/cart/handler/TGTRewardOptions.getClassLoader());
        mRewardOptionId = parcel.readString();
    }


    public List a()
    {
        return mGiftProducts;
    }

    public void a(String s)
    {
        mRewardOptionId = s;
    }

    public void a(List list)
    {
        mGiftProducts = list;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeList(mGiftProducts);
        parcel.writeString(mRewardOptionId);
    }

}
