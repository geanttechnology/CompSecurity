// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.product;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.util.o;

public class CategoryId
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CategoryId a(Parcel parcel)
        {
            return new CategoryId(parcel);
        }

        public CategoryId[] a(int i)
        {
            return new CategoryId[i];
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

    public CategoryId(Parcel parcel)
    {
        a(parcel);
    }

    public CategoryId(String s)
    {
        if (o.c(s))
        {
            throw new IllegalArgumentException("Category id may not be empty or null");
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

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (CategoryId)obj;
            if (mRawId == null ? ((CategoryId) (obj)).mRawId != null : !mRawId.equals(((CategoryId) (obj)).mRawId))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return mRawId.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mRawId);
    }

}
