// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.IntentFilter;
import android.os.Parcel;
import com.google.android.gms.wearable.internal.b;

public class awe
    implements android.os.Parcelable.Creator
{

    public awe()
    {
    }

    public static void a(b b1, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, b1.a);
        rq.a(parcel, 2, b1.a(), false);
        rq.a(parcel, 3, b1.c, i, false);
        rq.a(parcel, j);
    }

    public b a(Parcel parcel)
    {
        IntentFilter aintentfilter[] = null;
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

                case 3: // '\003'
                    aintentfilter = (IntentFilter[])ro.b(parcel, k, IntentFilter.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new b(i, ibinder, aintentfilter);
            }
        } while (true);
    }

    public b[] a(int i)
    {
        return new b[i];
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
