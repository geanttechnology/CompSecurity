// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.model.TileOverlayOptions;

public class app
    implements android.os.Parcelable.Creator
{

    public app()
    {
    }

    public static void a(TileOverlayOptions tileoverlayoptions, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, tileoverlayoptions.a());
        rq.a(parcel, 2, tileoverlayoptions.b(), false);
        rq.a(parcel, 3, tileoverlayoptions.d());
        rq.a(parcel, 4, tileoverlayoptions.c());
        rq.a(parcel, 5, tileoverlayoptions.e());
        rq.a(parcel, i);
    }

    public TileOverlayOptions a(Parcel parcel)
    {
        boolean flag1 = false;
        int j = ro.b(parcel);
        android.os.IBinder ibinder = null;
        float f = 0.0F;
        boolean flag = true;
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
                    ibinder = ro.l(parcel, k);
                    break;

                case 3: // '\003'
                    flag1 = ro.c(parcel, k);
                    break;

                case 4: // '\004'
                    f = ro.i(parcel, k);
                    break;

                case 5: // '\005'
                    flag = ro.c(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new TileOverlayOptions(i, ibinder, flag1, f, flag);
            }
        } while (true);
    }

    public TileOverlayOptions[] a(int i)
    {
        return new TileOverlayOptions[i];
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
