// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.wallet.wobs.l;

public class ato
    implements android.os.Parcelable.Creator
{

    public ato()
    {
    }

    public static void a(l l1, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, l1.a());
        rq.a(parcel, 2, l1.a);
        rq.a(parcel, 3, l1.b);
        rq.a(parcel, i);
    }

    public l a(Parcel parcel)
    {
        long l1 = 0L;
        int j = ro.b(parcel);
        int i = 0;
        long l2 = 0L;
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
                    l2 = ro.h(parcel, k);
                    break;

                case 3: // '\003'
                    l1 = ro.h(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new l(i, l2, l1);
            }
        } while (true);
    }

    public l[] a(int i)
    {
        return new l[i];
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
