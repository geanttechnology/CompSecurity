// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            id, ib

public final class jr
    implements android.os.Parcelable.Creator
{

    public jr()
    {
    }

    static void a(id id1, Parcel parcel, int i)
    {
        int j = c.a(parcel, 20293);
        Set set = id1.a;
        if (set.contains(Integer.valueOf(1)))
        {
            c.b(parcel, 1, id1.b);
        }
        if (set.contains(Integer.valueOf(2)))
        {
            c.a(parcel, 2, id1.c, true);
        }
        if (set.contains(Integer.valueOf(4)))
        {
            c.a(parcel, 4, id1.d, i, true);
        }
        if (set.contains(Integer.valueOf(5)))
        {
            c.a(parcel, 5, id1.e, true);
        }
        if (set.contains(Integer.valueOf(6)))
        {
            c.a(parcel, 6, id1.f, i, true);
        }
        if (set.contains(Integer.valueOf(7)))
        {
            c.a(parcel, 7, id1.g, true);
        }
        c.b(parcel, j);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        String s = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        HashSet hashset = new HashSet();
        int i = 0;
        ib ib1 = null;
        String s1 = null;
        ib ib2 = null;
        String s2 = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = parcel.readInt();
                switch (0xffff & k)
                {
                case 3: // '\003'
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, k);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, k);
                    hashset.add(Integer.valueOf(1));
                    break;

                case 2: // '\002'
                    s2 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, k);
                    hashset.add(Integer.valueOf(2));
                    break;

                case 4: // '\004'
                    ib2 = (ib)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, ib.CREATOR);
                    hashset.add(Integer.valueOf(4));
                    break;

                case 5: // '\005'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, k);
                    hashset.add(Integer.valueOf(5));
                    break;

                case 6: // '\006'
                    ib1 = (ib)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, ib.CREATOR);
                    hashset.add(Integer.valueOf(6));
                    break;

                case 7: // '\007'
                    s = com.google.android.gms.common.internal.safeparcel.a.k(parcel, k);
                    hashset.add(Integer.valueOf(7));
                    break;
                }
            } else
            {
                if (parcel.dataPosition() != j)
                {
                    throw new b((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
                }
                return new id(hashset, i, s2, ib2, s1, ib1, s);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new id[i];
    }
}
