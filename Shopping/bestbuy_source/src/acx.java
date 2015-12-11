// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.jj;

public class acx
    implements android.os.Parcelable.Creator
{

    public acx()
    {
    }

    public static void a(jj jj1, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, jj1.a);
        rq.a(parcel, 2, jj1.b);
        rq.a(parcel, 3, jj1.c);
        rq.a(parcel, 4, jj1.d, false);
        rq.a(parcel, 5, jj1.e, false);
        rq.a(parcel, 6, jj1.f, i, false);
        rq.a(parcel, 7, jj1.g, false);
        rq.a(parcel, j);
    }

    public jj a(Parcel parcel)
    {
        int i = 0;
        android.os.Bundle bundle = null;
        int l = ro.b(parcel);
        Scope ascope[] = null;
        android.os.IBinder ibinder = null;
        String s = null;
        int j = 0;
        int k = 0;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = ro.a(parcel);
                switch (ro.a(i1))
                {
                default:
                    ro.b(parcel, i1);
                    break;

                case 1: // '\001'
                    k = ro.f(parcel, i1);
                    break;

                case 2: // '\002'
                    j = ro.f(parcel, i1);
                    break;

                case 3: // '\003'
                    i = ro.f(parcel, i1);
                    break;

                case 4: // '\004'
                    s = ro.k(parcel, i1);
                    break;

                case 5: // '\005'
                    ibinder = ro.l(parcel, i1);
                    break;

                case 6: // '\006'
                    ascope = (Scope[])ro.b(parcel, i1, Scope.CREATOR);
                    break;

                case 7: // '\007'
                    bundle = ro.m(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new jj(k, j, i, s, ibinder, ascope, bundle);
            }
        } while (true);
    }

    public jj[] a(int i)
    {
        return new jj[i];
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
