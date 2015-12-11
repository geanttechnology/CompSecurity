// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.wearable.internal.z;

public class aut
    implements android.os.Parcelable.Creator
{

    public aut()
    {
    }

    public static void a(z z1, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, z1.a);
        rq.a(parcel, 2, z1.b);
        rq.a(parcel, 3, z1.c, i, false);
        rq.a(parcel, j);
    }

    public z a(Parcel parcel)
    {
        int j = 0;
        int k = ro.b(parcel);
        ParcelFileDescriptor parcelfiledescriptor = null;
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
                    parcelfiledescriptor = (ParcelFileDescriptor)ro.a(parcel, l, ParcelFileDescriptor.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new z(i, j, parcelfiledescriptor);
            }
        } while (true);
    }

    public z[] a(int i)
    {
        return new z[i];
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
