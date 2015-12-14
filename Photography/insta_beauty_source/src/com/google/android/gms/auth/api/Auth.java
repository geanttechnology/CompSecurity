// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api;

import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.internal.zzc;
import com.google.android.gms.auth.api.proxy.zza;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzje;
import com.google.android.gms.internal.zzjf;
import com.google.android.gms.internal.zzjm;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzjp;

public final class Auth
{

    public static final com.google.android.gms.common.api.Api.ClientKey CLIENT_KEY_CREDENTIALS_API;
    public static final Api CREDENTIALS_API;
    public static final CredentialsApi CredentialsApi = new zzc();
    public static final com.google.android.gms.common.api.Api.ClientKey zzOE;
    public static final com.google.android.gms.common.api.Api.ClientKey zzOF;
    public static final com.google.android.gms.common.api.Api.ClientKey zzOG;
    private static final com.google.android.gms.common.api.Api.zza zzOH;
    private static final com.google.android.gms.common.api.Api.zza zzOI;
    private static final com.google.android.gms.common.api.Api.zza zzOJ;
    private static final com.google.android.gms.common.api.Api.zza zzOK;
    public static final Api zzOL;
    public static final Api zzOM;
    public static final Api zzON;
    public static final zza zzOO = new zzjm();
    public static final zzje zzOP = new zzjf();
    public static final zzjn zzOQ = new zzjp();

    private Auth()
    {
    }

    static 
    {
        zzOE = new com.google.android.gms.common.api.Api.ClientKey();
        CLIENT_KEY_CREDENTIALS_API = new com.google.android.gms.common.api.Api.ClientKey();
        zzOF = new com.google.android.gms.common.api.Api.ClientKey();
        zzOG = new com.google.android.gms.common.api.Api.ClientKey();
        zzOH = new _cls1();
        zzOI = new _cls2();
        zzOJ = new _cls3();
        zzOK = new _cls4();
        zzOL = new Api("Auth.PROXY_API", zzOH, zzOE, new Scope[0]);
        CREDENTIALS_API = new Api("Auth.CREDENTIALS_API", zzOI, CLIENT_KEY_CREDENTIALS_API, new Scope[0]);
        zzOM = new Api("Auth.SIGN_IN_API", zzOK, zzOG, new Scope[0]);
        zzON = new Api("Auth.ACCOUNT_STATUS_API", zzOJ, zzOF, new Scope[0]);
    }

    private class _cls1
        implements com.google.android.gms.common.api.Api.zza
    {

        public int getPriority()
        {
            return 0x7fffffff;
        }

        public volatile com.google.android.gms.common.api.Api.Client zza(Context context, Looper looper, zze zze, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return zza(context, looper, zze, (zza)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public zzjj zza(Context context, Looper looper, zze zze, zza zza1, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return new zzjj(context, looper, zze, zza1, connectioncallbacks, onconnectionfailedlistener);
        }

        _cls1()
        {
        }

        private class zza
            implements com.google.android.gms.common.api.Api.ApiOptions.Optional
        {

            private final Bundle zzOR;

            public Bundle zzkY()
            {
                return new Bundle(zzOR);
            }
        }

    }


    private class _cls2
        implements com.google.android.gms.common.api.Api.zza
    {

        public int getPriority()
        {
            return 0x7fffffff;
        }

        public com.google.android.gms.common.api.Api.Client zza(Context context, Looper looper, zze zze, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return zzd(context, looper, zze, (com.google.android.gms.common.api.Api.ApiOptions.NoOptions)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public CredentialsClientImpl zzd(Context context, Looper looper, zze zze, com.google.android.gms.common.api.Api.ApiOptions.NoOptions nooptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return new CredentialsClientImpl(context, looper, connectioncallbacks, onconnectionfailedlistener);
        }

        _cls2()
        {
        }
    }


    private class _cls3
        implements com.google.android.gms.common.api.Api.zza
    {

        public int getPriority()
        {
            return 0x7fffffff;
        }

        public com.google.android.gms.common.api.Api.Client zza(Context context, Looper looper, zze zze1, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return zze(context, looper, zze1, (com.google.android.gms.common.api.Api.ApiOptions.NoOptions)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public zzjg zze(Context context, Looper looper, zze zze1, com.google.android.gms.common.api.Api.ApiOptions.NoOptions nooptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return new zzjg(context, looper, zze1, connectioncallbacks, onconnectionfailedlistener);
        }

        _cls3()
        {
        }
    }


    private class _cls4
        implements com.google.android.gms.common.api.Api.zza
    {

        public int getPriority()
        {
            return 0x7fffffff;
        }

        public com.google.android.gms.common.api.Api.Client zza(Context context, Looper looper, zze zze, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return zzf(context, looper, zze, (com.google.android.gms.common.api.Api.ApiOptions.NoOptions)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public zzjq zzf(Context context, Looper looper, zze zze, com.google.android.gms.common.api.Api.ApiOptions.NoOptions nooptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return new zzjq(context, looper, connectioncallbacks, onconnectionfailedlistener);
        }

        _cls4()
        {
        }
    }

}
