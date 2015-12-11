// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.wearable.internal.ar;

public class avr
    implements android.os.Parcelable.Creator
{

    public avr()
    {
    }

    public static void a(ar ar1, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, ar1.a);
        rq.a(parcel, 2, ar1.a(), false);
        rq.a(parcel, i);
    }

    public ar a(Parcel parcel)
    {
        int j = ro.b(parcel);
        int i = 0;
        android.os.IBinder ibinder = null;
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
                    ibinder = ro.l(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new ar(i, ibinder);
            }
        } while (true);
    }

    public ar[] a(int i)
    {
        return new ar[i];
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
