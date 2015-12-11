// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

public class cwm
    implements cwh
{

    public static final android.os.Parcelable.Creator CREATOR = new cwn();
    public final bum a;
    public final cwi b;

    public cwm(Parcel parcel)
    {
        a = (bum)parcel.readParcelable(getClass().getClassLoader());
        b = (cwi)parcel.readParcelable(getClass().getClassLoader());
    }

    public cwm(bum bum1, cwi cwi1)
    {
        a = bum1;
        b = cwi1;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(a, 0);
        parcel.writeParcelable(b, 0);
    }

}
