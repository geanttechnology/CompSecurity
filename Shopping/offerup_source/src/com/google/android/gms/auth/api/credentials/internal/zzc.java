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

    public final PendingResult delete(GoogleApiClient googleapiclient, Credential credential)
    {
        return googleapiclient.zzb(new _cls3(googleapiclient, credential));
    }

    public final PendingResult disableAutoSignIn(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zzb(new _cls4(googleapiclient));
    }

    public final PendingResult request(GoogleApiClient googleapiclient, CredentialRequest credentialrequest)
    {
        return googleapiclient.zza(new _cls1(googleapiclient, credentialrequest));
    }

    public final PendingResult save(GoogleApiClient googleapiclient, Credential credential)
    {
        return googleapiclient.zzb(new _cls2(googleapiclient, credential));
    }

    private class _cls3 extends zzd
    {

        final zzc zzSF;
        final Credential zzSH;

        protected void zza(Context context, zzh zzh1)
        {
            zzh1.zza(new zza(this), new DeleteRequest(zzSH));
        }

        protected Result zzb(Status status)
        {
            return zzd(status);
        }

        protected Status zzd(Status status)
        {
            return status;
        }

        _cls3(GoogleApiClient googleapiclient, Credential credential)
        {
            zzSF = zzc.this;
            zzSH = credential;
            super(googleapiclient);
        }

        private class zza extends com.google.android.gms.auth.api.credentials.internal.zza
        {

            private com.google.android.gms.internal.zzlb.zzb zzSI;

            public void zzg(Status status)
            {
                zzSI.zzp(status);
            }

            zza(com.google.android.gms.internal.zzlb.zzb zzb1)
            {
                zzSI = zzb1;
            }
        }

    }


    private class _cls4 extends zzd
    {

        final zzc zzSF;

        protected void zza(Context context, zzh zzh1)
        {
            zzh1.zza(new zza(this));
        }

        protected Result zzb(Status status)
        {
            return zzd(status);
        }

        protected Status zzd(Status status)
        {
            return status;
        }

        _cls4(GoogleApiClient googleapiclient)
        {
            zzSF = zzc.this;
            super(googleapiclient);
        }
    }


    private class _cls1 extends zzd
    {

        final CredentialRequest zzSE;
        final zzc zzSF;

        protected void zza(Context context, zzh zzh1)
        {
            class _cls1 extends com.google.android.gms.auth.api.credentials.internal.zza
            {

                final _cls1 zzSG;

                public void zza(Status status, Credential credential)
                {
                    zzSG.zzb(new zzb(status, credential));
                }

                public void zzg(Status status)
                {
                    zzSG.zzb(com.google.android.gms.auth.api.credentials.internal.zzb.zzh(status));
                }

                _cls1()
                {
                    zzSG = _cls1.this;
                    super();
                }
            }

            zzh1.zza(new _cls1(), zzSE);
        }

        protected Result zzb(Status status)
        {
            return zzi(status);
        }

        protected CredentialRequestResult zzi(Status status)
        {
            return com.google.android.gms.auth.api.credentials.internal.zzb.zzh(status);
        }

        _cls1(GoogleApiClient googleapiclient, CredentialRequest credentialrequest)
        {
            zzSF = zzc.this;
            zzSE = credentialrequest;
            super(googleapiclient);
        }
    }


    private class _cls2 extends zzd
    {

        final zzc zzSF;
        final Credential zzSH;

        protected void zza(Context context, zzh zzh1)
        {
            zzh1.zza(new zza(this), new SaveRequest(zzSH));
        }

        protected Result zzb(Status status)
        {
            return zzd(status);
        }

        protected Status zzd(Status status)
        {
            return status;
        }

        _cls2(GoogleApiClient googleapiclient, Credential credential)
        {
            zzSF = zzc.this;
            zzSH = credential;
            super(googleapiclient);
        }
    }

}
