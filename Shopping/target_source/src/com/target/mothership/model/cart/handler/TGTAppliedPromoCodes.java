// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.model.cart.interfaces.AppliedPromoCodes;
import java.util.ArrayList;
import java.util.List;

class TGTAppliedPromoCodes
    implements AppliedPromoCodes
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTAppliedPromoCodes a(Parcel parcel)
        {
            return new TGTAppliedPromoCodes(parcel);
        }

        public TGTAppliedPromoCodes[] a(int i)
        {
            return new TGTAppliedPromoCodes[i];
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
    private List mPromotionList;

    public TGTAppliedPromoCodes()
    {
    }

    private TGTAppliedPromoCodes(Parcel parcel)
    {
        mOrderId = parcel.readString();
        mPromotionList = new ArrayList();
        parcel.readList(mPromotionList, com/target/mothership/model/cart/handler/TGTAppliedPromoCodes.getClassLoader());
    }


    public void a(String s)
    {
        mOrderId = s;
    }

    public void a(List list)
    {
        mPromotionList = list;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mOrderId);
        parcel.writeList(mPromotionList);
    }

}
