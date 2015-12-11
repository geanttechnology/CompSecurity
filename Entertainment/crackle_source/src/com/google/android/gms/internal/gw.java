// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.location.LocationRequest;

// Referenced classes of package com.google.android.gms.internal:
//            gv, gt

public class gw
    implements android.os.Parcelable.Creator
{

    public gw()
    {
    }

    static void a(gv gv1, Parcel parcel, int i)
    {
        int j = b.o(parcel);
        b.a(parcel, 1, gv1.dS(), i, false);
        b.c(parcel, 1000, gv1.kg);
        b.a(parcel, 2, gv1.dT(), i, false);
        b.D(parcel, j);
    }

    public gv[] aZ(int i)
    {
        return new gv[i];
    }

    public gv ak(Parcel parcel)
    {
        gt gt1 = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        int i = 0;
        LocationRequest locationrequest = null;
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
                    locationrequest = (LocationRequest)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, LocationRequest.CREATOR);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, k);
                    break;

                case 2: // '\002'
                    gt1 = (gt)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, gt.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new gv(i, locationrequest, gt1);
            }
        } while (true);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return ak(parcel);
    }

    public Object[] newArray(int i)
    {
        return aZ(i);
    }
}
