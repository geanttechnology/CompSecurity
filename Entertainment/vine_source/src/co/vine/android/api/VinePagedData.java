// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public class VinePagedData
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VinePagedData createFromParcel(Parcel parcel)
        {
            return new VinePagedData(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VinePagedData[] newArray(int i)
        {
            return new VinePagedData[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public long anchor;
    public int count;
    public ArrayList items;
    public int nextPage;
    public int previousPage;
    public int size;
    public String stringAnchor;
    public String title;

    public VinePagedData()
    {
        previousPage = -1;
    }

    public VinePagedData(Parcel parcel)
    {
        previousPage = -1;
        anchor = parcel.readLong();
        count = parcel.readInt();
        nextPage = parcel.readInt();
        previousPage = parcel.readInt();
        size = parcel.readInt();
        items = new ArrayList();
        Parcelable aparcelable[] = parcel.readParcelableArray(co/vine/android/api/VinePagedData.getClassLoader());
        int j = aparcelable.length;
        for (int i = 0; i < j; i++)
        {
            Parcelable parcelable = aparcelable[i];
            items.add(parcelable);
        }

        title = parcel.readString();
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean isEmpty()
    {
        return items != null && items.isEmpty();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(anchor);
        parcel.writeInt(count);
        parcel.writeInt(nextPage);
        parcel.writeInt(previousPage);
        parcel.writeInt(size);
        if (items == null)
        {
            parcel.writeParcelableArray((Parcelable[])(new ArrayList()).toArray(new Parcelable[0]), i);
        } else
        {
            parcel.writeParcelableArray((Parcelable[])items.toArray(new Parcelable[items.size()]), i);
        }
        parcel.writeString(title);
    }

}
