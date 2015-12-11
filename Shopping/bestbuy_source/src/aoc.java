// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.model.internal.a;
import com.google.android.gms.maps.model.internal.e;

public class aoc
    implements android.os.Parcelable.Creator
{

    public aoc()
    {
    }

    public static void a(e e1, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, e1.a());
        rq.a(parcel, 2, e1.b(), i, false);
        rq.a(parcel, j);
    }

    public e a(Parcel parcel)
    {
        int j = ro.b(parcel);
        int i = 0;
        a a1 = null;
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
                    a1 = (a)ro.a(parcel, k, a.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new e(i, a1);
            }
        } while (true);
    }

    public e[] a(int i)
    {
        return new e[i];
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
