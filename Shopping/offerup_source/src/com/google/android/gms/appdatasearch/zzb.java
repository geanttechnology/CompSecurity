// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;

// Referenced classes of package com.google.android.gms.appdatasearch:
//            DocumentContents, DocumentSection

public class zzb
    implements android.os.Parcelable.Creator
{

    public zzb()
    {
    }

    static void zza(DocumentContents documentcontents, Parcel parcel, int i)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zzb.zzaq(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, documentcontents.zzPX, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, documentcontents.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, documentcontents.zzPY, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, documentcontents.zzPZ);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, documentcontents.account, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzr(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzae(i);
    }

    public DocumentContents[] zzae(int i)
    {
        return new DocumentContents[i];
    }

    public DocumentContents zzr(Parcel parcel)
    {
        boolean flag = false;
        Account account = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        String s = null;
        DocumentSection adocumentsection[] = null;
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
                    adocumentsection = (DocumentSection[])com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, k, DocumentSection.CREATOR);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 3: // '\003'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 4: // '\004'
                    account = (Account)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, Account.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new DocumentContents(i, adocumentsection, s, flag, account);
            }
        } while (true);
    }
}
