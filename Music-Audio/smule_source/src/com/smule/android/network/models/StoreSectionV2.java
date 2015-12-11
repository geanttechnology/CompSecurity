// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.smule.android.network.models:
//            ListingV2

public class StoreSectionV2
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public StoreSectionV2 a(Parcel parcel)
        {
            return new StoreSectionV2(parcel);
        }

        public StoreSectionV2[] a(int i)
        {
            return new StoreSectionV2[i];
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
    public String displayName;
    public String imageUrl;
    public List listingIds;
    public List listings;
    public int order;
    public String sectionId;
    public List subSections;
    public long ts;

    public StoreSectionV2()
    {
        listingIds = new ArrayList();
        listings = new ArrayList();
        subSections = new ArrayList();
    }

    public StoreSectionV2(Parcel parcel)
    {
        listingIds = new ArrayList();
        listings = new ArrayList();
        subSections = new ArrayList();
        sectionId = parcel.readString();
        ts = parcel.readLong();
        displayName = parcel.readString();
        imageUrl = parcel.readString();
        parcel.readStringList(listingIds);
        parcel.readTypedList(listings, ListingV2.CREATOR);
        order = parcel.readInt();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        String s;
        if (sectionId == null)
        {
            s = "";
        } else
        {
            s = sectionId;
        }
        parcel.writeString(s);
        parcel.writeLong(ts);
        if (displayName == null)
        {
            s = "";
        } else
        {
            s = displayName;
        }
        parcel.writeString(s);
        if (imageUrl == null)
        {
            s = "";
        } else
        {
            s = imageUrl;
        }
        parcel.writeString(s);
        parcel.writeStringList(listingIds);
        parcel.writeTypedList(listings);
        parcel.writeInt(order);
    }

}
