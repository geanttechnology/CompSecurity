// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.LoyaltyWalletObject;
import com.google.android.gms.wallet.wobs.d;
import com.google.android.gms.wallet.wobs.f;
import com.google.android.gms.wallet.wobs.j;
import com.google.android.gms.wallet.wobs.l;
import com.google.android.gms.wallet.wobs.n;
import com.google.android.gms.wallet.wobs.p;

public class atd
    implements android.os.Parcelable.Creator
{

    public atd()
    {
    }

    public static void a(LoyaltyWalletObject loyaltywalletobject, Parcel parcel, int i)
    {
        int k = rq.a(parcel);
        rq.a(parcel, 1, loyaltywalletobject.a());
        rq.a(parcel, 2, loyaltywalletobject.a, false);
        rq.a(parcel, 3, loyaltywalletobject.b, false);
        rq.a(parcel, 4, loyaltywalletobject.c, false);
        rq.a(parcel, 5, loyaltywalletobject.d, false);
        rq.a(parcel, 6, loyaltywalletobject.e, false);
        rq.a(parcel, 7, loyaltywalletobject.f, false);
        rq.a(parcel, 8, loyaltywalletobject.g, false);
        rq.a(parcel, 9, loyaltywalletobject.h, false);
        rq.a(parcel, 10, loyaltywalletobject.i, false);
        rq.a(parcel, 11, loyaltywalletobject.j, false);
        rq.a(parcel, 12, loyaltywalletobject.k);
        rq.b(parcel, 13, loyaltywalletobject.l, false);
        rq.a(parcel, 14, loyaltywalletobject.m, i, false);
        rq.b(parcel, 15, loyaltywalletobject.n, false);
        rq.a(parcel, 17, loyaltywalletobject.p, false);
        rq.a(parcel, 16, loyaltywalletobject.o, false);
        rq.a(parcel, 19, loyaltywalletobject.r);
        rq.b(parcel, 18, loyaltywalletobject.q, false);
        rq.b(parcel, 21, loyaltywalletobject.t, false);
        rq.b(parcel, 20, loyaltywalletobject.s, false);
        rq.a(parcel, 23, loyaltywalletobject.v, i, false);
        rq.b(parcel, 22, loyaltywalletobject.u, false);
        rq.a(parcel, k);
    }

    public LoyaltyWalletObject a(Parcel parcel)
    {
        int i1 = ro.b(parcel);
        int k = 0;
        String s11 = null;
        String s10 = null;
        String s9 = null;
        String s8 = null;
        String s7 = null;
        String s6 = null;
        String s5 = null;
        String s4 = null;
        String s3 = null;
        String s2 = null;
        int i = 0;
        java.util.ArrayList arraylist5 = aed.a();
        l l1 = null;
        java.util.ArrayList arraylist4 = aed.a();
        String s1 = null;
        String s = null;
        java.util.ArrayList arraylist3 = aed.a();
        boolean flag = false;
        java.util.ArrayList arraylist2 = aed.a();
        java.util.ArrayList arraylist1 = aed.a();
        java.util.ArrayList arraylist = aed.a();
        f f1 = null;
        do
        {
            if (parcel.dataPosition() < i1)
            {
                int j1 = ro.a(parcel);
                switch (ro.a(j1))
                {
                default:
                    ro.b(parcel, j1);
                    break;

                case 1: // '\001'
                    k = ro.f(parcel, j1);
                    break;

                case 2: // '\002'
                    s11 = ro.k(parcel, j1);
                    break;

                case 3: // '\003'
                    s10 = ro.k(parcel, j1);
                    break;

                case 4: // '\004'
                    s9 = ro.k(parcel, j1);
                    break;

                case 5: // '\005'
                    s8 = ro.k(parcel, j1);
                    break;

                case 6: // '\006'
                    s7 = ro.k(parcel, j1);
                    break;

                case 7: // '\007'
                    s6 = ro.k(parcel, j1);
                    break;

                case 8: // '\b'
                    s5 = ro.k(parcel, j1);
                    break;

                case 9: // '\t'
                    s4 = ro.k(parcel, j1);
                    break;

                case 10: // '\n'
                    s3 = ro.k(parcel, j1);
                    break;

                case 11: // '\013'
                    s2 = ro.k(parcel, j1);
                    break;

                case 12: // '\f'
                    i = ro.f(parcel, j1);
                    break;

                case 13: // '\r'
                    arraylist5 = ro.c(parcel, j1, p.CREATOR);
                    break;

                case 14: // '\016'
                    l1 = (l)ro.a(parcel, j1, l.CREATOR);
                    break;

                case 15: // '\017'
                    arraylist4 = ro.c(parcel, j1, LatLng.CREATOR);
                    break;

                case 17: // '\021'
                    s = ro.k(parcel, j1);
                    break;

                case 16: // '\020'
                    s1 = ro.k(parcel, j1);
                    break;

                case 19: // '\023'
                    flag = ro.c(parcel, j1);
                    break;

                case 18: // '\022'
                    arraylist3 = ro.c(parcel, j1, d.CREATOR);
                    break;

                case 21: // '\025'
                    arraylist1 = ro.c(parcel, j1, j.CREATOR);
                    break;

                case 20: // '\024'
                    arraylist2 = ro.c(parcel, j1, n.CREATOR);
                    break;

                case 23: // '\027'
                    f1 = (f)ro.a(parcel, j1, f.CREATOR);
                    break;

                case 22: // '\026'
                    arraylist = ro.c(parcel, j1, n.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != i1)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(i1).toString(), parcel);
            } else
            {
                return new LoyaltyWalletObject(k, s11, s10, s9, s8, s7, s6, s5, s4, s3, s2, i, arraylist5, l1, arraylist4, s1, s, arraylist3, flag, arraylist2, arraylist1, arraylist, f1);
            }
        } while (true);
    }

    public LoyaltyWalletObject[] a(int i)
    {
        return new LoyaltyWalletObject[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }
}
