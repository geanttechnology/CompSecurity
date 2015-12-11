// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.wearable.internal.an;
import com.google.android.gms.wearable.internal.aw;

public class avu
    implements android.os.Parcelable.Creator
{

    public avu()
    {
    }

    public static void a(aw aw1, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, aw1.a);
        rq.a(parcel, 2, aw1.b);
        rq.a(parcel, 3, aw1.c);
        rq.b(parcel, 4, aw1.d, false);
        rq.a(parcel, i);
    }

    public aw a(Parcel parcel)
    {
        int i = 0;
        int k = ro.b(parcel);
        long l1 = 0L;
        java.util.ArrayList arraylist = null;
        int j = 0;
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
                    j = ro.f(parcel, l);
                    break;

                case 2: // '\002'
                    i = ro.f(parcel, l);
                    break;

                case 3: // '\003'
                    l1 = ro.h(parcel, l);
                    break;

                case 4: // '\004'
                    arraylist = ro.c(parcel, l, an.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new aw(j, i, l1, arraylist);
            }
        } while (true);
    }

    public aw[] a(int i)
    {
        return new aw[i];
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
