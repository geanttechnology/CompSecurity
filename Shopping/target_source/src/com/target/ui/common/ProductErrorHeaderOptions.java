// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.a.a.e;

public class ProductErrorHeaderOptions
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ProductErrorHeaderOptions a(Parcel parcel)
        {
            return new ProductErrorHeaderOptions(parcel);
        }

        public ProductErrorHeaderOptions[] a(int i)
        {
            return new ProductErrorHeaderOptions[i];
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
    private com.target.ui.view.common.b.a mErrorType;
    private boolean mShowLargeSize;
    private boolean mShowTryAgain;
    private String mSubtitle;
    private String mTitle;

    protected ProductErrorHeaderOptions(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        com.target.ui.view.common.b.a a1;
        int i;
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mShowLargeSize = flag;
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        mShowTryAgain = flag;
        i = parcel.readInt();
        if (i == -1)
        {
            a1 = null;
        } else
        {
            a1 = com.target.ui.view.common.b.a.values()[i];
        }
        mErrorType = a1;
        mSubtitle = parcel.readString();
        mTitle = parcel.readString();
    }

    public ProductErrorHeaderOptions(String s, String s1, boolean flag, boolean flag1)
    {
        mTitle = s;
        mSubtitle = s1;
        mShowTryAgain = flag;
        mShowLargeSize = flag1;
    }

    public boolean a()
    {
        return mShowLargeSize;
    }

    public boolean b()
    {
        return mShowTryAgain;
    }

    public e c()
    {
        return com.google.a.a.e.c(mErrorType);
    }

    public e d()
    {
        return com.google.a.a.e.c(mTitle);
    }

    public int describeContents()
    {
        return 0;
    }

    public e e()
    {
        return com.google.a.a.e.c(mSubtitle);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        if (mShowLargeSize)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (mShowTryAgain)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (mErrorType == null)
        {
            i = -1;
        } else
        {
            i = mErrorType.ordinal();
        }
        parcel.writeInt(i);
        parcel.writeString(mSubtitle);
        parcel.writeString(mTitle);
    }

}
