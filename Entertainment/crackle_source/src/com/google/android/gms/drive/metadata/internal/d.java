// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.drive.metadata.internal:
//            MetadataBundle

public class d
    implements android.os.Parcelable.Creator
{

    public d()
    {
    }

    static void a(MetadataBundle metadatabundle, Parcel parcel, int i)
    {
        i = b.o(parcel);
        b.c(parcel, 1, metadatabundle.kg);
        b.a(parcel, 2, metadatabundle.rF, false);
        b.D(parcel, i);
    }

    public MetadataBundle P(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        int i = 0;
        android.os.Bundle bundle = null;
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

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, k);
                    break;

                case 2: // '\002'
                    bundle = com.google.android.gms.common.internal.safeparcel.a.o(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new MetadataBundle(i, bundle);
            }
        } while (true);
    }

    public MetadataBundle[] ap(int i)
    {
        return new MetadataBundle[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return P(parcel);
    }

    public Object[] newArray(int i)
    {
        return ap(i);
    }
}
