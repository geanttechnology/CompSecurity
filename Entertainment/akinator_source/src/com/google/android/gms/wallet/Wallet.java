// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzrq;
import com.google.android.gms.internal.zzrr;
import com.google.android.gms.wallet.firstparty.zza;
import com.google.android.gms.wallet.wobs.zzj;

// Referenced classes of package com.google.android.gms.wallet:
//            Payments, FullWalletRequest, MaskedWalletRequest, NotifyTransactionStatusRequest

public final class Wallet
{

    public static final Api API;
    public static final Payments Payments = new zzrn();
    private static final com.google.android.gms.common.api.Api.zzc zzRk;
    private static final com.google.android.gms.common.api.Api.zza zzRl;
    public static final zzj zzbdJ = new zzrr();
    public static final zza zzbdK = new zzrq();

    private Wallet()
    {
    }

    public static void changeMaskedWallet(GoogleApiClient googleapiclient, String s, String s1, int i)
    {
        Payments.changeMaskedWallet(googleapiclient, s, s1, i);
    }

    public static void checkForPreAuthorization(GoogleApiClient googleapiclient, int i)
    {
        Payments.checkForPreAuthorization(googleapiclient, i);
    }

    public static void loadFullWallet(GoogleApiClient googleapiclient, FullWalletRequest fullwalletrequest, int i)
    {
        Payments.loadFullWallet(googleapiclient, fullwalletrequest, i);
    }

    public static void loadMaskedWallet(GoogleApiClient googleapiclient, MaskedWalletRequest maskedwalletrequest, int i)
    {
        Payments.loadMaskedWallet(googleapiclient, maskedwalletrequest, i);
    }

    public static void notifyTransactionStatus(GoogleApiClient googleapiclient, NotifyTransactionStatusRequest notifytransactionstatusrequest)
    {
        Payments.notifyTransactionStatus(googleapiclient, notifytransactionstatusrequest);
    }

    static com.google.android.gms.common.api.Api.zzc zzEF()
    {
        return zzRk;
    }

    static 
    {
        zzRk = new com.google.android.gms.common.api.Api.zzc();
        zzRl = new _cls1();
        API = new Api("Wallet.API", zzRl, zzRk);
    }

    // Unreferenced inner class com/google/android/gms/wallet/Wallet$WalletOptions
    /* block-local class not found */
    class WalletOptions {}


    // Unreferenced inner class com/google/android/gms/wallet/Wallet$zza
    /* block-local class not found */
    class zza {}


    // Unreferenced inner class com/google/android/gms/wallet/Wallet$zzb
    /* block-local class not found */
    class zzb {}


    /* member class not found */
    class _cls1 {}

}
