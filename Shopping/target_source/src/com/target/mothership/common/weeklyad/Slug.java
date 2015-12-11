// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.weeklyad;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class Slug
    implements Parcelable, Comparable
{

    private String mRawId;

    protected Slug(Parcel parcel)
    {
        mRawId = parcel.readString();
    }

    public Slug(String s)
    {
        mRawId = s;
    }

    public int a(Slug slug)
    {
        if (slug == null)
        {
            return 0;
        } else
        {
            return mRawId.compareTo(slug.a());
        }
    }

    public String a()
    {
        return mRawId;
    }

    public int compareTo(Object obj)
    {
        return a((Slug)obj);
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
