// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.credentials.internal;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

public final class zzc
    implements CredentialsApi
{

    public zzc()
    {
    }

    public PendingResult delete(GoogleApiClient googleapiclient, Credential credential)
    {
        return googleapiclient.zzb(new _cls3(googleapiclient, credential));
    }

    public PendingResult disableAutoSignIn(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zzb(new _cls4(googleapiclient));
    }

    public PendingResult request(GoogleApiClient googleapiclient, CredentialRequest credentialrequest)
    {
        return googleapiclient.zza(new _cls1(googleapiclient, credentialrequest));
    }

    public PendingResult save(GoogleApiClient googleapiclient, Credential credential)
    {
        return googleapiclient.zzb(new _cls2(googleapiclient, credential));
    }

    private class _cls3 extends zzd
    {

        final zzc zzPd;
        final Credential zzPf;

        protected Result createFailedResult(Status status)
        {
            return zzb(status);
        }

        protected void zza(Context context, ICredentialsService icredentialsservice)
        {
            icredentialsservice.performCredentialsDeleteOperation(new zza(this), new DeleteRequest(zzPf));
        }

        protected Status zzb(Status status)
        {
            return status;
        }

        _cls3(GoogleApiClient googleapiclient, Credential credential)
        {
            zzPd = zzc.this;
            zzPf = credential;
            super(googleapiclient);
        }

        private class zza extends com.google.android.gms.auth.api.credentials.internal.zza
        {

            private com.google.android.gms.common.api.zza.zzb zzPg;

            public void onStatusResult(Status status)
            {
                zzPg.zzm(status);
            }

            zza(com.google.android.gms.common.api.zza.zzb zzb1)
            {
                zzPg = zzb1;
            }
        }

    }


    private class _cls4 extends zzd
    {

        final zzc zzPd;

        protected Result createFailedResult(Status status)
        {
            return zzb(status);
        }

        protected void zza(Context context, ICredentialsService icredentialsservice)
        {
            icredentialsservice.performDisableAutoSignInOperation(new zza(this));
        }

        protected Status zzb(Status status)
        {
            return status;
        }

        _cls4(GoogleApiClient googleapiclient)
        {
            zzPd = zzc.this;
            super(googleapiclient);
        }
    }


    private class _cls1 extends zzd
    {

        final CredentialRequest zzPc;
        final zzc zzPd;

        protected Result createFailedResult(Status status)
        {
            return zzk(status);
        }

        protected void zza(Context context, ICredentialsService icredentialsservice)
        {
            class _cls1 extends com.google.android.gms.auth.api.credentials.internal.zza
            {

                final _cls1 zzPe;

                public void onCredentialResult(Status status, Credential credential)
                {
                    zzPe.setResult(new zzb(status, credential));
                }

                _cls1()
                {
                    zzPe = _cls1.this;
                    super();
                }
            }

            icredentialsservice.performCredentialsRequestOperation(new _cls1(), zzPc);
        }

        protected CredentialRequestResult zzk(Status status)
        {
            return zzb.zzj(status);
        }

        _cls1(GoogleApiClient googleapiclient, CredentialRequest credentialrequest)
        {
            zzPd = zzc.this;
            zzPc = credentialrequest;
            super(googleapiclient);
        }
    }


    private class _cls2 extends zzd
    {

        final zzc zzPd;
        final Credential zzPf;

        protected Result createFailedResult(Status status)
        {
            return zzb(status);
        }

        protected void zza(Context context, ICredentialsService icredentialsservice)
        {
            icredentialsservice.performCredentialsSaveOperation(new zza(this), new SaveRequest(zzPf));
        }

        protected Status zzb(Status status)
        {
            return status;
        }

        _cls2(GoogleApiClient googleapiclient, Credential credential)
        {
            zzPd = zzc.this;
            zzPf = credential;
            super(googleapiclient);
        }
    }

}
