// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.page_item;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.util.o;

public class PageIdentifier
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public PageIdentifier a(Parcel parcel)
        {
            return new PageIdentifier(parcel);
        }

        public PageIdentifier[] a(int i)
        {
            return new PageIdentifier[i];
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
    private String mRawId;

    private PageIdentifier(Parcel parcel)
    {
        a(parcel);
    }


    public PageIdentifier(String s)
    {
        if (o.c(s))
        {
            throw new IllegalArgumentException("page id may not be blank or null");
        } else
        {
            mRawId = s;
            return;
        }
    }

    public String a()
    {
        return mRawId;
    }

    public void a(Parcel parcel)
    {
        mRawId = parcel.readString();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mRawId);
    }

}
