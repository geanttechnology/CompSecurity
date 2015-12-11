// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

// Referenced classes of package com.google.android.gms.internal:
//            hx, hz, ht

public class hy
    implements android.os.Parcelable.Creator
{

    public hy()
    {
    }

    static void a(hx hx1, Parcel parcel, int i)
    {
        int j = b.p(parcel);
        b.a(parcel, 1, hx1.getId(), false);
        b.a(parcel, 2, hx1.gE(), false);
        b.a(parcel, 3, hx1.gF(), i, false);
        b.a(parcel, 4, hx1.gx(), i, false);
        b.a(parcel, 5, hx1.gy());
        b.a(parcel, 6, hx1.gz(), i, false);
        b.a(parcel, 7, hx1.gG(), false);
        b.a(parcel, 8, hx1.gA(), i, false);
        b.a(parcel, 9, hx1.gB());
        b.a(parcel, 10, hx1.getRating());
        b.c(parcel, 11, hx1.gC());
        b.a(parcel, 12, hx1.gD());
        b.b(parcel, 13, hx1.gw(), false);
        b.c(parcel, 1000, hx1.wj);
        b.D(parcel, j);
    }

    public hx aB(Parcel parcel)
    {
        int k = com.google.android.gms.common.internal.safeparcel.a.o(parcel);
        int j = 0;
        String s1 = null;
        java.util.ArrayList arraylist = null;
        android.os.Bundle bundle = null;
        hz hz1 = null;
        LatLng latlng = null;
        float f1 = 0.0F;
        LatLngBounds latlngbounds = null;
        String s = null;
        Uri uri = null;
        boolean flag = false;
        float f = 0.0F;
        int i = 0;
        long l1 = 0L;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.S(l))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, l);
                    break;

                case 1: // '\001'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;

                case 2: // '\002'
                    bundle = com.google.android.gms.common.internal.safeparcel.a.o(parcel, l);
                    break;

                case 3: // '\003'
                    hz1 = (hz)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, hz.CREATOR);
                    break;

                case 4: // '\004'
                    latlng = (LatLng)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, LatLng.CREATOR);
                    break;

                case 5: // '\005'
                    f1 = com.google.android.gms.common.internal.safeparcel.a.j(parcel, l);
                    break;

                case 6: // '\006'
                    latlngbounds = (LatLngBounds)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, LatLngBounds.CREATOR);
                    break;

                case 7: // '\007'
                    s = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;

                case 8: // '\b'
                    uri = (Uri)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, Uri.CREATOR);
                    break;

                case 9: // '\t'
                    flag = com.google.android.gms.common.internal.safeparcel.a.c(parcel, l);
                    break;

                case 10: // '\n'
                    f = com.google.android.gms.common.internal.safeparcel.a.j(parcel, l);
                    break;

                case 11: // '\013'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, l);
                    break;

                case 12: // '\f'
                    l1 = com.google.android.gms.common.internal.safeparcel.a.h(parcel, l);
                    break;

                case 13: // '\r'
                    arraylist = com.google.android.gms.common.internal.safeparcel.a.c(parcel, l, ht.CREATOR);
                    break;

                case 1000: 
                    j = com.google.android.gms.common.internal.safeparcel.a.g(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new hx(j, s1, arraylist, bundle, hz1, latlng, f1, latlngbounds, s, uri, flag, f, i, l1);
            }
        } while (true);
    }

    public hx[] bw(int i)
    {
        return new hx[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return aB(parcel);
    }

    public Object[] newArray(int i)
    {
        return bw(i);
    }
}
