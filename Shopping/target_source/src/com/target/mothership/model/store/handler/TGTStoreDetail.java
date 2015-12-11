// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.store.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.common.store.b;
import com.target.mothership.model.common.Address;
import com.target.mothership.model.common.PhoneNumber;
import com.target.mothership.model.store.interfaces.StoreCapability;
import com.target.mothership.model.store.interfaces.StoreDetail;
import com.target.mothership.model.store.interfaces.StoreOperatingHours;
import com.target.mothership.model.store.interfaces.a;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.mothership.model.store.handler:
//            TGTStore

class TGTStoreDetail extends TGTStore
    implements Parcelable, StoreDetail
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTStoreDetail a(Parcel parcel)
        {
            return new TGTStoreDetail(parcel);
        }

        public TGTStoreDetail[] a(int i)
        {
            return new TGTStoreDetail[i];
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
    private Address mAddress;
    private List mAlternateOperatingHours;
    private String mName;
    private List mOperatingHours;
    private List mPhoneNumbers;
    private List mStoreCapabilities;
    private b mStoreType;

    private TGTStoreDetail(Parcel parcel)
    {
        super(parcel);
        mName = parcel.readString();
        mAddress = (Address)parcel.readParcelable(com/target/mothership/model/common/Address.getClassLoader());
        mPhoneNumbers = new ArrayList();
        parcel.readList(mPhoneNumbers, com/target/mothership/model/common/PhoneNumber.getClassLoader());
        mOperatingHours = new ArrayList();
        parcel.readList(mOperatingHours, com/target/mothership/model/store/interfaces/StoreOperatingHours.getClassLoader());
        mAlternateOperatingHours = new ArrayList();
        parcel.readList(mAlternateOperatingHours, com/target/mothership/model/store/interfaces/a.getClassLoader());
        int i = parcel.readInt();
        b b1;
        if (i == -1)
        {
            b1 = null;
        } else
        {
            b1 = com.target.mothership.common.store.b.values()[i];
        }
        mStoreType = b1;
        mStoreCapabilities = new ArrayList();
        parcel.readList(mStoreCapabilities, com/target/mothership/model/store/interfaces/StoreCapability.getClassLoader());
    }


    TGTStoreDetail(String s)
    {
        super(new StoreIdentifier(s));
    }

    public String a()
    {
        return mName;
    }

    public void a(b b1)
    {
        mStoreType = b1;
    }

    public void a(Address address)
    {
        mAddress = address;
    }

    public void a(String s)
    {
        mName = s;
    }

    public void a(List list)
    {
        mPhoneNumbers = list;
    }

    public Address b()
    {
        return mAddress;
    }

    public void b(List list)
    {
        mOperatingHours = list;
    }

    public List c()
    {
        return mPhoneNumbers;
    }

    public void c(List list)
    {
        mAlternateOperatingHours = list;
    }

    public List d()
    {
        return mOperatingHours;
    }

    public void d(List list)
    {
        mStoreCapabilities = list;
    }

    public int describeContents()
    {
        return 0;
    }

    public List e()
    {
        return mAlternateOperatingHours;
    }

    public List f()
    {
        return mStoreCapabilities;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeString(mName);
        parcel.writeParcelable(mAddress, 0);
        parcel.writeList(mPhoneNumbers);
        parcel.writeList(mOperatingHours);
        parcel.writeList(mAlternateOperatingHours);
        if (mStoreType == null)
        {
            i = -1;
        } else
        {
            i = mStoreType.ordinal();
        }
        parcel.writeInt(i);
        parcel.writeList(mStoreCapabilities);
    }

}
