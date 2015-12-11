// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models;

import android.os.Parcel;
import android.os.Parcelable;

public class SearchSuggestion
    implements Parcelable
{
    public static class List
    {

        public java.util.List dealsAutocompleteResults;

        public List()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Object createFromParcel(Parcel parcel)
        {
            return new SearchSuggestion(parcel);
        }

        public Object[] newArray(int i)
        {
            return new Object[0];
        }

    };
    public String label;
    public String value;

    public SearchSuggestion()
    {
    }

    public SearchSuggestion(Parcel parcel)
    {
        value = parcel.readString();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(value);
    }

}
