// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            id, ib

public class ie
    implements android.os.Parcelable.Creator
{

    public ie()
    {
    }

    static void a(id id1, Parcel parcel, int i)
    {
        int j = b.o(parcel);
        Set set = id1.fa();
        if (set.contains(Integer.valueOf(1)))
        {
            b.c(parcel, 1, id1.getVersionCode());
        }
        if (set.contains(Integer.valueOf(2)))
        {
            b.a(parcel, 2, id1.getId(), true);
        }
        if (set.contains(Integer.valueOf(4)))
        {
            b.a(parcel, 4, id1.fr(), i, true);
        }
        if (set.contains(Integer.valueOf(5)))
        {
            b.a(parcel, 5, id1.getStartDate(), true);
        }
        if (set.contains(Integer.valueOf(6)))
        {
            b.a(parcel, 6, id1.fs(), i, true);
        }
        if (set.contains(Integer.valueOf(7)))
        {
            b.a(parcel, 7, id1.getType(), true);
        }
        b.D(parcel, j);
    }

    public id at(Parcel parcel)
    {
        String s = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
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
                int k = com.google.android.gms.common.internal.safeparcel.a.m(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.M(k))
                {
                case 3: // '\003'
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, k);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, k);
                    hashset.add(Integer.valueOf(1));
                    break;

                case 2: // '\002'
                    s2 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, k);
                    hashset.add(Integer.valueOf(2));
                    break;

                case 4: // '\004'
                    ib2 = (ib)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, ib.CREATOR);
                    hashset.add(Integer.valueOf(4));
                    break;

                case 5: // '\005'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, k);
                    hashset.add(Integer.valueOf(5));
                    break;

                case 6: // '\006'
                    ib1 = (ib)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, ib.CREATOR);
                    hashset.add(Integer.valueOf(6));
                    break;

                case 7: // '\007'
                    s = com.google.android.gms.common.internal.safeparcel.a.m(parcel, k);
                    hashset.add(Integer.valueOf(7));
                    break;
                }
            } else
            {
                if (parcel.dataPosition() != j)
                {
                    throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
                }
                return new id(hashset, i, s2, ib2, s1, ib1, s);
            }
        } while (true);
    }

    public id[] bl(int i)
    {
        return new id[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return at(parcel);
    }

    public Object[] newArray(int i)
    {
        return bl(i);
    }
}
