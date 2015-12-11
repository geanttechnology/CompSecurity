// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.poi;

import android.os.Parcel;
import com.pointinside.internal.utils.StringUtils;
import com.pointinside.maps.Location;
import java.util.Date;

public class PIPointOfInterest
{
    public static final class POIType extends Enum
    {

        private static final POIType $VALUES[];
        public static final POIType Beacon;
        public static final POIType None;
        private final String name;

        public static POIType valueOf(String s)
        {
            return (POIType)Enum.valueOf(com/pointinside/location/poi/PIPointOfInterest$POIType, s);
        }

        public static POIType[] values()
        {
            return (POIType[])$VALUES.clone();
        }

        public String toString()
        {
            return name;
        }

        static 
        {
            None = new POIType("None", 0, null);
            Beacon = new POIType("Beacon", 1, "Beacon");
            $VALUES = (new POIType[] {
                None, Beacon
            });
        }

        private POIType(String s, int i, String s1)
        {
            super(s, i);
            name = s1;
        }
    }


    private static final String dPIMPointOfInterestId = "poiUniqueId".intern();
    private static final String dPIMPointOfInterestLocation = "location".intern();
    private static final String dPIMPointOfInterestModifiedDate = "modifiedDate".intern();
    private static final String dPIMPointOfInterestStatus = "status".intern();
    private static final String dPIMPointOfInterestType = "type".intern();
    private static final String dPIMPointofInterestCreatedDate = "createdDate".intern();
    public final Date createdDate;
    public final String id;
    public final Location location;
    public final Date modifiedDate;
    public final String status;
    public final String type;

    public PIPointOfInterest()
    {
        id = null;
        type = null;
        status = null;
        location = null;
        createdDate = null;
        modifiedDate = null;
    }

    protected PIPointOfInterest(Parcel parcel)
    {
        id = parcel.readString();
        type = parcel.readString();
        status = parcel.readString();
        location = (Location)parcel.readParcelable(com/pointinside/maps/Location.getClassLoader());
        createdDate = (Date)parcel.readSerializable();
        modifiedDate = (Date)parcel.readSerializable();
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        StringUtils.appendIfNotNull(stringbuilder, "id", id);
        StringUtils.appendIfNotNull(stringbuilder, "type", type);
        StringUtils.appendIfNotNull(stringbuilder, "status", status);
        if (location != null)
        {
            stringbuilder.append(" ~ Location ~");
            stringbuilder.append(location.toString());
        }
        return stringbuilder.toString();
    }

}
