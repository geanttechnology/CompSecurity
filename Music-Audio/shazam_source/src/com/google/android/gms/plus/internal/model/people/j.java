// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public final class j
    implements android.os.Parcelable.Creator
{

    public j()
    {
    }

    static void a(PersonEntity.UrlsEntity urlsentity, Parcel parcel)
    {
        int i = b.a(parcel, 20293);
        Set set = urlsentity.a;
        if (set.contains(Integer.valueOf(1)))
        {
            b.b(parcel, 1, urlsentity.b);
        }
        if (set.contains(Integer.valueOf(3)))
        {
            b.b(parcel, 3, PersonEntity.UrlsEntity.e());
        }
        if (set.contains(Integer.valueOf(4)))
        {
            b.a(parcel, 4, urlsentity.e, true);
        }
        if (set.contains(Integer.valueOf(5)))
        {
            b.a(parcel, 5, urlsentity.c, true);
        }
        if (set.contains(Integer.valueOf(6)))
        {
            b.b(parcel, 6, urlsentity.d);
        }
        b.b(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        String s = null;
        int i = 0;
        int l = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        HashSet hashset = new HashSet();
        String s1 = null;
        int k = 0;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = parcel.readInt();
                switch (0xffff & i1)
                {
                case 2: // '\002'
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, i1);
                    break;

                case 1: // '\001'
                    k = com.google.android.gms.common.internal.safeparcel.a.e(parcel, i1);
                    hashset.add(Integer.valueOf(1));
                    break;

                case 3: // '\003'
                    com.google.android.gms.common.internal.safeparcel.a.e(parcel, i1);
                    hashset.add(Integer.valueOf(3));
                    break;

                case 4: // '\004'
                    s = com.google.android.gms.common.internal.safeparcel.a.k(parcel, i1);
                    hashset.add(Integer.valueOf(4));
                    break;

                case 5: // '\005'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, i1);
                    hashset.add(Integer.valueOf(5));
                    break;

                case 6: // '\006'
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, i1);
                    hashset.add(Integer.valueOf(6));
                    break;
                }
            } else
            {
                if (parcel.dataPosition() != l)
                {
                    throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder("Overread allowed size end=")).append(l).toString(), parcel);
                }
                return new PersonEntity.UrlsEntity(hashset, k, s1, i, s);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new PersonEntity.UrlsEntity[i];
    }
}
