// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;

// Referenced classes of package com.google.android.gms.internal:
//            zzrh

public class zzrg
    implements Payments
{

    public zzrg()
    {
    }

    public void changeMaskedWallet(GoogleApiClient googleapiclient, String s, String s1, int i)
    {
        googleapiclient.zza(new com.google.android.gms.wallet.Wallet.zzb(googleapiclient, s, s1, i) {

            final int zzaAy;
            final zzrg zzaYm;
            final String zzaYp;
            final String zzaYq;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzrh)zzb);
            }

            protected void zza(zzrh zzrh1)
            {
                zzrh1.zze(zzaYp, zzaYq, zzaAy);
                zza(((com.google.android.gms.common.api.Result) (Status.zzaaD)));
            }

            
            {
                zzaYm = zzrg.this;
                zzaYp = s;
                zzaYq = s1;
                zzaAy = i;
                super(googleapiclient);
            }
        });
    }

    public void checkForPreAuthorization(GoogleApiClient googleapiclient, int i)
    {
        googleapiclient.zza(new com.google.android.gms.wallet.Wallet.zzb(googleapiclient, i) {

            final int zzaAy;
            final zzrg zzaYm;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzrh)zzb);
            }

            protected void zza(zzrh zzrh1)
            {
                zzrh1.zzki(zzaAy);
                zza(((com.google.android.gms.common.api.Result) (Status.zzaaD)));
            }

            
            {
                zzaYm = zzrg.this;
                zzaAy = i;
                super(googleapiclient);
            }
        });
    }

    public void isNewUser(GoogleApiClient googleapiclient, int i)
    {
        googleapiclient.zza(new com.google.android.gms.wallet.Wallet.zzb(googleapiclient, i) {

            final int zzaAy;
            final zzrg zzaYm;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzrh)zzb);
            }

            protected void zza(zzrh zzrh1)
            {
                zzrh1.zzkj(zzaAy);
                zza(((com.google.android.gms.common.api.Result) (Status.zzaaD)));
            }

            
            {
                zzaYm = zzrg.this;
                zzaAy = i;
                super(googleapiclient);
            }
        });
    }

    public void loadFullWallet(GoogleApiClient googleapiclient, FullWalletRequest fullwalletrequest, int i)
    {
        googleapiclient.zza(new com.google.android.gms.wallet.Wallet.zzb(googleapiclient, fullwalletrequest, i) {

            final int zzaAy;
            final zzrg zzaYm;
            final FullWalletRequest zzaYo;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzrh)zzb);
            }

            protected void zza(zzrh zzrh1)
            {
                zzrh1.zza(zzaYo, zzaAy);
                zza(((com.google.android.gms.common.api.Result) (Status.zzaaD)));
            }

            
            {
                zzaYm = zzrg.this;
                zzaYo = fullwalletrequest;
                zzaAy = i;
                super(googleapiclient);
            }
        });
    }

    public void loadMaskedWallet(GoogleApiClient googleapiclient, MaskedWalletRequest maskedwalletrequest, int i)
    {
        googleapiclient.zza(new com.google.android.gms.wallet.Wallet.zzb(googleapiclient, maskedwalletrequest, i) {

            final int zzaAy;
            final zzrg zzaYm;
            final MaskedWalletRequest zzaYn;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzrh)zzb);
            }

            protected void zza(zzrh zzrh1)
            {
                zzrh1.zza(zzaYn, zzaAy);
                zza(((com.google.android.gms.common.api.Result) (Status.zzaaD)));
            }

            
            {
                zzaYm = zzrg.this;
                zzaYn = maskedwalletrequest;
                zzaAy = i;
                super(googleapiclient);
            }
        });
    }

    public void notifyTransactionStatus(GoogleApiClient googleapiclient, NotifyTransactionStatusRequest notifytransactionstatusrequest)
    {
        googleapiclient.zza(new com.google.android.gms.wallet.Wallet.zzb(googleapiclient, notifytransactionstatusrequest) {

            final zzrg zzaYm;
            final NotifyTransactionStatusRequest zzaYr;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzrh)zzb);
            }

            protected void zza(zzrh zzrh1)
            {
                zzrh1.zza(zzaYr);
                zza(((com.google.android.gms.common.api.Result) (Status.zzaaD)));
            }

            
            {
                zzaYm = zzrg.this;
                zzaYr = notifytransactionstatusrequest;
                super(googleapiclient);
            }
        });
    }
}
