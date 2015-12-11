// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.page_item;

import android.os.Parcel;
import android.os.Parcelable;

public class PreviewSuffix
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public PreviewSuffix a(Parcel parcel)
        {
            return new PreviewSuffix(parcel);
        }

        public PreviewSuffix[] a(int i)
        {
            return new PreviewSuffix[i];
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
    private String mValue;

    private PreviewSuffix(Parcel parcel)
    {
        mValue = parcel.readString();
    }


    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mValue);
    }

}
