// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

public class cwk
    implements cwh
{

    public static final android.os.Parcelable.Creator CREATOR = new cwl();
    public final bxb a;
    public final bum b;
    public cto c;
    public cto d;
    public final boolean e;
    public final boolean f;
    public final cwb g;

    public cwk(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        ClassLoader classloader = getClass().getClassLoader();
        a = (bxb)parcel.readParcelable(classloader);
        b = (bum)parcel.readParcelable(classloader);
        c = (cto)parcel.readParcelable(classloader);
        d = (cto)parcel.readParcelable(classloader);
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        e = flag;
        if (parcel.readInt() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        f = flag;
        g = (cwb)parcel.readParcelable(classloader);
    }

    public cwk(bxb bxb1, bum bum1, cto cto1, cto cto2, boolean flag, boolean flag1, cwb cwb1)
    {
        a = bxb1;
        b = bum1;
        c = cto1;
        d = cto2;
        e = flag;
        f = flag1;
        g = cwb1;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeParcelable(a, 0);
        parcel.writeParcelable(b, 0);
        parcel.writeParcelable(c, 0);
        parcel.writeParcelable(d, 0);
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
        parcel.writeParcelable(g, 0);
    }

}
