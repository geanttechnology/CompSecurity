// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;

public final class cyi
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new cyj();
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    public cyi(int i, int j, int k, int l, int i1, int j1)
    {
        a = i;
        b = j;
        c = k;
        d = l;
        e = i1;
        f = j1;
    }

    cyi(Parcel parcel)
    {
        a = parcel.readInt();
        b = parcel.readInt();
        c = parcel.readInt();
        d = parcel.readInt();
        e = parcel.readInt();
        f = parcel.readInt();
    }

    public cyi(android.view.accessibility.CaptioningManager.CaptionStyle captionstyle, int i)
    {
        a = captionstyle.backgroundColor;
        c = captionstyle.edgeColor;
        d = captionstyle.edgeType;
        e = captionstyle.foregroundColor;
        b = i;
        f = 7;
    }

    public static final String a(int i)
    {
        return String.format("#%06X", new Object[] {
            Integer.valueOf(0xffffff & i)
        });
    }

    public static final String b(int i)
    {
        double d1 = (double)Color.alpha(i) / 255D;
        if (d1 < 0.0D)
        {
            return "0.0";
        } else
        {
            return String.format("%.2f", new Object[] {
                Double.valueOf(d1)
            });
        }
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(a);
        parcel.writeInt(b);
        parcel.writeInt(c);
        parcel.writeInt(d);
        parcel.writeInt(e);
        parcel.writeInt(f);
    }

}
