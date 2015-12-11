// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import android.os.Parcelable;

public final class cwr
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new cws();
    private final String a;
    private final long b;
    private final long c;
    private final String d;
    private final long e;

    public cwr(Parcel parcel)
    {
        a = parcel.readString();
        b = parcel.readLong();
        c = parcel.readLong();
        d = parcel.readString();
        e = parcel.readLong();
    }

    public cwr(String s, long l, long l1, String s1, long l2)
    {
        a = s;
        b = l;
        c = l1;
        d = s1;
        e = l2;
    }

    public static String a(cwr cwr1)
    {
        return cwr1.a;
    }

    public static long b(cwr cwr1)
    {
        return cwr1.b;
    }

    public static long c(cwr cwr1)
    {
        return cwr1.c;
    }

    public static String d(cwr cwr1)
    {
        return cwr1.d;
    }

    public static long e(cwr cwr1)
    {
        return cwr1.e;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(a);
        parcel.writeLong(b);
        parcel.writeLong(c);
        parcel.writeString(d);
        parcel.writeLong(e);
    }

}
