// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.CommonWalletObject;
import com.google.android.gms.wallet.wobs.d;
import com.google.android.gms.wallet.wobs.j;
import com.google.android.gms.wallet.wobs.l;
import com.google.android.gms.wallet.wobs.n;
import com.google.android.gms.wallet.wobs.p;

public class ati
    implements android.os.Parcelable.Creator
{

    public ati()
    {
    }

    public static void a(CommonWalletObject commonwalletobject, Parcel parcel, int i)
    {
        int k = rq.a(parcel);
        rq.a(parcel, 1, commonwalletobject.b());
        rq.a(parcel, 2, commonwalletobject.a, false);
        rq.a(parcel, 3, commonwalletobject.b, false);
        rq.a(parcel, 4, commonwalletobject.c, false);
        rq.a(parcel, 5, commonwalletobject.d, false);
        rq.a(parcel, 6, commonwalletobject.e, false);
        rq.a(parcel, 7, commonwalletobject.f, false);
        rq.a(parcel, 8, commonwalletobject.g, false);
        rq.a(parcel, 9, commonwalletobject.h, false);
        rq.a(parcel, 10, commonwalletobject.i);
        rq.b(parcel, 11, commonwalletobject.j, false);
        rq.a(parcel, 12, commonwalletobject.k, i, false);
        rq.b(parcel, 13, commonwalletobject.l, false);
        rq.a(parcel, 14, commonwalletobject.m, false);
        rq.a(parcel, 15, commonwalletobject.n, false);
        rq.a(parcel, 17, commonwalletobject.p);
        rq.b(parcel, 16, commonwalletobject.o, false);
        rq.b(parcel, 19, commonwalletobject.r, false);
        rq.b(parcel, 18, commonwalletobject.q, false);
        rq.b(parcel, 20, commonwalletobject.s, false);
        rq.a(parcel, k);
    }

    public CommonWalletObject a(Parcel parcel)
    {
        int i1 = ro.b(parcel);
        int k = 0;
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
                    s9 = ro.k(parcel, j1);
                    break;

                case 3: // '\003'
                    s8 = ro.k(parcel, j1);
                    break;

                case 4: // '\004'
                    s7 = ro.k(parcel, j1);
                    break;

                case 5: // '\005'
                    s6 = ro.k(parcel, j1);
                    break;

                case 6: // '\006'
                    s5 = ro.k(parcel, j1);
                    break;

                case 7: // '\007'
                    s4 = ro.k(parcel, j1);
                    break;

                case 8: // '\b'
                    s3 = ro.k(parcel, j1);
                    break;

                case 9: // '\t'
                    s2 = ro.k(parcel, j1);
                    break;

                case 10: // '\n'
                    i = ro.f(parcel, j1);
                    break;

                case 11: // '\013'
                    arraylist5 = ro.c(parcel, j1, p.CREATOR);
                    break;

                case 12: // '\f'
                    l1 = (l)ro.a(parcel, j1, l.CREATOR);
                    break;

                case 13: // '\r'
                    arraylist4 = ro.c(parcel, j1, LatLng.CREATOR);
                    break;

                case 14: // '\016'
                    s1 = ro.k(parcel, j1);
                    break;

                case 15: // '\017'
                    s = ro.k(parcel, j1);
                    break;

                case 17: // '\021'
                    flag = ro.c(parcel, j1);
                    break;

                case 16: // '\020'
                    arraylist3 = ro.c(parcel, j1, d.CREATOR);
                    break;

                case 19: // '\023'
                    arraylist1 = ro.c(parcel, j1, j.CREATOR);
                    break;

                case 18: // '\022'
                    arraylist2 = ro.c(parcel, j1, n.CREATOR);
                    break;

                case 20: // '\024'
                    arraylist = ro.c(parcel, j1, n.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != i1)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(i1).toString(), parcel);
            } else
            {
                return new CommonWalletObject(k, s9, s8, s7, s6, s5, s4, s3, s2, i, arraylist5, l1, arraylist4, s1, s, arraylist3, flag, arraylist2, arraylist1, arraylist);
            }
        } while (true);
    }

    public CommonWalletObject[] a(int i)
    {
        return new CommonWalletObject[i];
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
