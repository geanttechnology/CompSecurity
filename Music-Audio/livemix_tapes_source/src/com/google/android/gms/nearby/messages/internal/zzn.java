// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.nearby.messages.internal:
//            UnsubscribeRequest

public class zzn
    implements android.os.Parcelable.Creator
{

    public zzn()
    {
    }

    static void zza(UnsubscribeRequest unsubscriberequest, Parcel parcel, int i)
    {
        int j = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, unsubscriberequest.mVersionCode);
        zzb.zza(parcel, 2, unsubscriberequest.zzyq(), false);
        zzb.zza(parcel, 3, unsubscriberequest.zzyp(), false);
        zzb.zza(parcel, 4, unsubscriberequest.zzaKh, i, false);
        zzb.zzc(parcel, 5, unsubscriberequest.zzaKi);
        zzb.zza(parcel, 6, unsubscriberequest.zzaCr, false);
        zzb.zza(parcel, 7, unsubscriberequest.zzaKe, false);
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzfG(parcel);
    }

    public Object[] newArray(int i)
    {
        return zziu(i);
    }

    public UnsubscribeRequest zzfG(Parcel parcel)
    {
        int i = 0;
        String s = null;
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        String s1 = null;
        PendingIntent pendingintent = null;
        android.os.IBinder ibinder = null;
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
                    ibinder = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, l);
                    break;

                case 4: // '\004'
                    pendingintent = (PendingIntent)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, PendingIntent.CREATOR);
                    break;

                case 5: // '\005'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 6: // '\006'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    break;

                case 7: // '\007'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new UnsubscribeRequest(j, ibinder1, ibinder, pendingintent, i, s1, s);
            }
        } while (true);
    }

    public UnsubscribeRequest[] zziu(int i)
    {
        return new UnsubscribeRequest[i];
    }
}
