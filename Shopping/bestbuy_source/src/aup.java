// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.wearable.c;

public class aup
    implements android.os.Parcelable.Creator
{

    public aup()
    {
    }

    public static void a(c c1, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, c1.a);
        rq.a(parcel, 2, c1.a(), false);
        rq.a(parcel, 3, c1.b(), false);
        rq.a(parcel, 4, c1.c());
        rq.a(parcel, 5, c1.d());
        rq.a(parcel, 6, c1.g());
        rq.a(parcel, 7, c1.e());
        rq.a(parcel, 8, c1.f(), false);
        rq.a(parcel, i);
    }

    public c a(Parcel parcel)
    {
        String s = null;
        boolean flag = false;
        int l = ro.b(parcel);
        boolean flag1 = false;
        int i = 0;
        int j = 0;
        String s1 = null;
        String s2 = null;
        int k = 0;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = ro.a(parcel);
                switch (ro.a(i1))
                {
                default:
                    ro.b(parcel, i1);
                    break;

                case 1: // '\001'
                    k = ro.f(parcel, i1);
                    break;

                case 2: // '\002'
                    s2 = ro.k(parcel, i1);
                    break;

                case 3: // '\003'
                    s1 = ro.k(parcel, i1);
                    break;

                case 4: // '\004'
                    j = ro.f(parcel, i1);
                    break;

                case 5: // '\005'
                    i = ro.f(parcel, i1);
                    break;

                case 6: // '\006'
                    flag1 = ro.c(parcel, i1);
                    break;

                case 7: // '\007'
                    flag = ro.c(parcel, i1);
                    break;

                case 8: // '\b'
                    s = ro.k(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new c(k, s2, s1, j, i, flag1, flag, s);
            }
        } while (true);
    }

    public c[] a(int i)
    {
        return new c[i];
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
