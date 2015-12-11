// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.internal.ea;

public class xs
    implements android.os.Parcelable.Creator
{

    public xs()
    {
    }

    public static void a(ea ea1, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, ea1.a);
        rq.a(parcel, 3, ea1.b(), false);
        rq.a(parcel, 4, ea1.c(), false);
        rq.a(parcel, 5, ea1.d(), false);
        rq.a(parcel, 6, ea1.a(), false);
        rq.a(parcel, i);
    }

    public ea a(Parcel parcel)
    {
        android.os.IBinder ibinder = null;
        int j = ro.b(parcel);
        int i = 0;
        android.os.IBinder ibinder1 = null;
        android.os.IBinder ibinder2 = null;
        android.os.IBinder ibinder3 = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = ro.a(parcel);
                switch (ro.a(k))
                {
                case 2: // '\002'
                default:
                    ro.b(parcel, k);
                    break;

                case 1: // '\001'
                    i = ro.f(parcel, k);
                    break;

                case 3: // '\003'
                    ibinder3 = ro.l(parcel, k);
                    break;

                case 4: // '\004'
                    ibinder2 = ro.l(parcel, k);
                    break;

                case 5: // '\005'
                    ibinder1 = ro.l(parcel, k);
                    break;

                case 6: // '\006'
                    ibinder = ro.l(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new ea(i, ibinder3, ibinder2, ibinder1, ibinder);
            }
        } while (true);
    }

    public ea[] a(int i)
    {
        return new ea[i];
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
