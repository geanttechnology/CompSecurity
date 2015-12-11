// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.wearable.internal.ab;
import com.google.android.gms.wearable.internal.al;

public class auu
    implements android.os.Parcelable.Creator
{

    public auu()
    {
    }

    public static void a(ab ab1, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, ab1.a);
        rq.a(parcel, 2, ab1.b);
        rq.a(parcel, 3, ab1.c, i, false);
        rq.a(parcel, j);
    }

    public ab a(Parcel parcel)
    {
        int j = 0;
        int k = ro.b(parcel);
        al al1 = null;
        int i = 0;
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

                case 1: // '\001'
                    i = ro.f(parcel, l);
                    break;

                case 2: // '\002'
                    j = ro.f(parcel, l);
                    break;

                case 3: // '\003'
                    al1 = (al)ro.a(parcel, l, al.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new ab(i, j, al1);
            }
        } while (true);
    }

    public ab[] a(int i)
    {
        return new ab[i];
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
