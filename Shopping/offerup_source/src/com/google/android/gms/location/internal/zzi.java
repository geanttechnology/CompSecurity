// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IInterface;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GestureRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.zzd;
import java.util.List;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzh, zzj, LocationRequestInternal, LocationRequestUpdateData

public interface zzi
    extends IInterface
{

    public abstract Status zza(GestureRequest gesturerequest, PendingIntent pendingintent);

    public abstract void zza(long l, boolean flag, PendingIntent pendingintent);

    public abstract void zza(PendingIntent pendingintent);

    public abstract void zza(PendingIntent pendingintent, zzh zzh, String s);

    public abstract void zza(Location location, int i);

    public abstract void zza(GeofencingRequest geofencingrequest, PendingIntent pendingintent, zzh zzh);

    public abstract void zza(LocationRequest locationrequest, PendingIntent pendingintent);

    public abstract void zza(LocationRequest locationrequest, zzd zzd1);

    public abstract void zza(LocationRequest locationrequest, zzd zzd1, String s);

    public abstract void zza(LocationSettingsRequest locationsettingsrequest, zzj zzj, String s);

    public abstract void zza(LocationRequestInternal locationrequestinternal, PendingIntent pendingintent);

    public abstract void zza(LocationRequestInternal locationrequestinternal, zzd zzd1);

    public abstract void zza(LocationRequestUpdateData locationrequestupdatedata);

    public abstract void zza(zzh zzh, String s);

    public abstract void zza(zzd zzd1);

    public abstract void zza(List list, PendingIntent pendingintent, zzh zzh, String s);

    public abstract void zza(String as[], zzh zzh, String s);

    public abstract void zzah(boolean flag);

    public abstract Status zzb(PendingIntent pendingintent);

    public abstract Status zzc(PendingIntent pendingintent);

    public abstract void zzc(Location location);

    public abstract Status zzd(PendingIntent pendingintent);

    public abstract ActivityRecognitionResult zzdu(String s);

    public abstract Location zzdv(String s);

    public abstract LocationAvailability zzdw(String s);

    public abstract void zze(PendingIntent pendingintent);

    public abstract Location zzwC();
}
