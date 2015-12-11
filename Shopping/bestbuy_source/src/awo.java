// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;

public class awo
    implements android.os.Parcelable.Creator
{

    public awo()
    {
    }

    public static void a(DataItemAssetParcelable dataitemassetparcelable, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, dataitemassetparcelable.a);
        rq.a(parcel, 2, dataitemassetparcelable.b(), false);
        rq.a(parcel, 3, dataitemassetparcelable.c(), false);
        rq.a(parcel, i);
    }

    public DataItemAssetParcelable a(Parcel parcel)
    {
        String s1 = null;
        int j = ro.b(parcel);
        int i = 0;
        String s = null;
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
                    s = ro.k(parcel, k);
                    break;

                case 3: // '\003'
                    s1 = ro.k(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new DataItemAssetParcelable(i, s, s1);
            }
        } while (true);
    }

    public DataItemAssetParcelable[] a(int i)
    {
        return new DataItemAssetParcelable[i];
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
