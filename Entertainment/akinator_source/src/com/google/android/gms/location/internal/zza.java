// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognitionApi;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzl

public class com.google.android.gms.location.internal.zza
    implements ActivityRecognitionApi
{
    private static abstract class zza extends com.google.android.gms.location.ActivityRecognition.zza
    {

        public Result zzb(Status status)
        {
            return zzd(status);
        }

        public Status zzd(Status status)
        {
            return status;
        }

        public zza(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }
    }


    public com.google.android.gms.location.internal.zza()
    {
    }

    public PendingResult removeActivityUpdates(GoogleApiClient googleapiclient, PendingIntent pendingintent)
    {
        return googleapiclient.zzb(new zza(googleapiclient, pendingintent) {

            final PendingIntent zzaEY;
            final com.google.android.gms.location.internal.zza zzaEZ;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzl)zzb);
            }

            protected void zza(zzl zzl1)
                throws RemoteException
            {
                zzl1.zza(zzaEY);
                zzb(Status.zzabb);
            }

            
            {
                zzaEZ = com.google.android.gms.location.internal.zza.this;
                zzaEY = pendingintent;
                super(googleapiclient);
            }
        });
    }

    public PendingResult requestActivityUpdates(GoogleApiClient googleapiclient, long l, PendingIntent pendingintent)
    {
        return googleapiclient.zzb(new zza(googleapiclient, l, pendingintent) {

            final long zzaEX;
            final PendingIntent zzaEY;
            final com.google.android.gms.location.internal.zza zzaEZ;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzl)zzb);
            }

            protected void zza(zzl zzl1)
                throws RemoteException
            {
                zzl1.zza(zzaEX, zzaEY);
                zzb(Status.zzabb);
            }

            
            {
                zzaEZ = com.google.android.gms.location.internal.zza.this;
                zzaEX = l;
                zzaEY = pendingintent;
                super(googleapiclient);
            }
        });
    }
}
