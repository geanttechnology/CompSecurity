// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.store.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.model.common.Address;
import com.target.mothership.model.common.Geofence;
import com.target.mothership.model.store.interfaces.StoreSummary;

// Referenced classes of package com.target.mothership.model.store.handler:
//            TGTStore

public class TGTStoreSummary extends TGTStore
    implements Parcelable, StoreSummary
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTStoreSummary a(Parcel parcel)
        {
            return new TGTStoreSummary(parcel);
        }

        public TGTStoreSummary[] a(int i)
        {
            return new TGTStoreSummary[i];
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
    private Geofence mGeofence;
    private boolean mHasRequestATeamMember;
    private String mName;

    private TGTStoreSummary(Parcel parcel)
    {
        super(parcel);
        mGeofence = (Geofence)parcel.readParcelable(com/target/mothership/model/common/Geofence.getClassLoader());
        mName = parcel.readString();
        mAddress = (Address)parcel.readParcelable(com/target/mothership/model/common/Address.getClassLoader());
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mHasRequestATeamMember = flag;
    }


    public int describeContents()
    {
        return 0;
    }

    public Address getAddress()
    {
        return mAddress;
    }

    public Geofence getGeofence()
    {
        return mGeofence;
    }

    public String getName()
    {
        return mName;
    }

    public boolean hasRequestATeamMember()
    {
        return mHasRequestATeamMember;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = false;
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(mGeofence, 0);
        parcel.writeString(mName);
        parcel.writeParcelable(mAddress, 0);
        i = ((flag) ? 1 : 0);
        if (mHasRequestATeamMember)
        {
            i = 1;
        }
        parcel.writeByte((byte)i);
    }

}
