// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.vision.face.internal.client:
//            FaceParcel, LandmarkParcel

public class zza
    implements android.os.Parcelable.Creator
{

    public zza()
    {
    }

    static void zza(FaceParcel faceparcel, Parcel parcel, int i)
    {
        int j = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, faceparcel.versionCode);
        zzb.zzc(parcel, 2, faceparcel.id);
        zzb.zza(parcel, 3, faceparcel.centerX);
        zzb.zza(parcel, 4, faceparcel.centerY);
        zzb.zza(parcel, 5, faceparcel.width);
        zzb.zza(parcel, 6, faceparcel.height);
        zzb.zza(parcel, 7, faceparcel.zzaVK);
        zzb.zza(parcel, 8, faceparcel.zzaVL);
        zzb.zza(parcel, 9, faceparcel.zzaVM, i, false);
        zzb.zza(parcel, 10, faceparcel.zzaVN);
        zzb.zza(parcel, 11, faceparcel.zzaVO);
        zzb.zza(parcel, 12, faceparcel.zzaVP);
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzgA(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzjE(i);
    }

    public FaceParcel zzgA(Parcel parcel)
    {
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int j = 0;
        int i = 0;
        float f8 = 0.0F;
        float f7 = 0.0F;
        float f6 = 0.0F;
        float f5 = 0.0F;
        float f4 = 0.0F;
        float f3 = 0.0F;
        LandmarkParcel alandmarkparcel[] = null;
        float f2 = 0.0F;
        float f1 = 0.0F;
        float f = 0.0F;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(l))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, l);
                    break;

                case 1: // '\001'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 2: // '\002'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 3: // '\003'
                    f8 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, l);
                    break;

                case 4: // '\004'
                    f7 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, l);
                    break;

                case 5: // '\005'
                    f6 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, l);
                    break;

                case 6: // '\006'
                    f5 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, l);
                    break;

                case 7: // '\007'
                    f4 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, l);
                    break;

                case 8: // '\b'
                    f3 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, l);
                    break;

                case 9: // '\t'
                    alandmarkparcel = (LandmarkParcel[])com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, l, LandmarkParcel.CREATOR);
                    break;

                case 10: // '\n'
                    f2 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, l);
                    break;

                case 11: // '\013'
                    f1 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, l);
                    break;

                case 12: // '\f'
                    f = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new FaceParcel(j, i, f8, f7, f6, f5, f4, f3, alandmarkparcel, f2, f1, f);
            }
        } while (true);
    }

    public FaceParcel[] zzjE(int i)
    {
        return new FaceParcel[i];
    }
}
