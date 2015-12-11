// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import com.google.android.gms.auth.api.signin.EmailSignInConfig;
import com.google.android.gms.auth.api.signin.FacebookSignInConfig;
import com.google.android.gms.auth.api.signin.GoogleSignInConfig;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.auth.api.signin.internal:
//            SignInConfiguration

public class zzh
    implements android.os.Parcelable.Creator
{

    public zzh()
    {
    }

    static void zza(SignInConfiguration signinconfiguration, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, signinconfiguration.versionCode);
        zzb.zza(parcel, 2, signinconfiguration.zzme(), false);
        zzb.zza(parcel, 3, signinconfiguration.zzmb(), false);
        zzb.zza(parcel, 4, signinconfiguration.zzmf(), i, false);
        zzb.zza(parcel, 5, signinconfiguration.zzmg(), i, false);
        zzb.zza(parcel, 6, signinconfiguration.zzmh(), i, false);
        zzb.zza(parcel, 7, signinconfiguration.zzmi(), false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzS(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzaJ(i);
    }

    public SignInConfiguration zzS(Parcel parcel)
    {
        String s = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        FacebookSignInConfig facebooksigninconfig = null;
        GoogleSignInConfig googlesigninconfig = null;
        EmailSignInConfig emailsigninconfig = null;
        String s1 = null;
        String s2 = null;
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
                    s2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 3: // '\003'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 4: // '\004'
                    emailsigninconfig = (EmailSignInConfig)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, EmailSignInConfig.CREATOR);
                    break;

                case 5: // '\005'
                    googlesigninconfig = (GoogleSignInConfig)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, GoogleSignInConfig.CREATOR);
                    break;

                case 6: // '\006'
                    facebooksigninconfig = (FacebookSignInConfig)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, FacebookSignInConfig.CREATOR);
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
                return new SignInConfiguration(i, s2, s1, emailsigninconfig, googlesigninconfig, facebooksigninconfig, s);
            }
        } while (true);
    }

    public SignInConfiguration[] zzaJ(int i)
    {
        return new SignInConfiguration[i];
    }
}
