// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.drive.query.internal:
//            LogicalFilter, Operator, FilterHolder

public class f
    implements android.os.Parcelable.Creator
{

    public f()
    {
    }

    static void a(LogicalFilter logicalfilter, Parcel parcel, int i)
    {
        int j = b.o(parcel);
        b.c(parcel, 1000, logicalfilter.kg);
        b.a(parcel, 1, logicalfilter.rR, i, false);
        b.b(parcel, 2, logicalfilter.sb, false);
        b.D(parcel, j);
    }

    public LogicalFilter V(Parcel parcel)
    {
        java.util.ArrayList arraylist = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        int i = 0;
        Operator operator = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = com.google.android.gms.common.internal.safeparcel.a.m(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.M(k))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, k);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, k);
                    break;

                case 1: // '\001'
                    operator = (Operator)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, Operator.CREATOR);
                    break;

                case 2: // '\002'
                    arraylist = com.google.android.gms.common.internal.safeparcel.a.c(parcel, k, FilterHolder.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new LogicalFilter(i, operator, arraylist);
            }
        } while (true);
    }

    public LogicalFilter[] av(int i)
    {
        return new LogicalFilter[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return V(parcel);
    }

    public Object[] newArray(int i)
    {
        return av(i);
    }
}
