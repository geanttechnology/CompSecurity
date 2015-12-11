// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api;

import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.internal.zzc;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.internal.zza;
import com.google.android.gms.auth.api.signin.internal.zzf;
import com.google.android.gms.auth.api.signin.zzd;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.zzjz;
import com.google.android.gms.internal.zzka;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzkm;

public final class Auth
{

    public static final Api CREDENTIALS_API;
    public static final CredentialsApi CredentialsApi = new zzc();
    public static final Api PROXY_API;
    public static final ProxyApi ProxyApi = new zzkm();
    public static final com.google.android.gms.common.api.Api.zzc zzRE;
    public static final com.google.android.gms.common.api.Api.zzc zzRF;
    public static final com.google.android.gms.common.api.Api.zzc zzRG;
    public static final com.google.android.gms.common.api.Api.zzc zzRH;
    public static final com.google.android.gms.common.api.Api.zzc zzRI;
    public static final com.google.android.gms.common.api.Api.zzc zzRJ;
    private static final com.google.android.gms.common.api.Api.zza zzRK;
    private static final com.google.android.gms.common.api.Api.zza zzRL;
    private static final com.google.android.gms.common.api.Api.zza zzRM;
    private static final com.google.android.gms.common.api.Api.zza zzRN;
    private static final com.google.android.gms.common.api.Api.zza zzRO;
    private static final com.google.android.gms.common.api.Api.zza zzRP;
    public static final Api zzRQ;
    public static final Api zzRR;
    public static final Api zzRS;
    public static final Api zzRT;
    public static final zzjz zzRU = new zzka();
    public static final com.google.android.gms.auth.api.signin.zzf zzRV = new zzf();
    public static final zzd zzRW = new zza();
    public static final com.google.android.gms.auth.api.consent.zza zzRX = new zzke();

    private Auth()
    {
    }

    static 
    {
        zzRE = new com.google.android.gms.common.api.Api.zzc();
        zzRF = new com.google.android.gms.common.api.Api.zzc();
        zzRG = new com.google.android.gms.common.api.Api.zzc();
        zzRH = new com.google.android.gms.common.api.Api.zzc();
        zzRI = new com.google.android.gms.common.api.Api.zzc();
        zzRJ = new com.google.android.gms.common.api.Api.zzc();
        zzRK = new _cls1();
        zzRL = new _cls2();
        zzRM = new _cls3();
        zzRN = new _cls4();
        zzRO = new _cls5();
        zzRP = new _cls6();
        PROXY_API = new Api("Auth.PROXY_API", zzRK, zzRE);
        CREDENTIALS_API = new Api("Auth.CREDENTIALS_API", zzRL, zzRF);
        zzRQ = new Api("Auth.SIGN_IN_API", zzRO, zzRH);
        zzRR = new Api("Auth.GOOGLE_SIGN_IN_API", zzRP, zzRI);
        zzRS = new Api("Auth.ACCOUNT_STATUS_API", zzRM, zzRG);
        zzRT = new Api("Auth.CONSENT_API", zzRN, zzRJ);
    }

    private class _cls1 extends com.google.android.gms.common.api.Api.zza
    {

        public final volatile com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf1, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return zza(context, looper, zzf1, (zza)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public final zzki zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf1, zza zza1, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return new zzki(context, looper, zzf1, zza1, connectioncallbacks, onconnectionfailedlistener);
        }

        _cls1()
        {
        }

        private class zza
            implements com.google.android.gms.common.api.Api.ApiOptions.Optional
        {

            private final Bundle zzSa;

            public final Bundle zzlE()
            {
                return new Bundle(zzSa);
            }
        }

    }


    private class _cls2 extends com.google.android.gms.common.api.Api.zza
    {

        public final zze zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf1, AuthCredentialsOptions authcredentialsoptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return new zze(context, looper, zzf1, authcredentialsoptions, connectioncallbacks, onconnectionfailedlistener);
        }

        public final volatile com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf1, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return zza(context, looper, zzf1, (AuthCredentialsOptions)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        _cls2()
        {
        }

        private class AuthCredentialsOptions
            implements com.google.android.gms.common.api.Api.ApiOptions.Optional
        {

            private final String zzRY;
            private final PasswordSpecification zzRZ;

            public final Bundle zzly()
            {
                Bundle bundle = new Bundle();
                bundle.putString("consumer_package", zzRY);
                bundle.putParcelable("password_specification", zzRZ);
                return bundle;
            }
        }

    }


    private class _cls3 extends com.google.android.gms.common.api.Api.zza
    {

        public final com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf1, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return zzc(context, looper, zzf1, (com.google.android.gms.common.api.Api.ApiOptions.NoOptions)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public final zzkb zzc(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf1, com.google.android.gms.common.api.Api.ApiOptions.NoOptions nooptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return new zzkb(context, looper, zzf1, connectioncallbacks, onconnectionfailedlistener);
        }

        _cls3()
        {
        }
    }


    private class _cls4 extends com.google.android.gms.common.api.Api.zza
    {

        public final com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf1, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return zzd(context, looper, zzf1, (com.google.android.gms.common.api.Api.ApiOptions.NoOptions)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public final zzkf zzd(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf1, com.google.android.gms.common.api.Api.ApiOptions.NoOptions nooptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return new zzkf(context, looper, zzf1, connectioncallbacks, onconnectionfailedlistener);
        }

        _cls4()
        {
        }
    }


    private class _cls5 extends com.google.android.gms.common.api.Api.zza
    {

        public final zzg zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf1, com.google.android.gms.auth.api.signin.zzg zzg1, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return new zzg(context, looper, zzf1, zzg1, connectioncallbacks, onconnectionfailedlistener);
        }

        public final volatile com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf1, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return zza(context, looper, zzf1, (com.google.android.gms.auth.api.signin.zzg)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        _cls5()
        {
        }
    }


    private class _cls6 extends com.google.android.gms.common.api.Api.zza
    {

        public final zzb zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf1, GoogleSignInConfig googlesigninconfig, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return new zzb(context, looper, zzf1, googlesigninconfig, connectioncallbacks, onconnectionfailedlistener);
        }

        public final volatile com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf1, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return zza(context, looper, zzf1, (GoogleSignInConfig)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        _cls6()
        {
        }
    }

}
