// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.drive:
//            DriveId

public class d
    implements android.os.Parcelable.Creator
{

    public d()
    {
    }

    static void a(DriveId driveid, Parcel parcel, int i)
    {
        i = b.p(parcel);
        b.c(parcel, 1, driveid.wj);
        b.a(parcel, 2, driveid.Dc, false);
        b.a(parcel, 3, driveid.Dd);
        b.a(parcel, 4, driveid.De);
        b.D(parcel, i);
    }

    public DriveId[] ae(int i)
    {
        return new DriveId[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return z(parcel);
    }

    public Object[] newArray(int i)
    {
        return ae(i);
    }

    public DriveId z(Parcel parcel)
    {
        long l = 0L;
        int j = com.google.android.gms.common.internal.safeparcel.a.o(parcel);
        int i = 0;
        String s = null;
        long l1 = 0L;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.S(k))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, k);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, k);
                    break;

                case 2: // '\002'
                    s = com.google.android.gms.common.internal.safeparcel.a.m(parcel, k);
                    break;

                case 3: // '\003'
                    l1 = com.google.android.gms.common.internal.safeparcel.a.h(parcel, k);
                    break;

                case 4: // '\004'
                    l = com.google.android.gms.common.internal.safeparcel.a.h(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new DriveId(i, s, l1, l);
            }
        } while (true);
    }
}
