// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.maps.model:
//            StreetViewPanoramaLink

public final class p
    implements android.os.Parcelable.Creator
{

    public p()
    {
    }

    static void a(StreetViewPanoramaLink streetviewpanoramalink, Parcel parcel)
    {
        int i = b.a(parcel, 20293);
        b.b(parcel, 1, streetviewpanoramalink.a);
        b.a(parcel, 2, streetviewpanoramalink.b, false);
        b.a(parcel, 3, streetviewpanoramalink.c);
        b.b(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        int i = 0;
        String s = null;
        float f = 0.0F;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = parcel.readInt();
                switch (0xffff & k)
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, k);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, k);
                    break;

                case 2: // '\002'
                    s = com.google.android.gms.common.internal.safeparcel.a.k(parcel, k);
                    break;

                case 3: // '\003'
                    f = com.google.android.gms.common.internal.safeparcel.a.h(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new StreetViewPanoramaLink(i, s, f);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new StreetViewPanoramaLink[i];
    }
}
