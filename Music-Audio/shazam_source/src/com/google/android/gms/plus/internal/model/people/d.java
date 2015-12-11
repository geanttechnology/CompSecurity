// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public final class d
    implements android.os.Parcelable.Creator
{

    public d()
    {
    }

    static void a(PersonEntity.CoverEntity.CoverInfoEntity coverinfoentity, Parcel parcel)
    {
        int i = b.a(parcel, 20293);
        Set set = coverinfoentity.a;
        if (set.contains(Integer.valueOf(1)))
        {
            b.b(parcel, 1, coverinfoentity.b);
        }
        if (set.contains(Integer.valueOf(2)))
        {
            b.b(parcel, 2, coverinfoentity.c);
        }
        if (set.contains(Integer.valueOf(3)))
        {
            b.b(parcel, 3, coverinfoentity.d);
        }
        b.b(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int k = 0;
        int l = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        HashSet hashset = new HashSet();
        int j = 0;
        int i = 0;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = parcel.readInt();
                switch (0xffff & i1)
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, i1);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, i1);
                    hashset.add(Integer.valueOf(1));
                    break;

                case 2: // '\002'
                    j = com.google.android.gms.common.internal.safeparcel.a.e(parcel, i1);
                    hashset.add(Integer.valueOf(2));
                    break;

                case 3: // '\003'
                    k = com.google.android.gms.common.internal.safeparcel.a.e(parcel, i1);
                    hashset.add(Integer.valueOf(3));
                    break;
                }
            } else
            {
                if (parcel.dataPosition() != l)
                {
                    throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder("Overread allowed size end=")).append(l).toString(), parcel);
                }
                return new PersonEntity.CoverEntity.CoverInfoEntity(hashset, i, j, k);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new PersonEntity.CoverEntity.CoverInfoEntity[i];
    }
}
