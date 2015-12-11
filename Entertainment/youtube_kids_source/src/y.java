// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import android.os.Parcelable;

final class y
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new z();
    aa a[];
    int b[];
    g c[];

    public y()
    {
    }

    public y(Parcel parcel)
    {
        a = (aa[])parcel.createTypedArray(aa.CREATOR);
        b = parcel.createIntArray();
        c = (g[])parcel.createTypedArray(g.CREATOR);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeTypedArray(a, i);
        parcel.writeIntArray(b);
        parcel.writeTypedArray(c, i);
    }

}
