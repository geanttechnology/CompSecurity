// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.drive.internal:
//            SetFileUploadPreferencesRequest, FileUploadPreferencesImpl

public class zzbp
    implements android.os.Parcelable.Creator
{

    public zzbp()
    {
    }

    static void zza(SetFileUploadPreferencesRequest setfileuploadpreferencesrequest, Parcel parcel, int i)
    {
        int j = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, setfileuploadpreferencesrequest.mVersionCode);
        zzb.zza(parcel, 2, setfileuploadpreferencesrequest.zzajJ, i, false);
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzbC(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzdq(i);
    }

    public SetFileUploadPreferencesRequest zzbC(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        FileUploadPreferencesImpl fileuploadpreferencesimpl = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(k))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, k);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    fileuploadpreferencesimpl = (FileUploadPreferencesImpl)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, FileUploadPreferencesImpl.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new SetFileUploadPreferencesRequest(i, fileuploadpreferencesimpl);
            }
        } while (true);
    }

    public SetFileUploadPreferencesRequest[] zzdq(int i)
    {
        return new SetFileUploadPreferencesRequest[i];
    }
}
