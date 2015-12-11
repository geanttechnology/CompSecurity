// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.maps.model.CameraPosition;

// Referenced classes of package com.google.android.gms.maps:
//            GoogleMapOptions

public class zza
    implements android.os.Parcelable.Creator
{

    public zza()
    {
    }

    static void zza(GoogleMapOptions googlemapoptions, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, googlemapoptions.getVersionCode());
        zzb.zza(parcel, 2, googlemapoptions.zzxz());
        zzb.zza(parcel, 3, googlemapoptions.zzxA());
        zzb.zzc(parcel, 4, googlemapoptions.getMapType());
        zzb.zza(parcel, 5, googlemapoptions.getCamera(), i, false);
        zzb.zza(parcel, 6, googlemapoptions.zzxB());
        zzb.zza(parcel, 7, googlemapoptions.zzxC());
        zzb.zza(parcel, 8, googlemapoptions.zzxD());
        zzb.zza(parcel, 9, googlemapoptions.zzxE());
        zzb.zza(parcel, 10, googlemapoptions.zzxF());
        zzb.zza(parcel, 11, googlemapoptions.zzxG());
        zzb.zza(parcel, 12, googlemapoptions.zzxH());
        zzb.zza(parcel, 14, googlemapoptions.zzxI());
        zzb.zza(parcel, 15, googlemapoptions.zzxJ());
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzff(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzhD(i);
    }

    public GoogleMapOptions zzff(Parcel parcel)
    {
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int j = 0;
        byte byte10 = -1;
        byte byte9 = -1;
        int i = 0;
        CameraPosition cameraposition = null;
        byte byte8 = -1;
        byte byte7 = -1;
        byte byte6 = -1;
        byte byte5 = -1;
        byte byte4 = -1;
        byte byte3 = -1;
        byte byte2 = -1;
        byte byte1 = -1;
        byte byte0 = -1;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(l))
                {
                case 13: // '\r'
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, l);
                    break;

                case 1: // '\001'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 2: // '\002'
                    byte10 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, l);
                    break;

                case 3: // '\003'
                    byte9 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, l);
                    break;

                case 4: // '\004'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 5: // '\005'
                    cameraposition = (CameraPosition)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, CameraPosition.CREATOR);
                    break;

                case 6: // '\006'
                    byte8 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, l);
                    break;

                case 7: // '\007'
                    byte7 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, l);
                    break;

                case 8: // '\b'
                    byte6 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, l);
                    break;

                case 9: // '\t'
                    byte5 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, l);
                    break;

                case 10: // '\n'
                    byte4 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, l);
                    break;

                case 11: // '\013'
                    byte3 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, l);
                    break;

                case 12: // '\f'
                    byte2 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, l);
                    break;

                case 14: // '\016'
                    byte1 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, l);
                    break;

                case 15: // '\017'
                    byte0 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza((new StringBuilder("Overread allowed size end=")).append(k).toString(), parcel);
            } else
            {
                return new GoogleMapOptions(j, byte10, byte9, i, cameraposition, byte8, byte7, byte6, byte5, byte4, byte3, byte2, byte1, byte0);
            }
        } while (true);
    }

    public GoogleMapOptions[] zzhD(int i)
    {
        return new GoogleMapOptions[i];
    }
}
