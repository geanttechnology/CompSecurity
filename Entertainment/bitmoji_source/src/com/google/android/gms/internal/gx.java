// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.multiplayer.InvitationEntity;

// Referenced classes of package com.google.android.gms.internal:
//            gy

public class gx
    implements android.os.Parcelable.Creator
{

    public gx()
    {
    }

    static void a(gy gy1, Parcel parcel, int i)
    {
        i = b.p(parcel);
        b.b(parcel, 1, gy1.fS(), false);
        b.c(parcel, 1000, gy1.getVersionCode());
        b.D(parcel, i);
    }

    public gy[] aX(int i)
    {
        return new gy[i];
    }

    public gy al(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.a.o(parcel);
        int i = 0;
        java.util.ArrayList arraylist = null;
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
                    arraylist = com.google.android.gms.common.internal.safeparcel.a.c(parcel, k, InvitationEntity.CREATOR);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new gy(i, arraylist);
            }
        } while (true);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return al(parcel);
    }

    public Object[] newArray(int i)
    {
        return aX(i);
    }
}
