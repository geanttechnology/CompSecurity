// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationRequest;

// Referenced classes of package com.google.android.gms.fitness.request:
//            SensorRegistrationRequest

public class zzs
    implements android.os.Parcelable.Creator
{

    public zzs()
    {
    }

    static void zza(SensorRegistrationRequest sensorregistrationrequest, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, sensorregistrationrequest.getDataSource(), i, false);
        zzb.zzc(parcel, 1000, sensorregistrationrequest.getVersionCode());
        zzb.zza(parcel, 2, sensorregistrationrequest.getDataType(), i, false);
        zzb.zza(parcel, 3, sensorregistrationrequest.zztf(), false);
        zzb.zzc(parcel, 4, sensorregistrationrequest.zzasG);
        zzb.zzc(parcel, 5, sensorregistrationrequest.zzasH);
        zzb.zza(parcel, 6, sensorregistrationrequest.zzsB());
        zzb.zza(parcel, 7, sensorregistrationrequest.zztc());
        zzb.zza(parcel, 8, sensorregistrationrequest.zzta(), i, false);
        zzb.zza(parcel, 9, sensorregistrationrequest.zztb());
        zzb.zzc(parcel, 10, sensorregistrationrequest.getAccuracyMode());
        zzb.zzc(parcel, 11, sensorregistrationrequest.zztd(), false);
        zzb.zza(parcel, 12, sensorregistrationrequest.zzte());
        zzb.zza(parcel, 13, sensorregistrationrequest.zzsO(), false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzdn(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzfe(i);
    }

    public SensorRegistrationRequest zzdn(Parcel parcel)
    {
        int i1 = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int l = 0;
        DataSource datasource = null;
        DataType datatype = null;
        android.os.IBinder ibinder1 = null;
        int k = 0;
        int j = 0;
        long l4 = 0L;
        long l3 = 0L;
        PendingIntent pendingintent = null;
        long l2 = 0L;
        int i = 0;
        java.util.ArrayList arraylist = null;
        long l1 = 0L;
        android.os.IBinder ibinder = null;
        do
        {
            if (parcel.dataPosition() < i1)
            {
                int j1 = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(j1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, j1);
                    break;

                case 1: // '\001'
                    datasource = (DataSource)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, j1, DataSource.CREATOR);
                    break;

                case 1000: 
                    l = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, j1);
                    break;

                case 2: // '\002'
                    datatype = (DataType)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, j1, DataType.CREATOR);
                    break;

                case 3: // '\003'
                    ibinder1 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, j1);
                    break;

                case 4: // '\004'
                    k = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, j1);
                    break;

                case 5: // '\005'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, j1);
                    break;

                case 6: // '\006'
                    l4 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, j1);
                    break;

                case 7: // '\007'
                    l3 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, j1);
                    break;

                case 8: // '\b'
                    pendingintent = (PendingIntent)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, j1, PendingIntent.CREATOR);
                    break;

                case 9: // '\t'
                    l2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, j1);
                    break;

                case 10: // '\n'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, j1);
                    break;

                case 11: // '\013'
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, j1, LocationRequest.CREATOR);
                    break;

                case 12: // '\f'
                    l1 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, j1);
                    break;

                case 13: // '\r'
                    ibinder = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, j1);
                    break;
                }
            } else
            if (parcel.dataPosition() != i1)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(i1).toString(), parcel);
            } else
            {
                return new SensorRegistrationRequest(l, datasource, datatype, ibinder1, k, j, l4, l3, pendingintent, l2, i, arraylist, l1, ibinder);
            }
        } while (true);
    }

    public SensorRegistrationRequest[] zzfe(int i)
    {
        return new SensorRegistrationRequest[i];
    }
}
