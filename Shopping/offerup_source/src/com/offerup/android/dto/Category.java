// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class Category
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private int id;
    private String name;

    public Category()
    {
    }

    public int describeContents()
    {
        return 0;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setId(int i)
    {
        id = i;
    }

    public void setName(String s)
    {
        name = s;
    }

    public String toString()
    {
        return (new StringBuilder("Category [name=")).append(name).append(", id=").append(id).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(name);
        parcel.writeInt(id);
    }



/*
    static String access$002(Category category, String s)
    {
        category.name = s;
        return s;
    }

*/


/*
    static int access$102(Category category, int i)
    {
        category.id = i;
        return i;
    }

*/

    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final Category createFromParcel(Parcel parcel)
        {
            Category category = new Category();
            category.name = parcel.readString();
            category.id = parcel.readInt();
            return category;
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final Category[] newArray(int i)
        {
            return new Category[i];
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        _cls1()
        {
        }
    }

}
