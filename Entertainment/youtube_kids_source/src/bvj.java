// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Collections;
import java.util.List;

public final class bvj
    implements Parcelable, bn
{

    public static final android.os.Parcelable.Creator CREATOR = new bvk();
    private final int a;
    private final List b;
    private final List c;
    private final bvr d;

    private bvj(int i, List list, List list1, bvr bvr)
    {
        a = i;
        b = Collections.unmodifiableList((List)b.a(list));
        c = Collections.unmodifiableList((List)b.a(list1));
        d = bvr;
    }

    bvj(int i, List list, List list1, bvr bvr, byte byte0)
    {
        this(i, list, list1, bvr);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (obj != null && getClass().equals(obj.getClass()))
        {
            obj = (bvj)obj;
            if (b.a(Integer.valueOf(a), Integer.valueOf(((bvj) (obj)).a)) && b.a(c, ((bvj) (obj)).c) && b.a(b, ((bvj) (obj)).b) && b.a(d, ((bvj) (obj)).d))
            {
                return true;
            }
        }
        return false;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(a);
        parcel.writeTypedList(b);
        parcel.writeTypedList(c);
        parcel.writeParcelable(d, 0);
    }

    static 
    {
        new bvm();
    }
}
