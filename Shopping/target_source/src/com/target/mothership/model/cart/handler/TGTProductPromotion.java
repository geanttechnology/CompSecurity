// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.common.a.i;
import com.target.mothership.common.b;
import com.target.mothership.model.cart.interfaces.ProductPromotion;

public class TGTProductPromotion
    implements ProductPromotion
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductPromotion a(Parcel parcel)
        {
            return new TGTProductPromotion(parcel);
        }

        public TGTProductPromotion[] a(int j)
        {
            return new TGTProductPromotion[j];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int j)
        {
            return a(j);
        }

    };
    private String mDescription;
    private String mLegalDisclaimer;
    private b mPromoGroup;
    private String mPromoId;
    private i mPromoStatus;

    public TGTProductPromotion()
    {
    }

    private TGTProductPromotion(Parcel parcel)
    {
        Object obj = null;
        super();
        int j = parcel.readInt();
        b b1;
        if (j == -1)
        {
            b1 = null;
        } else
        {
            b1 = b.values()[j];
        }
        mPromoGroup = b1;
        mPromoId = parcel.readString();
        mDescription = parcel.readString();
        mLegalDisclaimer = parcel.readString();
        j = parcel.readInt();
        if (j == -1)
        {
            parcel = obj;
        } else
        {
            parcel = i.values()[j];
        }
        mPromoStatus = parcel;
    }


    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int j)
    {
        byte byte0 = -1;
        if (mPromoGroup == null)
        {
            j = -1;
        } else
        {
            j = mPromoGroup.ordinal();
        }
        parcel.writeInt(j);
        parcel.writeString(mPromoId);
        parcel.writeString(mDescription);
        parcel.writeString(mLegalDisclaimer);
        if (mPromoStatus == null)
        {
            j = byte0;
        } else
        {
            j = mPromoStatus.ordinal();
        }
        parcel.writeInt(j);
    }

}
