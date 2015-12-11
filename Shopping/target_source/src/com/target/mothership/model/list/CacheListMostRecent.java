// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.model.list.interfaces.ListMostRecent;
import java.util.Date;

class CacheListMostRecent
    implements Parcelable, ListMostRecent
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CacheListMostRecent a(Parcel parcel)
        {
            return new CacheListMostRecent(parcel);
        }

        public CacheListMostRecent[] a(int i)
        {
            return new CacheListMostRecent[i];
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
    public static final String GUEST_ID_FIELD = "mGuestId";
    public static final String LAST_MODIFIED_DATE_FIELD = "mLastModifiedDate";
    public static final String LIST_MOST_RECENT_TABLE = "list_most_recent";
    public static final String TITLE_FIELD = "mTitle";
    public static final String TYPE_FIELD = "mType";
    private String mGuestId;
    private int mKey;
    private Date mLastModifiedDate;
    private String mTitle;
    private com.target.mothership.model.list.interfaces.ListMostRecent.a mType;

    public CacheListMostRecent()
    {
    }

    private CacheListMostRecent(Parcel parcel)
    {
        mKey = parcel.readInt();
        mTitle = parcel.readString();
        mGuestId = parcel.readString();
        long l = parcel.readLong();
        if (l == -1L)
        {
            parcel = null;
        } else
        {
            parcel = new Date(l);
        }
        mLastModifiedDate = parcel;
    }


    public CacheListMostRecent(String s, com.target.mothership.model.list.interfaces.ListMostRecent.a a1)
    {
        mTitle = s;
        mType = a1;
    }

    public int a()
    {
        return mKey;
    }

    public void a(Date date)
    {
        mLastModifiedDate = date;
    }

    public String b()
    {
        return mTitle;
    }

    public com.target.mothership.model.list.interfaces.ListMostRecent.a c()
    {
        return mType;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(mKey);
        parcel.writeString(mTitle);
        parcel.writeString(mGuestId);
        long l;
        if (mLastModifiedDate != null)
        {
            l = mLastModifiedDate.getTime();
        } else
        {
            l = -1L;
        }
        parcel.writeLong(l);
    }

}
