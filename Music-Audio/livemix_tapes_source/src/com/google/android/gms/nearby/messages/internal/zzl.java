// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;

// Referenced classes of package com.google.android.gms.nearby.messages.internal:
//            SubscribeRequest

public class zzl
    implements android.os.Parcelable.Creator
{

    public zzl()
    {
    }

    static void zza(SubscribeRequest subscriberequest, Parcel parcel, int i)
    {
        int j = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, subscriberequest.mVersionCode);
        zzb.zza(parcel, 2, subscriberequest.zzyq(), false);
        zzb.zza(parcel, 3, subscriberequest.zzaKd, i, false);
        zzb.zza(parcel, 4, subscriberequest.zzyp(), false);
        zzb.zza(parcel, 5, subscriberequest.zzaKg, i, false);
        zzb.zza(parcel, 6, subscriberequest.zzaKh, i, false);
        zzb.zzc(parcel, 7, subscriberequest.zzaKi);
        zzb.zza(parcel, 8, subscriberequest.zzaCr, false);
        zzb.zza(parcel, 9, subscriberequest.zzaKe, false);
        zzb.zza(parcel, 10, subscriberequest.zzaKj, false);
        zzb.zza(parcel, 11, subscriberequest.zzaJJ);
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzfE(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzis(i);
    }

    public SubscribeRequest zzfE(Parcel parcel)
    {
        boolean flag = false;
        byte abyte0[] = null;
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        String s = null;
        String s1 = null;
        int i = 0;
        PendingIntent pendingintent = null;
        MessageFilter messagefilter = null;
        android.os.IBinder ibinder = null;
        Strategy strategy = null;
        android.os.IBinder ibinder1 = null;
        int j = 0;
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
                    ibinder1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, l);
                    break;

                case 3: // '\003'
                    strategy = (Strategy)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, Strategy.CREATOR);
                    break;

                case 4: // '\004'
                    ibinder = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, l);
                    break;

                case 5: // '\005'
                    messagefilter = (MessageFilter)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, MessageFilter.CREATOR);
                    break;

                case 6: // '\006'
                    pendingintent = (PendingIntent)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, PendingIntent.CREATOR);
                    break;

                case 7: // '\007'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 8: // '\b'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    break;

                case 9: // '\t'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    break;

                case 10: // '\n'
                    abyte0 = com.google.android.gms.common.internal.safeparcel.zza.zzr(parcel, l);
                    break;

                case 11: // '\013'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new SubscribeRequest(j, ibinder1, strategy, ibinder, messagefilter, pendingintent, i, s1, s, abyte0, flag);
            }
        } while (true);
    }

    public SubscribeRequest[] zzis(int i)
    {
        return new SubscribeRequest[i];
    }
}
