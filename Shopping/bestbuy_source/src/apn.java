// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.model.Tile;

public class apn
    implements android.os.Parcelable.Creator
{

    public apn()
    {
    }

    public static void a(Tile tile, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, tile.a());
        rq.a(parcel, 2, tile.a);
        rq.a(parcel, 3, tile.b);
        rq.a(parcel, 4, tile.c, false);
        rq.a(parcel, i);
    }

    public Tile a(Parcel parcel)
    {
        int k = 0;
        int l = ro.b(parcel);
        byte abyte0[] = null;
        int j = 0;
        int i = 0;
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
                    i = ro.f(parcel, i1);
                    break;

                case 2: // '\002'
                    j = ro.f(parcel, i1);
                    break;

                case 3: // '\003'
                    k = ro.f(parcel, i1);
                    break;

                case 4: // '\004'
                    abyte0 = ro.n(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new Tile(i, j, k, abyte0);
            }
        } while (true);
    }

    public Tile[] a(int i)
    {
        return new Tile[i];
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
