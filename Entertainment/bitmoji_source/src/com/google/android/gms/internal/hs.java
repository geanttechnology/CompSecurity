// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.location.LocationRequest;

// Referenced classes of package com.google.android.gms.internal:
//            hr, hn

public class hs
    implements android.os.Parcelable.Creator
{

    public hs()
    {
    }

    static void a(hr hr1, Parcel parcel, int i)
    {
        int j = b.p(parcel);
        b.a(parcel, 1, hr1.gu(), i, false);
        b.c(parcel, 1000, hr1.wj);
        b.a(parcel, 2, hr1.gv(), i, false);
        b.D(parcel, j);
    }

    public hr ay(Parcel parcel)
    {
        hn hn1 = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.o(parcel);
        int i = 0;
        LocationRequest locationrequest = null;
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
                    locationrequest = (LocationRequest)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, LocationRequest.CREATOR);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, k);
                    break;

                case 2: // '\002'
                    hn1 = (hn)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, hn.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new hr(i, locationrequest, hn1);
            }
        } while (true);
    }

    public hr[] bs(int i)
    {
        return new hr[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return ay(parcel);
    }

    public Object[] newArray(int i)
    {
        return bs(i);
    }
}
