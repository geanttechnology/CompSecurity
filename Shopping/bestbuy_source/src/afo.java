// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.internal.nu;
import com.google.android.gms.internal.ny;

public class afo
    implements android.os.Parcelable.Creator
{

    public afo()
    {
    }

    public static void a(ny ny1, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1000, ny1.b);
        rq.a(parcel, 2, ny1.a(), i, false);
        rq.a(parcel, 3, ny1.b());
        rq.a(parcel, 4, ny1.c());
        rq.a(parcel, j);
    }

    public ny a(Parcel parcel)
    {
        int k = ro.b(parcel);
        int j = 0;
        nu nu1 = null;
        long l1 = ny.a;
        int i = 102;
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

                case 1000: 
                    j = ro.f(parcel, l);
                    break;

                case 2: // '\002'
                    nu1 = (nu)ro.a(parcel, l, nu.CREATOR);
                    break;

                case 3: // '\003'
                    l1 = ro.h(parcel, l);
                    break;

                case 4: // '\004'
                    i = ro.f(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new ny(j, nu1, l1, i);
            }
        } while (true);
    }

    public ny[] a(int i)
    {
        return new ny[i];
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
