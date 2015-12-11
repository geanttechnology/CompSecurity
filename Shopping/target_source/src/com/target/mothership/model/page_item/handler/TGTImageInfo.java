// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.page_item.handler;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.common.page_item.c;
import com.target.mothership.model.page_item.interfaces.ImageInfo;
import com.target.mothership.util.p;

class TGTImageInfo
    implements ImageInfo
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTImageInfo a(Parcel parcel)
        {
            return new TGTImageInfo(parcel);
        }

        public TGTImageInfo[] a(int i)
        {
            return new TGTImageInfo[i];
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
    private String mAccessibilityText;
    private int mCachedHeight;
    private String mCachedUri;
    private c mImageType;
    private String mUri;

    TGTImageInfo()
    {
    }

    private TGTImageInfo(Parcel parcel)
    {
        mAccessibilityText = parcel.readString();
        mCachedHeight = parcel.readInt();
        mCachedUri = parcel.readString();
        int i = parcel.readInt();
        c c1;
        if (i == -1)
        {
            c1 = null;
        } else
        {
            c1 = c.values()[i];
        }
        mImageType = c1;
        mUri = parcel.readString();
    }


    public e a()
    {
        return e.c(mAccessibilityText);
    }

    public String a(int i)
    {
        if (i == mCachedHeight)
        {
            return mCachedUri;
        } else
        {
            mCachedHeight = i;
            mCachedUri = p.a(mUri, i, mImageType);
            return mCachedUri;
        }
    }

    public void a(c c1)
    {
        mImageType = c1;
    }

    public void a(String s)
    {
        mAccessibilityText = s;
    }

    public String b()
    {
        return mUri;
    }

    public void b(String s)
    {
        mUri = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mAccessibilityText);
        parcel.writeInt(mCachedHeight);
        parcel.writeString(mCachedUri);
        if (mImageType == null)
        {
            i = -1;
        } else
        {
            i = mImageType.ordinal();
        }
        parcel.writeInt(i);
        parcel.writeString(mUri);
    }

}
