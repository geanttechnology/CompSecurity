// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.identity.intents.model.UserAddress;

public class si
    implements android.os.Parcelable.Creator
{

    public si()
    {
    }

    public static void a(UserAddress useraddress, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, useraddress.a());
        rq.a(parcel, 2, useraddress.a, false);
        rq.a(parcel, 3, useraddress.b, false);
        rq.a(parcel, 4, useraddress.c, false);
        rq.a(parcel, 5, useraddress.d, false);
        rq.a(parcel, 6, useraddress.e, false);
        rq.a(parcel, 7, useraddress.f, false);
        rq.a(parcel, 8, useraddress.g, false);
        rq.a(parcel, 9, useraddress.h, false);
        rq.a(parcel, 10, useraddress.i, false);
        rq.a(parcel, 11, useraddress.j, false);
        rq.a(parcel, 12, useraddress.k, false);
        rq.a(parcel, 13, useraddress.l, false);
        rq.a(parcel, 14, useraddress.m);
        rq.a(parcel, 15, useraddress.n, false);
        rq.a(parcel, 16, useraddress.o, false);
        rq.a(parcel, i);
    }

    public UserAddress a(Parcel parcel)
    {
        int j = ro.b(parcel);
        int i = 0;
        String s13 = null;
        String s12 = null;
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
        boolean flag = false;
        String s1 = null;
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
                    s13 = ro.k(parcel, k);
                    break;

                case 3: // '\003'
                    s12 = ro.k(parcel, k);
                    break;

                case 4: // '\004'
                    s11 = ro.k(parcel, k);
                    break;

                case 5: // '\005'
                    s10 = ro.k(parcel, k);
                    break;

                case 6: // '\006'
                    s9 = ro.k(parcel, k);
                    break;

                case 7: // '\007'
                    s8 = ro.k(parcel, k);
                    break;

                case 8: // '\b'
                    s7 = ro.k(parcel, k);
                    break;

                case 9: // '\t'
                    s6 = ro.k(parcel, k);
                    break;

                case 10: // '\n'
                    s5 = ro.k(parcel, k);
                    break;

                case 11: // '\013'
                    s4 = ro.k(parcel, k);
                    break;

                case 12: // '\f'
                    s3 = ro.k(parcel, k);
                    break;

                case 13: // '\r'
                    s2 = ro.k(parcel, k);
                    break;

                case 14: // '\016'
                    flag = ro.c(parcel, k);
                    break;

                case 15: // '\017'
                    s1 = ro.k(parcel, k);
                    break;

                case 16: // '\020'
                    s = ro.k(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new UserAddress(i, s13, s12, s11, s10, s9, s8, s7, s6, s5, s4, s3, s2, flag, s1, s);
            }
        } while (true);
    }

    public UserAddress[] a(int i)
    {
        return new UserAddress[i];
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
