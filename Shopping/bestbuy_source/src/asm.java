// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.wallet.Address;

public class asm
    implements android.os.Parcelable.Creator
{

    public asm()
    {
    }

    public static void a(Address address, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, address.a());
        rq.a(parcel, 2, address.a, false);
        rq.a(parcel, 3, address.b, false);
        rq.a(parcel, 4, address.c, false);
        rq.a(parcel, 5, address.d, false);
        rq.a(parcel, 6, address.e, false);
        rq.a(parcel, 7, address.f, false);
        rq.a(parcel, 8, address.g, false);
        rq.a(parcel, 9, address.h, false);
        rq.a(parcel, 10, address.i, false);
        rq.a(parcel, 11, address.j);
        rq.a(parcel, 12, address.k, false);
        rq.a(parcel, i);
    }

    public Address a(Parcel parcel)
    {
        int j = ro.b(parcel);
        int i = 0;
        String s9 = null;
        String s8 = null;
        String s7 = null;
        String s6 = null;
        String s5 = null;
        String s4 = null;
        String s3 = null;
        String s2 = null;
        String s1 = null;
        boolean flag = false;
        String s = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = ro.a(parcel);
                switch (ro.a(k))
                {
                default:
                    ro.b(parcel, k);
                    break;

                case 1: // '\001'
                    i = ro.f(parcel, k);
                    break;

                case 2: // '\002'
                    s9 = ro.k(parcel, k);
                    break;

                case 3: // '\003'
                    s8 = ro.k(parcel, k);
                    break;

                case 4: // '\004'
                    s7 = ro.k(parcel, k);
                    break;

                case 5: // '\005'
                    s6 = ro.k(parcel, k);
                    break;

                case 6: // '\006'
                    s5 = ro.k(parcel, k);
                    break;

                case 7: // '\007'
                    s4 = ro.k(parcel, k);
                    break;

                case 8: // '\b'
                    s3 = ro.k(parcel, k);
                    break;

                case 9: // '\t'
                    s2 = ro.k(parcel, k);
                    break;

                case 10: // '\n'
                    s1 = ro.k(parcel, k);
                    break;

                case 11: // '\013'
                    flag = ro.c(parcel, k);
                    break;

                case 12: // '\f'
                    s = ro.k(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new Address(i, s9, s8, s7, s6, s5, s4, s3, s2, s1, flag, s);
            }
        } while (true);
    }

    public Address[] a(int i)
    {
        return new Address[i];
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
