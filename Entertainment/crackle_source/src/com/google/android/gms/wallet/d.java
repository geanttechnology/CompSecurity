// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.wallet:
//            FullWallet, ProxyCard, Address

public class d
    implements android.os.Parcelable.Creator
{

    public d()
    {
    }

    static void a(FullWallet fullwallet, Parcel parcel, int i)
    {
        int j = b.o(parcel);
        b.c(parcel, 1, fullwallet.getVersionCode());
        b.a(parcel, 2, fullwallet.Gn, false);
        b.a(parcel, 3, fullwallet.Go, false);
        b.a(parcel, 4, fullwallet.Gp, i, false);
        b.a(parcel, 5, fullwallet.Gq, false);
        b.a(parcel, 6, fullwallet.Gr, i, false);
        b.a(parcel, 7, fullwallet.Gs, i, false);
        b.a(parcel, 8, fullwallet.Gt, false);
        b.D(parcel, j);
    }

    public FullWallet aH(Parcel parcel)
    {
        String as[] = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        int i = 0;
        Address address = null;
        Address address1 = null;
        String s = null;
        ProxyCard proxycard = null;
        String s1 = null;
        String s2 = null;
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
                    s2 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, k);
                    break;

                case 3: // '\003'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, k);
                    break;

                case 4: // '\004'
                    proxycard = (ProxyCard)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, ProxyCard.CREATOR);
                    break;

                case 5: // '\005'
                    s = com.google.android.gms.common.internal.safeparcel.a.m(parcel, k);
                    break;

                case 6: // '\006'
                    address1 = (Address)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, Address.CREATOR);
                    break;

                case 7: // '\007'
                    address = (Address)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, Address.CREATOR);
                    break;

                case 8: // '\b'
                    as = com.google.android.gms.common.internal.safeparcel.a.x(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new FullWallet(i, s2, s1, proxycard, s, address1, address, as);
            }
        } while (true);
    }

    public FullWallet[] bz(int i)
    {
        return new FullWallet[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return aH(parcel);
    }

    public Object[] newArray(int i)
    {
        return bz(i);
    }
}
