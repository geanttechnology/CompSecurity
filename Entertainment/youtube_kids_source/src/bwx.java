// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

final class bwx
    implements android.os.Parcelable.Creator
{

    bwx()
    {
    }

    private static bww a(Parcel parcel)
    {
        dyz dyz1;
        boolean flag;
        flag = true;
        dyz1 = null;
        dyz dyz2 = (dyz)a.b(parcel, new dyz());
        dyz1 = dyz2;
_L1:
        String s = parcel.readString();
        long l = parcel.readLong();
        long l1 = parcel.readLong();
        eum eum1;
        if (parcel.readInt() != 1)
        {
            flag = false;
        }
        return new bww(dyz1, s, l, l1, flag);
        eum1;
        bmo.a("Error reading streaming data", eum1);
          goto _L1
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new bww[i];
    }
}
