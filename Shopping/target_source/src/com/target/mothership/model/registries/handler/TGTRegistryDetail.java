// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.registries.handler;

import android.os.Parcel;
import com.target.mothership.model.registries.interfaces.RegistryDetailWrapper;
import com.target.mothership.model.registries.interfaces.RegistryDetails;
import com.target.mothership.util.k;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.mothership.model.registries.handler:
//            TGTRegistryProductDetails

public class TGTRegistryDetail
    implements RegistryDetailWrapper
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTRegistryDetail a(Parcel parcel)
        {
            return new TGTRegistryDetail(parcel);
        }

        public TGTRegistryDetail[] a(int i)
        {
            return new TGTRegistryDetail[i];
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
    private int mCurrentPage;
    private boolean mRecordSetComplete;
    private int mRecordSetCount;
    private int mRecordSetStartNumber;
    private int mRecordSetTotal;
    private RegistryDetails mRegistryDetails;
    private List mRegistryProductDetails;
    private int mTotalPage;

    TGTRegistryDetail()
    {
    }

    protected TGTRegistryDetail(Parcel parcel)
    {
        mRegistryDetails = (RegistryDetails)parcel.readParcelable(com/target/mothership/model/registries/interfaces/RegistryDetails.getClassLoader());
        mRegistryProductDetails = new ArrayList();
        parcel.readList(mRegistryProductDetails, com/target/mothership/model/registries/handler/TGTRegistryProductDetails.getClassLoader());
        mTotalPage = parcel.readInt();
        mCurrentPage = parcel.readInt();
        mRecordSetCount = parcel.readInt();
        mRecordSetStartNumber = parcel.readInt();
        mRecordSetTotal = parcel.readInt();
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mRecordSetComplete = flag;
    }

    public RegistryDetails a()
    {
        return mRegistryDetails;
    }

    public void a(int i)
    {
        mTotalPage = i;
    }

    public void a(RegistryDetails registrydetails)
    {
        mRegistryDetails = registrydetails;
    }

    public void a(List list)
    {
        mRegistryProductDetails = list;
    }

    public void a(boolean flag)
    {
        mRecordSetComplete = flag;
    }

    public List b()
    {
        return k.a(mRegistryProductDetails);
    }

    public void b(int i)
    {
        mCurrentPage = i;
    }

    public int c()
    {
        return mCurrentPage;
    }

    public void c(int i)
    {
        mRecordSetCount = i;
    }

    public int d()
    {
        return mRecordSetCount;
    }

    public void d(int i)
    {
        mRecordSetStartNumber = i;
    }

    public int describeContents()
    {
        return 0;
    }

    public int e()
    {
        return mRecordSetTotal;
    }

    public void e(int i)
    {
        mRecordSetTotal = i;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        byte byte0 = 0;
        parcel.writeParcelable(mRegistryDetails, 0);
        parcel.writeList(mRegistryProductDetails);
        parcel.writeInt(mTotalPage);
        parcel.writeInt(mCurrentPage);
        parcel.writeInt(mRecordSetCount);
        parcel.writeInt(mRecordSetStartNumber);
        parcel.writeInt(mRecordSetTotal);
        if (mRecordSetComplete)
        {
            byte0 = 1;
        }
        parcel.writeByte(byte0);
    }

}
