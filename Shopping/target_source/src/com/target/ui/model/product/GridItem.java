// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.product;

import android.os.Parcel;
import android.os.Parcelable;
import java.net.URL;

public class GridItem
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public GridItem a(Parcel parcel)
        {
            return new GridItem(parcel);
        }

        public GridItem[] a(int i)
        {
            return new GridItem[i];
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
    private static final String TAG = com/target/ui/model/product/GridItem.getSimpleName();
    private final String mContentDescription;
    private final URL mImageUrl;
    private final String mKey;

    private GridItem(Parcel parcel)
    {
        mKey = parcel.readString();
        mContentDescription = parcel.readString();
        mImageUrl = (URL)parcel.readSerializable();
    }


    public GridItem(String s, String s1, URL url)
    {
        mKey = s;
        mImageUrl = url;
        mContentDescription = s1;
    }

    public String a()
    {
        return mKey;
    }

    public String b()
    {
        return mContentDescription;
    }

    public URL c()
    {
        return mImageUrl;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        boolean flag3 = false;
        boolean flag;
        boolean flag1;
        boolean flag2;
        if (obj instanceof GridItem)
        {
            obj = (GridItem)obj;
            flag1 = mKey.equals(((GridItem) (obj)).a());
            flag = mContentDescription.equals(((GridItem) (obj)).b());
        } else
        {
            flag = false;
            flag1 = false;
        }
        flag2 = flag3;
        if (flag1)
        {
            flag2 = flag3;
            if (flag)
            {
                flag2 = true;
            }
        }
        return flag2;
    }

    public int hashCode()
    {
        return mContentDescription.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mKey);
        parcel.writeString(mContentDescription);
        parcel.writeSerializable(mImageUrl);
    }

}
