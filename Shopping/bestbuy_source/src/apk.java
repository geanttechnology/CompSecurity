// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.model.StreetViewPanoramaLink;

public class apk
    implements android.os.Parcelable.Creator
{

    public apk()
    {
    }

    public static void a(StreetViewPanoramaLink streetviewpanoramalink, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, streetviewpanoramalink.a());
        rq.a(parcel, 2, streetviewpanoramalink.a, false);
        rq.a(parcel, 3, streetviewpanoramalink.b);
        rq.a(parcel, i);
    }

    public StreetViewPanoramaLink a(Parcel parcel)
    {
        int j = ro.b(parcel);
        int i = 0;
        String s = null;
        float f = 0.0F;
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
                    f = ro.i(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new StreetViewPanoramaLink(i, s, f);
            }
        } while (true);
    }

    public StreetViewPanoramaLink[] a(int i)
    {
        return new StreetViewPanoramaLink[i];
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
