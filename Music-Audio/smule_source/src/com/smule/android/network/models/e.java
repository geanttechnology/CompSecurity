// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.smule.android.network.models:
//            StoreSectionV2, ListingV2, SongV2, SoundfontV2

public class e
{

    public static final android.os.Parcelable.Creator a = new android.os.Parcelable.Creator() {

        public e a(Parcel parcel)
        {
            return new e(parcel);
        }

        public e[] a(int i)
        {
            return new e[i];
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
    public List listings;
    public List songs;
    public List soundfonts;
    public String storeId;
    public List storeSections;
    public long ts;

    public e()
    {
        listings = new ArrayList();
        songs = new ArrayList();
        soundfonts = new ArrayList();
        storeSections = new ArrayList();
    }

    public e(Parcel parcel)
    {
        listings = new ArrayList();
        songs = new ArrayList();
        soundfonts = new ArrayList();
        storeSections = new ArrayList();
        storeId = parcel.readString();
        ts = parcel.readLong();
        parcel.readTypedList(storeSections, StoreSectionV2.CREATOR);
        parcel.readTypedList(listings, ListingV2.CREATOR);
        parcel.readTypedList(songs, SongV2.CREATOR);
        parcel.readTypedList(soundfonts, SoundfontV2.CREATOR);
    }

}
