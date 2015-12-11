// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import android.text.TextUtils;

public class cwf
    implements cwh
{

    public static final android.os.Parcelable.Creator CREATOR = new cwg();
    public final bxb a;
    public final bum b;
    public final String c;
    public final String d;
    public final byte e[];
    public final int f;
    public final int g;
    public final boolean h;
    public final cwb i;

    public cwf(Parcel parcel)
    {
        Object obj = null;
        super();
        String s1 = parcel.readString();
        String s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = null;
        }
        c = s;
        s = parcel.readString();
        if (TextUtils.isEmpty(s))
        {
            s = obj;
        }
        d = s;
        e = new byte[parcel.readInt()];
        parcel.readByteArray(e);
        a = (bxb)parcel.readParcelable(getClass().getClassLoader());
        b = (bum)parcel.readParcelable(getClass().getClassLoader());
        f = parcel.readInt();
        g = parcel.readInt();
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        h = flag;
        i = (cwb)parcel.readParcelable(getClass().getClassLoader());
    }

    public cwf(String s, String s1, byte abyte0[], bxb bxb1, bum bum1, int j, int k, 
            boolean flag, cwb cwb1)
    {
        c = s;
        d = s1;
        e = abyte0;
        a = bxb1;
        b = bum1;
        f = j;
        g = k;
        h = flag;
        i = cwb1;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int j)
    {
        String s;
        if (c != null)
        {
            s = c;
        } else
        {
            s = "";
        }
        parcel.writeString(s);
        if (d != null)
        {
            s = d;
        } else
        {
            s = "";
        }
        parcel.writeString(s);
        parcel.writeInt(e.length);
        parcel.writeByteArray(e);
        parcel.writeParcelable(a, 0);
        parcel.writeParcelable(b, 0);
        parcel.writeInt(f);
        parcel.writeInt(g);
        if (h)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        parcel.writeParcelable(i, 0);
    }

}
