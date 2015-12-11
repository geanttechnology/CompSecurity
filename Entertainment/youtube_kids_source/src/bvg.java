// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public final class bvg
    implements Parcelable, bn
{

    public static final android.os.Parcelable.Creator CREATOR = new bvh();
    public final Uri a;
    private final int b;
    private final boolean c;

    public bvg(int i, boolean flag, Uri uri)
    {
        b = i;
        c = flag;
        a = uri;
    }

    public final int a(int i)
    {
        if (c)
        {
            return (b * i * 1000) / 100;
        } else
        {
            return b;
        }
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (obj != null && getClass().equals(obj.getClass()))
        {
            obj = (bvg)obj;
            if (b == ((bvg) (obj)).b && b.a(Boolean.valueOf(c), Boolean.valueOf(((bvg) (obj)).c)) && b.a(a, ((bvg) (obj)).a))
            {
                return true;
            }
        }
        return false;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(b);
        if (c)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeParcelable(a, 0);
    }

    static 
    {
        new bvi();
    }
}
