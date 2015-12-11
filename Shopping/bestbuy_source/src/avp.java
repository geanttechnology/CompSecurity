// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.wearable.internal.an;

public class avp
    implements android.os.Parcelable.Creator
{

    public avp()
    {
    }

    public static void a(an an1, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, an1.a);
        rq.a(parcel, 2, an1.b, false);
        rq.a(parcel, 3, an1.c, false);
        rq.a(parcel, 4, an1.d);
        rq.a(parcel, i);
    }

    public an a(Parcel parcel)
    {
        String s = null;
        int j = ro.b(parcel);
        int i = 0;
        long l = 0L;
        String s1 = null;
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
                    s1 = ro.k(parcel, k);
                    break;

                case 3: // '\003'
                    s = ro.k(parcel, k);
                    break;

                case 4: // '\004'
                    l = ro.h(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new an(i, s1, s, l);
            }
        } while (true);
    }

    public an[] a(int i)
    {
        return new an[i];
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
