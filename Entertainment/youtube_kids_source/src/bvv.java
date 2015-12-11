// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public final class bvv
    implements Parcelable, bn
{

    public static final android.os.Parcelable.Creator CREATOR = new bvw();
    public final Uri a;
    private final int b;

    public bvv(int i, Uri uri)
    {
        b = i;
        a = uri;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (obj != null && getClass().equals(obj.getClass()))
        {
            obj = (bvv)obj;
            if (b.a(Integer.valueOf(b), Integer.valueOf(((bvv) (obj)).b)) && b.a(a, ((bvv) (obj)).a))
            {
                return true;
            }
        }
        return false;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(b);
        parcel.writeParcelable(a, 0);
    }

    static 
    {
        new bvx();
    }
}
