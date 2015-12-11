// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public final class cxy
    implements Parcelable, Serializable
{

    public static final android.os.Parcelable.Creator CREATOR = new cxz();
    public static final cxy a = new cxy(34, 50, 95, true, false);
    public final int b;
    public final int c;
    public final int d;
    public final boolean e;
    public final boolean f;

    public cxy(int i, int j, int k, boolean flag, boolean flag1)
    {
        boolean flag3 = true;
        super();
        boolean flag2;
        if (j >= 0 && j <= 100)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        b.a(flag2, (new StringBuilder(40)).append("invalid anchorHorizontalPos: ").append(j).toString());
        if (k >= 0 && k <= 100)
        {
            flag2 = flag3;
        } else
        {
            flag2 = false;
        }
        b.a(flag2, (new StringBuilder(38)).append("invalid anchorVerticalPos: ").append(k).toString());
        b = i;
        c = j;
        d = k;
        e = flag;
        f = flag1;
    }

    cxy(Parcel parcel)
    {
        boolean flag1 = false;
        int i = parcel.readInt();
        int j = parcel.readInt();
        int k = parcel.readInt();
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (parcel.readInt() == 1)
        {
            flag1 = true;
        }
        this(i, j, k, flag, flag1);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final String toString()
    {
        return String.format("ap=%d, ah=%d, av=%d, vs=%b, sd=%b", new Object[] {
            Integer.valueOf(b), Integer.valueOf(c), Integer.valueOf(d), Boolean.valueOf(e), Boolean.valueOf(f)
        });
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeInt(b);
        parcel.writeInt(c);
        parcel.writeInt(d);
        if (e)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (f)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }

}
