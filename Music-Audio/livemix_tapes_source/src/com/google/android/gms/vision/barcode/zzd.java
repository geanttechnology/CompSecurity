// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd
    implements android.os.Parcelable.Creator
{

    public zzd()
    {
    }

    static void zza(Barcode.CalendarEvent calendarevent, Parcel parcel, int i)
    {
        int j = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, calendarevent.versionCode);
        zzb.zza(parcel, 2, calendarevent.summary, false);
        zzb.zza(parcel, 3, calendarevent.description, false);
        zzb.zza(parcel, 4, calendarevent.location, false);
        zzb.zza(parcel, 5, calendarevent.organizer, false);
        zzb.zza(parcel, 6, calendarevent.status, false);
        zzb.zza(parcel, 7, calendarevent.start, i, false);
        zzb.zza(parcel, 8, calendarevent.end, i, false);
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzgp(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzjt(i);
    }

    public Barcode.CalendarEvent zzgp(Parcel parcel)
    {
        Barcode.CalendarDateTime calendardatetime = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        Barcode.CalendarDateTime calendardatetime1 = null;
        String s = null;
        String s1 = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
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
                    s4 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 3: // '\003'
                    s3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 4: // '\004'
                    s2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 5: // '\005'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 6: // '\006'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 7: // '\007'
                    calendardatetime1 = (Barcode.CalendarDateTime)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, Barcode.CalendarDateTime.CREATOR);
                    break;

                case 8: // '\b'
                    calendardatetime = (Barcode.CalendarDateTime)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, Barcode.CalendarDateTime.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new Barcode.CalendarEvent(i, s4, s3, s2, s1, s, calendardatetime1, calendardatetime);
            }
        } while (true);
    }

    public Barcode.CalendarEvent[] zzjt(int i)
    {
        return new Barcode.CalendarEvent[i];
    }
}
