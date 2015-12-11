// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.internal.nn;

public class afi
    implements android.os.Parcelable.Creator
{

    public afi()
    {
    }

    public static void a(nn nn1, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, nn1.f(), false);
        rq.a(parcel, 1000, nn1.a());
        rq.a(parcel, 2, nn1.g());
        rq.a(parcel, 3, nn1.b());
        rq.a(parcel, 4, nn1.c());
        rq.a(parcel, 5, nn1.d());
        rq.a(parcel, 6, nn1.e());
        rq.a(parcel, 7, nn1.h());
        rq.a(parcel, 8, nn1.i());
        rq.a(parcel, 9, nn1.j());
        rq.a(parcel, i);
    }

    public nn a(Parcel parcel)
    {
        int i1 = ro.b(parcel);
        int l = 0;
        String s = null;
        int k = 0;
        short word0 = 0;
        double d1 = 0.0D;
        double d = 0.0D;
        float f = 0.0F;
        long l1 = 0L;
        int j = 0;
        int i = -1;
        do
        {
            if (parcel.dataPosition() < i1)
            {
                int j1 = ro.a(parcel);
                switch (ro.a(j1))
                {
                default:
                    ro.b(parcel, j1);
                    break;

                case 1: // '\001'
                    s = ro.k(parcel, j1);
                    break;

                case 1000: 
                    l = ro.f(parcel, j1);
                    break;

                case 2: // '\002'
                    l1 = ro.h(parcel, j1);
                    break;

                case 3: // '\003'
                    word0 = ro.e(parcel, j1);
                    break;

                case 4: // '\004'
                    d1 = ro.j(parcel, j1);
                    break;

                case 5: // '\005'
                    d = ro.j(parcel, j1);
                    break;

                case 6: // '\006'
                    f = ro.i(parcel, j1);
                    break;

                case 7: // '\007'
                    k = ro.f(parcel, j1);
                    break;

                case 8: // '\b'
                    j = ro.f(parcel, j1);
                    break;

                case 9: // '\t'
                    i = ro.f(parcel, j1);
                    break;
                }
            } else
            if (parcel.dataPosition() != i1)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(i1).toString(), parcel);
            } else
            {
                return new nn(l, s, k, word0, d1, d, f, l1, j, i);
            }
        } while (true);
    }

    public nn[] a(int i)
    {
        return new nn[i];
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
