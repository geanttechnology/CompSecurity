// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.os.Parcel;
import android.os.Parcelable;

public class b
    implements Parcelable
{

    public static final android.os.eviewItem.b CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new CollageCategoryItem.CollagePreviewItem(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new CollageCategoryItem.CollagePreviewItem[i];
        }

    };
    public int a;
    public String b;

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(a);
        parcel.writeString(b);
    }


    public _cls1()
    {
    }

    public _cls1(Parcel parcel)
    {
        a = parcel.readInt();
        b = parcel.readString();
    }
}
