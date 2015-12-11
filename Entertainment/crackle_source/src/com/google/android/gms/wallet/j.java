// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.wallet:
//            NotifyTransactionStatusRequest

public class j
    implements android.os.Parcelable.Creator
{

    public j()
    {
    }

    static void a(NotifyTransactionStatusRequest notifytransactionstatusrequest, Parcel parcel, int i)
    {
        i = b.o(parcel);
        b.c(parcel, 1, notifytransactionstatusrequest.kg);
        b.a(parcel, 2, notifytransactionstatusrequest.Gn, false);
        b.c(parcel, 3, notifytransactionstatusrequest.status);
        b.a(parcel, 4, notifytransactionstatusrequest.GV, false);
        b.D(parcel, i);
    }

    public NotifyTransactionStatusRequest aN(Parcel parcel)
    {
        String s1 = null;
        int k = 0;
        int l = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        String s = null;
        int i = 0;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.M(i1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, i1);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, i1);
                    break;

                case 2: // '\002'
                    s = com.google.android.gms.common.internal.safeparcel.a.m(parcel, i1);
                    break;

                case 3: // '\003'
                    k = com.google.android.gms.common.internal.safeparcel.a.g(parcel, i1);
                    break;

                case 4: // '\004'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new NotifyTransactionStatusRequest(i, s, k, s1);
            }
        } while (true);
    }

    public NotifyTransactionStatusRequest[] bF(int i)
    {
        return new NotifyTransactionStatusRequest[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return aN(parcel);
    }

    public Object[] newArray(int i)
    {
        return bF(i);
    }
}
