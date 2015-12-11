// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.common.a.h;
import com.target.mothership.model.cart.interfaces.PickUpContactDetails;

public class TGTPickUpContactDetails
    implements PickUpContactDetails
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTPickUpContactDetails a(Parcel parcel)
        {
            return new TGTPickUpContactDetails(parcel);
        }

        public TGTPickUpContactDetails[] a(int i)
        {
            return new TGTPickUpContactDetails[i];
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
    private String mAltPickUpPersonEmail;
    private String mAltPickUpPersonFirstName;
    private String mAltPickUpPersonLastName;
    private String mAltPickUpPersonName;
    private String mAltPickUpPersonPhoneNumber;
    private h mContactType;
    private String mPickUpEmail;
    private String mPickUpPersonFirstName;
    private String mPickUpPersonLastName;
    private String mPickUpPersonName;
    private String mPickUpPhoneNumber;

    TGTPickUpContactDetails()
    {
    }

    private TGTPickUpContactDetails(Parcel parcel)
    {
        int i = parcel.readInt();
        h h1;
        if (i == -1)
        {
            h1 = null;
        } else
        {
            h1 = h.values()[i];
        }
        mContactType = h1;
        mPickUpPersonFirstName = parcel.readString();
        mPickUpPersonLastName = parcel.readString();
        mPickUpPersonName = parcel.readString();
        mPickUpEmail = parcel.readString();
        mPickUpPhoneNumber = parcel.readString();
        mAltPickUpPersonFirstName = parcel.readString();
        mAltPickUpPersonLastName = parcel.readString();
        mAltPickUpPersonName = parcel.readString();
        mAltPickUpPersonEmail = parcel.readString();
        mAltPickUpPersonPhoneNumber = parcel.readString();
    }


    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (mContactType == null)
        {
            i = -1;
        } else
        {
            i = mContactType.ordinal();
        }
        parcel.writeInt(i);
        parcel.writeString(mPickUpPersonFirstName);
        parcel.writeString(mPickUpPersonLastName);
        parcel.writeString(mPickUpPersonName);
        parcel.writeString(mPickUpEmail);
        parcel.writeString(mPickUpPhoneNumber);
        parcel.writeString(mAltPickUpPersonFirstName);
        parcel.writeString(mAltPickUpPersonLastName);
        parcel.writeString(mAltPickUpPersonName);
        parcel.writeString(mAltPickUpPersonEmail);
        parcel.writeString(mAltPickUpPersonPhoneNumber);
    }

}
