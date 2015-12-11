// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.drive.internal.zzaa;
import com.google.android.gms.drive.internal.zzac;
import com.google.android.gms.drive.internal.zzs;
import com.google.android.gms.drive.internal.zzu;
import com.google.android.gms.drive.internal.zzx;

// Referenced classes of package com.google.android.gms.drive:
//            DriveApi, DrivePreferencesApi, zzd, zzg

public final class Drive
{
    public static abstract class zza extends com.google.android.gms.common.api.Api.zza
    {

        protected abstract Bundle zza(com.google.android.gms.common.api.Api.ApiOptions apioptions);

        public volatile com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf zzf, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return zza(context, looper, zzf, (com.google.android.gms.common.api.Api.ApiOptions)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public zzu zza(Context context, Looper looper, zzf zzf, com.google.android.gms.common.api.Api.ApiOptions apioptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return new zzu(context, looper, zzf, connectioncallbacks, onconnectionfailedlistener, zza(apioptions));
        }

        public zza()
        {
        }
    }

    public static class zzb
        implements com.google.android.gms.common.api.Api.ApiOptions.Optional
    {

        private final Bundle zzRj;

        public Bundle zzqN()
        {
            return zzRj;
        }
    }


    public static final Api API;
    public static final DriveApi DriveApi = new zzs();
    public static final DrivePreferencesApi DrivePreferencesApi = new zzaa();
    public static final Scope SCOPE_APPFOLDER = new Scope("https://www.googleapis.com/auth/drive.appdata");
    public static final Scope SCOPE_FILE = new Scope("https://www.googleapis.com/auth/drive.file");
    public static final com.google.android.gms.common.api.Api.zzc zzRk;
    public static final Scope zzaiF = new Scope("https://www.googleapis.com/auth/drive");
    public static final Scope zzaiG = new Scope("https://www.googleapis.com/auth/drive.apps");
    public static final Api zzaiH;
    public static final zzd zzaiI = new zzx();
    public static final zzg zzaiJ = new zzac();

    private Drive()
    {
    }

    static 
    {
        zzRk = new com.google.android.gms.common.api.Api.zzc();
        API = new Api("Drive.API", new zza() {

            protected Bundle zza(com.google.android.gms.common.api.Api.ApiOptions.NoOptions nooptions)
            {
                return new Bundle();
            }

            protected volatile Bundle zza(com.google.android.gms.common.api.Api.ApiOptions apioptions)
            {
                return zza((com.google.android.gms.common.api.Api.ApiOptions.NoOptions)apioptions);
            }

        }, zzRk);
        zzaiH = new Api("Drive.INTERNAL_API", new zza() {

            protected volatile Bundle zza(com.google.android.gms.common.api.Api.ApiOptions apioptions)
            {
                return zza((zzb)apioptions);
            }

            protected Bundle zza(zzb zzb1)
            {
                if (zzb1 == null)
                {
                    return new Bundle();
                } else
                {
                    return zzb1.zzqN();
                }
            }

        }, zzRk);
    }
}
