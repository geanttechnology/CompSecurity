// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.product;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.util.o;

public class EndecaId
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public EndecaId a(Parcel parcel)
        {
            return new EndecaId(parcel);
        }

        public EndecaId[] a(int i)
        {
            return new EndecaId[i];
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

    public EndecaId(Parcel parcel)
    {
        a(parcel);
    }

    public EndecaId(String s)
    {
        if (o.c(s))
        {
            throw new IllegalArgumentException("EndecaId id may not be empty or null");
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
            obj = (EndecaId)obj;
            if (mRawId == null ? ((EndecaId) (obj)).mRawId != null : !mRawId.equals(((EndecaId) (obj)).mRawId))
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
