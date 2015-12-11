// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public final class e
    implements android.os.Parcelable.Creator
{

    public e()
    {
    }

    static void a(PersonEntity.CoverEntity.CoverPhotoEntity coverphotoentity, Parcel parcel)
    {
        int i = b.a(parcel, 20293);
        Set set = coverphotoentity.a;
        if (set.contains(Integer.valueOf(1)))
        {
            b.b(parcel, 1, coverphotoentity.b);
        }
        if (set.contains(Integer.valueOf(2)))
        {
            b.b(parcel, 2, coverphotoentity.c);
        }
        if (set.contains(Integer.valueOf(3)))
        {
            b.a(parcel, 3, coverphotoentity.d, true);
        }
        if (set.contains(Integer.valueOf(4)))
        {
            b.b(parcel, 4, coverphotoentity.e);
        }
        b.b(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int i = 0;
        int l = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        HashSet hashset = new HashSet();
        String s = null;
        int j = 0;
        int k = 0;
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
                    k = com.google.android.gms.common.internal.safeparcel.a.e(parcel, i1);
                    hashset.add(Integer.valueOf(1));
                    break;

                case 2: // '\002'
                    j = com.google.android.gms.common.internal.safeparcel.a.e(parcel, i1);
                    hashset.add(Integer.valueOf(2));
                    break;

                case 3: // '\003'
                    s = com.google.android.gms.common.internal.safeparcel.a.k(parcel, i1);
                    hashset.add(Integer.valueOf(3));
                    break;

                case 4: // '\004'
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, i1);
                    hashset.add(Integer.valueOf(4));
                    break;
                }
            } else
            {
                if (parcel.dataPosition() != l)
                {
                    throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder("Overread allowed size end=")).append(l).toString(), parcel);
                }
                return new PersonEntity.CoverEntity.CoverPhotoEntity(hashset, k, j, s, i);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new PersonEntity.CoverEntity.CoverPhotoEntity[i];
    }
}
