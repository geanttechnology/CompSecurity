// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

// Referenced classes of package com.google.android.gms.drive.internal:
//            CreateFileIntentSenderRequest

public final class d
    implements android.os.Parcelable.Creator
{

    public d()
    {
    }

    static void a(CreateFileIntentSenderRequest createfileintentsenderrequest, Parcel parcel, int i)
    {
        int j = c.a(parcel, 20293);
        c.b(parcel, 1, createfileintentsenderrequest.a);
        c.a(parcel, 2, createfileintentsenderrequest.b, i, false);
        c.b(parcel, 3, createfileintentsenderrequest.c);
        c.a(parcel, 4, createfileintentsenderrequest.d, false);
        c.a(parcel, 5, createfileintentsenderrequest.e, i, false);
        c.b(parcel, j);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int i = 0;
        DriveId driveid = null;
        int k = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        String s = null;
        MetadataBundle metadatabundle = null;
        int j = 0;
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
                    j = com.google.android.gms.common.internal.safeparcel.a.e(parcel, l);
                    break;

                case 2: // '\002'
                    metadatabundle = (MetadataBundle)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, MetadataBundle.CREATOR);
                    break;

                case 3: // '\003'
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, l);
                    break;

                case 4: // '\004'
                    s = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    break;

                case 5: // '\005'
                    driveid = (DriveId)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, DriveId.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new b((new StringBuilder("Overread allowed size end=")).append(k).toString(), parcel);
            } else
            {
                return new CreateFileIntentSenderRequest(j, metadatabundle, i, s, driveid);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new CreateFileIntentSenderRequest[i];
    }
}
