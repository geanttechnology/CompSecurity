// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

// Referenced classes of package com.google.android.gms.drive.internal:
//            CreateFileRequest

public class zzm
    implements android.os.Parcelable.Creator
{

    public zzm()
    {
    }

    static void zza(CreateFileRequest createfilerequest, Parcel parcel, int i)
    {
        int j = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, createfilerequest.mVersionCode);
        zzb.zza(parcel, 2, createfilerequest.zzaid, i, false);
        zzb.zza(parcel, 3, createfilerequest.zzaib, i, false);
        zzb.zza(parcel, 4, createfilerequest.zzahR, i, false);
        zzb.zza(parcel, 5, createfilerequest.zzaic, false);
        zzb.zza(parcel, 6, createfilerequest.zzahM);
        zzb.zza(parcel, 7, createfilerequest.zzagM, false);
        zzb.zzc(parcel, 8, createfilerequest.zzaie);
        zzb.zzc(parcel, 9, createfilerequest.zzaif);
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzaU(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzcE(i);
    }

    public CreateFileRequest zzaU(Parcel parcel)
    {
        int i = 0;
        String s = null;
        int l = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int j = 0;
        boolean flag = false;
        Integer integer = null;
        Contents contents = null;
        MetadataBundle metadatabundle = null;
        DriveId driveid = null;
        int k = 0;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(i1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, i1);
                    break;

                case 1: // '\001'
                    k = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 2: // '\002'
                    driveid = (DriveId)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, i1, DriveId.CREATOR);
                    break;

                case 3: // '\003'
                    metadatabundle = (MetadataBundle)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, i1, MetadataBundle.CREATOR);
                    break;

                case 4: // '\004'
                    contents = (Contents)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, i1, Contents.CREATOR);
                    break;

                case 5: // '\005'
                    integer = com.google.android.gms.common.internal.safeparcel.zza.zzh(parcel, i1);
                    break;

                case 6: // '\006'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, i1);
                    break;

                case 7: // '\007'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, i1);
                    break;

                case 8: // '\b'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 9: // '\t'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new CreateFileRequest(k, driveid, metadatabundle, contents, integer, flag, s, j, i);
            }
        } while (true);
    }

    public CreateFileRequest[] zzcE(int i)
    {
        return new CreateFileRequest[i];
    }
}
