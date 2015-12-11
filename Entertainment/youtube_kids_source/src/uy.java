// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import android.os.Parcelable;

public final class uy
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new uz();
    public final cto a;
    public final uw b;
    public final ri c;
    public final cwh d;
    public final boolean e;

    public uy(Parcel parcel)
    {
        ClassLoader classloader = getClass().getClassLoader();
        a = (cto)parcel.readParcelable(classloader);
        b = (uw)parcel.readParcelable(classloader);
        c = (ri)parcel.readParcelable(classloader);
        d = (cwh)parcel.readParcelable(classloader);
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        e = flag;
    }

    public uy(cto cto1, uw uw1, cwh cwh1, ri ri1, boolean flag)
    {
        a = cto1;
        b = uw1;
        c = ri1;
        d = cwh1;
        e = flag;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        i = 0;
        parcel.writeParcelable(a, 0);
        parcel.writeParcelable(b, 0);
        parcel.writeParcelable(c, 0);
        parcel.writeParcelable(d, 0);
        if (e)
        {
            i = 1;
        }
        parcel.writeInt(i);
    }

}
