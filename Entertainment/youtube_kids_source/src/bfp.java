// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import android.os.Parcelable;

public final class bfp
    implements Parcelable, bn
{

    public static final android.os.Parcelable.Creator CREATOR = new bfq();
    public final bft a;
    public final long b;
    public final bfr c;

    public bfp(Parcel parcel)
    {
        this(bft.values()[parcel.readInt()], parcel.readLong());
    }

    public bfp(bft bft1, long l)
    {
        boolean flag4;
label0:
        {
            flag4 = true;
            super();
            a = (bft)b.a(bft1);
            long l1;
            boolean flag5;
            if (l >= 0L)
            {
                flag5 = true;
            } else
            {
                flag5 = false;
            }
            b.a(flag5);
            if (bft1 == bft.c || bft1 == bft.d)
            {
                l1 = 0L;
            } else
            {
                l1 = l;
            }
            b = l1;
            if (bft1 != bft.c && (bft1 != bft.a || l != 0L))
            {
                boolean flag;
                boolean flag2;
                if (bft1 == bft.b)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (l == 0L)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                if (!(flag2 & flag))
                {
                    break label0;
                }
            }
            c = bfr.a;
            return;
        }
label1:
        {
            if (bft1 != bft.d)
            {
                boolean flag1;
                boolean flag3;
                if (bft1 == bft.b)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (l == 100L)
                {
                    flag3 = flag4;
                } else
                {
                    flag3 = false;
                }
                if (!(flag1 & flag3))
                {
                    break label1;
                }
            }
            c = bfr.c;
            return;
        }
        c = bfr.b;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (obj != null && getClass().equals(obj.getClass()))
        {
            if (a == ((bfp) (obj = (bfp)obj)).a && b == ((bfp) (obj)).b && c == ((bfp) (obj)).c)
            {
                return true;
            }
        }
        return false;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(a.ordinal());
        parcel.writeLong(b);
    }

    static 
    {
        new bfs();
    }
}
