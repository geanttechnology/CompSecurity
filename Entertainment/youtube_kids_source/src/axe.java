// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.images.WebImage;

public final class axe
    implements android.os.Parcelable.Creator
{

    public axe()
    {
    }

    public static void a(WebImage webimage, Parcel parcel, int i)
    {
        int j = a.g(parcel, 20293);
        a.c(parcel, 1, webimage.a);
        a.a(parcel, 2, webimage.b, i, false);
        a.c(parcel, 3, webimage.c);
        a.c(parcel, 4, webimage.d);
        a.h(parcel, j);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int i1 = a.a(parcel);
        int j = 0;
        Uri uri = null;
        int i = 0;
        int k = 0;
        do
        {
            if (parcel.dataPosition() < i1)
            {
                int j1 = parcel.readInt();
                switch (0xffff & j1)
                {
                default:
                    a.b(parcel, j1);
                    break;

                case 1: // '\001'
                    i = a.d(parcel, j1);
                    break;

                case 2: // '\002'
                    uri = (Uri)a.a(parcel, j1, Uri.CREATOR);
                    break;

                case 3: // '\003'
                    j = a.d(parcel, j1);
                    break;

                case 4: // '\004'
                    k = a.d(parcel, j1);
                    break;
                }
            } else
            if (parcel.dataPosition() != i1)
            {
                throw new l((new StringBuilder("Overread allowed size end=")).append(i1).toString(), parcel);
            } else
            {
                return new WebImage(i, uri, j, k);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new WebImage[i];
    }
}
