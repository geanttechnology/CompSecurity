// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.poi;

import android.os.Parcel;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.pointinside.location.poi:
//            PIPointOfInterest

public class BeaconPointOfInterest extends PIPointOfInterest
{
    public static class UserData
    {

        public List featureIds;
        public String mapFeature;

        public UserData()
        {
        }
    }


    public final String advertisingInterval;
    public final Date batteryReplacementDate;
    public final String estimatedRadius;
    public final Date installationDate;
    private String mKeyName;
    public final int major;
    public final int minor;
    public final String model;
    public final String name;
    public final String notes;
    public final String placeType;
    public final String power;
    public final UserData userData;
    public final String uuid;

    protected BeaconPointOfInterest(Parcel parcel)
    {
        super(parcel);
        model = parcel.readString();
        batteryReplacementDate = (Date)parcel.readSerializable();
        minor = parcel.readInt();
        name = parcel.readString();
        estimatedRadius = parcel.readString();
        power = parcel.readString();
        uuid = parcel.readString();
        notes = parcel.readString();
        userData = (UserData)parcel.readParcelable(com/pointinside/location/poi/BeaconPointOfInterest$UserData.getClassLoader());
        placeType = parcel.readString();
        major = parcel.readInt();
        installationDate = (Date)parcel.readSerializable();
        advertisingInterval = parcel.readString();
    }

    public String getBeaconKey()
    {
        if (mKeyName == null)
        {
            mKeyName = (new StringBuilder()).append(uuid).append("-").append(major).append("-").append(minor).toString();
        }
        return mKeyName;
    }
}
