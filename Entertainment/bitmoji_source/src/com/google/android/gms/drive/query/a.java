// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.query;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.query.internal.LogicalFilter;

// Referenced classes of package com.google.android.gms.drive.query:
//            Query

public class a
    implements android.os.Parcelable.Creator
{

    public a()
    {
    }

    static void a(Query query, Parcel parcel, int i)
    {
        int j = b.p(parcel);
        b.c(parcel, 1000, query.wj);
        b.a(parcel, 1, query.EL, i, false);
        b.a(parcel, 3, query.EM, false);
        b.D(parcel, j);
    }

    public Query[] aG(int i)
    {
        return new Query[i];
    }

    public Query ab(Parcel parcel)
    {
        String s = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.o(parcel);
        int i = 0;
        LogicalFilter logicalfilter = null;
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

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, k);
                    break;

                case 1: // '\001'
                    logicalfilter = (LogicalFilter)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, LogicalFilter.CREATOR);
                    break;

                case 3: // '\003'
                    s = com.google.android.gms.common.internal.safeparcel.a.m(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new Query(i, logicalfilter, s);
            }
        } while (true);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return ab(parcel);
    }

    public Object[] newArray(int i)
    {
        return aG(i);
    }
}
