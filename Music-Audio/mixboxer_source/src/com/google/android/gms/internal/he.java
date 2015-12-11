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
//            hd, hf, gx

public class he
    implements android.os.Parcelable.Creator
{

    public he()
    {
    }

    static void a(hd hd1, Parcel parcel, int i)
    {
        int j = b.o(parcel);
        b.a(parcel, 1, hd1.getId(), false);
        b.a(parcel, 2, hd1.ee(), false);
        b.a(parcel, 3, hd1.ef(), i, false);
        b.a(parcel, 4, hd1.dX(), i, false);
        b.a(parcel, 5, hd1.dY());
        b.a(parcel, 6, hd1.dZ(), i, false);
        b.a(parcel, 7, hd1.eg(), false);
        b.a(parcel, 8, hd1.ea(), i, false);
        b.a(parcel, 9, hd1.eb());
        b.a(parcel, 10, hd1.getRating());
        b.c(parcel, 11, hd1.ec());
        b.a(parcel, 12, hd1.ed());
        b.b(parcel, 13, hd1.dW(), false);
        b.c(parcel, 1000, hd1.kg);
        b.D(parcel, j);
    }

    public hd ao(Parcel parcel)
    {
        int k = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        int j = 0;
        String s1 = null;
        java.util.ArrayList arraylist = null;
        android.os.Bundle bundle = null;
        hf hf1 = null;
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
                int l = com.google.android.gms.common.internal.safeparcel.a.m(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.M(l))
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
                    hf1 = (hf)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, hf.CREATOR);
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
                    arraylist = com.google.android.gms.common.internal.safeparcel.a.c(parcel, l, gx.CREATOR);
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
                return new hd(j, s1, arraylist, bundle, hf1, latlng, f1, latlngbounds, s, uri, flag, f, i, l1);
            }
        } while (true);
    }

    public hd[] be(int i)
    {
        return new hd[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return ao(parcel);
    }

    public Object[] newArray(int i)
    {
        return be(i);
    }
}
