// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.os.Parcel;
import com.google.android.gms.maps.model.internal.a;

public class aoa
    implements android.os.Parcelable.Creator
{

    public aoa()
    {
    }

    public static void a(a a1, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, a1.a());
        rq.a(parcel, 2, a1.b());
        rq.a(parcel, 3, a1.c(), false);
        rq.a(parcel, 4, a1.d(), i, false);
        rq.a(parcel, j);
    }

    public a a(Parcel parcel)
    {
        Bitmap bitmap = null;
        byte byte0 = 0;
        int j = ro.b(parcel);
        android.os.Bundle bundle = null;
        int i = 0;
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
                    byte0 = ro.d(parcel, k);
                    break;

                case 3: // '\003'
                    bundle = ro.m(parcel, k);
                    break;

                case 4: // '\004'
                    bitmap = (Bitmap)ro.a(parcel, k, Bitmap.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new a(i, byte0, bundle, bitmap);
            }
        } while (true);
    }

    public a[] a(int i)
    {
        return new a[i];
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
