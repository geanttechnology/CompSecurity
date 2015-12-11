// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.drive.metadata.internal:
//            MetadataBundle

public class f
    implements android.os.Parcelable.Creator
{

    public f()
    {
    }

    static void a(MetadataBundle metadatabundle, Parcel parcel, int i)
    {
        i = b.p(parcel);
        b.c(parcel, 1, metadatabundle.wj);
        b.a(parcel, 2, metadatabundle.Ek, false);
        b.D(parcel, i);
    }

    public MetadataBundle[] aF(int i)
    {
        return new MetadataBundle[i];
    }

    public MetadataBundle aa(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.a.o(parcel);
        int i = 0;
        android.os.Bundle bundle = null;
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

    public Object createFromParcel(Parcel parcel)
    {
        return aa(parcel);
    }

    public Object[] newArray(int i)
    {
        return aF(i);
    }
}
