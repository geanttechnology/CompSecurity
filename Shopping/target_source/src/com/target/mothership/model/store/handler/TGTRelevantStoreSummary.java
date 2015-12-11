// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.store.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.model.common.Address;
import com.target.mothership.model.common.Geofence;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.model.store.interfaces.StoreSummary;

// Referenced classes of package com.target.mothership.model.store.handler:
//            TGTStore

public class TGTRelevantStoreSummary extends TGTStore
    implements Parcelable, RelevantStoreSummary
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTRelevantStoreSummary a(Parcel parcel)
        {
            return new TGTRelevantStoreSummary(parcel);
        }

        public TGTRelevantStoreSummary[] a(int i)
        {
            return new TGTRelevantStoreSummary[i];
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
    private boolean mFrequented;
    private boolean mGuestInside;
    private boolean mHasRequestTeamMember;
    private boolean mOverride;
    private StoreSummary mStoreSummary;

    private TGTRelevantStoreSummary(Parcel parcel)
    {
        boolean flag1 = true;
        super(parcel);
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mGuestInside = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mFrequented = flag;
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        mOverride = flag;
        mStoreSummary = (StoreSummary)parcel.readParcelable(com/target/mothership/model/store/interfaces/StoreSummary.getClassLoader());
    }


    TGTRelevantStoreSummary(StoreSummary storesummary, boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        super(storesummary.getStoreId());
        mStoreSummary = storesummary;
        mGuestInside = flag;
        mFrequented = flag1;
        mOverride = flag2;
        mHasRequestTeamMember = flag3;
    }

    public boolean a()
    {
        return mGuestInside;
    }

    public boolean b()
    {
        return mFrequented;
    }

    public boolean c()
    {
        return mOverride;
    }

    public int describeContents()
    {
        return 0;
    }

    public Address getAddress()
    {
        return mStoreSummary.getAddress();
    }

    public Geofence getGeofence()
    {
        return mStoreSummary.getGeofence();
    }

    public String getName()
    {
        return mStoreSummary.getName();
    }

    public boolean hasRequestATeamMember()
    {
        return mHasRequestTeamMember;
    }

    public String toString()
    {
        return (new StringBuilder()).append("TGTRelevantStoreSummary{mGuestInside=").append(mGuestInside).append(", mFrequented=").append(mFrequented).append(", mOverride=").append(mOverride).append(", mHasRequestTeamMember=").append(mHasRequestTeamMember).append(", mStoreSummary=").append(mStoreSummary).append("} ").append(super.toString()).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        super.writeToParcel(parcel, i);
        byte byte0;
        if (mGuestInside)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mFrequented)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mOverride)
        {
            byte0 = flag;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeParcelable(mStoreSummary, i);
    }

}
