// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class bgj
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new bgk();
    public final int a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final List e;
    public final int f;
    public final bgl g;

    public bgj(int i, boolean flag, boolean flag1, boolean flag2, List list, int j, bgl bgl1)
    {
        a = i;
        b = flag;
        c = flag1;
        d = flag2;
        e = a.a(list);
        f = j;
        g = bgl1;
    }

    public bgj(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        a = parcel.readInt();
        ArrayList arraylist;
        boolean flag;
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
            flag = flag1;
        } else
        {
            flag = false;
        }
        d = flag;
        arraylist = new ArrayList();
        parcel.readStringList(arraylist);
        e = a.a(arraylist);
        f = parcel.readInt();
        g = bgl.a(parcel.readString());
    }

    public final int describeContents()
    {
        return 0;
    }

    public final String toString()
    {
        String s = String.valueOf(Integer.toHexString(System.identityHashCode(this)));
        int i = a;
        boolean flag = b;
        boolean flag1 = c;
        String s1 = String.valueOf(TextUtils.join(",", e));
        String s2 = String.valueOf(g);
        return (new StringBuilder(String.valueOf(s).length() + 143 + String.valueOf(s1).length() + String.valueOf(s2).length())).append("AdsStatsClient.AdsStatsClientState{").append(s).append(" nextQuartile=").append(i).append(" engagedViewPinged=").append(flag).append(" impressionPinged=").append(flag1).append(" pingedCustomConversionTypes=").append(s1).append(" kind=").append(s2).append("}").toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeInt(a);
        String s;
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
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeStringList(e);
        parcel.writeInt(f);
        if (g == null)
        {
            s = "";
        } else
        {
            s = g.c;
        }
        parcel.writeString(s);
    }

}
