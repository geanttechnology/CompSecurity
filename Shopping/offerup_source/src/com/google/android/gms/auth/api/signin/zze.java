// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.auth.api.signin:
//            GoogleSignInConfig

public class zze
    implements android.os.Parcelable.Creator
{

    public zze()
    {
    }

    static void zza(GoogleSignInConfig googlesigninconfig, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, googlesigninconfig.versionCode);
        zzb.zzc(parcel, 2, googlesigninconfig.zzlS(), false);
        zzb.zza(parcel, 3, googlesigninconfig.getAccount(), i, false);
        zzb.zza(parcel, 4, googlesigninconfig.zzlY());
        zzb.zza(parcel, 5, googlesigninconfig.zzlZ());
        zzb.zza(parcel, 6, googlesigninconfig.zzma());
        zzb.zza(parcel, 7, googlesigninconfig.zzmb(), false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzR(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzaI(i);
    }

    public GoogleSignInConfig zzR(Parcel parcel)
    {
        String s = null;
        boolean flag = false;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        boolean flag1 = false;
        boolean flag2 = false;
        Account account = null;
        java.util.ArrayList arraylist = null;
        int i = 0;
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
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k, Scope.CREATOR);
                    break;

                case 3: // '\003'
                    account = (Account)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, Account.CREATOR);
                    break;

                case 4: // '\004'
                    flag2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 5: // '\005'
                    flag1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 6: // '\006'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 7: // '\007'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new GoogleSignInConfig(i, arraylist, account, flag2, flag1, flag, s);
            }
        } while (true);
    }

    public GoogleSignInConfig[] zzaI(int i)
    {
        return new GoogleSignInConfig[i];
    }
}
