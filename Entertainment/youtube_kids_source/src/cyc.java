// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public final class cyc
    implements Parcelable, Serializable
{

    public static final android.os.Parcelable.Creator CREATOR = new cyd();
    public final int a;
    public final cxy b;
    public final String c;
    public final String d;
    private int e;

    public cyc(int i, int j, String s, String s1, cxy cxy1)
    {
        a = i;
        e = j;
        c = s;
        b = cxy1;
        d = s1;
    }

    cyc(Parcel parcel)
    {
        this(parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), (cxy)parcel.readParcelable(cxy.getClassLoader()));
    }

    public final int describeContents()
    {
        return 0;
    }

    public final String toString()
    {
        return String.format("id: %d time: %d text: %s fullText: %s settings: %s", new Object[] {
            Integer.valueOf(a), Integer.valueOf(e), c, d, b.toString()
        });
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(a);
        parcel.writeInt(e);
        parcel.writeString(c);
        parcel.writeString(d);
        parcel.writeParcelable(b, 0);
    }

}
