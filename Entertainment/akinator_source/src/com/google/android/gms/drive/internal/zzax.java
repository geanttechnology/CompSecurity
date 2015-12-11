// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.drive.internal:
//            OnDeviceUsagePreferenceResponse, FileUploadPreferencesImpl

public class zzax
    implements android.os.Parcelable.Creator
{

    public zzax()
    {
    }

    static void zza(OnDeviceUsagePreferenceResponse ondeviceusagepreferenceresponse, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, ondeviceusagepreferenceresponse.mVersionCode);
        zzb.zza(parcel, 2, ondeviceusagepreferenceresponse.zzalY, i, false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzbs(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzde(i);
    }

    public OnDeviceUsagePreferenceResponse zzbs(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        FileUploadPreferencesImpl fileuploadpreferencesimpl = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(k))
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
                return new OnDeviceUsagePreferenceResponse(i, fileuploadpreferencesimpl);
            }
        } while (true);
    }

    public OnDeviceUsagePreferenceResponse[] zzde(int i)
    {
        return new OnDeviceUsagePreferenceResponse[i];
    }
}
