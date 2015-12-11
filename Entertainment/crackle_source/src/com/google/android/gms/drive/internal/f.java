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
//            CreateFolderRequest

public class f
    implements android.os.Parcelable.Creator
{

    public f()
    {
    }

    static void a(CreateFolderRequest createfolderrequest, Parcel parcel, int i)
    {
        int j = b.o(parcel);
        b.c(parcel, 1, createfolderrequest.kg);
        b.a(parcel, 2, createfolderrequest.ra, i, false);
        b.a(parcel, 3, createfolderrequest.qZ, i, false);
        b.D(parcel, j);
    }

    public CreateFolderRequest E(Parcel parcel)
    {
        MetadataBundle metadatabundle = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        int i = 0;
        DriveId driveid = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = com.google.android.gms.common.internal.safeparcel.a.m(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.M(k))
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
                return new CreateFolderRequest(i, driveid, metadatabundle);
            }
        } while (true);
    }

    public CreateFolderRequest[] ae(int i)
    {
        return new CreateFolderRequest[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return E(parcel);
    }

    public Object[] newArray(int i)
    {
        return ae(i);
    }
}
