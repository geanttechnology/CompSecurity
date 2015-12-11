// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.smule.android.network.models:
//            SongV2, SoundfontV2

public class ListingV2
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ListingV2 a(Parcel parcel)
        {
            return new ListingV2(parcel);
        }

        public ListingV2[] a(int i)
        {
            return new ListingV2[i];
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
    private static final String a = com/smule/android/network/models/ListingV2.getName();
    public int currencyId;
    public boolean isFree;
    public boolean isNew;
    public String listingId;
    public long liveTs;
    public List modes;
    public int price;
    public String productId;
    public String productType;
    public boolean sale;
    public SongV2 song;
    public SoundfontV2 soundfont;
    public float storePrice;
    public boolean subscriberOnly;
    public long ts;

    public ListingV2()
    {
        modes = new ArrayList();
    }

    public ListingV2(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        modes = new ArrayList();
        listingId = parcel.readString();
        ts = parcel.readLong();
        productType = parcel.readString();
        productId = parcel.readString();
        price = parcel.readInt();
        currencyId = parcel.readInt();
        boolean flag;
        if (parcel.readByte() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isNew = flag;
        if (parcel.readByte() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        sale = flag;
        if (parcel.readByte() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        subscriberOnly = flag;
        if (parcel.readByte() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        isFree = flag;
        song = (SongV2)parcel.readParcelable(com/smule/android/network/models/SongV2.getClassLoader());
        soundfont = (SoundfontV2)parcel.readParcelable(com/smule/android/network/models/SoundfontV2.getClassLoader());
        storePrice = parcel.readFloat();
        parcel.readStringList(modes);
    }

    public ListingV2(SongV2 songv2)
    {
        modes = new ArrayList();
        listingId = (new StringBuilder()).append("__owned_song__").append(songv2.songId).toString();
        ts = 0L;
        productType = "SONG";
        productId = songv2.songId;
        price = 0;
        currencyId = 0;
        isNew = false;
        sale = false;
        subscriberOnly = false;
        isFree = false;
        song = songv2;
        soundfont = null;
        storePrice = 0.0F;
        modes = new ArrayList();
    }

    public static List a(List list)
    {
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.add(((ListingV2)list.next()).listingId)) { }
        return arraylist;
    }

    static String c()
    {
        return a;
    }

    public boolean a()
    {
        return subscriberOnly;
    }

    public boolean b()
    {
        return modes != null && modes.contains("join");
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeString(listingId);
        parcel.writeLong(ts);
        String s;
        if (productType == null)
        {
            s = "";
        } else
        {
            s = productType;
        }
        parcel.writeString(s);
        if (productId == null)
        {
            s = "";
        } else
        {
            s = productId;
        }
        parcel.writeString(s);
        parcel.writeInt(price);
        parcel.writeInt(currencyId);
        if (isNew)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (sale)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (subscriberOnly)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (isFree)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        parcel.writeParcelable(song, 0);
        parcel.writeParcelable(soundfont, 0);
        parcel.writeFloat(storePrice);
        parcel.writeStringList(modes);
    }

}
