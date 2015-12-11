// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import android.os.Parcelable;

public final class cve
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new cvf();
    public final long a;
    private long b;

    public cve(long l, long l1)
    {
        a = l;
        b = l1;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (obj != null && getClass().equals(obj.getClass()))
        {
            if (a == ((cve) (obj = (cve)obj)).a && b == ((cve) (obj)).b)
            {
                return true;
            }
        }
        return false;
    }

    public final int hashCode()
    {
        return (int)(a * 31L + b);
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(a);
        parcel.writeLong(b);
    }

}
