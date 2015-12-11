// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.images.WebImage;

public final class avn
    implements android.os.Parcelable.Creator
{

    public avn()
    {
    }

    public static void a(ApplicationMetadata applicationmetadata, Parcel parcel, int i)
    {
        int j = a.g(parcel, 20293);
        a.c(parcel, 1, applicationmetadata.a);
        a.a(parcel, 2, applicationmetadata.b, false);
        a.a(parcel, 3, applicationmetadata.c, false);
        a.b(parcel, 4, applicationmetadata.d, false);
        a.a(parcel, 5, applicationmetadata.e, false);
        a.a(parcel, 6, applicationmetadata.f, false);
        a.a(parcel, 7, applicationmetadata.g, i, false);
        a.h(parcel, j);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        Uri uri = null;
        int j = a.a(parcel);
        int i = 0;
        String s = null;
        java.util.ArrayList arraylist = null;
        java.util.ArrayList arraylist1 = null;
        String s1 = null;
        String s2 = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = parcel.readInt();
                switch (0xffff & k)
                {
                default:
                    a.b(parcel, k);
                    break;

                case 1: // '\001'
                    i = a.d(parcel, k);
                    break;

                case 2: // '\002'
                    s2 = a.e(parcel, k);
                    break;

                case 3: // '\003'
                    s1 = a.e(parcel, k);
                    break;

                case 4: // '\004'
                    arraylist1 = a.b(parcel, k, WebImage.CREATOR);
                    break;

                case 5: // '\005'
                    arraylist = a.f(parcel, k);
                    break;

                case 6: // '\006'
                    s = a.e(parcel, k);
                    break;

                case 7: // '\007'
                    uri = (Uri)a.a(parcel, k, Uri.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new l((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new ApplicationMetadata(i, s2, s1, arraylist1, arraylist, s, uri);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new ApplicationMetadata[i];
    }
}
