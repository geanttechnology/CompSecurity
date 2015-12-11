// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.internal.oh;

public class afx
    implements android.os.Parcelable.Creator
{

    public afx()
    {
    }

    public static void a(oh oh1, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, oh1.c, false);
        rq.a(parcel, 1000, oh1.b);
        rq.a(parcel, 2, oh1.d, false);
        rq.a(parcel, 3, oh1.e, false);
        rq.a(parcel, 4, oh1.f, false);
        rq.a(parcel, i);
    }

    public oh a(Parcel parcel)
    {
        String s = null;
        int j = ro.b(parcel);
        int i = 0;
        String s1 = null;
        String s2 = null;
        String s3 = null;
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
                    s3 = ro.k(parcel, k);
                    break;

                case 1000: 
                    i = ro.f(parcel, k);
                    break;

                case 2: // '\002'
                    s2 = ro.k(parcel, k);
                    break;

                case 3: // '\003'
                    s1 = ro.k(parcel, k);
                    break;

                case 4: // '\004'
                    s = ro.k(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new oh(i, s3, s2, s1, s);
            }
        } while (true);
    }

    public oh[] a(int i)
    {
        return new oh[i];
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
