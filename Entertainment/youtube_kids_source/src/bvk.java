// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import java.util.ArrayList;
import java.util.Collections;

final class bvk
    implements android.os.Parcelable.Creator
{

    bvk()
    {
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int i = parcel.readInt();
        Object obj = new ArrayList();
        parcel.readTypedList(((java.util.List) (obj)), bvn.CREATOR);
        obj = Collections.unmodifiableList(((java.util.List) (obj)));
        ArrayList arraylist = new ArrayList();
        parcel.readTypedList(arraylist, bvv.CREATOR);
        return new bvj(i, ((java.util.List) (obj)), Collections.unmodifiableList(arraylist), (bvr)parcel.readParcelable(bvr.getClassLoader()), (byte)0);
    }

    public final Object[] newArray(int i)
    {
        return new bvj[i];
    }
}
