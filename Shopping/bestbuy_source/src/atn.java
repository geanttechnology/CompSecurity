// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.wallet.wobs.j;

public class atn
    implements android.os.Parcelable.Creator
{

    public atn()
    {
    }

    public static void a(j j1, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, j1.a());
        rq.a(parcel, 2, j1.a, false);
        rq.a(parcel, 3, j1.b, false);
        rq.a(parcel, i);
    }

    public j a(Parcel parcel)
    {
        String s1 = null;
        int k = ro.b(parcel);
        int i = 0;
        String s = null;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = ro.a(parcel);
                switch (ro.a(l))
                {
                default:
                    ro.b(parcel, l);
                    break;

                case 1: // '\001'
                    i = ro.f(parcel, l);
                    break;

                case 2: // '\002'
                    s = ro.k(parcel, l);
                    break;

                case 3: // '\003'
                    s1 = ro.k(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new j(i, s, s1);
            }
        } while (true);
    }

    public j[] a(int i)
    {
        return new j[i];
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
