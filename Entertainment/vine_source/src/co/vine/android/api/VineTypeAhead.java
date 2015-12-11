// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.os.Parcel;
import android.os.Parcelable;

public class VineTypeAhead
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VineTypeAhead createFromParcel(Parcel parcel)
        {
            return new VineTypeAhead(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VineTypeAhead[] newArray(int i)
        {
            return new VineTypeAhead[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public long id;
    public final String token;
    public final String type;

    public VineTypeAhead(Parcel parcel)
    {
        id = parcel.readLong();
        token = parcel.readString();
        type = parcel.readString();
    }

    public VineTypeAhead(String s, String s1, long l)
    {
        id = l;
        token = s1;
        type = s;
    }

    public static String getPlainTag(String s)
    {
        return s.substring(1, s.length());
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(id);
        parcel.writeString(token);
        parcel.writeString(type);
    }

}
