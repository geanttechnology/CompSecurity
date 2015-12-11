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
//            UpdateMetadataRequest

public class am
    implements android.os.Parcelable.Creator
{

    public am()
    {
    }

    static void a(UpdateMetadataRequest updatemetadatarequest, Parcel parcel, int i)
    {
        int j = b.p(parcel);
        b.c(parcel, 1, updatemetadatarequest.wj);
        b.a(parcel, 2, updatemetadatarequest.Do, i, false);
        b.a(parcel, 3, updatemetadatarequest.Dp, i, false);
        b.D(parcel, j);
    }

    public UpdateMetadataRequest Z(Parcel parcel)
    {
        MetadataBundle metadatabundle = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.o(parcel);
        int i = 0;
        DriveId driveid = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.S(k))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, k);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, k);
                    break;

                case 2: // '\002'
                    driveid = (DriveId)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, DriveId.CREATOR);
                    break;

                case 3: // '\003'
                    metadatabundle = (MetadataBundle)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, MetadataBundle.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new UpdateMetadataRequest(i, driveid, metadatabundle);
            }
        } while (true);
    }

    public UpdateMetadataRequest[] aE(int i)
    {
        return new UpdateMetadataRequest[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return Z(parcel);
    }

    public Object[] newArray(int i)
    {
        return aE(i);
    }
}
