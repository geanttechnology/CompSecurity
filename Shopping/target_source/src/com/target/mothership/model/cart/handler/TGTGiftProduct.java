// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.model.cart.interfaces.GiftProduct;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            TGTFreeProduct

public class TGTGiftProduct extends TGTFreeProduct
    implements GiftProduct
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTGiftProduct a(Parcel parcel)
        {
            return new TGTGiftProduct(parcel);
        }

        public TGTGiftProduct[] a(int i)
        {
            return new TGTGiftProduct[i];
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
    private boolean mIsSelected;
    private String mRewardOptionId;

    TGTGiftProduct()
    {
    }

    private TGTGiftProduct(Parcel parcel)
    {
        super(parcel);
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsSelected = flag;
        mRewardOptionId = parcel.readString();
    }


    public void b(boolean flag)
    {
        mIsSelected = flag;
    }

    public int describeContents()
    {
        return 0;
    }

    public void e(String s)
    {
        mRewardOptionId = s;
    }

    public boolean l_()
    {
        return mIsSelected;
    }

    public String m_()
    {
        return mRewardOptionId;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        byte byte0;
        if (mIsSelected)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeString(mRewardOptionId);
    }

}
