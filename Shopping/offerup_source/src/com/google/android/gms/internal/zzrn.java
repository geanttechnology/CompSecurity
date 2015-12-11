// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;

public class zzrn
    implements Payments
{

    public zzrn()
    {
    }

    public void changeMaskedWallet(GoogleApiClient googleapiclient, String s, String s1, int i)
    {
        googleapiclient.zza(new _cls4(googleapiclient, s, s1, i));
    }

    public void checkForPreAuthorization(GoogleApiClient googleapiclient, int i)
    {
        googleapiclient.zza(new _cls1(googleapiclient, i));
    }

    public void isNewUser(GoogleApiClient googleapiclient, int i)
    {
        googleapiclient.zza(new _cls6(googleapiclient, i));
    }

    public void loadFullWallet(GoogleApiClient googleapiclient, FullWalletRequest fullwalletrequest, int i)
    {
        googleapiclient.zza(new _cls3(googleapiclient, fullwalletrequest, i));
    }

    public void loadMaskedWallet(GoogleApiClient googleapiclient, MaskedWalletRequest maskedwalletrequest, int i)
    {
        googleapiclient.zza(new _cls2(googleapiclient, maskedwalletrequest, i));
    }

    public void notifyTransactionStatus(GoogleApiClient googleapiclient, NotifyTransactionStatusRequest notifytransactionstatusrequest)
    {
        googleapiclient.zza(new _cls5(googleapiclient, notifytransactionstatusrequest));
    }

    private class _cls4 extends com.google.android.gms.wallet.Wallet.zzb
    {

        final int zzaDg;
        final zzrn zzbeu;
        final String zzbex;
        final String zzbey;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
        {
            zza((zzro)zzb);
        }

        protected void zza(zzro zzro1)
        {
            zzro1.zze(zzbex, zzbey, zzaDg);
            zzb(Status.zzabb);
        }

        _cls4(GoogleApiClient googleapiclient, String s, String s1, int i)
        {
            zzbeu = zzrn.this;
            zzbex = s;
            zzbey = s1;
            zzaDg = i;
            super(googleapiclient);
        }
    }


    private class _cls1 extends com.google.android.gms.wallet.Wallet.zzb
    {

        final int zzaDg;
        final zzrn zzbeu;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
        {
            zza((zzro)zzb);
        }

        protected void zza(zzro zzro1)
        {
            zzro1.zzkz(zzaDg);
            zzb(Status.zzabb);
        }

        _cls1(GoogleApiClient googleapiclient, int i)
        {
            zzbeu = zzrn.this;
            zzaDg = i;
            super(googleapiclient);
        }
    }


    private class _cls6 extends com.google.android.gms.wallet.Wallet.zzb
    {

        final int zzaDg;
        final zzrn zzbeu;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
        {
            zza((zzro)zzb);
        }

        protected void zza(zzro zzro1)
        {
            zzro1.zzkA(zzaDg);
            zzb(Status.zzabb);
        }

        _cls6(GoogleApiClient googleapiclient, int i)
        {
            zzbeu = zzrn.this;
            zzaDg = i;
            super(googleapiclient);
        }
    }


    private class _cls3 extends com.google.android.gms.wallet.Wallet.zzb
    {

        final int zzaDg;
        final zzrn zzbeu;
        final FullWalletRequest zzbew;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
        {
            zza((zzro)zzb);
        }

        protected void zza(zzro zzro1)
        {
            zzro1.zza(zzbew, zzaDg);
            zzb(Status.zzabb);
        }

        _cls3(GoogleApiClient googleapiclient, FullWalletRequest fullwalletrequest, int i)
        {
            zzbeu = zzrn.this;
            zzbew = fullwalletrequest;
            zzaDg = i;
            super(googleapiclient);
        }
    }


    private class _cls2 extends com.google.android.gms.wallet.Wallet.zzb
    {

        final int zzaDg;
        final zzrn zzbeu;
        final MaskedWalletRequest zzbev;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
        {
            zza((zzro)zzb);
        }

        protected void zza(zzro zzro1)
        {
            zzro1.zza(zzbev, zzaDg);
            zzb(Status.zzabb);
        }

        _cls2(GoogleApiClient googleapiclient, MaskedWalletRequest maskedwalletrequest, int i)
        {
            zzbeu = zzrn.this;
            zzbev = maskedwalletrequest;
            zzaDg = i;
            super(googleapiclient);
        }
    }


    private class _cls5 extends com.google.android.gms.wallet.Wallet.zzb
    {

        final zzrn zzbeu;
        final NotifyTransactionStatusRequest zzbez;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
        {
            zza((zzro)zzb);
        }

        protected void zza(zzro zzro1)
        {
            zzro1.zza(zzbez);
            zzb(Status.zzabb);
        }

        _cls5(GoogleApiClient googleapiclient, NotifyTransactionStatusRequest notifytransactionstatusrequest)
        {
            zzbeu = zzrn.this;
            zzbez = notifytransactionstatusrequest;
            super(googleapiclient);
        }
    }

}
