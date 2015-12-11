// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.smule.android.network.models:
//            SongV2, ArrangementVersionLite, c

public class SearchSongbookResult
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SearchSongbookResult a(Parcel parcel)
        {
            return new SearchSongbookResult(parcel);
        }

        public SearchSongbookResult[] a(int i)
        {
            return new SearchSongbookResult[i];
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
    public ArrangementVersionLite mArrangementVersionLite;
    public SongV2 mSongLite;
    public c mType;

    public SearchSongbookResult()
    {
    }

    public SearchSongbookResult(Parcel parcel)
    {
        int i = parcel.readInt();
        c c1;
        if (i == -1)
        {
            c1 = null;
        } else
        {
            c1 = c.values()[i];
        }
        mType = c1;
        mSongLite = (SongV2)parcel.readParcelable(com/smule/android/network/models/SongV2.getClassLoader());
        mArrangementVersionLite = (ArrangementVersionLite)parcel.readParcelable(com/smule/android/network/models/ArrangementVersionLite.getClassLoader());
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        return (new StringBuilder()).append("SearchSongbookResult{mType=").append(mType).append(", mSongLite=").append(mSongLite).append(", mArrangementVersionLite=").append(mArrangementVersionLite).append('}').toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (mType == null)
        {
            i = -1;
        } else
        {
            i = mType.ordinal();
        }
        parcel.writeInt(i);
        parcel.writeParcelable(mSongLite, 0);
        parcel.writeParcelable(mArrangementVersionLite, 0);
    }

}
