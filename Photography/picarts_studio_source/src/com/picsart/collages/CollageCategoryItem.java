// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class CollageCategoryItem
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new CollageCategoryItem(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new CollageCategoryItem[i];
        }

    };
    public String a;
    public String b;
    public List c;

    public CollageCategoryItem()
    {
        c = new ArrayList();
    }

    public CollageCategoryItem(Parcel parcel)
    {
        c = new ArrayList();
        a = parcel.readString();
        b = parcel.readString();
        c = parcel.readArrayList(com/picsart/collages/CollageCategoryItem$CollagePreviewItem.getClassLoader());
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(a);
        parcel.writeString(b);
        parcel.writeList(c);
    }

}
