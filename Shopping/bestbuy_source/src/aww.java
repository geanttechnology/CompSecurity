// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.wearable.internal.al;
import com.google.android.gms.wearable.internal.v;

public class aww
    implements android.os.Parcelable.Creator
{

    public aww()
    {
    }

    public static void a(v v1, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, v1.a);
        rq.a(parcel, 2, v1.b);
        rq.b(parcel, 3, v1.c, false);
        rq.a(parcel, i);
    }

    public v a(Parcel parcel)
    {
        int j = 0;
        int k = ro.b(parcel);
        java.util.ArrayList arraylist = null;
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
                    arraylist = ro.c(parcel, l, al.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new v(i, j, arraylist);
            }
        } while (true);
    }

    public v[] a(int i)
    {
        return new v[i];
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
