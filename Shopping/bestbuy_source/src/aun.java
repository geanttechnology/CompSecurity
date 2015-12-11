// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.wearable.Asset;

public class aun
    implements android.os.Parcelable.Creator
{

    public aun()
    {
    }

    public static void a(Asset asset, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, asset.a);
        rq.a(parcel, 2, asset.a(), false);
        rq.a(parcel, 3, asset.b(), false);
        rq.a(parcel, 4, asset.b, i, false);
        rq.a(parcel, 5, asset.c, i, false);
        rq.a(parcel, j);
    }

    public Asset a(Parcel parcel)
    {
        Uri uri = null;
        int j = ro.b(parcel);
        int i = 0;
        ParcelFileDescriptor parcelfiledescriptor = null;
        String s = null;
        byte abyte0[] = null;
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
                    abyte0 = ro.n(parcel, k);
                    break;

                case 3: // '\003'
                    s = ro.k(parcel, k);
                    break;

                case 4: // '\004'
                    parcelfiledescriptor = (ParcelFileDescriptor)ro.a(parcel, k, ParcelFileDescriptor.CREATOR);
                    break;

                case 5: // '\005'
                    uri = (Uri)ro.a(parcel, k, Uri.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new Asset(i, abyte0, s, parcelfiledescriptor, uri);
            }
        } while (true);
    }

    public Asset[] a(int i)
    {
        return new Asset[i];
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
