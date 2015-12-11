// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

public class cwi
    implements cwh
{

    public static final android.os.Parcelable.Creator CREATOR = new cwj();
    public final String a[];
    public final byte b[];
    public final String c;
    public final int d;
    public final int e;
    public final bxb f;
    public final boolean g;
    public final cwb h;

    public cwi(Parcel parcel)
    {
        a = new String[parcel.readInt()];
        parcel.readStringArray(a);
        b = new byte[parcel.readInt()];
        parcel.readByteArray(b);
        c = parcel.readString();
        d = parcel.readInt();
        e = parcel.readInt();
        f = (bxb)parcel.readParcelable(getClass().getClassLoader());
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        g = flag;
        h = (cwb)parcel.readParcelable(getClass().getClassLoader());
    }

    public cwi(String as[], byte abyte0[], String s, int i, int j, bxb bxb1, boolean flag, 
            cwb cwb1)
    {
        a = as;
        b = abyte0;
        c = s;
        d = i;
        e = j;
        f = bxb1;
        g = flag;
        h = cwb1;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(a.length);
        parcel.writeStringArray(a);
        parcel.writeInt(b.length);
        parcel.writeByteArray(b);
        parcel.writeString(c);
        parcel.writeInt(d);
        parcel.writeInt(e);
        parcel.writeParcelable(f, 0);
        if (g)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeParcelable(h, 0);
    }

}
