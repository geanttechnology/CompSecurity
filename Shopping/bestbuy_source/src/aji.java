// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.model.CameraPosition;

public class aji
    implements android.os.Parcelable.Creator
{

    public aji()
    {
    }

    public static void a(GoogleMapOptions googlemapoptions, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, googlemapoptions.a());
        rq.a(parcel, 2, googlemapoptions.b());
        rq.a(parcel, 3, googlemapoptions.c());
        rq.a(parcel, 4, googlemapoptions.l());
        rq.a(parcel, 5, googlemapoptions.m(), i, false);
        rq.a(parcel, 6, googlemapoptions.d());
        rq.a(parcel, 7, googlemapoptions.e());
        rq.a(parcel, 8, googlemapoptions.f());
        rq.a(parcel, 9, googlemapoptions.g());
        rq.a(parcel, 10, googlemapoptions.h());
        rq.a(parcel, 11, googlemapoptions.i());
        rq.a(parcel, 12, googlemapoptions.j());
        rq.a(parcel, 14, googlemapoptions.k());
        rq.a(parcel, j);
    }

    public GoogleMapOptions a(Parcel parcel)
    {
        int k = ro.b(parcel);
        int j = 0;
        byte byte9 = 0;
        byte byte8 = 0;
        int i = 0;
        CameraPosition cameraposition = null;
        byte byte7 = 0;
        byte byte6 = 0;
        byte byte5 = 0;
        byte byte4 = 0;
        byte byte3 = 0;
        byte byte2 = 0;
        byte byte1 = 0;
        byte byte0 = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = ro.a(parcel);
                switch (ro.a(l))
                {
                case 13: // '\r'
                default:
                    ro.b(parcel, l);
                    break;

                case 1: // '\001'
                    j = ro.f(parcel, l);
                    break;

                case 2: // '\002'
                    byte9 = ro.d(parcel, l);
                    break;

                case 3: // '\003'
                    byte8 = ro.d(parcel, l);
                    break;

                case 4: // '\004'
                    i = ro.f(parcel, l);
                    break;

                case 5: // '\005'
                    cameraposition = (CameraPosition)ro.a(parcel, l, CameraPosition.CREATOR);
                    break;

                case 6: // '\006'
                    byte7 = ro.d(parcel, l);
                    break;

                case 7: // '\007'
                    byte6 = ro.d(parcel, l);
                    break;

                case 8: // '\b'
                    byte5 = ro.d(parcel, l);
                    break;

                case 9: // '\t'
                    byte4 = ro.d(parcel, l);
                    break;

                case 10: // '\n'
                    byte3 = ro.d(parcel, l);
                    break;

                case 11: // '\013'
                    byte2 = ro.d(parcel, l);
                    break;

                case 12: // '\f'
                    byte1 = ro.d(parcel, l);
                    break;

                case 14: // '\016'
                    byte0 = ro.d(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new GoogleMapOptions(j, byte9, byte8, i, cameraposition, byte7, byte6, byte5, byte4, byte3, byte2, byte1, byte0);
            }
        } while (true);
    }

    public GoogleMapOptions[] a(int i)
    {
        return new GoogleMapOptions[i];
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
