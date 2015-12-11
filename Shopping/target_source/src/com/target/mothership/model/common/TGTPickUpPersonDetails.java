// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.common;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.common:
//            PickUpPersonDetails, PhoneNumber

public class TGTPickUpPersonDetails
    implements PickUpPersonDetails
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTPickUpPersonDetails a(Parcel parcel)
        {
            return new TGTPickUpPersonDetails(parcel);
        }

        public TGTPickUpPersonDetails[] a(int i)
        {
            return new TGTPickUpPersonDetails[i];
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
    private String mPickUpEmailId;
    private String mPickUpPersonName;
    private PhoneNumber mPickUpPhone;

    public TGTPickUpPersonDetails()
    {
    }

    private TGTPickUpPersonDetails(Parcel parcel)
    {
        mPickUpPersonName = parcel.readString();
        mPickUpPhone = (PhoneNumber)parcel.readParcelable(com/target/mothership/model/common/PhoneNumber.getClassLoader());
        mPickUpEmailId = parcel.readString();
    }


    public String a()
    {
        return mPickUpPersonName;
    }

    public void a(PhoneNumber phonenumber)
    {
        mPickUpPhone = phonenumber;
    }

    public void a(String s)
    {
        mPickUpPersonName = s;
    }

    public void b(String s)
    {
        mPickUpEmailId = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mPickUpPersonName);
        parcel.writeParcelable(mPickUpPhone, 0);
        parcel.writeString(mPickUpEmailId);
    }

}
