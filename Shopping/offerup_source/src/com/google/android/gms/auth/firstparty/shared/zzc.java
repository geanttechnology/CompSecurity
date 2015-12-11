// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.auth.firstparty.shared:
//            ScopeDetail, FACLData

public class zzc
    implements android.os.Parcelable.Creator
{

    public zzc()
    {
    }

    static void zza(ScopeDetail scopedetail, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, scopedetail.version);
        zzb.zza(parcel, 2, scopedetail.description, false);
        zzb.zza(parcel, 3, scopedetail.zzTH, false);
        zzb.zza(parcel, 4, scopedetail.zzTI, false);
        zzb.zza(parcel, 5, scopedetail.zzTJ, false);
        zzb.zza(parcel, 6, scopedetail.zzTK, false);
        zzb.zzb(parcel, 7, scopedetail.zzTL, false);
        zzb.zza(parcel, 8, scopedetail.zzTM, i, false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzV(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzaM(i);
    }

    public ScopeDetail zzV(Parcel parcel)
    {
        FACLData facldata = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        ArrayList arraylist = new ArrayList();
        String s = null;
        String s1 = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
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
                    s4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 3: // '\003'
                    s3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 4: // '\004'
                    s2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 5: // '\005'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 6: // '\006'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 7: // '\007'
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzD(parcel, k);
                    break;

                case 8: // '\b'
                    facldata = (FACLData)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, FACLData.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new ScopeDetail(i, s4, s3, s2, s1, s, arraylist, facldata);
            }
        } while (true);
    }

    public ScopeDetail[] zzaM(int i)
    {
        return new ScopeDetail[i];
    }
}
