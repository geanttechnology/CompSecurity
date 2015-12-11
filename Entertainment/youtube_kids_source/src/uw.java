// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import android.os.Parcelable;

public final class uw
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new ux();
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;

    public uw(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b = flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c = flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d = flag;
        if (parcel.readInt() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        e = flag;
    }

    public uw(boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4)
    {
        a = flag;
        b = flag1;
        c = flag2;
        d = flag3;
        e = flag4;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        if (a)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (b)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (c)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (d)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (e)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }

}
