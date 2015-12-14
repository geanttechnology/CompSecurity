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
import com.google.android.gms.drive.internal.zzab;
import com.google.android.gms.drive.internal.zzr;
import com.google.android.gms.drive.internal.zzt;
import com.google.android.gms.drive.internal.zzw;
import com.google.android.gms.drive.internal.zzz;

// Referenced classes of package com.google.android.gms.drive:
//            DriveApi, DrivePreferencesApi, zzc, zzf

public final class Drive
{
    public static abstract class zza extends com.google.android.gms.common.api.Api.zza
    {

        protected abstract Bundle zza(com.google.android.gms.common.api.Api.ApiOptions apioptions);

        public volatile com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf zzf, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return zza(context, looper, zzf, (com.google.android.gms.common.api.Api.ApiOptions)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public zzt zza(Context context, Looper looper, zzf zzf, com.google.android.gms.common.api.Api.ApiOptions apioptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return new zzt(context, looper, zzf, connectioncallbacks, onconnectionfailedlistener, zza(apioptions));
        }

        public zza()
        {
        }
    }

    public static class zzb
        implements com.google.android.gms.common.api.Api.ApiOptions.Optional
    {

        private final Bundle zzQe;

        public Bundle zzqg()
        {
            return zzQe;
        }

        private zzb()
        {
            this(new Bundle());
        }

        private zzb(Bundle bundle)
        {
            zzQe = bundle;
        }
    }


    public static final Api API;
    public static final DriveApi DriveApi = new zzr();
    public static final DrivePreferencesApi DrivePreferencesApi = new zzz();
    public static final Scope SCOPE_APPFOLDER = new Scope("https://www.googleapis.com/auth/drive.appdata");
    public static final Scope SCOPE_FILE = new Scope("https://www.googleapis.com/auth/drive.file");
    public static final com.google.android.gms.common.api.Api.zzc zzQf;
    public static final zzc zzagA = new zzw();
    public static final com.google.android.gms.drive.zzf zzagB = new zzab();
    public static final Scope zzagx = new Scope("https://www.googleapis.com/auth/drive");
    public static final Scope zzagy = new Scope("https://www.googleapis.com/auth/drive.apps");
    public static final Api zzagz;

    private Drive()
    {
    }

    static 
    {
        zzQf = new com.google.android.gms.common.api.Api.zzc();
        API = new Api("Drive.API", new zza() {

            protected Bundle zza(com.google.android.gms.common.api.Api.ApiOptions apioptions)
            {
                return zzb((com.google.android.gms.common.api.Api.ApiOptions.NoOptions)apioptions);
            }

            protected Bundle zzb(com.google.android.gms.common.api.Api.ApiOptions.NoOptions nooptions)
            {
                return new Bundle();
            }

        }, zzQf);
        zzagz = new Api("Drive.INTERNAL_API", new zza() {

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
                    return zzb1.zzqg();
                }
            }

        }, zzQf);
    }
}
