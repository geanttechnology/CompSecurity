// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

// Referenced classes of package com.google.android.gms.drive.internal:
//            OnDownloadProgressResponse

public final class j
    implements android.os.Parcelable.Creator
{

    public j()
    {
    }

    static void a(OnDownloadProgressResponse ondownloadprogressresponse, Parcel parcel)
    {
        int i = c.a(parcel, 20293);
        c.b(parcel, 1, ondownloadprogressresponse.a);
        c.a(parcel, 2, ondownloadprogressresponse.b);
        c.a(parcel, 3, ondownloadprogressresponse.c);
        c.b(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        long l1 = 0L;
        int k = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        int i = 0;
        long l2 = 0L;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = parcel.readInt();
                switch (0xffff & l)
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, l);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, l);
                    break;

                case 2: // '\002'
                    l2 = com.google.android.gms.common.internal.safeparcel.a.f(parcel, l);
                    break;

                case 3: // '\003'
                    l1 = com.google.android.gms.common.internal.safeparcel.a.f(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new b((new StringBuilder("Overread allowed size end=")).append(k).toString(), parcel);
            } else
            {
                return new OnDownloadProgressResponse(i, l2, l1);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new OnDownloadProgressResponse[i];
    }
}
