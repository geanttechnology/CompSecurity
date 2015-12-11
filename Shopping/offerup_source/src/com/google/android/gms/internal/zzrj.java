// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.wallet.CreateWalletObjectsRequest;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.firstparty.GetBuyFlowInitializationTokenRequest;
import com.google.android.gms.wallet.firstparty.GetInstrumentsRequest;
import com.google.android.gms.wallet.firstparty.InitializeBuyFlowRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zzrm, zzrl

public interface zzrj
    extends IInterface
{

    public abstract void zzC(Bundle bundle);

    public abstract void zzD(Bundle bundle);

    public abstract void zza(Bundle bundle, zzrm zzrm);

    public abstract void zza(CreateWalletObjectsRequest createwalletobjectsrequest, Bundle bundle, zzrm zzrm);

    public abstract void zza(FullWalletRequest fullwalletrequest, Bundle bundle, zzrm zzrm);

    public abstract void zza(MaskedWalletRequest maskedwalletrequest, Bundle bundle, zzrl zzrl);

    public abstract void zza(MaskedWalletRequest maskedwalletrequest, Bundle bundle, zzrm zzrm);

    public abstract void zza(NotifyTransactionStatusRequest notifytransactionstatusrequest, Bundle bundle);

    public abstract void zza(GetBuyFlowInitializationTokenRequest getbuyflowinitializationtokenrequest, Bundle bundle, zzrm zzrm);

    public abstract void zza(GetInstrumentsRequest getinstrumentsrequest, Bundle bundle, zzrm zzrm);

    public abstract void zza(InitializeBuyFlowRequest initializebuyflowrequest, Bundle bundle, zzrm zzrm);

    public abstract void zza(String s, String s1, Bundle bundle, zzrm zzrm);

    public abstract void zzb(Bundle bundle, zzrm zzrm);
}
