// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import android.os.Parcel;
import android.os.Parcelable;

public class AutoFillSuggestion
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public AutoFillSuggestion createFromParcel(Parcel parcel)
        {
            return new AutoFillSuggestion(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public AutoFillSuggestion[] newArray(int i)
        {
            return new AutoFillSuggestion[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String categoryId;
    public String categoryName;
    public String title;

    public AutoFillSuggestion()
    {
    }

    AutoFillSuggestion(Parcel parcel)
    {
        title = parcel.readString();
        categoryId = parcel.readString();
        categoryName = parcel.readString();
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        return title;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(title);
        parcel.writeString(categoryId);
        parcel.writeString(categoryName);
    }

}
