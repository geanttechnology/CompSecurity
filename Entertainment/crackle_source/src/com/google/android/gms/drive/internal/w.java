// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

// Referenced classes of package com.google.android.gms.drive.internal:
//            OpenContentsRequest

public class w
    implements android.os.Parcelable.Creator
{

    public w()
    {
    }

    static void a(OpenContentsRequest opencontentsrequest, Parcel parcel, int i)
    {
        int j = b.o(parcel);
        b.c(parcel, 1, opencontentsrequest.kg);
        b.a(parcel, 2, opencontentsrequest.rr, i, false);
        b.c(parcel, 3, opencontentsrequest.qF);
        b.D(parcel, j);
    }

    public OpenContentsRequest L(Parcel parcel)
    {
        int i = 0;
        int k = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        DriveId driveid = null;
        int j = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = com.google.android.gms.common.internal.safeparcel.a.m(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.M(l))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, l);
                    break;

                case 1: // '\001'
                    j = com.google.android.gms.common.internal.safeparcel.a.g(parcel, l);
                    break;

                case 2: // '\002'
                    driveid = (DriveId)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, DriveId.CREATOR);
                    break;

                case 3: // '\003'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new OpenContentsRequest(j, driveid, i);
            }
        } while (true);
    }

    public OpenContentsRequest[] al(int i)
    {
        return new OpenContentsRequest[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return L(parcel);
    }

    public Object[] newArray(int i)
    {
        return al(i);
    }
}
