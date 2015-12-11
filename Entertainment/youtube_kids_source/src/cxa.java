// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import android.os.Parcelable;
import java.util.PriorityQueue;

public final class cxa
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new cxb();
    private final btv a[];
    private final String b;

    public cxa(Parcel parcel)
    {
        a = (btv[])parcel.createTypedArray(btv.CREATOR);
        b = parcel.readString();
    }

    public cxa(PriorityQueue priorityqueue, String s)
    {
        a = (btv[])priorityqueue.toArray(new btv[priorityqueue.size()]);
        b = s;
    }

    public static btv[] a(cxa cxa1)
    {
        return cxa1.a;
    }

    public static String b(cxa cxa1)
    {
        return cxa1.b;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeTypedArray(a, i);
        parcel.writeString(b);
    }

}
