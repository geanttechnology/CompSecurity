// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.zzc;
import com.google.android.gms.location.zzd;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzn, zzg, LocationRequestInternal

public class LocationRequestUpdateData
    implements SafeParcelable
{

    public static final zzn CREATOR = new zzn();
    PendingIntent mPendingIntent;
    private final int mVersionCode;
    int zzaFJ;
    LocationRequestInternal zzaFK;
    zzd zzaFL;
    zzc zzaFM;
    zzg zzaFN;

    LocationRequestUpdateData(int i, int j, LocationRequestInternal locationrequestinternal, IBinder ibinder, PendingIntent pendingintent, IBinder ibinder1, IBinder ibinder2)
    {
        Object obj = null;
        super();
        mVersionCode = i;
        zzaFJ = j;
        zzaFK = locationrequestinternal;
        if (ibinder == null)
        {
            locationrequestinternal = null;
        } else
        {
            locationrequestinternal = com.google.android.gms.location.zzd.zza.zzbX(ibinder);
        }
        zzaFL = locationrequestinternal;
        mPendingIntent = pendingintent;
        if (ibinder1 == null)
        {
            locationrequestinternal = null;
        } else
        {
            locationrequestinternal = com.google.android.gms.location.zzc.zza.zzbW(ibinder1);
        }
        zzaFM = locationrequestinternal;
        if (ibinder2 == null)
        {
            locationrequestinternal = obj;
        } else
        {
            locationrequestinternal = zzg.zza.zzbZ(ibinder2);
        }
        zzaFN = locationrequestinternal;
    }

    public static LocationRequestUpdateData zza(LocationRequestInternal locationrequestinternal, PendingIntent pendingintent, zzg zzg1)
    {
        if (zzg1 != null)
        {
            zzg1 = zzg1.asBinder();
        } else
        {
            zzg1 = null;
        }
        return new LocationRequestUpdateData(1, 1, locationrequestinternal, null, pendingintent, null, zzg1);
    }

    public static LocationRequestUpdateData zza(LocationRequestInternal locationrequestinternal, zzc zzc1, zzg zzg1)
    {
        IBinder ibinder = zzc1.asBinder();
        if (zzg1 != null)
        {
            zzc1 = zzg1.asBinder();
        } else
        {
            zzc1 = null;
        }
        return new LocationRequestUpdateData(1, 1, locationrequestinternal, null, null, ibinder, zzc1);
    }

    public static LocationRequestUpdateData zza(LocationRequestInternal locationrequestinternal, zzd zzd1, zzg zzg1)
    {
        IBinder ibinder = zzd1.asBinder();
        if (zzg1 != null)
        {
            zzd1 = zzg1.asBinder();
        } else
        {
            zzd1 = null;
        }
        return new LocationRequestUpdateData(1, 1, locationrequestinternal, ibinder, null, null, zzd1);
    }

    public static LocationRequestUpdateData zza(zzc zzc1, zzg zzg1)
    {
        IBinder ibinder = zzc1.asBinder();
        if (zzg1 != null)
        {
            zzc1 = zzg1.asBinder();
        } else
        {
            zzc1 = null;
        }
        return new LocationRequestUpdateData(1, 2, null, null, null, ibinder, zzc1);
    }

    public static LocationRequestUpdateData zza(zzd zzd1, zzg zzg1)
    {
        IBinder ibinder = zzd1.asBinder();
        if (zzg1 != null)
        {
            zzd1 = zzg1.asBinder();
        } else
        {
            zzd1 = null;
        }
        return new LocationRequestUpdateData(1, 2, null, ibinder, null, null, zzd1);
    }

    public static LocationRequestUpdateData zzb(PendingIntent pendingintent, zzg zzg1)
    {
        if (zzg1 != null)
        {
            zzg1 = zzg1.asBinder();
        } else
        {
            zzg1 = null;
        }
        return new LocationRequestUpdateData(1, 2, null, null, pendingintent, null, zzg1);
    }

    public int describeContents()
    {
        return 0;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzn.zza(this, parcel, i);
    }

    IBinder zzwF()
    {
        if (zzaFL == null)
        {
            return null;
        } else
        {
            return zzaFL.asBinder();
        }
    }

    IBinder zzwG()
    {
        if (zzaFM == null)
        {
            return null;
        } else
        {
            return zzaFM.asBinder();
        }
    }

    IBinder zzwH()
    {
        if (zzaFN == null)
        {
            return null;
        } else
        {
            return zzaFN.asBinder();
        }
    }

}
