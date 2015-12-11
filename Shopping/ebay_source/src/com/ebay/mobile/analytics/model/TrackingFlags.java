// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.analytics.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TrackingFlags
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TrackingFlags createFromParcel(Parcel parcel)
        {
            return new TrackingFlags(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public TrackingFlags[] newArray(int i)
        {
            return new TrackingFlags[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final String FLAGS_BUNDLE_TAG = "com.ebay.mobile.analytics.tracking_flags";
    private final Set bitPositions;
    private final String name;

    private TrackingFlags(Parcel parcel)
    {
        name = parcel.readString();
        ArrayList arraylist = new ArrayList();
        parcel.readStringList(arraylist);
        bitPositions = new HashSet(arraylist);
    }


    public TrackingFlags(TrackingFlags trackingflags)
    {
        name = trackingflags.name;
        bitPositions = new HashSet(trackingflags.bitPositions);
    }

    public TrackingFlags(String s)
    {
        name = s;
        bitPositions = new HashSet();
    }

    public void clearAllFlags()
    {
        bitPositions.clear();
    }

    public boolean clearBitPosition(int i)
    {
        return bitPositions.remove(String.valueOf(i));
    }

    public int describeContents()
    {
        return 0;
    }

    public Set getBitPositions()
    {
        HashSet hashset = new HashSet();
        for (Iterator iterator = bitPositions.iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            try
            {
                hashset.add(Integer.valueOf(s));
            }
            catch (NumberFormatException numberformatexception) { }
        }

        return hashset;
    }

    public Set getBitPositionsAsStrings()
    {
        return bitPositions;
    }

    public String getName()
    {
        return name;
    }

    public boolean hasFlags()
    {
        return bitPositions.size() > 0;
    }

    public void setBitPosition(int i)
    {
        bitPositions.add(String.valueOf(i));
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(name);
        parcel.writeStringList(new ArrayList(bitPositions));
    }

}
