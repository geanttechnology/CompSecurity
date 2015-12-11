// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

public class adx
    implements android.os.Parcelable.Creator
{

    public adx()
    {
    }

    public static void a(com.google.android.gms.internal.jg.a a1, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, a1.a(), false);
        rq.a(parcel, 1000, a1.e());
        rq.a(parcel, 2, a1.d(), false);
        rq.a(parcel, 3, a1.b());
        rq.a(parcel, 4, a1.c(), false);
        rq.a(parcel, i);
    }

    public com.google.android.gms.internal.jg.a a(Parcel parcel)
    {
        int i = 0;
        String s = null;
        int k = ro.b(parcel);
        java.util.ArrayList arraylist = null;
        String s1 = null;
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
                    s1 = ro.k(parcel, l);
                    break;

                case 1000: 
                    j = ro.f(parcel, l);
                    break;

                case 2: // '\002'
                    arraylist = ro.p(parcel, l);
                    break;

                case 3: // '\003'
                    i = ro.f(parcel, l);
                    break;

                case 4: // '\004'
                    s = ro.k(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new com.google.android.gms.internal.jg.a(j, s1, arraylist, i, s);
            }
        } while (true);
    }

    public com.google.android.gms.internal.jg.a[] a(int i)
    {
        return new com.google.android.gms.internal.jg.a[i];
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
