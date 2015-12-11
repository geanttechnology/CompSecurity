// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.wallet.InstrumentInfo;

public class atb
    implements android.os.Parcelable.Creator
{

    public atb()
    {
    }

    public static void a(InstrumentInfo instrumentinfo, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, instrumentinfo.a());
        rq.a(parcel, 2, instrumentinfo.b(), false);
        rq.a(parcel, 3, instrumentinfo.c(), false);
        rq.a(parcel, i);
    }

    public InstrumentInfo a(Parcel parcel)
    {
        String s1 = null;
        int j = ro.b(parcel);
        int i = 0;
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
                    s = ro.k(parcel, k);
                    break;

                case 3: // '\003'
                    s1 = ro.k(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new InstrumentInfo(i, s, s1);
            }
        } while (true);
    }

    public InstrumentInfo[] a(int i)
    {
        return new InstrumentInfo[i];
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
