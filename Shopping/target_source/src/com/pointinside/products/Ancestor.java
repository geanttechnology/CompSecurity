// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;

import android.os.Parcel;
import android.os.Parcelable;
import com.pointinside.internal.utils.StringUtils;

public class Ancestor
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Ancestor createFromParcel(Parcel parcel)
        {
            return new Ancestor(parcel.readString(), parcel.readString());
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Ancestor[] newArray(int i)
        {
            return new Ancestor[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final String name;
    public final String title;

    public Ancestor(String s, String s1)
    {
        title = s;
        name = s1;
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        StringUtils.appendIfNotNull(stringbuilder, " Name", name);
        StringUtils.appendIfNotNull(stringbuilder, " Title", title);
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(title);
        parcel.writeString(name);
    }

}
