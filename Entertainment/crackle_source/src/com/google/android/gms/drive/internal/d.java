// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

// Referenced classes of package com.google.android.gms.drive.internal:
//            CreateFileIntentSenderRequest

public class d
    implements android.os.Parcelable.Creator
{

    public d()
    {
    }

    static void a(CreateFileIntentSenderRequest createfileintentsenderrequest, Parcel parcel, int i)
    {
        int j = b.o(parcel);
        b.c(parcel, 1, createfileintentsenderrequest.kg);
        b.a(parcel, 2, createfileintentsenderrequest.qZ, i, false);
        b.c(parcel, 3, createfileintentsenderrequest.qE);
        b.a(parcel, 4, createfileintentsenderrequest.qL, false);
        b.a(parcel, 5, createfileintentsenderrequest.qM, i, false);
        b.D(parcel, j);
    }

    public CreateFileIntentSenderRequest C(Parcel parcel)
    {
        int i = 0;
        DriveId driveid = null;
        int k = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        String s = null;
        MetadataBundle metadatabundle = null;
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
                    metadatabundle = (MetadataBundle)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, MetadataBundle.CREATOR);
                    break;

                case 3: // '\003'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, l);
                    break;

                case 4: // '\004'
                    s = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;

                case 5: // '\005'
                    driveid = (DriveId)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, DriveId.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new CreateFileIntentSenderRequest(j, metadatabundle, i, s, driveid);
            }
        } while (true);
    }

    public CreateFileIntentSenderRequest[] ac(int i)
    {
        return new CreateFileIntentSenderRequest[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return C(parcel);
    }

    public Object[] newArray(int i)
    {
        return ac(i);
    }
}
