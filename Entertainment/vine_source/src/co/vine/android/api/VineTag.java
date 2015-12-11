// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class VineTag
    implements Parcelable, Serializable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VineTag createFromParcel(Parcel parcel)
        {
            return new VineTag(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VineTag[] newArray(int i)
        {
            return new VineTag[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public long tagId;
    public String tagName;

    public VineTag()
    {
    }

    public VineTag(Parcel parcel)
    {
        tagName = parcel.readString();
        tagId = parcel.readLong();
    }

    public VineTag(String s, long l)
    {
        tagName = s;
        tagId = l;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(tagName);
        parcel.writeLong(tagId);
    }

}
