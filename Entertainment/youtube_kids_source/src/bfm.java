// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import android.os.Parcelable;

public final class bfm
    implements Parcelable, cry
{

    public static final android.os.Parcelable.Creator CREATOR = new bfn();
    public final bfz a;
    public final buz b;

    public bfm(bfz bfz1, buz buz)
    {
        a = (bfz)b.a(bfz1);
        b = buz;
    }

    public final buz a()
    {
        return b;
    }

    public final boolean b()
    {
        return a == null;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (obj != null && getClass().equals(obj.getClass()))
        {
            obj = (bfm)obj;
            if (b.a(a, ((bfm) (obj)).a) && b.a(b, ((bfm) (obj)).b))
            {
                return true;
            }
        }
        return false;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(a, 0);
        parcel.writeParcelable(b, 0);
    }

}
